package com.thymeweb.web.controller;

import com.thymeweb.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
public class AjaxFormController {

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public String getAjaxFormView(Model model) {
        model.addAttribute("user", new User());
        return "ajax";
    }

    @RequestMapping(value = "/ajax/form-submit", method = RequestMethod.POST)
    public String processAjaxFormSubmitRequest(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        // return ajaxResult fragment inside "fragments/ajax-result" page
        return "fragments/ajax-result :: ajaxResult";
    }
}
