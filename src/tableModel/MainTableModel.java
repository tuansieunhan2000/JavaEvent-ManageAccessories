package tableModel;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import entity.*;

public class MainTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] headers = { "Mã sản phẩm","Tên sản phẩm", "Đơn giá"};
	private List<SanPham> dssp;


	public MainTableModel(List<SanPham> dssp) {
		this.dssp = dssp;
	}


	@Override
	public int getRowCount() {
		return dssp.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public String getColumnName(int column) {
		return headers[column];
	}
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SanPham sp = dssp.get(rowIndex);
		DecimalFormat df = new DecimalFormat("###,###.### VND");
		switch (columnIndex) {
		case 0: return sp.getMaSP();
		case 1: return sp.getTenSP();
		case 2: return df.format(sp.getDonGia());
		}
		return sp;
	}
	
}
