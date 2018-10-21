package com.cc.springbootstudy.fileupload;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	@RequestMapping("/toUpload")
	public String toUpload() {
		return "/file/upload";
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest req){
		List<MultipartFile> files = ((MultipartHttpServletRequest)req).getFiles("files");
		
		BufferedOutputStream os = null;
		for(MultipartFile file : files) {
			if(!file.isEmpty()) {
				try {
					byte[] bs = file.getBytes();
					os = new BufferedOutputStream(new FileOutputStream(file.getOriginalFilename()));
					os.write(bs);
					os.close();
				}catch(Exception err) {
					err.printStackTrace();
				}
			}else {
				return "/file/failed";
			}
		}
		
		return "/file/success";
	}
}
