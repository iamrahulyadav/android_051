package model;

public class Quiz {
	int qusno;
	String qus;
	int Ans;
	int set , module;
	public Quiz(int qusno, String qus, int ans , int setno , int module) {
		super();
		this.qusno = qusno;
		this.qus = qus;
		Ans = ans;
		set= setno;
		this.module = module;
		
	}
	public int getQusno() {
		return qusno;
	}
	public void setQusno(int qusno) {
		this.qusno = qusno;
	}
	public String getQus() {
		return qus;
	}
	public void setQus(String qus) {
		this.qus = qus;
	}
	public int getSet() {
		return set;
	}
	public void setSet(int set) {
		this.set = set;
	}
	public int getAns() {
		return Ans;
	}
	public void setAns(int ans) {
		Ans = ans;
	}
	

}
