package com.appweb.psicologa.psicologa.controller.mvc;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appweb.psicologa.psicologa.model.Correu;
//import com.appweb.psicologa.psicologa.services.correuSender;
import com.appweb.psicologa.psicologa.model.Usuari;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/contacte")
public class ContacteController {

   /*  @Autowired
    private correuSender emailService;*/


    private ModelAndView modelAndView;

    @GetMapping
    public ModelAndView getHome(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuari usuariRegistrat = (Usuari) session.getAttribute("usuariRegistrat"); //recuperem l'objecte del usuari, per posar la info automaticament
        Correu correu = new Correu();
       if(usuariRegistrat != null){
         
        correu.setNom(usuariRegistrat.getNomUsuari());
        correu.setCorreu(usuariRegistrat.getCorreuUsuari());
        
       }
       
        modelAndView = new ModelAndView("/contacte");// Referencia al template terapies.html
        modelAndView.addObject("correu", correu);
        return modelAndView;
    }

    @PostMapping
    public String sendEmail(@ModelAttribute Correu correu, RedirectAttributes redirectAtribut) {
        //emailService.sendEmail(correu.getCorreu(), "Formulari de contacte enviat", " Gracies per enviar el seguent missatge: " + correu.getConsulta() + "Quan pugi, em posare en contacte amb vosté");
        redirectAtribut.addFlashAttribute("correcte", "Correu enviat correctament");
        return "redirect:/contacte";
    }

}
