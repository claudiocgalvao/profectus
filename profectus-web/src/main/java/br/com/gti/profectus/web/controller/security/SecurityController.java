//package br.com.gti.profectus.web.controller.security;
//
//import javax.inject.Inject;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import br.com.gti.profectus.business.dto.security.UserDTO;
//import br.com.gti.profectus.business.entity.security.User;
//import br.com.gti.profectus.business.services.security.ISecurityService;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * SecurityController.
// * @since 25/11/2014
// */
//@Slf4j
//@Controller
//@RequestMapping(value = "/security")
//public class SecurityController {
//
//  private final ISecurityService<User, UserDTO> securityService;
//
//  private Authentication auth;
//
//  /**
//   * SecurityController.
//   * Constructor of class SecurityController.java.
//   * @param securityService
//   */
//  @Inject
//  public SecurityController(final ISecurityService<User, UserDTO> securityService) {
//    super();
//    this.securityService = securityService;
//  }
//
//  /**
//   * defaultPage.
//   * @author eduardo.fsantos
//   * @since 04/12/2014
//   * @return ModelAndView
//   * @throws Exception
//   */
//  @SuppressWarnings("unused")
//  @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
//  public ModelAndView defaultPage() throws Exception {
//    ModelAndView view = new ModelAndView();
//
//    try {
//
//      UserDTO userDTO = this.securityService.getUserAuthentication();
//
//      this.auth = SecurityContextHolder.getContext().getAuthentication();
//
//      if (this.auth.isAuthenticated() && this.auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
//        view.setViewName("security/securityList");
//      } else {
//        view.setViewName("login/login");
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    return view;
//  }
//}
