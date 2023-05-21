package com.appweb.psicologa.psicologa.controller.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appweb.psicologa.psicologa.model.Activitats;
import com.appweb.psicologa.psicologa.model.Agenda;
import com.appweb.psicologa.psicologa.model.Usuari;
import com.appweb.psicologa.psicologa.repository.ActivitatsRep;
import com.appweb.psicologa.psicologa.repository.AgendaRep;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/activitats") // Sera com va en el navegador (http..../blogs)
public class ActivitatsController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ActivitatsRep activitatsRepository;

    @Autowired
    private AgendaRep agendaRep;

    @GetMapping("/activitatDestacada")
    public ModelAndView getHomeActivitat(@RequestParam(defaultValue = "all", required = false) String view_name,
            @RequestParam(defaultValue = "0", required = false) int id) {

        ModelAndView modelAndView = new ModelAndView("/activitats");// Referencia al template blogs.html

        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat

        switch (view_name) {
            case "all":
                modelAndView.addObject("activitats", activitatsRepository.buscarActivitatDestacada()); // Busquem totes els
                                                                                                // blogs i les
                // mostrem
                break;
            case "new":
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    modelAndView.addObject("activitatnova", new Activitats()); // Posem un blog buit per poder
                    // informala i crearla
                } else { // Si no son usuaris i intentn entrar a la força, els obliguem a anar al login
                         // directament.
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }

                break;
            case "update": // ----- De moment nomes la busca, si cliques guardar es fa una nova.
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    Activitats activitatModificar = activitatsRepository.buscarPerId(id);
                    modelAndView.addObject("activiatatUpdate", activitatModificar); // busca els blogs per la ID per
                                                                                    // poderla actualitzar
                    activitatModificar.setDescripcio(activitatModificar.getDescripcio().replace("<br>", "\n"));
                    break;
                } else {
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }
        }
        return modelAndView;
    }
