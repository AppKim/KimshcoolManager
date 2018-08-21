package com.kimschool.login.service;

import java.util.List;

import com.kimschool.login.vo.UserInfoVo;

public interface LoginService {
	public UserInfoVo getUser(String userId, String password);
	public List<UserInfoVo> searchID(String email, String birthDate);
	public UserInfoVo searchPW(String userId, String birthDate);
	public boolean updatePW(String password, String userId, String birthDate);
	public boolean insertUser(UserInfoVo userInfoVo);
	public boolean getUserID(String userId);
}
