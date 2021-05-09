package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.HoaDonConTrol;
import Controller.KhachHangConTrol;
import Controller.NhanVienConTrol;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;

import javax.swing.ImageIcon;

public class HoaDonJPanel extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtTimKiem;
	private DefaultTableModel modelHoaDon;
	private JTextField txtTrang;
	private JButton btnSau;
	private JButton btnTruoc;
	private JButton btnCuoi;
	private JButton btnDau;
	private JButton btnXemChiTiet;
	private List<HoaDon> listHD;
	private List<KhachHang> listKH;
	private List<NhanVien> listNV;
	private HoaDonConTrol hoaDonDAO;
	private KhachHangConTrol khachHangDAO;
	private NhanVienConTrol nhanVienDAO;

	/**
	 * Create the panel.
	 */
	public HoaDonJPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 143, 1091, 602);
		add(scrollPane);
		String[] header = { "STT", "Mã hóa đơn", "Mã nhân viên", "Tên nhân viên", "Khách hàng", "Tên khách hàng",
				"Ngày lập hóa đơn" };
		modelHoaDon = new DefaultTableModel(header, 0);
		table = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		table.setRowHeight(25);

		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);

		JLabel lblTimKiem = new JLabel("Tìm kiếm theo mã hóa đơn:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimKiem.setBounds(54, 88, 292, 30);
		add(lblTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(361, 88, 302, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnXemChiTiet = new JButton("Xem chi tiết");
//		btnXemChiTiet.setIcon(new ImageIcon(HoaDonJPanel.class.getResource("/hinh/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(933, 758, 212, 47);
		add(btnXemChiTiet);

		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setBackground(new Color(0, 128, 0));
		pnlHoaDon.setBounds(0, 0, 1200, 59);
		add(pnlHoaDon);
		pnlHoaDon.setLayout(null);

		JLabel lblHan = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblHan.setBounds(0, 0, 1200, 59);
		pnlHoaDon.add(lblHan);
		lblHan.setForeground(Color.WHITE);
		lblHan.setFont(new Font("Tahoma", Font.BOLD, 25));

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setText("1");
		txtTrang.setBounds(220, 759, 68, 30);
		add(txtTrang);
		txtTrang.setColumns(10);
		txtTrang.setEditable(false);

		btnDau = new JButton("");
		btnDau.setBackground(Color.GRAY);
//		btnDau.setIcon(new ImageIcon(HoaDonJPanel.class.getResource("/hinh/baseline_fast_rewind_white_24dp.png")));
		btnDau.setBounds(54, 759, 41, 30);
		add(btnDau);

		btnCuoi = new JButton("");
//		btnCuoi.setIcon(new ImageIcon(HoaDonJPanel.class.getResource("/hinh/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(405, 759, 41, 30);
		add(btnCuoi);

		btnTruoc = new JButton("");
//		btnTruoc.setIcon(new ImageIcon(HoaDonJPanel.class.getResource("/hinh/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(136, 759, 41, 30);
		add(btnTruoc);

		btnSau = new JButton("");
//		btnSau.setIcon(new ImageIcon(HoaDonJPanel.class.getResource("/hinh/baseline_skip_next_white_24dp.png")));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(326, 759, 41, 30);
		add(btnSau);

		hoaDonDAO = new HoaDonConTrol();
		listHD = hoaDonDAO.phanTrang(1, 23);
		docDuLieuDatabaseVaoTableHoaDon();
		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnXemChiTiet.addActionListener(this);
		txtTimKiem.addKeyListener(this);
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnTruoc.addActionListener(this);
	}

	private void docDuLieuDatabaseVaoTableHoaDon() {
		modelHoaDon.getDataVector().removeAllElements();
		int dem = 1;
		for (HoaDon hd : listHD) {
			modelHoaDon
					.addRow(new Object[] { dem, hd.getMaHD(), hd.getNhanVien().getMaNV(), hd.getNhanVien().getHoTenNV(),
							hd.getKhachHang().getMaKH(), hd.getKhachHang().getHoTenKH(), hd.getNgayLapHD() });
			dem++;
		}
	}

	/**
	 * Hàm xem chi tiết linh kiện
	 */
	private void xemChiTietLinhKien() {
		int row = table.getSelectedRow();
		listKH = new ArrayList<KhachHang>();
		khachHangDAO = new KhachHangConTrol();
		nhanVienDAO = new NhanVienConTrol();
		if (row != -1) {
			String maHD = modelHoaDon.getValueAt(row, 1).toString().trim();
			String maNV = modelHoaDon.getValueAt(row, 2).toString().trim();
			String maKH = modelHoaDon.getValueAt(row, 4).toString().trim();

			KhachHang khachHang = khachHangDAO.getKhachHang(maKH);
			NhanVien nhanVien = nhanVienDAO.getNhanVien(maNV);
			Date ngayLapHD = Date.valueOf(modelHoaDon.getValueAt(row, 6).toString());
			frm_ChiTietHoaDon ctHD = new frm_ChiTietHoaDon(new HoaDon(maHD, ngayLapHD, nhanVien, khachHang));
			ctHD.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xem");
		}
	}

	/**
	 * Hàm di chuyển đến trang đầu của bảng thông tin linh kiện
	 */
	private void denTrangDau() {
		listHD = hoaDonDAO.phanTrang(1, 23);
		docDuLieuDatabaseVaoTableHoaDon();
//		table.setRowSelectionInterval(0, 0);
		txtTrang.setText("1");
	}

	/**
	 * Hàm di chuyển đến trang cuối của bảng thông tin linh kiện
	 */
	private void denTrangCuoi() {
		int slDb = hoaDonDAO.demSluongDuLieuTrongDB();
		int trangLonNhat;
		if (slDb % 23 == 0) {
			trangLonNhat = slDb / 23;
		} else {
			trangLonNhat = slDb / 23 + 1;
		}
		int soDau = 23 * (trangLonNhat - 1) + 1;
		int soCuoi = soDau + 22;
		listHD = hoaDonDAO.phanTrang(soDau, soCuoi);
		docDuLieuDatabaseVaoTableHoaDon();
		table.setRowSelectionInterval(0, 0);
		txtTrang.setText(String.valueOf(trangLonNhat));
	}

	/**
	 * Hàm di chuyển đến trang thứ i-1 của bảng thông tin linh kiện
	 */
	private void denTrangTruoc() {
		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int soDau = 23 * (trang - 2) + 1;
			int soCuoi = soDau + 22;
			listHD = hoaDonDAO.phanTrang(soDau, soCuoi);
			docDuLieuDatabaseVaoTableHoaDon();
			table.setRowSelectionInterval(0, 0);
		}
	}

	/**
	 * Hàm di chuyển đến trang thứ i+1 của bảng thông tin linh kiện
	 */
	private void denTrangSau() {
		int slDb = hoaDonDAO.demSluongDuLieuTrongDB();
		int trangLonNhat;
		int trang = Integer.parseInt(txtTrang.getText());
		if (slDb % 23 == 0) {
			trangLonNhat = slDb / 23;
		} else {
			trangLonNhat = slDb / 23 + 1;
		}
		if (trang < trangLonNhat) {
			txtTrang.setText(String.valueOf(trang + 1));
			int soDau = 23 * (trang) + 1;
			int soCuoi = soDau + 22;
			listHD = hoaDonDAO.phanTrang(soDau, soCuoi);
			docDuLieuDatabaseVaoTableHoaDon();
			table.setRowSelectionInterval(0, 0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnXemChiTiet)) {
			xemChiTietLinhKien();
		}else if (o.equals(btnDau)) {
			denTrangDau();
		}else if (o.equals(btnCuoi)) {
			denTrangCuoi();
		}else if (o.equals(btnSau)) {
			denTrangSau();
		}else if (o.equals(btnTruoc)) {
			denTrangTruoc();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
//		listHD = HoaDonDao.timKiemHoaDon(txtTimKiem.getText());
		docDuLieuDatabaseVaoTableHoaDon();
	}
}
