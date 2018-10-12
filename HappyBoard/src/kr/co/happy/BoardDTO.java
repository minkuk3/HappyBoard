package kr.co.happy;

public class BoardDTO {
	// 데이터 베이스 한 행을 담을 공간 그릇같은 
	
	private int bid;
	private int btype;
	private int seq;
	private String btitle;
	private String bcontent;
	private String brefdate;
	private String pw;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getBtype() {
		return btype;
	}
	public void setBtype(int btype) {
		this.btype = btype;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBrefdate() {
		return brefdate;
	}
	public void setBrefdate(String brefdate) {
		this.brefdate = brefdate;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
