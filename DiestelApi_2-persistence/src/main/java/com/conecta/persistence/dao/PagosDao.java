package com.conecta.persistence.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.entities.Pagos;

@Repository
@Transactional
public class PagosDao implements IPagosDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Pagos> find(DetachedCriteria criteria, int inicio, int maxFilas) {
		return (List<Pagos>) hibernateTemplate.findByCriteria( criteria );
	}

	@Override
	public Pagos registrar(Pagos pago) {
		hibernateTemplate.save(pago);
		return pago;
	}

	@Override
	public Object montoTotal(int origen, int codResp, int cat1, int cat2) {
		Query qry = hibernateTemplate.getSessionFactory().getCurrentSession().getNamedQuery("monto-total");
		qry.setParameter("instOrigen", origen);
		qry.setParameter("codResp", codResp);
		qry.setParameter("cat1", cat1);
		qry.setParameter("cat2", cat2);
		return qry.uniqueResult();
	}

	@Override
	public BigDecimal saldo(int idInst, BigDecimal monto) {
		// TODO Auto-generated method stub
		Query qry = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("update Institucion set montoDisponible = (montoDisponible - :monto) where idInstitucion = :idInst")
				.setInteger("idInst", idInst)
                .setBigDecimal("monto", monto );
		int result = qry.executeUpdate();
		qry = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("select montoDisponible from Institucion where idInstitucion = 1");
		BigDecimal saldo = (BigDecimal) qry.uniqueResult();
		return saldo;
	}
	
}
