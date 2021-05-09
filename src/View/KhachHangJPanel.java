
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.KhachHangConTrol;
import entity.KhachHang;
import Model.KhachHangModel;
import javax.swing.ImageIcon;

public class KhachHangJPanel extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaKH;
	private JTextField txtSDT;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtTim;
	private DefaultTableModel model;
	private JTable table;
	private KhachHangConTrol khachHangDAO;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JButton btnXoa;
	private JButton btnXoaRong;

	private List<KhachHang> listKH;
	private JPanel panel;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnCuoi;
	private JButton btnSau;
	private JTextField txtTrang;

	public KhachHangJPanel() throws SQLException {
		setBackground(Color.LIGHT_GRAY);
		setSize(1200, 830);
		setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING,

				TitledBorder.TOP, null, null));
		panel_1.setBounds(47, 470, 1113, 268);
		add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(120, 25, 172, 30);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Số diện thoại:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(120, 90, 140, 30);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Họ tên:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(120, 150, 105, 30);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Địa chỉ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(120, 215, 105, 30);
		panel_1.add(lblNewLabel_5);

		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(301, 25, 507, 30);
		txtMaKH.setText(taoMa());
		txtMaKH.setEditable(false);
		panel_1.add(txtMaKH);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(301, 90, 670, 30);
		panel_1.add(txtSDT);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(301, 150, 670, 30);
		panel_1.add(txtHoTen);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(301, 215, 670, 30);
		panel_1.add(txtDiaChi);

		JLabel lblTim = new JLabel("Nhập mã cần tìm:");
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTim.setBounds(47, 420, 178, 30);
		add(lblTim);

		btnTim = new JButton("Tìm");
//		btnTim.setIcon(new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_pageview_white_18dp.png")));
		btnTim.setBackground(Color.GRAY);
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTim.setBounds(525, 420, 121, 30);
		add(btnTim);

		btnThem = new JButton("Thêm");
//		btnThem.setIcon(new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_person_add_alt_1_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(0, 100, 0));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBounds(47, 755, 136, 50);
		add(btnThem);

		btnCapNhat = new JButton("Sửa");
//		btnCapNhat.setIcon(new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_construction_white_18dp.png")));
		btnCapNhat.setBackground(Color.GRAY);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setBounds(369, 755, 144, 50);
		add(btnCapNhat);

		btnXoa = new JButton("Xóa");
//		btnXoa.setIcon(new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_delete_sweep_white_18dp.png")));
		btnXoa.setBackground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.addActionListener(this);
		btnXoa.setBounds(1045, 755, 115, 50);
		add(btnXoa);

		String[] colHeaderThongTin = { "Mã KH", "Tên KH", "SĐT", "Địa Chỉ" };
		model = new DefaultTableModel(colHeaderThongTin, 0);

		btnXoaRong = new JButton("Xóa rỗng");
//		btnXoaRong.setIcon(new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_clear_all_white_18dp.png")));
		btnXoaRong.setBackground(Color.GRAY);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setBounds(716, 755, 166, 50);
		add(btnXoaRong);

		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTim.setBounds(237, 420, 276, 30);
		add(txtTim);
		txtTim.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(47, 82, 1113, 313);
		add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "Danh Sách Khách Hàng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setLayout(null);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(25, 25, 1065, 275);
		panel_3.add(scroll);
		table.addMouseListener(this);
		table.setRowHeight(25);
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 1200, 59);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblNewLabel.setBounds(0, 0, 1200, 59);
		panel.add(lblNewLabel);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));

		btnDau = new JButton("");
//		btnDau.setIcon(new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_fast_rewind_white_24dp.png")));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(703, 420, 50, 30);
		add(btnDau);

		btnTruoc = new JButton("");
//		btnTruoc.setIcon(
//				new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setForeground(Color.WHITE);
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(776, 420, 50, 30);
		add(btnTruoc);

		btnCuoi = new JButton("");
//		btnCuoi.setIcon(new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setForeground(Color.WHITE);
		btnCuoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(1032, 420, 50, 30);
		add(btnCuoi);

		btnSau = new JButton("");
