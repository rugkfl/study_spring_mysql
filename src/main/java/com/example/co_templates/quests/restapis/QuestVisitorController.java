package com.example.co_templates.quests.restapis;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.co_templates.quests.services.QuestVisitorService;


@RestController
public class QuestVisitorController {
    @Autowired 
    QuestVisitorService QuestVisitorService;


    @GetMapping({"/q/r/visitor/List/{pageNumber}", "/q/r/visitor/List"})
    public ResponseEntity<Object> callVisitorList(@PathVariable(required = false) String pageNumber,
        HashMap<String,Object> dataMap) {
        Object list = QuestVisitorService.list(dataMap);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/q/r/visitor/Insert")
    public ResponseEntity<Object> callVisitorInsert(@RequestBody HashMap<String,Object> dataMap) {
        QuestVisitorService.insert(dataMap);
        return ResponseEntity.ok().body(dataMap);
    }


    @GetMapping("/q/r/visitor/Delete")
    public ResponseEntity<Object> callVisitorDelete(@RequestBody HashMap<String,Object> dataMap) {
        QuestVisitorService.delete(dataMap);
        return ResponseEntity.ok().body(dataMap);
    }

    
}
