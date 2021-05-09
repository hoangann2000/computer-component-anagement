package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.KhachHang;

@SuppressWarnings("unused")
public class KhachHangModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 4051763091525139742L;
	private List<KhachHang> dskh;
	private String[] headers = { "Mã KH", "Họ Tên KH", "SĐT", "Địa Chỉ" };

	public KhachHangModel(List<KhachHang> dskh) {

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

		KhachHang kh = dskh.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return kh.getMaKH();
		case 1:
			return kh.getHoTenKH();
		case 2:
			return kh.getSoDienThoaiKH();
		case 3:
			return kh.getDiaChiKH();

		}

		return kh;
	}

}
