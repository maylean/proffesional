-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 28, 2017 at 06:55 AM
-- Server version: 5.1.36
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `myjobconnect`
--

-- --------------------------------------------------------

--
-- Table structure for table `companyprofile`
--

CREATE TABLE IF NOT EXISTS `companyprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(512) NOT NULL,
  `location` varchar(512) NOT NULL,
  `phonenumber` int(20) NOT NULL,
  `tinnumber` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `companyprofile`
--

INSERT INTO `companyprofile` (`id`, `name`, `location`, `phonenumber`, `tinnumber`) VALUES
(1, 'my job connect', 'kampala', 4, 6),
(2, 'my job connect', 'kampala', 1234567890, 1234567890);

-- --------------------------------------------------------

--
-- Table structure for table `getjob`
--

CREATE TABLE IF NOT EXISTS `getjob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(512) NOT NULL,
  `lastname` varchar(512) NOT NULL,
  `email` varchar(511) NOT NULL,
  `phone` varchar(511) NOT NULL,
  `password` varchar(511) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `getjob`
--

INSERT INTO `getjob` (`id`, `firstname`, `lastname`, `email`, `phone`, `password`) VALUES
(1, 'patrick', 'maylean', 'pacmac2013@gmail.com', '999000303', '77666666');

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE IF NOT EXISTS `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job` varchar(512) NOT NULL,
  `jobdescription` varchar(512) NOT NULL,
  `skills` varchar(512) NOT NULL,
  `amount` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`id`, `job`, `jobdescription`, `skills`, `amount`) VALUES
(1, 'web development', 'e commerce website', 'oop php', '5400000');

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profession` varchar(512) NOT NULL,
  `skills` varchar(512) NOT NULL,
  `projectslink` varchar(512) NOT NULL,
  `experince` varchar(512) NOT NULL,
  `education` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`id`, `profession`, `skills`, `projectslink`, `experince`, `education`) VALUES
(1, 'software eng', 'oop php', 'codeeagle', 'a5years', 'degree');
