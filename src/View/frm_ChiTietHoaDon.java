package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ChiTietHoaDonConTrol;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.LinhKien;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.EventObject;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class frm_ChiTietHoaDon extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaHD;
	private JTextField txtNgayLapHD;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSdt;
	private JTextField txtDiaChi;
	private JTextField txtTongTien;
	private DefaultTableModel modelChiTietHD;
	private JTable tableChiTietHD;
	private JButton btnThoat;
	private HoaDon hoaDon;
	private List<LinhKien> listLK;
	private List<ChiTietHoaDon> listCTHD;
	private ChiTietHoaDonConTrol chiTietHoaDonDAO;
	private double TongTien;
	private DecimalFormat df;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new frm_ChiTietHoaDon(new HoaDon()).setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public frm_ChiTietHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
		df = new DecimalFormat("#,##0.00");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 936, 779);
		setLocationRelativeTo(null);
		setTitle("Chi tiết hóa đơn");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlChiTiet = new JPanel();
		pnlChiTiet.setBackground(new Color(0, 128, 0));
		pnlChiTiet.setBounds(0, 0, 918, 59);
		contentPane.add(pnlChiTiet);
		pnlChiTiet.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chi tiết hóa đơn");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 918, 59);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnlChiTiet.add(lblNewLabel);

		JLabel lblMaHD = new JLabel("Mã hóa đơn:");
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaHD.setBounds(10, 72, 131, 30);
		contentPane.add(lblMaHD);

		txtMaHD = new JTextField();
		txtMaHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaHD.setBounds(183, 72, 223, 30);
		contentPane.add(txtMaHD);
		txtMaHD.setColumns(10);
		txtMaHD.setEditable(false);
		txtMaHD.setText(hoaDon.getMaHD());

		JLabel lblNgayLapHD = new JLabel("Ngày lập hóa đơn:");
		lblNgayLapHD.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgayLapHD.setBounds(429, 72, 183, 30);
		contentPane.add(lblNgayLapHD);

		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayLapHD.setColumns(10);
		txtNgayLapHD.setBounds(638, 72, 268, 30);
		contentPane.add(txtNgayLapHD);
		txtNgayLapHD.setEditable(false);
		txtNgayLapHD.setText(hoaDon.getNgayLapHD().toString());
		

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaNV.setBounds(10, 115, 161, 30);
		contentPane.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(183, 115, 223, 30);
		contentPane.add(txtMaNV);
		txtMaNV.setEditable(false);
		txtMaNV.setText(hoaDon.getNhanVien().getMaNV());

		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenNV.setBounds(429, 115, 161, 30);
		contentPane.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(601, 115, 305, 30);
		contentPane.add(txtTenNV);
		txtTenNV.setEditable(false);
		txtTenNV.setText(hoaDon.getNhanVien().getHoTenNV());

		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaKH.setBounds(10, 158, 161, 30);
		contentPane.add(lblMaKH);

		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(183, 158, 223, 30);
		contentPane.add(txtMaKH);
		txtMaKH.setEditable(false);
		txtMaKH.setText(hoaDon.getKhachHang().getMaKH());

		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenKH.setBounds(429, 158, 183, 30);
		contentPane.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(601, 158, 305, 30);
		contentPane.add(txtTenKH);
		txtTenKH.setEditable(false);
		txtTenKH.setText(hoaDon.getKhachHang().getHoTenKH());

		JLabel lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSdt.setBounds(10, 201, 161, 30);
		contentPane.add(lblSdt);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSdt.setColumns(10);
		txtSdt.setBounds(183, 201, 223, 30);
		contentPane.add(txtSdt);
		txtSdt.setEditable(false);
		txtSdt.setText(hoaDon.getKhachHang().getSoDienThoaiKH());

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDiaChi.setBounds(10, 244, 84, 30);
		contentPane.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(107, 244, 799, 30);
		contentPane.add(txtDiaChi);
		txtDiaChi.setEditable(false);
		txtDiaChi.setText(hoaDon.getKhachHang().getDiaChiKH());

		String[] header = { "Mã linh kiện", "Tên linh kiện", "Số lượng", "Đơn giá", "Bảo hành", "Thành tiền" };
		modelChiTietHD = new DefaultTableModel(header, 0);
		tableChiTietHD = new JTable(modelChiTietHD) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tableChiTietHD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		JScrollPane scrollPane = new JScrollPane(tableChiTietHD);
		scrollPane.setBounds(10, 287, 896, 364);
		scrollPane = new JScrollPane(tableChiTietHD);
		scrollPane.setBounds(12, 287, 894, 360);
		contentPane.add(scrollPane);
		tableChiTietHD.setRowHeight(25);
		
		docDuLieuDatabaseVaoTable();
		
		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTongTien.setBounds(10, 677, 113, 30);
		contentPane.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(124, 677, 161, 30);
		contentPane.add(txtTongTien);
		txtTongTien.setEditable(false);
		
//		Tính tổng tiền
		chiTietHoaDonDAO = new ChiTietHoaDonConTrol();
		listCTHD = chiTietHoaDonDAO.getAllChiTietHoaDon(txtMaHD.getText().trim());
		TongTien = hoaDon.tinhTongTien(listCTHD);
		txtTongTien.setText(df.format(TongTien));
		
		btnThoat = new JButton("Thoát");
//		btnThoat.setIcon(new ImageIcon(frm_ChiTietHoaDon.class.getResource("/hinh/baseline_close_white_24dp.png")));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setBackground(Color.RED);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(781, 683, 125, 30);
		contentPane.add(btnThoat);
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
	public void docDuLieuDatabaseVaoTable() {
		chiTietHoaDonDAO = new ChiTietHoaDonConTrol();
		listLK = chiTietHoaDonDAO.getChiTietHoaDon(txtMaHD.getText().trim());
		for (LinhKien lk : listLK) {
			modelChiTietHD.addRow(new Object[] { lk.getMaLK(), lk.getTenLK(), lk.getSlTon(),
					df.format(lk.getDonGiaLK()), lk.getBaoHanh(), df.format(lk.getDonGiaLK()*lk.getSlTon()) });
		}
	}
}
