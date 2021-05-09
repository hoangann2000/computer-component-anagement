package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.KhachHang;
import entity.NhanVien;
import Connection.connection;

public class NhanVienConTrol {
	private Connection ketNoi;

	public NhanVienConTrol() {
		// TODO Auto-generated constructor stub
		ketNoi = connection.getJDBCConnection();
	}

	public List<NhanVien> getAllNV() {
		List<NhanVien> dsNV = new ArrayList<NhanVien>();
		PreparedStatement stmt = null;
		String sql = "select * from NhanVien";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getString("MaNhanVien"));
				nv.setHoTenNV(rs.getString("HoTenNV"));
				nv.setGioiTinhNV(rs.getString("GioiTinhNV"));
				nv.setNgaySinhNV(rs.getDate("NgaySinhNV"));
				nv.setDiaChiNV(rs.getString("DiaChiNV"));
				nv.setSoDienThoaiNV(rs.getString("SoDienThoaiNV"));
				nv.setMatKhau(rs.getString("MatKhau"));
				nv.setQuyenTruyCap(rs.getString("QuyenTruyCap"));
				dsNV.add(nv);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}

	public List<NhanVien> getAllNV(String maNV) throws Exception {
		List<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			PreparedStatement stmt = ketNoi.prepareStatement("select * from NhanVien where MaNhanVien = ?");
			stmt.setString(1, maNV);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getString("MaNhanVien"));
				nv.setHoTenNV(rs.getString("HoTenNV"));
				nv.setGioiTinhNV(rs.getString("GioiTinhNV"));
				nv.setNgaySinhNV(rs.getDate("NgaySinhNV"));
				nv.setDiaChiNV(rs.getString("DiaChiNV"));
				nv.setSoDienThoaiNV(rs.getString("SoDienThoaiNV"));
				nv.setMatKhau(rs.getString("MatKhau"));
				nv.setQuyenTruyCap(rs.getString("QuyenTruyCap"));
				dsNV.add(nv);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}

		return dsNV;
	}

	public boolean themNV(NhanVien nv) throws SQLException {
		String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = ketNoi.prepareStatement(sql);

			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getHoTenNV());
			stmt.setString(3, nv.getGioiTinhNV());
			stmt.setDate(4, nv.getNgaySinhNV());
			stmt.setString(5, nv.getDiaChiNV());
			stmt.setString(6, nv.getSoDienThoaiNV());
			stmt.setString(7, nv.getMatKhau());
			stmt.setString(8, nv.getQuyenTruyCap());

			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			;
		}

		return false;
	}

	public boolean xoaNV(NhanVien nv) throws SQLException {
		try {
			PreparedStatement stmt = ketNoi.prepareStatement("delete from NhanVien where MaNhanVien = ?");
			stmt.setString(1, nv.getMaNV());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateNV(String maNV, NhanVien nv) {

		try {
			PreparedStatement stmt = ketNoi.prepareStatement(
					"update NhanVien set HoTenNV = ?, GioiTinhNV=?,NgaySinhNV=?,DiaChiNV=?,SoDienThoaiNV= ?,MatKhau=?,QuyenTruyCap=? where MaNhanVien = ?");
			stmt.setString(1, nv.getHoTenNV());
			stmt.setString(2, nv.getGioiTinhNV());
			stmt.setDate(3, nv.getNgaySinhNV());
			stmt.setString(4, nv.getDiaChiNV());
			stmt.setString(5, nv.getSoDienThoaiNV());
			stmt.setString(6, nv.getMatKhau());
			stmt.setString(7, nv.getQuyenTruyCap());
			stmt.setString(8, nv.getMaNV());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public NhanVien getNhanVien(String maNV) {
		NhanVien nhanVien = new NhanVien();
		PreparedStatement stmt = null;
		String sql = "select * from NhanVien where MaNhanVien = " + maNV;
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				nhanVien.setMaNV(rs.getString("MaNhanVien"));
				nhanVien.setHoTenNV(rs.getString("HoTenNV"));
				nhanVien.setGioiTinhNV(rs.getString("GioiTinhNV"));
				nhanVien.setNgaySinhNV(rs.getDate("NgaySinhNV"));
				nhanVien.setDiaChiNV(rs.getString("DiaChiNV"));
				nhanVien.setSoDienThoaiNV(rs.getString("SoDienThoaiNV"));
				nhanVien.setMatKhau(rs.getString("MatKhau"));
				nhanVien.setQuyenTruyCap(rs.getString("QuyenTruyCap"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanVien;
	}
}
