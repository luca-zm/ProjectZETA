-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Gen 22, 2020 alle 11:27
-- Versione del server: 10.1.13-MariaDB
-- Versione PHP: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
(123456789, 100);

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
  `country` text NOT NULL,
  `zone` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `address`
--

INSERT INTO `address` (`id`, `address`, `city`, `postalCode`, `telephone`, `state`, `country`, `zone`) VALUES
(1, 'Via del Quadraro 72', 'Roma', '00179', '+393334455666', 'Italy', 'Italy', 'Quadraro'),
(2, 'Via del Quadraro 72', 'Roma', '00179', '+393334455666', 'Italy', 'Italy', 'Quadraro');

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

-- --------------------------------------------------------

--
-- Struttura della tabella `collectionpoint`
--

CREATE TABLE `collectionpoint` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `longitude` bigint(20) NOT NULL,
  `latitude` bigint(20) NOT NULL,
  `address` int(11) NOT NULL,
  `openingTime` int(11) DEFAULT NULL,
  `closingTime` int(11) DEFAULT NULL,
  `isAvailable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `collectionpoint`
--

INSERT INTO `collectionpoint` (`id`, `name`, `longitude`, `latitude`, `address`, `openingTime`, `closingTime`, `isAvailable`) VALUES
(1, 'Quadraro', 42, 13, 1, 9, 21, 1);

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
  `description` text NOT NULL,
  `availability` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `discountPercentage`, `category`, `image`, `description`, `availability`) VALUES
(12345, 'Borraccia in legno', 200, 0, 'utility', '/Users/davide/Desktop/Progetto3/src/logic/view/images', 'Yoko Design 1550 Bottiglia Termica, Acciaio Inox, Legno, 26 x 7 x 7 cm', 1);

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
(1, '12/01/2020', 'a1b2c3d4e5f6', 12345, 'SENT', 1);

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
(1, 'luca@libero.it', 'Luca', 'Zammariella', 'lucaluca', '', NULL, NULL, NULL, NULL, NULL),
(2, 'mauro', 'mauro1', 'trulli', 'trulla', 'USER', NULL, NULL, NULL, NULL, NULL),
(3, 'checco@libero.it', 'checco', 'checchino', 'checco123', 'USER', NULL, NULL, NULL, NULL, NULL);

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
-- Dump dei dati per la tabella `wishlist`
--

INSERT INTO `wishlist` (`id`, `userId`, `productId`) VALUES
(1, 1, 12345);

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
  ADD PRIMARY KEY (`id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT per la tabella `bonustran`
--
ALTER TABLE `bonustran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `collectionpoint`
--
ALTER TABLE `collectionpoint`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12346;
--
-- AUTO_INCREMENT per la tabella `shipment`
--
ALTER TABLE `shipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT per la tabella `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
