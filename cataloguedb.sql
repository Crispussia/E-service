-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 19, 2023 at 11:03 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cataloguedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id`, `nom`) VALUES
(1, 'Livres'),
(2, 'DVDs'),
(3, 'CDs');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL,
  `adresse` varchar(250) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `adresse`, `email`, `nom`, `telephone`) VALUES
(4, '140 Rue Marivaux', 'degbelocrispussia24@gmail.com', 'Degbelo Crispussia', '+33 94518407'),
(31, '25 Rue de la Vendée', 'degbelocrispussia24@yahoo.com', 'Agoï Crispussia DEGBELO', '0749770925');

-- --------------------------------------------------------

--
-- Table structure for table `commande_client`
--

DROP TABLE IF EXISTS `commande_client`;
CREATE TABLE IF NOT EXISTS `commande_client` (
  `id` int(11) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `dernier_maj` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `no_confirmation` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn3xxvum7o26utrh4c1vhbvgaq` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `commande_client`
--

INSERT INTO `commande_client` (`id`, `date_creation`, `dernier_maj`, `montant`, `no_confirmation`, `client_id`) VALUES
(11, '2023-01-28 15:58:56', '2023-01-28 15:58:56', 39.65, 64083991, 4),
(12, '2023-01-28 15:58:56', '2023-01-28 15:58:56', 39.65, 64083991, 4),
(13, '2023-01-28 15:58:56', '2023-01-28 15:58:56', 39.65, 64083991, 4),
(16, '2023-01-28 16:16:10', '2023-01-28 16:16:10', 79.3, 35112290, 4),
(17, '2023-01-28 16:16:10', '2023-01-28 16:16:10', 79.3, 35112290, 4),
(19, '2023-01-28 00:00:00', '2023-01-28 00:00:00', 39.65, 53697782, 4),
(20, '2023-01-28 00:00:00', '2023-01-28 00:00:00', 39.65, 53697782, 4),
(22, '2023-01-28 00:00:00', '2023-01-28 00:00:00', 28, 59319732, 4),
(23, '2023-01-28 00:00:00', '2023-01-28 00:00:00', 28, 59319732, 4),
(25, '2023-02-01 15:25:11', '2023-02-01 15:25:11', 39.65, 54731817, 4),
(26, '2023-02-01 15:25:11', '2023-02-01 15:25:11', 39.65, 54731817, 4),
(28, '2023-02-01 15:29:57', '2023-02-01 15:29:57', 99.3, 75719464, 4),
(29, '2023-02-01 15:29:57', '2023-02-01 15:29:57', 99.3, 75719464, 4),
(32, '2023-02-01 20:53:41', '2023-02-01 20:53:41', 25.98, 43131954, 31),
(33, '2023-02-01 20:53:41', '2023-02-01 20:53:41', 25.98, 43131954, 31),
(35, '2023-02-01 20:53:41', '2023-02-01 20:53:41', 25.98, 43131954, 31),
(37, '2023-02-01 21:04:30', '2023-02-01 21:04:30', 60.720000000000006, 44173087, 31),
(42, '2023-02-02 20:48:04', '2023-02-02 20:48:04', 79.64, 21460076, 4),
(45, '2023-02-08 16:19:50', '2023-02-08 16:19:50', 45.74, 92619295, 4),
(48, '2023-02-18 21:10:28', '2023-02-18 21:10:28', 8.5, 58565045, 4),
(50, '2023-02-18 21:16:12', '2023-02-18 21:16:12', 39.98, 51583878, 4),
(52, '2023-02-18 21:44:39', '2023-02-18 21:44:39', 19.99, 76521092, 31),
(54, '2023-02-18 22:06:48', '2023-02-18 22:06:48', 8.74, 63123976, 31),
(56, '2023-02-18 22:39:59', '2023-02-18 22:39:59', 59.98, 56082098, 31),
(58, '2023-02-18 22:52:51', '2023-02-18 22:52:51', 39.98, 83485927, 31),
(60, '2023-02-18 22:57:25', '2023-02-18 22:57:25', 75.97999999999999, 52838100, 31),
(63, '2023-02-18 23:02:39', '2023-02-18 23:02:39', 89.3, 42389287, 31),
(65, '2023-02-19 11:27:03', '2023-02-19 11:27:03', 27, 35045349, 31),
(67, '2023-02-19 11:41:37', '2023-02-19 11:41:37', 8.5, 80197672, 31),
(69, '2023-02-19 11:44:39', '2023-02-19 11:44:39', 8.5, 63918924, 31),
(71, '2023-02-19 11:50:12', '2023-02-19 11:50:12', 8.5, 91419293, 31),
(73, '2023-02-19 12:03:32', '2023-02-19 12:03:32', 54.97, 62690611, 31),
(76, '2023-02-19 14:49:24', '2023-02-19 14:49:24', 27, 78662628, 31),
(78, '2023-02-19 23:56:24', '2023-02-19 23:56:25', 8.5, 87890063, 31);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(80),
(80),
(80),
(80),
(80);

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL,
  `dernier_maj` datetime DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `nom` varchar(45) NOT NULL,
  `prix` double NOT NULL,
  `categorie_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKejxvy5dl65jihv1v5k6v9vqd6` (`categorie_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id`, `dernier_maj`, `description`, `image`, `nom`, `prix`, `categorie_id`) VALUES
