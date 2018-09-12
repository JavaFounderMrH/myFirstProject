package com.shb.web.mobile.user;

import java.io.Serializable;

public class LandlordReceivables implements Serializable {

	private static final long serialVersionUID = 661315204835646554L;

	private Byte type;// 0：银行卡 1：支付宝

	private String name;// 姓名

	private String alipayAccount;// 支付宝账号

	private String alipayUserName;// 支付宝收款姓名

	private String bankName;// 开户行名称

	private String bankBranch;// 开户支行名称

	private String bankUserName; // 开户人

	private String bankAddress; // 开户网点

	private String bankAccount; // 银行卡号

	private Long srid; // 房间ID

	public String getBankUserName() {
		return bankUserName;
	}

	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Long getSrid() {
		return srid;
	}

	public void setSrid(Long srid) {
		this.srid = srid;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlipayAccount() {
		return alipayAccount;
	}

	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

	public String getAlipayUserName() {
		return alipayUserName;
	}

	public void setAlipayUserName(String alipayUserName) {
		this.alipayUserName = alipayUserName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

}
