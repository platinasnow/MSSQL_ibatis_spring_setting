package com.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.dao.ImageDao;
import com.model.ImageVO;

@Controller
public class TestController {


	@Autowired
	private ImageDao imageDao;

	@RequestMapping("/index.do")
	public String Test(Model model, HttpServletResponse response, @RequestParam int key) {
		ImageVO imageList = imageDao.getImage(key);
		
		byte[] imageByte = imageList.getImageData();
		try {
			response.setHeader("Content-disposition","attachment; filename="+imageList.getImageName());
			OutputStream os = response.getOutputStream();
			os.write(imageByte);
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/WEB-INF/view/index.jsp";
	}


	@RequestMapping("/uploadPage.do")
	public String uploadPage() {
		return "/WEB-INF/view/uploadPage.jsp";
	}

	@RequestMapping("/imageUpload.do")
	public String imageUpload(MultipartRequest file_path) throws IOException {

		MultipartFile imgfile = file_path.getFile("file_path");
		
		try {
			byte[] data = imgfile.getBytes();
			ImageVO imageVO = new ImageVO();
			imageVO.setImageData(data);
			imageVO.setImageName(imgfile.getOriginalFilename());
			imageDao.insertImage(imageVO);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "redirect:index.do";
	}
}
