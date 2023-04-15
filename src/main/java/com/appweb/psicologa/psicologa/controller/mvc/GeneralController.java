package com.appweb.psicologa.psicologa.controller.mvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GeneralController {
    /* Classe general que aporta informacio a tots els controllers */

    @ModelAttribute
    public void addAtributes(Model model, HttpServletRequest request){ //Fem visible per a tots e
        model.addAttribute("solicitud", request); 
    }   
}
