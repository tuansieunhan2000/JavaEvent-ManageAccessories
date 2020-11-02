package qlLinhKien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import entity.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDao;
import dao.NhanVienDAO;
import tableModel.NhanVienTableModel;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class QuanLyNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtTim_qlnv;
	private JTable table;
	private NhanVienDAO nhanVienDao;
	private NhanVienTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhanVien frame = new QuanLyNhanVien();
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
	public QuanLyNhanVien() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(QuanLyNhanVien.class.getResource("/images/partner.png")));

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Quản lý nhân viên");
		setBounds(100, 100, 952, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(372, 10, 230, 42);
		contentPane.add(lblNewLabel);

		JLabel lblTmTheoM = new JLabel("Tìm theo mã nhân viên");
		lblTmTheoM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTmTheoM.setBounds(47, 96, 175, 32);
		contentPane.add(lblTmTheoM);

		txtTim_qlnv = new JTextField();
		txtTim_qlnv.setBounds(47, 138, 325, 28);
		contentPane.add(txtTim_qlnv);
		txtTim_qlnv.setColumns(10);

		JButton btnTim_qlnv = new JButton(" Tìm");
		btnTim_qlnv.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/images/magnifying-glass.png")));

		btnTim_qlnv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTim_qlnv.setBounds(394, 138, 94, 28);
		contentPane.add(btnTim_qlnv);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 198, 908, 263);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn", "\u0110\u1ECBa ch\u1EC9", "Email",
						"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "L\u01B0\u01A1ng" }));
		scrollPane.setViewportView(table);
		nhanVienDao = new NhanVienDAO();
		model = new NhanVienTableModel(nhanVienDao.getDSNV());
		table.setModel(model);
		JButton btnThem_qlnv = new JButton("Thêm");
		btnThem_qlnv.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/images/Add_24x24.png")));
		btnThem_qlnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameThemNhanVien().setVisible(true);
			}
		});
		btnThem_qlnv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem_qlnv.setBounds(255, 514, 117, 43);
		contentPane.add(btnThem_qlnv);

		JButton btnXoa_qlnv = new JButton("Xóa");
		btnXoa_qlnv.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/images/Delete_24x24.png")));
		btnXoa_qlnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				List<NhanVien> dsnv = nhanVienDao.getDSNV();
				if (row >= 0 && row < dsnv.size()) {
					NhanVien nv = dsnv.get(row);
					System.out.println(row);
					int c = JOptionPane.showConfirmDialog(null,
							"Bạn có muốn xóa nhân viên này không?\n Lưu ý: Nếu xóa nhân viên đã lập hóa đơn, sẽ bị mất tất các hóa đơn mà nhân viên đã lập!",
							"xóa nhân viên", JOptionPane.YES_NO_OPTION);
					if (c == JOptionPane.YES_OPTION) {
						
						//test xoa nv
						ChiTietHoaDonDAO cthddao = new ChiTietHoaDonDAO();
						HoaDonDao hoadondao = new HoaDonDao();
						cthddao.xoaCTHD(nv.getMaNV());
						//
						hoadondao.xoaHD(nv.getMaNV());				
						//buggggggggg						
						nhanVienDao.xoaNV(nv);
						model = new NhanVienTableModel(nhanVienDao.getDSNV());
						table.setModel(model);
					}
				}
			}
		});
		btnXoa_qlnv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa_qlnv.setBounds(411, 514, 117, 43);
		contentPane.add(btnXoa_qlnv);

		JButton btnSua_qlnv = new JButton("Sửa");
		btnSua_qlnv.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/images/pencil.png")));
		btnSua_qlnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				List<NhanVien> dsnv = nhanVienDao.getDSNV();
				NhanVien nv = dsnv.get(row);

				new FrameSuaThongTinNhanVien(nv.getMaNV()).setVisible(true);

			}
		});
		btnSua_qlnv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua_qlnv.setBounds(567, 514, 117, 43);
		contentPane.add(btnSua_qlnv);

		JButton btnQuayLai_qlnv = new JButton("Quay lại");
		btnQuayLai_qlnv.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/images/Previous_24x24.png")));
		btnQuayLai_qlnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyNhanVien.super.setVisible(false);
			}
		});
		btnQuayLai_qlnv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQuayLai_qlnv.setBounds(728, 514, 141, 43);
		contentPane.add(btnQuayLai_qlnv);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 928, 63);
		contentPane.add(panel);

		JButton btnCapNhatLai = new JButton("Cập nhật");
		btnCapNhatLai.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/images/update.png")));

		btnCapNhatLai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCapNhatLai.setBounds(72, 514, 148, 42);
		contentPane.add(btnCapNhatLai);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 489, 908, 96);
		contentPane.add(panel_2);

		btnTim_qlnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = txtTim_qlnv.getText().trim();
				String sql = "";
				if (!t.equals("")) {
					sql = "select * from nhanvien where manv like '%" + t + "%'";
				} else {
					sql = "select * from nhanvien";
				}
				model = new NhanVienTableModel(nhanVienDao.getDSNV(sql));
				table.setModel(model);
			}
		});

		btnCapNhatLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = new NhanVienTableModel(nhanVienDao.getDSNV());
				table.setModel(model);
			}
		});

	}

}
