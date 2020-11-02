package entity;

public class ChiTietHoaDon {
	private double tongTien;
	private double discount;
	private HoaDon hoaDon;
	private SanPham sanPham;
	private KhachHang khachHang;
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public ChiTietHoaDon(double tongTien, double discount, HoaDon hoaDon, SanPham sanPham,KhachHang khachhang) {
		super();
		this.tongTien = tongTien;
		this.discount = discount;
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.khachHang = khachhang;
	}
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon( HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	
}
