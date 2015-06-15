package com.conecta.persistence.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.domain.entities.Pagos;

@Repository
public interface IPagosDao {
	public Pagos registrar(Pagos pago);
	public List<Pagos> find(DetachedCriteria criteria, int start, int maxPerPage);
	public Object montoTotal(int origen, int codResp, int cat, int cat2);
	public BigDecimal saldo(int idInst, BigDecimal monto);
}
