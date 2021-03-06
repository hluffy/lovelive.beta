package lovelive.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoveLiveMusicController {
	
	@RequestMapping("lovelivecall.lovelive")
	public String openLoveLiveCall() throws Exception{
		return "/html/lovelivecall.jsp";
	}
	
	@RequestMapping("openchatroom.lovelive")
	public String openChatRoom() throws Exception{
		return "/html/chatroom.jsp";
	}
	
	
	@RequestMapping("ll.lovelive")
	public String openLoveLiveView(Model model) throws Exception{
//		model.addAttribute("musicPath","http://localhost:8080/lovelive.beta/getLLMusicToJsp.lovelive?src=");
		model.addAttribute("path","http://localhost:8080/lovelive.beta/getLLPictureToJsp.lovelive?src=");
		return "/html/lovelive.jsp";
	}
	
	@RequestMapping("getLoveLiveMusicName.lovelive")
	@ResponseBody
	public String getLoveLiveMusicName(String src) throws Exception{
		String path = "E:/java/music";
		File file = new File(path);
		File[] musics = file.listFiles();
		for(int i =0 ;i<musics.length;i++){
			String musicName = musics[i].getName();
			if(musicName.contains(src)){
				return path+"/"+musicName;
			}
		}
		return null;
	}
	
	@RequestMapping("getLLLive.lovelive")
	@ResponseBody
	public void getLLLive(String src,HttpServletResponse response) throws Exception{
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		
		String path = "D:/BDdownloads/【6th】μ's Final LoveLive! 〜μ'sic forever♪♪♪♪♪♪♪♪♪〜_Day1_Part1.mp4";
		try {
			fis = new FileInputStream(path);
			sos = response.getOutputStream();
			int i = 0;
			byte[] data = new byte[99999999];
			while((i = fis.read(data))!=-1){
				sos.write(data,0,i);
			}
			fis.read(data);
			fis.close();
			sos.flush();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			fis = new FileInputStream(path);
//			int i = fis.available();
//			byte[] data = new byte[i];
//			fis.read(data);
//			fis.close();
//			
//			sos = response.getOutputStream();
//			sos.write(data);
//			sos.flush();
//			sos.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	@RequestMapping("getLoveLiveCallPdf.lovelive")
	@ResponseBody
	public void getLLCall(String src,HttpServletResponse response) throws Exception{
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		
		String path = "C:/Users/carol/Desktop/lovelive call/call_leader_project.pdf";
		
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
			e.printStackTrace();
		}
	}
	
	@RequestMapping("getLLPictureToJsp.lovelive")
	public void getLLPictureToJsp(String src,HttpServletRequest request,HttpServletResponse response) throws Exception{
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		
		String path ="C:/Users/carol/Desktop/image";
		if(src.isEmpty()){
			throw new Exception("src is null");
		}
		
//		File file = new File(path);
//		File[] pictures = file.listFiles();
//		for(int i = 0;i <pictures.length;i++){
//			String picturesName = pictures[i].getName();
//			if(picturesName.contains(src)){
//				src = pictures[i].getName();
//			}
//		}
		
		path = path +"/" + src;
		
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
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("getLLMusicToJsp.lovelive")
	public void getLLMusicToJsp(String src,HttpServletRequest request,HttpServletResponse response) throws Exception{
		src = URLDecoder.decode(src,"UTF-8");
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		boolean flag = false;
		String path = "E:/BaiduYunDownload/lovelive mp3/lovelivemusic";
		File file = new File(path);
		File[] musices = file.listFiles();
		for(int i =0;i<musices.length;i++){
			String name = musices[i].getName();
			if(name.contains(src)){
				path = path + "/" + name;
				flag = true;
				break;
			};
			
		}
		
		if(flag){
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
				e.printStackTrace();
			}
			
		}else{
			throw new Exception("path is error");
		}
	}

}
