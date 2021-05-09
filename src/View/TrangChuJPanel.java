package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Controller.ChiTietHoaDonConTrol;
import Controller.HoaDonConTrol;
import Controller.KhachHangConTrol;
import Controller.LinhKienConTrol;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.EventObject;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class TrangChuJPanel extends JPanel implements KeyListener, ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel pnlThongTinLK;
	private JPanel pnlHoaDon;
	private JPanel pnlThongTin;
	private JPanel pnlHD;
	private JPanel pnlThanhToan;
	private JLabel lblThongTinLK;
	private JLabel lblTimKiem;
	private JLabel lblHoaDon;
	private JLabel lblMaHoDon;
	private JLabel lblNgayLap;
	private JLabel lblMaKhachHang;
	private JLabel lblKhachHang;
	private JLabel lblSoDienThoai;
	private JLabel lblDiaChi;
	private JLabel lblTienThoi;
	private JLabel lblSoLuong;
	private JLabel lblTongTien;
	private JLabel lblTienKhachTra;
	private JTextField txtMaHoaDon;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtNgayLapHD;
	private JTextField txtDiaChiKH;
	private JTextField txtTrang;
	private JTextField txtTimKiem;
	private JTextField txtTongTien;
	private JTextField txtTienKhachTra;
	private JTextField txtTienThoi;
	private JTextField txtSoLuong;
	private JButton btnThanhToan;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnThem;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JButton btnXemChiTiet;
	private JButton btnTaoMoi;
	private DefaultTableModel modelThongTinLK;
	private DefaultTableModel modelHoaDon;
	private JTable tableThongTinLK;
	private JTable tableHoaDon;
	private JScrollPane scrollPaneLK;
	private JScrollPane scrollPaneHoaDon;
	private JComboBox<String> cboTimKiem;
	private LinhKienConTrol linhKienDao;
	private KhachHangConTrol khachHangDAO;
	private HoaDonConTrol hoaDonDAO;
	private ChiTietHoaDonConTrol chiTietHoaDonDAO;
	private List<LinhKien> listLK;
	private List<KhachHang> listKH;
	private List<HoaDon> listHD;
	private DecimalFormat df;
	private SimpleDateFormat dt1;
	private Date date;
	private NhanVien nhanVien;

	private String ma;

	/**
	 * Tạo giao diện trang chủ.
	 */
	public TrangChuJPanel(NhanVien nhanVien) {
		setBackground(Color.GRAY);
		setLayout(null);
		linhKienDao = new LinhKienConTrol();
		this.nhanVien = nhanVien;
		df = new DecimalFormat("#,##0.00");
		long millis = System.currentTimeMillis();
		date = new Date(millis);
		dt1 = new SimpleDateFormat("yyyy-MM-dd");
		ThongTinLKpnl();
		HoaDonpnl();

//		listLK = linhKienDao.getAllLinhKien();
		listLK = linhKienDao.phanTrang(1, 20);
		khachHangDAO = new KhachHangConTrol();
		listKH = khachHangDAO.getAllKhachHang();
		docDuLieuDatabaseVaoTableThongTinLK();
		dangKySuKien();
	}

	/**
	 * Hàm tạo giao diện cho pnl Thông tin linh kiện
	 */
	public void ThongTinLKpnl() {
		// TODO Auto-generated method stub
		pnlThongTinLK = new JPanel();
		pnlThongTinLK.setBackground(Color.LIGHT_GRAY);
		pnlThongTinLK.setBounds(0, 0, 534, 830);
		this.add(pnlThongTinLK);
		pnlThongTinLK.setLayout(null);

		lblTimKiem = new JLabel("Tìm kiếm theo:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimKiem.setBounds(12, 87, 164, 16);
		pnlThongTinLK.add(lblTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTimKiem.setBounds(191, 115, 331, 30);
		pnlThongTinLK.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		String[] colHeaderThongTinLK = { "Mã", "Tên linh kiện", "Thương hiệu", "SL", "Đơn giá" };
		modelThongTinLK = new DefaultTableModel(colHeaderThongTinLK, 0);
		tableThongTinLK = new JTable(modelThongTinLK) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tableThongTinLK.setBackground(Color.WHITE);
		tableThongTinLK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPaneLK = new JScrollPane(tableThongTinLK);
		scrollPaneLK.setBounds(12, 167, 510, 530);
		pnlThongTinLK.add(scrollPaneLK);

		tableThongTinLK.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableThongTinLK.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableThongTinLK.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableThongTinLK.getColumnModel().getColumn(3).setPreferredWidth(60);
		tableThongTinLK.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableThongTinLK.setRowHeight(25);

		btnThem = new JButton("Thêm");
//		btnThem.setIcon(
//				new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_add_shopping_cart_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBounds(358, 757, 164, 59);
		pnlThongTinLK.add(btnThem);

		txtSoLuong = new JTextField();
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setBounds(459, 712, 63, 30);
		txtSoLuong.setText("1");
		pnlThongTinLK.add(txtSoLuong);

		lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSoLuong.setBounds(358, 712, 89, 30);
		pnlThongTinLK.add(lblSoLuong);

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cboTimKiem.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Mã linh kiện", "Tên linh kiện", "Thương hiệu", "Loại" }));
		cboTimKiem.setSelectedIndex(1);
		cboTimKiem.setBounds(12, 116, 164, 30);
		pnlThongTinLK.add(cboTimKiem);

		btnXemChiTiet = new JButton("Xem chi tiết");
//		btnXemChiTiet.setIcon(
//				new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(12, 757, 212, 59);
		pnlThongTinLK.add(btnXemChiTiet);

		pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(0, 128, 0));
		pnlThongTin.setBounds(0, 0, 534, 59);
		pnlThongTinLK.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblThongTinLK = new JLabel("Thông tin linh kiện");
		lblThongTinLK.setForeground(Color.WHITE);
		lblThongTinLK.setBounds(0, 0, 534, 59);
		pnlThongTin.add(lblThongTinLK);
		lblThongTinLK.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblThongTinLK.setHorizontalAlignment(SwingConstants.CENTER);

		txtTrang = new JTextField();
		txtTrang.setText("1");
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTrang.setBounds(120, 712, 56, 32);
		pnlThongTinLK.add(txtTrang);
		txtTrang.setColumns(10);
		txtTrang.setEditable(false);

		btnSau = new JButton("");
//		btnSau.setIcon(new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_skip_next_white_24dp.png")));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(184, 712, 40, 31);
		pnlThongTinLK.add(btnSau);

		btnTruoc = new JButton("");
//		btnTruoc.setIcon(
//				new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(68, 712, 40, 31);
		pnlThongTinLK.add(btnTruoc);

		btnDau = new JButton("");
		btnDau.setBackground(Color.GRAY);
//		btnDau.setIcon(new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_fast_rewind_white_24dp.png")));
		btnDau.setBounds(12, 712, 40, 31);
		pnlThongTinLK.add(btnDau);

		btnCuoi = new JButton("");
		btnCuoi.setBackground(Color.GRAY);
//		btnCuoi.setIcon(new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setBounds(238, 712, 40, 31);
		pnlThongTinLK.add(btnCuoi);
	}

	/**
	 * Hàm tạo giao diện cho panel Hóa đơn bán hàng
	 */
	public void HoaDonpnl() {
		// TODO Auto-generated method stub
		pnlHoaDon = new JPanel();
		pnlHoaDon.setBackground(Color.LIGHT_GRAY);
		pnlHoaDon.setBounds(525, 0, 675, 830);
		this.add(pnlHoaDon);
		pnlHoaDon.setLayout(null);

		lblMaHoDon = new JLabel("Mã HD");
		lblMaHoDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaHoDon.setBounds(12, 77, 142, 30);
		pnlHoaDon.add(lblMaHoDon);

		lblNgayLap = new JLabel("Ngày lập HD");
		lblNgayLap.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgayLap.setBounds(371, 117, 141, 23);
		pnlHoaDon.add(lblNgayLap);

		lblMaKhachHang = new JLabel("Mã KH");
		lblMaKhachHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaKhachHang.setBounds(371, 77, 161, 27);
		pnlHoaDon.add(lblMaKhachHang);

		lblKhachHang = new JLabel("Tên KH");
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblKhachHang.setBounds(12, 113, 142, 30);
		pnlHoaDon.add(lblKhachHang);

		lblSoDienThoai = new JLabel("SĐT");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSoDienThoai.setBounds(12, 156, 97, 30);
		pnlHoaDon.add(lblSoDienThoai);

		lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiaChi.setBounds(297, 157, 97, 28);
		pnlHoaDon.add(lblDiaChi);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(455, 77, 208, 30);
		pnlHoaDon.add(txtMaKhachHang);
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setText(taoMa("KhachHang"));

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(91, 113, 201, 30);
		pnlHoaDon.add(txtTenKhachHang);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(91, 156, 201, 30);
		pnlHoaDon.add(txtSoDienThoai);

		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayLapHD.setColumns(10);
		txtNgayLapHD.setBounds(512, 113, 151, 30);
		txtNgayLapHD.setEditable(false);

		txtNgayLapHD.setText(dt1.format(date));

		pnlHoaDon.add(txtNgayLapHD);

		txtDiaChiKH = new JTextField();
		txtDiaChiKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChiKH.setColumns(10);
		txtDiaChiKH.setBounds(371, 156, 292, 30);
		pnlHoaDon.add(txtDiaChiKH);

		String[] colHeaderHoaDon = { "Mã linh kiện", "Tên linh kiện", "Sl", "Đơn giá", "Bảo hành", "Thành tiền" };
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tableHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tableHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPaneHoaDon = new JScrollPane(tableHoaDon);
		scrollPaneHoaDon.setBounds(12, 199, 651, 448);
		pnlHoaDon.add(scrollPaneHoaDon);
		tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableHoaDon.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableHoaDon.getColumnModel().getColumn(2).setPreferredWidth(30);
		tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableHoaDon.getColumnModel().getColumn(4).setPreferredWidth(50);
		tableHoaDon.getColumnModel().getColumn(5).setPreferredWidth(90);
		tableHoaDon.setRowHeight(25);

		pnlThanhToan = new JPanel();
		pnlThanhToan.setBorder(
				new TitledBorder(null, "Thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThanhToan.setBounds(12, 660, 325, 157);
		pnlHoaDon.add(pnlThanhToan);
		pnlThanhToan.setLayout(null);

		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTongTien.setBounds(12, 23, 93, 30);
		pnlThanhToan.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTongTien.setBounds(117, 24, 196, 30);
		pnlThanhToan.add(txtTongTien);
		txtTongTien.setColumns(10);
		txtTongTien.setEditable(false);

		lblTienKhachTra = new JLabel("Tiền khách trả:");
		lblTienKhachTra.setForeground(Color.RED);
		lblTienKhachTra.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienKhachTra.setBounds(12, 66, 152, 30);
		pnlThanhToan.add(lblTienKhachTra);

		lblTienThoi = new JLabel("Tiền thối lại:");
		lblTienThoi.setForeground(Color.RED);
		lblTienThoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienThoi.setBounds(12, 109, 137, 30);
		pnlThanhToan.add(lblTienThoi);

		txtTienKhachTra = new JTextField();
		txtTienKhachTra.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTienKhachTra.setBounds(161, 67, 152, 30);
		pnlThanhToan.add(txtTienKhachTra);
		txtTienKhachTra.setColumns(10);

		txtTienThoi = new JTextField();
		txtTienThoi.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTienThoi.setBounds(133, 109, 180, 30);
		pnlThanhToan.add(txtTienThoi);
		txtTienThoi.setColumns(10);
		txtTienThoi.setEditable(false);

		btnThanhToan = new JButton("Thanh toán");
//		btnThanhToan.setIcon(
//				new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_monetization_on_white_18dp.png")));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThanhToan.setBackground(new Color(0, 128, 0));
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setBounds(476, 754, 187, 63);
		pnlHoaDon.add(btnThanhToan);

		btnTaoMoi = new JButton("Tạo mới");
//		btnTaoMoi.setIcon(
//				new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_create_new_folder_white_18dp.png")));
		btnTaoMoi.setForeground(Color.WHITE);
		btnTaoMoi.setBackground(new Color(30, 144, 255));
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTaoMoi.setBounds(476, 660, 187, 63);
		pnlHoaDon.add(btnTaoMoi);

		btnXoa = new JButton("Xóa");
//		btnXoa.setIcon(
//				new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_remove_shopping_cart_white_18dp.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBounds(349, 660, 111, 63);
		pnlHoaDon.add(btnXoa);
		btnXoa.setBackground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnSua = new JButton("Sửa");
//		btnSua.setIcon(new ImageIcon(TrangChuJPanel.class.getResource("/hinh/baseline_edit_white_18dp.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBounds(349, 754, 111, 63);
		pnlHoaDon.add(btnSua);
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 18));

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setBounds(91, 77, 201, 30);
		pnlHoaDon.add(txtMaHoaDon);
		txtMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setText(taoMa("HoaDon"));

		pnlHD = new JPanel();
		pnlHD.setBackground(new Color(0, 102, 255));
		pnlHD.setBounds(0, 0, 771, 59);
		pnlHoaDon.add(pnlHD);
		pnlHD.setLayout(null);

		lblHoaDon = new JLabel("Hóa đơn bán hàng");
		lblHoaDon.setForeground(Color.WHITE);
		lblHoaDon.setBounds(0, 0, 675, 59);
		pnlHD.add(lblHoaDon);
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(txtTenKhachHang)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtSoDienThoai.requestFocus();
			}
		} else if (o.equals(txtSoDienThoai)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				if (txtSoDienThoai.getText().matches("^0\\d{9}$")) {
					listKH = khachHangDAO.timKiemKhachHang("SoDienThoaiKH", txtSoDienThoai.getText());
					if (listKH.size() != 0) {
						txtMaKhachHang.setText(listKH.get(0).getMaKH());
						txtDiaChiKH.setText(listKH.get(0).getDiaChiKH());
						txtTenKhachHang.setText(listKH.get(0).getHoTenKH());
					} else {
						txtMaKhachHang.setText(taoMa("KhachHang"));
						txtDiaChiKH.requestFocus();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
					txtSoDienThoai.requestFocus();
					txtSoDienThoai.selectAll();
				}
			}
		} else if (o.equals(txtTienKhachTra)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				if (txtTienKhachTra.getText().matches("^\\d+$")) {
					tinhTienThoi();
				} else {
					txtTienThoi.setText("");
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(txtTimKiem)) {
			if (!txtTimKiem.getText().equals("")) {
				if (cboTimKiem.getSelectedIndex() == 0) {
					listLK = linhKienDao.timKiemLinhKien("MaLinhKien", txtTimKiem.getText());
					docDuLieuDatabaseVaoTableThongTinLK();
					capNhatSoLuongModel();
					txtTrang.setText("1");
				}
				if (cboTimKiem.getSelectedIndex() == 1) {
					listLK = linhKienDao.timKiemLinhKien("TenLinhKien", txtTimKiem.getText());
					docDuLieuDatabaseVaoTableThongTinLK();
					capNhatSoLuongModel();
					txtTrang.setText("1");
				}
				if (cboTimKiem.getSelectedIndex() == 2) {
					listLK = linhKienDao.timKiemLinhKien("ThuongHieu", txtTimKiem.getText());
					docDuLieuDatabaseVaoTableThongTinLK();
					capNhatSoLuongModel();
					txtTrang.setText("1");
				}
				if (cboTimKiem.getSelectedIndex() == 3) {
					listLK = linhKienDao.timKiemLinhKien("LoaiLinhKien", txtTimKiem.getText());
					docDuLieuDatabaseVaoTableThongTinLK();
					capNhatSoLuongModel();
					txtTrang.setText("1");
				}

			} else {
				listLK = linhKienDao.phanTrang(1, 20);
				docDuLieuDatabaseVaoTableThongTinLK();
				capNhatSoLuongModel();
				txtTrang.setText("1");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if (o.equals(btnThem)) {
			themLinhKienVaoHoaDon();
		} else if (o.equals(btnDau)) {
			denTrangDau();
		} else if (o.equals(btnCuoi)) {
			denTrangCuoi();
		} else if (o.equals(btnTruoc)) {
			denTrangTruoc();
		} else if (o.equals(btnSau)) {
			denTrangSau();
		} else if (o.equals(btnXoa)) {
			xoaLinhKienKhoiHoaDon();
		} else if (o.equals(btnXemChiTiet)) {
			xemChiTietLinhKien();
		} else if (o.equals(btnTaoMoi)) {
			taoHoaDonMoi();
		} else if (o.equals(btnSua)) {
			sua();

		} else if (o.equals(btnThanhToan)) {
			ThanhToan();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(tableThongTinLK)) {
//			int row = tableThongTinLK.getSelectedRow();
			txtSoLuong.setText("1");
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
		} else if (o.equals(tableHoaDon)) {
			int row = tableHoaDon.getSelectedRow();
			txtSoLuong.setText(modelHoaDon.getValueAt(row, 2).toString());
			txtSoLuong.selectAll();
			txtSoLuong.requestFocus();
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

	/**
	 * Hàm đọc dữ liệu từ SQL vào bảng thông tin linh kiện
	 */
	public void docDuLieuDatabaseVaoTableThongTinLK() {
		modelThongTinLK.getDataVector().removeAllElements();
		for (LinhKien lk : listLK) {
			modelThongTinLK.addRow(new Object[] { lk.getMaLK(), lk.getTenLK(), lk.getThuongHieu(), lk.getSlTon(),
					df.format(lk.getDonGiaLK()) });
		}
	}

	/**
	 * Hàm tạo mã Hóa đơn, mã khách hàng
	 * 
	 * @param loaiMa
	 * @return ma
	 */
	public String taoMa(String loaiMa) {
		hoaDonDAO = new HoaDonConTrol();
		khachHangDAO = new KhachHangConTrol();
		Random rand = new Random();
		int rd = rand.nextInt(100000 - 10000) + 10000;
		switch (loaiMa) {
		case "HoaDon":
			do {
				rd = rand.nextInt(100000 - 10000) + 10000;
				ma = "170" + String.valueOf(rd);
				listHD = hoaDonDAO.getAllHoaDon();
			} while (listHD.contains(ma));
			break;
		case "KhachHang":
			do {
				rd = rand.nextInt(100000 - 10000) + 10000;
				ma = "195" + String.valueOf(rd);
				listKH = khachHangDAO.getAllKhachHang();
			} while (listKH.contains(ma));
			break;
		}
		return ma;
	}

	/**
	 * Hàm đăng kí sự kiện cho Jbutton, JTextfield
	 */
	private void dangKySuKien() {
		// TODO Auto-generated method stub
		txtTimKiem.addKeyListener(this);
		txtSoLuong.addKeyListener(this);
		txtSoDienThoai.addKeyListener(this);
		txtTenKhachHang.addKeyListener(this);
		txtTienKhachTra.addKeyListener(this);
		btnDau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTaoMoi.addActionListener(this);
		btnThanhToan.addActionListener(this);
		tableThongTinLK.addMouseListener(this);
		tableHoaDon.addMouseListener(this);
	}

	/**
	 * Hàm tính tổng tiền
	 */
	public void tinhTongTien() {
		double tongTien = 0;
		for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
			tongTien += Double.parseDouble(modelHoaDon.getValueAt(i, 5).toString().replace(",", ""));
		}
		txtTongTien.setText(df.format(tongTien));
	}

	/**
	 * Hàm tính tiền thối
	 */
	public void tinhTienThoi() {
		if (!txtTongTien.getText().equals("")) {
			String tienKT = txtTienKhachTra.getText().trim().replace(",", "");
			double tienKhachTra = 0;
			double tongTien = 0;
			try {
				tienKhachTra = Double.parseDouble(tienKT);
				tongTien = Double.parseDouble(txtTongTien.getText().replace(",", ""));
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Tiền khách trả không hợp lệ");
			}

			if (tienKT.matches("^\\d+$") && tienKhachTra >= tongTien) {
				txtTienThoi.setText(df.format(tienKhachTra - tongTien));
			} else {
				JOptionPane.showMessageDialog(this, "Số tiền Không hợp lệ");
				txtTienKhachTra.selectAll();
				txtTienKhachTra.requestFocus();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hóa đơn trống");
			txtTienKhachTra.setText("");
		}
	}

	/**
	 * Hàm cập nhật lại số lượng linh kiện trong model
	 */
	public void capNhatSoLuongModel() {
		for (int i = 0; i < modelThongTinLK.getRowCount(); i++) {
			for (int j = 0; j < modelHoaDon.getRowCount(); j++) {
				if (modelThongTinLK.getValueAt(i, 0).toString().equals(modelHoaDon.getValueAt(j, 0))) {
					int sl = Integer.parseInt(modelThongTinLK.getValueAt(i, 3).toString())
							- Integer.parseInt(modelHoaDon.getValueAt(j, 2).toString());
					modelThongTinLK.setValueAt(String.valueOf(sl), i, 3);
				}
			}
		}
	}

	/**
	 * Hàm xóa rỗng hóa đơn
	 */
	public void xoaRong() {
		txtMaHoaDon.setText(taoMa("HoaDon"));
		txtMaKhachHang.setText(taoMa("KhachHang"));
		txtTenKhachHang.setText("");
		txtSoDienThoai.setText("");
		txtDiaChiKH.setText("");
		txtNgayLapHD.setText(dt1.format(date));
		txtTongTien.setText("");
		txtTienKhachTra.setText("");
		txtTienThoi.setText("");
		modelHoaDon.getDataVector().removeAllElements();
		modelHoaDon.fireTableDataChanged();
	}

	/**
	 * Hàm sửa số lượng linh kiện trong hóa đơn
	 */
	public void sua() {
		String soLuong = txtSoLuong.getText();
		int row2 = tableHoaDon.getSelectedRow();
		int sl = Integer.parseInt(soLuong);
		int trang = Integer.parseInt(txtTrang.getText());
		if (row2 != -1) {
			if (!txtSoLuong.getText().equals("0")) {
				double gia = Double.parseDouble(modelHoaDon.getValueAt(row2, 3).toString().replace(",", ""));
				modelHoaDon.setValueAt(txtSoLuong.getText(), row2, 2);
				modelHoaDon.setValueAt(df.format(sl * gia), row2, 5);
				int soDau = 20 * (trang - 1) + 1;
				int soCuoi = soDau + 19;
				listLK = linhKienDao.phanTrang(soDau, soCuoi);
				docDuLieuDatabaseVaoTableThongTinLK();
				tableThongTinLK.setRowSelectionInterval(0, 0);
				capNhatSoLuongModel();
				tinhTongTien();
			} else {
				modelHoaDon.removeRow(row2);
				docDuLieuDatabaseVaoTableThongTinLK();
				tableThongTinLK.setRowSelectionInterval(0, 0);
				capNhatSoLuongModel();
				tinhTongTien();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để sửa");
		}
	}

	/**
	 * Hàm di chuyển đến trang đầu của bảng thông tin linh kiện
	 */
	public void denTrangDau() {
		listLK = linhKienDao.phanTrang(1, 20);
		docDuLieuDatabaseVaoTableThongTinLK();
		capNhatSoLuongModel();
		tableThongTinLK.clearSelection();
		txtTrang.setText("1");
	}

	/**
	 * Hàm di chuyển đến trang cuối của bảng thông tin linh kiện
	 */
	public void denTrangCuoi() {
		int slDb = linhKienDao.demSluongDuLieuTrongDB();
		int trangLonNhat;
		if (slDb % 20 == 0) {
			trangLonNhat = slDb / 20;
		} else {
			trangLonNhat = slDb / 20 + 1;
		}
		int soDau = 20 * (trangLonNhat - 1) + 1;
		int soCuoi = soDau + 19;
		listLK = linhKienDao.phanTrang(soDau, soCuoi);
		docDuLieuDatabaseVaoTableThongTinLK();
		capNhatSoLuongModel();
		tableThongTinLK.clearSelection();
		txtTrang.setText(String.valueOf(trangLonNhat));
	}

	/**
	 * Hàm di chuyển đến trang thứ i-1 của bảng thông tin linh kiện
	 */
	public void denTrangTruoc() {
		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int soDau = 20 * (trang - 2) + 1;
			int soCuoi = soDau + 19;
			listLK = linhKienDao.phanTrang(soDau, soCuoi);
			docDuLieuDatabaseVaoTableThongTinLK();
			capNhatSoLuongModel();
			tableThongTinLK.clearSelection();
		}
	}

	/**
	 * Hàm di chuyển đến trang thứ i+1 của bảng thông tin linh kiện
	 */
	public void denTrangSau() {
		int slDb = linhKienDao.demSluongDuLieuTrongDB();
		int trangLonNhat;
		int trang = Integer.parseInt(txtTrang.getText());
		if (slDb % 20 == 0) {
			trangLonNhat = slDb / 20;
		} else {
			trangLonNhat = slDb / 20 + 1;
		}
		if (trang < trangLonNhat) {
			txtTrang.setText(String.valueOf(trang + 1));
			int soDau = 20 * (trang) + 1;
			int soCuoi = soDau + 19;
			listLK = linhKienDao.phanTrang(soDau, soCuoi);
			docDuLieuDatabaseVaoTableThongTinLK();
			capNhatSoLuongModel();
			tableThongTinLK.clearSelection();
		}
	}

	/**
	 * Hàm thêm linh kiện vào hóa đơn
	 */
	public void themLinhKienVaoHoaDon() {
		int row = tableThongTinLK.getSelectedRow();
		String soLuong = txtSoLuong.getText();
		if (row != -1) {
			String soLuongTbl = modelThongTinLK.getValueAt(row, 3).toString();
			Double donGia = Double.parseDouble(modelThongTinLK.getValueAt(row, 4).toString().replace(",", ""));
			if (txtSoLuong.getText().matches("^\\d+$") && !(txtSoLuong.getText().equals("0"))) {
				String maLK = modelThongTinLK.getValueAt(row, 0).toString();
				String tenLK = modelThongTinLK.getValueAt(row, 1).toString();
				List<LinhKien> list = linhKienDao.timKiemLinhKien("MaLinhKien", maLK);
				int sl = Integer.parseInt(soLuong);
				int slTbl = Integer.parseInt(soLuongTbl);

				if (sl > slTbl) {
					JOptionPane.showMessageDialog(this, "Không đủ số lượng");
					txtSoLuong.selectAll();
					txtSoLuong.requestFocus();
				} else {
					double thanhTien = sl * donGia;
					int capNhatSoLuong = slTbl - sl;
					int dong = -1;
					for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
						if (modelHoaDon.getValueAt(i, 0).equals(maLK)) {
							dong = i;
						}
					}
					if (dong == -1) {
						modelHoaDon.addRow(new Object[] { maLK, tenLK, soLuong, df.format(donGia),
								list.get(0).getBaoHanh(), df.format(thanhTien) });
						modelThongTinLK.setValueAt(capNhatSoLuong, row, 3);

					} else {
						int sl2 = Integer.parseInt(modelHoaDon.getValueAt(dong, 2).toString());
						modelHoaDon.setValueAt(sl + sl2, dong, 2);
						modelHoaDon.setValueAt(df.format((sl + sl2) * donGia), dong, 5);
						modelThongTinLK.setValueAt(capNhatSoLuong, row, 3);
					}
					tinhTongTien();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
				txtSoLuong.selectAll();
				txtSoLuong.requestFocus();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn linh kiện");
		}
	}

	/**
	 * Hàm xóa linh kiện khỏi hóa đơn
	 */
	public void xoaLinhKienKhoiHoaDon() {
		int row2 = tableHoaDon.getSelectedRow();
		int trang = Integer.parseInt(txtTrang.getText());
		if (row2 != -1) {
			modelHoaDon.removeRow(row2);
			int soDau = 20 * (trang - 1) + 1;
			int soCuoi = soDau + 19;
			listLK = linhKienDao.phanTrang(soDau, soCuoi);
			docDuLieuDatabaseVaoTableThongTinLK();
			capNhatSoLuongModel();
			tableThongTinLK.clearSelection();
			tinhTongTien();
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để xóa");
		}
	}

	/**
	 * Hàm xem chi tiết linh kiện
	 */
	public void xemChiTietLinhKien() {
		int row = tableThongTinLK.getSelectedRow();
		if (row != -1) {
			String maLK = modelThongTinLK.getValueAt(row, 0).toString();
			listLK = linhKienDao.timKiemLinhKien("MaLinhKien", maLK);
			String ten = listLK.get(0).getTenLK();
			String moTa = listLK.get(0).getMoTaLK();
			String loai = listLK.get(0).getLoaiLK();
			String thuongHieu = listLK.get(0).getThuongHieu();
			int slTon = listLK.get(0).getSlTon();
			Date ngayNhap = listLK.get(0).getNgayNhap();
			int baoHanh = listLK.get(0).getBaoHanh();
			Double donGia = Double.parseDouble(modelThongTinLK.getValueAt(row, 4).toString().replace(",", ""));
			frm_ChiTietLinhKien lk = new frm_ChiTietLinhKien(
					new LinhKien(maLK, ten, moTa, donGia, loai, thuongHieu, slTon, ngayNhap, baoHanh));
			lk.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xem");
		}
	}

	/**
	 * Hàm tạo hóa đơn mới
	 */
	public void taoHoaDonMoi() {
		xoaRong();
	}

	/**
	 * Hàm thanh toán và lưu hóa đơn
	 */
	public void ThanhToan() {
		if (regex()) {
			chiTietHoaDonDAO = new ChiTietHoaDonConTrol();
			String maHD = txtMaHoaDon.getText().trim();
			Date ngayLap = Date.valueOf(txtNgayLapHD.getText());
			String maKH = txtMaKhachHang.getText().trim();
			String hoTen = txtTenKhachHang.getText().trim();
			String sdt = txtSoDienThoai.getText().trim();
			String diaChi = txtDiaChiKH.getText().trim();
			int n = 0;
			int soLuong;
			String maLK;
			KhachHang khachHang = new KhachHang(maKH, hoTen, sdt, diaChi);
			HoaDon hoaDon = new HoaDon(maHD, ngayLap, nhanVien, khachHang);
			hoaDonDAO.themHoaDon(hoaDon);
			if (!listKH.equals(maKH)) {
				khachHangDAO.themKhachHang(khachHang);
			}
			for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
				soLuong = Integer.parseInt(modelHoaDon.getValueAt(i, 2).toString());
				maLK = modelHoaDon.getValueAt(i, 0).toString();
				LinhKien linhKien = new LinhKien(maLK);
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(soLuong, hoaDon, linhKien);
				if (chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon)) {
					n++;
				}
				if (n > 1)
					linhKienDao.capNhatSoLuongLinhKien(soLuong, maLK);
			}
			tinhTienThoi();
			txtTienKhachTra.setText(df.format(Double.parseDouble(txtTienKhachTra.getText())));
			int trang = Integer.parseInt(txtTrang.getText());
			int fn = 20 * (trang - 1) + 1;
			int ln = fn + 19;
			listLK = linhKienDao.phanTrang(fn, ln);
			docDuLieuDatabaseVaoTableThongTinLK();
			tableThongTinLK.clearSelection();
			if (n > 0) {
				JOptionPane.showMessageDialog(this, "Lưu hóa đơn thành công");
			}
		}
	}

	public boolean regex() {
		String tenKH = txtTenKhachHang.getText().trim();
		String sdt = txtSoDienThoai.getText().trim();
		String diaChiKH = txtDiaChiKH.getText().trim();

		if (!(tenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Chưa nhập tên khách hàng!!!");
			txtTenKhachHang.requestFocus();
			return false;
		}
		if (!(tenKH.matches(
				"^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$"))) {
			JOptionPane.showInternalMessageDialog(this, "Tên khách hàng chỉ được nhập chữ!");
			txtTenKhachHang.requestFocus();
			txtTenKhachHang.selectAll();
			return false;
		}

		if (!(sdt.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Chưa nhập số điện thoại của khách hàng!!!");
			txtSoDienThoai.requestFocus();
			return false;
		}
		if (!(sdt.matches("^0[0-9]{9}$"))) {
			JOptionPane.showInternalMessageDialog(this, "Số điện thoại chỉ được nhập số!");
			txtSoDienThoai.requestFocus();
			txtSoDienThoai.selectAll();
			return false;
		}
		if (!(diaChiKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ của khách hàng!!!");
			txtDiaChiKH.requestFocus();
			return false;
		}
		if (!(diaChiKH.matches(
				"^[a-zA-Z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ -/]+$"))) {
			JOptionPane.showMessageDialog(this,
					"Địa chỉ khách hàng chỉ được nhập chữ và không chứ kí tự đặc biết ngoại trừ/ - !");
			txtDiaChiKH.requestFocus();
			txtDiaChiKH.selectAll();
			return false;
		}
		int a = 0;
		for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
			a++;
		}
		if (!(a > 0)) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để thanh toán");
			return false;
		}
		String tienKT = txtTienKhachTra.getText().replace(",", "");

		double tongTien = Double.parseDouble(txtTongTien.getText().replace(",", ""));
		double tien = 0;
		try {
			if (!(tienKT.length() > 0)) {
				JOptionPane.showMessageDialog(this, "Chưa nhập tiền khách trả");
				txtTienKhachTra.requestFocus();
				return false;
			}
			tien = Double.parseDouble(tienKT);
			if (!(tien > tongTien)) {
				JOptionPane.showMessageDialog(this, "Chưa trả đủ tiền!!!");
				txtTienKhachTra.requestFocus();
				txtTienKhachTra.selectAll();
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Tiền chỉ được nhập số!");
			txtTienKhachTra.requestFocus();
			txtTienKhachTra.selectAll();
			return false;
		}
		return true;
	}
}
