-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2019 at 09:28 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3
create database finmandb;
use finmandb;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `detsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblexpense`
--
create table `UserRole` (
	`ID` int (10) not null,
    `RoleName` nvarchar(20)
);

create table `ExpenseItem` (
	`ID` int not null,
    `ItemName` nvarchar(50)
);

CREATE TABLE `Expense` (
  `ID` int ,
  `UserId` int NOT NULL,
  `ExpenseDate` date DEFAULT NULL,
  `ExpenseItem` int(10) DEFAULT NULL,
  `ExpenseCost` Decimal DEFAULT NULL,
  `NoteDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Note` varchar(255) not null,
  foreign key(UserId) references Users(ID),
  foreign key (ExpenseItem) references ExpenseItem(ID)
) ;

--
-- Dumping data for table `tblexpense`
--

insert into `UserRole`(`ID`, `RoleName`) values 
(2, 'Leader'),
(3, 'Member'); 

insert into `ExpenseItem` (`ID`,`ItemName`) values
(1, 'Food & Drink'),
(2, 'Shopping'),
(3, 'Transportation'),
(4,'Rentals'),
(5, 'Water Bill'),
(6, 'Phone Bill'),
(7, 'Internet Bill'),
(8,'Education'),
(9, 'Insurances'),
(10, 'Gifts & Donations');

insert into `Expense` (`ID`, `UserId`, `ExpenseDate`, `ExpenseItem`, `ExpenseCost`, `NoteDate`, `Note`) VALUES
(1, 39, '2019-05-15', '1', '63000', NULL,'sandwich'),
(2, 39, '2019-05-15', '2', '52000', '2019-05-15 10:06:19', 'T-shirt'),
(3, 39, '2019-05-15', '2', '52000', '2019-05-15 10:07:08', 'T-shirt'),
(4, 39, '2019-05-14', '1', '83000', '2019-05-15 10:07:27','sandwich'),
(5, 39, '2019-05-14', '3', '11000', '2019-05-15 10:07:49', 'Bus ticket'),
(6, 38, '2019-05-12', '3', '89000', '2019-05-15 10:08:09', 'Bus ticket'),
(7,38, '2019-05-10', '5', '56000', '2019-05-15 10:08:26', 'drink water'),
(8, 38, '2019-04-24', '5', '102000', '2019-05-15 10:08:44', 'shower'),
(9, 38, '2019-05-08', '5', '89000', '2019-05-15 10:08:57', 'drink water'),
(10, 38, '2018-12-19', '3', '112000', '2019-05-15 10:09:34','Bus ticket'),
(11, 39, '2018-12-19', '2', '56000', '2019-05-15 10:09:52', 'T-shirt'),
(13, 39, '2018-12-20', '1', '30000', '2019-05-15 10:15:47', 'sandwich');
-- (14, 2, '2019-05-14', 'Milk', '360', '2019-05-15 10:21:31'),
-- (15, 3, '2019-05-15', 'Milk', '123', '2019-05-15 10:29:56'),
-- (16, 3, '2019-05-15', 'Household Items', '360', '2019-05-15 10:30:06'),
-- (17, 3, '2019-05-15', 'Bed Sheets', '3000', '2019-05-15 10:30:18'),
-- (18, 3, '2019-05-07', 'Milk', '123', '2019-05-15 10:30:28'),
-- (19, 3, '2019-05-14', 'Household Items', '3600', '2019-05-15 10:30:38'),
-- (20, 2, '2019-05-14', 'Electric Board Extension', '300', '2019-05-15 15:11:33'),
-- (21, 2, '2019-04-11', 'Milk', '123', '2019-05-15 17:50:24'),
-- (22, 2, '2019-04-10', 'Household Items', '520', '2019-05-15 17:50:37'),
-- (23, 2, '2019-05-16', 'Household Items', '360', '2019-05-16 07:29:54'),
-- (25, 8, '2019-05-17', 'Milk', '3600', '2019-05-17 05:35:13'),
-- (26, 8, '2019-05-16', 'Bed Sheets', '1025', '2019-05-17 05:35:42'),
-- (27, 1, '2019-05-17', 'Computer Mouse', '500', '2019-05-18 05:19:05'),
-- (30, 1, '2019-05-18', 'Milk + Bread', '80', '2019-05-18 05:22:01'),
-- (31, 10, '2019-05-16', 'Computer Mouse', '500', '2019-05-18 05:35:45'),
-- (32, 10, '2019-05-17', 'Milk+Bread', '80', '2019-05-18 05:36:06'),
-- (33, 10, '2019-05-18', 'Room Rent', '10000', '2019-05-18 05:36:26');

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

