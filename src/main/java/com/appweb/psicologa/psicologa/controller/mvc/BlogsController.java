package com.appweb.psicologa.psicologa.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/blogs")//Sera com va en el navegador (http..../admin)
public class BlogsController {
    
    @GetMapping()
    public ModelAndView getHome(){
        return new ModelAndView("blogs");//Referencia al template blogs.html
    }
}