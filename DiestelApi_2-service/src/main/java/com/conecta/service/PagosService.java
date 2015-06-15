package com.conecta.service;

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

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.conecta.persistence.dao.IPagosDao;
import com.diestel.ws.ArrayOfCCampo;
import com.diestel.ws.CCampo;
import com.diestel.ws.ETipo;
import com.domain.entities.Pagos;

@Service("pagoService")
public class PagosService implements IPagoService {

	@Resource
	private IPagosDao pagosDao;
	
	@Override
	public Pagos registrar(Pagos pago) {
		// TODO Auto-generated method stub
		return pagosDao.registrar(pago);
	}

	@Override
	public List<Pagos> find(DetachedCriteria criteria, int start, int maxPerPage) {
		// TODO Auto-generated method stub
		return pagosDao.find(criteria, start, maxPerPage);
	}

	public ArrayOfCCampo info_ws(ArrayOfCCampo arrayOfCCampo) throws InterruptedException, SocketTimeoutException {

        //log.info("crea authenticator: " + new Date());
        Authenticator myAuth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("usr_ws", "usr123".toCharArray());
            }
        };
        Authenticator.setDefault(myAuth);
        com.diestel.ws.PxUniversal service = new com.diestel.ws.PxUniversal();
        com.diestel.ws.PxUniversalSoap port = service.getPxUniversalSoap();
        //log.info("creado authenticator: " + new Date());

        //log.info("crea servicio: " + new Date());
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.ws.request.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.ws.connect.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.connectionTimeout", 45000);
        ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.receiveTimeout", 45000);
        //log.info("creado servicio: " + new Date());
        try{
            return port.info(arrayOfCCampo);
        }catch(Exception ex){
            if( ex instanceof java.net.SocketTimeoutException){
                throw new java.net.SocketTimeoutException();
            }else{
                throw new java.net.SocketTimeoutException();
            }
        }
    }
	
	public ArrayOfCCampo test_ws() throws InterruptedException, SocketTimeoutException {

        //log.info("crea authenticator: " + new Date());
        Authenticator myAuth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("usr_ws", "usr123".toCharArray());
            }
        };
        Authenticator.setDefault(myAuth);
        com.diestel.ws.PxUniversal service = new com.diestel.ws.PxUniversal();
        com.diestel.ws.PxUniversalSoap port = service.getPxUniversalSoap();
        //log.info("creado authenticator: " + new Date());

        //log.info("crea servicio: " + new Date());
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.ws.request.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.ws.connect.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.connectionTimeout", 45000);
        ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.receiveTimeout", 45000);
        //log.info("creado servicio: " + new Date());
        try{
            return port.test();
        }catch(Exception ex){
            if( ex instanceof java.net.SocketTimeoutException){
                throw new java.net.SocketTimeoutException();
            }else{
                throw new java.net.SocketTimeoutException();
            }
        }
    }
	
	public ArrayOfCCampo ejecuta(ArrayOfCCampo arrayOfCCampo) throws InterruptedException, SocketTimeoutException {

        Authenticator myAuth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
            	return new PasswordAuthentication("usr_ws", "usr123".toCharArray());
            }
        };
        Authenticator.setDefault(myAuth);
        com.diestel.ws.PxUniversal service = new com.diestel.ws.PxUniversal();
        com.diestel.ws.PxUniversalSoap port = service.getPxUniversalSoap();
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.ws.request.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.ws.connect.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.connectionTimeout", 45000);
        ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.receiveTimeout", 45000);
        
        try{
            return port.ejecuta(arrayOfCCampo);
        }catch(Exception ex){
            if( ex instanceof java.net.SocketTimeoutException){
                throw new java.net.SocketTimeoutException();
            }else{
                throw new java.net.SocketTimeoutException();
            }
        }
        
    }
	
	public List<CCampo> returnHeadFields(int tx, int caja, Date dtFecha){
		List<CCampo> lstResp = new ArrayList<>();
		
		CCampo campo = new CCampo();
		campo.setSCampo("IDGRUPO");
		campo.setSValor( 7 );
		campo.setITipo(ETipo.NE);
		campo.setBEncriptado(false);
		
		lstResp.add(campo);

		CCampo campo1 = new CCampo();
		campo1.setSCampo("IDCADENA");
		campo1.setSValor(1);
		campo1.setITipo(ETipo.NE);
		campo1.setBEncriptado(false);
        //Cadena
		lstResp.add(campo1);

		CCampo campo2 = new CCampo();
		campo2.setSCampo("IDTIENDA");
		campo2.setSValor( 1 );
		campo2.setITipo(ETipo.NE);
		campo2.setBEncriptado(false);
        //Tienda
		lstResp.add(campo2);

		CCampo campo3 = new CCampo();
		campo3.setSCampo("IDPOS");
		campo3.setSValor( caja );
		campo3.setITipo(ETipo.NE);
		campo3.setBEncriptado(false);
        //POS
		lstResp.add(campo3);

		CCampo campo4 = new CCampo();
		campo4.setSCampo("IDCAJERO");
		campo4.setSValor( 1 );
		campo4.setITipo(ETipo.NE);
		campo4.setBEncriptado(false);
        //Cajero
		lstResp.add(campo4);

        //Fechas

        CCampo campo5 = new CCampo();
        campo5.setSCampo("FECHALOCAL");
        campo5.setSValor( new SimpleDateFormat("dd/MM/yyyy").format(dtFecha) );
        campo5.setITipo(ETipo.FD);
        campo5.setBEncriptado(false);
        //Fecha Local
        lstResp.add(campo5);

        CCampo campo6 = new CCampo();
        campo6.setSCampo("HORALOCAL");
        campo6.setSValor(new SimpleDateFormat("HH:mm:ss").format(dtFecha));
        campo6.setITipo(ETipo.HR);
        campo6.setBEncriptado(false);
        //Hora Local
        lstResp.add(campo6);

        CCampo campo7 = new CCampo();
        campo7.setSCampo("TRANSACCION");
        campo7.setSValor(tx);
        campo7.setITipo(ETipo.NE);
        campo7.setBEncriptado(false);
        //Transacción
        lstResp.add(campo7);
		return lstResp;
	}

	@Override
	public String saldo(int idInst, BigDecimal monto) {
		// TODO Auto-generated method stub
		return pagosDao.saldo(idInst, monto).toString();
	}
}
