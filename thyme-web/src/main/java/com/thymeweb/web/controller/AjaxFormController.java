package com.thymeweb.web.controller;

import com.thymeweb.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/ajax-field-validation", method = RequestMethod.GET)
    public String getAjaxFieldValidationView() {
        return "ajax-field-validation";
    }

    @RequestMapping(value = "/ajax-field-validation", method = RequestMethod.POST)
    @ResponseBody
    public boolean processAjaxFieldSubmitWithValidationRequest(@RequestParam(value = "username") String username) {
        List<String> usernames = new ArrayList<>();
        usernames.add("singh");
        usernames.add("peter");
        usernames.add("john");
        return usernames.contains(username);
    }

}
