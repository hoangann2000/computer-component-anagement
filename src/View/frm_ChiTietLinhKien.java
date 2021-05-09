package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.LinhKien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class frm_ChiTietLinhKien extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlChiTietLK;
	private JTextField txtMaLK;
	private JTextField txtSoLuongTon;
	private JTextField txtThuongHieu;
	private JTextField txtNgayNhap;
	private JTextField txtDonGia;
	private JTextField txtBaoHanh;
	private JLabel lblChiTietLK;
	private JLabel lblMaLinhKien;
	private JLabel lblTenLinhKien;
	private JLabel lblMoTaLK;
	private JLabel lblThuongHieu;
	private JLabel lblDonGia;
	private JLabel lblNgayNhap;
	private JLabel lblSoLuongTon;
	private JLabel lblBaoHanh;
	private JLabel lblThang;
	private JTextArea txtMoTa;
	private LinhKien linhkien;
	private JTextArea txtTenLK;
	private JLabel txtLoaiLK;
	private JTextField txtLoai;
	private JButton btnThoat;
	private DecimalFormat df;
	private JPanel pnlChiTiet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new frm_ChiTietLinhKien(new LinhKien()).setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public frm_ChiTietLinhKien(LinhKien linhkien) {
		this.linhkien = linhkien;
		df = new DecimalFormat("#,##0.00");
		setTitle("Chi tiết linh kiện");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 811, 667);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlChiTietLK = new JPanel();
		pnlChiTietLK.setBackground(Color.LIGHT_GRAY);
		pnlChiTietLK.setBounds(0, 0, 803, 620);
		contentPane.add(pnlChiTietLK);
		pnlChiTietLK.setLayout(null);

		lblMaLinhKien = new JLabel("Mã linh kiện:");
		lblMaLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaLinhKien.setBounds(29, 70, 114, 25);
		pnlChiTietLK.add(lblMaLinhKien);

		lblTenLinhKien = new JLabel("Tên linh kiện:");
		lblTenLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenLinhKien.setBounds(29, 124, 134, 25);
		pnlChiTietLK.add(lblTenLinhKien);

		lblMoTaLK = new JLabel("Mô tả linh kiện:");
		lblMoTaLK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoTaLK.setBounds(29, 309, 149, 25);
		pnlChiTietLK.add(lblMoTaLK);

		lblThuongHieu = new JLabel("Thương hiệu:");
		lblThuongHieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThuongHieu.setBounds(29, 212, 134, 25);
		pnlChiTietLK.add(lblThuongHieu);

		lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDonGia.setBounds(440, 265, 91, 25);
		pnlChiTietLK.add(lblDonGia);

		lblNgayNhap = new JLabel("Ngày nhập:");
		lblNgayNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayNhap.setBounds(440, 70, 114, 25);
		pnlChiTietLK.add(lblNgayNhap);

		lblSoLuongTon = new JLabel("Số lượng tồn:");
		lblSoLuongTon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoLuongTon.setBounds(29, 265, 134, 25);
		pnlChiTietLK.add(lblSoLuongTon);

		lblBaoHanh = new JLabel("Bảo hành:");
		lblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBaoHanh.setBounds(441, 309, 114, 25);
		pnlChiTietLK.add(lblBaoHanh);

		txtMaLK = new JTextField();
		txtMaLK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaLK.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaLK.setBounds(175, 70, 182, 25);
		pnlChiTietLK.add(txtMaLK);
		txtMaLK.setColumns(10);
		txtMaLK.setEditable(false);
		txtMaLK.setText(linhkien.getMaLK());

		txtSoLuongTon = new JTextField();
		txtSoLuongTon.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuongTon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuongTon.setColumns(10);
		txtSoLuongTon.setBounds(175, 265, 182, 25);
		pnlChiTietLK.add(txtSoLuongTon);
		txtSoLuongTon.setEditable(false);
		txtSoLuongTon.setText(String.valueOf(linhkien.getSlTon()));

		txtThuongHieu = new JTextField();
		txtThuongHieu.setHorizontalAlignment(SwingConstants.CENTER);
		txtThuongHieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThuongHieu.setColumns(10);
		txtThuongHieu.setBounds(175, 212, 182, 25);
		pnlChiTietLK.add(txtThuongHieu);
		txtThuongHieu.setEditable(false);
		txtThuongHieu.setText(linhkien.getThuongHieu());

		txtNgayNhap = new JTextField();
		txtNgayNhap.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayNhap.setColumns(10);
		txtNgayNhap.setBounds(580, 70, 182, 25);
		pnlChiTietLK.add(txtNgayNhap);
		txtNgayNhap.setEditable(false);
		txtNgayNhap.setText(String.valueOf(linhkien.getNgayNhap()));

		txtDonGia = new JTextField();
		txtDonGia.setHorizontalAlignment(SwingConstants.CENTER);
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(580, 265, 182, 25);
		pnlChiTietLK.add(txtDonGia);
		txtDonGia.setEditable(false);
		txtDonGia.setText(df.format(linhkien.getDonGiaLK()));

		txtBaoHanh = new JTextField();
		txtBaoHanh.setHorizontalAlignment(SwingConstants.CENTER);
		txtBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBaoHanh.setColumns(10);
		txtBaoHanh.setBounds(580, 309, 91, 25);
		pnlChiTietLK.add(txtBaoHanh);
		txtBaoHanh.setEditable(false);
		txtBaoHanh.setText(String.valueOf(linhkien.getBaoHanh()));

		txtMoTa = new JTextArea();
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMoTa.setBounds(29, 354, 733, 203);
		pnlChiTietLK.add(txtMoTa);
		txtMoTa.setEditable(false);
		txtMoTa.setText(linhkien.getMoTaLK());

		lblThang = new JLabel("tháng.");
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThang.setBounds(705, 309, 57, 25);
		pnlChiTietLK.add(lblThang);

		btnThoat = new JButton("Thoát");
//		btnThoat.setIcon(new ImageIcon(frm_ChiTietLinhKien.class.getResource("/hinh/baseline_close_white_24dp.png")));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setBackground(Color.RED);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThoat.setBounds(648, 577, 114, 30);
		pnlChiTietLK.add(btnThoat);

		txtTenLK = new JTextArea();
		txtTenLK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenLK.setBounds(175, 122, 587, 66);
		pnlChiTietLK.add(txtTenLK);
		txtTenLK.setEditable(false);
		txtTenLK.setText(linhkien.getTenLK());

		txtLoaiLK = new JLabel("Loại:");
		txtLoaiLK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLoaiLK.setBounds(440, 212, 91, 25);
		pnlChiTietLK.add(txtLoaiLK);

		txtLoai = new JTextField();
		txtLoai.setText("0.0");
		txtLoai.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLoai.setEditable(false);
		txtLoai.setColumns(10);
		txtLoai.setBounds(580, 212, 182, 25);
		pnlChiTietLK.add(txtLoai);
		txtLoai.setText(linhkien.getLoaiLK());

		pnlChiTiet = new JPanel();
		pnlChiTiet.setBackground(new Color(0, 128, 0));
		pnlChiTiet.setBounds(0, 0, 791, 54);
		pnlChiTietLK.add(pnlChiTiet);
		pnlChiTiet.setLayout(null);

		lblChiTietLK = new JLabel("Chi tiết linh kiện");
		lblChiTietLK.setBounds(0, 0, 791, 54);
		pnlChiTiet.add(lblChiTietLK);
		lblChiTietLK.setForeground(Color.WHITE);
		lblChiTietLK.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblChiTietLK.setHorizontalAlignment(SwingConstants.CENTER);

		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
