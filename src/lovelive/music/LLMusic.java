package lovelive.music;

import java.io.File;

public class LLMusic {
	public static void main(String[] args) {
		String src = getAudioSrc("Snow");
		System.out.println(src);
	}
	
	private static String getAudioSrc(String src){
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

}
