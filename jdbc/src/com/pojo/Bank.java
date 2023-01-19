package com.pojo;

public class Bank {
	private String bankname;
	private String acctype;
	private String branch;
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public Bank() {
		super();
	}
	public Bank(String bankname, String acctype, String branch) {
		super();
		this.bankname = bankname;
		this.acctype = acctype;
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Bank [bankname=" + bankname + ", acctype=" + acctype + ", branch=" + branch + "]";
	}
	

}
