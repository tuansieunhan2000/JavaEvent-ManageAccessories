package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDon;
import entity.KhachHang;

public class KhachHangDAO {
	Connection con;
	public KhachHangDAO() {
		// TODO Auto-generated constructor stub
		try {
			con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBHLK","sa","123456");
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public boolean themKhachHang(KhachHang kh) {
		try {
			PreparedStatement stmt=con.prepareStatement("insert into khachhang values(?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getSdtKH());
			stmt.setString(4, kh.getDiaChiKH());
			stmt.setString(5, kh.getEmailKH());
			stmt.setString(6, "");
			int n=stmt.executeUpdate();
			if(n>0)
				return true;
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean xoaKhachHang(KhachHang kh) {
		try {
			PreparedStatement stmt=con.prepareStatement("delete khachhang where makh=?");
			stmt.setString(1, kh.getMaKH());
			int n=stmt.executeUpdate();
			if(n>0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public List<KhachHang> getDSKH() {
		List<KhachHang> dskh =new ArrayList<KhachHang>();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from khachhang");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				KhachHang kh= new KhachHang(rs.getString("makh"),rs.getString("tenkh"),rs.getString("sdt"),rs.getString("diachikh"),rs.getString("emailkh"));
				dskh.add(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dskh;
	}
	
	public int countKH() {
		try {
			PreparedStatement stmt=con.prepareStatement("select count(*) as countkh from khachhang");
			ResultSet rs=stmt.executeQuery();
			int kq = rs.getInt("countkh");
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
