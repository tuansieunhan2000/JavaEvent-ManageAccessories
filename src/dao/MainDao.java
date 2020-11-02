package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.*;
/*
 * trangThai = Loại sản phẩm: 01 ~ 05
 * */
public class MainDao {
	Connection con;
	public MainDao() {
		// TODO Auto-generated constructor stub
		try {
			con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBHLK","sa","123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean themMain(SanPham sp) {
		try {
			PreparedStatement stmt=con.prepareStatement("insert into SanPham value(?,?,?,?,?,?,?,?,?,?");
			stmt.setString(1, sp.getMaSP());
			stmt.setString(2, sp.getTenSP());
			stmt.setString(3, "SX000001");
			stmt.setDouble(4, sp.getDonGia());
			stmt.setInt(5, 30);
			stmt.setString(6, "");
			stmt.setString(7, sp.getTrangThai());
			stmt.setString(8, "CC000001");
			int n=stmt.executeUpdate();
			if(n>0)
				return true;
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean xoaMain(SanPham sp) {
		try {
			PreparedStatement stmt=con.prepareStatement("delete from SanPham where Masp=?");
			stmt.setString(1, sp.getMaSP());
			int n=stmt.executeUpdate();
			if(n>0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public List<SanPham> getDSSP() {
		List<SanPham> dssp =new ArrayList<SanPham>();
		try {
			PreparedStatement stmt=con.prepareStatement("select masp,tensp,dongia from SanPham");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				SanPham sp= new SanPham(rs.getString("masp"),rs.getString("tensp"),rs.getDouble("dongia"));
				dssp.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dssp;
	}
	public List<SanPham> getDSSP(int n) {
		List<SanPham> dssp =new ArrayList<SanPham>();
		try {
			PreparedStatement stmt=con.prepareStatement("select masp,tensp,soluong,dongia from sanpham");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				SanPham sp= new SanPham(rs.getString("masp"),rs.getString("tensp"),rs.getInt("soluong"),rs.getDouble("dongia"));
				dssp.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dssp;
	}
	public List<SanPham> getDSSP(String sql) {
		List<SanPham> dssp =new ArrayList<SanPham>();
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				SanPham sp= new SanPham(rs.getString("masp"),rs.getString("tensp"),rs.getDouble("dongia"));
				dssp.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dssp;
	}
	
}
