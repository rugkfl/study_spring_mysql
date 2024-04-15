package com.example.co_templates.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;

@Controller
public class TemplateJSP {
    @GetMapping ("/templateWithJSP")
    public ModelAndView templateWithJSP() {
        String viewPath = "/WEB-INF/views/template.jsp";
        ModelAndView modelAndView = new ModelAndView(); // = ModelAndView modelAndView; 
        modelAndView.setViewName(viewPath);
        return modelAndView;
    }

    @GetMapping ("/templateWithJSPStatements")
    public ModelAndView templateWithJSPStatements(ModelAndView modelAndView) { // param에 넣어서 new와 같은 기능 
        modelAndView.addObject("name", "cocolang");
        modelAndView.addObject("age", "1");
        
        String viewPath = "/WEB-INF/views/template_jspstatements.jsp";
        modelAndView.setViewName(viewPath);
        return modelAndView;
    }

    @GetMapping ("/templateWithServletStatements")
    public String templateWithServletStatements() { 
        HashMap<String, Object> model = new HashMap<>();
        model.put("name", "cocolang");
        model.put("age", "1");

        int day = 3;

        String htmlAll = "<html>";
        htmlAll = htmlAll + "<head><title>IF...ELSE Example</title></head>";
        htmlAll = htmlAll + "<body>";
        if (day == 1 || day == 7) {
            htmlAll = htmlAll + "<p> Today is weekend</p>";
        } else {
            htmlAll = htmlAll + "<p> Today is not weekend</p>";
        }
        htmlAll = htmlAll + "</body>" ;
        htmlAll = htmlAll  + "</html> " ;

        htmlAll = htmlAll + "<div>";
        String name = (String)model.get("name");
        htmlAll = htmlAll + "<div>name : "+name+"</div>";
        String age = (String) model.get("age") ;
        htmlAll = htmlAll + "<div>age : "+age+"</div>";
        htmlAll = htmlAll + "</div>";

        return htmlAll ;
    }
}
