package com;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TestDao;
import com.model.TestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"./JUnit/configuration/spring-servlet.xml", 
		"./JUnit/configuration/sqlMapConfig.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class Test {
	
	@Autowired
	private TestDao testDao;
	
	//@org.junit.Test
	public void init(){
		
	}
	

}
