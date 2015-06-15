package com.conecta.web.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.BindingProvider;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.conecta.service.IPagoService;
import com.conecta.util.TxCounter;
import com.diestel.ws.ArrayOfCCampo;
import com.diestel.ws.CCampo;
import com.diestel.ws.ETipo;
import com.domain.entities.Pagos;

@RestController
@RequestMapping("/api/info-pago")
public class InfoPagoController {

	@Resource
	private IPagoService pagoService;

	@Resource
	private TxCounter txCounter;

	Calendar calFecha = GregorianCalendar.getInstance();

	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public @ResponseBody ArrayOfCCampo test() {
		try {
			return pagoService.test_ws();
		} catch (SocketTimeoutException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/info")
	public @ResponseBody ArrayOfCCampo info(
			@RequestBody ArrayOfCCampo arrayOfCCampo) {
		try {
			Date dtFecha = calFecha.getTime();

			for (CCampo c : arrayOfCCampo.getCCampo()) {
				System.out.println("campo: " + c.getSCampo() + " valor: "
						+ c.getSValor());
			}

			int tx;

			synchronized (this) {
				tx = txCounter.getNext();
			}

			arrayOfCCampo.getCCampo().addAll(0,
					pagoService.returnHeadFields(tx, 1, dtFecha));
			for (CCampo c : arrayOfCCampo.getCCampo()) {
				System.out.println("campo: " + c.getSCampo() + " valor: "
						+ c.getSValor());
			}

			return pagoService.info_ws(arrayOfCCampo);
		} catch (SocketTimeoutException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/info-pago")
	public @ResponseBody ArrayOfCCampo info_pago(
			@RequestBody ArrayOfCCampo arrayOfCCampo) {

		ArrayOfCCampo bloque = new ArrayOfCCampo();
		ArrayOfCCampo bloque2 = new ArrayOfCCampo();
		ArrayOfCCampo result = new ArrayOfCCampo();
		String refOriginal = "";
		int caja = 0;
		Pagos p = new Pagos();

		CCampo cCref = new CCampo();
		CCampo cCSku = new CCampo();
		CCampo cCcaja = new CCampo();
		CCampo cCFolio = new CCampo();
		
		/*Validar institucion
		 * 
		 */
		
		try {
			for (CCampo c : arrayOfCCampo.getCCampo()) {
				System.out.println("campo: " + c.getSCampo() + " valor: "
						+ c.getSValor());
				if (c.getSCampo().equalsIgnoreCase("REFERENCIA")) {
					refOriginal = c.getSValor().toString();
					p.setReferencia(refOriginal);

					cCref = c;
					bloque.getCCampo().add(c);
					bloque2.getCCampo().add(c);
				} else if (c.isBEncriptado()) {
					// String valEncrypted = eencriptar
					// c.setSValor(valEncrypted);
				}
				if (c.getSCampo().equalsIgnoreCase("SKU")) {
					p.setSkuServicio(c.getSValor().toString());
					bloque.getCCampo().add(c);
					bloque2.getCCampo().add(c);
				} else if (c.getSCampo().equalsIgnoreCase("COMISION")) {
					p.setComision(BigDecimal.valueOf(Double.parseDouble(c
							.getSValor().toString())));
					bloque2.getCCampo().add(c);
				} else if (c.getSCampo().equalsIgnoreCase("MONTO")) {
					p.setMonto(BigDecimal.valueOf(Double.parseDouble(c
							.getSValor().toString())));
					/*Validar el monto del pago
					 * 
					 */
					bloque2.getCCampo().add(c);
				} else if (c.getSCampo().equalsIgnoreCase("DV")) {
					p.setDv(Integer.valueOf(c.getSValor().toString()));
					bloque2.getCCampo().add(c);
				} else if (c.getSCampo().equalsIgnoreCase("TIPOPAGO")) {
					p.setTipoPago(Integer.valueOf(c.getSValor().toString()));
					bloque2.getCCampo().add(c);
				} else if (c.getSCampo().equalsIgnoreCase("CAJA")) {
					caja = Integer.valueOf( c.getSValor().toString());
					p.setCaja( caja );
				} else if (c.getSCampo().equalsIgnoreCase("CAJERO")) {
					/*Validar la caja y cajero
					 * 
					 */
					p.setCaja( caja );
				}
			}

			Date dtFecha = calFecha.getTime();
			p.setFechaCaptura(dtFecha);

			int tx;

			synchronized (this) {
				tx = txCounter.getNext();
			}
			
			p.setTransaccion(tx);

			bloque.getCCampo().addAll(0,
					pagoService.returnHeadFields(tx, caja, dtFecha));

			System.out.println("info(bloque): ");

			for (CCampo c : bloque.getCCampo()) {
				System.out.println("campo: " + c.getSCampo() + " valor: "
						+ c.getSValor());
			}

			result = pagoService.info_ws(bloque);

			System.out.println("result: ");

			for (CCampo c : result.getCCampo()) {
				System.out.println("campo: " + c.getSCampo() + " valor: "
						+ c.getSValor());
				if (c.getSCampo().equals("TOKEN")) {
					bloque2.getCCampo().add(c);
				}
			}

			bloque2.getCCampo().addAll(0,
					pagoService.returnHeadFields(tx, caja, dtFecha));

			System.out.println("ejecuta(bloque2): ");

			for (CCampo c : bloque2.getCCampo()) {
				System.out.println("campo: " + c.getSCampo() + " valor: "
						+ c.getSValor());
			}
			
			/**
			 * Aplicar descuento de saldo
			 */
			String saldo = pagoService.saldo( 1, p.getMonto() );
			System.out.println("saldo restante: " + saldo);
			
			result = pagoService.ejecuta(bloque2);

			System.out.println("result: ");

			for (CCampo c : result.getCCampo()) {
				System.out.println("campo: " + c.getSCampo() + " valor: "
						+ c.getSValor());
				if (c.getSCampo().equals("PROVEEDOR")) {
					p.setDescripcionResp(c.getSValor().toString());
				} else if (c.getSCampo().equals("AUTORIZACION")) {
					p.setAutorizacion(Integer.valueOf(c.getSValor().toString()));
				} else if (c.getSCampo().equals("LEYENDA")) {
					p.setLeyenda(c.getSValor().toString());
				}
			}

			return result;
		} catch (SocketTimeoutException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			pagoService.registrar(p);
		}
	}

}
