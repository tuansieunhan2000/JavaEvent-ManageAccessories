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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.DropMode;

public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private String tk1 = "admin";
	private String mk1 = "admin";
	private JPasswordField pwMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/images/Apps-Computer-Login-icon.png")));
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Đăng nhập");
		setBounds(100, 100, 769, 375);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblngNhp = new JLabel("ĐĂNG NHẬP");
		lblngNhp.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/Apps-Computer-Login-icon.png")));
		lblngNhp.setBackground(Color.RED);
		lblngNhp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblngNhp.setBounds(72, 15, 193, 53);
		contentPane.add(lblngNhp);
		
		JLabel lblTiKhon = new JLabel(" Tài khoản");
		lblTiKhon.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/user.png")));
		lblTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTiKhon.setBounds(303, 117, 150, 46);
		contentPane.add(lblTiKhon);
		
		JLabel lblMtKhu = new JLabel(" Mật khẩu ");
		lblMtKhu.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/key3.png")));
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(303, 185, 150, 46);
		contentPane.add(lblMtKhu);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(452, 123, 252, 35);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !txtTaiKhoan.getText().trim().equalsIgnoreCase(tk1) ) {
					JOptionPane.showMessageDialog(null, "Tài khoản không đúng!");
					txtTaiKhoan.selectAll();
					txtTaiKhoan.requestFocus();
				}	else if( !pwMatKhau.getText().trim().equalsIgnoreCase(mk1) ) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không đúng!");
					pwMatKhau.requestFocus();
				} else {
					FrameLogin.super.setVisible(false);
					new QuanLyNhanVien().setVisible(true);
				}
			}
		});
		btnLogin.setForeground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(374, 257, 127, 35);
		contentPane.add(btnLogin);
		
		JButton btnHuy_Login = new JButton("Hủy");
		btnHuy_Login.setForeground(Color.DARK_GRAY);
		btnHuy_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameLogin.super.setVisible(false);
			}
		});
		btnHuy_Login.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHuy_Login.setBounds(565, 257, 127, 35);
		contentPane.add(btnHuy_Login);
		
		pwMatKhau = new JPasswordField();
		pwMatKhau.setBounds(452, 190, 252, 35);
		contentPane.add(pwMatKhau);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/resizeUser.png")));
		lblNewLabel.setBounds(42, 78, 238, 233);
		contentPane.add(lblNewLabel);
	}
}
