package com.shb.web.mobile.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8838913893891691273L;

	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public String getDateBirth() {
		return dateBirth;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getEducationalBackground() {
		return educationalBackground;
	}

	public void setEducationalBackground(String educationalBackground) {
		this.educationalBackground = educationalBackground;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getResTime() {
		return resTime;
	}

	public void setResTime(String resTime) {
		this.resTime = resTime;
	}

	public String getResIp() {
		return resIp;
	}

	public void setResIp(String resIp) {
		this.resIp = resIp;
	}

	public Integer getResType() {
		return resType;
	}

	public void setResType(Integer resType) {
		this.resType = resType;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	private String username; // 账号

	private String password; // 密码

	private String nickname; // 昵称

	private String name; // 姓名

	private Integer sex; // 性别

	private String dateBirth; // 出生日期

	private String educationalBackground; // 教育背景

	private String headPortrait; // 用户头像

	private String resTime; // 注册时间

	private String resIp; // 注册IP

	private Integer resType;// 1：PC 2：IOS 3：Android

	private String createTime; // 创建时间

	private Integer userStatus;// 0：禁用 1：正常

	private String operator; // 操作人

	private String modifyTime; // 修改时间

	private Integer isDelete; // 逻辑删除

	private Integer score; // 用户评分

	private String content; // 评价内容

	private Long sreId; // 评论ID

	private Integer evaluateCount; // 评论数量

	private Long soiRid; // 订单号

	private String mailbox; // 邮箱地址

	private String userCity;// 用户所在城市

	private Integer registerType;// 1:android 2:ios

	private String usernameIntegral; // 邀请人账号

	public String getUsernameIntegral() {
		return usernameIntegral;
	}

	public void setUsernameIntegral(String usernameIntegral) {
		this.usernameIntegral = usernameIntegral;
	}

	public Long getSoiRid() {
		return soiRid;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public Integer getRegisterType() {
		return registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}

	public void setSoiRid(Long soiRid) {
		this.soiRid = soiRid;
	}

	public Integer getEvaluateCount() {
		return evaluateCount;
	}

	public void setEvaluateCount(Integer evaluateCount) {
		this.evaluateCount = evaluateCount;
	}

	public Long getSreId() {
		return sreId;
	}

	public void setSreId(Long sreId) {
		this.sreId = sreId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}