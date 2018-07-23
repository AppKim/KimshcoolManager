package com.kimschool.sample.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimschool.sample.service.SampleService;
import com.kimschool.vo.GuestBookVO;

@Repository
public class SampleServiceImpl implements SampleService {

	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kimschool_mm", "kimschool", "kimschool1");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver loading failed");
		}
		return conn;
	}

	// 방명록 게시글 리스트를 조회하는 메서드
	  public List<GuestBookVO> getList(){
	    List<GuestBookVO> list = new ArrayList<GuestBookVO>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	      conn = getConnection();

	      String sql = "SELECT no, name, pwd, content, reg_date" +
	             " FROM guestbook" +
	             " ORDER BY no desc";

	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();

	      while(rs.next()) {
	        GuestBookVO vo = new GuestBookVO();
	        vo.setNo(rs.getInt(1));
	        vo.setName(rs.getString(2));
	        vo.setPwd(rs.getString(3));
	        vo.setContent(rs.getString(4));
	        vo.setRegDate(rs.getString(5));

	        list.add(vo);
	      }
	    }
	    catch (SQLException e) {
	      System.out.println("에러: " + e);
	    }

	    return list;
	  }
}
