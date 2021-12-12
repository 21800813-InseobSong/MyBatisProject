package com.my.mybatis.board;

import javax.servlet.http.HttpServletRequest;

public class FileUpload {
	public BoardVO uploadPhoto(HttpServletRequest request) {
		int sizeLimit = 15 * 1024 * 1024;
		String realPath = request.getServerContext().getRealPath("upload");
	}
	
	public static void deleteFile(HttpServletRequest request, String filename) {
		
	}
}
