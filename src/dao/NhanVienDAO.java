package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDon;
import entity.NhanVien;
import entity.QuanLy;


public class NhanVienDAO {
	Connection con;
	public NhanVienDAO() {
		
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBHLK","sa","123456");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("fail");
		} finally {
			System.out.println("success");
		}
	}
	public boolean themNhanVien(NhanVien nv) {
		try {
			PreparedStatement stmt = con.prepareStatement("insert into nhanvien values(?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getSdtNV());
			stmt.setString(4, nv.getDiaChiNV());
			stmt.setString(5, nv.getEmailNV());
			stmt.setString(6, nv.getNhaQuanLy().getMaQL());
			stmt.setDouble(7, nv.getLuong());
			
			int n = stmt.executeUpdate();
			if(n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<NhanVien> getDSNV(){
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from NhanVien");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NhanVien nv = new NhanVien(rs.getString("manv"),rs.getString("ten"),rs.getString("sdt"),rs.getString("diachinv"), rs.getString("emailnv"),rs.getDouble("luong"));
				
				QuanLy ql = new QuanLy(rs.getString("maql"));
				nv.setNhaQuanLy(ql);
				dsnv.add(nv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public List<NhanVien> getDSNV(String sql){
		List<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NhanVien nv = new NhanVien(rs.getString("manv"),rs.getString("ten"),rs.getString("sdt"),rs.getString("diachinv"), rs.getString("emailnv"),rs.getDouble("luong"));
				
				QuanLy ql = new QuanLy(rs.getString("maql"));
				nv.setNhaQuanLy(ql);
				dsnv.add(nv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public void xoaNV(NhanVien nv) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete from nhanvien where manv = ?");
			stmt.setString(1, nv.getMaNV());
			int n = stmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean suaNV(NhanVien nv) {
		try {
			PreparedStatement stmt = con.prepareStatement("	update nhanvien set [ten] = ?, [sdt] = ?, [diachinv] = ?, [emailnv] = ?, [luong] = ? where [maNV] = ?");
	
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getSdtNV());
			stmt.setString(3, nv.getDiaChiNV());
			stmt.setString(4, nv.getEmailNV());
			stmt.setDouble(5,  nv.getLuong());
			stmt.setString(6,  nv.getMaNV());
			
			int n = stmt.executeUpdate();
			if(n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