/* -------------------------------------- BLOGS ------------------------------------- */
    @GetMapping("/blogs")
    public ModelAndView getHomeBlog(@RequestParam(defaultValue = "all", required = false) String view_name,
            @RequestParam(defaultValue = "0", required = false) int id) {

        ModelAndView modelAndView = new ModelAndView("/blogs");// Referencia al template blogs.html

        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat

        switch (view_name) {
            case "all":
                modelAndView.addObject("activitats", activitatsRepository.buscarAllByTipus(1)); // Busquem totes els
                                                                                                // blogs i les
                // mostrem
                break;
            case "new":
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    modelAndView.addObject("activitatnova", new Activitats()); // Posem un blog buit per poder
                    // informala i crearla
                } else { // Si no son usuaris i intentn entrar a la força, els obliguem a anar al login
                         // directament.
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }

                break;
            case "update": // ----- De moment nomes la busca, si cliques guardar es fa una nova.
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    Activitats activitatModificar = activitatsRepository.buscarPerId(id);
                    modelAndView.addObject("activiatatUpdate", activitatModificar); // busca els blogs per la ID per
                                                                                    // poderla actualitzar
                    activitatModificar.setDescripcio(activitatModificar.getDescripcio().replace("<br>", "\n"));
                    break;
                } else {
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }
        }
        return modelAndView;
    }

    @PostMapping("/blogs")
    public String newAndUpdateBlogs(@ModelAttribute Activitats activitat) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {

            // Canviem els enters
            activitat.setDescripcio(activitat.getDescripcio().replace("\n", "<br>"));
            // posem el tipus d'activitat que es
            activitat.setTipus(1);

            if (activitat.getIdActivitat() > 0) {
                activitatsRepository.update(activitat);
            } else {
                activitatsRepository.guardar(activitat);
            }
        }
        return "redirect:/activitats/blogs";
    }

    @DeleteMapping("/blogs")
    public String eliminarBlogsById(@RequestParam int id) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
            activitatsRepository.eliminarById(id);
        }
        return "redirect:/activitats/blogs";
    }

    /**
     * ---------------------------------------------------- CURSOS----------------------------------------------------*/

    @GetMapping("/cursos")
    public ModelAndView getHomeCursos(@RequestParam(defaultValue = "all", required = false) String view_name,
            @RequestParam(defaultValue = "0", required = false) int id) {

        ModelAndView modelAndView = new ModelAndView("/cursos");// Referencia al template blogs.html

        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que estaregistrat
        

        switch (view_name) {
            case "all":
                List<Agenda> dates = new ArrayList<>();
                List<Activitats> activitats = activitatsRepository.buscarAllByTipus(2); //Busquem tots els cursos
                modelAndView.addObject("activitats", activitats); // Busquem totes els blogs i les mostrem

                for(Activitats activitat : activitats){ //Busquem quines activitats tenen alguna data agendada
                    List<Agenda> agendes = agendaRep.buscarPerIdActivitat(activitat.getIdActivitat());
                    for(Agenda agenda: agendes){ //De les ativitats que tinguin una agenda, les afegim a la llista
                        dates.add(agenda);
                    }
                }
              
                modelAndView.addObject("agendes", dates);

                break;
            case "new":
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    modelAndView.addObject("activitatnova", new Activitats()); // Posem un blog buit per poder informala i crearla
                    
                } else { // Si no son usuaris i intentn entrar a la força, els obliguem a anar al login directament.
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }

                break;
            case "update":
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    List<Agenda> datesUpdate = new ArrayList<>();

                    Activitats activitatModificar = activitatsRepository.buscarPerId(id);
                    modelAndView.addObject("activiatatUpdate", activitatModificar); // busca els blogs per la ID per poderla actualitzar
                    activitatModificar.setDescripcio(activitatModificar.getDescripcio().replace("<br>", "\n"));

                    List<Agenda> agendes = agendaRep.buscarPerIdActivitat(activitatModificar.getIdActivitat());
                    for(Agenda agenda: agendes){ //De les ativitats que tinguin una agenda, les afegim a la llista
                        datesUpdate.add(agenda);
                    }
                    modelAndView.addObject("agendesUpdate", datesUpdate);
                    break;
                } else {
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }
        }
        return modelAndView;
    }

    @PostMapping("/cursos")
    public String newAndUpdateCursos(@ModelAttribute Activitats activitat, HttpServletRequest request) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta registrat

        Enumeration<String> parameterNames = request.getParameterNames();
        List<Date> datas = new ArrayList<>();
    
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("data[")) {
                String[] paramValues = request.getParameterValues(paramName);
    
                for (String paramValue : paramValues) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = dateFormat.parse(paramValue);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String dataFormatejada = formatter.format(date);
                        
                        date = formatter.parse(dataFormatejada);
                        datas.add(date);
                    } catch (ParseException e) {
                        // 
                    }
                }
            }
        }
                                                                                       
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {

            // Canviem els enters
            activitat.setDescripcio(activitat.getDescripcio().replace("\n", "<br>"));
            // posem el tipus d'activitat que es
            activitat.setTipus(2);

            if (activitat.getIdActivitat() > 0) {
                activitatsRepository.update(activitat);
                agendaRep.guardarByIdActivitatData(datas,activitat.getIdActivitat());

            } else {
                activitatsRepository.guardar(activitat); //Guardem l'activitat perq generi el seu ID
                activitat = activitatsRepository.buscarUltimaCreada(); //Recuparem l'activitat que s'acava de crear
                if(activitat != null){
                    agendaRep.guardarByIdActivitatData(datas,activitat.getIdActivitat());
                }
            }
        }
        return "redirect:/activitats/cursos";
    }

    @DeleteMapping("/cursos")
    public String eliminarCursosById(@RequestParam int id) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
            activitatsRepository.eliminarById(id);
        }
        return "redirect:/activitats/cursos";
    }

  /* ----------------------------------------------- Podcasts ----------------------------------------------*/

    @GetMapping("/podcasts")
    public ModelAndView getHomePodcasts(@RequestParam(defaultValue = "all", required = false) String view_name,
            @RequestParam(defaultValue = "0", required = false) int id) {

        ModelAndView modelAndView = new ModelAndView("/podcasts");// Referencia al template blogs.html

        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat

        switch (view_name) {
            case "all":
                modelAndView.addObject("activitats", activitatsRepository.buscarAllByTipus(3)); // Busquem totes els
                                                                                                // blogs i les
                // mostrem
                break;
            case "new":
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    modelAndView.addObject("activitatnova", new Activitats()); // Posem un blog buit per poder
                    // informala i crearla
                } else { // Si no son usuaris i intentn entrar a la força, els obliguem a anar al login
                         // directament.
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }

                break;
            case "update": // ----- De moment nomes la busca, si cliques guardar es fa una nova.
                if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                    Activitats activitatModificar = activitatsRepository.buscarPerId(id);
                    modelAndView.addObject("activiatatUpdate", activitatModificar); // busca els blogs per la ID per
                                                                                    // poderla actualitzar
                    activitatModificar.setDescripcio(activitatModificar.getDescripcio().replace("<br>", "\n"));
                    break;
                } else {
                    modelAndView = new ModelAndView("/login");
                    modelAndView.addObject("usuari", new Usuari());
                }
        }
        return modelAndView;
    }

    @PostMapping("/podcasts")
    public String newAndUpdatePodcasts(@ModelAttribute Activitats activitat) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {

            // Canviem els enters
            activitat.setDescripcio(activitat.getDescripcio().replace("\n", "<br>"));
            // posem el tipus d'activitat que es
            activitat.setTipus(3);

            if (activitat.getIdActivitat() > 0) {
                activitatsRepository.update(activitat);
            } else {
                activitatsRepository.guardar(activitat);
            }
        }
        return "redirect:/activitats/podcasts";
    }

    @DeleteMapping("/podcasts")
    public String eliminarPodcastsById(@RequestParam int id) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat
        if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
            activitatsRepository.eliminarById(id);
        }
        return "redirect:/activitats/podcasts";
    }


