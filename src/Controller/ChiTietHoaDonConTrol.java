package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;
import Connection.connection;

public class ChiTietHoaDonConTrol {
	private Connection ketNoi;

	public ChiTietHoaDonConTrol() {
		// TODO Auto-generated constructor stub
		ketNoi = connection.getJDBCConnection();
	}

	public List<ChiTietHoaDon> getAllChiTietHoaDon(String maHD) {
		List<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
		String sql = "select *, l.DonGia from ChiTietHoaDon c join LinhKien l on c.MaLinhKien = l.MaLinhKien where c.MaHoaDon = '"
				+ maHD + "'";
		try {
			PreparedStatement stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				HoaDon hd = new HoaDon(rs.getString("MaHoaDon"));
				LinhKien lk = new LinhKien(rs.getString("MaLinhKien"));
				lk.setDonGiaLK(rs.getDouble("DonGia"));
				chiTietHoaDon.setHoaDon(hd);
				chiTietHoaDon.setLinhKien(lk);
				chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
				dsCTHD.add(chiTietHoaDon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsCTHD;
	}

	public List<LinhKien> getChiTietHoaDon(String maHD) {
		List<LinhKien> dsLK = new ArrayList<LinhKien>();
		String sql = "select l.MaLinhKien, l.TenLinhKien, c.SoLuong, l.DonGia, l.BaoHanh from ChiTietHoaDon c join LinhKien l on c.MaLinhKien = l.MaLinhKien where c.MaHoaDon = '"
				+ maHD + "'";
		try {
			PreparedStatement stmt = ketNoi.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LinhKien linhKien = new LinhKien();
				linhKien.setMaLK(rs.getString("MaLinhKien"));
				linhKien.setTenLK(rs.getString("TenLinhKien"));
				linhKien.setSlTon(rs.getInt("SoLuong"));
				linhKien.setDonGiaLK(rs.getDouble("DonGia"));
				linhKien.setBaoHanh(rs.getInt("BaoHanh"));
				dsLK.add(linhKien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsLK;
	}

	public Boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		String sql = "insert into ChiTietHoaDon values(?,?,?)";
		int n;
		try {
			PreparedStatement stmt = ketNoi.prepareStatement(sql);
			stmt.setString(1, chiTietHoaDon.getHoaDon().getMaHD());
			stmt.setString(2, chiTietHoaDon.getLinhKien().getMaLK());
			stmt.setInt(3, chiTietHoaDon.getSoLuong());
			n = stmt.executeUpdate();
			if (n > 0)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
