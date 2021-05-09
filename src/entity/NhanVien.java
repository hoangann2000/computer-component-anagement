package entity;

import java.sql.Date;

public class NhanVien {
	private String maNV;
	private String hoTenNV;
	private String gioiTinhNV;
	private Date ngaySinhNV;
	private String diaChiNV;
	private String soDienThoaiNV;
	private String matKhau;
	private String quyenTruyCap;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNV, String hoTenNV, String gioiTinhNV, Date ngaySinhNV, String diaChiNV,
			String soDienThoaiNV, String matKhau, String quyenTruyCap) {
		super();
		this.maNV = maNV;
		this.hoTenNV = hoTenNV;
		this.gioiTinhNV = gioiTinhNV;
		this.ngaySinhNV = ngaySinhNV;
		this.diaChiNV = diaChiNV;
		this.soDienThoaiNV = soDienThoaiNV;
		this.matKhau = matKhau;
		this.quyenTruyCap = quyenTruyCap;
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public NhanVien(String maNV, String quyenTruyCap) {
		super();
		this.maNV = maNV;
		this.quyenTruyCap = quyenTruyCap;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTenNV() {
		return hoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}

	public String getGioiTinhNV() {
		return gioiTinhNV;
	}

	public void setGioiTinhNV(String gioiTinhNV) {
		this.gioiTinhNV = gioiTinhNV;
	}

	public Date getNgaySinhNV() {
		return ngaySinhNV;
	}

	public void setNgaySinhNV(Date ngaySinhNV) {
		this.ngaySinhNV = ngaySinhNV;
	}

	public String getDiaChiNV() {
		return diaChiNV;
	}

	public void setDiaChiNV(String diaChiNV) {
		this.diaChiNV = diaChiNV;
	}

	public String getSoDienThoaiNV() {
		return soDienThoaiNV;
	}

	public void setSoDienThoaiNV(String soDienThoaiNV) {
		this.soDienThoaiNV = soDienThoaiNV;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyenTruyCap() {
		return quyenTruyCap;
	}

	public void setQuyenTruyCap(String quyenTruyCap) {
		this.quyenTruyCap = quyenTruyCap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTenNV=" + hoTenNV + ", gioiTinhNV=" + gioiTinhNV + ", ngaySinhNV="
				+ ngaySinhNV + ", diaChiNV=" + diaChiNV + ", soDienThoaiNV=" + soDienThoaiNV
				+ ", matKhau=" + matKhau + ", quyenTruyCap=" + quyenTruyCap + "]";
	}


}
