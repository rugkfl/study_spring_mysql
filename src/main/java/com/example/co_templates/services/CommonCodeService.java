package com.example.co_templates.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;
import com.example.co_templates.utils.Paginations;

@Service
public class CommonCodeService {
    @Autowired
    ShareDao shareDao;

    @Autowired
    Commons commons;

    public Object selectMany(HashMap<String, Object> dataMap) {
        // 여러개 가져오기
        String sqlMapId = "CommonCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }

    public Object selectTotal(Map dataMap) {
        String sqlMapId = "CommonCode.selectTotal"; // 전체 개수만 가져옴
        Object result = shareDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Map selectSearchWithPagination(Map dataMap) {
        // 페이지 형성 위한 계산
        int totalCount = (int) this.selectTotal(dataMap);

        int currentPage = 1; // 값이 안들어오면 1페이지
        if(dataMap.get("currentPage") != null) {
            currentPage = Integer.parseInt((String)dataMap.get("currentPage"));    // from client in param
        }

        Paginations paginations = new Paginations(totalCount, currentPage);
        HashMap result = new HashMap<>();
        result.put("paginations", paginations); // 페이지에 대한 정보

        // page record 수
        String sqlMapId = "CommonCode.selectSearchWithPagination";
        dataMap.put("pageScale", paginations.getPageScale());
        dataMap.put("pageBegin", paginations.getPageBegin());
        
        result.put("resultList", shareDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }

    public void callDao(HashMap<String, Object> dataMap){

        // 한개만 가져오기
        String sqlMapId = "CommonCode.selectByUID";
        dataMap.put("PK_UNIQUE", "CC002");
        Object one = shareDao.getOne(sqlMapId, dataMap);

        String pk_unique = commons.getUniqueSequence();
        sqlMapId = "CommonCode.insert";
        dataMap.put("PK_UNIQUE", pk_unique);
        dataMap.put("CODE_NAME", "test_insert");
        dataMap.put("DESCRIPTION", "test insert");
        dataMap.put("PARENT_UNIQUE", "");
        Object insert = shareDao.insert(sqlMapId, dataMap);

        sqlMapId = "CommonCode.update";
        dataMap.put("PK_UNIQUE", pk_unique);
        dataMap.put("CODE_NAME", "test_ROOT");
        Object update = shareDao.update(sqlMapId, dataMap);

        sqlMapId = "CommonCode.delete";
        dataMap.put("PK_UNIQUE", pk_unique);
        Object delete = shareDao.delete(sqlMapId, dataMap);

        return;
    }

    public HashMap<String, Object> mixed(Integer pageNumber, Integer pkid){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", this.list(pageNumber));
        resultMap.put("view", this.view(pkid));
        return resultMap;
    }

    public ArrayList<HashMap<String, Object>> list(Integer pageNumber){
        ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
 
        HashMap<String, Object> item = new HashMap<>();
        item.put("PK_ID", 1);
        item.put("FK_ID", 10);
        item.put("NAME", "Excalibur");
        itemList.add(item);
    
        item = new HashMap<>();
        item.put("PK_ID", 2);
        item.put("FK_ID", 20);
        item.put("NAME", "Dragon Sword");
        itemList.add(item);

        return itemList;
    }

    public HashMap<String, Object> view(Integer pkId){
        HashMap<String, Object> itemDetails = new HashMap<>();

        String fkId = "FK_0382";
        String name = "Commons";
        itemDetails.put("PK_ID", pkId);
        itemDetails.put("FK_ID", fkId);
        itemDetails.put("NAME", name);

        return itemDetails;
    }
}
