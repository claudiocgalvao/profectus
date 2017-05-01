package br.com.gti.profectus.business.services.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gti.profectus.business.dao.security.ISecurityDAO;
import br.com.gti.profectus.business.dto.security.UserDTO;
import br.com.gti.profectus.business.entity.security.RolesEnum;
import br.com.gti.profectus.business.entity.security.User;
import br.com.gti.profectus.business.entity.security.UserRole;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * SecurityService.
 * @author eduardo.fsantos
 * @since 02/12/2014
 */
@Slf4j
@Service
@Transactional
@Data
public class SecurityService implements ISecurityService<User, UserDTO> {

  private Authentication auth;

  /** securityDAO. */
  @Autowired
 private ISecurityDAO securityDAO;

  /** userDTO. */
  private UserDTO userDTO;
  
  

public SecurityService() {
	super();
}

  /**
   * getUserAuthentication().
   * @author claudio.cesar
   * @since 29/05/2015
   * @return
   * @throws Exception
   */
  @Override
  public UserDTO getUserAuthentication() throws Exception {

    UserDTO dto = new UserDTO();

    this.auth = SecurityContextHolder.getContext().getAuthentication();

    dto.setName(this.auth.getName());

    List<UserRole> listUserRole = new ArrayList<>();

    Set<String> setlist = AuthorityUtils.authorityListToSet(this.auth.getAuthorities());

    Iterator<String> iterator = setlist.iterator();

    //Roles
    while (iterator.hasNext()) {
      String role = iterator.next();
      UserRole userRole = new UserRole();
      userRole.setRole(role);
      listUserRole.add(userRole);
    }
    dto.setUserRoles(listUserRole);

    return dto;
  }

  /**
   * getUserAuthentication().
   * @author claudio.cesar
   * @since 29/05/2015
   * @return
   * @throws Exception
   */
  @Override
  public UserDTO getUserAuthenticationWithId() throws Exception {

    try {
      this.auth = SecurityContextHolder.getContext().getAuthentication();

      //this.userDTO = new UserDTO(this.securityDAO.findByUserName(this.auth.getName()));

      List<UserRole> listUserRole = new ArrayList<>();

      Set<String> setlist = AuthorityUtils.authorityListToSet(this.auth.getAuthorities());

      Iterator<String> iterator = setlist.iterator();

      //Roles
      while (iterator.hasNext()) {
        String role = iterator.next();
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        listUserRole.add(userRole);
      }
      this.userDTO.setUserRoles(listUserRole);

      return this.userDTO;

    } catch (Exception e) {
      log.error("ERROR: SecurityService.getUserAuthenticationWithId");
      log.error("Error to get userDTO with id, detils: ", e);
    }

    return null;
  }

  @Override
  public UserDTO findOneUserByUserName(String userName) throws Exception {

    try {
      //this.userDTO = new UserDTO(this.securityDAO.findByUserName(userName));

      List<UserRole> listUserRole = new ArrayList<>();

      Set<String> setlist = AuthorityUtils.authorityListToSet(this.auth.getAuthorities());

      Iterator<String> iterator = setlist.iterator();

      //Roles
      while (iterator.hasNext()) {
        String role = iterator.next();
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        listUserRole.add(userRole);
      }
      this.userDTO.setUserRoles(listUserRole);

      return this.userDTO;

    } catch (Exception e) {
      log.error(e.getLocalizedMessage(), e);
    }

    return null;
  }

  @Override
  public Boolean hasAdministrationModule() throws Exception {

    try {

      //Authorities
      this.auth = SecurityContextHolder.getContext().getAuthentication();

      //Get authorities to a set list
      Set<String> setlist = AuthorityUtils.authorityListToSet(this.auth.getAuthorities());

      //verify permission to administration module
      return setlist.contains(RolesEnum.ADMIN.getKey());

    } catch (Exception e) {
      log.error("ERROR: SecurityService.hasAdministrationModule");
      log.error("Error verify admin permission, detils: ", e);
    }

    return null;
  }

  @Override
  public Long save(UserDTO dto) throws Exception {
    return null;
  }

  @Override
  public void delete(UserDTO dto) throws Exception {

  }

  @Override
  public UserDTO findObject(Long id) throws Exception {
    return null;
  }

  @Override
  public List<UserDTO> findAll() throws Exception {
    return null;
  }


}
