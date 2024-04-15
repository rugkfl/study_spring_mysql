package com.example.co_templates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.co_templates.services.CommonCodeService;

import java.util.ArrayList;

import java.util.HashMap;

@Controller
public class CommonCodeController {

    @Autowired
    CommonCodeService commonCodeService;
    @GetMapping("/commonCode/list")
    public ModelAndView list(ModelAndView modelAndView) {
        ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
        // Call Service with Pure Java
        // CommonCodeService commonCodeService = new CommonCodeService();
        itemList = commonCodeService.list(1);

        String viewPath = "/WEB-INF/views/template.jsp";
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("itemList", itemList);

        return modelAndView;
    }
}
