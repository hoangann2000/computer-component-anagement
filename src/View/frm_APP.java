package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.events.StartDocument;

import entity.NhanVien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;

public class frm_APP extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlMenu;
	private JPanel pnlCuaHang;
	private JPanel pnlTrangChu;
	private JPanel pnlHoaDon;
	private JPanel pnlLinhKien;
	private JPanel pnlKhachHang;
	private JPanel pnlNhanVien;
	private JPanel pnlMHChinh;

	private JLabel lblCuaHang;
	private JLabel lblTrangChu;
	private JLabel lblHoaDon;
	private JLabel lblLinhKien;
	private JLabel lblKhachHang;
	private JLabel lblNhanVien;
	private JPanel pnlDangXuat;
	private JLabel lblDangXuat;
	private NhanVien nhanVien;
	private JLabel lblNgay;
	private JLabel lblNhanVienHD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new frm_APP(new NhanVien()).setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public frm_APP(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		setTitle("Quản Lý mua bán linh kiện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1445, 871);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlMenu = new JPanel();
		pnlMenu.setBackground(Color.DARK_GRAY);
		pnlMenu.setBounds(0, 0, 230, 830);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);

		pnlCuaHang = new JPanel();
		pnlCuaHang.setBackground(Color.DARK_GRAY);
		pnlCuaHang.setBounds(0, 0, 230, 58);
		pnlMenu.add(pnlCuaHang);
		pnlCuaHang.setLayout(null);

		lblCuaHang = new JLabel("");
//		lblCuaHang.setIcon(new ImageIcon(frm_APP.class.getResource("/hinh/LogoG.png")));
		lblCuaHang.setBounds(0, 0, 230, 58);
		pnlCuaHang.add(lblCuaHang);
		lblCuaHang.setBackground(Color.BLACK);
		lblCuaHang.setForeground(new Color(255, 255, 255));
		lblCuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuaHang.setFont(new Font("Tahoma", Font.BOLD, 24));

		pnlTrangChu = new JPanel();
		pnlTrangChu.setBackground(new Color(0, 128, 0));
		pnlTrangChu.setBounds(10, 71, 208, 53);
		pnlMenu.add(pnlTrangChu);
		pnlTrangChu.setLayout(null);

		lblTrangChu = new JLabel("Trang chủ");
//		lblTrangChu.setIcon(new ImageIcon(frm_APP.class.getResource("/hinh/baseline_home_white_36dp.png")));
		lblTrangChu.setBounds(12, 0, 196, 53);
		pnlTrangChu.add(lblTrangChu);
		lblTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrangChu.setForeground(Color.WHITE);
		lblTrangChu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTrangChu.setBackground(Color.BLACK);

		pnlHoaDon = new JPanel();
		pnlHoaDon.setLayout(null);
		pnlHoaDon.setBackground(new Color(0, 128, 0));
		pnlHoaDon.setBounds(10, 137, 208, 53);
		pnlMenu.add(pnlHoaDon);

		lblHoaDon = new JLabel("Hóa đơn");
//		lblHoaDon.setIcon(new ImageIcon(frm_APP.class.getResource("/hinh/baseline_receipt_long_white_36dp.png")));
		lblHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoaDon.setForeground(Color.WHITE);
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHoaDon.setBackground(Color.BLACK);
		lblHoaDon.setBounds(12, 0, 196, 53);
		pnlHoaDon.add(lblHoaDon);

		pnlLinhKien = new JPanel();
		pnlLinhKien.setLayout(null);
		pnlLinhKien.setBackground(new Color(0, 128, 0));
		pnlLinhKien.setBounds(10, 269, 208, 53);
		pnlMenu.add(pnlLinhKien);

		lblLinhKien = new JLabel("Linh kiện");
//		lblLinhKien.setIcon(new ImageIcon(frm_APP.class.getResource("/hinh/baseline_devices_other_white_36dp.png")));
		lblLinhKien.setHorizontalAlignment(SwingConstants.LEFT);
		lblLinhKien.setForeground(Color.WHITE);
		lblLinhKien.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLinhKien.setBackground(Color.BLACK);
		lblLinhKien.setBounds(12, 0, 196, 53);
		pnlLinhKien.add(lblLinhKien);

		pnlKhachHang = new JPanel();
		pnlKhachHang.setLayout(null);
		pnlKhachHang.setBackground(new Color(0, 128, 0));
		pnlKhachHang.setBounds(10, 203, 208, 53);
		pnlMenu.add(pnlKhachHang);

		lblKhachHang = new JLabel("Khách hàng");
//		lblKhachHang
//				.setIcon(new ImageIcon(frm_APP.class.getResource("/hinh/baseline_supervisor_account_white_36dp.png")));
		lblKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblKhachHang.setBackground(Color.BLACK);
		lblKhachHang.setBounds(12, 0, 196, 53);
		pnlKhachHang.add(lblKhachHang);

		pnlNhanVien = new JPanel();
		pnlNhanVien.setLayout(null);
		pnlNhanVien.setBackground(new Color(0, 128, 0));
		pnlNhanVien.setBounds(10, 335, 208, 53);
		pnlMenu.add(pnlNhanVien);

		lblNhanVien = new JLabel("Nhân viên");
//		lblNhanVien.setIcon(new ImageIcon(frm_APP.class.getResource("/hinh/baseline_portrait_white_36dp.png")));
		lblNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNhanVien.setBackground(Color.BLACK);
		lblNhanVien.setBounds(12, 0, 196, 53);
		pnlNhanVien.add(lblNhanVien);

		pnlDangXuat = new JPanel();
		pnlDangXuat.setLayout(null);
		pnlDangXuat.setBackground(new Color(0, 128, 0));
		pnlDangXuat.setBounds(10, 401, 208, 53);
		pnlMenu.add(pnlDangXuat);

		lblDangXuat = new JLabel("Đăng xuất");
//		lblDangXuat.setIcon(new ImageIcon(frm_APP.class.getResource("/hinh/baseline_exit_to_app_white_36dp.png")));
		lblDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDangXuat.setBackground(Color.BLACK);
		lblDangXuat.setBounds(12, 0, 196, 53);
		pnlDangXuat.add(lblDangXuat);

		pnlMHChinh = new JPanel();
		pnlMHChinh.setBackground(Color.PINK);
		pnlMHChinh.setBounds(323, 0, 1200, 830);
		contentPane.add(pnlMHChinh);

		lblDangXuat.addMouseListener(this);

		ChuyenManHinh chuyen = new ChuyenManHinh(pnlMHChinh, nhanVien);
		chuyen.setManHinh(pnlTrangChu, lblTrangChu);

		List<DanhMuc> listDanhMuc = new ArrayList<>();
		listDanhMuc.add(new DanhMuc("TrangChu", pnlTrangChu, lblTrangChu));
		listDanhMuc.add(new DanhMuc("HoaDon", pnlHoaDon, lblHoaDon));
		listDanhMuc.add(new DanhMuc("KhachHang", pnlKhachHang, lblKhachHang));
		listDanhMuc.add(new DanhMuc("LinhKien", pnlLinhKien, lblLinhKien));
		listDanhMuc.add(new DanhMuc("NhanVien", pnlNhanVien, lblNhanVien));
		listDanhMuc.add(new DanhMuc("DangXuat", pnlDangXuat, lblDangXuat));
		chuyen.setSuKien(listDanhMuc);
		DongHo();
	}

	public void DongHo() {
		JLabel lblGio = new JLabel("Giờ");
		lblGio.setForeground(Color.WHITE);
		lblGio.setHorizontalAlignment(SwingConstants.CENTER);
		lblGio.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblGio.setBounds(10, 721, 206, 44);
		pnlMenu.add(lblGio);
		
		lblNgay = new JLabel("Ngày");
		lblNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgay.setForeground(Color.WHITE);
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNgay.setBounds(10, 679, 206, 44);
		pnlMenu.add(lblNgay);
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
		lblNgay.setText(dt1.format(date));
		
		new Thread() {
			public void run() {
				while (true) {
					Calendar ca = new GregorianCalendar();
					int gio = ca.get(Calendar.HOUR_OF_DAY);
					int phut = ca.get(Calendar.MINUTE);
					int giay = ca.get(Calendar.SECOND);
					String dongHo = gio + " : " + phut + " : " + giay;
					lblGio.setText(dongHo);
				}
			}

		}.start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(lblDangXuat)) {
			int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				this.setVisible(false);
				new frm_DangNhap().setVisible(true);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
