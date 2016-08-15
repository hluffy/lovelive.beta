package lovelive.controller;

import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("getPictureToJsp.lovelive")
	public void getPictureToJsp(HttpServletRequest request,HttpServletResponse response){
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		String path = "C:/Users/carol/Desktop/image/lovelive1.jpg";
		
		try {
			fis = new FileInputStream(path);
			int i = fis.available();
			byte[] data = new byte[i];
			fis.read(data);
			fis.close();
			
			sos = response.getOutputStream();
			sos.write(data);
			sos.flush();
			sos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("openTestView.lovelive")
	public String openTestView(){
		return "/html/test.jsp";
	}

}
