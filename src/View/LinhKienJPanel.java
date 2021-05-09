//package ui;
//
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.Color;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//
//public class LinhKienJPanel extends JPanel {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private JTable table;
//	private JTextField txtMaLK;
//	private JTextField txtTenLK;
//	private JTextField txtSoLuong;
//	private JTextField txtDonGia;
//	private JTextField txtMaTim;
//
//	/**
//	 * Create the panel.
//	 */
//	public LinhKienJPanel() {
//		setBackground(Color.LIGHT_GRAY);
//		setLayout(null);
//		
//		JLabel lblQunLLinh = new JLabel("QU\u1EA2N L\u00CD LINH KI\u1EC6N");
//		lblQunLLinh.setForeground(Color.BLUE);
//		lblQunLLinh.setFont(new Font("Tahoma", Font.BOLD, 25));
//		lblQunLLinh.setBounds(368, 10, 275, 44);
//		add(lblQunLLinh);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(28, 296, 930, 255);
//		add(scrollPane);
//		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null},
//			},
//			new String[] {
//				"STT", "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "\u0110\u01A1n Gi\u00E1", "Ghi Ch\u00FA"
//			}
//		) {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 8643717709696161088L;
//			@SuppressWarnings("rawtypes")
//			Class[] columnTypes = new Class[] {
//				Integer.class, String.class, String.class, Integer.class, Double.class, String.class
//			};
//			public Class<?> getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		scrollPane.setViewportView(table);
//		
//		JLabel lblMSnPhm = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m:");
//		lblMSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblMSnPhm.setBounds(10, 99, 99, 25);
//		add(lblMSnPhm);
//		
//		txtMaLK = new JTextField();
//		txtMaLK.setBounds(137, 101, 234, 25);
//		add(txtMaLK);
//		txtMaLK.setColumns(10);
//		
//		JLabel lblTn = new JLabel("T\u00EAn:");
//		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblTn.setBounds(486, 99, 48, 25);
//		add(lblTn);
//		
//		txtTenLK = new JTextField();
//		txtTenLK.setBounds(593, 101, 243, 25);
//		add(txtTenLK);
//		txtTenLK.setColumns(10);
//		
//		JLabel lblSLng = new JLabel("S\u1ED1 L\u01B0\u1EE3ng:");
//		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblSLng.setBounds(10, 165, 99, 25);
//		add(lblSLng);
//		
//		txtSoLuong = new JTextField();
//		txtSoLuong.setBounds(137, 169, 234, 25);
//		add(txtSoLuong);
//		txtSoLuong.setColumns(10);
//		
//		JLabel lblnGi = new JLabel("\u0110\u01A1n Gi\u00E1:");
//		lblnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblnGi.setBounds(486, 165, 76, 25);
//		add(lblnGi);
//		
//		txtDonGia = new JTextField();
//		txtDonGia.setBounds(593, 167, 243, 25);
//		add(txtDonGia);
//		txtDonGia.setColumns(10);
//		
//		JLabel lblNewLabel = new JLabel("Nh\u1EADp m\u00E3 s\u1EA3n ph\u1EA9m c\u1EA7n t\u00ECm :");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNewLabel.setBounds(10, 230, 190, 31);
//		add(lblNewLabel);
//		
//		txtMaTim = new JTextField();
//		txtMaTim.setBounds(210, 235, 160, 25);
//		add(txtMaTim);
//		txtMaTim.setColumns(10);
//		
//		JButton btnThem = new JButton("Th\u00EAm");
//		btnThem.setForeground(Color.WHITE);
//		btnThem.setBackground(Color.BLUE);
//		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnThem.setBounds(28, 582, 85, 41);
//		add(btnThem);
//		
//		JButton btnXoa = new JButton("X\u00F3a");
//		btnXoa.setForeground(Color.WHITE);
//		btnXoa.setBackground(Color.BLUE);
//		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnXoa.setBounds(639, 582, 85, 41);
//		add(btnXoa);
//		
//		JButton btnSua = new JButton("S\u1EEDa");
//		btnSua.setForeground(Color.WHITE);
//		btnSua.setBackground(Color.BLUE);
//		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnSua.setBounds(333, 582, 85, 41);
//		add(btnSua);
//		
//		JButton btnLuu = new JButton("L\u01B0u");
//		btnLuu.setForeground(Color.WHITE);
//		btnLuu.setBackground(Color.BLUE);
//		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnLuu.setBounds(486, 582, 85, 41);
//		add(btnLuu);
//		
//		JButton btnXoaRong = new JButton("X\u00F3a r\u1ED7ng");
//		btnXoaRong.setForeground(Color.WHITE);
//		btnXoaRong.setBackground(Color.BLUE);
//		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnXoaRong.setBounds(173, 582, 99, 41);
//		add(btnXoaRong);
//		
//		JButton btnTim = new JButton("T\u00ECm");
//		btnTim.setForeground(Color.WHITE);
//		btnTim.setBackground(Color.RED);
//		btnTim.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnTim.setBounds(432, 230, 85, 31);
//		add(btnTim);
//
//	}
//}

