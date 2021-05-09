package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.NhanVien;

public class NhanVienModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4051763091525139742L;
	private List<NhanVien> dskh;
	private String[] headers = { "Mã nhân viên", "Họ tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ"};

	public NhanVienModel(List<NhanVien> dskh) {

		this.dskh = dskh;
	}

	public int getRowCount() {
		return dskh.size();
	}

	public int getColumnCount() {
		return headers.length;
	}

	public String getColumnName(int column) {
		return headers[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		NhanVien nv = dskh.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return nv.getMaNV();
		case 1:
			return nv.getHoTenNV();
		case 2:
			return nv.getGioiTinhNV();
		case 3:
			return nv.getNgaySinhNV();
		case 4:
			return nv.getSoDienThoaiNV();
		case 5:
			return nv.getDiaChiNV();
		}
		return nv;
	}

}