/* ----------------------------------------------- Xerrades ----------------------------------------------*/

@GetMapping("/xerrades")
public ModelAndView getHomeXerrades(@RequestParam(defaultValue = "all", required = false) String view_name,
        @RequestParam(defaultValue = "0", required = false) int id) {

    ModelAndView modelAndView = new ModelAndView("/xerrades");// Referencia al template blogs.html

    Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                   // registrat

    switch (view_name) {
        case "all":
            modelAndView.addObject("activitats", activitatsRepository.buscarAllByTipus(4)); // Busquem totes els
                                                                                            // blogs i les
            // mostrem
            break;
        case "new":
            if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                modelAndView.addObject("activitatnova", new Activitats()); // Posem un blog buit per poder
                // informala i crearla
            } else { // Si no son usuaris i intentn entrar a la força, els obliguem a anar al login
                     // directament.
                modelAndView = new ModelAndView("/login");
                modelAndView.addObject("usuari", new Usuari());
            }

            break;
        case "update": // ----- De moment nomes la busca, si cliques guardar es fa una nova.
            if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
                Activitats activitatModificar = activitatsRepository.buscarPerId(id);
                modelAndView.addObject("activiatatUpdate", activitatModificar); // busca els blogs per la ID per
                                                                                // poderla actualitzar
                activitatModificar.setDescripcio(activitatModificar.getDescripcio().replace("<br>", "\n"));
                break;
            } else {
                modelAndView = new ModelAndView("/login");
                modelAndView.addObject("usuari", new Usuari());
            }
    }
    return modelAndView;
}

@PostMapping("/xerrades")
public String newAndUpdateXerrada(@ModelAttribute Activitats activitat) {
    Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                   // registrat
    if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {

        // Canviem els enters
        activitat.setDescripcio(activitat.getDescripcio().replace("\n", "<br>"));
        // posem el tipus d'activitat que es
        activitat.setTipus(4);

        if (activitat.getIdActivitat() > 0) {
            activitatsRepository.update(activitat);
        } else {
            activitatsRepository.guardar(activitat);
        }
    }
    return "redirect:/activitats/xerrades";
}

@DeleteMapping("/xerrades")
public String eliminarXerradaById(@RequestParam int id) {
    Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                   // registrat
    if (usuariRegistrat != null && usuariRegistrat.getIdRol() == 1) {
        activitatsRepository.eliminarById(id);
    }
    return "redirect:/activitats/xerrades";
}

}
