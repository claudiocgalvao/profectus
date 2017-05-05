package br.com.gti.profectus.web.controller.factGenerator;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import lombok.extern.log4j.Log4j2;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import br.com.gti.profectus.business.constants.MessageTreatmentTypeEnum;
//import br.com.gti.profectus.business.constants.factGenerator.SituationEnum;
//import br.com.gti.profectus.business.constants.variable.VariableOriginEnum;
//import br.com.gti.profectus.business.constants.variable.VariableTypeEnum;
//import br.com.gti.business.dto.factGenerator.FactGeneratorDTO;
//import br.com.gti.business.dto.formula.FormulaDTO;
//import br.com.gti.business.dto.tax.TaxCriterionDTO;
//import br.com.gti.business.dto.tax.TaxDTO;
//import br.com.gti.business.dto.variable.VariableDTO;
//import br.com.gti.business.entity.factGenerator.FactGenerator;
//import br.com.gti.business.entity.formula.Formula;
//import br.com.gti.business.entity.tax.Tax;
//import br.com.gti.business.entity.variable.Variable;
//import br.com.gti.business.services.factGenerator.IFactGeneratorService;
//import br.com.gti.business.services.formula.IFormulaService;
//import br.com.gti.business.services.tax.ITaxService;
//import br.com.gti.business.services.variable.IVariableService;
//import br.com.gti.profectusweb.controller.IController;
//import br.com.gti.profectusweb.validation.factGenerator.FactGeneratorValidator;
//import br.com.gti.profectusweb.validation.factGenerator.FactGeneratorVersionValidator;
//import br.com.gti.profectusweb.validation.tax.FormulaValidator;
//import br.com.gti.profectusweb.validation.tax.TaxCriterionValidator;
//import br.com.gti.profectusweb.validation.variable.VariableValidator;
//import br.com.gti.utilitario.dateTime.DateHelper;
//
///**
// * FactGeneratorController.
// * @author claudio.cesar
// * @since 20/11/2014
// */
//@Log4j2
//@Controller
//@RequestMapping(value = "/factGenerator")
//public class FactGeneratorController implements IController<FactGeneratorDTO> {
//
//  private ModelAndView modelAndView;
//
//  private final IFactGeneratorService<FactGenerator, FactGeneratorDTO> factGeneratorService;
//
//  private final IVariableService<Variable, VariableDTO> variableService;
//
//  private final VariableValidator variableValidator;
//
//  private final IFormulaService<Formula, FormulaDTO> formulaService;
//
//  private final ITaxService<Tax, TaxDTO> taxService;
//
//  private final TaxCriterionValidator taxCriterionValidator;
//
//  private final FormulaValidator formulaValidator;
//
//  private final FactGeneratorVersionValidator factGeneratorVersionValidator;
//
//  private final FactGeneratorValidator factGeneratorValidator;
//
//  /**
//   * Constructor of class FactGeneratorController.java.
//   * @param factGeneratorService
//   */
//
//  @Inject
//  public FactGeneratorController(final IFactGeneratorService<FactGenerator, FactGeneratorDTO> factGeneratorService,
//                                 final FactGeneratorValidator factGeneratorValidator,
//                                 final VariableValidator variableValidator,
//                                 final IVariableService<Variable, VariableDTO> variableService,
//                                 final ITaxService<Tax, TaxDTO> taxService,
//                                 final TaxCriterionValidator taxCriterionValidator,
//                                 final FormulaValidator formulaValidator,
//                                 final FactGeneratorVersionValidator factGeneratorVersionValidator,
//                                 final IFormulaService<Formula, FormulaDTO> formulaService) {
//
//    this.factGeneratorService = factGeneratorService;
//    this.factGeneratorValidator = factGeneratorValidator;
//    this.variableValidator = variableValidator;
//    this.variableService = variableService;
//    this.modelAndView = new ModelAndView();
//    this.taxService = taxService;
//    this.formulaService = formulaService;
//    this.taxCriterionValidator = taxCriterionValidator;
//    this.formulaValidator = formulaValidator;
//    this.factGeneratorVersionValidator = factGeneratorVersionValidator;
//  }
//
//  @Override
//  public ModelAndView init(FactGeneratorDTO dto) throws Exception {
//
//    return null;
//  }
//
//  /**
//   * list..
//   */
//  @Override
//  @RequestMapping(value = "/list")
//  public ModelAndView list(FactGeneratorDTO dto,
//      HttpServletRequest request,
//      HttpServletResponse response,
//      BindingResult bindingResult) {
//
//    this.modelAndView = new ModelAndView("factGenerator/factGeneratorList");
//
//    List<FactGeneratorDTO> listFactGeneratorDTO = new ArrayList<FactGeneratorDTO>();
//
//    try {
//
//      listFactGeneratorDTO = this.factGeneratorService.filterFactGeneratorMaintenance(dto, request);
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    this.modelAndView.addObject("IS_CHANGE_DESCRIPTION", Boolean.FALSE);
//    this.modelAndView.addObject("listFactGeneratorDTO", listFactGeneratorDTO);
//    return this.modelAndView;
//  }
//
//  /**
//   * add.
//   */
//  @Override
//  @RequestMapping(value = "/add")
//  public ModelAndView add(FactGeneratorDTO dto,
//      HttpServletRequest request,
//      HttpServletResponse response,
//      BindingResult bindResult) {
//
//    this.modelAndView.setViewName("factGenerator/factGeneratorAddEdit");
//
//    dto.getFactGeneratorVersionDTO().setSituation(SituationEnum.EDITION.getId());
//
//    dto.setIsNewVersion(Boolean.TRUE);
//
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//
//    return this.modelAndView;
//  }
//
//  /**
//   * addNewtax.
//   */
//  @RequestMapping(value = "/addNewtax")
//  public ModelAndView addNewtax(FactGeneratorDTO dto,
//      HttpServletRequest request,
//      HttpServletResponse response,
//      BindingResult bindResult) {
//
//    this.modelAndView.setViewName("factGenerator/taxChange");
//    Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//    dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//
//    //dto.getFactGeneratorVersionDTO().setSituation(SituationEnum.EDITION.getId());
//
//    dto.setIsNewVersion(Boolean.TRUE);
//
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//
//    return this.modelAndView;
//  }
//
//  /**
//   * View.
//   * @author claudio.cesar
//   * @since 16/01/2015
//   * @param dto
//   * @param request
//   * @param response
//   * @param bindingResult
//   * @return
//   */
//  @Override
//  @RequestMapping(value = "/view")
//  @Transactional
//  public ModelAndView view(FactGeneratorDTO dto,
//      HttpServletRequest request,
//      HttpServletResponse response,
//      BindingResult bindingResult) {
//
//    String action = dto.getAction();
//    String description = dto.getDescription();
//    String viewName = dto.getViewName();
//    Integer situationId = dto.getFactGeneratorVersionDTO().getSituation();
//    Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//    //Verificar se esta em uso em producao
//    Boolean isUsedProduction = null;
//
//    if (situationId != null
//        && (action.equals("change") || action.equals("save") || action.equals("deleteVariable")
//            || action.equals("deleteFactGenerator") || action.equals("editVariable"))
//        || action.equals("changeCriterion")) {
//
//      isUsedProduction = this.factGeneratorService.isFactGeneratorInProduction(situationId);
//    }
//
//    try {
//      if (action != null && action.equals("prev")) {
//        dto = this.actionPrev(dto);
//        viewName = dto.getViewName(); //Recuperar pagina anterior
//      }
//
//      if (action != null && action.equals("next")) {
//        dto = this.actionNext(dto);
//        viewName = dto.getViewName(); //Recuperar proxima pagina
//      }
//
//      if (viewName != null && viewName.equals("factGenerator/factGeneratorList")) {
//        dto.setInputFormFilter("");
//        List<FactGeneratorDTO> listFactGeneratorDTO = new ArrayList<FactGeneratorDTO>();
//        listFactGeneratorDTO = this.factGeneratorService.filterFactGeneratorMaintenance(dto, null);
//        this.modelAndView.addObject("listFactGeneratorDTO", listFactGeneratorDTO);
//      }
//
//      if (viewName != null && viewName.equals("factGenerator/tabTaxList")) {
//        dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//        dto.setAction(action);
//        this.modelAndView.addObject("IS_CHANGE_DESCRIPTION", Boolean.TRUE); // mostrar botão alterar
//      }
//
//      if (action != null && action.equals("change")) {
//        if (!isUsedProduction) {
//
//          if (viewName.equals("factGenerator/criterionView")) {
//            dto = this.factGeneratorService.findOneFactGeneratorComplete(dto);
//          } else {
//            dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//          }
//
//          boolean isPermisionChange = this.factGeneratorService.unlockPermissionChange(dto);
//
//          dto.setAction(action);
//
//          if (!isPermisionChange) {
//            String msg = "message.formFactGenerator.permission.change.not.allowed";
//            dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.ERROR.getAlertType());
//            viewName = this.modelAndView.getViewName();
//          }
//
//        }
//      }
//
//      if (action != null && action.equals("changeCriterion")) {
//        if (!isUsedProduction) {
//
//          Integer currentIndex = dto.getCurrentIndex();
//
//          if (viewName.equals("factGenerator/criterionAddEdit")) {
//            dto = this.factGeneratorService.findOneFactGeneratorComplete(dto);
//
//          } else {
//            dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//          }
//
//          dto.setCurrentIndex(currentIndex);
//
//          dto.setAction(action);
//
//          boolean isPermisionChange = this.factGeneratorService.unlockPermissionChange(dto);
//          if (!isPermisionChange) {
//            String msg = "message.formFactGenerator.permission.change.not.allowed";
//            dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.ERROR.getAlertType());
//            viewName = this.modelAndView.getViewName();
//          }
//        }
//      }
//
//      // Save description
//      if (action != null && action.equals("save")) {
//        if (!isUsedProduction) {
//          dto.setDescription(description);
//          this.factGeneratorValidator.beforeValidate(dto, bindingResult, this.modelAndView);
//          this.factGeneratorValidator.validate(dto, bindingResult);
//
//          if (dto.getFactGeneratorVersionDTO().getCalculationBase().trim().equals("")) {
//            bindingResult.rejectValue("factGeneratorVersionDTO.calculationBase",
//                                      "message.formFactGeneratorVersion.calculationBase.error");
//          }
//
//          if (dto.getFactGeneratorVersionDTO().getStartTerm().trim().equals("")) {
//            bindingResult.rejectValue("factGeneratorVersionDTO.startTerm",
//                                      "message.formFactGeneratorVersion.startTerm.error");
//          } else {
//            this.factGeneratorVersionValidator.validateDate(bindingResult,
//                                                            "factGeneratorVersionDTO.startTerm",
//                                                            "global.messages.invalid.date.error");
//          }
//
//          if (bindingResult.hasErrors()) {
//
//            if (fgvId != null && dto.getId() != null) {
//              dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//              dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//            }
//
//            this.modelAndView.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//            this.modelAndView.addObject("factGeneratorDTO", dto);
//            return this.modelAndView;
//          }
//
//          if (viewName.equals("factGenerator/factGeneratorChange")) {
//            viewName = "factGenerator/tabTaxList";
//          } else {
//            dto.setViewName(viewName);
//          }
//
//          dto.setIsNewVersion(null); //Não gerar versão na Edição
//          this.saveChange(dto, request, bindingResult);
//          //dto = this.factGeneratorService.updateChange(dto);
//
//          String msg = "message.formFactGenerator.success.change";
//          dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.SUCCESS.getAlertType());
//          this.modelAndView.addObject("IS_CHANGE_DESCRIPTION", Boolean.TRUE); // mostrar botão alterar
//          dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//        }
//      }
//
//      boolean isPermisionChange = this.factGeneratorService.unlockPermissionChange(dto);
//      if (!isPermisionChange) {
//        String msg = "message.formFactGenerator.permission.change.not.allowed";
//        dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.ERROR.getAlertType());
//        viewName = this.modelAndView.getViewName();
//      } else {
//
//        if (action != null && action.equals("deleteVariable")) { // Excluir Variavel
//          this.deleteVariable(dto, isUsedProduction);
//          return this.modelAndView;
//        }
//
//        if (action != null && action.equals("editVariable")) { // editVariable
//          viewName = "factGenerator/variableChange";
//          if (!isUsedProduction) {
//            dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//          }
//        }
//
//      }
//
//      if (action != null && action.equals("deleteFactGenerator")) { // deleteFactGenerator
//        viewName = "factGenerator/factGeneratorList";
//        if (!isUsedProduction) {
//          this.delete(dto, request, response, bindingResult);
//        }
//      }
//
//      if (isUsedProduction != null && isUsedProduction) { //Em uso na producao
//        String msg = "message.formFactGenerator.use.production.error";
//        dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.ERROR.getAlertType());
//        viewName = this.modelAndView.getViewName();
//      }
//
//      if (fgvId != null && dto.getId() != null) {
//
//        if (dto.getFactGeneratorVersionDTO().getDigtiVersion() > 1) {
//
//          dto.setIsBlockDescriptionField(Boolean.TRUE);
//
//        } else {
//          dto.setIsBlockDescriptionField(Boolean.FALSE);
//        }
//
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//        dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//        this.variableService.separateOriginVariable(dto.getListVariableDTO(), this.modelAndView);
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    this.modelAndView.setViewName(viewName);
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//    return this.modelAndView;
//  }
//
//  /**
//   * Lógica do botão prev.
//   * @author claudio.cesar
//   * @since 13/01/2015
//   * @param dto
//   */
//  private FactGeneratorDTO actionPrev(FactGeneratorDTO dto) {
//
//    try {
//
//      if (dto.getAction() != null && dto.getAction().equals("prev") && dto.getViewName() != null
//          && dto.getViewName().equals("factGenerator/criterionView")) {
//
//        Integer currentIndex = dto.getCurrentIndex();
//
//        Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//        dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//
//        dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//        this.variableService.separateOriginVariable(dto.getListVariableDTO(), this.modelAndView);
//
//        //Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//
//        for (int i = 0; i < dto.getListTaxDTO().size(); i++) {
//
//          if (currentIndex == null) {
//            dto.setViewName("factGenerator/criterionView");
//            dto.setAction("prev");
//
//            TaxDTO taxDTO = dto.getListTaxDTO().get(dto.getListTaxDTO().size() - 1);
//
//            dto.getFactGeneratorVersionDTO().setTaxDTO(taxDTO);
//
//            dto.setCurrentIndex(dto.getListTaxDTO().size() - 1);
//            break;
//          }
//
//          if (i == currentIndex - 1) {
//            dto.setViewName("factGenerator/criterionView");
//            dto.setAction("prev");
//            dto.getFactGeneratorVersionDTO().setTaxDTO(dto.getListTaxDTO().get(i));
//            dto.setCurrentIndex(i);
//            break;
//          }
//
//          if (currentIndex - 1 == -1) {
//            dto.setViewName("factGenerator/tabTaxList");
//            break;
//          }
//
//        }
//
//        if (dto.getListTaxDTO().size() == 0) {
//          dto.setViewName("factGenerator/tabTaxList");
//        }
//
//        this.modelAndView.addObject("IS_CHANGE_DESCRIPTION", Boolean.TRUE); // mostrar botão alterar
//
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    return dto;
//  }
//
//  /**
//   * Lógica do botão next.
//   * @author claudio.cesar
//   * @since 13/01/2015
//   * @param dto
//   */
//  private FactGeneratorDTO actionNext(FactGeneratorDTO dto) {
//
//    try {
//
//      if (dto.getAction() != null && dto.getAction().equals("next") && dto.getViewName() != null
//          && dto.getViewName().equals("factGenerator/criterionView")) {
//
//        Integer currentIndex = dto.getCurrentIndex();
//
//        Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//        dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//
//        dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//        this.variableService.separateOriginVariable(dto.getListVariableDTO(), this.modelAndView);
//
//        //Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//
//        for (int i = 0; i < dto.getListTaxDTO().size(); i++) {
//
//          if (currentIndex == null) {
//            dto.setViewName("factGenerator/criterionView");
//            dto.setAction("next");
//            dto.getFactGeneratorVersionDTO().setTaxDTO(dto.getListTaxDTO().get(i));
//            dto.setCurrentIndex(i);
//            break;
//          }
//
//          if (i == currentIndex + 1) {
//            dto.setViewName("factGenerator/criterionView");
//            dto.setAction("next");
//            dto.getFactGeneratorVersionDTO().setTaxDTO(dto.getListTaxDTO().get(i));
//            dto.setCurrentIndex(i);
//            break;
//
//          }
//
//          if (i + 1 == dto.getListTaxDTO().size()) {
//            dto.setViewName("factGenerator/tabVariableList");
//            break;
//          }
//
//        }
//
//        if (dto.getListTaxDTO().size() == 0) {
//          dto.setViewName("factGenerator/tabVariableList");
//        }
//
//        this.modelAndView.addObject("IS_CHANGE_DESCRIPTION", Boolean.TRUE); // mostrar botão alterar
//
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    return dto;
//  }
//
//  /**
//   * edit.
//   */
//  @Override
//  @RequestMapping(value = "/edit")
//  public ModelAndView edit(FactGeneratorDTO dto,
//      HttpServletRequest request,
//      HttpServletResponse response,
//      BindingResult bindingResult) {
//
//    this.modelAndView.setViewName("factGenerator/tabTaxList");
//
//    try {
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//
//      dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//      dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//    return this.modelAndView;
//  }
//
//  /**
//   * editTaxCriterion.
//   * @author claudio.cesar
//   * @since 02/07/2015
//   * @param dto
//   * @param request
//   * @param response
//   * @param bindingResult
//   * @return
//   */
//  @RequestMapping(value = "/editTaxCriterion")
//  public ModelAndView editTaxCriterion(FactGeneratorDTO dto,
//      HttpServletRequest request,
//      HttpServletResponse response,
//      BindingResult bindingResult) {
//
//    try {
//
//      if (dto.getAction().equalsIgnoreCase("criterionView")) {
//        this.modelAndView.setViewName("factGenerator/criterionView");
//      }
//
//      if (dto.getAction().equalsIgnoreCase("criterionChange")) {
//        this.modelAndView.setViewName("factGenerator/criterionChange");
//      }
//
//      if (dto.getAction().equalsIgnoreCase("prev")) {
//        this.modelAndView.setViewName("factGenerator/tabTaxList");
//      }
//
//      if (dto.getAction().equalsIgnoreCase("cancel")) {
//        this.modelAndView.setViewName("factGenerator/factGeneratorList");
//        dto.setAction("");
//      }
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      dto = this.factGeneratorService.findOneFactGeneratorComplete(dto);
//      //dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//
//      dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//      dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//
//      this.variableService.separateOriginVariable(dto.getListVariableDTO(), this.modelAndView);
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//    return this.modelAndView;
//  }
//
//  /**
//   * editVariable.
//   */
//  @RequestMapping(value = "/editVariable")
//  public ModelAndView editVariable(FactGeneratorDTO dto) {
//
//    this.modelAndView.setViewName("factGenerator/variableAddEdit");
//
//    FactGeneratorDTO factGeneratorDTO = new FactGeneratorDTO();
//
//    try {
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      factGeneratorDTO = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//
//      factGeneratorDTO.setVariableDTO(this.variableService.findObject(dto.getVariableDTO().getId()));
//
//      factGeneratorDTO.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//    this.modelAndView.addObject("factGeneratorDTO", factGeneratorDTO);
//    this.modelAndView.addObject("factGeneratorDTOBackup", factGeneratorDTO);
//    return this.modelAndView;
//  }
//
//  /**
//   * editVariableChange.
//   */
//  @RequestMapping(value = "/editVariableChange")
//  public ModelAndView editVariableChange(FactGeneratorDTO dto) {
//
//    FactGeneratorDTO factGeneratorDTO = new FactGeneratorDTO();
//
//    try {
//
//      if (dto.getAction().equalsIgnoreCase("variableView")) {
//        this.modelAndView.setViewName("factGenerator/variableView");
//      }
//
//      if (dto.getAction().equalsIgnoreCase("variableChange")) {
//        this.modelAndView.setViewName("factGenerator/variableChange");
//      }
//
//      if (dto.getAction().equalsIgnoreCase("prev")) {
//        this.modelAndView.setViewName("factGenerator/tabTaxList");
//      }
//
//      if (dto.getAction().equalsIgnoreCase("cancel")) {
//        this.modelAndView.setViewName("factGenerator/factGeneratorList");
//        dto.setAction("");
//      }
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      factGeneratorDTO = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//
//      if (dto.getVariableDTO().getId() != null) {
//
//        factGeneratorDTO.setVariableDTO(this.variableService.findObject(dto.getVariableDTO().getId()));
//      }
//
//      factGeneratorDTO.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    this.modelAndView.addObject("factGeneratorDTO", factGeneratorDTO);
//    this.modelAndView.addObject("factGeneratorDTOBackup", factGeneratorDTO);
//    return this.modelAndView;
//  }
//
//  /**
//   * taxAddEdit.
//   */
//  @RequestMapping(value = "/taxAddEdit")
//  public ModelAndView taxAddEdit(FactGeneratorDTO dto, BindingResult bindingResult) {
//
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("factGenerator/taxAddEdit");
//
//    FactGeneratorDTO fgDTO = new FactGeneratorDTO();
//
//    try {
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      // Presevar parâmetros necessários para validação
//      Long taxId = dto.getFactGeneratorVersionDTO().getTaxDTO().getId();
//      Boolean saveTax = dto.getFactGeneratorVersionDTO().getTaxDTO().getSaveTax();
//
//      // Pesquisando as informações para edição
//      fgDTO = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//      fgDTO.setListTaxDTO(this.taxService.findAll());
//
//      // Setando os parametro novamente apos a consulta anterior
//      fgDTO.getFactGeneratorVersionDTO().getTaxDTO().setId(taxId);
//      fgDTO.getFactGeneratorVersionDTO().getTaxDTO().setSaveTax(saveTax);
//
//      // Pesquisar a descrição do imposto para visualização
//      this.factGeneratorService.findTaxDescription(fgDTO);
//
//      List<TaxDTO> listTaxValid = this.taxService.findTaxByFactGeneratorVersion(fgvId);
//
//      boolean isTaxExisting = Boolean.TRUE;
//
//      if (listTaxValid != null && taxId != null) {
//
//        for (TaxDTO taxDTO : listTaxValid) {
//
//          if (taxId.equals(taxDTO.getId())) {
//            isTaxExisting = Boolean.FALSE;
//            break;
//          }
//        }
//
//        if (!isTaxExisting) {
//
//          bindingResult
//              .rejectValue("factGeneratorVersionDTO.taxDTO.id", "message.formFactGenerator.tax.existing.error");
//
//          if (bindingResult.hasErrors()) {
//            dto.setListTaxDTO(this.taxService.findAll());
//            dto.getFactGeneratorVersionDTO().getTaxDTO().setDescription("");
//            dto.getFactGeneratorVersionDTO().getTaxDTO().setSaveTax(false);
//            mv.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//            mv.addObject("factGeneratorDTO", dto);
//            mv.addObject("factGeneratorDTOBackup", dto);
//            return mv;
//          }
//
//        }
//      }
//
//      if (dto.getFactGeneratorVersionDTO().getTaxDTO().getSaveTax()) {
//
//        if (dto.getFactGeneratorVersionDTO().getTaxDTO().getId() == null) {
//
//          bindingResult.rejectValue("factGeneratorVersionDTO.taxDTO.id", "message.formFactGenerator.tax.error");
//
//          if (bindingResult.hasErrors()) {
//            dto.setListTaxDTO(this.taxService.findAll());
//            dto.getFactGeneratorVersionDTO().getTaxDTO().setSaveTax(false);
//            mv.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//            mv.addObject("factGeneratorDTO", dto);
//            mv.addObject("factGeneratorDTOBackup", dto);
//            return mv;
//          }
//
//        } else {
//          fgDTO.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//          this.variableService.separateOriginVariable(fgDTO.getListVariableDTO(), mv);
//          mv.setViewName("factGenerator/criterionAddEdit");
//        }
//
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    mv.addObject("factGeneratorDTO", fgDTO);
//    mv.addObject("factGeneratorDTOBackup", fgDTO);
//    return mv;
//  }
//
//  /**
//   * taxAddTax.
//   */
//  @RequestMapping(value = "/taxAddTax")
//  public ModelAndView taxAddTax(FactGeneratorDTO dto, BindingResult bindingResult) {
//
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("factGenerator/taxAddTax");
//
//    FactGeneratorDTO fgDTO = new FactGeneratorDTO();
//
//    try {
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      if (dto.getAction() != null && dto.getAction().equals("finalize")) {
//
//        if (fgvId != null && dto.getId() != null) {
//          fgDTO = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//          fgDTO.setAction("");
//          fgDTO.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//          fgDTO.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//          this.modelAndView.addObject("IS_CHANGE_DESCRIPTION", Boolean.TRUE);
//          this.variableService.separateOriginVariable(fgDTO.getListVariableDTO(), this.modelAndView);
//        }
//        mv.setViewName("factGenerator/tabTaxList");
//      } else {
//
//        // Presevar parâmetros necessários para validação
//        Long taxId = dto.getFactGeneratorVersionDTO().getTaxDTO().getId();
//        Boolean saveTax = dto.getFactGeneratorVersionDTO().getTaxDTO().getSaveTax();
//
//        // Pesquisando as informações para edição
//        fgDTO = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//        fgDTO.setListTaxDTO(this.taxService.findAll());
//
//        // Setando os parametro novamente apos a consulta anterior
//        fgDTO.getFactGeneratorVersionDTO().getTaxDTO().setId(taxId);
//        fgDTO.getFactGeneratorVersionDTO().getTaxDTO().setSaveTax(saveTax);
//
//        // Pesquisar a descrição do imposto para visualização
//        this.factGeneratorService.findTaxDescription(fgDTO);
//
//        List<TaxDTO> listTaxValid = this.taxService.findTaxByFactGeneratorVersion(fgvId);
//
//        boolean isTaxExisting = Boolean.TRUE;
//
//        if (listTaxValid != null && taxId != null) {
//
//          for (TaxDTO taxDTO : listTaxValid) {
//
//            if (taxId.equals(taxDTO.getId())) {
//              isTaxExisting = Boolean.FALSE;
//              break;
//            }
//          }
//
//          if (!isTaxExisting) {
//
//            bindingResult.rejectValue("factGeneratorVersionDTO.taxDTO.id",
//                                      "message.formFactGenerator.tax.existing.error");
//
//            if (bindingResult.hasErrors()) {
//              dto.setListTaxDTO(this.taxService.findAll());
//              dto.getFactGeneratorVersionDTO().getTaxDTO().setDescription("");
//              dto.getFactGeneratorVersionDTO().getTaxDTO().setSaveTax(false);
//              mv.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//              mv.addObject("factGeneratorDTO", dto);
//              mv.addObject("factGeneratorDTOBackup", dto);
//              return mv;
//            }
//
//          }
//        }
//
//        if (dto.getFactGeneratorVersionDTO().getTaxDTO().getSaveTax()) {
//
//          if (dto.getFactGeneratorVersionDTO().getTaxDTO().getId() == null) {
//
//            bindingResult.rejectValue("factGeneratorVersionDTO.taxDTO.id", "message.formFactGenerator.tax.error");
//
//            if (bindingResult.hasErrors()) {
//              dto.setListTaxDTO(this.taxService.findAll());
//              dto.getFactGeneratorVersionDTO().getTaxDTO().setSaveTax(false);
//              mv.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//              mv.addObject("factGeneratorDTO", dto);
//              mv.addObject("factGeneratorDTOBackup", dto);
//              return mv;
//            }
//
//          } else {
//            fgDTO.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//            this.variableService.separateOriginVariable(fgDTO.getListVariableDTO(), mv);
//            mv.setViewName("factGenerator/criterionChange");
//          }
//
//        }
//
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    mv.addObject("factGeneratorDTO", fgDTO);
//    mv.addObject("factGeneratorDTOBackup", fgDTO);
//    return mv;
//  }
//
//  /**
//   * variableAdd.
//   * @author claudio.cesar
//   * @since 02/07/2015
//   * @param dto
//   * @param bindingResult
//   * @return
//   */
//  @RequestMapping(value = "/variableAdd")
//  public ModelAndView variableAdd(FactGeneratorDTO dto, BindingResult bindingResult) {
//
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("factGenerator/variableChange");
//
//    FactGeneratorDTO fgDTO = new FactGeneratorDTO();
//
//    try {
//
//      // Presevar parâmetros necessários para validação
//      Long taxId = dto.getFactGeneratorVersionDTO().getTaxDTO().getId();
//      Boolean saveTax = dto.getFactGeneratorVersionDTO().getTaxDTO().getSaveTax();
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      // Pesquisando as informações para edição
//      fgDTO = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//      fgDTO.setListTaxDTO(this.taxService.findAll());
//
//      // Setando os parametro novamente apos a consulta anterior
//      fgDTO.getFactGeneratorVersionDTO().getTaxDTO().setId(taxId);
//      fgDTO.getFactGeneratorVersionDTO().getTaxDTO().setSaveTax(saveTax);
//
//      // Pesquisar a descrição do imposto para visualização
//      this.factGeneratorService.findTaxDescription(fgDTO);
//
//      if (dto.getFactGeneratorVersionDTO().getTaxDTO().getSaveTax()) {
//
//        if (dto.getFactGeneratorVersionDTO().getTaxDTO().getId() == null) {
//
//          bindingResult.rejectValue("factGeneratorVersionDTO.taxDTO.id", "message.formFactGenerator.tax.error");
//
//          if (bindingResult.hasErrors()) {
//            dto.setListTaxDTO(this.taxService.findAll());
//            dto.getFactGeneratorVersionDTO().getTaxDTO().setSaveTax(false);
//            mv.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//            mv.addObject("factGeneratorDTO", dto);
//            mv.addObject("factGeneratorDTOBackup", dto);
//            return mv;
//          }
//
//        } else {
//          fgDTO.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//          this.variableService.separateOriginVariable(fgDTO.getListVariableDTO(), mv);
//          mv.setViewName("factGenerator/variableChange");
//        }
//
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    mv.addObject("factGeneratorDTO", fgDTO);
//    mv.addObject("factGeneratorDTOBackup", fgDTO);
//    return mv;
//  }
//
//  /**
//   * Save.
//   * @author claudio.cesar
//   * @since 20/11/2014
//   * @param dto
//   * @param request
//   * @param bindingResult
//   * @return ModelAndView
//   */
//  @RequestMapping({ "/save" })
//  @Transactional
//  public ModelAndView save(FactGeneratorDTO dto, HttpServletRequest request, BindingResult bindingResult) {
//
//    this.modelAndView.setViewName("factGenerator/factGeneratorAddEdit");
//    FactGeneratorDTO factGeneratorDTO = null;
//    try {
//
//      if (dto.getAction().equals("saveFactGenerator")) {
//
//        /******************************************************
//         * Validator DTO
//         *****************************************************/
//        this.factGeneratorValidator.beforeValidate(dto, bindingResult, this.modelAndView);
//        this.factGeneratorValidator.validate(dto, bindingResult);
//
//        if (dto.getFactGeneratorVersionDTO().getStartTerm().trim().equals("")) {
//          bindingResult.rejectValue("factGeneratorVersionDTO.startTerm",
//                                    "message.formFactGeneratorVersion.startTerm.error");
//        } else {
//          this.factGeneratorVersionValidator.validateDate(bindingResult,
//                                                          "factGeneratorVersionDTO.startTerm",
//                                                          "global.messages.invalid.date.error");
//        }
//
//        if (bindingResult.hasErrors()) {
//          this.modelAndView.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//          dto.setAction("");
//          this.modelAndView.addObject("factGeneratorDTO", dto);
//          return this.modelAndView;
//        }
//
//        /*****************************************************
//         * Save FactGeneratorDTO
//         *****************************************************/
//        dto.setId(this.factGeneratorService.save(dto));
//
//        dto.getFactGeneratorVersionDTO().setSituation(SituationEnum.EDITION.getId());
//
//        /*****************************************************
//         * Save FactGeneratorVersionDTO
//         *****************************************************/
//        dto.getFactGeneratorVersionDTO().setId(this.factGeneratorService.saveVersion(dto));
//
//        /*****************************************************
//         * Montar a(metodo mountVersionView) atraves do construtor (metodo mountVersionView).
//         *****************************************************/
//        factGeneratorDTO = new FactGeneratorDTO(dto);
//        Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//        factGeneratorDTO.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//      }
//
//      this.modelAndView.setViewName("factGenerator/variableAddEdit");
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    factGeneratorDTO.setAction("");
//    dto.setAction("");
//    this.modelAndView.addObject("factGeneratorDTO", factGeneratorDTO);
//    this.modelAndView.addObject("factGeneratorDTOBackup", factGeneratorDTO);
//
//    return this.modelAndView;
//  }
//
//  /**
//   * saveChange.
//   * @author claudio.cesar
//   * @since 26/01/2015
//   * @param dto
//   * @param request
//   * @param bindingResult
//   * @return
//   */
//  @RequestMapping({ "/saveChange" })
//  @Transactional
//  public ModelAndView saveChange(FactGeneratorDTO dto, HttpServletRequest request, BindingResult bindingResult) {
//
//    this.modelAndView.setViewName("factGenerator/factGeneratorAddEdit");
//    FactGeneratorDTO factGeneratorDTO = null;
//    try {
//
//      /******************************************************
//       * Validator DTO
//       *****************************************************/
//      this.factGeneratorValidator.beforeValidate(dto, bindingResult, this.modelAndView);
//      this.factGeneratorValidator.validate(dto, bindingResult);
//
//      if (dto.getFactGeneratorVersionDTO().getStartTerm().trim().equals("")) {
//        bindingResult.rejectValue("factGeneratorVersionDTO.startTerm",
//                                  "message.formFactGeneratorVersion.startTerm.error");
//      } else {
//        this.factGeneratorVersionValidator.validateDate(bindingResult,
//                                                        "factGeneratorVersionDTO.startTerm",
//                                                        "global.messages.invalid.date.error");
//      }
//
//      if (bindingResult.hasErrors()) {
//        this.modelAndView.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//        this.modelAndView.addObject("factGeneratorDTO", dto);
//        return this.modelAndView;
//      }
//
//      /*****************************************************
//       * Save FactGeneratorDTO
//       *****************************************************/
//      dto.setId(this.factGeneratorService.save(dto));
//
//      dto.getFactGeneratorVersionDTO().setSituation(SituationEnum.EDITION.getId());
//
//      /*****************************************************
//       * Save FactGeneratorVersionDTO
//       *****************************************************/
//      dto.getFactGeneratorVersionDTO().setId(this.factGeneratorService.saveVersionChange(dto));
//
//      /*****************************************************
//       * Montar a(metodo mountVersionView) atraves do construtor (metodo mountVersionView).
//       *****************************************************/
//      factGeneratorDTO = new FactGeneratorDTO(dto);
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//      factGeneratorDTO.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//      this.modelAndView.setViewName("factGenerator/variableAddEdit");
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//      //ERROR message
//      dto.addMessageTreatment("global.messages.error.processSolicitation",
//                              MessageTreatmentTypeEnum.ERROR.getAlertType());
//
//    }
//
//    factGeneratorDTO.setAction("");
//    this.modelAndView.addObject("factGeneratorDTO", factGeneratorDTO);
//    this.modelAndView.addObject("factGeneratorDTOBackup", factGeneratorDTO);
//
//    return this.modelAndView;
//  }
//
//  /**
//   * Save VariableDTO.
//   * @author claudio.cesar
//   * @since 11/12/2014
//   * @param dto
//   * @param request
//   * @param bindingResult
//   * @return ModelAndView
//   */
//  @RequestMapping({ "/saveVariable" })
//  @Transactional
//  public ModelAndView saveVariable(FactGeneratorDTO dto, HttpServletRequest request, BindingResult bindingResult) {
//
//    this.modelAndView.setViewName("factGenerator/variableAddEdit");
//    try {
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      if (dto.getAction().equals("saveVariable")) {
//
//        this.setParameterVariableDefault(dto);
//
//        /******************************************************
//         * Validator DTO
//         *****************************************************/
//        this.variableValidator.beforeValidate(dto, bindingResult, this.modelAndView);
//        this.variableValidator.validate(dto.getVariableDTO(), bindingResult);
//        this.variableValidator.afterValidate(dto.getVariableDTO(), bindingResult);
//
//        Boolean isOrder = this.variableService.validateOrderVariable(dto);
//
//        if (bindingResult.hasErrors()) {
//          dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//          this.modelAndView.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//          this.modelAndView.addObject("factGeneratorDTO", dto);
//          return this.modelAndView;
//        }
//
//        if (!bindingResult.hasErrors()) {
//
//          if (isOrder != null && !isOrder) {
//            bindingResult.rejectValue("variableDTO.fieldIndex", "message.formVariable.variavel.sequence.invalid.error");
//            dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//            this.modelAndView.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//            this.modelAndView.addObject("factGeneratorDTO", dto);
//            return this.modelAndView;
//
//          }
//        }
//
//        /*****************************************************
//         * Save variableDTO
//         *****************************************************/
//        if (isOrder != null && isOrder) {
//          dto.getVariableDTO().setId(this.variableService.saveVariableAndTmpFactGenerator(dto.getId(),
//                                                                                          fgvId,
//                                                                                          dto.getVariableDTO()));
//
//          String msg = "message.formVariable.variable.save.sucess";
//          dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.SUCCESS.getAlertType());
//          dto.setVariableDTO(new VariableDTO()); // Limpar form após salvar
//        }
//
//      }
//
//      dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//      this.modelAndView.setViewName("factGenerator/variableAddEdit");
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    dto.setAction("");
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("listVariableDTO", dto.getListVariableDTO());
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//
//    return this.modelAndView;
//  }
//
//  /**
//   * saveVariableChange.
//   * @author claudio.cesar
//   * @since 21/01/2015
//   * @param dto
//   * @param request
//   * @param bindResult
//   * @return ModelAndView
//   */
//  @RequestMapping({ "/saveVariableChange" })
//  @Transactional
//  public ModelAndView saveVariableChange(FactGeneratorDTO dto, HttpServletRequest request, BindingResult bindResult) {
//
//    this.modelAndView.setViewName("factGenerator/variableChange");
//    String viewName = dto.getViewName();
//    try {
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//      if (!dto.getAction().equals("finalize")) {
//
//        this.setParameterVariableDefault(dto);
//
//        /*****************************************************
//         * Validate DTO
//         *****************************************************/
//        this.variableValidator.beforeValidate(dto, bindResult, this.modelAndView);
//        this.variableValidator.validate(dto.getVariableDTO(), bindResult);
//        this.variableValidator.afterValidate(dto.getVariableDTO(), bindResult);
//
//        Boolean isOrder = this.variableService.validateOrderVariable(dto);
//
//        if (bindResult.hasErrors()) {
//          dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//          this.modelAndView.addObject("firstFieldError", bindResult.getFieldErrors().get(0).getField());
//          this.modelAndView.addObject("factGeneratorDTO", dto);
//          return this.modelAndView;
//        }
//
//        if (!bindResult.hasErrors()) {
//
//          if (isOrder != null && !isOrder) {
//            bindResult.rejectValue("variableDTO.fieldIndex", "message.formVariable.variavel.sequence.invalid.error");
//            dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//            this.modelAndView.addObject("firstFieldError", bindResult.getFieldErrors().get(0).getField());
//            this.modelAndView.addObject("factGeneratorDTO", dto);
//            return this.modelAndView;
//
//          }
//        }
//
//        /*****************************************************
//         * Save variableDTO
//         *****************************************************/
//        dto.getVariableDTO().setId(this.variableService.saveVariableAndTmpFactGenerator(dto.getId(),
//                                                                                        fgvId,
//                                                                                        dto.getVariableDTO()));
//
//        dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//
//        boolean isFormulaVariableValid = this.formulaService.findAllFormulaAndSaveNewVariable(dto);
//
//        if (isFormulaVariableValid) {
//          String msg = "message.formFactGenerator.success.change";
//          dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.SUCCESS.getAlertType());
//
//          //Validate situation released--------------------------------------------------------------------------
//          FactGeneratorDTO factGeneratorDTO = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//          Integer situationId = factGeneratorDTO.getFactGeneratorVersionDTO().getSituation();
//
//          if (situationId != null && situationId.equals(SituationEnum.RELEASED.getId())) {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            this.factGeneratorService.updateUser(fgvId, auth.getName());
//          }
//          //------------------------------------------------------------------------------------------------------
//
//          this.factGeneratorService.updateSituation(fgvId, SituationEnum.EDITION.getId());
//          dto.getFactGeneratorVersionDTO().setSituation(SituationEnum.EDITION.getId());
//
//        } else {
//          this.formulaService.deleteFormulaVariableByVariableId(dto.getVariableDTO().getId());
//          this.variableService.deleteTmpFactGeneratorVariable(dto);
//          this.variableService.delete(dto.getVariableDTO());
//          dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//        }
//
//      } else {
//        dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//      //ERROR message
//      dto.addMessageTreatment("global.messages.error.processSolicitation",
//                              MessageTreatmentTypeEnum.ERROR.getAlertType());
//
//    }
//
//    dto.setVariableDTO(new VariableDTO());
//    this.modelAndView.setViewName(viewName);
//    dto.setAction("");
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("listVariableDTO", dto.getListVariableDTO());
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//
//    return this.modelAndView;
//  }
//
//  /**
//   * setParameterDefault.
//   * @author claudio.cesar
//   * @since 14/10/2015
//   * @param dto
//   */
//  private void setParameterVariableDefault(FactGeneratorDTO dto) {
//
//    try {
//      /**
//       * Correcao ref. id 10 corrigido em 17/09/2015
//       */
//      Integer origin = dto.getVariableDTO().getOrigin();
//      if (origin != null && origin.equals(VariableOriginEnum.INTERNAL.getId())) {
//        dto.getVariableDTO().setMandatory(false);
//        dto.getVariableDTO().setKey(false);
//      }
//
//      /**
//       * ID 257 13/10/2015.
//       */
//      Integer type = dto.getVariableDTO().getType();
//      if (type != null && type.equals(VariableTypeEnum.DATE.getId())) {
//        dto.getVariableDTO().setVariableSize(Integer.parseInt("10"));
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//      //ERROR message
//      dto.addMessageTreatment("global.messages.error.processSolicitation",
//                              MessageTreatmentTypeEnum.ERROR.getAlertType());
//
//    }
//
//  }
//
//  /**
//   * saveCriterion.
//   * @author claudio.cesar
//   * @since 11/12/2014
//   * @param dto
//   * @param request
//   * @param bindingResult
//   * @return ModelAndView
//   */
//  @RequestMapping({ "/saveCriterion" })
//  @Transactional
//  public ModelAndView saveCriterion(FactGeneratorDTO dto, HttpServletRequest request, BindingResult bindingResult) {
//
//    this.modelAndView.setViewName("factGenerator/criterionAddEdit");
//
//    try {
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//      dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//      this.variableService.separateOriginVariable(dto.getListVariableDTO(), this.modelAndView);
//
//      /************************************************************************************************
//       * Action dos botões
//       ************************************************************************************************/
//      if (dto.getAction() != null && dto.getAction().equals("prev")) {
//        this.modelAndView.setViewName("factGenerator/taxAddEdit");
//        dto.getFactGeneratorVersionDTO().setTaxDTO(new TaxDTO());
//        dto.setListTaxDTO(this.taxService.findAll());
//      }
//
//      if (dto.getAction() != null && dto.getAction().equals("validate")) {
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//        this.modelAndView.setViewName("validatorFactGenerator/validatorFactGeneratorView");
//      }
//
//      if (dto.getAction() != null && dto.getAction().equals("cancel")) {
//        this.modelAndView.setViewName("factGenerator/factGeneratorList");
//        this.list(dto, request, null, bindingResult);
//      }
//
//      if (dto.getAction() != null && dto.getAction().equals("save")) {
//
//        /******************************************************************************************
//         * Validator DTO
//         ******************************************************************************************/
//        TaxCriterionDTO taxCriterionDTO = dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO();
//        taxCriterionDTO.setFgvId(fgvId);
//        this.taxCriterionValidator.beforeValidate(taxCriterionDTO, bindingResult, this.modelAndView);
//        this.taxCriterionValidator.validate(taxCriterionDTO, bindingResult);
//
//        this.factGeneratorVersionValidator.validate(dto.getFactGeneratorVersionDTO(), bindingResult);
//
//        this.formulaValidator.validate(dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO()
//            .getFormulaDTO(), bindingResult);
//
//        if (bindingResult.hasErrors()) {
//
//          this.modelAndView.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//          this.modelAndView.addObject("factGeneratorDTO", dto);
//          return this.modelAndView;
//
//        } else {
//          this.modelAndView.addObject("firstFieldError", "");
//        }
//
//        if (dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().getId() == null) {
//
//          // RegistrationDate
//          dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO()
//              .setRegistrationDate(DateHelper.formatDateTime(new Date(), DateHelper.DATE_YYYY_MM_DD));
//
//          // lastUpdateDate
//          dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO()
//              .setLastUpdateDate(DateHelper.formatDateTime(new Date(), DateHelper.DATE_YYYY_MM_DD));
//
//        } else {
//
//          // lastUpdateDate
//          dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO()
//              .setLastUpdateDate(DateHelper.formatDateTime(new Date(), DateHelper.DATE_YYYY_MM_DD));
//        }
//
//        //Update table FACT_GENERATOR_VERSION
//        //Não incrementar a versão nesta estapa, somente updade dos campos RegistrationDate e LastUpdateDate
//        dto.setIsNewVersion(null); //Não incrementa a versao
//        this.factGeneratorService.saveVersion(dto);
//
//        // Save table
//        // FACT_GENERATOR_VERSION_TAX*********************************************************/
//        Long taxId = dto.getFactGeneratorVersionDTO().getTaxDTO().getId();
//
//        this.factGeneratorService.saveFactGeneratorVersionTax(fgvId, taxId);
//
//        // Save table
//        // FORMULA****************************************************************************/
//        Long formulaId =
//            this.formulaService.save(dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().getFormulaDTO());
//
//        // Save table
//        // TAX_CRITERION**********************************************************************/
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().setTaxId(taxId);
//
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().setFormulaId(formulaId);
//
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().getFormulaDTO().setId(formulaId);
//
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().setFgvId(fgvId);
//
//        Long criterionId =
//            this.taxService.saveCriterion(dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO());
//
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().setId(criterionId);
//
//        // Save table
//        // FORMULA_VARIABLE*******************************************************************/
//        //this.formulaService.saveAllFormulaVariable(fgvId, formulaId, dto.getListVariableDTO());
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//        boolean isFormulaVariableValid = this.formulaService.findAllFormulaAndSaveNewVariable(dto);
//
//        if (isFormulaVariableValid) {
//          String msg = "message.formFactGenerator.success.save";
//          dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.SUCCESS.getAlertType());
//        }
//
//        this.modelAndView.setViewName("factGenerator/criterionAddEdit");
//
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    dto.setAction("clear"); // Limpar último Ação dos botões
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//
//    return this.modelAndView;
//  }
//
//  /**
//   * saveCriterionChange.
//   * @author claudio.cesar
//   * @since 26/01/2015
//   * @param dto
//   * @param request
//   * @param bindingResult
//   * @return
//   */
//  @RequestMapping({ "/saveCriterionChange" })
//  @Transactional
//  public ModelAndView
//      saveCriterionChange(FactGeneratorDTO dto, HttpServletRequest request, BindingResult bindingResult) {
//
//    this.modelAndView.setViewName(dto.getViewName());
//
//    try {
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//      dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//      this.variableService.separateOriginVariable(dto.getListVariableDTO(), this.modelAndView);
//
//      if (dto.getAction() != null && dto.getAction().equals("save")) {
//
//        /******************************************************************************************
//         * Validator DTO
//         ******************************************************************************************/
//        TaxCriterionDTO taxCriterionDTO = dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO();
//        taxCriterionDTO.setFgvId(fgvId);
//        this.taxCriterionValidator.beforeValidate(taxCriterionDTO, bindingResult, this.modelAndView);
//        this.taxCriterionValidator.validate(taxCriterionDTO, bindingResult);
//        this.factGeneratorVersionValidator.validate(dto.getFactGeneratorVersionDTO(), bindingResult);
//
//        this.formulaValidator.validate(dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO()
//            .getFormulaDTO(), bindingResult);
//
//        if (bindingResult.hasErrors()) {
//          this.modelAndView.setViewName("factGenerator/criterionChange");
//          this.modelAndView.addObject("firstFieldError", bindingResult.getFieldErrors().get(0).getField());
//          this.modelAndView.addObject("factGeneratorDTO", dto);
//          return this.modelAndView;
//
//        } else {
//          this.modelAndView.addObject("firstFieldError", "");
//        }
//
//        if (dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().getId() == null) {
//
//          // RegistrationDate
//          dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO()
//              .setRegistrationDate(DateHelper.formatDateTime(new Date(), DateHelper.DATE_YYYY_MM_DD));
//
//          // lastUpdateDate
//          dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO()
//              .setLastUpdateDate(DateHelper.formatDateTime(new Date(), DateHelper.DATE_YYYY_MM_DD));
//
//        } else {
//
//          // lastUpdateDate
//          dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO()
//              .setLastUpdateDate(DateHelper.formatDateTime(new Date(), DateHelper.DATE_YYYY_MM_DD));
//        }
//
//        // Update table FACT_GENERATOR_VERSION
//        Long fgvIdNew = this.factGeneratorService.saveVersionChange(dto);
//
//        // Save table FACT_GENERATOR_VERSION_TAX**************************************/
//
//        //Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//
//        Long taxId = dto.getFactGeneratorVersionDTO().getTaxDTO().getId();
//
//        this.factGeneratorService.saveFactGeneratorVersionTax(fgvId, taxId);
//
//        // Save table
//        // FORMULA****************************************************************************/
//        Long formulaId =
//            this.formulaService.save(dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().getFormulaDTO());
//
//        // Save table
//        // FORMULA_VARIABLE*******************************************************************/
//        //this.formulaService.saveAllFormulaVariable(fgvId, formulaId, dto.getListVariableDTO());
//        boolean isFormulaVariableValid = this.formulaService.findAllFormulaAndSaveNewVariable(dto);
//
//        // Save table
//        // TAX_CRITERION**********************************************************************/
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().setTaxId(taxId);
//
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().setFormulaId(formulaId);
//
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().getFormulaDTO().setId(formulaId);
//
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().setFgvId(fgvId);
//
//        dto.getFactGeneratorVersionDTO().setSituation(SituationEnum.EDITION.getId());
//
//        Long criterionId =
//            this.taxService.saveCriterion(dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO());
//
//        dto.getFactGeneratorVersionDTO().getTaxDTO().getTaxCriterionDTO().setId(criterionId);
//
//        dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//        dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//        if (isFormulaVariableValid) {
//          String msg = "message.formFactGenerator.success.change";
//          dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.SUCCESS.getAlertType());
//        }
//      }
//
//      if (dto.getAction() != null && dto.getAction().equals("finalize")) {
//        dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//        dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//        dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    dto.setAction(""); // Limpar último Ação dos botões
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    this.modelAndView.addObject("factGeneratorDTOBackup", dto);
//
//    return this.modelAndView;
//  }
//
//  /**
//   * Excluir o fato gerador com impostos, formulas e variaveis.
//   * @author claudio.cesar
//   * @since 22/01/2015
//   * @param dto
//   * @return ModelAndView
//   */
//  @Override
//  @RequestMapping(value = "/delete")
//  public ModelAndView delete(FactGeneratorDTO dto,
//      HttpServletRequest request,
//      HttpServletResponse response,
//      BindingResult bindingResult) {
//
//    List<FactGeneratorDTO> listFactGeneratorDTO = null;
//    try {
//
//      this.factGeneratorService.deleteFactGenerator(dto);
//      listFactGeneratorDTO = this.factGeneratorService.filterFactGeneratorMaintenance(dto, request);
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    this.modelAndView.setViewName("factGenerator/factGeneratorList");
//    this.modelAndView.addObject("listFactGeneratorDTO", listFactGeneratorDTO);
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    return this.modelAndView;
//  }
//
//  /**
//   * Excluir variavel.
//   * @author claudio.cesar
//   * @since 18/12/2014
//   * @param dto
//   * @param isUsedProduction
//   * @return ModelAndView
//   */
//  @RequestMapping(value = "/deleteVariable")
//  public ModelAndView deleteVariable(FactGeneratorDTO dto, boolean isUsedProduction) {
//
//    String viewName = dto.getViewName();
//
//    try {
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//      int situationId = dto.getFactGeneratorVersionDTO().getSituation();
//
//      boolean isMaintenance = this.factGeneratorService.isFactGeneratorInMaintenance(situationId);
//
//      if (isMaintenance && !isUsedProduction) {
//        this.formulaService.deleteFormulaVariableByVariableId(dto.getVariableDTO().getId());
//        this.variableService.deleteTmpFactGeneratorVariable(dto);
//        this.variableService.delete(dto.getVariableDTO());
//      }
//
//      dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//      dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//      dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId));
//
//      if (!isUsedProduction) {
//        if (!isMaintenance) {
//          String msg = "message.formVariable.warning.delete";
//          dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.ERROR.getAlertType());
//
//        } else {
//          String msg = "message.formVariable.success.delete";
//          dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.SUCCESS.getAlertType());
//        }
//      }
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    if (isUsedProduction) { //Em uso na producao
//      String msg = "message.formFactGenerator.use.production.error";
//      dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.ERROR.getAlertType());
//    }
//
//    this.modelAndView.addObject("IS_CHANGE_DESCRIPTION", Boolean.TRUE); // mostrar botão alterar
//    dto.getFactGeneratorVersionDTO().setSituationEnum(SituationEnum.values());
//    this.modelAndView.setViewName(viewName);
//    this.modelAndView.addObject("factGeneratorDTO", dto);
//    //this.modelAndView.addObject("listVariableDTO", dto.getListVariableDTO());
//
//    return this.modelAndView;
//  }
//
//  /**
//   * Excluir imposto.
//   * @author claudio.cesar
//   * @since 18/12/2014
//   * @param dto
//   * @param isUsedProduction
//   * @return ModelAndView
//   */
//  @RequestMapping(value = "/deleteTax")
//  public ModelAndView deleteTax(FactGeneratorDTO dto) {
//
//    try {
//
//      Long fgvId = dto.getFactGeneratorVersionDTO().getId();
//      this.taxService.deleteTaxCriterionChange(dto);
//      dto = this.factGeneratorService.findFactGeneratorByVersionId(fgvId);
//
//      dto.setListVariableDTO(this.variableService.findAllVariableByVersion(fgvId)); //tmpVariable
//      dto.setListTaxDTO(this.taxService.findTaxByFactGeneratorVersion(fgvId));
//
//      dto.getFactGeneratorVersionDTO().setSituationEnum(SituationEnum.values());
//
//      String msg = "message.formFactGenerator.tax.success.delete";
//      dto.addMessageTreatment(msg, MessageTreatmentTypeEnum.SUCCESS.getAlertType());
//
//      this.modelAndView.setViewName("factGenerator/tabTaxList");
//      this.modelAndView.addObject("factGeneratorDTO", dto);
//
//    } catch (Exception e) {
//      log.error(e.getLocalizedMessage(), e);
//    }
//
//    return this.modelAndView;
//  }
//
//}
