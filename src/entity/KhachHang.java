package entity;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String sdtKH;
	private String diaChiKH;
	private String emailKH;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdtKH() {
		return sdtKH;
	}
	public void setSdtKH(String sdtKH) {
		this.sdtKH = sdtKH;
	}
	public String getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	public String getEmailKH() {
		return emailKH;
	}
	public void setEmailKH(String emailKH) {
		this.emailKH = emailKH;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equalsIgnoreCase(other.maKH))
			return false;
		return true;
	}
	public KhachHang(String maKH, String tenKH, String sdtKH, String diaChiKH, String emailKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdtKH = sdtKH;
		this.diaChiKH = diaChiKH;
		this.emailKH = emailKH;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH) {
		super();
		// TODO Auto-generated constructor stub
		this.maKH = maKH;
	}

}
