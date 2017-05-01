//package br.com.gti.profectus.business.dto.security;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.List;
//
//import org.springframework.security.core.userdetails.User;
//
//import lombok.Getter;
//import lombok.Setter;
//
///**
// * UserDTO.
// * @author eduardo.fsantos
// * @since 02/12/2014
// */
//@SuppressWarnings("serial")
//public class UserDTO implements Serializable {
//
//  /** USER_BLANK. */
//  public static final String USER_BLANK = " ";
//
//  private Long userId;
//
//  private String despartment;
//
//  private String email;
//
//  private BigDecimal enabled;
//
//  private String name;
//
//  private String password;
//
//  private String username;
//
// // private List<UserRole> userRoles;
//
//  @Getter
//  @Setter
//  private Boolean isAdm;
//
//  /**
//   * UserDTO.
//   * Constructor of class UserDTO.java.
//   */
//  public UserDTO() {
//  }
//
//  /**
//   * Constructor of class UserDTO.java.
//   * @param user
//   */
//  public UserDTO(User user) {
//    if (user != null) {
////      this.userId = user.getUserId();
////      this.username = user.getUsername();
////      this.name = user.getName();
//    }
//  }
//
//  public Long getUserId() {
//    return this.userId;
//  }
//
//  public void setUserId(Long userId) {
//    this.userId = userId;
//  }
//
//  public String getDespartment() {
//    return this.despartment;
//  }
//
//  public void setDespartment(String despartment) {
//    this.despartment = despartment;
//  }
//
//  public String getEmail() {
//    return this.email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//  public BigDecimal getEnabled() {
//    return this.enabled;
//  }
//
//  public void setEnabled(BigDecimal enabled) {
//    this.enabled = enabled;
//  }
//
//  public String getName() {
//    return this.name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public String getPassword() {
//    return this.password;
//  }
//
//  public void setPassword(String password) {
//    this.password = password;
//  }
//
//  public String getUsername() {
//    return this.username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }
//
//  public List<UserRole> getUserRoles() {
//    return this.userRoles;
//  }
//
//  public void setUserRoles(List<UserRole> userRoles) {
//    this.userRoles = userRoles;
//  }
//
//  /**
//   * addUserRole.
//   * @author eduardo.fsantos
//   * @since 03/12/2014
//   * @param userRole
//   * @return UserRole
//   */
//  public UserRole addUserRole(UserRole userRole) {
//    this.getUserRoles().add(userRole);
//    //userRole.setUser(this);
//
//    return userRole;
//  }
//
//  /**
//   * removeUserRole.
//   * @author eduardo.fsantos
//   * @since 03/12/2014
//   * @param userRole
//   * @return UserRole
//   */
//  public UserRole removeUserRole(UserRole userRole) {
//    this.getUserRoles().remove(userRole);
//    userRole.setUser(null);
//
//    return userRole;
//  }
//
//}