(5, '2023-01-26 00:00:00', 'An application running in the cloud can benefit from incredible efficiencies, but they come with unique security threats too.', 'https://itbook.store/img/books/9781617294136.png', 'Securing DevOps', 39.65, 1),
(6, '2023-01-26 00:00:00', 'Today we have the ability to connect speech, touch, haptic, and gestural interfaces into products that engage several human senses at once.', 'https://itbook.store/img/books/9781491954249.png', 'Designing Across Senses', 8, 1),
(7, '2023-01-26 00:00:00', '12 titres mythiques d\'un répertoire qui a changé le cours de la chanson française, des textes passionnés, des mélodies légendaires, magnifiés par la voix intemporelle de Chimène. ', 'https://static.fnac-static.com/multimedia/Images/FR/NR/26/6d/e0/14708006/1540-1/tsp20220915145135/Chimene-chante-Piaf-Edition-Limitee.jpg', 'Chimène Chante Piaf', 14.99, 3),
(8, '2023-01-26 00:00:00', 'La tournée historique des stade ! inclus le concert événement sur 3 CD', 'https://tse3.mm.bing.net/th?id=OIP.nnc29MHb8uBuryv9hSEvEwHaEK&pid=Api&P=0', 'Central Tour', 19.99, 3),
(9, '2023-01-26 00:00:00', 'Un convoyeur de fonds fraîchement engagé étonne ses collègues par l’incroyable précision de ses tirs de riposte quand ils sont attaqués par des braqueurs expérimentés. Tous se demandent désormais qui il est et d’où il vient.', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqm3Icw9t7Gi6oSvk4zkLHZI0uHnPO8AnVhjWAAYVd&s', 'Un Homme en colère', 8.74, 2),
(10, '2023-01-26 00:00:00', 'Dalida, 1 DVD, 129 minutes', 'https://tse3.mm.bing.net/th?id=OIP.ospskeVpFR8Bs7J_lK4AQAHaNW&pid=Api&P=0', 'Dalida', 8.5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `produit_commande`
--

DROP TABLE IF EXISTS `produit_commande`;
CREATE TABLE IF NOT EXISTS `produit_commande` (
  `id` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `commande_client_id` int(11) NOT NULL,
  `produit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiuuk9tuwrt7d7hh5shg0a6flu` (`commande_client_id`),
  KEY `FKreisu6j044f6laacmkwq82bh5` (`produit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produit_commande`
--

INSERT INTO `produit_commande` (`id`, `quantite`, `commande_client_id`, `produit_id`) VALUES
(14, 1, 13, 5),
(18, 2, 17, 5),
(21, 1, 20, 5),
(24, 1, 23, 6),
(27, 1, 26, 5),
(30, 2, 29, 5),
(34, 1, 33, 10),
(36, 2, 35, 9),
(38, 2, 37, 10),
(39, 1, 37, 9),
(40, 1, 37, 8),
(41, 1, 37, 7),
(43, 1, 42, 5),
(44, 1, 42, 8),
(46, 1, 45, 9),
(47, 2, 45, 10),
(49, 1, 48, 10),
(51, 2, 50, 8),
(53, 1, 52, 8),
(55, 1, 54, 9),
(57, 2, 56, 8),
(59, 2, 58, 8),
(61, 2, 60, 8),
(62, 2, 60, 6),
(64, 2, 63, 5),
(66, 2, 65, 10),
(68, 1, 67, 10),
(70, 1, 69, 10),
(72, 1, 71, 10),
(74, 2, 73, 8),
(75, 1, 73, 7),
(77, 2, 76, 10),
(79, 1, 78, 10);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
