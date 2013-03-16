package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public List<UserVo> getUser(){
		return sqlMapClientTemplate.queryForList("admin.selectUser");
	}
}
