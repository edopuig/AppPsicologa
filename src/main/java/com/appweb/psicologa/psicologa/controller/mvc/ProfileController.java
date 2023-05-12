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

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UsuariRep usuariRepository;

    @GetMapping
    public ModelAndView getHome(@RequestParam(defaultValue = "login", required = false) String view_name){
        ModelAndView modelAndView = new ModelAndView("/profile");//Referencia al template profile.html
       

        switch (view_name){
            case "login":
                 modelAndView.addObject("usuari", new Usuari()); //Busquem totes les terapies i les mostrem
                break;
            case "logout":
                httpSession.removeAttribute("usuariRegistrat"); // Elimina la sessió "usuariRegistrat"
                httpSession.invalidate(); // Invalida la sessió
                modelAndView.setViewName("redirect:/login"); // Redirige a la página de inicio de sesión
                break;
        }
        return modelAndView;
    }

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/profile/login")
    public String logout(HttpServletResponse response) {
        httpSession.removeAttribute("usuariRegistrat"); // Elimina la sessió "usuariRegistrat"
        httpSession.invalidate(); // Invalida la sessió
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Deshabilita la caché del
                                                                                    // navegador

        return "redirect:/login";
    }

    @PostMapping
    public String newAndUpdate(@ModelAttribute Usuari usuari) {// Quan es clica el boto de registrar, entra en aquesta
                                                               // funcio
        usuariRepository.guardar(usuari); // guardem el nou usuari a la bbdd
        return "redirect:/";
    }
}
