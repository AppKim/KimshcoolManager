package com.kimschool.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimschool.login.vo.UserInfoVo;

@Repository
public class LoginDAO {

	Connection conn = null;

	private Connection getConnection() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kimschool_mm", "kimschool", "kimschool1");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading failed");
		}
		return conn;
	}

	public UserInfoVo getUser(String userId, String password) {
		System.out.println("LoginDAO getUser start");

		PreparedStatement ptmt = null;
		ResultSet rs = null;
		UserInfoVo vo = null;

		try {
			 conn = getConnection();
			 String sql = "SELECT * FROM USER_INFO " +
			 		"WHERE USER_ID = ? AND PASSWORD = ?";
			 ptmt = conn.prepareStatement(sql);
			 ptmt.setString(1, userId);
			 ptmt.setString(2, password);
			 rs = ptmt.executeQuery();
			 if(rs == null) {
				 System.out.println("data nothing");
			 }
			 while(rs.next()) {
					int idx = rs.getInt(1);
					String id = rs.getString(2);
					String pw = rs.getString(3);
					String nameKanji = rs.getString(4);
					String nameHurigana = rs.getString(5);
					String sex = rs.getString(6);
					String birthDate = rs.getString(7);
					String email = rs.getString(8);
					String kakaoId = rs.getString(9);
					String lineId = rs.getString(10);
					String address = rs.getString(11);
					String phone = rs.getString(12);

					vo = new UserInfoVo(id, pw, nameKanji, nameHurigana, sex,
							birthDate, email, kakaoId, lineId, address);
			 }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("LoginDAO getUser end");

		return vo;
	}

	@SuppressWarnings("null")
	public List<UserInfoVo> searchID(String email, String birthDate) {
		System.out.println("LoginDAO searchID start");

		PreparedStatement ptmt = null;
		ResultSet rs = null;
		List<UserInfoVo> userIdList = new ArrayList<>();

		try {
			 conn = getConnection();
			 String sql = "SELECT USER_ID FROM USER_INFO " +
			 		"WHERE EMAIL = ? AND BIRTHDATE = ?";
			 ptmt = conn.prepareStatement(sql);
			 ptmt.setString(1, email);
			 ptmt.setString(2, birthDate);
			 rs = ptmt.executeQuery();

			 if(rs == null) {
				 System.out.println("data nothing");
			 }

			 while(rs.next()) {
					String id = rs.getString(1);
					UserInfoVo vo = new UserInfoVo();
					vo.setUserId(id);
					userIdList.add(vo);
			 }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("LoginDAO searchID end");

		return userIdList;
	}

	public UserInfoVo searchPW(String userId, String birthDate) {
		System.out.println("LoginDAO searchPW start");

		PreparedStatement ptmt = null;
		ResultSet rs = null;
		UserInfoVo vo = null;

		try {
			 conn = getConnection();
			 String sql = "SELECT USER_ID, DATE_FORMAT(BIRTHDATE, '%Y%m%d') FROM USER_INFO " +
					"WHERE USER_ID = ? AND BIRTHDATE = ?";

			 ptmt = conn.prepareStatement(sql);
			 ptmt.setString(1, userId);
			 ptmt.setString(2, birthDate);
			 rs = ptmt.executeQuery();

			 if(rs == null) {
				 System.out.println("data nothing");
			 }

			 while(rs.next()) {
					String id = rs.getString(1);
					String birthdate = rs.getString(2);
					vo = new UserInfoVo();
					vo.setUserId(id);
					vo.setBirthDate(birthdate);
			 }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("LoginDAO searchPW end");

		return vo;
	}

	public boolean updatePW(String password, String userId, String birthDate) {
		System.out.println("LoginDAO updatePW start");

		PreparedStatement ptmt = null;
		boolean updatePWFlg = false;

		try {
			 conn = getConnection();
			 String sql = "UPDATE USER_INFO SET PASSWORD = ? WHERE USER_ID = ? AND BIRTHDATE = ?";

			 ptmt = conn.prepareStatement(sql);
			 ptmt.setString(1, password);
			 ptmt.setString(2, userId);
			 ptmt.setString(3, birthDate);
			 int ret = ptmt.executeUpdate();

			 if(ret > 0) {
				 updatePWFlg = true;
			 }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("LoginDAO updatePW end");

		return updatePWFlg;
	}

	public boolean insertUser(UserInfoVo userInfoVo) {
		System.out.println("LoginDAO insertUser start");

		PreparedStatement ptmt = null;
		boolean insertUserFlg = false;

		try {
			 conn = getConnection();
			 String sql = "INSERT INTO USER_INFO("
			 		+ "USER_ID, "
			 		+ "PASSWORD, "
			 		+ "NAME_KANJI, "
			 		+ "NAME_HURIGANA, "
			 		+ "SEX, "
			 		+ "BIRTHDATE, "
			 		+ "EMAIL, "
			 		+ "KAKAO_ID,"
			 		+ "LINE_ID, "
			 		+ "ADDRESS, "
			 		+ "PHONE, "
			 		+ "DEL_FLAG, "
			 		+ "REG_DATE, "
			 		+ "UPD_DATE, "
			 		+ "DEL_DATE) "
			 		+ "VALUES( "
			 		+ "?, ?, ?, ?, ?, CAST(? AS DATE), ?, ?, ?, ?, 'XXX-XXXX-XXXX', "
			 		+ "'N', CAST(NOW() AS DATE), CAST(NOW() AS DATE), CAST(NOW() AS DATE))";

			 ptmt = conn.prepareStatement(sql);
			 ptmt.setString(1, userInfoVo.getUserId());
			 ptmt.setString(2, userInfoVo.getPassword());
			 ptmt.setString(3, userInfoVo.getNameKanji());
			 ptmt.setString(4, userInfoVo.getNameHurigana());
			 ptmt.setString(5, userInfoVo.getSex());
			 ptmt.setString(6, userInfoVo.getBirthDate());
			 ptmt.setString(7, userInfoVo.getEmail());
			 ptmt.setString(8, userInfoVo.getKakaoId());
			 ptmt.setString(9, userInfoVo.getLineId());
			 ptmt.setString(10, userInfoVo.getAddress());

			 int ret = ptmt.executeUpdate();

			 if(ret > 0) {
				 insertUserFlg = true;
			 }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("LoginDAO insertUser end");

		return insertUserFlg;
	}

	public boolean getUserID(String userId) {
		System.out.println("LoginDAO getUserID start");

		PreparedStatement ptmt = null;
		ResultSet rs = null;
		UserInfoVo vo = null;
		boolean isUserIDFlg = false;

		try {
			 conn = getConnection();
			 String sql = "SELECT USER_ID FROM USER_INFO WHERE USER_ID = ?";

			 ptmt = conn.prepareStatement(sql);
			 ptmt.setString(1, userId);
			 rs = ptmt.executeQuery();

			 if(rs.next()) {
				 isUserIDFlg = true;
			 }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("LoginDAO getUserID end: " + isUserIDFlg);

		return isUserIDFlg;
	}
}
