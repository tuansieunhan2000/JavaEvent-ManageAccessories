package qlLinhKien;

import java.awt.BorderLayout;
import entity.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhanVienDAO;
import entity.NhanVien;
import entity.QuanLy;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FrameSuaThongTinNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final JPanel contentPane_2 = new JPanel();
	private JTextField txtMaNV_sua;
	private JTextField txtTenNV_sua;
	private JTextField txtDiaChiNV_sua;
	private JTextField txtEmailNV_sua;
	private JTextField txtSDTNV_sua;
	private JTextField txtLuongNV_sua;
	private NhanVienDAO nvdao = new NhanVienDAO();
	private JLabel txtMess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSuaThongTinNhanVien frame = new FrameSuaThongTinNhanVien("");
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
	public FrameSuaThongTinNhanVien(String ma) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameSuaThongTinNhanVien.class.getResource("/images/partner.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1008, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 998, 45);
		contentPane_1.add(panel);
		
		JLabel lblQuanLyThong = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQuanLyThong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblQuanLyThong);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin.setBounds(136, 133, 111, 30);
		contentPane_1.add(lblMNhnVin);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(277, 130, 304, 30);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(277, 170, 612, 30);
		contentPane_1.add(textField_1);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhnVin.setBounds(136, 173, 111, 30);
		contentPane_1.add(lblTnNhnVin);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(277, 213, 612, 30);
		contentPane_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(277, 255, 612, 30);
		contentPane_1.add(textField_3);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(136, 255, 111, 30);
		contentPane_1.add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(277, 295, 226, 30);
		contentPane_1.add(textField_4);
		
		JLabel lblSdt = new JLabel("SDT");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSdt.setBounds(136, 295, 111, 30);
		contentPane_1.add(lblSdt);
		
		JLabel lblSdt_1 = new JLabel("Tiền Lương");
		lblSdt_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSdt_1.setBounds(513, 295, 111, 30);
		contentPane_1.add(lblSdt_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(663, 298, 226, 30);
		contentPane_1.add(textField_5);
		
		JButton btnThoat = new JButton("Hủy");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBackground(SystemColor.activeCaption);
		btnThoat.setBounds(573, 361, 108, 29);
		contentPane_1.add(btnThoat);
		
		JButton btnThem = new JButton("Thêm nhân viên");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBackground(SystemColor.activeCaption);
		btnThem.setBounds(277, 361, 179, 29);
		contentPane_1.add(btnThem);
		
		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(136, 210, 111, 30);
		contentPane_1.add(lblaCh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(423, 505, -18, 30);
		contentPane_1.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(78, 110, 850, 231);
		contentPane_1.add(panel_4);
		
		JLabel lblThmNhnVin = new JLabel("Thêm nhân viên");
		lblThmNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThmNhnVin.setBounds(78, 55, 211, 45);
		contentPane_1.add(lblThmNhnVin);
		contentPane.add(contentPane_2, BorderLayout.CENTER);
		contentPane_2.setLayout(null);
		contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 998, 45);
		contentPane_2.add(panel_2);
		
		JLabel lblQuanLyThong_1 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQuanLyThong_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_2.add(lblQuanLyThong_1);
		
		JLabel lblMNhnVin_1 = new JLabel("Mã nhân viên:");
		lblMNhnVin_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin_1.setBounds(136, 133, 111, 30);
		contentPane_2.add(lblMNhnVin_1);
		
		txtMaNV_sua = new JTextField();
		txtMaNV_sua.setEditable(false);
		txtMaNV_sua.setColumns(10);
		txtMaNV_sua.setBounds(277, 130, 304, 30);
		contentPane_2.add(txtMaNV_sua);
		
		txtTenNV_sua = new JTextField();
		txtTenNV_sua.setColumns(10);
		txtTenNV_sua.setBounds(277, 170, 612, 30);
		contentPane_2.add(txtTenNV_sua);
		
		JLabel lblTnNhnVin_1 = new JLabel("Tên nhân viên:");
		lblTnNhnVin_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhnVin_1.setBounds(136, 173, 111, 30);
		contentPane_2.add(lblTnNhnVin_1);
		
		txtDiaChiNV_sua = new JTextField();
		txtDiaChiNV_sua.setColumns(10);
		txtDiaChiNV_sua.setBounds(277, 213, 612, 30);
		contentPane_2.add(txtDiaChiNV_sua);
		
		txtEmailNV_sua = new JTextField();
		txtEmailNV_sua.setColumns(10);
		txtEmailNV_sua.setBounds(277, 255, 612, 30);
		contentPane_2.add(txtEmailNV_sua);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail_1.setBounds(136, 255, 111, 30);
		contentPane_2.add(lblEmail_1);
		
		txtSDTNV_sua = new JTextField();
		txtSDTNV_sua.setColumns(10);
		txtSDTNV_sua.setBounds(277, 295, 226, 30);
		contentPane_2.add(txtSDTNV_sua);
		
		JLabel lblSdt_2 = new JLabel("SDT");
		lblSdt_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSdt_2.setBounds(136, 295, 111, 30);
		contentPane_2.add(lblSdt_2);
		
		JLabel lblSdt_1_1 = new JLabel("Tiền Lương");
		lblSdt_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSdt_1_1.setBounds(513, 295, 111, 30);
		contentPane_2.add(lblSdt_1_1);
		
		txtLuongNV_sua = new JTextField();
		txtLuongNV_sua.setColumns(10);
		txtLuongNV_sua.setBounds(663, 298, 226, 30);
		contentPane_2.add(txtLuongNV_sua);
		setTitle("Sửa nhân viên");
		JButton btnHuyNV_sua = new JButton("  Hủy");
		btnHuyNV_sua.setIcon(new ImageIcon(FrameSuaThongTinNhanVien.class.getResource("/images/Cancel_24x24.png")));
		btnHuyNV_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameSuaThongTinNhanVien.super.setVisible(false);
			}
		});
		btnHuyNV_sua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuyNV_sua.setBackground(Color.WHITE);
		btnHuyNV_sua.setBounds(573, 399, 188, 49);
		contentPane_2.add(btnHuyNV_sua);
		
		JButton btnSuaNV_sua = new JButton(" Sửa nhân viên");
		btnSuaNV_sua.setIcon(new ImageIcon(FrameSuaThongTinNhanVien.class.getResource("/images/pencil.png")));
		btnSuaNV_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( validDataSuaNV()) {
					
					String manv = ma;
					System.out.println(manv);
					String ten = txtTenNV_sua.getText();
					String sdt = txtSDTNV_sua.getText();
					String diachi = txtDiaChiNV_sua.getText();
					String email = txtEmailNV_sua.getText();
					double luong = Double.parseDouble(txtLuongNV_sua.getText());
					NhanVien nv = new NhanVien(manv, ten, sdt, diachi, email, luong);
					if( 	nvdao.suaNV(nv) ) {
						JOptionPane.showMessageDialog(null, "sua thanh cong!");
					} else {
						JOptionPane.showMessageDialog(null, "fail");
					}
				}	
			}
		});
		btnSuaNV_sua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSuaNV_sua.setBackground(Color.WHITE);
		btnSuaNV_sua.setBounds(273, 399, 179, 49);
		contentPane_2.add(btnSuaNV_sua);
		
		JLabel lblaCh_1 = new JLabel("Địa Chỉ");
		lblaCh_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh_1.setBounds(136, 210, 111, 30);
		contentPane_2.add(lblaCh_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(423, 505, -18, 30);
		contentPane_2.add(panel_1_1);
		
		JLabel lblSaThngTin = new JLabel("    Sửa thông tin nhân viên");
		lblSaThngTin.setIcon(new ImageIcon(FrameSuaThongTinNhanVien.class.getResource("/images/pencil.png")));
		lblSaThngTin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSaThngTin.setBounds(78, 55, 316, 45);
		contentPane_2.add(lblSaThngTin);
		
		txtMess = new JLabel("");
		txtMess.setFont(txtMess.getFont().deriveFont(txtMess.getFont().getStyle() | Font.ITALIC));
		txtMess.setForeground(Color.RED);
		txtMess.setBounds(136, 338, 753, 28);
		contentPane_2.add(txtMess);
		
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(78, 110, 870, 278);
		contentPane_2.add(panel_3);
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	protected boolean validDataSuaNV() {
		String tenNV=txtTenNV_sua.getText().trim();
		String diaChiNV=txtDiaChiNV_sua.getText().trim();
		String emailNV=txtEmailNV_sua.getText().trim();
		String luong=txtLuongNV_sua.getText().trim();
		String sdt=txtSDTNV_sua.getText().trim();
		String maNV= txtMaNV_sua.getText().trim();
		
		
		if(!(tenNV.length()>0 )) {
			showMessage("Lỗi: Tên nhân viên không được để trống và không được chứa kí tự đặc biệt", txtTenNV_sua);
			return false;
		}else if(!tenNV.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$")) {			
			showMessage("Lỗi: Tên nhân viên không được chứa kí tự đặc biệt", txtTenNV_sua);
			return false;		
		}
		if(!(diaChiNV.length()>0 )) {
			showMessage("Lỗi: Địa chỉ không được để trống, có thể chứa dấu chấm (.), dấu phẩy (,) dấu / và - ", txtDiaChiNV_sua);
			return false;
		}else if(!diaChiNV.matches("^[\\da-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\,-/]+$")) {
			showMessage("Lỗi: Địa chỉ chỉ có thể chứa dấu chấm (.), dấu phẩy (,), dấu / ", txtDiaChiNV_sua);
			return false;
		}

		if(!(emailNV.length()>0 )) {
			showMessage("Lỗi: Email không được để trống và phải theo định dạng : x@gmail.com hoặc x@gmail.com.vn", txtEmailNV_sua);
			return false;
		}else if(!emailNV.matches("^[a-zA-Z][\\w_\\.]+@((\\w{5,}.\\w{3})|(\\w{5}.\\w{3}.\\w{2}))$")) {
			showMessage("Lỗi: Email phải theo định dạng : x@gmail.com hoặc x@gmail.com.vn", txtEmailNV_sua);
			return false;
		}
		if(!(sdt.length()>0)) {
			showMessage("Lỗi: Số điện thoại không được để trống từ 10-11 số, bắt đầu là 0", txtSDTNV_sua);
			return false;
		}else if(!sdt.matches("^(0)\\d{9,10}$")) {
			showMessage("Lỗi: Số điện thoại chứa từ 10-11 số ", txtSDTNV_sua);
			return false;
		}
		if(luong.length()>0) {
			try {
				double y= Double.parseDouble(luong);
				if(y<0) {
					showMessage("Lỗi: Lương phải >0", txtLuongNV_sua);
					return false;
				}
			} catch (Exception e) {
				showMessage("Lương phải nhập số", txtLuongNV_sua);
				return false;
			}
		} else {
			showMessage("Lỗi: Lương không được rỗng", txtLuongNV_sua);
			return false;
		}
		
		return true;
	}
	
}
