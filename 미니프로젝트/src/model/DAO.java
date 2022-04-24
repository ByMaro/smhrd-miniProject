package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	
	private void getConn() {		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "cgi_2_0418_4";
			String pw = "smhrd4";
			
			conn = DriverManager.getConnection(url, id, pw);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void getclose() {
		
		try {
			if(rs != null)
				rs.close();
			
			if(psmt != null)
				psmt.close();
			
			if(conn != null)
				conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//rank 조회
	
	public ArrayList<userRank> getRankingList() {
		ArrayList<userRank> rankUserList = new ArrayList<userRank>();
		
		try {
			getConn();
			
			String sql = "select * from music_ranking_list";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				rankUserList.add(new userRank(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			getclose();
			
		};
		
		
		return rankUserList;		
	};
	
	
	//유저 설정
	public int join(String id, String pw, String nick) {
		cnt = 0;
		
		try {
			getConn();
				String sql = "select * from userinfo where id = ? or nickname = ?";
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1,id);
				psmt.setString(2, nick);
				
				rs = psmt.executeQuery();
				
			if(!rs.next()) {
				sql = "insert into userinfo(id, pw, nickname) values(?,?,?)";
				psmt = conn.prepareStatement(sql);

				psmt.setString(1,id);
				psmt.setString(2,pw);
				psmt.setString(3,nick);
				
				cnt = psmt.executeUpdate();
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			getclose();
		}
		
		return cnt;
	}
	

	public String userLogin(String id, String pw) {
		String nickname = null;
		
		try {
			getConn();
			
			String sql = "select nickname from userinfo where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();

			if(rs.next()) {
				nickname = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
		
		
		return nickname;
	}
	
	
	public int updateScore(String id, String nickname, int score) {
		cnt = 0;
		try {
			getConn();
			
			String sql = "select score from userinfo where id = ? and nickname = ?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, nickname);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1)<score) {
					sql = "update userinfo set score = ? where id = ? and nickname = ?";
					
					psmt = conn.prepareStatement(sql);
					
					psmt.setInt(1, score);
					psmt.setString(2, id);
					psmt.setString(3, nickname);
					
					cnt = psmt.executeUpdate();
					
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			getclose();
		}
		
		
		return cnt;
	}
	
	
	public ArrayList<Integer> musicId() {
	      ArrayList<Integer> al = new ArrayList<Integer>();
	      
	      try {
	         getConn();
	         
	         String sql = "select music_id from musicinfo";
	         
	         psmt = conn.prepareStatement(sql);
	         
	         rs = psmt.executeQuery();
	         
	         while(rs.next()) {
	            int m_id = rs.getInt("music_id");
	                     
	            al.add(m_id);

	         }
	         
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         getclose();
	      }
	      
	      return al;
	   }
	
	
	
	public musicDTO musicIdQuestion(int musicId) {
	      musicDTO buf = null;
	      
	      try {
	         getConn();
	         
	         String sql = "select * from musicinfo where music_id = ?";
	         
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, musicId);
	         
	         rs = psmt.executeQuery();
	         
	         while(rs.next()) {
	            buf = new musicDTO(rs.getString("music_name"),rs.getInt("music_id"), rs.getString("music_name"), rs.getString("singer"), rs.getString("music_h"), rs.getString("music_A"));
	         }
	         
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         getclose();
	      }
	      
	      return buf;
	   }
	
	
	
}
