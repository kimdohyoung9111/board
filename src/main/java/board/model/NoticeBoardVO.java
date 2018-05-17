package board.model;

import java.util.Date;

public class NoticeBoardVO {
	private int nb_seq;
	private String nb_name;
	private Date nb_dt;
	private String nb_yn;
	private String mem_id;
	
	public int getNb_seq() {
		return nb_seq;
	}
	public void setNb_seq(int nb_seq) {
		this.nb_seq = nb_seq;
	}
	public String getNb_name() {
		return nb_name;
	}
	public void setNb_name(String nb_name) {
		this.nb_name = nb_name;
	}
	public Date getNb_dt() {
		return nb_dt;
	}
	public void setNb_dt(Date nb_dt) {
		this.nb_dt = nb_dt;
	}
	public String getNb_yn() {
		return nb_yn;
	}
	public void setNb_yn(String nb_yn) {
		this.nb_yn = nb_yn;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
}
