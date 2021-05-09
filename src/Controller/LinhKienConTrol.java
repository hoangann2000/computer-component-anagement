package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LinhKien;
import Connection.connection;

public class LinhKienConTrol{
	private Connection ketNoi;

	public LinhKienConTrol() {
		// TODO Auto-generated constructor stub
		ketNoi = connection.getJDBCConnection();
	}

	public List<LinhKien> phanTrang(int fn, int ln) {
		List<LinhKien> dSLK = new ArrayList<LinhKien>();
		PreparedStatement stmt = null;
		String sql = "select * from(select *, ROW_NUMBER() over (order by MaLinhKien) as STT from LinhKien) as PhanTrang where PhanTrang.STT Between "
				+ fn + " and " + ln;
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LinhKien lk = new LinhKien();
				lk.setMaLK(rs.getString("MaLinhKien"));
				lk.setTenLK(rs.getString("TenLinhKien"));
				lk.setMoTaLK(rs.getString("MoTaLinhKien"));
				lk.setDonGiaLK(rs.getDouble("DonGia"));
				lk.setLoaiLK(rs.getString("LoaiLinhKien"));
				lk.setThuongHieu(rs.getString("ThuongHieu"));
				lk.setSlTon(rs.getInt("SoLuongTon"));
				lk.setNgayNhap(rs.getDate("NgayNhap"));
				lk.setBaoHanh(rs.getInt("BaoHanh"));


				dSLK.add(lk);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dSLK;
	}

	public List<LinhKien> getAllLinhKien() {
		List<LinhKien> dSLK = new ArrayList<LinhKien>();
		PreparedStatement stmt = null;
		String sql = "select * from LinhKien";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LinhKien lk = new LinhKien();
				lk.setMaLK(rs.getString("MaLinhKien"));
				lk.setTenLK(rs.getString("TenLinhKien"));
				lk.setMoTaLK(rs.getString("MoTaLinhKien"));
				lk.setDonGiaLK(rs.getDouble("DonGia"));
				lk.setLoaiLK(rs.getString("LoaiLinhKien"));
				lk.setThuongHieu(rs.getString("ThuongHieu"));
				lk.setSlTon(rs.getInt("SoLuongTon"));
				lk.setNgayNhap(rs.getDate("NgayNhap"));
				lk.setBaoHanh(rs.getInt("BaoHanh"));

				dSLK.add(lk);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dSLK;
	}

	public List<LinhKien> timKiemLinhKien(String tk, String vl) {
		List<LinhKien> dSLK = new ArrayList<LinhKien>();
		PreparedStatement stmt = null;
		String sql = "select * from LinhKien where " + tk + " like N'%" + vl + "%'";
		try {
			stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LinhKien lk = new LinhKien();
				lk.setMaLK(rs.getString("MaLinhKien"));
				lk.setTenLK(rs.getString("TenLinhKien"));
				lk.setMoTaLK(rs.getString("MoTaLinhKien"));
				lk.setDonGiaLK(rs.getDouble("DonGia"));
				lk.setLoaiLK(rs.getString("LoaiLinhKien"));
				lk.setThuongHieu(rs.getString("ThuongHieu"));
				lk.setSlTon(rs.getInt("SoLuongTon"));
				lk.setNgayNhap(rs.getDate("NgayNhap"));
				lk.setBaoHanh(rs.getInt("BaoHanh"));
				dSLK.add(lk);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dSLK;
	}

	public Boolean capNhatSoLuongLinhKien(int soLuong, String ma) {
		String sql = "update LinhKien set SoLuongTon -=" + soLuong + " where MaLinhKien = '" + ma + "'";
		try {
			PreparedStatement statement = ketNoi.prepareStatement(sql);
			int n = statement.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Boolean themLinhKien(LinhKien lk) {
		String sql = "insert into LinhKien values(?,?,?,?,?,?,?,?,?)";
		int n;
		try {
			PreparedStatement stmt = ketNoi.prepareStatement(sql);
			stmt.setString(1, lk.getMaLK());
			stmt.setString(2, lk.getTenLK());
			stmt.setString(3, lk.getMoTaLK());
			stmt.setDouble(4, lk.getDonGiaLK());
			stmt.setString(5, lk.getLoaiLK());
			stmt.setString(6, lk.getThuongHieu());
			stmt.setInt(7, lk.getSlTon());
			stmt.setDate(8, lk.getNgayNhap());
			stmt.setInt(9, lk.getBaoHanh());
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

	public boolean deleteLK(LinhKien lk) {

		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = ketNoi.prepareStatement("delete from LinhKien where MaLinhKien= ?");
			stmt.setString(1, lk.getMaLK());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (n > 0) {
			return true;
		} else
			return false;
	}

	public boolean update(LinhKien lk) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.getJDBCConnection().prepareStatement(
					"update LinhKien set TenLinhKien=?,MoTaLinhKien=?,DonGia=?,LoaiLinhKien=?,ThuongHieu=?,SoLuongTon=?,NgayNhap=?,BaoHanh=? where MaLinhKien=?");
			stmt.setString(1, lk.getTenLK());
			stmt.setString(2, lk.getMoTaLK());
			stmt.setDouble(3, lk.getDonGiaLK());
			stmt.setString(4, lk.getLoaiLK());
			stmt.setString(5, lk.getThuongHieu());
			stmt.setInt(6, lk.getSlTon());
			stmt.setDate(7, lk.getNgayNhap());
			stmt.setInt(8, lk.getBaoHanh());
			stmt.setString(9, lk.getMaLK());
			stmt.executeUpdate();
			ketNoi.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return true;

	}

	public int demSluongDuLieuTrongDB() {
		int dem = 0;
		String sql = "select count(MaLinhKien) as Dem from LinhKien";
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

	public static void main(String[] args) {
		LinhKienConTrol linhKienDAO = new LinhKienConTrol();
		System.out.println(linhKienDAO.getAllLinhKien());
	}
}
