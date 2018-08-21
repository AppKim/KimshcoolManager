package com.kimschool.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kimschool.login.dao.LoginDAO;
import com.kimschool.login.service.LoginService;
import com.kimschool.login.vo.UserInfoVo;

@Repository
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDao;

	public UserInfoVo getUser(String userId, String password) {
		UserInfoVo userInfoVo = loginDao.getUser( userId, password );

		return userInfoVo;
	}

	@Override
	public List<UserInfoVo> searchID(String email, String birthDate) {
		List<UserInfoVo> userIdList = loginDao.searchID(email, birthDate);

		return userIdList;
	}

	@Override
	public UserInfoVo searchPW(String userId, String birthDate) {
		UserInfoVo userInfoVo = loginDao.searchPW(userId, birthDate);
		return userInfoVo;
	}

	@Override
	public boolean updatePW(String password, String userId, String birthDate) {
		boolean updatePWFlg = loginDao.updatePW(password, userId, birthDate);

		return updatePWFlg;
	}

	@Override
	public boolean insertUser(UserInfoVo userInfoVo) {
		boolean insertUserFlg = loginDao.insertUser(userInfoVo);

		return insertUserFlg;
	}

	@Override
	public boolean getUserID(String userId) {
		boolean isUserIDFlg = loginDao.getUserID(userId);

		return isUserIDFlg;
	};

}
