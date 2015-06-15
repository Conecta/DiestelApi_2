package com.conecta.persistence.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.entities.Pagos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/hibernateAppContext.xml")
public class EnvioDaoTest {
	@Resource
	private IPagosDao pagosDao;
	
	@Test
	public void find(){
		System.out.println("testing...");
		DetachedCriteria criteria = DetachedCriteria.forClass(Pagos.class);
		criteria.add( Restrictions.eq("codRespuesta", 0) );
		DateFormat dfh = new SimpleDateFormat("yyyyMMdd");
		String fh1 = "20150606";
		try {
			Calendar calendar = Calendar.getInstance();
			Date hoy = null;
			
			hoy = dfh.parse(fh1);
			
			calendar.setTime(hoy);
			
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			hoy = calendar.getTime();			
			System.out.println("hoy " + hoy);
			
			calendar.set(Calendar.HOUR, 23);
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
			
			List<Pagos> pagos = pagosDao.find(criteria, 1, 10);
	        
	        for(Pagos p:pagosDao.find(criteria, 1, 2)){
				System.out.println("pago: " + p.getLeyenda());
			}
	        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void montos(){
		System.out.println("testing montos...");
		System.out.println("monto: " + pagosDao.montoTotal(1, 0, 1, 19) );
	}
}
