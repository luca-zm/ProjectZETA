-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 06, 2020 alle 22:22
-- Versione del server: 10.4.8-MariaDB
-- Versione PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test1`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `activationcode`
--

CREATE TABLE `activationcode` (
  `activationCode` int(11) NOT NULL,
  `greenCoinAdded` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `activationcode`
--

INSERT INTO `activationcode` (`activationCode`, `greenCoinAdded`) VALUES
(1111, 100),
(2222, 200),
(3333, 300),
(4444, 400);

-- --------------------------------------------------------

--
-- Struttura della tabella `activationcodetran`
--

CREATE TABLE `activationcodetran` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `activationCode` int(11) NOT NULL,
  `greenCoinAdded` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `activationcodetran`
--

INSERT INTO `activationcodetran` (`id`, `date`, `activationCode`, `greenCoinAdded`, `userId`) VALUES
(29, '2020-01-29 00:08:05', 111, 200, 6),
(30, '2020-01-29 00:08:23', 444, 300, 6),
(31, '2020-01-29 00:08:58', 222, 400, 6),
(32, '2020-01-29 00:34:50', 111, 300, 6),
(33, '2020-01-29 00:34:59', 222, 300, 6),
(34, '2020-02-03 12:29:21', 1111, 300, 3),
(35, '2020-02-04 16:51:54', 123, 1200, 3),
(36, '2020-02-05 18:11:40', 1111, 100, 3),
(37, '2020-02-05 19:15:53', 2222, 200, 11),
(38, '2020-02-05 19:15:59', 3333, 300, 11),
(39, '2020-02-05 19:23:55', 1111, 300, 14),
(40, '2020-02-05 19:24:10', 2222, 200, 14),
(41, '2020-02-06 17:18:30', 1111, 100, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `address` text NOT NULL,
  `city` text NOT NULL,
  `postalCode` text NOT NULL,
  `telephone` text NOT NULL,
  `state` text NOT NULL,
  `zone` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `address`
--

INSERT INTO `address` (`id`, `address`, `city`, `postalCode`, `telephone`, `state`, `zone`) VALUES
(3, 'ttt', 'ttt', '111', '111', 'ttt', 'ttt'),
(4, 'hdbtrdshberdghrehtdsherwwgerw', 'gevwsrges', '4444', '5555', 'dfgvdsb', 'reghewbe'),
(5, 'via p. rose 5', 'roma', '00012', '3206220152', 'Italy', 'nomentana'),
(6, 'via del quadraro 72', 'roma', '00174', '333333333', 'italy', 'tuscolano'),
(7, 'via ciccip', 'roma', '222', '333333333', 'italy', 'ciao'),
(8, 'via carlo', 'roma', '00010', '33333333', 'italy', 'talenti'),
(10, 'via scarpa', 'roma', '002', '3334354', 'italy', 'tivoli'),
(11, 'via ciao', 'roma', '00012', '333333', 'italy', 'talenti'),
(12, 'via nero', 'roma', '00123', '33333333', 'italy', 'talenti'),
(14, 'via scarpa', 'roma', '00123', '333333', 'italy', 'talenti');

-- --------------------------------------------------------

--
-- Struttura della tabella `bonustran`
--

CREATE TABLE `bonustran` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `description` text NOT NULL,
  `greenCoinAdded` int(11) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `bonustran`
--

INSERT INTO `bonustran` (`id`, `date`, `description`, `greenCoinAdded`, `userId`) VALUES
(6941, '2020-01-29 00:34:59', 'Hai collezionato 500 GreenCoin', 100, 6),
(6942, '2020-02-04 16:51:54', 'Hai collezionato 500 GreenCoin', 100, 3),
(6943, '2020-02-04 16:51:54', 'Hai collezionato 500 GreenCoin', 100, 3),
(6944, '2020-02-05 19:15:59', 'Hai collezionato 500 GreenCoin', 100, 11),
(6945, '2020-02-05 19:24:10', 'Hai collezionato 500 GreenCoin', 100, 14);

-- --------------------------------------------------------

--
-- Struttura della tabella `collectionpoint`
--

CREATE TABLE `collectionpoint` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  `address` text NOT NULL,
  `openingTime` int(11) DEFAULT NULL,
  `closingTime` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `collectionpoint`
--

INSERT INTO `collectionpoint` (`id`, `name`, `longitude`, `latitude`, `address`, `openingTime`, `closingTime`) VALUES
(25, 'Anagnina', 12.5863578, 41.8426566, 'Anagnina roma', 6, 18),
(26, 'Lucio Sestio', 12.5571617, 41.8597204, 'Lucio Sestio roma', 7, 17);

-- --------------------------------------------------------

--
-- Struttura della tabella `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `title` text NOT NULL,
  `bodymessage` text NOT NULL,
  `type` text NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `message`
