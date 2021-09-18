/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Efrain
 */
@Entity
@Table(name = "sesion", catalog = "db_auth", schema = "seguridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s")
    , @NamedQuery(name = "Sesion.findBySesId", query = "SELECT s FROM Sesion s WHERE s.sesId = :sesId")
    , @NamedQuery(name = "Sesion.findBySesUsername", query = "SELECT s FROM Sesion s WHERE s.sesUsername = :sesUsername")
    , @NamedQuery(name = "Sesion.findBySesPassword", query = "SELECT s FROM Sesion s WHERE s.sesPassword = :sesPassword")
    , @NamedQuery(name = "Sesion.findBySesUser", query = "SELECT s FROM Sesion s WHERE s.sesUser = :sesUser")
    , @NamedQuery(name = "Sesion.findBySesLastAccess", query = "SELECT s FROM Sesion s WHERE s.sesLastAccess = :sesLastAccess")
    , @NamedQuery(name = "Sesion.findBySesState", query = "SELECT s FROM Sesion s WHERE s.sesState = :sesState")})
public class Sesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ses_id")
    private Integer sesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ses_username")
    private String sesUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ses_password")
    private String sesPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ses_user")
    private String sesUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ses_last_access")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sesLastAccess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ses_state")
    private boolean sesState;

    public Sesion() {
    }

    public Sesion(Integer sesId) {
        this.sesId = sesId;
    }

    public Sesion(Integer sesId, String sesUsername, String sesPassword, String sesUser, Date sesLastAccess, boolean sesState) {
        this.sesId = sesId;
        this.sesUsername = sesUsername;
        this.sesPassword = sesPassword;
        this.sesUser = sesUser;
        this.sesLastAccess = sesLastAccess;
        this.sesState = sesState;
    }

    public Integer getSesId() {
        return sesId;
    }

    public void setSesId(Integer sesId) {
        this.sesId = sesId;
    }

    public String getSesUsername() {
        return sesUsername;
    }

    public void setSesUsername(String sesUsername) {
        this.sesUsername = sesUsername;
    }

    public String getSesPassword() {
        return sesPassword;
    }

    public void setSesPassword(String sesPassword) {
        this.sesPassword = sesPassword;
    }

    public String getSesUser() {
        return sesUser;
    }

    public void setSesUser(String sesUser) {
        this.sesUser = sesUser;
    }

    public Date getSesLastAccess() {
        return sesLastAccess;
    }

    public void setSesLastAccess(Date sesLastAccess) {
        this.sesLastAccess = sesLastAccess;
    }

    public boolean getSesState() {
        return sesState;
    }

    public void setSesState(boolean sesState) {
        this.sesState = sesState;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sesId != null ? sesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.sesId == null && other.sesId != null) || (this.sesId != null && !this.sesId.equals(other.sesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "auth.entity.Sesion[ sesId=" + sesId + " ]";
    }
    
}
