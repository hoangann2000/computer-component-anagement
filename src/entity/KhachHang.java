package entity;

public class KhachHang {
	private String maKH;
	private String hoTenKH;
	private String soDienThoaiKH;
	private String diaChiKH;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH, String hoTenKH, String soDienThoaiKH, String diaChiKH) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.soDienThoaiKH = soDienThoaiKH;
		this.diaChiKH = diaChiKH;
	}
	
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public String getSoDienThoaiKH() {
		return soDienThoaiKH;
	}
	public void setSoDienThoaiKH(String soDienThoaiKH) {
		this.soDienThoaiKH = soDienThoaiKH;
	}
	public String getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTenKH=" + hoTenKH + ", soDienThoaiKH=" + soDienThoaiKH + ", diaChiKH="
				+ diaChiKH + "]";
	}
	
	
}
