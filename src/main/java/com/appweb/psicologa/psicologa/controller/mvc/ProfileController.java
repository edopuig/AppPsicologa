package com.appweb.psicologa.psicologa.controller.mvc;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appweb.psicologa.psicologa.model.Activitats;
import com.appweb.psicologa.psicologa.model.Agenda;
import com.appweb.psicologa.psicologa.model.Participacio;
import com.appweb.psicologa.psicologa.model.Usuari;
import com.appweb.psicologa.psicologa.repository.ActivitatsRep;
import com.appweb.psicologa.psicologa.repository.AgendaRep;
import com.appweb.psicologa.psicologa.repository.ParticipacioRep;
import com.appweb.psicologa.psicologa.repository.UsuariRep;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UsuariRep usuariRepository;

    @Autowired
    private ParticipacioRep participacioRep;

    @Autowired
    private AgendaRep agendaRep;
    
    @Autowired
    private ActivitatsRep activitatsRepository;

    @GetMapping
    public ModelAndView getHome(@RequestParam(defaultValue = "login", required = false) String view_name){
        ModelAndView modelAndView = new ModelAndView("/profile");//Referencia al template profile.html
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat");

        switch (view_name){
            case "login":
                List<Participacio> partisipacionsList = participacioRep.buscarPerIdUsuari(usuariRegistrat.getIdUsuari());
                List<Activitats> activitatsUsuari = new ArrayList<>();
                List<Agenda> datesUpdate = new ArrayList<>();

                for(Participacio parti : partisipacionsList){
                    List<Agenda> auxdatesUpdate = agendaRep.buscarPerIdAgendas(parti.getIdAgenda());
                    for(Agenda agendaUsuari : auxdatesUpdate){
                        datesUpdate.add(agendaUsuari);
                        activitatsUsuari.add(activitatsRepository.buscarPerId(agendaUsuari.getIdActivitat()));
                    }
                }

                modelAndView.addObject("agendesUpdate", datesUpdate);
                modelAndView.addObject("activitatsUsuari", activitatsUsuari);

                break;
            case "logout":
                httpSession.removeAttribute("usuariRegistrat"); // Elimina la sessió "usuariRegistrat"
                httpSession.invalidate(); // Invalida la sessió
                modelAndView.setViewName("redirect:/login"); // Redirige a la página de inicio de sesión
                break;
        }
        return modelAndView;
    }



    @PostMapping
    public String UpdateProfile(Model model,@ModelAttribute Usuari usuari, HttpServletResponse response) {// Quan es clica el boto de registrar, entra en aquesta  
        Usuari auxUsuari = usuariRepository.getUsuariByCorreu(usuari.getCorreuUsuari());
        usuari.setIdUsuari(auxUsuari.getIdUsuari());                                              // funcio
        usuariRepository.update(usuari); // guardem el nou usuari a la bbdd
        httpSession.removeAttribute("usuariRegistrat"); //eliminem l'antic usuari
        httpSession.setAttribute("usuariRegistrat", usuari); //l'agregem amb les noves dades
       
        return "redirect:/profile";
    }

    @DeleteMapping
    public String eliminarActivitatUsuari(@RequestParam int id, RedirectAttributes redirectAtribut) {
        Usuari usuariRegistrat = (Usuari) httpSession.getAttribute("usuariRegistrat"); // Agafem l'usuari que esta
                                                                                       // registrat
        if (usuariRegistrat != null) {
            participacioRep.eliminarByIdAgendaIdUsuari(id,usuariRegistrat.getIdUsuari());
            redirectAtribut.addFlashAttribute("correcte", "Activitat eliminada correctament");
        }
        return "redirect:/profile";
    }
}
