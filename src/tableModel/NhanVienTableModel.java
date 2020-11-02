package tableModel;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.NhanVien;
import entity.SanPham;

public class NhanVienTableModel extends AbstractTableModel{
	List<NhanVien> dsnv;
	private String[] headers = {"mã nhân viên","Tên","Số điện thoại","địa chỉ","email","lương"};

	@Override
	public String getColumnName(int column) {
		return headers[column];
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return dsnv.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		NhanVien nv = dsnv.get(rowIndex);
		DecimalFormat df = new DecimalFormat("###, ###. ### VND");
		switch (columnIndex) {
		case 0: return nv.getMaNV();
		case 1: return nv.getTenNV();
		case 2: return nv.getSdtNV();
		case 3: return nv.getDiaChiNV();
		case 4: return nv.getEmailNV();
		case 5: return df.format(nv.getLuong());
		}
		return nv;
	}

	public NhanVienTableModel(List<NhanVien> dsnv) {
		super();
		this.dsnv = dsnv;
	}

	public List<NhanVien> getDsnv() {
		return dsnv;
	}

	public void setDsnv(List<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}

}
