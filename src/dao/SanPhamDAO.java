package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.NhanVien;
import entity.QuanLy;
import entity.SanPham;

public class SanPhamDAO {
	Connection con;
	public SanPhamDAO() {
		// TODO Auto-generated constructor stub
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBHLK","sa","123456");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("fail");
		} finally {
			System.out.println("success");
		}
	}

}
