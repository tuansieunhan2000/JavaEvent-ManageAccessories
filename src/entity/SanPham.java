package entity;

public class SanPham {
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	private String maSP;
	private String tenSP;
	private double donGia;
	private int soLuongTon;
	private int soLuong;
	private String trangThai;
	private String moTaSP;
	private double thanhTien;
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getMoTaSP() {
		return moTaSP;
	}
	public void setMoTaSP(String moTaSP) {
		this.moTaSP = moTaSP;
	}
	public SanPham(String maSP, String tenSP, double donGia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
	}
	public SanPham(String maSP, String tenSP, int soLuong, double donGia, double thanhTien) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public SanPham(String maSP, String tenSP, int soLuong, double donGia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.soLuong = soLuong;
	
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSP == null) ? 0 : maSP.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		if (maSP == null) {
			if (other.maSP != null)
				return false;
		} else if (!maSP.equalsIgnoreCase(other.maSP))
			return false;
		return true;
	}

	public SanPham(String maSP, String tenSP, double donGia, int soLuongTon, int soLuong, String trangThai,
			String moTaSP, double thanhTien) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.soLuongTon = soLuongTon;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
		this.moTaSP = moTaSP;
		this.thanhTien = thanhTien;
	}
	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}
	public SanPham() {
		super();
	}
	
	
}