--

INSERT INTO `message` (`id`, `date`, `title`, `bodymessage`, `type`, `userId`) VALUES
(26, '2020-01-28 14:13:12', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: Anagnina', 'COLLPOINTBROAD', 0),
(27, '2020-01-28 14:25:42', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: anagnina', 'COLLPOINTBROAD', 0),
(28, '2020-01-28 14:59:11', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: anagnina', 'COLLPOINTBROAD', 0),
(29, '2020-01-28 15:01:52', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: colosseo', 'COLLPOINTBROAD', 0),
(45, '2020-02-01 22:22:08', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: Quadraro', 'COLLPOINTBROAD', 0),
(46, '2020-02-01 22:25:47', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: Quadraro', 'COLLPOINTBROAD', 0),
(47, '2020-02-01 22:26:45', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: Romanisti', 'COLLPOINTBROAD', 0),
(48, '2020-02-01 22:27:35', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: poggio fiorito', 'COLLPOINTBROAD', 0),
(49, '2020-02-01 22:27:58', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: Corso Trieste', 'COLLPOINTBROAD', 0),
(50, '2020-02-01 22:28:18', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: null', 'COLLPOINTBROAD', 0),
(51, '2020-02-02 18:01:45', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: park', 'COLLPOINTBROAD', 0),
(52, '2020-02-03 12:29:21', 'Riscossione GreenCoin da ActivationCode', 'Hai riscosso 300 GreenCoin da un ActivationCode! ', 'ACTIVATIONCODE', 3),
(53, '2020-02-03 12:29:31', 'Acquisto prodotto', 'Hai acquistato guanti al modico prezzo di 80', 'PRODUCT', 3),
(54, '2020-02-03 12:38:18', 'Acquisto prodotto', 'Hai acquistato guanti al modico prezzo di 80', 'PRODUCT', 3),
(55, '2020-02-03 15:53:05', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: eur', 'COLLPOINTBROAD', 0),
(56, '2020-02-03 16:00:28', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: eur', 'COLLPOINTBROAD', 0),
(57, '2020-02-03 16:01:53', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: test', 'COLLPOINTBROAD', 0),
(58, '2020-02-03 16:03:44', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: romanisti', 'COLLPOINTBROAD', 0),
(59, '2020-02-03 16:05:41', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: test', 'COLLPOINTBROAD', 0),
(60, '2020-02-03 16:07:22', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: eur', 'COLLPOINTBROAD', 0),
(61, '2020-02-03 16:09:28', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: eur', 'COLLPOINTBROAD', 0),
(62, '2020-02-03 21:48:34', 'Acquisto prodotto', 'Hai acquistato guanti al modico prezzo di 80', 'PRODUCT', 3),
(63, '2020-02-03 22:02:21', 'Acquisto prodotto', 'Hai acquistato tazza al modico prezzo di 10', 'PRODUCT', 3),
(64, '2020-02-03 22:49:06', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: eur', 'COLLPOINTBROAD', 0),
(65, '2020-02-03 22:51:32', 'Nuovo Punto di raccolta', 'C\'ï¿½ un nuovo punto di raccolta sulla mappa: rom', 'COLLPOINTBROAD', 0),
(66, '2020-02-03 23:36:26', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: rom', 'COLLPOINTBROAD', 0),
(67, '2020-02-03 23:36:51', 'Nuovo Punto di raccolta', 'C\'e\' un nuovo punto di raccolta sulla mappa: romi', 'COLLPOINTBROAD', 0),
(68, '2020-02-03 23:37:40', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: romi', 'COLLPOINTBROAD', 0),
(69, '2020-02-03 23:55:43', 'Nuovo Punto di raccolta', 'C\'e\' un nuovo punto di raccolta sulla mappa: rom', 'COLLPOINTBROAD', 0),
(70, '2020-02-04 00:01:08', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: rom', 'COLLPOINTBROAD', 0),
(71, '2020-02-04 00:01:27', 'Nuovo Punto di raccolta', 'C\'e\' un nuovo punto di raccolta sulla mappa: xxx', 'COLLPOINTBROAD', 0),
(72, '2020-02-04 00:02:01', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: xxx', 'COLLPOINTBROAD', 0),
(73, '2020-02-04 16:07:55', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: null', 'COLLPOINTBROAD', 0),
(74, '2020-02-04 16:14:48', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: null', 'COLLPOINTBROAD', 0),
(75, '2020-02-04 16:14:56', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: null', 'COLLPOINTBROAD', 0),
(76, '2020-02-04 16:17:23', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: null', 'COLLPOINTBROAD', 0),
(77, '2020-02-04 16:17:50', 'Nuovo Punto di raccolta', 'C\'e\' un nuovo punto di raccolta sulla mappa: Anagnina', 'COLLPOINTBROAD', 0),
(78, '2020-02-04 16:28:35', 'Eliminato Punto di raccolta', 'E\' stato eliminato un punto di raccolta sulla mappa: null', 'COLLPOINTBROAD', 0),
(79, '2020-02-04 16:29:06', 'Nuovo Punto di raccolta', 'C\'e\' un nuovo punto di raccolta sulla mappa: Lucio Sestio', 'COLLPOINTBROAD', 0),
(80, '2020-02-04 16:51:01', 'Acquisto prodotto', 'Hai acquistato tazza al modico prezzo di 10', 'PRODUCT', 3),
(81, '2020-02-04 16:51:54', 'Bonus', 'Hai ricevuto un bonus di 100', 'BONUS', 3),
(82, '2020-02-04 16:51:55', 'Bonus', 'Hai ricevuto un bonus di 100', 'BONUS', 3),
(83, '2020-02-04 16:51:55', 'Riscossione GreenCoin da ActivationCode', 'Hai riscosso 1200 GreenCoin da un ActivationCode! ', 'ACTIVATIONCODE', 3),
(84, '2020-02-04 17:04:31', 'Acquisto prodotto', 'Hai acquistato zaino al modico prezzo di 150', 'PRODUCT', 3),
(85, '2020-02-04 17:04:31', 'Acquisto prodotto', 'Hai acquistato guanti al modico prezzo di 80', 'PRODUCT', 3),
(86, '2020-02-04 17:05:26', 'Nuovo Punto di raccolta', 'C\'e\' un nuovo punto di raccolta sulla mappa: prenestina', 'COLLPOINTBROAD', 0),
(87, '2020-02-04 21:16:04', 'Acquisto prodotto', 'Hai acquistato Borraccia al modico prezzo di 200', 'PRODUCT', 3),
(88, '2020-02-05 12:25:17', 'Acquisto prodotto', 'Hai acquistato Borraccia al modico prezzo di 200', 'PRODUCT', 3),
(89, '2020-02-05 12:26:09', 'Acquisto prodotto', 'Hai acquistato Borraccia al modico prezzo di 200', 'PRODUCT', 3),
(90, '2020-02-05 19:15:53', 'Riscossione GreenCoin da ActivationCode', 'Hai riscosso 200 GreenCoin da un ActivationCode! ', 'ACTIVATIONCODE', 11),
(91, '2020-02-05 19:15:59', 'Bonus', 'Hai ricevuto un bonus di 100', 'BONUS', 11),
(92, '2020-02-05 19:15:59', 'Riscossione GreenCoin da ActivationCode', 'Hai riscosso 300 GreenCoin da un ActivationCode! ', 'ACTIVATIONCODE', 11),
(93, '2020-02-05 19:16:22', 'Acquisto prodotto', 'Hai acquistato borraccia al modico prezzo di 200', 'PRODUCT', 11),
(94, '2020-02-05 19:16:22', 'Acquisto prodotto', 'Hai acquistato peluche al modico prezzo di 90', 'PRODUCT', 11),
(95, '2020-02-05 19:16:22', 'Acquisto prodotto', 'Hai acquistato zaino al modico prezzo di 110', 'PRODUCT', 11),
(96, '2020-02-05 19:23:55', 'Riscossione GreenCoin da ActivationCode', 'Hai riscosso 300 GreenCoin da un ActivationCode! ', 'ACTIVATIONCODE', 14),
(97, '2020-02-05 19:24:10', 'Bonus', 'Hai ricevuto un bonus di 100', 'BONUS', 14),
(98, '2020-02-05 19:24:10', 'Riscossione GreenCoin da ActivationCode', 'Hai riscosso 200 GreenCoin da un ActivationCode! ', 'ACTIVATIONCODE', 14),
(99, '2020-02-05 19:24:17', 'Acquisto prodotto', 'Hai acquistato zaino al modico prezzo di 110', 'PRODUCT', 14),
(100, '2020-02-05 19:24:17', 'Acquisto prodotto', 'Hai acquistato borraccia al modico prezzo di 200', 'PRODUCT', 14),
(101, '2020-02-06 17:18:30', 'Riscossione GreenCoin da ActivationCode', 'Hai riscosso 100 GreenCoin da un ActivationCode! ', 'ACTIVATIONCODE', 3),
(102, '2020-02-06 21:44:27', 'Acquisto prodotto', 'Hai acquistato Guanti al modico prezzo di 80', 'PRODUCT', 5),
(103, '2020-02-06 21:45:45', 'Acquisto prodotto', 'Hai acquistato Guanti al modico prezzo di 80', 'PRODUCT', 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `price` int(11) NOT NULL,
  `discountPercentage` int(11) NOT NULL,
  `category` text NOT NULL,
  `image` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `discountPercentage`, `category`, `image`, `description`) VALUES
(267, 'peluche', 90, 0, 'UTILITY', '.\\img\\orso.jpg', 'peluche eco'),
(342, 'borraccia', 200, 0, 'UTILITY', '.\\img\\bor.png', 'borraccia eco'),
(567, 'shampoo', 30, 0, 'UTILITY', '.\\img\\2.jpg', 'shampoo eco'),
(879, 'Guanti', 80, 0, 'UTILITY', '.\\img\\5.jpg', 'guanti eco'),
(2956, 'tazza', 30, 0, 'UTILITY', '.\\img\\6.jpg', 'tazza eco'),
(3535, 'zaino', 110, 0, 'UTILITY', '.\\img\\3.png', 'zaino eco');

-- --------------------------------------------------------

--
-- Struttura della tabella `shipment`
--

CREATE TABLE `shipment` (
  `id` int(11) NOT NULL,
  `date` text NOT NULL,
  `trackingNumber` text NOT NULL,
  `product` int(11) NOT NULL,
  `deliveryStatus` text NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `shipment`
--

INSERT INTO `shipment` (`id`, `date`, `trackingNumber`, `product`, `deliveryStatus`, `userId`) VALUES
(1, '12/01/2020', 'a1b2c3d4e5f6', 12345, 'SENT', 1),
(2, '2020-01-24 14:00:00', 'randomString', 1, 'SENT', 2),
(3, '2020-01-24 14:02:57', 'randomString', 1, 'SENT', 2),
(4, '2020-01-24 14:04:51', 'randomString', 1, 'SENT', 2),
(5, '2020-01-24 14:06:46', 'randomString', 1, 'SENT', 2),
(6, '2020-01-24 14:10:23', 'randomString', 1, 'SENT', 2),
(7, '2020-01-24 14:12:53', 'randomString', 1, 'SENT', 2),
(8, '2020-01-24 14:14:04', 'randomString', 1, 'SENT', 2),
(9, '2020-01-24 14:15:07', 'randomString', 1, 'SENT', 2),
(10, '2020-01-24 14:16:26', 'randomString', 1, 'SENT', 2),
(11, '2020-01-24 14:25:35', 'randomString', 1, 'SENT', 2),
(12, '2020-01-24 14:25:59', 'randomString', 1, 'SENT', 2),
(13, '2020-01-24 14:29:28', 'randomString', 1, 'SENT', 2),
(14, '2020-01-24 14:32:07', 'randomString', 1, 'SENT', 2),
(15, '2020-01-24 14:34:08', 'randomString', 1, 'SENT', 2),
(16, '2020-02-03 12:29:31', 'kX0ckbby5j', 267, 'SENT', 3),
(17, '2020-02-03 12:38:18', 'gmIMzLgkGS', 267, 'SENT', 3),
(18, '2020-02-03 21:48:34', '7sGSSwvXQH', 267, 'SENT', 3),
(19, '2020-02-03 22:02:21', '9zwMMZ56j7', 564756, 'SENT', 3),
(20, '2020-02-03 22:34:26', 'GwwTEpGsXD', 564757, 'SENT', 3),
(21, '2020-02-04 15:43:25', '3NwHqYkBxf', 564757, 'SENT', 3),
(22, '2020-02-04 16:51:01', 'pf647IsFpM', 564756, 'SENT', 3),
(23, '2020-02-04 17:04:31', 'KtPbVCmMLA', 342, 'SENT', 3),
(24, '2020-02-04 17:04:31', 'KtPbVCmMLA', 267, 'SENT', 3),
(25, '2020-02-04 21:16:04', 'Mr1eiuTs2N', 12345, 'SENT', 3),
(26, '2020-02-05 12:25:17', 'GzJcQaWDa8', 12345, 'SENT', 3),
(27, '2020-02-05 12:26:09', 'n5T5XmXp9J', 12345, 'SENT', 3),
(28, '2020-02-05 19:16:22', 'VoF6CrdvUM', 342, 'SENT', 11),
(29, '2020-02-05 19:16:22', 'VoF6CrdvUM', 7692, 'SENT', 11),
(30, '2020-02-05 19:16:22', 'VoF6CrdvUM', 1957, 'SENT', 11),
(31, '2020-02-05 19:24:17', 'CWBsXxQ0W4', 1957, 'SENT', 14),
(32, '2020-02-05 19:24:17', 'CWBsXxQ0W4', 342, 'SENT', 14),
(33, '2020-02-05 19:29:08', 'qSv5DqA0q3', 342, 'SENT', 14),
(34, '2020-02-06 21:44:27', 'XUwkobU7WA', 879, 'SENT', 5),
(35, '2020-02-06 21:45:45', 'Fy8M2crJuW', 879, 'SENT', 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `tabella`
--

CREATE TABLE `tabella` (
  `id` int(7) NOT NULL,
  `nome` text NOT NULL,
  `cognome` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `tabella`
--

INSERT INTO `tabella` (`id`, `nome`, `cognome`, `password`) VALUES
(123, 'Luca', 'Zammariella', '24'),
(222, 'Gino', 'Zaia', '42'),
(256, 'Rocco', 'Grande', '25'),
(258, 'Rocco', 'Grande', '25');

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `mail` text NOT NULL,
  `name` text NOT NULL,
  `surname` text NOT NULL,
  `pass` text NOT NULL,
  `type` text NOT NULL,
  `cart` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL,
  `boards` int(11) DEFAULT NULL,
  `greenCoin` int(11) DEFAULT NULL,
  `address` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`id`, `mail`, `name`, `surname`, `pass`, `type`, `cart`, `history`, `boards`, `greenCoin`, `address`) VALUES
(1, 'admin', 'admin', 'admin', 'admin', 'ADMIN', NULL, NULL, NULL, NULL, NULL),
(2, 'moderator', 'moderator', 'moderator', 'moderator', 'COLLECTIONPOINTMAN', NULL, NULL, NULL, NULL, NULL),
(3, 'ttt', 'ttt', 'ttt', 'ttt', 'USER', NULL, NULL, NULL, 770, 3),
(5, 'luca.zammariello@gmail.com', 'Luca', 'Zammariello', 'aaaa', 'USER', NULL, NULL, NULL, 40, 5),
(6, 'verardo', 'vdavide95@libero.it', 'davide', 'bbbb', 'USER', NULL, NULL, NULL, 0, 6),
(7, 'stefano@gmail.com', 'stefano', 'costanzo', 'cccc', 'USER', NULL, NULL, NULL, 0, 7),
(10, 'stef@gmail.com', 'stefano', 'ciccio', 'aaaa', 'USER', NULL, NULL, NULL, 0, 10),
(14, 'scotti@gmail.com', 'virgilio', 'scotti', 'aaaa', 'USER', NULL, NULL, NULL, 60, 14);

-- --------------------------------------------------------

--
-- Struttura della tabella `wishlist`
--

CREATE TABLE `wishlist` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `productId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `activationcode`
--
ALTER TABLE `activationcode`
  ADD PRIMARY KEY (`activationCode`);

--
-- Indici per le tabelle `activationcodetran`
--
ALTER TABLE `activationcodetran`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_3` (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- Indici per le tabelle `bonustran`
--
ALTER TABLE `bonustran`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `collectionpoint`
--
ALTER TABLE `collectionpoint`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `shipment`
--
ALTER TABLE `shipment`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `tabella`
--
ALTER TABLE `tabella`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `activationcodetran`
--
ALTER TABLE `activationcodetran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT per la tabella `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT per la tabella `bonustran`
--
ALTER TABLE `bonustran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6946;

--
-- AUTO_INCREMENT per la tabella `collectionpoint`
--
ALTER TABLE `collectionpoint`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT per la tabella `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT per la tabella `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=564760;

--
-- AUTO_INCREMENT per la tabella `shipment`
--
ALTER TABLE `shipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT per la tabella `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
