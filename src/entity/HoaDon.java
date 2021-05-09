package entity;

import java.sql.Date;
import java.util.List;

public class HoaDon {
	private String maHD;
	private Date ngayLapHD;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHD, Date ngayLapHD) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
	}
	
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}
	
	public HoaDon(String maHD, Date ngayLapHD, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}
	public double tinhTongTien(List<ChiTietHoaDon> chiTietHoaDon) {
		double tongTien = 0;
		for (ChiTietHoaDon ctHD : chiTietHoaDon) {
			tongTien += ctHD.tinhThanhTien(ctHD.getSoLuong(), ctHD.getLinhKien());
		}
		return tongTien;
	}
	
}
