-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 11, 2020 alle 18:08
-- Versione del server: 10.3.16-MariaDB
-- Versione PHP: 7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `activationcode`
--

CREATE TABLE `activationcode` (
  `activationCode` int(11) NOT NULL,
  `greenCoinAdded` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Struttura della tabella `shipment`
--

CREATE TABLE `shipment` (
  `id` int(11) NOT NULL,
  `date` text NOT NULL,
  `trackingNumber` text NOT NULL,
  `product` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `deliveryStatus` text NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, 'stefano@gmail.com', 'stefano', 'costanzo', 'stefano123', 'USER', NULL, NULL, NULL, NULL, NULL);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `bonustran`
--
ALTER TABLE `bonustran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `collectionpoint`
--
ALTER TABLE `collectionpoint`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `shipment`
--
ALTER TABLE `shipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
