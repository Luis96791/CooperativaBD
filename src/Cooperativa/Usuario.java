/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cooperativa;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "USUARIO", catalog = "CooperativaBD", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByCodigoEmpleado", query = "SELECT u FROM Usuario u WHERE u.codigoEmpleado = :codigoEmpleado"),
    @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Usuario.findByIdRol", query = "SELECT u FROM Usuario u WHERE u.idRol = :idRol"),
    @NamedQuery(name = "Usuario.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Usuario.findByFechaModif", query = "SELECT u FROM Usuario u WHERE u.fechaModif = :fechaModif"),
    @NamedQuery(name = "Usuario.findByCreadoPor", query = "SELECT u FROM Usuario u WHERE u.creadoPor = :creadoPor"),
    @NamedQuery(name = "Usuario.findByModificadoPor", query = "SELECT u FROM Usuario u WHERE u.modificadoPor = :modificadoPor")})
public class Usuario implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private String idUsuario;
    @Column(name = "CODIGO_EMPLEADO")
    private BigInteger codigoEmpleado;
    @Column(name = "CONTRASE\u00d1A")
    private String contraseña;
    @Basic(optional = false)
    @Column(name = "ID_ROL")
    private String idRol;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHA_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModif;
    @Column(name = "CREADO_POR")
    private String creadoPor;
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;

    public Usuario() {
    }

    public Usuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String idUsuario, String idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        String oldIdUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldIdUsuario, idUsuario);
    }

    public BigInteger getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(BigInteger codigoEmpleado) {
        BigInteger oldCodigoEmpleado = this.codigoEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        changeSupport.firePropertyChange("codigoEmpleado", oldCodigoEmpleado, codigoEmpleado);
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        String oldContraseña = this.contraseña;
        this.contraseña = contraseña;
        changeSupport.firePropertyChange("contrase\u00f1a", oldContraseña, contraseña);
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        String oldIdRol = this.idRol;
        this.idRol = idRol;
        changeSupport.firePropertyChange("idRol", oldIdRol, idRol);
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        Date oldFechaCreacion = this.fechaCreacion;
        this.fechaCreacion = fechaCreacion;
        changeSupport.firePropertyChange("fechaCreacion", oldFechaCreacion, fechaCreacion);
    }

    public Date getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(Date fechaModif) {
        Date oldFechaModif = this.fechaModif;
        this.fechaModif = fechaModif;
        changeSupport.firePropertyChange("fechaModif", oldFechaModif, fechaModif);
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        String oldCreadoPor = this.creadoPor;
        this.creadoPor = creadoPor;
        changeSupport.firePropertyChange("creadoPor", oldCreadoPor, creadoPor);
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        String oldModificadoPor = this.modificadoPor;
        this.modificadoPor = modificadoPor;
        changeSupport.firePropertyChange("modificadoPor", oldModificadoPor, modificadoPor);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cooperativa.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
