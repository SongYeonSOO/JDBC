package com.estsoft.ticketsystem;

public class Customer {

	private Long no;
	private String customername;
	private Long movieno;
	public Long getMovieno() {
		return movieno;
	}
	public void setMovieno(Long movieno) {
		this.movieno = movieno;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	@Override
	public String toString() {
		return "Customer [no=" + no + ", customername=" + customername + ", movieno=" + movieno + "]";
	}
	
	
}