package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.LinhKienConTrol;
import entity.LinhKien;
import Connection.connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;

public class LinhKienJPanel extends JPanel implements ActionListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaLK;
	private JTextField txtTenLK;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JComboBox<String> cboLoai;
	private JTextField txtThuongHieu;
	private JTextField txtNgayNhap;
	private JTextField txtBaoHanh;
	private DefaultTableModel modelLinhKien;
	private JTable tableLinhKien;
	private LinhKienConTrol linhKienDAO;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private JTextField txtTimKiem;
	private List<LinhKien> listLK;
	private JComboBox<String> cboTimKiem;
	private JLabel lblTimKiem;
	private JTextArea txtMoTa;
	private JButton btnXemChiTiet;
	private JTextField txtTrang;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;

	/**
	 * Create the panel.
	 */
	public LinhKienJPanel() {
		try {
			connection.getJDBCConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		linhKienDAO = new LinhKienConTrol();

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 372, 1139, 363);
		add(scrollPane);
		String[] colHeader = { "Mã Linh Kiện", "Tên Linh Kiện", "Mô Tả", "Đơn Giá", "Loại", "Thương Hiệu",
				"Sl", "Ngày Nhập", "Bảo Hành" };
		modelLinhKien = new DefaultTableModel(colHeader, 0);
		tableLinhKien = new JTable(modelLinhKien) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tableLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableLinhKien);

		tableLinhKien.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableLinhKien.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableLinhKien.getColumnModel().getColumn(2).setPreferredWidth(250);
		tableLinhKien.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableLinhKien.getColumnModel().getColumn(4).setPreferredWidth(60);
		tableLinhKien.getColumnModel().getColumn(5).setPreferredWidth(90);
		tableLinhKien.getColumnModel().getColumn(6).setPreferredWidth(20);
		tableLinhKien.getColumnModel().getColumn(7).setPreferredWidth(80);
		tableLinhKien.getColumnModel().getColumn(8).setPreferredWidth(40);
		tableLinhKien.setRowHeight(17);
		listLK = linhKienDAO.phanTrang(1, 20);
		docDuLieuVaoModelLinhKien();

		JLabel lblMSnPhm = new JLabel("Mã Linh Kiện:");
		lblMSnPhm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMSnPhm.setBounds(28, 83, 158, 30);
		add(lblMSnPhm);

		txtMaLK = new JTextField();
		txtMaLK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaLK.setBounds(198, 83, 200, 30);
		add(txtMaLK);
		txtMaLK.setColumns(10);

		JLabel lblTn = new JLabel("Tên linh kiện:");
		lblTn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTn.setBounds(450, 83, 153, 30);
		add(lblTn);

		txtTenLK = new JTextField();
		txtTenLK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenLK.setBounds(600, 83, 567, 30);
		add(txtTenLK);
		txtTenLK.setColumns(10);

		JLabel lblSLng = new JLabel("S\u1ED1 L\u01B0\u1EE3ng:");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSLng.setBounds(28, 126, 113, 30);
		add(lblSLng);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setBounds(198, 126, 200, 30);
		add(txtSoLuong);
		txtSoLuong.setColumns(10);

		JLabel lblnGi = new JLabel("\u0110\u01A1n Gi\u00E1:");
		lblnGi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblnGi.setBounds(450, 126, 94, 30);
		add(lblnGi);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDonGia.setBounds(600, 126, 212, 30);
		add(txtDonGia);
		txtDonGia.setColumns(10);

		btnThem = new JButton("Th\u00EAm");
