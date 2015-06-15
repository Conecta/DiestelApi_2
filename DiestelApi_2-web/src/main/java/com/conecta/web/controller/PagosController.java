package com.conecta.web.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.conecta.service.IPagoService;
import com.domain.entities.Pagos;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {
	
	@Resource
	private IPagoService pagoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public String test(){
		return "test OK";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/pagos")
	public @ResponseBody List<Pagos> find(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Pagos.class);
		return pagoService.find(criteria, 1, 10);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/institucion/{institucion}/pagos")
	public @ResponseBody List<Pagos> find(@PathVariable("institucion") int institucion ){
		DetachedCriteria criteria = DetachedCriteria.forClass(Pagos.class);
		criteria.add( Restrictions.eq("institucionOrigen", institucion) );
		return pagoService.find(criteria, 1, 10);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/conciliacion")
	public @ResponseBody String conciliación(
			@RequestParam(value="fh-inicial", required = false) String fh1
			){
		StringBuilder sb = new StringBuilder();
		String inicio = "HDR";
        String registro = "REG";
        String fin = "TRL";
        String separador = "|";
		DetachedCriteria criteria = DetachedCriteria.forClass(Pagos.class);
		DateFormat dfh = new SimpleDateFormat("yyyyMMdd");
		//3005201523:59:59
		try {
			Calendar calendar = Calendar.getInstance();
			Date hoy = null;
			
			if(fh1!=null) hoy = dfh.parse(fh1);
			else hoy = new Date();
			
			calendar.setTime(hoy);
			
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			hoy = calendar.getTime();			
			System.out.println("hoy " + hoy);
			
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.MILLISECOND, 99);
			
			Date hoyFin = calendar.getTime();
			System.out.println("hoyFin " + hoyFin);
			
			criteria.add(
					Restrictions.between("fechaCaptura", hoy, 
							hoyFin)
					)
					.add( Restrictions.isNotNull("autorizacion")
							);
			
			List<Pagos> pagos = pagoService.find(criteria, 1, 10);
			
			dfh = new SimpleDateFormat("yyyyMMdd");
			sb.append(inicio).append( separador ).append( dfh.format( hoy ) ).append("\n");
			
			dfh = new SimpleDateFormat("dd/MM/yyyy");
	        DateFormat dfHr = new SimpleDateFormat("HH:mm:ss");
	        
			int contador = 1;
			BigDecimal total = BigDecimal.ZERO;
	        for( int i = 0; i < pagos.size(); i++){
//	            System.out.println("pago: " + p.getLeyenda());
	            Pagos p = (Pagos)pagos.get( i );
	            sb.append(registro).append(separador)
	                    .append( contador ).append(separador)
	                    .append( dfh.format( p.getFechaCaptura() ) ).append( separador )
	                    .append( dfHr.format( p.getFechaCaptura() ) ).append( separador )
	                    .append( p.getSkuServicio() ).append( separador )
	                    .append( p.getAutorizacion() ).append( separador )
	                    .append( p.getReferencia() ).append( separador )
	                    .append( p.getMonto() ).append( separador )
	                    .append( p.getComision() ).append( separador )
	                    .append( "04850000100001000" ).append(p.getCaja()).append( separador )
	                    .append( p.getTransaccion() )
	                    .append("\n");
	            total = total.add(p.getMonto());
	            contador++;
	        }
	        sb.append(fin).append( separador ).append( (contador-1) ).append(separador).append( total );
	        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
