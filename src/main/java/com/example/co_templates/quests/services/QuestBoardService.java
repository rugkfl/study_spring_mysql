package com.example.co_templates.quests.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;

import java.sql.Timestamp;
import java.util.Date;


@Service
public class QuestBoardService {
    @Autowired
    ShareDao shareDao;

    @Autowired
    Commons commons;

    public List<HashMap<String, Object>> list(HashMap<String,Object> dataMap){
        String sqlMapId = "Board.selectBysearch";
        Object result = shareDao.getList(sqlMapId, dataMap);

        List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) result;
        return list;
    }

    public Object insert(HashMap<String,Object> dataMap){
        // xml 파일에서 특정 id로 지정해서 쿼리문 호출
        String sqlMapId = "Board.insert";
        // 고유번호 호출후 변수에 대입
        String pkUnique = commons.getUniqueSequence();
        String fkUnique = commons.getUniqueSequence();

        // 현재 날짜와 시간을  생성
        Date currentDate = new Date();
       Timestamp currentTimestamp = new Timestamp(currentDate.getTime());

        // 컬럼 갯수 만큼 대입
        dataMap.put("PK_BOARDS", pkUnique);
        dataMap.put("CREATE_DATE", currentTimestamp);



        Object insert = shareDao.insert(sqlMapId, dataMap);
        return insert;
    }

    public Object update(HashMap<String,Object> dataMap){
        String sqlMapId = "Board.update";

        Object update = shareDao.update(sqlMapId, dataMap);

        return update;
    }

    public Object delete(HashMap<String,Object> dataMap){
        String sqlMapId = "Board.delete";
        Object delete = shareDao.delete(sqlMapId, dataMap);
        
        return delete;
    }
    
}
