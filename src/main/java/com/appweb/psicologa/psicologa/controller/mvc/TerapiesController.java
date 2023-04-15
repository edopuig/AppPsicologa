package com.appweb.psicologa.psicologa.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.appweb.psicologa.psicologa.model.Terapies;
import com.appweb.psicologa.psicologa.repository.TerapiesRep;

@Controller
@RequestMapping("/admin/terapies")
public class TerapiesController {
   
    @Autowired
    private TerapiesRep terapiesRepository;

    @GetMapping
    public ModelAndView getHome( @RequestParam(defaultValue = "all", required = false) String view_name, @RequestParam(defaultValue = "0", required = false) int id){
        
        ModelAndView modelAndView = new ModelAndView("terapies");//Referencia al template terapies.html

        switch (view_name){
            case "all":
                
                break;
            case "new":
                modelAndView.addObject("terapies", new Terapies());
                break;
            case "update": //----- De moment nomes la busca, si cliques guardar es fa una nova.
                modelAndView.addObject("terapies", terapiesRepository.buscarPerId(id)); //busca la terapia per la ID per poderla actualitzar
                break;
        }
        return modelAndView;
    }


    @PostMapping
    public String newAndUpdate(@ModelAttribute Terapies terapies){

        terapiesRepository.guardar(terapies);
        
        return "redirect:/admin/terapies";
    }
}
