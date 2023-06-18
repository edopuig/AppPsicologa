package com.appweb.psicologa.psicologa.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("/registre");//Referencia al template registre.html
        modelAndView.addObject("usuari", new Usuari()); //Posem una terapia buida per poder informala i crearla
        return modelAndView;
    }


    @PostMapping
    public String newAndUpdate(@ModelAttribute Usuari usuari, RedirectAttributes redirectAtribut){//Quan es clica el boto de registrar, entra en aquesta funcio
            boolean guardat = usuariRepository.guardar(usuari); //guardem el nou usuari a la bbdd
            if(guardat){
                httpSession.setAttribute("usuariRegistrat", usuari); //com que entra dintre la aplicacio, guardem l'usuari dintre la sessio per recordarlo mentres estigui dintre
                redirectAtribut.addFlashAttribute("correcte", "Benvingut, per tenir un perfil complet, omple tota la informació restant");
                return "redirect:/profile";
            } else{
                redirectAtribut.addFlashAttribute("error", "Ja hi ha un usuari amb aquest correu");
                return "redirect:/registre";
            }
           
    }
}
