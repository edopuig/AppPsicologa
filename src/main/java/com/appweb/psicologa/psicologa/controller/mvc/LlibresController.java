package com.appweb.psicologa.psicologa.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.appweb.psicologa.psicologa.model.Llibres;
import com.appweb.psicologa.psicologa.model.Usuari;
import com.appweb.psicologa.psicologa.repository.LlibreRep;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/llibres")
public class LlibresController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private LlibreRep llibresRepository;

    @GetMapping
    public ModelAndView getHome(@RequestParam(defaultValue = "all", required = false) String view_name,
            @RequestParam(defaultValue = "0", required = false) int id) {

        ModelAndView modelAndView = new ModelAndView("/llibres");// Referencia al template llibres.html

        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta registrat

        switch (view_name) {
            case "all":
                modelAndView.addObject("llibres", llibresRepository.buscarAll()); // Busquem totes els llibres i les
                                                                                    // mostrem
                break;
            case "new":
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    modelAndView.addObject("llibreNou", new Llibres()); // Posem un llibre  buida per poder
                                                                           // informala i crearla
                } else{ //Si no son usuaris i intentn entrar a la força, els obliguem a anar al login directament.
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }

                break;
            case "update": // ----- De moment nomes la busca, si cliques guardar es fa una nova.
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    Llibres llibreModificar = llibresRepository.buscarPerId(id);
                    modelAndView.addObject("llibreUpdate", llibreModificar); // busca el llibre per la ID per poderla actualitzar
                    llibreModificar.setDescripcioLlibre(llibreModificar.getDescripcioLlibre().replace("<br>", "\n"));
                    break;
                } else{
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }
        }
        return modelAndView;
    }

    @PostMapping
    public String newAndUpdate(@ModelAttribute Llibres llibres) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {

            //Canviem les 
            llibres.setDescripcioLlibre(llibres.getDescripcioLlibre().replace("\n", "<br>")); 

            if (llibres.getIdLlibres() > 0) {
                llibresRepository.update(llibres);
            } else {
                llibresRepository.guardar(llibres);
            }
        }
        return "redirect:/llibres";
    }

    @DeleteMapping
    public String eliminarById(@RequestParam int id) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
            llibresRepository.eliminarById(id);
        }
        return "redirect:/llibres";
    }
}