CREATE TABLE `Users` (
  `ID` int ,
  `FullName` varchar(150) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `MobileNumber` varchar(10) DEFAULT NULL,
  `Password` varchar(200) DEFAULT NULL,
  `RegDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UserRole` varchar(20)
  
) ;

create table `IncomeSource`(
	`ID` int ,
    `InSource` varchar (150) default null
);
insert into `IncomeSource` (`ID`, `InSource`) values(1, 'salary'),(2, 'bonus');
CREATE TABLE `Income` (
  `ID` int ,
  `UserId` int NOT NULL,
  `IncomeDate` date DEFAULT NULL,
  `IncomeItem` int DEFAULT NULL,
  `IncomeCost` Decimal DEFAULT NULL,
  `NoteDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  
  foreign key(UserId) references Users(ID),
  foreign key (IncomeItem) references IncomeSource(ID)
) ;
insert into `Income` (`ID`, `UserId`, `IncomeDate`, `IncomeItem`, `IncomeCost`, `NoteDate`) VALUES
(1, 39, '2019-05-15', '1', '630000', NULL),
(2, 39, '2019-05-15', '2', '52000', '2019-05-15 10:06:19'),
(3, 39, '2019-05-15', '2', '52000', '2019-05-15 10:07:08'),
(4, 39, '2019-05-14', '1', '830000', '2019-06-15 10:07:27');
--
-- Dumping data for table `tbluser`
--
-- insert into `Users` (`ID`,`FullName`) values
-- (1, 'Food & Drink'),
insert into `Users` (`ID`, `FullName`,`UserRole`, `Email`, `MobileNumber`, `Password`, `RegDate`) VALUES
(1, 'Nguyễn Trung Vũ','ROLE_ADMIN', 'a@gmail.com', 8989898897, '81dc9bdb52d04dc20036dbd8313ed055', '2019-05-15 08:52:27');
-- (3, '', 'khusi@gmail.com', 5645798897, '202cb962ac59075b964b07152d234b70', '2019-05-15 08:52:27'),
-- (4, 'Shantanu Bhardwaj', 'shan@gmail.com', 7895641236, '202cb962ac59075b964b07152d234b70', '2019-05-17 05:13:23'),
-- (8, 'Test', 'test@gmail.com', 5656556565, '202cb962ac59075b964b07152d234b70', '2019-05-17 05:34:16'),
-- (9, 'Anuj kumar', 'phpgurukulofficial@gmail.com', 1234567890, 'f925916e2754e5e03f75dd58a5733251', '2019-05-18 05:31:47'),
-- (10, 'Test User demo', 'testuser@gmail.com', 987654321, 'f925916e2754e5e03f75dd58a5733251', '2019-05-18 05:34:53');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblexpense`
--
ALTER TABLE `Expense`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbluser`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`);
  
  ALTER TABLE `UserRole`
  ADD PRIMARY KEY (`ID`);
  
  ALTER TABLE `ExpenseItem`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `IncomeSource`
  ADD PRIMARY KEY (`ID`);
  
  ALTER TABLE `Income`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblexpense`
--
ALTER TABLE `Expense`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

ALTER TABLE `ExpenseItem`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

ALTER TABLE `UserRole`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
  
ALTER TABLE `IncomeSource`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

ALTER TABLE `Income`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `tbluser`
--
ALTER TABLE `Users`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
