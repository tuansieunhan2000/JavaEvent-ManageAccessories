package entity;

public class QuanLy {
	private String maQL;
	private String tenQL;
	private String sdtQL;
	private String diaChiQL;
	private String emailQL;
	private NhanVien nhanVien;
	public String getMaQL() {
		return maQL;
	}
	public void setMaQL(String maQL) {
		this.maQL = maQL;
	}
	public String getTenQL() {
		return tenQL;
	}
	public void setTenQL(String tenQL) {
		this.tenQL = tenQL;
	}
	public String getSdtQL() {
		return sdtQL;
	}
	public void setSdtQL(String sdtQL) {
		this.sdtQL = sdtQL;
	}
	public String getDiaChiQL() {
		return diaChiQL;
	}
	public void setDiaChiQL(String diaChiQL) {
		this.diaChiQL = diaChiQL;
	}
	public String getEmailQL() {
		return emailQL;
	}
	public void setEmailQL(String emailQL) {
		this.emailQL = emailQL;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maQL == null) ? 0 : maQL.hashCode());
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
		QuanLy other = (QuanLy) obj;
		if (maQL == null) {
			if (other.maQL != null)
				return false;
		} else if (!maQL.equalsIgnoreCase(other.maQL))
			return false;
		return true;
	}
	public QuanLy(String maQL, String tenQL, String sdtQL, String diaChiQL, String emailQL) {
		super();
		this.maQL = maQL;
		this.tenQL = tenQL;
		this.sdtQL = sdtQL;
		this.diaChiQL = diaChiQL;
		this.emailQL = emailQL;
	}
	public QuanLy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuanLy(String maQL) {	
		this.maQL = maQL;
		
	}
	
}
