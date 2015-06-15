package org.gradle;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.conecta.persistence.dao.PagosDao;
import com.conecta.service.PagosService;
import com.domain.entities.Pagos;

@RunWith(MockitoJUnitRunner.class)
public class PagosServiceTestCase {

	@InjectMocks
	private PagosService pagosService;
	
	@Mock
	private PagosDao pagosDao;
	
	@Test
	public void test(){
		System.out.println("running test");
		DetachedCriteria criteria = DetachedCriteria.forClass(Pagos.class);
		criteria.add( Restrictions.eq("codRespuesta", 0) );
		for(Pagos p:pagosService.find(criteria, 1, 11)){
			System.out.println("running test: " + p.getDescripcionResp());
		}
	}
}
