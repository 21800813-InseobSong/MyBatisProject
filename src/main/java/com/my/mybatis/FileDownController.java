package com.my.mybatis;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownController {
	
	@RequestMapping(value="board/list")
	public void fileDownload(HttpServletRequest request, 
				HttpServletResponse response) throws Exception{
		String filename = request.getParameter("fileName");
		String realFilename = "";
		System.out.println(filename);
		try {
			String browser = request.getHeader("User-Agent");
			if (browser.contains("MSIE") || browser.contains("Trident")
                    || browser.contains("Chrome")) {
                filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+",
                        "%20");
            } else {
                filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
            }
		}catch(UnsupportedEncodingException ex) {
			System.out.println("UnsupportedEncodingException");
        }
        realFilename = "D:\\STS4\\" + filename;
        System.out.println(realFilename);
        File file1 = new File(realFilename);
        if (!file1.exists()) {
            System.out.println("realFilename not exist" + realFilename);
        	return ;
		}
        response.setContentType("application/octer-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(realFilename);
 
            int ncount = 0;
            byte[] bytes = new byte[512];
 
            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            System.out.println("FileNotFoundException : " + e);
        }
		
	}
}
