package com.example.co_templates.quests.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.co_templates.quests.services.QuestBoardService;

@Controller
public class QuestBoardRestController {
    @Autowired 
    QuestBoardService QuestBoardService;


    //localhost:8080/q/r/board/List
    @GetMapping({"/q/r/board/List"})
    public ModelAndView callBoardList(ModelAndView modelAndView,
                            @RequestParam HashMap<String,Object> dataMap) {
          
        Object list = QuestBoardService.list(dataMap); //호출하여 실제 데이터를 가져옴
        String viewPath = "/WEB-INF/views/boards/list.jsp";
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("list", list) ; 
        modelAndView.addObject("dataMap", dataMap);

        return modelAndView;
    }

    //postman query
    //localhost:8080/q/r/board/Insert
    // {
    //     "TITLE" : "test_title",
    //     "CONTENTS" : "test_contesnts",
    //     "WRITER_ID" : "cocolang_id",
    //     "PARENT_BOARDS" : ""
    // }
    @GetMapping("/q/r/board/Insert")
    public ResponseEntity<Object> callBoardInsert(@RequestBody HashMap<String,Object> dataMap) {
        QuestBoardService.insert(dataMap);
        return ResponseEntity.ok().body(dataMap);
    }


    //postman query
    // localhost:8080/q/r/board/Update
    // {
    //     "PK_BOARDS" : "fa73ed31-001e-48a5-99e8-6fdd4fc4c871",
    //     "WRITER_ID" : "rugkfl"  
    // }
    @GetMapping("/q/r/board/Update")
    public ResponseEntity<Object> callBoardUpdate(@RequestBody HashMap<String,Object> dataMap) {
        QuestBoardService.update(dataMap);
        return ResponseEntity.ok().body(dataMap);
    }


    //postman query
    //localhost:8080/q/r/board/Delete
    // {
    //     "PK_BOARDS" : "fa73ed31-001e-48a5-99e8-6fdd4fc4c871",
    //     "WRITER_ID" : "rugkfl"  
    // }
    @GetMapping("/q/r/board/Delete")
    public ResponseEntity<Object> callBoardDelete(@RequestBody HashMap<String,Object> dataMap) {
        QuestBoardService.delete(dataMap);
        return ResponseEntity.ok().body(dataMap);
    }
    
}
