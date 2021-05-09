-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2021 at 01:30 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlylinhkien`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHoaDon` varchar(10) NOT NULL,
  `MaLinhKien` varchar(10) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHoaDon`, `MaLinhKien`, `SoLuong`) VALUES
('17036132', 'LK1', 1),
('17072617', 'LK2', 1),
('17072617', 'LK3', 1),
('17068042', 'LK2', 1),
('17038911', 'LK4', 1),
('17073222', 'LK1', 1),
('17034452', 'LK3', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` varchar(10) NOT NULL,
  `MaNhanVien` varchar(10) NOT NULL,
  `MaKhachHang` varchar(10) NOT NULL,
  `NgayLapHD` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `MaNhanVien`, `MaKhachHang`, `NgayLapHD`) VALUES
('17036132', 'NV1', '19534931', '2021-04-12'),
('17072617', 'NV1', '19551927', '2021-04-12'),
('17068042', 'NV1', '19535961', '2021-04-12'),
('17038911', 'NV1', '19591556', '2021-04-12'),
('17073222', 'NV1', '19539486', '2021-04-12'),
('17034452', 'NV1', '19515888', '2021-04-12');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhachHang` varchar(10) NOT NULL,
  `HoTenKH` varchar(100) NOT NULL,
  `SoDienThoaiKH` varchar(12) NOT NULL,
  `DiaChiKH` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKhachHang`, `HoTenKH`, `SoDienThoaiKH`, `DiaChiKH`) VALUES
('KH1', 'Hoàng Lê Thiện An', '037730900', 'Huế'),
('KH2', 'Trẫn Sĩ Nguyên Anh', '0132456543', 'Huế'),
('KH3', 'Võ Đức Bảo', '0132456543', 'Đà Nẵng'),
('KH4', 'Đặng Ngọc Châu', '0421254334', 'Quảng Nam'),
('KH5', 'Huỳnh Cao Bảo Long', '0212324543', 'Đà Nẵng'),
('KH6', 'Nguyễn Quang Hoàng Vũ', '0777501570', 'Quãng Ngãi'),
('19534931', 'ngoc', '0777501570', 'da nang'),
('19551927', 'phuc', '0921301239', 'quang nam'),
('19591556', 'duc bao', '0987654321', 'hue'),
('19539486', 'an', '0123456789', 'hue'),
('19537232', 'an hoang', '0123456789', 'hue'),
('19515888', 'bao', '0123456789', 'da nang');

-- --------------------------------------------------------

--
-- Table structure for table `linhkien`
--

CREATE TABLE `linhkien` (
  `MaLinhKien` varchar(10) NOT NULL,
  `TenLinhKien` varchar(100) NOT NULL,
  `MoTaLinhKien` varchar(1000) NOT NULL,
  `DonGia` float NOT NULL,
  `LoaiLinhKien` varchar(100) NOT NULL,
  `ThuongHieu` varchar(100) NOT NULL,
  `SoLuongTon` int(100) NOT NULL,
  `NgayNhap` date NOT NULL,
  `BaoHanh` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `linhkien`
--

INSERT INTO `linhkien` (`MaLinhKien`, `TenLinhKien`, `MoTaLinhKien`, `DonGia`, `LoaiLinhKien`, `ThuongHieu`, `SoLuongTon`, `NgayNhap`, `BaoHanh`) VALUES
('LK1', 'Ổ cứng HDD Seagate Backup Plus', 'Tên sản phẩm: ổ cứng HDD Seagate 1TB Backup Plus 3.0, 2.5\'\' (Đỏ)\r\n- Dung lượng: 1TB\r\n- Kích thước: 2.5\"\r\n- Kết nối: USB 3.0', 1640000, 'HDD', 'SEAGATE', 30, '2020-06-10', 36),
('LK2', 'Ổ cứng HDD Seagate Expansion Desktop 3TB 3.5\" 3.0', 'Tên sản phẩm: ổ cứng HDD Seagate Expansion Desktop 3TB 3.5\" 3.0 (STEB3000300)\r\n- Dung lượng: 3TB\r\n- Kích thước: 3.5\"\r\n- Kết nối: USB 3.0', 2890000, 'HDD', 'SEAGATE', 22, '2020-01-01', 36),
('LK3', 'Tản nhiệt CPU AIO Cooler Master Masterliquid ', 'Tên sản phẩm: Tản nhiệt CPU AIO CM Masterliquid ML240P Mirage\r\n\r\n- Tên sản phẩm: MASTERLIQUID ML240P MIRAGE\r\n- Dạng tản nhiệt: Tản nước\r\n- Chất liệu: Nhôm', 3840000, 'Tản nhiệt', 'Cooler Master', 20, '2020-04-15', 60),
('LK4', 'Đế tản nhiệt Laptop DEEPCOOL Windpal Mini', 'Tên sản phẩm: Tản nhiệt/ Fan laptop Deep cool Windpal Mini\r\n\r\n- Cổng kết nối: USB\r\n- Phù hợp laptop 15.6\" trở xuống\r\n- Tốc độ quạt: 1000 ± 10% rpm\r\n- Kích thước: 140x140x15 mm\r\n- Trọng lượng: 575g\r\n- Màu sắc: Đen', 209000, 'Tản Nhiệt', 'DEEPCOOL', 33, '2020-03-12', 12),
('Lk5', 'RAM desktop ADATA AD4U240038G17-R (1x8GB) DDR4 2400MHz', 'Tên sản phẩm: Bộ nhớ DDR4 Adata 8GB (2400) AD4U240038G17-R\r\n- Dung lượng: 1 x 8GB\r\n- Thế hệ: DDR4\r\n- Bus: 2400MHz', 1490000, 'RAM', 'ADATA', 20, '2020-02-14', 36),
('LK123456', 'a', 'testt', 200000, 'RAM', 'ssd', 1, '2021-02-10', 30);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` varchar(10) NOT NULL,
  `HoTenNV` varchar(100) NOT NULL,
  `GioiTinhNV` varchar(10) NOT NULL,
  `NgaySinhNV` date NOT NULL,
  `DiaChiNV` varchar(100) NOT NULL,
  `SoDienThoaiNV` varchar(12) NOT NULL,
  `MatKhau` varchar(20) NOT NULL,
  `QuyenTruyCap` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `HoTenNV`, `GioiTinhNV`, `NgaySinhNV`, `DiaChiNV`, `SoDienThoaiNV`, `MatKhau`, `QuyenTruyCap`) VALUES
('NV1', 'Hoàng Lê Thiện An', 'Nam', '2000-09-28', 'Huế', '0377730900', '123456              ', 'User      '),
('NV2', 'Hoàng A', 'Nam', '2000-09-28', 'Đà Nẵng', '0377730901', '123456              ', 'Admin      '),
('NV3', 'Hoàng B', 'Nữ', '2000-09-28', 'Đà Nẵng', '0377730902', '123456              ', 'Admin      '),
('NV4', 'Hoàng C', 'Nam', '2000-09-28', 'Đà Nẵng', '0377730901', '123456              ', 'Admin      '),
('NV5', 'Hoàng D', 'Nam', '2000-09-28', 'Đà Nẵng', '0377730901', '123456              ', 'Admin      ');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
