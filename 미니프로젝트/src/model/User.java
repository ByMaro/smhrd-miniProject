package model;

public class User {
	private String id;
	private String pw;
	private String nickName;
	private int score;
	
	public User(String id, String pw, String nickName, int score) {
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.score = score;
	}
	
	public User(String id, String pw, String nickName) {
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.score = 0;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getNickName() {
		return nickName;
	}

	public int getScore() {
		return score;
	}
	
	
}
