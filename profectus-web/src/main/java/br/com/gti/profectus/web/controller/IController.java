package br.com.gti.profectus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

/**
 * IController.
 * @author claudio.cesar
 * @since 13/11/2014
 * @param <U>
 * DTO
 */
public interface IController<U> {

  /**
   * Iinit.
   * @param dto
   * @return
   * @throws Exception
   */
  ModelAndView init(U dto) throws Exception;

  /**
   * PageList.
   * @param dto
   * @param bindResult
   * @return
   */
  ModelAndView list( U dto, HttpServletRequest request, HttpServletResponse response, BindingResult bindResult);

  /**
   * Add.
   * @param dto
   * @return
   */
  ModelAndView add( U dto, HttpServletRequest request, HttpServletResponse response, BindingResult bindResult);

  /**
   * View.
   * @param dto
   * @return
   */
  ModelAndView view( U dto, HttpServletRequest request, HttpServletResponse response, BindingResult bindResult);

  /**
   * Edit.
   * @param dto
   * @return
   */
  ModelAndView edit( U dto, HttpServletRequest request, HttpServletResponse response, BindingResult bindResult);

  /**
   * Delete.
   * @param dto
   * @return
   */
  ModelAndView delete( U dto, HttpServletRequest request, HttpServletResponse response, BindingResult bindResult);
}
