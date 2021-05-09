package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;
import Connection.connection;

public class HoaDonConTrol {
	private Connection ketNoi;

	public HoaDonConTrol() {
		// TODO Auto-generated constructor stub
		ketNoi = connection.getJDBCConnection();
	}

	public List<HoaDon> getAllHoaDon() {
		List<HoaDon> dsHD = new ArrayList<HoaDon>();
		PreparedStatement stmt = null;
		String sql = "select * from HoaDon";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HoaDon hd = new HoaDon();
				NhanVien nv = new NhanVien(rs.getString("MaNhanVien"));
				KhachHang kh = new KhachHang(rs.getString("MaKhachHang"));
				hd.setMaHD(rs.getString("MaHoaDon"));
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);
				hd.setNgayLapHD(rs.getDate("NgayLapHD"));
				dsHD.add(hd);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	public List<HoaDon> getHoaDon() {
		List<HoaDon> dsHD = new ArrayList<HoaDon>();
		PreparedStatement stmt = null;
		String sql = "select h.MaHoaDon, h.MaNhanVien, n.HoTenNV, h.MaKhachHang, k.HoTenKH, h.NgayLapHD from HoaDon h join NhanVien n on n.MaNhanVien = h.MaNhanVien join KhachHang k on k.MaKhachHang = h.MaKhachHang";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HoaDon hd = new HoaDon();
				NhanVien nv = new NhanVien(rs.getString("MaNhanVien"));
				nv.setHoTenNV(rs.getString("HoTenNV"));
				KhachHang kh = new KhachHang(rs.getString("MaKhachHang"));
				kh.setHoTenKH(rs.getString("HoTenKH"));
				hd.setMaHD(rs.getString("MaHoaDon"));
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);
				hd.setNgayLapHD(rs.getDate("NgayLapHD"));
				dsHD.add(hd);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public List<HoaDon> phanTrang(int fn, int ln) {
		List<HoaDon> dsHD = new ArrayList<HoaDon>();
		PreparedStatement stmt = null;
		String sql = "select * from(select ROW_NUMBER() over (order by h.MaHoaDon) as STT, h.MaHoaDon, h.MaNhanVien, n.HoTenNV, h.MaKhachHang, k.HoTenKH, h.NgayLapHD from HoaDon h join NhanVien n on n.MaNhanVien = h.MaNhanVien join KhachHang k on k.MaKhachHang = h.MaKhachHang) as PhanTrang where PhanTrang.STT Between "
				+ fn + " and " + ln;
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HoaDon hd = new HoaDon();
				NhanVien nv = new NhanVien(rs.getString("MaNhanVien"));
				nv.setHoTenNV(rs.getString("HoTenNV"));
				KhachHang kh = new KhachHang(rs.getString("MaKhachHang"));
				kh.setHoTenKH(rs.getString("HoTenKH"));
				hd.setMaHD(rs.getString("MaHoaDon"));
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);
				hd.setNgayLapHD(rs.getDate("NgayLapHD"));
				dsHD.add(hd);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	public int demSluongDuLieuTrongDB() {
		int dem = 0;
		String sql = "select count(MaHoaDon) as Dem from HoaDon";
		try {
			PreparedStatement statement = ketNoi.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dem = rs.getInt("Dem");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem;
	}
	public List<HoaDon> timKiemHoaDon(String vl) {
		List<HoaDon> dsHD = new ArrayList<HoaDon>();
		PreparedStatement stmt = null;
		String sql = "select h.MaHoaDon, h.MaNhanVien, n.HoTenNV, h.MaKhachHang, k.HoTenKH, h.NgayLapHD from HoaDon h join NhanVien n on n.MaNhanVien = h.MaNhanVien join KhachHang k on k.MaKhachHang = h.MaKhachHang where MaHoaDon like '%"
				+ vl + "%'";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				HoaDon hd = new HoaDon();
				NhanVien nv = new NhanVien(rs.getString("MaNhanVien"));
				nv.setHoTenNV(rs.getString("HoTenNV"));
				KhachHang kh = new KhachHang(rs.getString("MaKhachHang"));
				kh.setHoTenKH(rs.getString("HoTenKH"));
				hd.setMaHD(rs.getString("MaHoaDon"));
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);
				hd.setNgayLapHD(rs.getDate("NgayLapHD"));
				dsHD.add(hd);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}

	public Boolean themHoaDon(HoaDon hoaDon) {
		String sql = "insert into HoaDon values(?,?,?,?)";
		int n;
		try {
			PreparedStatement stmt = ketNoi.prepareStatement(sql);
			stmt.setString(1, hoaDon.getMaHD());
			stmt.setString(2, hoaDon.getNhanVien().getMaNV());
			stmt.setString(3, hoaDon.getKhachHang().getMaKH());
			stmt.setDate(4, hoaDon.getNgayLapHD());
			try {
				n = stmt.executeUpdate();
				if (n > 0)
					return true;
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
