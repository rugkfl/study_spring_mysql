package com.example.co_templates.quests.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;


@Service
public class QuestVisitorService {
    @Autowired
    ShareDao shareDao;

    @Autowired
    Commons commons;

    public Object list(HashMap<String,Object> dataMap){
        String sqlMapId = "Visitor.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }

    public void insert(HashMap<String,Object> dataMap){
        // xml 파일에서 특정 id로 지정해서 쿼리문 호출
        String sqlMapId = "Visitor.insert";
        // 고유번호 호출후 변수에 대입
        String pkUnique = commons.getUniqueSequence();
        String fkUnique = commons.getUniqueSequence();



        // 컬럼 갯수 만큼 대입
        dataMap.put("PK_VISITORS", pkUnique);
        dataMap.put("WRITER_ID", "cocolang_id");
        dataMap.put("PK_BOARDS", fkUnique);

        Object insert = shareDao.insert(sqlMapId, dataMap);
    }

    public void update(HashMap<String,Object> dataMap){
        String sqlMapId = "Visitor.update";
        String pkUnique = commons.getUniqueSequence();
        String fkUnique = commons.getUniqueSequence();
        dataMap.put("PK_VISITORS",pkUnique);
        dataMap.put("WRITER_ID",fkUnique);

        Object update = shareDao.update(sqlMapId, dataMap);
    }

    public void delete(HashMap<String,Object> dataMap){
        String sqlMapId = "Visitor.delete";
        String pkUnique = commons.getUniqueSequence();
        dataMap.put("PK_VISITORS",pkUnique);
        Object delete = shareDao.delete(sqlMapId, dataMap);

    }
    
}
