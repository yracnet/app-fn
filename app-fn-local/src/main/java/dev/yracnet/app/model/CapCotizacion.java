package dev.yracnet.app.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CAP_COTIZACION")
public class CapCotizacion {

    @Id
    @GeneratedValue(generator = "CAP_COTIZACIONES", strategy = GenerationType.TABLE)
    @TableGenerator(name = "CAP_COTIZACIONES", table = "CAP_SEQUENCE", schema = "CAP")
    @Column(name = "ID_COTIZACION", nullable = false)
    private Long cotizacionId;

    @Basic(optional = false)
    @Column(name = "TIPO_REGISTRO", nullable = false, updatable = false)
    private String tipo;

    @Basic(optional = false)
    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Basic(optional = false)
    @Column(name = "FECHA_COTIZACION", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Basic(optional = false)
    @Column(name = "VALOR_UFV", nullable = false, updatable = false, precision = 5)
    private Double valorUfv;

    @Basic(optional = false)
    @Column(name = "VALOR_INTERES", nullable = false, updatable = false, precision = 5)
    private Double valorInteres;

    @Basic
    @Column(name = "CREATED_BY", nullable = false, updatable = false, length = 15)
    private String createdBy;

    @Basic
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Long getCotizacionId() {
        return cotizacionId;
    }

    public void setCotizacionId(Long cotizacionId) {
        this.cotizacionId = cotizacionId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getValorUfv() {
        return valorUfv;
    }

    public void setValorUfv(Double valorUfv) {
        this.valorUfv = valorUfv;
    }

    public Double getValorInteres() {
        return valorInteres;
    }

    public void setValorInteres(Double valorInteres) {
        this.valorInteres = valorInteres;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}