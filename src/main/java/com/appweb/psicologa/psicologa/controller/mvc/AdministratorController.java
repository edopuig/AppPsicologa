package com.appweb.psicologa.psicologa.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class AdministratorController {
    @GetMapping("/")
    public ModelAndView getHome(){
        return new ModelAndView("/index");
    }

    @GetMapping("/blank")
    public ModelAndView getBlank(){
        return new ModelAndView("/blank");
    }
}
