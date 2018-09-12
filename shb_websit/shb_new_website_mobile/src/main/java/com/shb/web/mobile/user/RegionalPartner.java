package com.shb.web.mobile.user;

import java.io.Serializable;

public class RegionalPartner implements Serializable{
	
	private static final long serialVersionUID = 7908088488365530423L;

	private Long srpId;

    private String userName;

    private String password;

    private String name;

    private String phone;

    private Integer certificatesType;

    private String noNumber;

    private String addressInfo;

    private Long slrRid;

    private String areaCode;

    private Long sriRid;

    private Long commission;

    private Long type;

    private String regTime;

    private Long isDelete;

    private String createTime;

    private String modifyTime;

    private String operator;

    private String roomadress;

    private String areaaddress;

    public Long getSrpId() {
        return srpId;
    }

    public void setSrpId(Long srpId) {
        this.srpId = srpId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getCertificatesType() {
        return certificatesType;
    }

    public void setCertificatesType(Integer certificatesType) {
        this.certificatesType = certificatesType;
    }

    public String getNoNumber() {
        return noNumber;
    }

    public void setNoNumber(String noNumber) {
        this.noNumber = noNumber == null ? null : noNumber.trim();
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo == null ? null : addressInfo.trim();
    }

    public Long getSlrRid() {
        return slrRid;
    }

    public void setSlrRid(Long slrRid) {
        this.slrRid = slrRid;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Long getSriRid() {
        return sriRid;
    }

    public void setSriRid(Long sriRid) {
        this.sriRid = sriRid;
    }

    public Long getCommission() {
        return commission;
    }

    public void setCommission(Long commission) {
        this.commission = commission;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getRoomadress() {
        return roomadress;
    }

    public void setRoomadress(String roomadress) {
        this.roomadress = roomadress == null ? null : roomadress.trim();
    }

    public String getAreaaddress() {
        return areaaddress;
    }

    public void setAreaaddress(String areaaddress) {
        this.areaaddress = areaaddress == null ? null : areaaddress.trim();
    }

}