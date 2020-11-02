package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDonDao {
	Connection con;
	public HoaDonDao() {
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBHLK","sa","123456");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
	}
	public boolean themHoaDon(HoaDon hd) {
		DecimalFormat df = new DecimalFormat("###, ###. ### VND");
		try {
			PreparedStatement stmt = con.prepareStatement("insert into hoadon values(?,?,?,?,?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setString(2, hd.getKhachHang().getMaKH());
			stmt.setString(3, hd.getNhanVien().getMaNV());
			stmt.setDate(4, hd.getNgayLapHD());
			stmt.setString(5, hd.getGhichu());
			
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<HoaDon> getDSHD(){
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from hoadon");
			ResultSet rs = stmt.executeQuery();
			while( rs.next() ) {
				HoaDon hd = new HoaDon(rs.getString("mahd"), rs.getDate("ngaylaphd"),rs.getString("ghichu"));
				KhachHang kh = new KhachHang(rs.getString("makh"));
				NhanVien nv = new NhanVien(rs.getString("manv"));
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);
				dshd.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshd;
	}
	public List<HoaDon> getDSHD(String sql){
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while( rs.next() ) {
				HoaDon hd = new HoaDon(rs.getString("mahd"), rs.getDate("ngaylaphd"),rs.getString("ghichu"));
				KhachHang kh = new KhachHang(rs.getString("makh"));
				NhanVien nv = new NhanVien(rs.getString("manv"));
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);
				dshd.add(hd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshd;
	}
	public void xoaHD(HoaDon hd) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete hoadon where mahd = ?");
			stmt.setString(1, hd.getMaHD());		
			stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetHD() {
		try {
			PreparedStatement stmt = con.prepareStatement("delete luutrudata");
			int rs = stmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xoaHD(String maNV) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete hoadon where manv like ?");
			stmt.setString(1, maNV);
			stmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
