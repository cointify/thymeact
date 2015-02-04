package com.thymeweb.web.controller;

import com.thymeweb.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@Scope("prototype")
public class AjaxFormController {

    @RequestMapping(value = "/ajax-form-submit", method = RequestMethod.GET)
    public String getAjaxFormView(Model model) {
        model.addAttribute("user", new User());
        return "ajax-form-submit";
    }

    @RequestMapping(value = "/ajax-form-submit", method = RequestMethod.POST)
    public String processAjaxFormSubmitRequest(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "fragments/ajax-result :: ajaxResult";
    }

    @RequestMapping(value = "/ajax-form-validation", method = RequestMethod.GET)
    public String getAjaxFormValidationView(Model model) {
        model.addAttribute("user", new User());
        return "ajax-form-validation";
    }

    @RequestMapping(value = "/ajax-form-validation", method = RequestMethod.POST)
    public String processAjaxFormSubmitWithValidationRequest(@Valid @ModelAttribute User user, BindingResult result) {
        if(result.hasErrors()) {
            return "ajax-form-validation :: #form";
        }
        return "fragments/ajax-result :: ajaxResult";
    }

}
