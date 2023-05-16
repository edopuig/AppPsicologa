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
import com.appweb.psicologa.psicologa.model.Terapies;
import com.appweb.psicologa.psicologa.model.Usuari;
import com.appweb.psicologa.psicologa.repository.TerapiesRep;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/terapies")
public class TerapiesController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private TerapiesRep terapiesRepository;

    @GetMapping
    public ModelAndView getHome(@RequestParam(defaultValue = "all", required = false) String view_name,
            @RequestParam(defaultValue = "0", required = false) int id) {

        ModelAndView modelAndView = new ModelAndView("/terapies");// Referencia al template terapies.html

        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta registrat

        switch (view_name) {
            case "all":
                modelAndView.addObject("terapies", terapiesRepository.buscarAll()); // Busquem totes les terapies i les
                                                                                    // mostrem
                break;
            case "new":
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    modelAndView.addObject("terapies", terapiesRepository.buscarAll());
                    modelAndView.addObject("terapiaNova", new Terapies()); // Posem una terapia buida per poder
                                                                           // informala i crearla
                } else{ //Si no son usuaris i intentn entrar a la força, els obliguem a anar al login directament.
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }

                break;
            case "update": // ----- De moment nomes la busca, si cliques guardar es fa una nova.
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    modelAndView.addObject("terapies", terapiesRepository.buscarAll());
                    modelAndView.addObject("terapiaUpdate", terapiesRepository.buscarPerId(id)); // busca la terapia per la ID per poderla actualitzar
                    break;
                } else{
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }
        }
        return modelAndView;
    }

    @PostMapping
    public String newAndUpdate(@ModelAttribute Terapies terapies) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
            if (terapies.getIdTerapies() > 0) {
                terapiesRepository.update(terapies);
            } else {
                terapiesRepository.guardar(terapies);
            }
        }
        return "redirect:/terapies";
    }

    @DeleteMapping
    public String eliminarById(@RequestParam int id) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
            terapiesRepository.eliminarById(id);
        }
        return "redirect:/terapies";
    }
}