//		btnThem.setIcon(new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_note_add_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBounds(318, 748, 139, 54);
		add(btnThem);

		btnXoa = new JButton("X\u00F3a");
//		btnXoa.setIcon(new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_delete_sweep_white_18dp.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBounds(1047, 748, 120, 54);
		add(btnXoa);

		btnSua = new JButton("S\u1EEDa");
//		btnSua.setIcon(new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_construction_white_18dp.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(Color.GRAY);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBounds(825, 748, 126, 54);
		add(btnSua);

		btnXoaRong = new JButton("X\u00F3a r\u1ED7ng");
//		btnXoaRong.setIcon(new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_clear_all_white_18dp.png")));
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setBackground(Color.GRAY);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBounds(557, 748, 173, 54);
		add(btnXoaRong);

		JLabel lblNewLabel_1 = new JLabel("Loại:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(897, 126, 56, 30);
		add(lblNewLabel_1);

		cboLoai = new JComboBox<String>();
		cboLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoai.setBounds(1007, 126, 160, 30);
		add(cboLoai);

		listLK = linhKienDAO.getAllLinhKien();
		for (LinhKien lk : listLK) {
			int n = 0;
			for (int i = 0; i < cboLoai.getItemCount(); i++) {
				if (cboLoai.getItemAt(i).equalsIgnoreCase(lk.getLoaiLK())) {
					n++;
				}
			}
			if (n == 0) {
				cboLoai.addItem(lk.getLoaiLK());
			}

		}

		JLabel lblmota = new JLabel("Mô Tả:");
		lblmota.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblmota.setBounds(28, 169, 76, 30);
		add(lblmota);

		JLabel lblNewLabel_2 = new JLabel("Thương Hiệu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(28, 236, 150, 30);
		add(lblNewLabel_2);

		txtThuongHieu = new JTextField();
		txtThuongHieu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThuongHieu.setBounds(198, 236, 200, 30);
		add(txtThuongHieu);
		txtThuongHieu.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Ngày Nhập:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(450, 236, 134, 30);
		add(lblNewLabel_3);

		txtNgayNhap = new JTextField();
		txtNgayNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayNhap.setBounds(599, 236, 212, 30);
		add(txtNgayNhap);
		txtNgayNhap.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Bảo Hành:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(897, 236, 120, 30);
		add(lblNewLabel_4);

		txtBaoHanh = new JTextField();
		txtBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBaoHanh.setBounds(1007, 236, 160, 30);
		add(txtBaoHanh);
		txtBaoHanh.setColumns(10);

		lblTimKiem = new JLabel("Tìm kiếm theo:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimKiem.setBounds(28, 279, 160, 30);
		add(lblTimKiem);

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Mã linh kiện", "Tên linh kiện", "Thương hiệu", "Loại" }));
		cboTimKiem.setSelectedIndex(1);
		cboTimKiem.setBounds(198, 279, 200, 30);
		add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(450, 281, 358, 30);
		add(txtTimKiem);

		tableLinhKien.addMouseListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		txtTimKiem.addKeyListener(this);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 1200, 59);
		add(panel);
		panel.setLayout(null);

		JLabel lblQunLLinh = new JLabel("QUẢN LÝ LINH KIỆN");
		lblQunLLinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLLinh.setBounds(0, 0, 1200, 59);
		panel.add(lblQunLLinh);
		lblQunLLinh.setForeground(Color.WHITE);
		lblQunLLinh.setFont(new Font("Tahoma", Font.BOLD, 25));

		txtMoTa = new JTextArea();
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMoTa.setBounds(198, 169, 969, 54);
		add(txtMoTa);

		btnXemChiTiet = new JButton("Xem chi tiết");
//		btnXemChiTiet.setIcon(
//				new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setBounds(28, 748, 200, 54);
		add(btnXemChiTiet);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setBounds(154, 329, 56, 30);
		add(txtTrang);
		txtTrang.setColumns(10);
		txtTrang.setEditable(false);

		btnDau = new JButton("");
		btnDau.setBackground(Color.GRAY);
//		btnDau.setIcon(new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_fast_rewind_white_24dp.png")));
		btnDau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDau.setBounds(28, 329, 40, 30);
		add(btnDau);

		btnTruoc = new JButton("");
//		btnTruoc.setIcon(
//				new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(91, 329, 40, 30);
		add(btnTruoc);

		btnSau = new JButton("");
//		btnSau.setIcon(new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_skip_next_white_24dp.png")));
		btnSau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(234, 329, 40, 30);
		add(btnSau);

		btnCuoi = new JButton("");
//		btnCuoi.setIcon(new ImageIcon(LinhKienJPanel.class.getResource("/hinh/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(301, 329, 40, 30);
		add(btnCuoi);

		btnDau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
	}

	private void docDuLieuVaoModelLinhKien() {
		modelLinhKien.getDataVector().removeAllElements();
		for (LinhKien lk : listLK) {
			modelLinhKien.addRow(new Object[] { lk.getMaLK(), lk.getTenLK(), lk.getMoTaLK(), lk.getDonGiaLK(),
					lk.getLoaiLK(), lk.getThuongHieu(), lk.getSlTon(), lk.getNgayNhap(), lk.getBaoHanh() });
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = tableLinhKien.getSelectedRow();
		if (row != -1) {
			txtMaLK.setText(modelLinhKien.getValueAt(row, 0).toString());
			txtTenLK.setText(modelLinhKien.getValueAt(row, 1).toString());
			txtMoTa.setText(modelLinhKien.getValueAt(row, 2).toString());
			txtDonGia.setText(modelLinhKien.getValueAt(row, 3).toString());
			cboLoai.setSelectedItem(tableLinhKien.getValueAt(row, 4));
			txtThuongHieu.setText(modelLinhKien.getValueAt(row, 5).toString());
			txtSoLuong.setText(modelLinhKien.getValueAt(row, 6).toString());
			txtNgayNhap.setText(modelLinhKien.getValueAt(row, 7).toString());
			txtBaoHanh.setText(modelLinhKien.getValueAt(row, 8).toString());
		}
	}

	private boolean kiemTra() {
		String ma = txtMaLK.getText().trim();
		String ten = txtTenLK.getText().trim();
		String mota = txtMoTa.getText().trim();
		String gia = txtDonGia.getText().trim();
		String loai = cboLoai.getSelectedItem().toString();
		String thuonghieu = txtThuongHieu.getText().trim();
		String soluong = txtSoLuong.getText().trim();
		String ngay = txtNgayNhap.getText().trim();
		String bh = txtBaoHanh.getText();

		if (!(ma.length() > 0 && ma.matches("^[A-Z]{2}[0-9]{6}$"))) {
			JOptionPane.showMessageDialog(this,
					"Mã linh kiện không được để trống phải bắt đầu bằng 2 kí tự hoa và theo sau là 6 kí tự số");
			txtMaLK.requestFocus();
			txtMaLK.selectAll();
			return false;

		}
		if (!(ten.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống và phải bắt đầu bằng kí tự hoa!!!");
			txtTenLK.requestFocus();
			txtTenLK.selectAll();
			return false;
		}
		if (!(mota.length() > 0)) {
			JOptionPane.showMessageDialog(this,
					"Mô tả linh kiện không được để trống phải bắng đầu bằng kí tự tự hoa!!!");
			txtMoTa.requestFocus();
			txtMoTa.selectAll();
			return false;
		}
		double dongia = 0;
		try {
			if (!(gia.length() > 0)) {
				JOptionPane.showMessageDialog(this, "Đơn giá linh kiện không được để trống!!!");
				txtDonGia.requestFocus();
				txtDonGia.selectAll();
				return false;
			}
			dongia = Double.parseDouble(gia);

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Đơn giá chỉ được nhập số");
			txtDonGia.requestFocus();
			txtDonGia.selectAll();
			return false;
		}
		if (!(thuonghieu.length() > 0 && thuonghieu.matches(
				"^[a-z0-9A-Z_ ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ.-]*$"))) {
			JOptionPane.showMessageDialog(this, "Thương Hiệu linh kiện không được để trống!!!");
			txtThuongHieu.requestFocus();
			txtThuongHieu.selectAll();
			return false;
		}
		int soLuongTon = 0;
		try {
			soLuongTon = Integer.parseInt(soluong);
			if (!(soluong.length() > 0)) {
				JOptionPane.showMessageDialog(this, "Không được để trống số lượng linh kiện!!!!");
				txtSoLuong.requestFocus();
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Số lượng linh kiện không được nhập số!!!");
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		}


		long millis=System.currentTimeMillis();
		Date ngaht= new Date(millis);
		String txtNgay = txtNgayNhap.getText();
		String ngayn="1990-01-01";
		Date ngaygoc= Date.valueOf(ngayn);
		if(!(txtNgay.length() > 0 )) {
			JOptionPane.showMessageDialog(this,
					"Ngày nhập không được để trống !");
			txtNgayNhap.requestFocus();
			return false;
		}
		if (!( txtNgay.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))) {
			JOptionPane.showMessageDialog(this,
					"Ngày nhập phải có dạng: YYYY-MM-DD");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}
		Date ngaynhap=Date.valueOf(txtNgay);
		if(!(ngaynhap.before(ngaht))) {
			JOptionPane.showMessageDialog(this, "Ngày nhập phải nhỏ hơn ngày hiện tại");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}
		if(!(ngaynhap.after(ngaygoc))) {
			JOptionPane.showMessageDialog(this, "Ngày nhập phải lớn hơn 1990-01-01");
			txtNgayNhap.requestFocus();
			txtNgayNhap.selectAll();
			return false;
		}
		
		int baoHanh = 0;
		try {
			if (!(bh.length() > 0)) {
				JOptionPane.showMessageDialog(this, "Thời gian bảo hành linh kiện không được để trống");
				txtBaoHanh.requestFocus();
				return false;
			}
			baoHanh = Integer.parseInt(bh);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Thời gian bảo hành chỉ được nhập số !!!");
		}
		return true;
	}

	private boolean them() {

		String ma = txtMaLK.getText().trim();
		String ten = txtTenLK.getText().trim();
		String mota = txtMoTa.getText().trim();
		double gia = Double.parseDouble(txtDonGia.getText());
		String loai = cboLoai.getSelectedItem().toString();
		String thuonghieu = txtThuongHieu.getText().trim();
		int soluong = Integer.parseInt(txtSoLuong.getText());
		Date ngaynhap = Date.valueOf(txtNgayNhap.getText());
		int bh = Integer.parseInt(txtBaoHanh.getText());

		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		if (ngaynhap.before(date) || ngaynhap.equals(date)) {
			LinhKien lk = new LinhKien(ma, ten, mota, gia, loai, thuonghieu, soluong, ngaynhap, bh);
			if (linhKienDAO.themLinhKien(lk)) {
				listLK = linhKienDAO.getAllLinhKien();
				docDuLieuVaoModelLinhKien();
			} else {

				JOptionPane.showMessageDialog(this, "Trùng mã");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ");
		}

		return true;
	}

	private void xoaRong() {
		txtMaLK.setText("");
		txtTenLK.setText("");
		txtMoTa.setText("");
		txtDonGia.setText("");
		txtThuongHieu.setText("");
		txtBaoHanh.setText("");
		txtNgayNhap.setText("");
		txtSoLuong.setText("");
	}

	private void xoaHetModel() {
		DefaultTableModel df = (DefaultTableModel) tableLinhKien.getModel();
		df.getDataVector().removeAllElements();
	}

	private boolean xoa() {
		ArrayList<LinhKien> dslk = (ArrayList<LinhKien>) linhKienDAO.getAllLinhKien();
		int r = tableLinhKien.getSelectedRow();
		int tl = JOptionPane.showConfirmDialog(this, "Có muốn xóa hay không ?", "", JOptionPane.YES_NO_OPTION);
		if (tl == JOptionPane.YES_OPTION) {
			LinhKien lk = dslk.get(r);
			linhKienDAO.deleteLK(lk);
			modelLinhKien.removeRow(r);
			return true;
		}
		return false;
	}

	private boolean sua() {
		int row = tableLinhKien.getSelectedRow();
		if (row != -1) {
			String ma = txtMaLK.getText().trim();
			String ten = txtTenLK.getText().trim();
			String moTa = txtMoTa.getText().trim();
			double dongia = Double.parseDouble(txtDonGia.getText());
			String loai = cboLoai.getSelectedItem().toString();
			String thuongHieu = txtThuongHieu.getText().trim();
			int soLuong = Integer.parseInt(txtSoLuong.getText());
			String ngay = txtNgayNhap.getText().trim();
			Date ngaynhap = Date.valueOf(ngay);

			int baoHanh = Integer.parseInt(txtBaoHanh.getText());
			if (linhKienDAO.update(new LinhKien(ma, ten, moTa, dongia, loai, thuongHieu, soLuong, ngaynhap, baoHanh))) {
				modelLinhKien.setValueAt(ma, row, 0);
				modelLinhKien.setValueAt(ten, row, 1);
				modelLinhKien.setValueAt(moTa, row, 2);
				modelLinhKien.setValueAt(dongia, row, 3);
				modelLinhKien.setValueAt(loai, row, 4);
				modelLinhKien.setValueAt(thuongHieu, row, 5);
				modelLinhKien.setValueAt(soLuong, row, 6);
				modelLinhKien.setValueAt(ngay, row, 7);
				modelLinhKien.setValueAt(baoHanh, row, 8);
				return true;
			}
		}
		return false;
	}

	/**
	 * Hàm di chuyển đến trang đầu của bảng thông tin linh kiện
	 */
	private void denTrangDau() {
		listLK = linhKienDAO.phanTrang(1, 20);
		docDuLieuVaoModelLinhKien();
		tableLinhKien.setRowSelectionInterval(0, 0);
		txtTrang.setText("1");
	}

	/**
	 * Hàm di chuyển đến trang cuối của bảng thông tin linh kiện
	 */
	private void denTrangCuoi() {
		int slDb = linhKienDAO.demSluongDuLieuTrongDB();
		int trangLonNhat;
		if (slDb % 20 == 0) {
			trangLonNhat = slDb / 20;
		} else {
			trangLonNhat = slDb / 20 + 1;
		}
		int soDau = 20 * (trangLonNhat - 1) + 1;
		int soCuoi = soDau + 19;
		listLK = linhKienDAO.phanTrang(soDau, soCuoi);
		docDuLieuVaoModelLinhKien();
		tableLinhKien.setRowSelectionInterval(0, 0);
		txtTrang.setText(String.valueOf(trangLonNhat));
	}

	/**
	 * Hàm di chuyển đến trang thứ i-1 của bảng thông tin linh kiện
	 */
	private void denTrangTruoc() {
		int trang = Integer.parseInt(txtTrang.getText());
		if (trang > 1) {
			txtTrang.setText(String.valueOf(trang - 1));
			int soDau = 20 * (trang - 2) + 1;
			int soCuoi = soDau + 19;
			listLK = linhKienDAO.phanTrang(soDau, soCuoi);
			docDuLieuVaoModelLinhKien();
			tableLinhKien.setRowSelectionInterval(0, 0);
		}
	}

	/**
	 * Hàm di chuyển đến trang thứ i+1 của bảng thông tin linh kiện
	 */
	private void denTrangSau() {
		int slDb = linhKienDAO.demSluongDuLieuTrongDB();
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
			listLK = linhKienDAO.phanTrang(soDau, soCuoi);
			docDuLieuVaoModelLinhKien();
			tableLinhKien.setRowSelectionInterval(0, 0);
		}
	}

	/**
	 * Hàm xem chi tiết linh kiện
	 */
	private void xemChiTietLinhKien() {
		int row = tableLinhKien.getSelectedRow();
		if (row != -1) {
			String maLK = modelLinhKien.getValueAt(row, 0).toString();
			listLK = linhKienDAO.timKiemLinhKien("MaLinhKien", maLK);
			String ten = listLK.get(0).getTenLK();
			String moTa = listLK.get(0).getMoTaLK();
			String loai = listLK.get(0).getLoaiLK();
			String thuongHieu = listLK.get(0).getThuongHieu();
			int slTon = listLK.get(0).getSlTon();
			Date ngayNhap = listLK.get(0).getNgayNhap();
			int baoHanh = listLK.get(0).getBaoHanh();
			Double donGia = Double.parseDouble(modelLinhKien.getValueAt(row, 3).toString());
			frm_ChiTietLinhKien lk = new frm_ChiTietLinhKien(
					new LinhKien(maLK, ten, moTa, donGia, loai, thuongHieu, slTon, ngayNhap, baoHanh));
			lk.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xem");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
		if (o.equals(btnThem)) {
			if (kiemTra()) {
				if (them()) {
					int trang = Integer.parseInt(txtTrang.getText());
					int fn = 20 * (trang - 1) + 1;
					int ln = fn + 19;
					listLK = linhKienDAO.phanTrang(fn, ln);
					docDuLieuVaoModelLinhKien();
					tableLinhKien.clearSelection();
				}
			}
		} else if (o.equals(btnXoaRong))
			xoaRong();
		else if (o.equals(btnXoa)) {
			if (xoa()) {
				xoaRong();
				int trang = Integer.parseInt(txtTrang.getText());
				int fn = 20 * (trang - 1) + 1;
				int ln = fn + 19;
				listLK = linhKienDAO.phanTrang(fn, ln);
				docDuLieuVaoModelLinhKien();
				tableLinhKien.clearSelection();
				JOptionPane.showMessageDialog(this, "Xóa thành công!");
			} else
				JOptionPane.showMessageDialog(this, "Xóa thất bại!");
		} else if (o.equals(btnSua)) {
			if (kiemTra()) {
				if (sua()) {
					JOptionPane.showMessageDialog(this, "Sửa Thành Công!!!");
					int trang = Integer.parseInt(txtTrang.getText());
					int fn = 20 * (trang - 1) + 1;
					int ln = fn + 19;
					linhKienDAO = new LinhKienConTrol();
					listLK = linhKienDAO.phanTrang(fn, ln);
				}
			}
		} else if (o.equals(btnDau)) {
			denTrangDau();
		} else if (o.equals(btnTruoc)) {
			denTrangTruoc();
		} else if (o.equals(btnSau)) {
			denTrangSau();
		} else if (o.equals(btnCuoi)) {
			denTrangCuoi();
		} else if (o.equals(btnXemChiTiet)) {
			xemChiTietLinhKien();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stubObject o = e.getSource();
		Object o = e.getSource();
		if (o.equals(txtTimKiem)) {
			if (!txtTimKiem.getText().equals("")) {
				if (cboTimKiem.getSelectedIndex() == 0) {
					listLK = linhKienDAO.timKiemLinhKien("MaLinhKien", txtTimKiem.getText());
					docDuLieuVaoModelLinhKien();
				}
				if (cboTimKiem.getSelectedIndex() == 1) {
					listLK = linhKienDAO.timKiemLinhKien("TenLinhKien", txtTimKiem.getText());
					docDuLieuVaoModelLinhKien();
				}
				if (cboTimKiem.getSelectedIndex() == 2) {
					listLK = linhKienDAO.timKiemLinhKien("ThuongHieu", txtTimKiem.getText());
					docDuLieuVaoModelLinhKien();
				}
				if (cboTimKiem.getSelectedIndex() == 3) {
					listLK = linhKienDAO.timKiemLinhKien("LoaiLinhKien", txtTimKiem.getText());
					docDuLieuVaoModelLinhKien();
				}

			} else {
				listLK = linhKienDAO.getAllLinhKien();
				docDuLieuVaoModelLinhKien();
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}