package br.com.gti.profectus.business.entity.security;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * User.
 * @author eduardo.fsantos
 * @since 03/12/2014
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USERS_USERID_GENERATOR", sequenceName = "SEQ_USER")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USERS_USERID_GENERATOR")
    @Column(name = "USER_ID")
    private long userId;

    private String despartment;

    private String email;

    private BigDecimal enabled;

    private String name;

    private String password;

    private String username;

    //bi-directional many-to-one association to UserRole
    @OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
    private List<UserRole> userRoles;

    /**
     * Constructor of class User.java.
     */
    public User() {
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDespartment() {
        return this.despartment;
    }

    public void setDespartment(String despartment) {
        this.despartment = despartment;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getEnabled() {
        return this.enabled;
    }

    public void setEnabled(BigDecimal enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserRole> getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    /**
     * addUserRol.
     * @author eduardo.fsantos
     * @since 03/12/2014
     * @param userRole
     * @return UserRole
     */
    public UserRole addUserRole(UserRole userRole) {
        this.getUserRoles().add(userRole);
        userRole.setUser(this);

        return userRole;
    }

    /**
     * removeUserRole.
     * @author eduardo.fsantos
     * @since 03/12/2014
     * @param userRole
     * @return UserRole
     */
    public UserRole removeUserRole(UserRole userRole) {
        this.getUserRoles().remove(userRole);
        userRole.setUser(null);

        return userRole;
    }

}
