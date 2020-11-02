package tableModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.SanPham;

public class HoaDonTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String[] headers = { "Mã sản phẩm","Tên sản phẩm","Số lượng","Đơn giá","Thành tiền" };
	List<SanPham> dssp =new ArrayList<SanPham>();
	
	public List<SanPham> getDssp() {
		return dssp;
	}

	public void setDssp(List<SanPham> dssp) {
		this.dssp = dssp;
	}

	@Override
	public int getRowCount() {

		return dssp.size();
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return headers[column];
	}

	public HoaDonTableModel(List<SanPham> dssp) {
		super();
		this.dssp = dssp;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub		
		return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		SanPham sp = dssp.get(rowIndex);
		DecimalFormat df = new DecimalFormat("###, ###. ### VND");
		switch (columnIndex) {
		case 0: return sp.getMaSP();
		case 1: return sp.getTenSP();
		case 2: return sp.getSoLuong();
		case 3: return df.format(sp.getDonGia());
		case 4: return df.format(sp.getThanhTien());
		}
		return sp;

	}
	

}
