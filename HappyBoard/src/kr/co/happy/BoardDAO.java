package kr.co.happy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	// 싱글통 만들기
	public static BoardDAO instance = null;

	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO(); //딱 한번만 만들어준다 
		}
		return instance;
	}
	
	private BoardDAO() { }	// 기본생성자
	
	public ArrayList<BoardDTO> getBoardList(int btype, int page){
		
		ArrayList<BoardDTO> result = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnector.getConn();
			
			String query = " SELECT * from( " + 
					" SELECT" + 
					" h.*, " + 
					" ROW_NUMBER() OVER (order BY seq desc) as rnum " + 
					" FROM h_board h " + 
					" where h.BTYPE = ? " + 
					" ) where rnum between ? and ? ";
			
			conn = ps.getConnection();
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.close(conn, ps, rs);
		}
			
		return result;
		
	}
	
}
