package com.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer institucionOrigen;
    private Integer caja;
    private Integer cajero;
    private String referencia;
    private String skuServicio;
    private BigDecimal monto;
    private BigDecimal iva;
    private BigDecimal comision;
    private Integer tipoPago;
    private Date fechaCaptura;
    private Integer codRespuesta;
    private String reverso;
    private Integer status;
    private String descripcionResp;
    private String leyenda;
    private Integer autorizacion;
    private Integer transaccion;
    private String sbResult;
    private Integer dv;

    public Pagos() {
    }

    public Pagos(Integer id) {
        this.id = id;
    }

    public Pagos(Integer id, String skuServicio) {
        this.id = id;
        this.skuServicio = skuServicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstitucionOrigen() {
        return institucionOrigen;
    }

    public void setInstitucionOrigen(Integer institucionOrigen) {
        this.institucionOrigen = institucionOrigen;
    }

    public Integer getCaja() {
        return caja;
    }

    public void setCaja(Integer caja) {
        this.caja = caja;
    }

    public Integer getCajero() {
        return cajero;
    }

    public void setCajero(Integer cajero) {
        this.cajero = cajero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSkuServicio() {
        return skuServicio;
    }

    public void setSkuServicio(String skuServicio) {
        this.skuServicio = skuServicio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Integer getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Integer tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public Integer getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(Integer codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getReverso() {
        return reverso;
    }

    public void setReverso(String reverso) {
        this.reverso = reverso;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescripcionResp() {
        return descripcionResp;
    }

    public void setDescripcionResp(String descripcionResp) {
        this.descripcionResp = descripcionResp;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public Integer getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Integer autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Integer getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Integer transaccion) {
        this.transaccion = transaccion;
    }
    
    public Integer getDv() {
        return this.dv;
    }

    public void setDv(Integer dv) {
        this.dv = dv;
    }

    public String getSbResult() {
        return sbResult;
    }

    public void setSbResult(String sbResult) {
        this.sbResult = sbResult;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagos[ id=" + id + " ]";
    }
}
