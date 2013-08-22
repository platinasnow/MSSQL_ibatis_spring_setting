package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import com.model.TestVO;

@Component
public class TestDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<TestVO> getTest(){
		return sqlMapClientTemplate.queryForList("test.getTest");
	}
	
	@SuppressWarnings("unchecked")
	public int insertTest(TestVO testVO ){
		Integer appCode = (Integer)sqlMapClientTemplate.queryForObject("test.insertTest", testVO);
		
		return appCode.intValue();
	}
}
