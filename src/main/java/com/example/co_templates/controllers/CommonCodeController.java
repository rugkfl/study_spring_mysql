package com.example.co_templates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.co_templates.services.CommonCodeService;

import java.util.ArrayList;

import java.util.HashMap;

@Controller
public class CommonCodeController {

    @Autowired
    CommonCodeService commonCodeService;

    @GetMapping("/commonCode/list")
    public ModelAndView list(ModelAndView modelAndView
                        ,@RequestParam HashMap<String, Object> dataMap
                        ,@RequestParam(name = "deleteIds", required = false ) ArrayList<String> deleteIds) {
        ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
        // Call Service with Pure Java
        // CommonCodeService commonCodeService = new CommonCodeService();
        itemList = (ArrayList<HashMap<String, Object>>) commonCodeService.selectMany(dataMap);

        String viewPath = "/WEB-INF/views/commoncode/list.jsp";
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("itemList", itemList);
        modelAndView.addObject("dataMap", dataMap);

        return modelAndView;
    }

}

