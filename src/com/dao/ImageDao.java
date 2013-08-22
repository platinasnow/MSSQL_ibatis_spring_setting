package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import com.model.ImageVO;

@Component
public class ImageDao {

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void insertImage(ImageVO imageVO) {
		sqlMapClientTemplate.insert("image.insertImage", imageVO);
	}

	public ImageVO getImage(int imageKey) {
		return (ImageVO) sqlMapClientTemplate.queryForObject("image.getImage", imageKey);
	}

}
