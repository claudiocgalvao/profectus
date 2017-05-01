//package br.com.gti.profectus.business.entity.security;
//
//import java.io.Serializable;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
///**
// * The persistent class for the USER_ROLES database table.
// */
//@Entity
//@Table(name = "USER_ROLES")
//@NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
//public class UserRole implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @SequenceGenerator(name = "USER_ROLES_USERROLEID_GENERATOR", sequenceName = "SEQ_USER_ROLE")
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_ROLES_USERROLEID_GENERATOR")
//    @Column(name = "USER_ROLE_ID")
//    private long userRoleId;
//
//    private String authority;
//
//    @Column(name = "ROLE")
//    private String role;
//
//    private String username;
//
//    //bi-directional many-to-one association to User
//    @ManyToOne(cascade = { CascadeType.ALL })
//    @JoinColumn(name = "USER_ID")
//    private User user;
//
//    /**
//     * UserRole.
//     * Constructor of class UserRole.java.
//     */
//    public UserRole() {
//    }
//
//    public long getUserRoleId() {
//        return this.userRoleId;
//    }
//
//    public void setUserRoleId(long userRoleId) {
//        this.userRoleId = userRoleId;
//    }
//
//    public String getAuthority() {
//        return this.authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//
//    public String getRole() {
//        return this.role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getUsername() {
//        return this.username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public User getUser() {
//        return this.user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//}
