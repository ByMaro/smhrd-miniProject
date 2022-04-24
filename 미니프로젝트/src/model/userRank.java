package model;

public class userRank {
	private int rank;
	private String nickName;
	private int score;
	
	public String toString() {
		return rank+"\t¦¢"+nickName+"\t¦¢"+score;
	}
	
	public userRank(int rank, String nickName, int score) {
		this.rank = rank;
		this.nickName = nickName;
		this.score = score;
	}
	
	public int getRank() {
		return rank;
	}
	public String getNickName() {
		return nickName;
	}
	public int getScore() {
		return score;
	}
	
	
	
}
