package com.appweb.psicologa.psicologa.controller.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.appweb.psicologa.psicologa.model.Usuari;
import com.appweb.psicologa.psicologa.repository.UsuariRep;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UsuariRep usuariRepository;

    @Autowired
    private HttpSession httpSession;

    @GetMapping
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("/login");//Referencia al template registre.html
        modelAndView.addObject("usuari", new Usuari()); //Posem una terapia buida per poder informala i crearla
        return modelAndView;
    }


    @PostMapping
    public String login(@ModelAttribute Usuari usuari){//Quan es clica el boto de registrar, entra en aquesta funcio
        if(usuari.getCorreuUsuari() == null || usuari.getContrasenyaUsuari() == null){

        } else{
       
           usuari = usuariRepository.login(usuari.getCorreuUsuari(), usuari.getContrasenyaUsuari()); //guardem el nou usuari a la bbdd
           if(usuari != null){
                httpSession.setAttribute("usuariRegistrat", usuari); //com que entra dintre la aplicacio, guardem l'usuari dintre la sessio per recordarlo mentres estigui dintre
                return "redirect:/profile";
           } else{

           }
           
        }
        return "redirect:/";
    }
}
