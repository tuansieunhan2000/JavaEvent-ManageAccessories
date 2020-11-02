package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.*;

public class ChiTietHoaDonDAO {
	Connection con;
	public ChiTietHoaDonDAO() {
		// TODO Auto-generated constructor stub
		try {
			con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBHLK","sa","123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean themCTHD(ChiTietHoaDon cthd) {
		try {
			PreparedStatement stmt = con.prepareStatement("insert into ChiTietHoaDon values(?, ?, ?, ?)");
			stmt.setString(1, cthd.getHoaDon().getMaHD());
			stmt.setString(2, cthd.getSanPham().getMaSP());
			stmt.setDouble(3, cthd.getTongTien());
			stmt.setDouble(4, cthd.getDiscount());
			
			if( stmt.executeUpdate() > 0 )
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public void xoaCTHD(HoaDon hd) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete chitiethoadon where mahd like ?");
			stmt.setString(1, hd.getMaHD());
			stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public double sumHD() {
		try {
			PreparedStatement stmt = con.prepareStatement("select sum(thanhtien) as tongthanhtien from luuTruData");
			ResultSet rs = stmt.executeQuery();
			int kq = rs.getInt("tongthanhtien");
			return kq;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void xoaCTHD(String manv) {
		try {
		PreparedStatement stmt = con.prepareStatement("delete chitiethoadon where mahd in (select mahd from hoadon where manv like ?)");
		stmt.setString(1, manv);
		stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
