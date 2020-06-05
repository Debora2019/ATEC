-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2020 at 09:35 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `academia`
--

-- --------------------------------------------------------

--
-- Table structure for table `funcionarios`
--

CREATE TABLE `funcionarios` (
  `func_id` int(11) NOT NULL,
  `func_fone` varchar(25) DEFAULT NULL,
  `func_sobrenome` varchar(30) NOT NULL,
  `func_morada` varchar(50) NOT NULL,
  `func_email` varchar(20) NOT NULL,
  `func_nome` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `funcionarios`
--

INSERT INTO `funcionarios` (`func_id`, `func_fone`, `func_sobrenome`, `func_morada`, `func_email`, `func_nome`) VALUES
(1, '9184756321', 'Michio Mutiz', 'rua Af CAstro', 'juan', 'Jv'),
(2, '', 'Mutiz Filho', 'fALCAO MACAHADO', '', 'Juan');

-- --------------------------------------------------------

--
-- Table structure for table `modalidades`
--

CREATE TABLE `modalidades` (
  `mod_descricao` varchar(50) DEFAULT NULL,
  `mod_func_id` int(11) DEFAULT NULL,
  `mod_horario` varchar(15) DEFAULT NULL,
  `mod_preco` varchar(20) DEFAULT NULL,
  `mod_instrutor` varchar(30) DEFAULT NULL,
  `mod_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `modalidades`
--

INSERT INTO `modalidades` (`mod_descricao`, `mod_func_id`, `mod_horario`, `mod_preco`, `mod_instrutor`, `mod_id`) VALUES
('ginastica', NULL, '19/04/2020', '14.50', 'JVMM', 1),
('karate', NULL, '17/08/2020', '15', 'juan', 4),
('Hidroginastica', NULL, '19/04/2020', '14.50', 'Debora', 5),
('judo', NULL, '25/04/2020', '15', 'tony do judo', 6),
('judo', NULL, '25/04/2020', '15', 'tony do judo', 7),
('danca', NULL, '25/04/2020', '15', 'tony do judo', 8),
('bale', NULL, 'tony', '18', '14/01/2020', 9),
('musculação', NULL, 'tony Filho', '50', '10/10/2020', 10),
('alongamento', NULL, '15/01/2020', '65', 'Debora', 11),
('hfvufvuyfyu', NULL, '25/04/2020', '45', 'gvcjgkhfhgdfhf', 12);

-- --------------------------------------------------------

--
-- Table structure for table `sobre`
--

CREATE TABLE `sobre` (
  `sobre_texto` varchar(200) NOT NULL,
  `id_sobre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sobre`
--

INSERT INTO `sobre` (`sobre_texto`, `id_sobre`) VALUES
('ola', 1),
('O Sistema de Gestão para Academias foi criado para gerenciar academias. Este oferece uma maneira fácil e integrada de controlar gestão, campanhas de marketing, emissão de treino, avaliação física e ac', 2);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `usu_id` int(11) NOT NULL,
  `usu_nome` varchar(25) DEFAULT NULL,
  `usu_sobrenome` varchar(50) DEFAULT NULL,
  `usu_morada` varchar(80) DEFAULT NULL,
  `usu_fone` varchar(15) DEFAULT NULL,
  `usu_profissao` varchar(25) DEFAULT NULL,
  `usu_fun_id` int(11) DEFAULT NULL,
  `usu_email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`usu_id`, `usu_nome`, `usu_sobrenome`, `usu_morada`, `usu_fone`, `usu_profissao`, `usu_fun_id`, `usu_email`) VALUES
(28, 'tony', 'filho', 'rua FCLCAO', '918203784', 'estudante', NULL, 'tony@'),
(29, 'debora', 'michio', 'rua afonso castro', '123456789', 'estudante', NULL, 'dmutiz@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`func_id`);

--
-- Indexes for table `modalidades`
--
ALTER TABLE `modalidades`
  ADD PRIMARY KEY (`mod_id`);

--
-- Indexes for table `sobre`
--
ALTER TABLE `sobre`
  ADD PRIMARY KEY (`id_sobre`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usu_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `func_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `modalidades`
--
ALTER TABLE `modalidades`
  MODIFY `mod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `sobre`
--
ALTER TABLE `sobre`
  MODIFY `id_sobre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
