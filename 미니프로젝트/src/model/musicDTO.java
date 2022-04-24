package model;

public class musicDTO {
	private String path;
	   private int musicid;
	   private String song;
	   private String singer;
	   private String hint;
	   private String answer;
	   
	   public String toString() {
		   return path+" | "+musicid+" | "+song+" | "+singer+" | "+hint+" | "+answer;
	   }
	   
	   
	   public musicDTO(String path, int musicid, String song, String singer, String hint, String answer) {
	      this.path = "C:\\Users\\GITCT\\Desktop\\³ë·¡\\" + path+".mp3";
	      this.musicid = musicid;
	      this.song = song;
	      this.singer = singer;
	      this.hint = hint;
	      this.answer = answer;
	   }


	   public int getMusicid() {
	      return musicid;
	   }


	   public String getSong() {
	      return song;
	   }


	   public String getSinger() {
	      return singer;
	   }


	   public String getHint() {
	      return hint;
	   }


	   public String getAnswer() {
	      return answer;
	   }


	   public String getPath() {
	      return path;
	   }
}