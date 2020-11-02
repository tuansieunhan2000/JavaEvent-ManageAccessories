package qlLinhKien;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.LuuTruDataDAO;
import dao.MainDao;
import dao.SanPhamDAO;
import entity.NhanVien;
import entity.SanPham;
import qlLinhKien.*;
import jdk.jshell.execution.JdiDefaultExecutionControl;
import tableModel.MainTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;

public class FrameMain extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiem_sp;
	private JTable table;
	private MainTableModel model;
	private MainDao mainDAO = new MainDao();
	List<SanPham> dssp = new ArrayList<SanPham>();
	private JCheckBox checkBoxSortMain;
	private JComboBox comboBoxKhoangGia;
	private SanPhamDAO sanPhamDAO =new SanPhamDAO();
	private LuuTruDataDAO luuTruDAO = new LuuTruDataDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain frame = new FrameMain();
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
	public FrameMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMain.class.getResource("/images/logoBrand.png")));
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Quản lý bán hàng");
		setBounds(100, 100, 1198, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý bán sản phẩm");
		lblNewLabel.setIcon(new ImageIcon(FrameMain.class.getResource("/images/distribution.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(72, 140, 272, 48);
		contentPane.add(lblNewLabel);

		JComboBox cboSanPham = new JComboBox();
		//bug bug bug bug bug bug bug
		cboSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboSanPham.getSelectedIndex() == 0) {
					String sql = "";
					if( checkBoxSortMain.isSelected() )
						sql = "select masp,tensp,dongia from SanPham where trangthai like '01' order by dongia";
					else 
						sql ="  select masp,tensp,dongia from SanPham where trangthai like '01'";
					model = new MainTableModel(
					mainDAO.getDSSP(sql));
					table.setModel(model);
				} else if (cboSanPham.getSelectedIndex() == 1) {
					String sql = "";
					if( checkBoxSortMain.isSelected() )
						sql = "select masp,tensp,dongia from SanPham where trangthai like '02' order by dongia";
					else 
						sql ="  select masp,tensp,dongia from SanPham where trangthai like '02'";
					model = new MainTableModel(
					mainDAO.getDSSP(sql));
					table.setModel(model);
					table.setModel(model);
				} else if (cboSanPham.getSelectedIndex() == 2) {
					String sql = "";
					if( checkBoxSortMain.isSelected() )
						sql = "select masp,tensp,dongia from SanPham where trangthai like '03' order by dongia";
					else 
						sql ="  select masp,tensp,dongia from SanPham where trangthai like '03'";
					model = new MainTableModel(
					mainDAO.getDSSP(sql));
					table.setModel(model);
				} else if (cboSanPham.getSelectedIndex() == 3) {
					String sql = "";
					if( checkBoxSortMain.isSelected() )
						sql = "select masp,tensp,dongia from SanPham where trangthai like '04' order by dongia";
					else 
						sql ="  select masp,tensp,dongia from SanPham where trangthai like '04'";
					model = new MainTableModel(
					mainDAO.getDSSP(sql));
					table.setModel(model);
				} else if (cboSanPham.getSelectedIndex() == 4) {
					String sql = "";
					if( checkBoxSortMain.isSelected() )
						sql = "select masp,tensp,dongia from SanPham where trangthai like '05' order by dongia";
					else 
						sql ="  select masp,tensp,dongia from SanPham where trangthai like '05'";
					model = new MainTableModel(
					mainDAO.getDSSP(sql));
					table.setModel(model);
				} else {
					model = new MainTableModel(mainDAO.getDSSP("select masp,tensp,dongia from SanPham"));
					table.setModel(model);
				}
			}
		});
		cboSanPham.setModel(new DefaultComboBoxModel(new String[] { "RAM ", "CPU", "HHD", "SSD", "VGA", "Tất cả" }));
		cboSanPham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboSanPham.setBounds(50, 259, 279, 39);
		contentPane.add(cboSanPham);

		JLabel lblNewLabel_1 = new JLabel("Chọn Loại Sản Phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(50, 227, 272, 27);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tìm Kiếm theo tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(50, 431, 272, 27);
		contentPane.add(lblNewLabel_1_1);

		txtTimKiem_sp = new JTextField();
		txtTimKiem_sp.setBounds(50, 466, 279, 39);
		contentPane.add(txtTimKiem_sp);
		txtTimKiem_sp.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Khoảng giá");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(50, 338, 94, 34);
		contentPane.add(lblNewLabel_2);

		JButton btnLoc_sp = new JButton("  Lọc");
		btnLoc_sp.setIcon(new ImageIcon(FrameMain.class.getResource("/images/filter.png")));
		
		btnLoc_sp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLoc_sp.setBounds(132, 593, 127, 34);
		contentPane.add(btnLoc_sp);

		JButton btnQuanLyNhanVien = new JButton("Quản Lý Nhân Viên");
		btnQuanLyNhanVien.setIcon(new ImageIcon(FrameMain.class.getResource("/images/partner.png")));
		btnQuanLyNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameLogin().setVisible(true);
				
			}
		});
		btnQuanLyNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQuanLyNhanVien.setBounds(398, 588, 244, 39);
		contentPane.add(btnQuanLyNhanVien);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 125, 785, 413);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m",
						"\u0110\u01A1n Gi\u00E1" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(83);
		table.getColumnModel().getColumn(1).setPreferredWidth(212);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		scrollPane.setViewportView(table);

		JButton btnGioHang = new JButton(" Giỏ Hàng");
		btnGioHang.setIcon(new ImageIcon(FrameMain.class.getResource("/images/supermarket.png")));
	
		btnGioHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGioHang.setBounds(684, 588, 213, 39);
		contentPane.add(btnGioHang);

		JButton btnLapHD_main = new JButton("Lập hóa đơn");
		btnLapHD_main.setIcon(new ImageIcon(FrameMain.class.getResource("/images/create.png")));
		btnLapHD_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameHoaDon().setVisible(true);
			}
		});
		btnLapHD_main.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLapHD_main.setBounds(936, 588, 213, 39);
		contentPane.add(btnLapHD_main);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(377, 565, 785, 83);
		contentPane.add(panel_1);
		
		checkBoxSortMain = new JCheckBox("Sắp xếp theo giá");
		checkBoxSortMain.setBackground(Color.WHITE);
		checkBoxSortMain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBoxSortMain.setBounds(57, 511, 272, 45);
		contentPane.add(checkBoxSortMain);
		
		 comboBoxKhoangGia = new JComboBox();
		comboBoxKhoangGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxKhoangGia.setModel(new DefaultComboBoxModel(new String[] {"Mặc Định", "Dưới 2.000.000", "Trên 2.000.000"}));
		comboBoxKhoangGia.setBounds(50, 382, 279, 39);
		contentPane.add(comboBoxKhoangGia);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setBackground(Color.WHITE);
		panel.setBounds(23, 125, 333, 194);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(23, 338, 333, 311);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrameMain.class.getResource("/images/logoBrand.png")));
		label.setBounds(88, 10, 192, 77);
		contentPane.add(label);
		
		JLabel lblCaHngLinh = new JLabel("Cửa hàng linh kiện máy tính TDT");
		lblCaHngLinh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCaHngLinh.setBounds(476, 23, 449, 43);
		contentPane.add(lblCaHngLinh);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 1184, 96);
		contentPane.add(panel_3);

		updateDataMain();
		btnLoc_sp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				btnLoc_sp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sql = "";
						if(txtTimKiem_sp.getText().trim().equals("")) {
							sql = "select masp,tensp,dongia from SanPham";
						}
						
						if(!txtTimKiem_sp.getText().trim().equals("")) {
							sql = "select masp,tensp,dongia from SanPham where tensp like '%" +txtTimKiem_sp.getText().trim() + "%'";
						}
						
						if( comboBoxKhoangGia.getSelectedIndex() == 1 ) {
							if( sql.contains("where") )
								sql += " and dongia < 2000000 ";
							else
								sql+= " where dongia < 2000000";
						}
						if( comboBoxKhoangGia.getSelectedIndex() == 2 ) {
							if( sql.contains("where") )
								sql += " and dongia > 2000000 ";
							else
								sql+= " where dongia > 2000000";
						}
							
						
						if(checkBoxSortMain.isSelected())
							sql += " order by dongia";		
						
						model = new MainTableModel(mainDAO.getDSSP(sql));
						table.setModel(model);
					}
				});
				
			}
		});
		btnGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				List<SanPham> dsTemp = mainDAO.getDSSP(1);
				if( row >= 0 && row < dsTemp.size()) {
					SanPham sp = dsTemp.get(row);
					System.out.println(sp.getSoLuong());
					luuTruDAO.themMain(sp);
					JOptionPane.showMessageDialog(null, "Thanh cong!");
				}
				
			}
		});
	}

	public void updateDataMain() {
		model = new MainTableModel(mainDAO.getDSSP());
		table.setModel(model);
	}
}
