package com.appweb.psicologa.psicologa.controller.mvc;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GeneralController {
    /* Classe general que aporta informacio a tots els controllers */

    @ModelAttribute
    public void addAtributes(Model model, HttpServletRequest request, HttpSession httpSession  ) { // Fem visible per a totes les finestres
        model.addAttribute("solicitud", request);
        model.addAttribute("usuariRegistrat", httpSession.getAttribute("usuariRegistrat"));
    }

}
