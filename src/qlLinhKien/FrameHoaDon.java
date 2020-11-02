package qlLinhKien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDao;
import dao.KhachHangDAO;
import dao.LuuTruDataDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import entity.*;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import tableModel.*;

import qlLinhKien.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
public class FrameHoaDon extends JFrame {

	private JTextField txtMaHoaDon;
	private JTextField txtChietKhau;
	private JTextField txtNgayLap;

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtKHDiaChi;
	private JTextField txtKHEmail;
	private JTextField txtKHSDT;
	private JTable table;
	private JTextField txtThanhTien;
	private LuuTruDataDAO luuTruDAO = new LuuTruDataDAO();
	private HoaDonTableModel model;
	private HoaDonDao dao;
	private KhachHangDAO khachHangDAO;
	private ChiTietHoaDonDAO cthdDAO;
	private HoaDonDao hdDAO;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JComboBox cboMaNV;
	private int sizeOfListMahd;
	private JLabel txtMess;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHoaDon frame = new FrameHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameHoaDon() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 955, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		panel.setBounds(-11, 0, 975, 47);
		contentPane.add(panel);
		
		JLabel lblQunLThng = new JLabel("QUẢN LÝ THÔNG TIN HÓA ĐƠN");
		lblQunLThng.setFont(new Font("Roboto", Font.PLAIN, 31));
		panel.add(lblQunLThng);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(159, 159, 160, 23);
		contentPane.add(txtMaHoaDon);
		
		JLabel lblChitKhu = new JLabel("Chiết khấu");
		lblChitKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChitKhu.setBounds(54, 187, 108, 29);
		contentPane.add(lblChitKhu);
		
		JLabel lblNgyLp = new JLabel("Ngày lập");
		lblNgyLp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyLp.setBounds(54, 220, 108, 29);
		contentPane.add(lblNgyLp);
		
		JLabel lblMHan = new JLabel("Mã Hóa Đơn");
		lblMHan.setBounds(54, 157, 85, 23);
		contentPane.add(lblMHan);
		lblMHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtChietKhau = new JTextField();
		txtChietKhau.setColumns(10);
		txtChietKhau.setBounds(159, 192, 160, 23);
		contentPane.add(txtChietKhau);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setEditable(false);
		txtNgayLap.setEnabled(false);
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(159, 225, 160, 23);
		contentPane.add(txtNgayLap);
		
