package com.example.co_templates.daos;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShareDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 레코드 두개 이상일 때(여러개)
    public Object getList(String sqlMapId, Object dataMap) {
        
		Object result = sqlSessionTemplate.selectList(sqlMapId, dataMap);

		return result;
	}

    // 레코드 하나
    public Object getOne(String sqlMapId, Object dataMap){
        Object result = sqlSessionTemplate.selectOne(sqlMapId, dataMap);
        return result;
    }

    // 만듬
    public Object insert(String sqlMapId, Object dataMap){
        Object result = sqlSessionTemplate.insert(sqlMapId, dataMap);
        return result;
    }

    // 수정
    public Object update(String sqlMapId, Object dataMap){
        Object result = sqlSessionTemplate.update(sqlMapId, dataMap);
        return result;
    }

    // 없앨 때
    public Object delete(String sqlMapId, Object dataMap){
        Object result = sqlSessionTemplate.delete(sqlMapId, dataMap);
        return result;
    }
}