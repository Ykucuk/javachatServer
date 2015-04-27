-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Machine: 127.0.0.1
-- Gegenereerd op: 26 apr 2015 om 13:29
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
  `isim` varchar(255) NOT NULL,
  `sifre` varchar(255) NOT NULL,
  `rank` varchar(255) NOT NULL,
  `aktif` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Gegevens worden geëxporteerd voor tabel `hesap`
--

INSERT INTO `hesap` (`id`, `isim`, `sifre`, `rank`, `aktif`) VALUES
(26, 'yasin', '123', 'default', 0),
(28, 'jTextField2', 'jTextField3', 'default', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

