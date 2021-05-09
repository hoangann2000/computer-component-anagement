package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.KhachHang;
import entity.LinhKien;
import Connection.connection;

public class KhachHangConTrol {
	private Connection ketNoi;

	public KhachHangConTrol() {
		// TODO Auto-generated constructor stub
		ketNoi = connection.getJDBCConnection();
	}
	
	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> dsKH = new ArrayList<KhachHang>();
		PreparedStatement stmt = null;
		String sql = "select * from KhachHang";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getString("MaKhachHang"));
				kh.setHoTenKH(rs.getString("HoTenKH"));
				kh.setSoDienThoaiKH(rs.getString("SoDienThoaiKH"));
				kh.setDiaChiKH(rs.getString("DiaChiKH"));

				dsKH.add(kh);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	public List<KhachHang> getAllKhachHang(String maKH) {
		List<KhachHang> dsKH = new ArrayList<KhachHang>();
		PreparedStatement stmt = null;
		String sql = "select * from KhachHang where MaKhachHang=?";
		try {
			stmt = ketNoi.prepareStatement(sql);
			stmt.setString(1, maKH);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getString("MaKhachHang"));
				kh.setHoTenKH(rs.getString("HoTenKH"));
				kh.setSoDienThoaiKH(rs.getString("SoDienThoaiKH"));
				kh.setDiaChiKH(rs.getString("DiaChiKH"));

				dsKH.add(kh);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	
	public List<KhachHang> phanTrang(int fn, int ln) {
		List<KhachHang> dSLK = new ArrayList<KhachHang>();
		PreparedStatement stmt = null;
		String sql = "select * from(select *, ROW_NUMBER() over (order by MaKhachHang) as STT from KhachHang) as PhanTrang where PhanTrang.STT Between "
				+ fn + " and " + ln;
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getString("MaKhachHang"));
				kh.setHoTenKH(rs.getString("HoTenKH"));
				kh.setSoDienThoaiKH(rs.getString("SoDienThoaiKH"));
				kh.setDiaChiKH(rs.getString("DiaChiKH"));
				dSLK.add(kh);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dSLK;
	}
	
	public int demSluongDuLieuTrongDB() {
		int dem = 0;
		String sql = "select count(MaKhachHang) as Dem from KhachHang";
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
	
	public List<KhachHang> timKiemKhachHang(String tk, String vl) {
		List<KhachHang> dsKH = new ArrayList<KhachHang>();
		PreparedStatement stmt = null;
		String sql = "select * from KhachHang where " + tk + " like N'%" + vl + "%'";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKH(rs.getString("MaKhachHang"));
				kh.setHoTenKH(rs.getString("HoTenKH"));
				kh.setSoDienThoaiKH(rs.getString("SoDienThoaiKH"));
				kh.setDiaChiKH(rs.getString("DiaChiKH"));
				dsKH.add(kh);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKH;
	}
	public Boolean themKhachHang(KhachHang khachHang) {
		String sql = "insert into KhachHang values(?,?,?,?)";
		int n;
		try {
			PreparedStatement stmt = ketNoi.prepareStatement(sql);
			stmt.setString(1, khachHang.getMaKH());
			stmt.setString(2, khachHang.getHoTenKH());
			stmt.setString(3, khachHang.getSoDienThoaiKH());
			stmt.setString(4, khachHang.getDiaChiKH());
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
	
	public boolean xoaKhachHang(KhachHang kh) throws SQLException {
		try {
			PreparedStatement stmt = ketNoi.prepareStatement("delete from KhachHang where MaKhachHang = ?");
			stmt.setString(1, kh.getMaKH());
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean capNhatKhachHang(String maKH, KhachHang kh) {
		try {
			PreparedStatement stmt = ketNoi.prepareStatement(
					"update KhachHang set HoTenKH = ?, SoDienThoaiKH= ?,DiaChiKH= ? where MaKhachHang = ?");
			stmt.setString(1, kh.getHoTenKH());
			stmt.setString(2, kh.getSoDienThoaiKH());
			stmt.setString(3, kh.getDiaChiKH());
			stmt.setString(4, maKH);
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public KhachHang getKhachHang(String maKH) {
		KhachHang khachHang = new KhachHang();
		PreparedStatement stmt = null;
		String sql = "select * from KhachHang where MaKhachHang = '" + maKH + "'";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				khachHang.setMaKH(rs.getString("MaKhachHang"));
				khachHang.setHoTenKH(rs.getString("HoTenKH"));
				khachHang.setSoDienThoaiKH(rs.getString("SoDienThoaiKH"));
				khachHang.setDiaChiKH(rs.getString("DiaChiKH"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return khachHang;
	}
}
