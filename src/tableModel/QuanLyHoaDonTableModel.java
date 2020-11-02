package tableModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.ChiTietHoaDonDAO;
import dao.LuuTruDataDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;

public class QuanLyHoaDonTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<HoaDon> dshd =new ArrayList<HoaDon>();
	private LuuTruDataDAO luutrudao = new LuuTruDataDAO();
	public List<HoaDon> getDshd() {
		return dshd;
	}

	public void setDshd(List<HoaDon> dshd) {
		this.dshd = dshd;
	}

	private String[] header = {"Mã hóa đơn", "Mã Khách Hàng", "Mã Nhân Viên", "Ngày Lập Hóa Đơn","Tổng Tiền"};
	private ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
	
	public QuanLyHoaDonTableModel(List<HoaDon> dshd) {
		this.dshd = dshd;
	}

	@Override
	public int getRowCount() {	
		return dshd.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return header[column];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		HoaDon hd = dshd.get(rowIndex);	
		switch (columnIndex) {
		case 0: return hd.getMaHD();
		case 1: return hd.getKhachHang().getMaKH();
		case 2: return hd.getNhanVien().getMaNV();
		case 3: return hd.getNgayLapHD();	
		case 4: return hd.getGhichu();
		}
		return hd;
	}
}
