package com.conecta.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.diestel.ws.ArrayOfCCampo;
import com.diestel.ws.CCampo;
import com.domain.entities.Pagos;

@Service
public interface IPagoService {
	public Pagos registrar(Pagos pago);
	public List<Pagos> find(DetachedCriteria criteria, int start, int maxPerPage);
	public ArrayOfCCampo info_ws(ArrayOfCCampo arrayOfCCampo) throws InterruptedException, SocketTimeoutException;
	public List<CCampo> returnHeadFields(int tx, int caja, Date fh);
	public ArrayOfCCampo test_ws() throws InterruptedException, SocketTimeoutException;
	public ArrayOfCCampo ejecuta(ArrayOfCCampo arrayOfCCampo) throws InterruptedException, SocketTimeoutException;
	
	public String saldo(int idInst, BigDecimal monto);
}