//		btnSau.setIcon(new ImageIcon(KhachHangJPanel.class.getResource("/hinh/baseline_skip_next_white_24dp.png")));
		btnSau.setForeground(Color.WHITE);
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(957, 420, 50, 30);
		add(btnSau);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setText("1");
		txtTrang.setColumns(10);
		txtTrang.setBounds(852, 420, 79, 30);
		add(txtTrang);
		txtTrang.setEditable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(145);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(145);

		khachHangDAO = new KhachHangConTrol();
		listKH = khachHangDAO.phanTrang(1, 10);
		docDuLieuDatabaseVaoTable();
		dangKiSuKien();
	}

	private void docDuLieuDatabaseVaoTable() {
		model.getDataVector().removeAllElements();
		for (KhachHang lk : listKH) {
			model.addRow(new Object[] { lk.getMaKH(), lk.getHoTenKH(), lk.getSoDienThoaiKH(), lk.getDiaChiKH() });
		}
	}

	private boolean validData() {
		String hoTen = txtHoTen.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diaChi = txtDiaChi.getText().trim();

		if (hoTen.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Họ tên khách hàng trống !");
			txtHoTen.selectAll();
			txtHoTen.requestFocus();
			return false;
		} else {

			if ((hoTen.matches(
					"^[a-zA-Z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]"))) {
				JOptionPane.showMessageDialog(this, "tên khách hàng không hợp lệ");
				txtHoTen.requestFocus();
				txtHoTen.selectAll();
				return false;
			}
		}

		if (sdt.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại khách hàng trống !");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		} else {

			if (!(sdt.matches("^[0-9]{10}$"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại khách hàng không hợp lệ");
				txtSDT.requestFocus();
				txtSDT.selectAll();
				return false;
			}
		}

		if (diaChi.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được trống !");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		} else {

			if (diaChi.matches(
					"^[a-z0-9A-Z ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]")) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không hợp lê");
				txtDiaChi.requestFocus();
				txtDiaChi.selectAll();
				return false;

			}
		}

		return true;
	}

	private void xoaRongTextfields() {
		txtMaKH.setText(taoMa());
		txtHoTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtMaKH.requestFocus();
	}

	private void xoa() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa");
			return;
		} else {
			int t = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa ?", "Xóa", JOptionPane.YES_NO_OPTION);
			if (t == JOptionPane.YES_OPTION) {
				List<KhachHang> dskh = khachHangDAO.getAllKhachHang();
				if (row >= 0 && row < dskh.size()) {
					KhachHang kh = dskh.get(row);
					try {
						if (khachHangDAO.xoaKhachHang(kh)) {
							int trang = Integer.parseInt(txtTrang.getText());
							table.setModel(new KhachHangModel(
									khachHangDAO.phanTrang(10 * (trang - 1) + 1, 10 * (trang - 1) + 10)));
							xoaRongTextfields();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	private void capNhat() {
		if (validData()) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "chọn dòng muốn sửa");
				return;
			} else {
				String ma = table.getValueAt(row, 0).toString().trim();
				KhachHang kh = new KhachHang(ma, txtHoTen.getText().trim(), txtSDT.getText().trim(),
						txtDiaChi.getText().trim());
				int t = JOptionPane.showConfirmDialog(null, "bạn có muốn sửa ?", "Sửa", JOptionPane.YES_NO_OPTION);
				if (t == JOptionPane.YES_OPTION) {
					if (khachHangDAO.capNhatKhachHang(ma, kh)) {
						int trang = Integer.parseInt(txtTrang.getText());
						listKH = khachHangDAO.phanTrang(10 * (trang - 1) + 1, 10 * (trang - 1) + 10);
						docDuLieuDatabaseVaoTable();
						table.setModel(model);
					}
				}
			}
		}
	}

	private void them() {
		if (validData()) {
			KhachHang sv = new KhachHang(txtMaKH.getText().trim(), txtHoTen.getText().trim(), txtSDT.getText().trim(),
					txtDiaChi.getText().trim());
			if (khachHangDAO.themKhachHang(sv)) {
				int trang = Integer.parseInt(txtTrang.getText());
				listKH = khachHangDAO.phanTrang(10 * (trang - 1) + 1, 10 * (trang - 1) + 10);
				docDuLieuDatabaseVaoTable();
				try {
					table.setModel(model);
					xoaRongTextfields();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Trùng Mã");
			}
		}
	}

	private void tim() {
		String maKH = txtTim.getText().trim();
		if (maKH.equalsIgnoreCase("")) {
			listKH = khachHangDAO.phanTrang(1, 10);
			txtTrang.setText("1");
		} else {
			listKH = khachHangDAO.timKiemKhachHang("MaKhachHang", maKH);
			if (listKH.size() > 0) {
				txtTrang.setText("1");
				docDuLieuDatabaseVaoTable();
			}
			else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
			}
		}
	}

	private String taoMa() {
		khachHangDAO = new KhachHangConTrol();
		String ma = "";
		Random rand = new Random();
		int rd = rand.nextInt(100000 - 10000) + 10000;
		do {
			rd = rand.nextInt(100000 - 10000) + 10000;
			ma = "195" + String.valueOf(rd);
			listKH = khachHangDAO.getAllKhachHang();
		} while (listKH.contains(ma));
		return ma;
	}

	/**
	 * Hàm di chuyển đến trang đầu của bảng thông tin linh kiện
	 */
	private void denTrangDau() {
		listKH = khachHangDAO.phanTrang(1, 10);
		docDuLieuDatabaseVaoTable();
		table.setRowSelectionInterval(0, 0);
		txtTrang.setText("1");
	}

	/**
	 * Hàm di chuyển đến trang cuối của bảng thông tin linh kiện
	 */
	private void denTrangCuoi() {
		int slDb = khachHangDAO.demSluongDuLieuTrongDB();
		int trangLonNhat;
		if (slDb % 10 == 0) {
			trangLonNhat = slDb / 10;
		} else {
			trangLonNhat = slDb / 10 + 1;
		}
		int soDau = 10 * (trangLonNhat - 1) + 1;
		int soCuoi = soDau + 9;
		listKH = khachHangDAO.phanTrang(soDau, soCuoi);
		docDuLieuDatabaseVaoTable();
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
			int soDau = 10 * (trang - 2) + 1;
			int soCuoi = soDau + 9;
			listKH = khachHangDAO.phanTrang(soDau, soCuoi);
			docDuLieuDatabaseVaoTable();
			table.setRowSelectionInterval(0, 0);
		}
	}

	/**
	 * Hàm di chuyển đến trang thứ i+1 của bảng thông tin linh kiện
	 */
	private void denTrangSau() {
		int slDb = khachHangDAO.demSluongDuLieuTrongDB();
		int trangLonNhat;
		int trang = Integer.parseInt(txtTrang.getText());
		if (slDb % 10 == 0) {
			trangLonNhat = slDb / 10;
		} else {
			trangLonNhat = slDb / 10 + 1;
		}
		if (trang < trangLonNhat) {
			txtTrang.setText(String.valueOf(trang + 1));
			int soDau = 10 * (trang) + 1;
			int soCuoi = soDau + 9;
			listKH = khachHangDAO.phanTrang(soDau, soCuoi);
			docDuLieuDatabaseVaoTable();
			table.setRowSelectionInterval(0, 0);
		}
	}

	private void dangKiSuKien() {
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnCapNhat.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaKH.setText(table.getValueAt(row, 0).toString());
		txtHoTen.setText(table.getValueAt(row, 1).toString());
		txtSDT.setText(table.getValueAt(row, 2).toString());
		txtDiaChi.setText(table.getValueAt(row, 3).toString());
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
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			them();
		} else if (o.equals(btnCapNhat)) {
			capNhat();
		} else if (o.equals(btnXoa)) {
			xoa();
		} else if (o.equals(btnXoaRong)) {
			xoaRongTextfields();
		} else if (o.equals(btnTim)) {
			tim();
		} else if (o.equals(btnDau)) {
			denTrangDau();
		} else if (o.equals(btnCuoi)) {
			denTrangCuoi();
		} else if (o.equals(btnSau)) {
			denTrangSau();
		} else if (o.equals(btnTruoc)) {
			denTrangTruoc();
		}
	}
}
