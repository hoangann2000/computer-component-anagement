package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.KhachHangConTrol;
import Controller.NhanVienConTrol;

import entity.NhanVien;

import Model.NhanVienModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class NhanVienJPanel extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaNV;
	private JTextField textTenNV;
	private JTextField txtMatKhau;
	private JTextField textSdt;
	private JTextField textDc;
	private JTextField textNgay;
	private JTextField textMaTim;
	private JTable table;
	private DefaultTableModel modelNhanVien;
	private NhanVienConTrol nhanVienDAO;
	private JComboBox<String> comboBox;
	private JComboBox<String> cboGioiTinh;
	private JButton btnTim;
	private JButton btnSua;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnThem;
	private JPanel panel;
	private List<NhanVien> listNV = new ArrayList<NhanVien>();

	/**
	 * Create the panel.
	 */
	/**
	 * @throws SQLException
	 * 
	 */
	public NhanVienJPanel() throws SQLException {

		nhanVienDAO = new NhanVienConTrol();
		setBackground(Color.LIGHT_GRAY);
		// setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		JLabel lblMaNV = new JLabel("Mã nhân viên :");
		lblMaNV.setBounds(41, 79, 157, 30);
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblMaNV);

		JLabel lblHoTenNV = new JLabel("Họ tên nhân viên :");
		lblHoTenNV.setBounds(41, 122, 186, 30);
		lblHoTenNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblHoTenNV);

		JLabel lblMatKhau = new JLabel("Mật khẩu :");
		lblMatKhau.setBounds(703, 83, 116, 23);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblMatKhau);

		JLabel lblSdt = new JLabel("Số điện thoại :");
		lblSdt.setBounds(40, 162, 158, 30);
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblSdt);

		JLabel lblDc = new JLabel("Địa chỉ :");
		lblDc.setBounds(41, 205, 116, 30);
		lblDc.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblDc);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNV.setBounds(239, 79, 287, 30);
		add(txtMaNV);
		txtMaNV.setColumns(10);
		txtMaNV.setText(taoMa());
		txtMaNV.setEditable(false);

		textTenNV = new JTextField();
		textTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textTenNV.setBounds(239, 122, 287, 30);
		add(textTenNV);
		textTenNV.setColumns(10);

		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setBounds(869, 79, 285, 30);
		add(txtMatKhau);
		txtMatKhau.setColumns(10);

		textSdt = new JTextField();
		textSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textSdt.setBounds(239, 162, 287, 30);
		add(textSdt);
		textSdt.setColumns(10);

		textDc = new JTextField();
		textDc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textDc.setBounds(239, 205, 915, 30);
		add(textDc);
		textDc.setColumns(10);

		JLabel lblNgaySinh = new JLabel("Ngày sinh :");
		lblNgaySinh.setBounds(703, 165, 116, 30);
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblNgaySinh);

		textNgay = new JTextField();
		textNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNgay.setBounds(867, 165, 287, 30);
		add(textNgay);
		textNgay.setColumns(10);

		btnThem = new JButton("Thêm");
//		btnThem.setIcon(
//				new ImageIcon(NhanVienJPanel.class.getResource("/hinh/baseline_person_add_alt_1_white_18dp.png")));

		btnThem.setBackground(new Color(0, 100, 0));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBounds(41, 741, 134, 54);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btnThem);

		btnXoa = new JButton("Xóa");
//		btnXoa.setIcon(new ImageIcon(NhanVienJPanel.class.getResource("/hinh/baseline_delete_sweep_white_18dp.png")));

		btnXoa.setBackground(Color.RED);
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBounds(1028, 741, 126, 54);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btnXoa);

		btnXoaTrang = new JButton("Xóa rỗng");
//		btnXoaTrang.setIcon(new ImageIcon(NhanVienJPanel.class.getResource("/hinh/baseline_clear_all_white_18dp.png")));
		btnXoaTrang.setForeground(Color.WHITE);
		btnXoaTrang.setBackground(Color.GRAY);
		btnXoaTrang.setBounds(660, 741, 179, 54);
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btnXoaTrang);

		btnSua = new JButton("Sửa");
//		btnSua.setIcon(new ImageIcon(NhanVienJPanel.class.getResource("/hinh/baseline_construction_white_18dp.png")));
		btnSua.addActionListener(this);

		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(Color.GRAY);
		btnSua.setBounds(361, 741, 126, 54);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btnSua);

		btnTim = new JButton("Tìm");
