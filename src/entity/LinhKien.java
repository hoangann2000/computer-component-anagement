package entity;

import java.sql.Date;

public class LinhKien {
	private String maLK;
	private String tenLK;
	private String moTaLK;
	private double donGiaLK;
	private String loaiLK;
	private String thuongHieu;
	private int slTon;
	private Date ngayNhap;
	private int baoHanh;

	public LinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinhKien(String maLK) {
		super();
		this.maLK = maLK;
	}

	public LinhKien(String maLK, String tenLK, String moTaLK, double donGiaLK, String loaiLK, String thuongHieu,
			int slTon, Date ngayNhap, int baoHanh) {
		super();
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.moTaLK = moTaLK;
		this.donGiaLK = donGiaLK;
		this.loaiLK = loaiLK;
		this.thuongHieu = thuongHieu;
		this.slTon = slTon;
		this.ngayNhap = ngayNhap;
		this.baoHanh = baoHanh;
	}

	public String getMaLK() {
		return maLK;
	}

	public void setMaLK(String maLK) {
		this.maLK = maLK;
	}

	public String getTenLK() {
		return tenLK;
	}

	public void setTenLK(String tenLK) {
		this.tenLK = tenLK;
	}

	public String getMoTaLK() {
		return moTaLK;
	}

	public void setMoTaLK(String moTaLK) {
		this.moTaLK = moTaLK;
	}

	public double getDonGiaLK() {
		return donGiaLK;
	}

	public void setDonGiaLK(double donGiaLK) {
		this.donGiaLK = donGiaLK;
	}

	public String getLoaiLK() {
		return loaiLK;
	}

	public void setLoaiLK(String loaiLK) {
		this.loaiLK = loaiLK;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public int getSlTon() {
		return slTon;
	}

	public void setSlTon(int slTon) {
		this.slTon = slTon;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLK == null) ? 0 : maLK.hashCode());
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
		LinhKien other = (LinhKien) obj;
		if (maLK == null) {
			if (other.maLK != null)
				return false;
		} else if (!maLK.equals(other.maLK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Mã linh kiện: %s\nTên linh kiện: %s\nĐơn giá: %f\nNgày nhâp: %s \n\n", maLK, tenLK,
				donGiaLK, ngayNhap);
	}
}
