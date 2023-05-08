package com.appweb.psicologa.psicologa.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.appweb.psicologa.psicologa.model.Usuari;
import com.appweb.psicologa.psicologa.repository.UsuariRep;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/registre")
public class RegistreController {

    @Autowired
    private UsuariRep usuariRepository;

    @Autowired
    private HttpSession httpSession;

    @GetMapping
    public ModelAndView getHome(@RequestParam(defaultValue = "login", required = false) String nom_entrada){
        
        ModelAndView modelAndView = new ModelAndView("/registre");//Referencia al template terapies.html

        switch (nom_entrada){
               case "login":
                modelAndView.addObject("usuari", new Usuari()); //Posem una terapia buida per poder informala i crearla
                break;
                case "register":
                modelAndView.addObject("usuari", new Usuari()); //Posem una terapia buida per poder informala i crearla
                break;
        }
        return modelAndView;
    }


    @PostMapping
    public String newAndUpdate(@ModelAttribute Usuari usuari){//Quan es clica el boto de registrar, entra en aquesta funcio
            usuariRepository.guardar(usuari); //guardem el nou usuari a la bbdd
            httpSession.setAttribute("usuariRegistrat", usuari); //com que entra dintre la aplicacio, guardem l'usuari dintre la sessio per recordarlo mentres estigui dintre
        return "redirect:/";
    }
}
