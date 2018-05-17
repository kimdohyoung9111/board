package reply.model;

import java.util.Date;

public class ReplyVO {

	private int reply_seq;
	private int board_seq;
	private Date reply_dt;
	private String reply_content;
	private String reply_yn;
	private String mem_id;
	
	public int getReply_seq() {
		return reply_seq;
	}


	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}


	public int getBoard_seq() {
		return board_seq;
	}


	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}


	public Date getReply_dt() {
		return reply_dt;
	}


	public void setReply_dt(Date reply_dt) {
		this.reply_dt = reply_dt;
	}


	public String getReply_content() {
		return reply_content;
	}


	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}


	public String getReply_yn() {
		return reply_yn;
	}


	public void setReply_yn(String reply_yn) {
		this.reply_yn = reply_yn;
	}


	public String getMem_id() {
		return mem_id;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	@Override
	public String toString() {
		return "ReplyVO [reply_seq=" + reply_seq + ", board_seq=" + board_seq
				+ ", reply_dt=" + reply_dt + ", reply_content=" + reply_content
				+ ", reply_yn=" + reply_yn + ", mem_id=" + mem_id + "]";
	}
	
}
