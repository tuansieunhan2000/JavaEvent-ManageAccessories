package qlLinhKien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;
import entity.NhanVien;
import entity.QuanLy;
import tableModel.NhanVienTableModel;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrameThemNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV_them;
	private JTextField txtTenNV_them;
	private JTextField txtDiaChi_them;
	private JTextField txtEmail_them;
	private JTextField txtSDT_them;
	private JTextField txtLuong_them;
	private NhanVienDAO dao;
	private JLabel txtMess;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameThemNhanVien frame = new FrameThemNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	/**
	 * Create the frame.
	 */
	public FrameThemNhanVien() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1011, 468);
		contentPane = new JPanel();
		setTitle("Thêm nhân viên");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 998, 45);
		contentPane.add(panel);
		
		JLabel lblQuanLyThong = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQuanLyThong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblQuanLyThong);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin.setBounds(136, 133, 111, 30);
		contentPane.add(lblMNhnVin);
		
		txtMaNV_them = new JTextField();
		txtMaNV_them.setBounds(277, 130, 304, 30);
		contentPane.add(txtMaNV_them);
		txtMaNV_them.setColumns(10);
		
		txtTenNV_them = new JTextField();
		txtTenNV_them.setColumns(10);
		txtTenNV_them.setBounds(277, 170, 612, 30);
		contentPane.add(txtTenNV_them);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhnVin.setBounds(136, 173, 111, 30);
		contentPane.add(lblTnNhnVin);
		
		txtDiaChi_them = new JTextField();
		txtDiaChi_them.setColumns(10);
		txtDiaChi_them.setBounds(277, 213, 612, 30);
		contentPane.add(txtDiaChi_them);
		
		txtEmail_them = new JTextField();
		txtEmail_them.setColumns(10);
		txtEmail_them.setBounds(277, 255, 612, 30);
		contentPane.add(txtEmail_them);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(136, 255, 111, 30);
		contentPane.add(lblEmail);
		
		txtSDT_them = new JTextField();
		txtSDT_them.setColumns(10);
		txtSDT_them.setBounds(277, 295, 226, 30);
		contentPane.add(txtSDT_them);
		
		JLabel lblSdt = new JLabel("SDT");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSdt.setBounds(136, 295, 111, 30);
		contentPane.add(lblSdt);
		
		JLabel lblSdt_1 = new JLabel("Tiền Lương");
		lblSdt_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSdt_1.setBounds(513, 295, 111, 30);
		contentPane.add(lblSdt_1);
		
		txtLuong_them = new JTextField();
		txtLuong_them.setBounds(663, 298, 226, 30);
		contentPane.add(txtLuong_them);
		txtLuong_them.setColumns(10);
		
		JButton btnHuy_them = new JButton("    Hủy");
		btnHuy_them.setIcon(new ImageIcon(FrameThemNhanVien.class.getResource("/images/Cancel_24x24.png")));
		btnHuy_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameThemNhanVien.super.setVisible(false);
			}
		});
		btnHuy_them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy_them.setBackground(Color.WHITE);
		btnHuy_them.setBounds(539, 382, 182, 39);
		contentPane.add(btnHuy_them);
		
		JButton btnThemNV = new JButton("    Thêm nhân viên");
		btnThemNV.setIcon(new ImageIcon(FrameThemNhanVien.class.getResource("/images/Add_24x24.png")));
		
		dao = new NhanVienDAO();
		btnThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( validDataThemNV() ) {
					String manv = txtMaNV_them.getText();
					String ten = txtTenNV_them.getText();
					String sdt = txtSDT_them.getText();
					String diachi = txtDiaChi_them.getText();
					String email = txtEmail_them.getText();
					double luong = Double.parseDouble(txtLuong_them.getText());
					
					NhanVien nv = new NhanVien(manv, ten, sdt, diachi, email, luong);
					QuanLy ql = new QuanLy("QL000001");
					System.out.println("checked");
					nv.setNhaQuanLy(ql);
					if(dao.themNhanVien(nv)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						FrameThemNhanVien.super.setVisible(false);
										
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại!");
					}
					
				}
			}

		
		});
		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemNV.setBackground(Color.WHITE);
		btnThemNV.setBounds(256, 382, 226, 39);
		contentPane.add(btnThemNV);
		
		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(136, 210, 111, 30);
		contentPane.add(lblaCh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(423, 505, -18, 30);
		contentPane.add(panel_1);
		
		JLabel lblThmNhnVin = new JLabel("    Thêm nhân viên");
		lblThmNhnVin.setIcon(new ImageIcon(FrameThemNhanVien.class.getResource("/images/Add_24x24.png")));
		lblThmNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThmNhnVin.setBounds(78, 55, 211, 45);
		contentPane.add(lblThmNhnVin);
		
		txtMess = new JLabel("");
		txtMess.setBackground(Color.WHITE);
		txtMess.setFont(txtMess.getFont().deriveFont(txtMess.getFont().getStyle() | Font.ITALIC));
		txtMess.setForeground(Color.RED);
		txtMess.setBounds(136, 335, 753, 23);
		contentPane.add(txtMess);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(78, 119, 853, 253);
		contentPane.add(panel_2);
	}

	protected boolean validDataThemNV() {
		String maNV= txtMaNV_them.getText().trim();
		String tenNV=txtTenNV_them.getText().trim();
		String diaChiNV=txtDiaChi_them.getText().trim();
		String emailNV=txtEmail_them.getText().trim();
		String luong=txtLuong_them.getText().trim();
		String sdt=txtSDT_them.getText().trim();
		
		if(!(maNV.length()>0 )) {
			showMessage("Lỗi: Mã nhân viên không được để trống", txtMaNV_them);
			return false;
		}else if(!(maNV.matches("^NV\\d{6}$"))){
			showMessage("Lỗi: Mã nhân viên phải bắt đầu bằng NV sau đó là 6 chữ số", txtMaNV_them);
			return false;
		}
		

		if(!(tenNV.length()>0 )) {
			showMessage("Lỗi: Tên nhân viên không được để trống và không được chứa kí tự đặc biệt", txtTenNV_them);
			return false;
		}else if(!tenNV.matches("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$")) {			
			showMessage("Lỗi: Tên nhân viên không được chứa kí tự đặc biệt", txtTenNV_them);
			return false;		
		}
		if(!(diaChiNV.length()>0 )) {
			showMessage("Lỗi: Địa chỉ không được để trống, có thể chứa dấu chấm (.), dấu phẩy (,) dấu / và - ", txtDiaChi_them);
			return false;
		}else if(!diaChiNV.matches("^[\\da-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\\\" +\\r\\n\" + \r\n" + 
				"				\"            \\\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\,-/]+$")) {
			showMessage("Lỗi: Địa chỉ chỉ có thể chứa dấu chấm (.), dấu phẩy (,), dấu / ", txtDiaChi_them);
			return false;
		}

		if(!(emailNV.length()>0 )) {
			showMessage("Lỗi: Email không được để trống và phải theo định dạng : x@gmail.com hoặc x@gmail.com.vn", txtEmail_them);
			return false;
		}else if(!emailNV.matches("^[a-zA-Z][\\w_\\.]+@((\\w{5,}.\\w{3})|(\\w{5}.\\w{3}.\\w{2}))$")) {
			showMessage("Lỗi: Email phải theo định dạng : x@gmail.com hoặc x@gmail.com.vn", txtEmail_them);
			return false;
		}
		if(!(sdt.length()>0)) {
			showMessage("Lỗi: số điện thoại không được rỗng!", txtSDT_them);
			return false;
		}else if(!sdt.matches("^(0)\\d{9,10}$")) {
			showMessage("Lỗi: Số điện thoại không được để trống từ 10-11 số, bắt đầu là 0", txtSDT_them);
			return false;
		}
		if(luong.length()>0) {
			try {
				double y= Double.parseDouble(luong);
				if(y<0) {
					showMessage("Lỗi: Lương phải >0", txtLuong_them);
					return false;
				}
			} catch (Exception e) {
				showMessage("Lương phải nhập số", txtLuong_them);
				return false;
			}
		} else {
			showMessage("Lỗi: Lương không được rỗng", txtLuong_them);
			return false;
		}
		
		return true;
	}
}
