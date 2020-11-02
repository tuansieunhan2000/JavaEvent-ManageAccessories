package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.SanPham;

public class LuuTruDataDAO {
	Connection con;
	public LuuTruDataDAO() {
		// TODO Auto-generated constructor stub
		try {
			con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBHLK","sa","123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean themMain(SanPham sp) {
		try {
			PreparedStatement stmt=con.prepareStatement("insert into LuuTruData values(?,?,?,?,?)");
			stmt.setString(1, sp.getMaSP());
			stmt.setString(2, sp.getTenSP());
			stmt.setDouble(4, sp.getDonGia());
			stmt.setInt(3, sp.getSoLuong());
			stmt.setDouble(5, sp.getDonGia()*sp.getSoLuong());
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
			PreparedStatement stmt=con.prepareStatement("select masp,tensp,soluong,dongia, thanhtien from luuTruData");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				SanPham sp= new SanPham(rs.getString("masp"),rs.getString("tensp"),rs.getInt("soluong"),rs.getDouble("dongia"),rs.getDouble("thanhtien"));
				dssp.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssp;
	}
	public void xoaSP(String ma) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete luutrudata where masp = ?");
			stmt.setString(1, ma);
			stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getSoLuongHD() {
		try {
			PreparedStatement stmt = con.prepareStatement("select soluonghd from demsoluonghd");
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("====================================");
		}
		return 0;	
	}
	public void increaseHD() {
		try {
			PreparedStatement stmt = con.prepareStatement("update demsoluonghd set soluonghd = soluonghd + 1");
			stmt.executeQuery();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
