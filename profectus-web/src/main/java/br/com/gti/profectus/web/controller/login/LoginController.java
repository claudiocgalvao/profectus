package br.com.gti.profectus.web.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;




/**
 * LoginController.
 * @author eduardo.fsantos
 * @since 25/11/2014
 */
@Controller
@RequestMapping(value = "/")
@Log4j2
public class LoginController {

  private Authentication auth;

  /**
   * defaultPage.
   * @author eduardo.fsantos
   * @since 03/12/2014
   * @return ModelAndView
   */
  @RequestMapping(value = {
                           "/", "/welcome**" }, method = RequestMethod.GET)
  public ModelAndView defaultPage() {

    ModelAndView view = new ModelAndView();

    this.auth = SecurityContextHolder.getContext().getAuthentication();

    if (auth != null && this.auth.isAuthenticated()) {
      view.setViewName("layouts/default");
    } else {
      view.setViewName("login/login");
    }
    log.debug("nivel info");
    log.info("nivel info");
    log.error("nivel error");

    return view;

  }

  /**
   * executeSecurity.
   * @author eduardo.fsantos
   * @since 03/12/2014
   * @param model
   * @param request
   * @return String
   */
  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String executeSecurity(ModelMap model, HttpServletRequest request) {

    String name = request.getUserPrincipal().getName();
    model.addAttribute("author", name);
    model.addAttribute("message", "Welcome To Login Form Based Spring Security Example!!!");
    return "welcome";

  }

  /**
   * adminPage.
   * @author eduardo.fsantos
   * @since 03/12/2014
   * @return ModelAndView
   */
  @RequestMapping(value = "/admin**", method = RequestMethod.GET)
  public ModelAndView adminPage() {

    ModelAndView model = new ModelAndView();
    model.addObject("title", "Spring Security Login Form - Database Authentication");
    model.addObject("message", "This page is for ROLE_ADMIN only!");
    model.setViewName("admin");
    return model;

  }


  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login() {
    ModelAndView modelAndView = new ModelAndView("login/login");
    log.info("Login GET");
    return modelAndView;
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(
      value = "logout", required = false) String logout) {

    ModelAndView model = new ModelAndView();

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (error != null) {
      model.addObject("error", "Invalid username and password!");
    }

    if (logout != null) {
      model.addObject("msg", "You've been logged out successfully.");
    }
    model.setViewName("login/login");

    return model;

  }

  //for 403 access denied page
  /**
   * accesssDenied.
   * @since 03/12/2014
   * @return ModelAndView
   */
  @RequestMapping(value = "/403", method = RequestMethod.GET)
  public ModelAndView accesssDenied() {

    ModelAndView model = new ModelAndView();

    //check if user is login
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      UserDetails userDetail = (UserDetails) authentication.getPrincipal();
      model.addObject("username", userDetail.getUsername());
    }

    model.setViewName("403");
    return model;

  }

  /**
   * logout.
   * @author claudio.cesar
   * @since 03/06/2015
   * @return
   */
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public ModelAndView logout() {
    ModelAndView modelAndView = new ModelAndView("login/login");

    return modelAndView;
  }

}
