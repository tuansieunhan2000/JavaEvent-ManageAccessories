package entity;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String sdtNV;
	private String diaChiNV;
	private String emailNV;
	private QuanLy nhaQuanLy;
	private double luong;
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getSdtNV() {
		return sdtNV;
	}
	public void setSdtNV(String sdtNV) {
		this.sdtNV = sdtNV;
	}
	public String getDiaChiNV() {
		return diaChiNV;
	}
	public void setDiaChiNV(String diaChiNV) {
		this.diaChiNV = diaChiNV;
	}
	public String getEmailNV() {
		return emailNV;
	}
	public void setEmailNV(String emailNV) {
		this.emailNV = emailNV;
	}
	public QuanLy getNhaQuanLy() {
		return nhaQuanLy;
	}
	public void setNhaQuanLy(QuanLy nhaQuanLy) {
		this.nhaQuanLy = nhaQuanLy;
	}
	public NhanVien(String maNV, String tenNV, String sdtNV, String diaChiNV, String emailNV,double luong
			) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdtNV = sdtNV;
		this.diaChiNV = diaChiNV;
		this.emailNV = emailNV;
		this.luong = luong;
	}
	
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV) {
		this.maNV = maNV;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equalsIgnoreCase(other.maNV))
			return false;
		return true;
	}
}
