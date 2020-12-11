-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11-Dez-2020 às 12:42
-- Versão do servidor: 10.4.13-MariaDB
-- versão do PHP: 7.4.8
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;
/*!40101 SET NAMES utf8mb4 */
;
--
-- Banco de dados: `bdjackcadastra`
--
-- --------------------------------------------------------
--
-- Estrutura da tabela `tbcliente`
--
CREATE TABLE `tbcliente` (
	`idCliente` int(11) NOT NULL,
	`nomeCliente` varchar(50) NOT NULL,
	`cpfCliente` char(14) NOT NULL,
	`rgCliente` varchar(20) NOT NULL,
	`dtNasCliente` date NOT NULL,
	`sexoCliente` varchar(20) NOT NULL,
	`endCliente` varchar(150) NOT NULL,
	`bairroCliente` varchar(50) NOT NULL,
	`municipioCliente` varchar(50) NOT NULL,
	`ufCliente` char(2) NOT NULL,
	`emailCliente` varchar(150) NOT NULL,
	`senhaCliente` varchar(20) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
--
-- Extraindo dados da tabela `tbcliente`
--
INSERT INTO `tbcliente` (
		`idCliente`,
		`nomeCliente`,
		`cpfCliente`,
		`rgCliente`,
		`dtNasCliente`,
		`sexoCliente`,
		`endCliente`,
		`bairroCliente`,
		`municipioCliente`,
		`ufCliente`,
		`emailCliente`,
		`senhaCliente`
	)
VALUES (
		1,
		'Jack',
		'123.456.789-00',
		'123.456.789-00',
		'2020-11-26',
		'Masculino',
		'WEB',
		'WWW',
		'Internet',
		'SP',
		'mybot.dv@gmail.com',
		'1234'
	),
	--
	-- Índices para tabelas despejadas
	--
	--
	-- Índices para tabela `tbcliente`
	--
ALTER TABLE `tbcliente`
ADD PRIMARY KEY (`idCliente`);
--
-- AUTO_INCREMENT de tabelas despejadas
--
--
-- AUTO_INCREMENT de tabela `tbcliente`
--
ALTER TABLE `tbcliente`
MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT,
	AUTO_INCREMENT = 26;
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;
