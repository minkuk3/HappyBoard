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
	
	private BoardDAO() { }
	
	private final int LIST_CNT = 20;
	
	public ArrayList<BoardDTO> getBoardList(int btype, int page){
		
		ArrayList<BoardDTO> datas = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnector.getConn();
			
			int start = (page - 1) * LIST_CNT + 1;
			int end = page * LIST_CNT;
			
			String sql = " SELECT * from( " + 
					" SELECT" + 
					" h.*, " + 
					" ROW_NUMBER() OVER (order BY seq desc) as rnum " + 
					" FROM h_board h " + 
					" where h.BTYPE = ? " + 
					" ) where rnum between ? and ? ";
			
			conn = DBConnector.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			ps.setInt(2, start);
			ps.setInt(3, end);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBid(rs.getInt("bid"));
				dto.setSeq(rs.getInt("seq"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBregdate(rs.getString("bregdate"));
				
				datas.add(dto);
				
				/*System.out.println("dto");//확인
*/			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.close(conn, ps, rs);
		}
			
		return datas;
		
	}
	
}
