-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2017 at 12:26 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `friends`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `address_id` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `province` varchar(100) NOT NULL,
  `city_location` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`address_id`, `country`, `city`, `province`, `city_location`) VALUES
('amayendesa', 'zimbabwe', 'harare', 'harare', ''),
('bmay', 'zimbabwe', 'harare', 'harare', ''),
('chix', 'zimbabwe', 'chinhoyi', 'MashWest', ''),
('kmay', 'zimbabwe', 'harare', 'harare', ''),
('pzunza', 'zimbabwe', 'chinhoyi', 'MashWest', 'ColdStream'),
('tawaz', 'zimbabwe', 'harare', 'harare', 'waterfalls');

-- --------------------------------------------------------

--
-- Table structure for table `likes`
--

CREATE TABLE `likes` (
  `time` datetime NOT NULL,
  `like_id` int(11) NOT NULL,
  `person_id` varchar(50) NOT NULL,
  `song_id` int(11) NOT NULL,
  `tag` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `likes`
--

INSERT INTO `likes` (`time`, `like_id`, `person_id`, `song_id`, `tag`) VALUES
('2017-10-06 10:05:43', 86, 'pzunza', 17, 'r'),
('2017-10-06 10:05:43', 87, 'pzunza', 16, 'r'),
('2017-10-06 10:05:43', 88, 'pzunza', 14, 'r'),
('2017-10-06 10:05:43', 89, 'pzunza', 12, 'r'),
('2017-10-06 10:05:43', 90, 'pzunza', 11, 'r'),
('2017-10-06 10:11:54', 91, 'kmay', 16, 'r'),
('2017-10-06 10:11:54', 92, 'kmay', 14, 'r'),
('2017-10-06 10:11:54', 93, 'kmay', 11, 'r'),
('2017-10-06 10:11:54', 94, 'kmay', 7, 'r'),
('2017-10-06 10:11:54', 95, 'kmay', 6, 'r'),
('2017-10-06 10:15:52', 102, 'amayendesa', 17, 'nr'),
('2017-10-06 10:15:52', 103, 'amayendesa', 16, 'nr'),
('2017-10-06 10:15:52', 104, 'amayendesa', 7, 'nr'),
('2017-10-06 10:15:52', 105, 'amayendesa', 6, 'nr'),
('2017-10-06 10:15:52', 106, 'amayendesa', 5, 'nr'),
('2017-10-06 10:15:52', 107, 'amayendesa', 3, 'r'),
('2017-10-06 10:15:52', 108, 'amayendesa', 2, 'nr');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `username` varchar(50) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`username`, `date`) VALUES
('amayendesa', '2017-10-15'),
('bmay', '2017-10-15'),
('chix', '2017-10-15'),
('pzunza', '2017-10-15'),
('tawaz', '2017-10-16');

-- --------------------------------------------------------

--
-- Table structure for table `malikes`
--

CREATE TABLE `malikes` (
  `id` int(11) NOT NULL,
  `like_name` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `person_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `cell` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `password` varchar(100) NOT NULL,
  `address_id` int(11) NOT NULL,
  `hobbie1` varchar(200) NOT NULL,
  `hobbie2` varchar(200) NOT NULL,
  `hobbie3` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`person_id`, `name`, `surname`, `username`, `gender`, `cell`, `dob`, `password`, `address_id`, `hobbie1`, `hobbie2`, `hobbie3`) VALUES
(23, 'aaron', 'mayendesa', 'amayendesa', 'male', '0776824461', '0000-00-00', 'aaron', 56, '', '', ''),
(24, 'bygrage', 'mayendesa', 'bmay', 'male', '077868655', '0000-00-00', 'bmay', 56, '', '', ''),
(25, 'patson', 'zunza', 'pzunza', 'male', '077868655', '0000-00-00', 'pzunza', 56, '', '', ''),
(26, 'albert', 'chisoro', 'chix', 'male', '077868655', '0000-00-00', 'chix', 56, '', '', ''),
(27, 'kimberley', 'mayendesa', 'kmay', 'female', '0776456376', '1996-06-28', 'kmay', 56, 'hockey', '', ''),
(31, 'tawanda', 'nyahuye', 'tawaz', 'male', '0776456376', '2017-10-11', 'tawaz', 56, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `post_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `post` varchar(200) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`post_id`, `username`, `post`, `time`) VALUES
(1, 'amayendesa', 'i like football', '2017-10-03 00:00:00'),
(2, 'pzunza', 'i''m going to watch football', '2017-10-03 00:00:00'),
(3, 'chix', 'i hate football so much', '2017-10-03 00:00:00'),
(4, 'amayendesa', 'i also love cricket', '2017-10-03 00:00:00'),
(5, 'bmay', 'my name is bygrage mayendesa, a cricketer', '2017-10-03 00:00:00'),
(6, 'chix', 'i saw cricket last night, it was boring', '2017-10-03 00:00:00'),
(7, 'chix', 'franklin is a fool', '2017-10-03 00:00:00'),
(8, 'amayendesa', ' i''m cool', '2017-10-03 12:16:32'),
(9, 'amayendesa', ' yes', '2017-10-03 12:19:59'),
(10, 'amayendesa', ' what in the world', '2017-10-03 12:38:34'),
(11, 'amayendesa', ' hey you', '2017-10-03 13:23:13'),
(12, 'amayendesa', ' fytrct', '2017-10-03 13:24:05'),
(13, 'amayendesa', ' kogf', '2017-10-03 13:24:56'),
(14, 'amayendesa', ' but why', '2017-10-03 20:43:05'),
(15, 'amayendesa', ' my name is aaron mayendesa, 2.1', '2017-10-04 09:13:32'),
(16, 'chix', ' me too', '2017-10-05 17:57:17'),
(17, 'kmay', ' i''m kimberley', '2017-10-05 21:06:17');

-- --------------------------------------------------------

--
-- Table structure for table `songs`
--

CREATE TABLE `songs` (
  `song_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `size` int(11) NOT NULL,
  `song` varchar(250) NOT NULL,
  `artist` varchar(30) NOT NULL,
  `genre` varchar(30) NOT NULL,
  `year` varchar(6) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `songs`
--

INSERT INTO `songs` (`song_id`, `name`, `size`, `song`, `artist`, `genre`, `year`, `username`) VALUES
(8, 'your song', 7387197, 'Rita Ora - Your Song (CDQ) (Mp3Goo.com).mp3', 'rita ora', 'pop', '2017', 'chix'),
(9, 'do you mind', 5213666, 'DJ_Khaled_feat_Nicki_Minaj_feat_Chris_Brown_feat_August_Alsina_Do_You_Mind.mp3', 'dj khaled', 'hip-hop', '--', 'chix'),
(10, 'in my corner', 200, 'Fourplay - Elixir - 11 - In My Corner.mp3', 'fourplay', 'jazz', '1990', 'tawaz');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`);

--
-- Indexes for table `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`like_id`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `malikes`
--
ALTER TABLE `malikes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`person_id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`post_id`);

--
-- Indexes for table `songs`
--
ALTER TABLE `songs`
  ADD PRIMARY KEY (`song_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `likes`
--
ALTER TABLE `likes`
  MODIFY `like_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;
--
-- AUTO_INCREMENT for table `malikes`
--
ALTER TABLE `malikes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `person_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `songs`
--
ALTER TABLE `songs`
  MODIFY `song_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