		JLabel lblMHan_1 = new JLabel("Tên khách hàng");
		lblMHan_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMHan_1.setBounds(383, 73, 151, 23);
		contentPane.add(lblMHan_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(531, 75, 366, 23);
		contentPane.add(txtTenKH);
		
		JLabel lblMHan_2 = new JLabel("Địa chỉ");
		lblMHan_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMHan_2.setBounds(383, 108, 98, 29);
		contentPane.add(lblMHan_2);
		
		txtKHDiaChi = new JTextField();
		txtKHDiaChi.setColumns(10);
		txtKHDiaChi.setBounds(531, 118, 366, 23);
		contentPane.add(txtKHDiaChi);
		
		JLabel lblMHan_3 = new JLabel("Email");
		lblMHan_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMHan_3.setBounds(383, 156, 85, 23);
		contentPane.add(lblMHan_3);
		
		txtKHEmail = new JTextField();
		txtKHEmail.setColumns(10);
		txtKHEmail.setBounds(531, 156, 366, 23);
		contentPane.add(txtKHEmail);
		
		JLabel lblMHan_3_1 = new JLabel("SDT");
		lblMHan_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMHan_3_1.setBounds(383, 197, 85, 23);
		contentPane.add(lblMHan_3_1);
		
		txtKHSDT = new JTextField();
		txtKHSDT.setColumns(10);
		txtKHSDT.setBounds(531, 197, 366, 23);
		contentPane.add(txtKHSDT);
		JLabel lblMHan_3_2_1 = new JLabel("Tổng Tiền");
		lblMHan_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMHan_3_2_1.setBounds(383, 230, 85, 29);
		contentPane.add(lblMHan_3_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 331, 897, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"T\u00EAn H\u00E0ng", "M\u00E3 S\u1ED1", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n Gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(173);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(87);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(210);
		scrollPane.setViewportView(table);
		
		JButton btnHDXoaTrang = new JButton("Xóa Trắng");
		btnHDXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtChietKhau.setText("");
				txtKHDiaChi.setText("");
				txtKHEmail.setText("");
				txtKHSDT.setText("");
				txtNgayLap.setText("");
				txtTenKH.setText("");
			}
		});
		btnHDXoaTrang.setIcon(new ImageIcon(FrameHoaDon.class.getResource("/images/eraser.png")));
		btnHDXoaTrang.setBackground(Color.WHITE);
		btnHDXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHDXoaTrang.setBounds(400, 530, 140, 43);
		contentPane.add(btnHDXoaTrang);
		khachHangDAO = new KhachHangDAO();
		cthdDAO = new ChiTietHoaDonDAO();
		hdDAO = new HoaDonDao();
		KhachHangDAO khdao = new KhachHangDAO();	
		List<KhachHang> listkh = khdao.getDSKH();
	
		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setIcon(new ImageIcon(FrameHoaDon.class.getResource("/images/invoice.png")));
		//Bug--------------------------
		//Bug--------------------------
		//Bug--------------------------
		sizeOfListMahd = luuTruDAO.getSoLuongHD();
		String maHDidentity = "HD0000" + (sizeOfListMahd+1);
		txtMaHoaDon.setText(maHDidentity);	
		  long millis=System.currentTimeMillis();  
	      java.sql.Date date=new java.sql.Date(millis);  
		btnLapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( validDataThemHD() ) {
					int counthd = hdDAO.getDSHD().size();			
					String maHD = maHDidentity;
					// Khai báo nhân viên
					
					String maNV = (String) cboMaNV.getSelectedItem();			
					// Khai báo nhân viên
					int countkh = listkh.size();
					System.out.println(" something: "  + countkh);
					String maKH = "KH0000" + (countkh+1);	
					// Khai báo khách hàng
					String tenkh = txtTenKH.getText();
					String diachikh = txtKHDiaChi.getText();
					String emailkh = txtKHEmail.getText();
					String sdtkh = txtKHSDT.getText();
					KhachHang kh = new KhachHang(maKH, tenkh, sdtkh, diachikh, emailkh);
					khdao.themKhachHang(kh);
					//OrdersDate
								      
					//test				
					double chietkhau = Double.parseDouble(txtChietKhau.getText());
					List<SanPham> listsp = luuTruDAO.getDSSP();
					double tongthanhtien = 0;
					for (SanPham sp : listsp) {
						tongthanhtien +=sp.getThanhTien();
					}
					double thanhtien  = tongthanhtien;
					//test
			
					DecimalFormat df = new DecimalFormat("###, ###. ### VND");
					HoaDon hd = new HoaDon(maHD, date,df.format((thanhtien-thanhtien*chietkhau))+"");
					hd.setKhachHang(kh);
					NhanVien nv = new NhanVien(maNV);
					hd.setNhanVien(nv);
					
				
					System.out.println(hd.getMaHD() +" " + hd.getNgayLapHD() + " " + hd.getKhachHang().getMaKH() + " " +hd.getNhanVien().getMaNV());
					if( hdDAO.themHoaDon(hd) ){
					JOptionPane.showMessageDialog(null, "lap hoa don thanh cong!");		
					luuTruDAO.increaseHD();			
					//	
					updateDataHD();
					} else {
						JOptionPane.showMessageDialog(null, "fail!");		
					}
					
					
				}
				
				
			}
		});
		btnLapHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLapHoaDon.setBackground(Color.WHITE);
		btnLapHoaDon.setBounds(54, 530, 151, 43);
		contentPane.add(btnLapHoaDon);
		setTitle("Lập hóa đơn");
		JButton btnInHoaDon = new JButton("In Hóa Đơn");
		btnInHoaDon.setIcon(new ImageIcon(FrameHoaDon.class.getResource("/images/print.png")));
	
		btnInHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInHoaDon.setBackground(Color.WHITE);
		btnInHoaDon.setBounds(575, 530, 166, 43);
		contentPane.add(btnInHoaDon);
		
		JButton btnTatCaHoaDon = new JButton("Xem Tất cả hóa đơn");
		btnTatCaHoaDon.setIcon(new ImageIcon(FrameHoaDon.class.getResource("/images/book.png")));
		btnTatCaHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//test			
				new FrameQuanLyHoaDon().setVisible(true);
			}
		});
		btnTatCaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTatCaHoaDon.setBackground(Color.WHITE);
		btnTatCaHoaDon.setBounds(64, 261, 235, 36);
		contentPane.add(btnTatCaHoaDon);
		
		JButton btnHDXoa = new JButton("Xóa");
		btnHDXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int chon = JOptionPane.showConfirmDialog(null, "bạn có chắc muốn xóa sản phẩm này không?", "xóa sản phẩm khỏi giỏ hàng", JOptionPane.YES_NO_OPTION);
				
				if( row >=0 && chon == JOptionPane.YES_NO_OPTION) {
					
					SanPham sp = luuTruDAO.getDSSP().get(row);
					luuTruDAO.xoaSP(sp.getMaSP());
					JOptionPane.showMessageDialog(null, "xoa thanh cong!");
					List<SanPham> listsp = luuTruDAO.getDSSP();
					double tongthanhtien = 0;
					for (SanPham i : listsp) {
						tongthanhtien +=i.getThanhTien();
					}
					DecimalFormat df = new DecimalFormat("###,###.### VND");
					txtThanhTien.setText(df.format(tongthanhtien)+" (Chiết khấu sẽ tính khi In)");
					updateDataHD();
				} 
			}
		});
		btnHDXoa.setForeground(Color.DARK_GRAY);
		btnHDXoa.setIcon(new ImageIcon(FrameHoaDon.class.getResource("/images/Delete_24x24.png")));
		btnHDXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHDXoa.setBackground(Color.WHITE);
		btnHDXoa.setBounds(227, 530, 140, 43);
		contentPane.add(btnHDXoa);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setForeground(Color.RED);
		txtThanhTien.setEditable(false);
		txtThanhTien.setBackground(Color.WHITE);
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(531, 232, 366, 23);
		contentPane.add(txtThanhTien);
		
		JButton btnQuayLai = new JButton(" Quay lại");
		btnQuayLai.setBackground(Color.WHITE);
		btnQuayLai.setIcon(new ImageIcon(FrameHoaDon.class.getResource("/images/Previous_24x24.png")));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameHoaDon.super.setVisible(false);
			}
		});
		btnQuayLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnQuayLai.setBounds(774, 530, 140, 43);
		contentPane.add(btnQuayLai);
		
		JLabel lblLpHan = new JLabel("Lập Hóa Đơn");
		lblLpHan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLpHan.setBounds(133, 57, 198, 47);
		contentPane.add(lblLpHan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(23, 57, 331, 50);
		contentPane.add(panel_1);
		
		 cboMaNV = new JComboBox();
		cboMaNV.setBounds(159, 126, 160, 23);
		NhanVienDAO nvdao = new NhanVienDAO();
		List<NhanVien> listnv = nvdao.getDSNV();
		for (NhanVien nv : listnv) {
			System.out.println(nv.getMaNV());
			cboMaNV.addItem(nv.getMaNV());
		}
		contentPane.add(cboMaNV);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNhnVin.setBounds(54, 123, 85, 23);
		contentPane.add(lblMNhnVin);
	
		List<SanPham> listsp = luuTruDAO.getDSSP();
		double tongthanhtien = 0;
		for (SanPham sp : listsp) {
			tongthanhtien +=sp.getThanhTien();
		}
		DecimalFormat df = new DecimalFormat("###,###.### VND");
		txtThanhTien.setText(df.format(tongthanhtien)+" (Chiết khấu sẽ tính khi In)");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(21, 123, 30, -4);
		contentPane.add(panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(23, 114, 331, 199);
		contentPane.add(panel_4);
		
		txtMess = new JLabel("");
		txtMess.setFont(txtMess.getFont().deriveFont(txtMess.getFont().getStyle() | Font.ITALIC));
		txtMess.setForeground(Color.RED);
		txtMess.setBounds(383, 275, 511, 22);
		contentPane.add(txtMess);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(364, 57, 554, 257);
		contentPane.add(panel_3);
		btnInHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validDataThemHD()) {
					String tenkh = txtTenKH.getText();
					String diachi = txtKHDiaChi.getText();
					String sdt = txtKHSDT.getText();
					double chietkhau = Double.parseDouble(txtChietKhau.getText());
					List<SanPham> listsp = luuTruDAO.getDSSP();
					double tongthanhtien = 0;
					for (SanPham sp : listsp) {
						tongthanhtien +=sp.getThanhTien();
					}
					double thanhtien  = tongthanhtien;
					new FrameInHoaDon(tenkh, diachi, sdt, chietkhau, thanhtien-chietkhau*thanhtien).setVisible(true);
					hdDAO.resetHD();
					updateDataHD();
				}			
			}
		});
		txtNgayLap.setText(sdf.format(date));
		updateDataHD();
		
	}
	protected boolean validDataThemHD() {
		String maHD= txtMaHoaDon.getText().trim();
		String chietKhau=txtChietKhau.getText().trim();
		String tenKH=txtTenKH.getText().trim();
		String diaChiKH=txtKHDiaChi.getText().trim();
		String emailKH=txtKHEmail.getText().trim();
		String sdtKH= txtKHSDT.getText().trim();
		
//		if(!(maHD.length()>0 )) {
//			showMessage("Lỗi: Mã hóa đơn không được để trống và phải bắt đầu bằng HD sau đó là 6 chữ số", txtMaHoaDon);
//			return false;
//		}else if (maHD.matches("^HD\\d{6}$")) {
//			showMessage("Lỗi: Mã hóa đơn phải bắt đầu bằng HD sau đó là 6 chữ số", txtMaHoaDon);
//			return false;
//		}
		if(chietKhau.length()>0) {
			try {
				float x=Float.parseFloat(chietKhau);
				if(!(x>=0 && x<1)) {
					showMessage("Lỗi: Chiết khấu từ 0 đến 1", txtChietKhau);
					return false;
				}
			} catch (Exception e) {
				showMessage("Lỗi: Chiết khấu phải là số", txtChietKhau);
				return false;
			}
		}
//		if(!(ngayLap.length()>0 )) {
//			showMessage("Lỗi: Ngày lập không được để trống", txtNgayLap);
//			return false;
//		}
//		else if (!ngayLap.matches("^\\d{4}-((0?[1-9])|1[01])-((0?[1-9])|[12][0-9]|3[01])$")) {
//			showMessage("Lỗi: Ngày lập theo định dạng: YYYY-MM-DD", txtNgayLap);
//			return false;
//		}
		if(!(tenKH.length()>0 )) {
			showMessage("Lỗi: Tên khách Hàng không được để trống và không được chứa kí tự đặc biệt", txtTenKH);
			return false;
		}
		else if(!tenKH.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$")) {
			showMessage("Lỗi: Tên khách Hàng không được chứa kí tự đặc biệt", txtTenKH);
			return false;
		}
		if(!(diaChiKH.length()>0)) {
			showMessage("Lỗi: Địa chỉ không được để trống và có thể chứa dấu chấm (.), dấu phẩy (,), dấu / ", txtKHDiaChi);
			return false;
		}else if(!tenKH.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$")) {
			showMessage("Lỗi: Địa chỉ chỉ có thể chứa dấu chấm (.), dấu phẩy (,), dấu / ", txtKHDiaChi);
			return false;
		}
		if(!(emailKH.length()>0 )) {
			showMessage("Lỗi: Email không được để trống ", txtKHEmail);
			return false;
		}
		else if(!emailKH.matches("^[a-zA-Z][\\w_\\.]+@((\\w{5,}.\\w{3})|(\\w{5}.\\w{3}.\\w{2}))$")) {
			showMessage("Lỗi: Email phải theo định dạng : x@gmail.com hoặc x@gmail.com.vn ", txtKHEmail);
			return false;
		}
		
		if(!(sdtKH.length()>0 )) {
			showMessage("Lỗi: Số điện thoại không được rỗng!!!!", txtKHSDT);
			return false;
		}
		else if(!sdtKH.matches("^(0)\\d{9,10}$")) {
			showMessage("Lỗi: Số điện thoại chỉ chứa từ 10-11 số và bắt đầu bằng 0 ", txtKHSDT);
			return false;
		}
		return true;
	}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	public void updateDataHD() {
		model = new HoaDonTableModel(luuTruDAO.getDSSP());
		table.setModel(model);
		
	}
}


