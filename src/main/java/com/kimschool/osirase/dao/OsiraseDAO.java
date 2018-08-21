package com.kimschool.osirase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kimschool.osirase.vo.OsiraseVO;

@Repository
public class OsiraseDAO {

	Connection conn = null;

	private Connection getConnection() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kimschool_mm?useSSL=false", "kimschool", "kimschool1");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading failed");
		}
		return conn;
	}

	public void save(OsiraseVO vo) {

		PreparedStatement ptmt = null;

		try {

			conn = getConnection();
			String sql = "INSERT INTO osirase (title,user_id,content,file,file_path) VALUES(?,?,?,?,?)";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, vo.getTitle());
			ptmt.setString(2, "管理者");
			ptmt.setString(3, vo.getContent());
			ptmt.setString(4, "test.txt");
			ptmt.setString(5, "test");
			ptmt.executeUpdate();
			/*if (ptmt.executeUpdate() != 0) {
				System.out.println("insert success");
			}*/

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public List<OsiraseVO> listAll() {

		PreparedStatement ptmt = null;
		ResultSet rs = null;
		List<OsiraseVO> list = new ArrayList<OsiraseVO>();
		try {

			 conn = getConnection();
			 String sql = "SELECT idx,title,user_id,count,reg_date FROM osirase";
			 ptmt = conn.prepareStatement(sql);
			 rs = ptmt.executeQuery();

			 while(rs.next()) {
				 OsiraseVO vo = new OsiraseVO();
				 vo.setIdx(rs.getInt(1));
				 vo.setTitle(rs.getString(2));
				 vo.setUser_id(rs.getString(3));
				 vo.setCount(rs.getInt(4));
				 vo.setReg_date(rs.getDate(5));

				 list.add(vo);
			 }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list;
	}

	public OsiraseVO view(int idx){

		PreparedStatement ptmt = null;
		ResultSet rs = null;
		OsiraseVO vo = new OsiraseVO();

		try {

			conn = getConnection();

			String sql = "SELECT * FROM osirase WHERE idx="+idx;
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();


			if(rs.next()) {

			vo.setIdx(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setUser_id(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setFile(rs.getString(5));
			vo.setCount(rs.getInt(7));
			vo.setReg_date(rs.getDate(8));

			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return vo;

	}

}
