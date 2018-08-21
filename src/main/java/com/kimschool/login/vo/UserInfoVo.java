package com.kimschool.login.vo;

public class UserInfoVo {
	private int idx;
	private String userId;
	private String password;
	private String nameKanji;
	private String nameHurigana;
	private String sex;
	private String birthDate;
	private String email;
	private String kakaoId;
	private String lineId;
	private String address;
	private String phone;
	private String delFlag;
	private String regDate;
	private String updDate;
	private String delDate;

	public UserInfoVo() {}

	public UserInfoVo(String userId, String password,
			String nameKanji, String nameHurigana, String sex,
			String birthDate, String email, String kakaoId, String lineId,
			String address) {
		this.userId = userId;
		this.password = password;
		this.nameKanji = nameKanji;
		this.nameHurigana = nameHurigana;
		this.sex = sex;
		this.birthDate = birthDate;
		this.email = email;
		this.kakaoId = kakaoId;
		this.lineId = lineId;
		this.address = address;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNameKanji() {
		return nameKanji;
	}
	public void setNameKanji(String nameKanji) {
		this.nameKanji = nameKanji;
	}
	public String getNameHurigana() {
		return nameHurigana;
	}
	public void setNameHurigana(String nameHurigana) {
		this.nameHurigana = nameHurigana;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKakaoId() {
		return kakaoId;
	}
	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUpdDate() {
		return updDate;
	}
	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}
	public String getDelDate() {
		return delDate;
	}
	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return "UserInfoVo [idx=" + idx + ", userId=" + userId + ", password=" + password + ", nameKanji=" + nameKanji
				+ ", nameHurigana=" + nameHurigana + ", sex=" + sex + ", birthDate=" + birthDate + ", email=" + email
				+ ", kakaoId=" + kakaoId + ", lineId=" + lineId + ", address=" + address + ", phone=" + phone
				+ ", delFlag=" + delFlag + ", regDate=" + regDate + ", updDate=" + updDate + ", delDate=" + delDate
				+ "]";
	}
}
