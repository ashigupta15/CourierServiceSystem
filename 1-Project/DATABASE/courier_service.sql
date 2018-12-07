-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 23, 2017 at 04:50 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `courier_service`
--
CREATE DATABASE IF NOT EXISTS `courier_service` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `courier_service`;

-- --------------------------------------------------------

--
-- Table structure for table `admin_authendication`
--

CREATE TABLE IF NOT EXISTS `admin_authendication` (
  `admin_id` int(20) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(100) NOT NULL,
  `admin_password` varchar(50) NOT NULL,
  `admin_mailid` varchar(50) NOT NULL,
  `admin_mobilenumber` varchar(20) NOT NULL,
  `admin_location` varchar(100) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `admin_authendication`
--

INSERT INTO `admin_authendication` (`admin_id`, `admin_username`, `admin_password`, `admin_mailid`, `admin_mobilenumber`, `admin_location`) VALUES
(1, 'admin', 'admin', 'admin@gmail.com', '09039423234', 'chennai'),
(2, 'admin', 'admin', 'admin@gmail.com', '9685743210', 'chennai'),
(3, 'admin', 'admin', 'admin@gmail.com', '9486753210', 'chennai');

-- --------------------------------------------------------

--
-- Table structure for table `delivered_detail`
--

CREATE TABLE IF NOT EXISTS `delivered_detail` (
  `delivered_table_id` int(20) NOT NULL AUTO_INCREMENT,
  `received_person` varchar(100) NOT NULL,
  `delivered_address` varchar(100) NOT NULL,
  `item_id` varchar(50) NOT NULL,
  `delivered_material` varchar(100) NOT NULL,
  `delivered_material_weight` varchar(50) NOT NULL,
  `delivered_person` varchar(50) NOT NULL,
  `user_acknowledgement` varchar(100) NOT NULL,
  `any_notes` varchar(150) NOT NULL,
  PRIMARY KEY (`delivered_table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `delivery_item_management`
--

CREATE TABLE IF NOT EXISTS `delivery_item_management` (
  `table_id` int(20) NOT NULL AUTO_INCREMENT,
  `sender` varchar(50) NOT NULL,
  `sender_address` varchar(200) NOT NULL,
  `receiver` varchar(50) NOT NULL,
  `receiver_address` varchar(200) NOT NULL,
  `delivery_id` varchar(20) NOT NULL,
  `collecting_person_name` varchar(50) NOT NULL,
  `collecting_datetime` varchar(50) NOT NULL,
  `delevery_person_name` varchar(50) NOT NULL,
  `delivering_datetime` varchar(50) NOT NULL,
  `delivery_status` text NOT NULL,
  `user_intimation_status` varchar(100) NOT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `delivery_item_management`
--

INSERT INTO `delivery_item_management` (`table_id`, `sender`, `sender_address`, `receiver`, `receiver_address`, `delivery_id`, `collecting_person_name`, `collecting_datetime`, `delevery_person_name`, `delivering_datetime`, `delivery_status`, `user_intimation_status`) VALUES
(1, 'Ashok', 'Chennai', 'Princy', 'Madurai', '1', 'Ram', '2017-03-22', 'Ravi', 'null', 'Delivered', 'allocate to deliver'),
(2, 'Ashok', 'Chennai', 'Karan', 'Mumbai', '2', 'Ram', '2017-03-22', 'null', 'null', 'need to collect', 'allocated'),
(3, 'Kabilan', 'Banglore', 'Gokul', 'Mumbai', '3', 'null', '2017-03-22', 'Abhishek', 'null', 'need to deliver', 'allocate to deliver'),
(4, 'Kabilan', 'Hyderabad', 'Suresh', 'Banglore', '4', 'null', '2017-03-22', 'null', 'null', 'null', 'null'),
(5, 'Princy', 'Delhi', 'Kayal', 'Mumbai', '5', 'null', '2017-03-22', 'null', 'null', 'null', 'null'),
(6, 'Raj', 'Chennai', 'Gokul', 'Coimbatore', '6', 'Ram', '2017-03-22', 'Jeeva', 'null', 'Five minutes ', 'allocate to deliver'),
(7, 'Diva', 'Coimbatore', 'Gokul', 'Chennai', '7', 'Arul', '2017-03-22', 'pradeep', 'null', 'Delivered', 'allocate to deliver');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_table_id` int(20) NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(20) NOT NULL,
  `employee_name` varchar(100) NOT NULL,
  `employee_designation` varchar(100) NOT NULL,
  `employee_experience` varchar(20) NOT NULL,
  `employee_email_id` varchar(50) NOT NULL,
  `employee_mobile_number` varchar(50) NOT NULL,
  `employee_address` varchar(150) NOT NULL,
  `employee_category` varchar(50) NOT NULL,
  `employee_area` varchar(50) NOT NULL,
  `addrss_allocated` varchar(100) NOT NULL,
  `type_of_service` varchar(50) NOT NULL,
  `item_id` varchar(20) NOT NULL,
  `note` varchar(50) NOT NULL,
  PRIMARY KEY (`employee_table_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_table_id`, `employee_id`, `employee_name`, `employee_designation`, `employee_experience`, `employee_email_id`, `employee_mobile_number`, `employee_address`, `employee_category`, `employee_area`, `addrss_allocated`, `type_of_service`, `item_id`, `note`) VALUES
(1, '1', 'Ram', 'Field Executive', '1', 'Ram@gmail.com', '9772364758', 'Chennai', 'field', 'Chennai', 'not allocated', 'receiving', '6', 'null'),
(2, '2', 'Ravi', 'Field Executive', '2', 'Ravi@gmail.com', '91929394957', 'Madurai', 'field', 'Madurai', 'not allocated', 'delivering', '1', 'null'),
(3, '3', 'Shiva', 'Manager', '5', 'shiva@gmail.com', '8674953210', 'Chennai', 'management', 'not applicable', 'not applicable', 'not applicable', 'not applicable', 'null'),
(4, '4', 'Gokul', 'Senior Manager', '7', 'Gokul', '9685745321', 'Delhi', 'management', 'not applicable', 'not applicable', 'not applicable', 'not applicable', 'need to provide pay slip'),
(5, '5', 'Keshav', 'Manager', '8', 'k.shev@gmail.com', '867541209', 'Mumbai', 'management', 'not applicable', 'not applicable', 'not applicable', 'not applicable', 'null'),
(6, '6', 'Divakar', 'Field Executive', '1.2', 'diva@gmail.com', '9963582741', 'Bangalore', 'field', 'Banglore', 'not allocated', 'not allocated', 'not allocated', 'null'),
(7, '7', 'Venkat', 'Executive', '0.5', 'venukat@gmail.com', '7896523140', 'Hydrabad', 'field', 'Hyderabad', 'not allocated', 'not allocated', 'not allocated', 'null'),
(8, '8', 'Abhishek', 'Field Executive', '1.5', 'abhi@gmail.com', '886599321', 'Mumbai', 'field', 'Mumbai', 'not allocated', 'delivering', '3', 'null'),
(9, '9', 'Arul', 'Field Executive', '2', 'arul@gmail.com', '96853214700', 'Coimbatore', 'field', 'Coimbatore', 'not allocated', 'receiving', '7', 'null'),
(10, '10', 'pradeep', 'Field Executive', '2.1', 'pradee@gmail.com', '8696963552', 'Chennai', 'field', 'Chennai', 'not allocated', 'delivering', '7', 'null'),
(11, '11', 'Vishnu', 'Field Executive', '1', 'vishui@gmail.com', '8695968695', 'Cochin', 'field', 'Cochin', 'not allocated', 'not allocated', 'not allocated', 'null'),
(12, '12', 'sumesh', 'Field Executive', '2.6', 'sumesh@gmail.com', '96857435214', 'Cochin', 'field', 'Cochin', 'not allocated', 'not allocated', 'not allocated', 'null'),
(13, '13', 'Sabareesh', 'Field Executive', '2.2', 'sabareesh@gmail.com', '7689451230', '', 'field', 'Chennai', 'not allocated', 'not allocated', 'not allocated', 'null'),
(14, '14', 'Jeeva', 'Field Executive', '1.1', 'jeeva@gmail.com', '8695734210', 'Coimbatore', 'field', 'Coimbatore', 'not allocated', 'delivering', '6', 'null'),
(15, '15', 'Harish', 'Deputy Distribution manager', '3.5', 'harishqq@gmail.com', '99685573214', 'Chennai', 'management', 'not applicable', 'not applicable', 'not applicable', 'not applicable', 'null'),
(16, '16', 'Kalyan', 'Distribution Manager', '5.1', 'kal.yan@gmail.com', '78963214500', 'Bangalore', 'management', 'not applicable', 'not applicable', 'not applicable', 'not applicable', 'null'),
(17, '17', 'Karventhan', 'Field Executive', '2.5', 'kar.venthhan', '8965743210', 'Madurai', 'field', 'Madurai', 'not allocated', 'not allocated', 'not allocated', 'null'),
(18, '20', 'Diva', 'Manager', '5', 'diva@gmail.com', '9568562223', 'mumbai', 'management', 'not applicable', 'not applicable', 'not applicable', 'not applicable', 'null'),
(19, '22', 'roopa', 'Assistant manager', '5.3', 'roopa@gmail.com', '9685743210', 'roopa.m@gmail.com', 'management', 'not applicable', 'not applicable', 'not applicable', 'not applicable', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `payment_details`
--

CREATE TABLE IF NOT EXISTS `payment_details` (
  `payment_table_id` int(20) NOT NULL AUTO_INCREMENT,
  `sender_name` varchar(150) NOT NULL,
  `item_id` varchar(30) NOT NULL,
  `material_type` varchar(100) NOT NULL,
  `material_weight` varchar(50) NOT NULL,
  `amount_payable` varchar(100) NOT NULL,
  `payment_mode` varchar(50) NOT NULL,
  `payment_received_by` varchar(150) NOT NULL,
  `note` varchar(100) NOT NULL,
  PRIMARY KEY (`payment_table_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `payment_details`
--

INSERT INTO `payment_details` (`payment_table_id`, `sender_name`, `item_id`, `material_type`, `material_weight`, `amount_payable`, `payment_mode`, `payment_received_by`, `note`) VALUES
(1, 'Ashok', '1', 'Application', '8', '96', 'Cash', 'Ram', 'not'),
(2, 'Ashok', '2', 'Food', '90', '1080', 'null', 'null', ''),
(3, 'Kabilan', '3', 'Hardware', '2', '24', 'null', 'null', ''),
(4, 'Kabilan', '4', 'Glass', '15', '180', 'null', 'null', ''),
(5, 'Princy', '5', 'Glass', '20', '240', 'null', 'null', ''),
(6, 'Raj', '6', 'Glass', '5', '60', 'Cash', 'Ram', 'Paid'),
(7, 'Diva', '7', 'Food', '20', '240', 'Cheque', 'Arul', 'Paid');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE IF NOT EXISTS `user_details` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_mail` varchar(100) NOT NULL,
  `user_mobile_number` varchar(20) NOT NULL,
  `user_location` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id`, `user_name`, `user_password`, `user_mail`, `user_mobile_number`, `user_location`) VALUES
(1, 'Ashok', 'as', 'alex@gmail.com', '945625489', 'Chennai'),
(2, 'Kabilan', 'ka', 'kabhi@gmail.com', '9638527410', 'Banglore'),
(3, 'Princu', 'pr', 'princy@gmail.com', '9638521470', 'Delhi'),
(4, 'Raj', 'raj', 'ravi@gmail.com', '986653207', 'Chennai'),
(5, 'Diva', 'diva', 'diva@gmail.com', '9685327410', 'Coimbatore');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
