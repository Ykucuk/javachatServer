-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Gegenereerd op: 16 mei 2015 om 17:35
-- Serverversie: 5.6.17
-- PHP-versie: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databank: `bilgiagi`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `hesap`
--

CREATE TABLE IF NOT EXISTS `hesap` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `isim` varchar(255) DEFAULT NULL,
  `soyisim` varchar(255) DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `telefon2` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ulke` varchar(255) DEFAULT NULL,
  `sehir` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `hesapAdi` varchar(255) DEFAULT NULL,
  `hesapSifre` varchar(255) DEFAULT NULL,
  `hesapOlusturmaTarihi` varchar(255) DEFAULT NULL,
  `hesapSonGiris` varchar(255) DEFAULT NULL,
  `hesapDurum` int(12) DEFAULT NULL,
  `hesapRutbe` varchar(255) DEFAULT NULL,
  `hesapEmail` varchar(255) DEFAULT NULL,
  `hesapID` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Gegevens worden geëxporteerd voor tabel `hesap`
--

INSERT INTO `hesap` (`id`, `isim`, `soyisim`, `telefon`, `telefon2`, `email`, `ulke`, `sehir`, `adress`, `hesapAdi`, `hesapSifre`, `hesapOlusturmaTarihi`, `hesapSonGiris`, `hesapDurum`, `hesapRutbe`, `hesapEmail`, `hesapID`) VALUES
(1, 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jtextpassword', '0000', NULL, 0, 'jTextField2', 'jTextField2', '0000'),
(2, 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jtextpassword', '0000', NULL, 0, 'jTextField2', 'jTextField2', '0000'),
(3, 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jTextField2', 'jtextpassword', '0000', NULL, 0, 'jTextField2', 'jTextField2', '0000'),
(4, 'Yasin', 'Kucuk', '0625252525', '0685837041', 'y.kucuk@outlook.com', 'Hollanda', 'Ede', 'wasstraat', 'dedemontella', '123456789', '0000', NULL, 0, 'dedemontella', 'y.kucuk@outlook.com', '0000'),
(5, 'dede', 'dede', 'dede', 'dede', 'dede', '', '', '', 'dede', '', '0000', NULL, 0, 'dede', 'dede', '0000'),
(6, 'dede', 'dede', 'dede', 'dede', 'dede', '', '', '', 'dede1', '', '0000', NULL, 0, 'dede1', 'dede', '0000');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
