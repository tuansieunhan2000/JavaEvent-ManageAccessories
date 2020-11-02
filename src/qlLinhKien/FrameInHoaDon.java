package qlLinhKien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.LuuTruDataDAO;
import tableModel.HoaDonTableModel;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class FrameInHoaDon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LuuTruDataDAO dao;
	private HoaDonTableModel model;
	private String tenkh;
	private String diachi;
	private String sdt;
	private double chietkhau;
	private double thanhtien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInHoaDon frame = new FrameInHoaDon("","","",0,0);
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
	public FrameInHoaDon(String tenkh, String diachi, String sdt, double chietkhau, double thanhtien) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameInHoaDon.class.getResource("/images/logoBrand.png")));
		setTitle("Hóa Đơn Khách Hàng");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 778, 664);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHan = new JLabel("HÓA ĐƠN MUA HÀNG");
		lblHan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHan.setBounds(285, 25, 250, 50);
		contentPane.add(lblHan);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setBounds(47, 133, 96, 23);
		contentPane.add(lblTnKhchHng);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(47, 166, 96, 23);
		contentPane.add(lblaCh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(424, 133, 96, 23);
		contentPane.add(lblSinThoi);
		
		JLabel lblTenKH_in = new JLabel("_");
		lblTenKH_in.setBounds(171, 133, 243, 23);
		contentPane.add(lblTenKH_in);
		
		JLabel lblDiaChiKH_in = new JLabel("_");
		lblDiaChiKH_in.setBounds(171, 166, 570, 23);
		contentPane.add(lblDiaChiKH_in);
		
		JLabel lblSdt_In = new JLabel("_");
		lblSdt_In.setBounds(548, 133, 193, 23);
		contentPane.add(lblSdt_In);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 199, 714, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(121);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setFont(lblKhchHng.getFont().deriveFont(lblKhchHng.getFont().getStyle() | Font.BOLD));
		lblKhchHng.setBounds(518, 485, 79, 30);
		contentPane.add(lblKhchHng);
		
		JLabel lblNewLabel = new JLabel("(Kí & ghi rõ họ tên)");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() & ~Font.BOLD | Font.ITALIC));
		lblNewLabel.setBounds(508, 501, 149, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblChitKhu = new JLabel("Chiết khấu:  ");
		lblChitKhu.setBounds(74, 398, 111, 30);
		contentPane.add(lblChitKhu);
		
		JLabel lblChietKhau_In = new JLabel("_");
		lblChietKhau_In.setBounds(195, 398, 111, 30);
		contentPane.add(lblChietKhau_In);
		
		JLabel lblThnhTin = new JLabel("Thành tiền");
		lblThnhTin.setBounds(74, 430, 111, 30);
		contentPane.add(lblThnhTin);
		
		JLabel lblThanhTien_in = new JLabel("_");
		lblThanhTien_in.setForeground(Color.RED);
		lblThanhTien_in.setBounds(195, 430, 191, 30);
		contentPane.add(lblThanhTien_in);
		
		this.tenkh = tenkh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.chietkhau = chietkhau;
		this.thanhtien = thanhtien;
		
		DecimalFormat df= new DecimalFormat("###, ###. ### VND");
		lblTenKH_in.setText(tenkh);
		lblDiaChiKH_in.setText(diachi);
		lblSdt_In.setText(sdt);
		lblChietKhau_In.setText(chietkhau+"");
		lblThanhTien_in.setText(df.format(thanhtien));
		
		
		dao = new LuuTruDataDAO();
		model = new HoaDonTableModel(dao.getDSSP());
		table.setModel(model);
		
		JLabel lblNhanVien_in = new JLabel("Nhân viên");
		lblNhanVien_in.setFont(lblKhchHng.getFont().deriveFont(lblKhchHng.getFont().getStyle() | Font.BOLD));
		lblNhanVien_in.setBounds(160, 485, 79, 30);
		contentPane.add(lblNhanVien_in);
		
		JLabel lblNewLabel_1 = new JLabel("(Kí & ghi rõ họ tên)");
		lblNewLabel_1.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() & ~Font.BOLD | Font.ITALIC));
		lblNewLabel_1.setBounds(149, 501, 142, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrameInHoaDon.class.getResource("/images/logoBrand.png")));
		label.setBounds(48, 25, 163, 50);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(27, 131, 714, 342);
		contentPane.add(panel);
		
	}
}
