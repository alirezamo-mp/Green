-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2020 at 11:48 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `air`
--

CREATE TABLE `air` (
  `id` int(11) NOT NULL,
  `company` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `time` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `times` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `m` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `ms` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `mt` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `mf` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `msf` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `img` varchar(10) COLLATE utf8mb4_persian_ci NOT NULL,
  `modele` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `model` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `takhfif` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `price` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `priceb` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `pricee` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `airmodel` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `aircode` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `ttt` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci;

--
-- Dumping data for table `air`
--

INSERT INTO `air` (`id`, `company`, `time`, `times`, `m`, `ms`, `mt`, `mf`, `msf`, `img`, `modele`, `model`, `takhfif`, `price`, `priceb`, `pricee`, `airmodel`, `aircode`, `ttt`) VALUES
(6, 'ماهان', '12 : 30', '15 :00', 'تهران', 'مشهد', '29 خرداد', 'امام خمینی', 'شهید هاشمی نژاد', '2', 'اکونومی', 'سیستمی', '5', '35000000', '25000000', '10000000', 'A458', 'V740', '15'),
(7, 'ایران ایر', '12 : 30', '15 : 00', 'تهران', 'مشهد', '29 خرداد', 'امام خمینی', 'هاشمی نژاد', '1', 'اکونومی', 'سیستمی', '5', '35000000', '25000000', '10000000', 'A458', 'V740', '4'),
(8, 'آتا', '12 : 30', '15 : 00', 'تهران', 'مشهد', '29 خرداد', 'امام خمینی', 'هاشمی نژاد', '3', 'اکونومی', 'سیستمی', '5', '35000000', '25000000', '10000000', 'A458', 'V740', '2'),
(9, 'ماهان', '12 : 30', '15 :00', 'تهران', 'مشهد', '29 خرداد', 'امام خمینی', 'شهید هاشمی نژاد', '2', 'اکونومی', 'سیستمی', '5', '35000000', '25000000', '10000000', 'A458', 'V740', '4');

-- --------------------------------------------------------

--
-- Table structure for table `myusers`
--

CREATE TABLE `myusers` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `email` varchar(250) COLLATE utf8mb4_persian_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `phone` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `type` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci;

--
-- Dumping data for table `myusers`
--

INSERT INTO `myusers` (`id`, `name`, `email`, `pass`, `phone`, `type`) VALUES
(1, 'ali', 'alirezamo5939@gmail.com', '0122', '000000', 'user'),
(2, 'DS', 'admin@gmail.com', '0122', 'asasa', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `pay`
--

CREATE TABLE `pay` (
  `id` int(11) NOT NULL,
  `gh_code` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `time` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `gh_o` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `user_id` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `id` int(11) NOT NULL,
  `air_id` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `user_id` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `family` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `code` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `codes` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `sss` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `tav` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `nameb` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `gh` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL,
  `gh_code` varchar(50) COLLATE utf8mb4_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_persian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `air`
--
ALTER TABLE `air`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `myusers`
--
ALTER TABLE `myusers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pay`
--
ALTER TABLE `pay`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `air`
--
ALTER TABLE `air`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `myusers`
--
ALTER TABLE `myusers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `pay`
--
ALTER TABLE `pay`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tickets`
--
ALTER TABLE `tickets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
