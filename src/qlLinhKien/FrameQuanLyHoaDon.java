package qlLinhKien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDao;
import dao.KhachHangDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tableModel.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
public class FrameQuanLyHoaDon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtTimKiem;
	private HoaDonDao dao;
	private QuanLyHoaDonTableModel model;
	private JRadioButton radioMakh;
	private JRadioButton radioMahd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameQuanLyHoaDon frame = new FrameQuanLyHoaDon();
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
	public FrameQuanLyHoaDon() {

		setTitle("Quản lý hóa đơn");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 990, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblQunLHa = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblQunLHa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQunLHa.setBounds(372, 10, 190, 42);
		contentPane_1.add(lblQunLHa);
		
		JButton btnXoa_qlnv = new JButton("Xóa Hóa Đơn");
		btnXoa_qlnv.addActionListener(new ActionListener() {
			private HoaDonDao hddao;
			private KhachHangDAO khachhangdao;
			private ChiTietHoaDonDAO cthddao;

			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row >=0) {
					hddao = new HoaDonDao();
					 cthddao = new ChiTietHoaDonDAO();
					
					HoaDon hd = new HoaDon(hddao.getDSHD().get(row).getMaHD());
					ChiTietHoaDon cthd = new ChiTietHoaDon(hd);
					int chon = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa hóa đơn này không?", "Xóa hóa đơn", JOptionPane.YES_NO_OPTION);
					if(chon == JOptionPane.YES_OPTION) {
						cthddao.xoaCTHD(hd);
						hddao.xoaHD(hd);
						JOptionPane.showMessageDialog(null, "xóa thành công");
						dao = new HoaDonDao();
						model = new QuanLyHoaDonTableModel(dao.getDSHD());
						table.setModel(model);	
						
					}
				}
			}
		});
		btnXoa_qlnv.setIcon(new ImageIcon(FrameQuanLyHoaDon.class.getResource("/images/Delete_24x24.png")));
		btnXoa_qlnv.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnXoa_qlnv.setBounds(494, 382, 210, 49);
		contentPane_1.add(btnXoa_qlnv);
		
		JButton btnThoat_qlnv = new JButton("Quay lại");
		btnThoat_qlnv.setIcon(new ImageIcon(FrameQuanLyHoaDon.class.getResource("/images/Previous_24x24.png")));
		btnThoat_qlnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameQuanLyHoaDon.super.setVisible(false);
			}
		});
		btnThoat_qlnv.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnThoat_qlnv.setBounds(736, 382, 150, 49);
		contentPane_1.add(btnThoat_qlnv);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(-15, 0, 1006, 63);
		contentPane_1.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 85, 887, 229);
		contentPane_1.add(scrollPane);
		
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
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Kh\u00E1ch H\u00E0ng", "M\u00E3 Nh\u00E2n Vi\u00EAn", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "T\u1ED5ng Ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(129);
		scrollPane.setViewportView(table);
		
		JButton btnTim_qlnv = new JButton("Tìm");
		btnTim_qlnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="";
				if(( radioMahd.isSelected() && txtTimKiem.getText().length() == 0 ) ||
						( radioMakh.isSelected() && txtTimKiem.getText().length() == 0 )
						) {
					sql = "select * from hoadon";
				} else if ( radioMahd.isSelected() && txtTimKiem.getText().length() != 0 )
					sql = "select * from hoadon where mahd like '%" + txtTimKiem.getText().trim() + "%'" ;
				  else 
					sql = "select * from hoadon where makh like '%" + txtTimKiem.getText().trim() + "%'" ;
				dao = new HoaDonDao();
				model = new QuanLyHoaDonTableModel(dao.getDSHD(sql));
				table.setModel(model);
			}
		
		});
		btnTim_qlnv.setIcon(new ImageIcon(FrameQuanLyHoaDon.class.getResource("/images/Search_24x24.png")));
		btnTim_qlnv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim_qlnv.setBounds(295, 416, 119, 34);
		contentPane_1.add(btnTim_qlnv);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(51, 418, 234, 32);
		contentPane_1.add(txtTimKiem);
		
		 radioMakh = new JRadioButton("Mã khách hàng",true);
		radioMakh.setBackground(Color.WHITE);
		radioMakh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioMakh.setBounds(51, 389, 150, 21);
		contentPane_1.add(radioMakh);
		
		radioMahd = new JRadioButton("Mã hóa đơn");
		radioMahd.setBackground(Color.WHITE);
		radioMahd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioMahd.setBounds(210, 389, 210, 21);
		contentPane_1.add(radioMahd);
		ButtonGroup gr = new ButtonGroup();
		gr.add(radioMahd);
		gr.add(radioMakh);
		JLabel lblTmTheo = new JLabel("TÌm hóa đơn theo: ");
		lblTmTheo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTmTheo.setBounds(51, 351, 175, 32);
		contentPane_1.add(lblTmTheo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(37, 346, 388, 123);
		contentPane_1.add(panel_1);
		
		dao = new HoaDonDao();
		model = new QuanLyHoaDonTableModel(dao.getDSHD());
		table.setModel(model);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(462, 351, 456, 115);
		contentPane_1.add(panel_2);
	
	}
}