//		btnTim.setIcon(new ImageIcon(NhanVienJPanel.class.getResource("/hinh/baseline_pageview_white_18dp.png")));
		btnTim.addActionListener(this);
		btnTim.setForeground(Color.WHITE);
		btnTim.setBackground(Color.GRAY);
		btnTim.setBounds(660, 296, 116, 33);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btnTim);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(239, 251, 120, 30);
		comboBox.addItem("User");
		comboBox.addItem("Admin");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));

		add(comboBox);

		JLabel lblNewLabel = new JLabel("Quyền truy cập :");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(41, 248, 186, 30);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblNewLabel);

		JLabel lblTimMa = new JLabel("Nhập mã nhân viên cần tìm:");
		lblTimMa.setBounds(41, 296, 293, 30);
		lblTimMa.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblTimMa);

		textMaTim = new JTextField();
		textMaTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textMaTim.setBounds(346, 296, 287, 30);
		add(textMaTim);
		textMaTim.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 342, 1113, 374);
		add(scrollPane);

		String[] header = { "Mã nhân viên", "Họ tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ" };
		modelNhanVien = new DefaultTableModel(header, 0);
		table = new JTable(modelNhanVien) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(250);

		table.addMouseListener(this);

		JLabel lblGioiTinh = new JLabel("Giới tính :");
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGioiTinh.setBounds(703, 122, 107, 30);
		add(lblGioiTinh);

		cboGioiTinh = new JComboBox<String>();
		cboGioiTinh.addItem("Nam");
		cboGioiTinh.addItem("Nữ");
		cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cboGioiTinh.setBounds(867, 123, 120, 30);
		add(cboGioiTinh);

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTim.addActionListener(this);

		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 1200, 59);
		add(panel);
		panel.setLayout(null);

		JLabel lblNhanVien = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhanVien.setBounds(0, 0, 1200, 61);
		panel.add(lblNhanVien);
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 25));

		nhanVienDAO = new NhanVienConTrol();
		listNV = nhanVienDAO.getAllNV();
		docDuLieuDatabaseVaoTable();

	}

	private String taoMa() {
		nhanVienDAO = new NhanVienConTrol();
		String ma = "";
		Random rand = new Random();
		int rd = rand.nextInt(100000 - 10000) + 10000;
		do {
			rd = rand.nextInt(100000 - 10000) + 10000;
			ma = "180" + String.valueOf(rd);
			listNV = nhanVienDAO.getAllNV();
		} while (listNV.contains(ma));
		return ma;
	}

	private void docDuLieuDatabaseVaoTable() {
		// TODO Auto-generated method stub
		modelNhanVien.getDataVector().removeAllElements();
		for (NhanVien nv : listNV) {
			modelNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getHoTenNV(), nv.getGioiTinhNV(), nv.getNgaySinhNV(),
					nv.getSoDienThoaiNV(), nv.getDiaChiNV() });
		}
	}

	private void tim() {
		String maNV = textMaTim.getText().trim();

		if (maNV.equalsIgnoreCase(""))
			listNV = nhanVienDAO.getAllNV();
		else {
			try {
				listNV = nhanVienDAO.getAllNV(maNV);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (listNV.size() > 0) {
				docDuLieuDatabaseVaoTable();
			} else {
				JOptionPane.showMessageDialog(null, "Không tìm thấy");
			}
		}

	}

	private void sua() {

		int row1 = table.getSelectedRow();

		if (row1 == -1) {
			JOptionPane.showMessageDialog(null, "chọn dòng muốn sửa");
			return;
		} else {
			String ma = txtMaNV.getText().trim();
			String gt = textTenNV.getText().trim();
			String quyen = (String) (comboBox.getSelectedItem());
			Date ngay = Date.valueOf(textNgay.getText());
			String dc = textDc.getText().trim();
			String sdt = textSdt.getText().trim();
			String mk = txtMatKhau.getText().trim();
			String gioitinh = (String) (cboGioiTinh.getSelectedItem());
			NhanVien nv = new NhanVien(ma, gt, gioitinh, ngay, dc, sdt, mk, quyen);
			int t1 = JOptionPane.showConfirmDialog(null, "bạn có muốn sửa ?", "Sửa", JOptionPane.YES_NO_OPTION);
			if (t1 == JOptionPane.YES_OPTION) {
				if (nhanVienDAO.updateNV(ma, nv)) {
					listNV = nhanVienDAO.getAllNV();
					docDuLieuDatabaseVaoTable();
				}
			}
		}
	}

	private void xoaRongTextfields() {
		txtMaNV.setText(taoMa());
		txtMatKhau.setText("");
		textDc.setText("");
		textNgay.setText("");
		textTenNV.setText("");
		textSdt.setText("");
		cboGioiTinh.setSelectedIndex(0);
		comboBox.setSelectedIndex(0);
		txtMaNV.requestFocus();
	}

	private void them() {
		String ma = txtMaNV.getText().trim();
		String gt = textTenNV.getText().trim();
		String quyen = (String) (comboBox.getSelectedItem());
		Date ngay = Date.valueOf(textNgay.getText());
		String dc = textDc.getText().trim();
		String sdt = textSdt.getText().trim();
		String mk = txtMatKhau.getText().trim();
		String gioitinh = (String) (cboGioiTinh.getSelectedItem());
		NhanVien nv = new NhanVien(ma, gt, gioitinh, ngay, dc, sdt, mk, quyen);
		try {
			if (nhanVienDAO.themNV(nv)) {
				NhanVienModel model = new NhanVienModel(nhanVienDAO.getAllNV());
				try {
					table.setModel(model);
					xoaRongTextfields();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Trùng Mã");
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	private void xoa() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa");
			return;
		} else {
			int t = JOptionPane.showConfirmDialog(null, "bạn có muốn xóa ?", "Xóa", JOptionPane.YES_NO_OPTION);
			if (t == JOptionPane.YES_OPTION) {
				List<NhanVien> dskh = nhanVienDAO.getAllNV();
				if (row >= 0 && row < dskh.size()) {
					NhanVien kh = dskh.get(row);
					if (!kh.getQuyenTruyCap().trim().equals("Admin")) {

						try {
							if (nhanVienDAO.xoaNV(kh)) {
								table.setModel(new NhanVienModel(nhanVienDAO.getAllNV()));
								xoaRongTextfields();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(this, "Không thể xóa người quản lý");
					}
				}

			}
		}
	}

	public boolean regex() {
		String gt = textTenNV.getText().trim();
		String quyen = (String) (comboBox.getSelectedItem());

		String dc = textDc.getText().trim();
		String sdt = textSdt.getText().trim();
		String mk = txtMatKhau.getText().trim();

		if (!(mk.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Chưa nhập mật khẩu cho nhân viên");
			txtMatKhau.requestFocus();
			return false;
		}

		if (!(gt.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Chưa nhập tên nhân viên");
			textTenNV.requestFocus();
			return false;
		}
		if (!(gt.matches(
				"^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$"))) {
			JOptionPane.showMessageDialog(this, "Tên nhân viên phải là chữ");
			textTenNV.requestFocus();
			textTenNV.selectAll();
			return false;
		}
		if (!(sdt.length() > 0)) {
			JOptionPane.showInternalMessageDialog(this, "Chưa Nhập số điện thoại Nhân viên!");
			textSdt.requestFocus();
			return false;
		}
		if (!(sdt.matches("^0[0-9]{9}$"))) {
			JOptionPane.showInternalMessageDialog(this, "Số điện thoại chỉ được nhập số và bắt đầu là 0!");
			textSdt.requestFocus();
			textSdt.selectAll();
			return false;
		}

		if (!(dc.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ nhân viên");
			textDc.requestFocus();
			return false;
		}
		String ngay = textNgay.getText();
		Date ngaysinh = Date.valueOf(ngay);
		long millis = System.currentTimeMillis();
		Date ngaht = new Date(millis);
		if (!(ngay.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Chưa nhập ngày sinh nhân viên");
			textNgay.requestFocus();
			return false;
		}
		if (!(ngay.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))) {
			JOptionPane.showMessageDialog(this, "Ngày sinh phải có dạng: YYYY-MM-DD");
			textNgay.selectAll();
			textNgay.requestFocus();
			return false;
		}
		if (!(ngaysinh.before(ngaht))) {
			JOptionPane.showMessageDialog(this, "Ngày Sinh phải nhỏ hơn ngày hiện tại");
			textNgay.selectAll();
			textNgay.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaNV.setText(table.getValueAt(row, 0).toString().trim());
		NhanVien nhanVien = nhanVienDAO.getNhanVien(table.getValueAt(row, 0).toString().trim());
		textTenNV.setText(table.getValueAt(row, 1).toString());
		cboGioiTinh.setSelectedItem(table.getValueAt(row, 2));
		textNgay.setText(table.getValueAt(row, 3).toString());
		textSdt.setText(table.getValueAt(row, 4).toString());
		textDc.setText(table.getValueAt(row, 5).toString());
		txtMatKhau.setText(nhanVien.getMatKhau().trim());
		comboBox.setSelectedItem(nhanVien.getQuyenTruyCap().trim());
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
		if (o.equals(btnThem)) {
			if (regex()) {
				them();
			}
		} else if (o.equals(btnXoaTrang)) {
			xoaRongTextfields();
		} else if (o.equals(btnXoa)) {
			xoa();
		} else if (o.equals(btnTim)) {
			tim();
		} else if (o.equals(btnSua)) {
			if (regex()) {
				sua();
			}
		}
	}
}