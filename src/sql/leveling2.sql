-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 01 fév. 2023 à 22:06
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `leveling2`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `deleteGroupePrivate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteGroupePrivate` (IN `p_idGroupe` INT(3))  Begin
    delete from  tblgroupsprivate where idGroupe = p_idGroupe;
    delete from tblgroups where idGroupe = p_idGroupe;
End$$

DROP PROCEDURE IF EXISTS `deleteGroupePublic`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteGroupePublic` (IN `p_idGroupe` INT(3))  Begin
    delete from  tblgroupspublic where idGroupe = p_idGroupe;
    delete from tblgroups where idGroupe = p_idGroupe;
End$$

DROP PROCEDURE IF EXISTS `deleteJeuConsole`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteJeuConsole` (IN `p_idGame` INT(3))  Begin
    delete from  tblgamescs where idGame = p_idGame;
    delete from tblgames where idGame = p_idGame;
End$$

DROP PROCEDURE IF EXISTS `deleteJeuPc`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteJeuPc` (IN `p_idGame` INT(3))  Begin
    delete from  tblgamespc where idGame = p_idGame;
    delete from tblgames where idGame = p_idGame;
End$$

DROP PROCEDURE IF EXISTS `deleteUserAdmin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUserAdmin` (IN `p_idUser` INT(3))  Begin
    delete from  tblusersadmin where idUser = p_idUser;
    delete from tblusers where idUser = p_idUser;
End$$

DROP PROCEDURE IF EXISTS `deleteUserSimple`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUserSimple` (IN `p_idUser` INT(3))  Begin
    delete from  tbluserssimple where idUser = p_idUser;
    delete from tblusers where idUser = p_idUser;
End$$

DROP PROCEDURE IF EXISTS `insertGroupePrivate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertGroupePrivate` (IN `p_groupeMasquer` TINYINT(1), IN `p_groupePrivateNbUsers` INT(11), IN `p_groupePrivateidUser` INT(11), IN `p_groupeName` VARCHAR(50), IN `p_groupeDescription` VARCHAR(50), IN `p_groupeFkIdUser` INT(3), IN `p_groupePrivacy` VARCHAR(50), IN `p_groupeImg` LONGBLOB, IN `p_groupeTypeImg` VARCHAR(50), IN `p_groupeBanner` LONGBLOB, IN `p_groupeTypeBanner` VARCHAR(50))  Begin
        Declare p_idGroupe int(11);
        insert into tblgroups values(null,p_groupeName, p_groupeDescription, p_groupeFkIdUser, p_groupePrivacy,p_groupeImg, p_groupeTypeImg,p_groupeBanner, p_groupeTypeBanner);

        select idGroupe  into p_idGroupe from tblgroups
        where groupeName = p_groupeName and groupeDescription = p_groupeDescription and groupeFkIdUser = p_groupeFkIdUser and groupePrivacy = p_groupePrivacy;

        insert into tblgroupsprivate values (p_idGroupe, p_groupeMasquer, p_groupePrivateNbUsers,p_groupePrivateidUser, p_groupeName, p_groupeDescription,p_groupeFkIdUser, p_groupePrivacy,p_groupeImg, p_groupeTypeImg,p_groupeBanner, p_groupeTypeBanner);
    End$$

DROP PROCEDURE IF EXISTS `insertGroupePublic`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertGroupePublic` (IN `p_groupeMasquer` TINYINT(1), IN `p_groupePublicNbUsers` INT(11), IN `p_groupePublicidUser` INT(11), IN `p_groupeName` VARCHAR(50), IN `p_groupeDescription` VARCHAR(50), IN `p_groupeFkIdUser` INT(3), IN `p_groupePrivacy` VARCHAR(50), IN `p_groupeImg` LONGBLOB, IN `p_groupeTypeImg` VARCHAR(50), IN `p_groupeBanner` LONGBLOB, IN `p_groupeTypeBanner` VARCHAR(50))  Begin
        Declare p_idGroupe int(11);
        insert into tblgroups values(null,p_groupeName, p_groupeDescription, p_groupeFkIdUser, p_groupePrivacy,p_groupeImg, p_groupeTypeImg,p_groupeBanner, p_groupeTypeBanner);

        select idGroupe  into p_idGroupe from tblgroups
        where groupeName = p_groupeName and groupeDescription = p_groupeDescription and groupeFkIdUser = p_groupeFkIdUser and groupePrivacy = p_groupePrivacy;

        insert into tblgroupspublic values (p_idGroupe, p_groupeMasquer, p_groupePublicNbUsers,p_groupePublicidUser, p_groupeName, p_groupeDescription,p_groupeFkIdUser, p_groupePrivacy,p_groupeImg, p_groupeTypeImg,p_groupeBanner, p_groupeTypeBanner);
    End$$

DROP PROCEDURE IF EXISTS `insertJeuConsole`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertJeuConsole` (IN `p_gameCsSupport` VARCHAR(50), IN `p_gameCsDateSortie` VARCHAR(50), IN `p_gameCsPrix` FLOAT, IN `p_gameCsTaille` FLOAT, IN `p_gameCsModeleEco` VARCHAR(50), IN `p_gameName` VARCHAR(50), `p_gameDescription` VARCHAR(100), IN `p_gameGenre` VARCHAR(100), `p_gameAvis` VARCHAR(100), IN `p_gameClassification` VARCHAR(100), IN `p_gameMode` VARCHAR(100), IN `p_gameImg` VARCHAR(100), IN `p_gameTrailer` VARCHAR(100), IN `p_gameImgOther` VARCHAR(100))  Begin
        Declare p_idGame int(11);
        insert into tblgames values(null,p_gameName, p_gameDescription, p_gameGenre, p_gameAvis, p_gameClassification, p_gameMode, p_gameImg, p_gameTrailer,p_gameImgOther);

        select idGame into p_idGame from tblgames
        where gameName = p_gameName and gameDescription = p_gameDescription and gameGenre = p_gameGenre and gameAvis = p_gameAvis and
        gameClassification = p_gameClassification and gameMode = p_gameMode;

        insert into tblgamescs values (p_idGame, p_gameCsSupport, p_gameCsDateSortie,p_gameCsPrix, p_gameCsTaille, p_gameCsModeleEco, p_gameName, p_gameDescription, p_gameGenre,
        p_gameAvis, p_gameClassification, p_gameMode, p_gameImg, p_gameTrailer,p_gameImgOther);
    End$$

DROP PROCEDURE IF EXISTS `insertJeuPc`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertJeuPc` (IN `p_gamePcModeleEco` VARCHAR(50), IN `p_gamePcPrix` FLOAT, IN `p_gamePcOs` VARCHAR(50), IN `p_gamePcProc` VARCHAR(50), IN `p_gamePcCg` VARCHAR(50), IN `p_gamePcTaille` FLOAT, IN `p_gameName` VARCHAR(50), `p_gameDescription` VARCHAR(100), IN `p_gameGenre` VARCHAR(100), `p_gameAvis` VARCHAR(100), IN `p_gameClassification` VARCHAR(100), IN `p_gameMode` VARCHAR(100), IN `p_gameImg` VARCHAR(100), IN `p_gameTrailer` VARCHAR(100), IN `p_gameImgOther` VARCHAR(100))  Begin
        Declare p_idGame int(11);
        insert into tblgames values(null,p_gameName, p_gameDescription, p_gameGenre, p_gameAvis, p_gameClassification, p_gameMode, p_gameImg, p_gameTrailer,p_gameImgOther);

        select idGame into p_idGame from tblgames
        where gameName = p_gameName and gameDescription = p_gameDescription and gameGenre = p_gameGenre and gameAvis = p_gameAvis and
        gameClassification = p_gameClassification and gameMode = p_gameMode;

        insert into tblgamespc values (p_idGame, p_gamePcModeleEco, p_gamePcPrix,p_gamePcOs, p_gamePcProc, p_gamePcCg,p_gamePcTaille, p_gameName, p_gameDescription, p_gameGenre,
        p_gameAvis, p_gameClassification, p_gameMode, p_gameImg, p_gameTrailer,p_gameImgOther);
    End$$

DROP PROCEDURE IF EXISTS `insertUserAdmin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUserAdmin` (IN `p_userAdminGrade` VARCHAR(50), IN `p_userAdminFonction` VARCHAR(50), IN `p_userSimpleCanModify` TINYINT(1), IN `p_userNom` VARCHAR(50), IN `p_userPrenom` VARCHAR(50), IN `p_userAge` VARCHAR(50), IN `p_userBio` VARCHAR(50), IN `p_userNaissance` VARCHAR(50), IN `p_userLevel` INT(11), IN `p_userPseudo` VARCHAR(50), IN `p_userMail` VARCHAR(50), IN `p_userPassword` VARCHAR(50), IN `p_userRole` VARCHAR(50), IN `p_userDateInscription` VARCHAR(50), IN `p_userImg` LONGBLOB, IN `p_userTypeImg` VARCHAR(50), IN `p_userBanner` LONGBLOB, IN `p_userTypeBanner` VARCHAR(50))  Begin
        Declare p_idUser int(11);
        insert into tblusers values(null,p_userNom, p_userPrenom, p_userAge, p_userBio,p_userNaissance,p_userLevel,p_userPseudo,p_userMail,p_userPassword,p_userRole,p_userDateInscription, p_userImg, p_userTypeImg, p_userBanner, p_userTypeBanner);

         select idUser into p_idUser from tblusers
        where userNom = p_userNom and userPrenom = p_userPrenom and userAge = p_userAge and userBio = p_userBio and userNaissance = p_userNaissance and userLevel =p_userLevel and userPseudo =p_userPseudo
        and userMail = p_userMail and userPassword = p_userPassword and userRole = p_userRole and userDateInscription =p_userDateInscription;

        insert into tblusersadmin values (p_idUser, p_userAdminGrade, p_userAdminFonction,p_userSimpleCanModify, p_userNom,p_userPrenom, p_userAge, p_userBio , p_userNaissance, p_userLevel, p_userPseudo, p_userMail, p_userPassword, p_userRole, p_userDateInscription,
        p_userImg, p_userTypeImg, p_userBanner, p_userTypeBanner);
    End$$

DROP PROCEDURE IF EXISTS `insertUserSimple`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUserSimple` (IN `p_userSimplePlateforme` VARCHAR(50), `p_userSimpleCanModify` TINYINT(1), IN `p_userNom` VARCHAR(50), IN `p_userPrenom` VARCHAR(50), IN `p_userAge` VARCHAR(50), IN `p_userBio` VARCHAR(50), IN `p_userNaissance` VARCHAR(50), IN `p_userLevel` INT(11), IN `p_userPseudo` VARCHAR(50), IN `p_userMail` VARCHAR(50), IN `p_userPassword` VARCHAR(50), IN `p_userRole` VARCHAR(50), IN `p_userDateInscription` VARCHAR(50), IN `p_userImg` LONGBLOB, IN `p_userTypeImg` VARCHAR(50), IN `p_userBanner` LONGBLOB, IN `p_userTypeBanner` VARCHAR(50))  Begin
        Declare p_idUser int(11);
        insert into tblusers values(null,p_userNom, p_userPrenom, p_userAge, p_userBio,p_userNaissance,p_userLevel,p_userPseudo,p_userMail,p_userPassword,p_userRole,p_userDateInscription, p_userImg, p_userTypeImg, p_userBanner, p_userTypeBanner);

        select idUser into p_idUser from tblusers
        where userNom = p_userNom and userPrenom = p_userPrenom and userAge = p_userAge and userBio = p_userBio and userNaissance = p_userNaissance and userLevel =p_userLevel and userPseudo =p_userPseudo
        and userMail = p_userMail and userPassword = p_userPassword and userRole = p_userRole and userDateInscription =p_userDateInscription;

        insert into tbluserssimple values (p_idUser, p_userSimplePlateforme, p_userSimpleCanModify, p_userNom,p_userPrenom, p_userAge, p_userBio , p_userNaissance, p_userLevel, p_userPseudo, p_userMail, p_userPassword, p_userRole, p_userDateInscription,
        p_userImg, p_userTypeImg,p_userBanner, p_userTypeBanner);
    End$$

DROP PROCEDURE IF EXISTS `updateGameConsole`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateGameConsole` (IN `p_idGame` INT(11), IN `p_gameCsSupport` VARCHAR(50), IN `p_gameCsDateSortie` VARCHAR(50), IN `p_gameCsPrix` FLOAT, IN `p_gameCsTaille` FLOAT, IN `p_gameCsModeleEco` VARCHAR(50), IN `p_gameName` VARCHAR(50), IN `p_gameDescription` VARCHAR(100), IN `p_gameGenre` VARCHAR(100), IN `p_gameAvis` VARCHAR(100), IN `p_gameClassification` VARCHAR(100), IN `p_gameMode` VARCHAR(100), IN `p_gameImg` VARCHAR(100), IN `p_gameTrailer` VARCHAR(100), IN `p_gameImgOther` VARCHAR(100))  Begin
    update tblgamescs set gameCsSupport = p_gameCsSupport, gameCsDateSortie = p_gameCsDateSortie, gameCsPrix=p_gameCsPrix, gameCsTaille = p_gameCsTaille, gameCsModeleEco = p_gameCsModeleEco ,gameName = p_gameName, gameDescription = p_gameDescription,
    gameGenre = p_gameGenre ,gameAvis = p_gameAvis, gameClassification =p_gameClassification, gameMode =p_gameMode, gameImg =p_gameImg, gameTrailer = p_gameTrailer, gameImgOther = p_gameImgOther where idGame = p_idGame ; 

    update tblgames set gameName = p_gameName, gameDescription = p_gameDescription,gameGenre = p_gameGenre ,gameAvis = p_gameAvis, gameClassification =p_gameClassification, gameMode =p_gameMode, gameImg =p_gameImg, gameTrailer = p_gameTrailer, gameImgOther = p_gameImgOther 
    where idGame = p_idGame ;
End$$

DROP PROCEDURE IF EXISTS `updateGamePc`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateGamePc` (IN `p_idGame` INT(11), IN `p_gamePcModeleEco` VARCHAR(50), IN `p_gamePcPrix` FLOAT, IN `p_gamePcOs` VARCHAR(50), IN `p_gamePcProc` VARCHAR(50), IN `p_gamePcCg` VARCHAR(50), IN `p_gamePcTaille` FLOAT, IN `p_gameName` VARCHAR(50), IN `p_gameDescription` VARCHAR(100), IN `p_gameGenre` VARCHAR(100), IN `p_gameAvis` VARCHAR(100), IN `p_gameClassification` VARCHAR(100), IN `p_gameMode` VARCHAR(100), IN `p_gameImg` VARCHAR(100), IN `p_gameTrailer` VARCHAR(100), IN `p_gameImgOther` VARCHAR(100))  Begin
    update tblgamespc set gamePcModeleEco = p_gamePcModeleEco, gamePcPrix = p_gamePcPrix, gamePcOs=p_gamePcOs, gamePcProc = p_gamePcProc, gamePcCg = p_gamePcCg , gamePcTaille = p_gamePcTaille, gameName = p_gameName, gameDescription = p_gameDescription,
    gameGenre = p_gameGenre ,gameAvis = p_gameAvis, gameClassification =p_gameClassification, gameMode =p_gameMode, gameImg =p_gameImg, gameTrailer = p_gameTrailer, gameImgOther = p_gameImgOther where idGame = p_idGame ; 

    update tblgames set gameName = p_gameName, gameDescription = p_gameDescription,gameGenre = p_gameGenre ,gameAvis = p_gameAvis, gameClassification =p_gameClassification, gameMode =p_gameMode, gameImg =p_gameImg, gameTrailer = p_gameTrailer, gameImgOther = p_gameImgOther 
    where idGame = p_idGame ;
End$$

DROP PROCEDURE IF EXISTS `updateGroupePrivate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateGroupePrivate` (IN `p_idGroupe` INT(3), IN `p_groupeMasquer` TINYINT(1), IN `p_groupePrivateNbUsers` INT(11), IN `p_groupePrivateidUser` INT(11), IN `p_groupeName` VARCHAR(50), IN `p_groupeDescription` VARCHAR(50), IN `p_groupeFkIdUser` INT(11), IN `p_groupePrivacy` VARCHAR(50), IN `p_groupeImg` LONGBLOB, IN `p_groupeTypeImg` VARCHAR(50), IN `p_groupeBanner` LONGBLOB, IN `p_groupeTypeBanner` VARCHAR(50))  Begin
    update tblgroupsprivate set groupeMasquer = p_groupeMasquer, groupePrivateNbUsers = p_groupePrivateNbUsers, groupePrivateNbUsers = p_groupePrivateNbUsers, groupePrivateidUser = p_groupePrivateidUser, groupeName = p_groupeName, groupeDescription = p_groupeDescription,
     groupeFkIdUser = p_groupeFkIdUser , groupePrivacy = p_groupePrivacy, groupeImg = p_groupeImg, groupeTypeImg = p_groupeTypeImg, groupeBanner = p_groupeBanner, groupeTypeBanner = p_groupeTypeBanner
     where idGroupe = p_idGroupe ; 

    update tblgroups set  groupeName = p_groupeName, groupeDescription = p_groupeDescription, groupeFkIdUser = p_groupeFkIdUser , groupePrivacy = p_groupePrivacy, groupeImg = p_groupeImg, groupeTypeImg = p_groupeTypeImg, groupeBanner = p_groupeBanner,
     groupeTypeBanner = p_groupeTypeBanner where idGroupe = p_idGroupe ; 
End$$

DROP PROCEDURE IF EXISTS `updateGroupePublic`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateGroupePublic` (IN `p_idGroupe` INT(3), IN `p_groupeMasquer` TINYINT(1), IN `p_groupePublicNbUsers` INT(11), IN `p_groupePublicidUser` INT(11), IN `p_groupeName` VARCHAR(50), IN `p_groupeDescription` VARCHAR(50), IN `p_groupeFkIdUser` INT(11), IN `p_groupePrivacy` VARCHAR(50), IN `p_groupeImg` LONGBLOB, IN `p_groupeTypeImg` VARCHAR(50), IN `p_groupeBanner` LONGBLOB, IN `p_groupeTypeBanner` VARCHAR(50))  Begin
    update tblgroupspublic set groupeMasquer = p_groupeMasquer, groupePublicNbUsers = p_groupePublicNbUsers, groupePublicNbUsers = p_groupePublicNbUsers, groupePublicidUser = p_groupePublicidUser, groupeName = p_groupeName, groupeDescription = p_groupeDescription,
     groupeFkIdUser = p_groupeFkIdUser , groupePrivacy = p_groupePrivacy, groupeImg = p_groupeImg, groupeTypeImg = p_groupeTypeImg, groupeBanner = p_groupeBanner, groupeTypeBanner = p_groupeTypeBanner
     where idGroupe = p_idGroupe ; 

    update tblgroups set  groupeName = p_groupeName, groupeDescription = p_groupeDescription, groupeFkIdUser = p_groupeFkIdUser , groupePrivacy = p_groupePrivacy, groupeImg = p_groupeImg, groupeTypeImg = p_groupeTypeImg, groupeBanner = p_groupeBanner,
     groupeTypeBanner = p_groupeTypeBanner where idGroupe = p_idGroupe ; 
End$$

DROP PROCEDURE IF EXISTS `updateUserAdmin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserAdmin` (IN `p_idUser` INT(11), IN `p_userAdminGrade` VARCHAR(50), IN `p_userAdminFonction` VARCHAR(50), IN `p_userCanModify` TINYINT(1), IN `p_userNom` VARCHAR(50), IN `p_userPrenom` VARCHAR(50), IN `p_userAge` VARCHAR(50), IN `p_userBio` VARCHAR(50), IN `p_userNaissance` VARCHAR(50), IN `p_userLevel` INT(11), IN `p_userPseudo` VARCHAR(50), IN `p_userMail` VARCHAR(50), IN `p_userPassword` VARCHAR(50), IN `p_userRole` VARCHAR(50), IN `p_userDateInscription` VARCHAR(50), IN `p_userAdminImg` LONGBLOB, IN `p_userAdminTypeImg` VARCHAR(50), IN `p_userAdminBanner` LONGBLOB, IN `p_userAdminTypeBanner` VARCHAR(50))  Begin
    update tblusersadmin set userAdminGrade = p_userAdminGrade, userAdminFonction = p_userAdminFonction, userCanModify = p_userCanModify, userNom =p_userNom, userPrenom = p_userPrenom, userAge = p_userAge , userBio = p_userBio, userNaissance = p_userNaissance,
    userLevel = p_userLevel, userPseudo = p_userPseudo ,userMail = p_userMail, userPassword =p_userPassword, userRole =p_userRole, userDateInscription =p_userDateInscription, userAdminImg = p_userAdminImg, userAdminTypeImg = p_userAdminTypeImg,
    userAdminBanner = p_userAdminBanner, userAdminTypeBanner = p_userAdminTypeBanner where idUser = p_idUser ; 

    update tblusers set  userNom =p_userNom, userPrenom = p_userPrenom, userAge = p_userAge , userBio = p_userBio, userNaissance = p_userNaissance,userLevel = p_userLevel, userPseudo = p_userPseudo ,userMail = p_userMail, userPassword =p_userPassword,
     userRole =p_userRole, userDateInscription =p_userDateInscription, userImg = p_userAdminImg, userTypeImg = p_userAdminTypeImg, userBanner = p_userAdminBanner, userTypeBanner = p_userAdminTypeBanner where idUser = p_idUser ; 
End$$

DROP PROCEDURE IF EXISTS `updateUserSimple`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserSimple` (IN `p_idUser` INT(11), IN `p_userSimplePlateforme` VARCHAR(50), IN `p_userSimpleCanModify` TINYINT(1), IN `p_userNom` VARCHAR(50), IN `p_userPrenom` VARCHAR(50), IN `p_userAge` VARCHAR(50), IN `p_userBio` VARCHAR(50), IN `p_userNaissance` VARCHAR(50), IN `p_userLevel` INT(11), IN `p_userPseudo` VARCHAR(50), IN `p_userMail` VARCHAR(50), IN `p_userPassword` VARCHAR(50), IN `p_userRole` VARCHAR(50), IN `p_userDateInscription` VARCHAR(50), IN `p_userSimpleImg` LONGBLOB, IN `p_userSimpleTypeImg` VARCHAR(50), IN `p_userSimpleBanner` LONGBLOB, IN `p_userSimpleTypeBanner` VARCHAR(50))  Begin
    update tbluserssimple set userSimplePlateforme = p_userSimplePlateforme, userSimpleCanModify = p_userSimpleCanModify, userNom =p_userNom, userPrenom = p_userPrenom, userAge = p_userAge , userBio = p_userBio, userNaissance = p_userNaissance,
    userLevel = p_userLevel, userPseudo = p_userPseudo ,userMail = p_userMail, userPassword =p_userPassword, userRole =p_userRole, userDateInscription =p_userDateInscription, userSimpleImg = p_userSimpleImg, userSimpleTypeImg = p_userSimpleTypeImg,
    userSimpleBanner = p_userSimpleBanner, userSimpleTypeBanner = p_userSimpleTypeBanner where idUser = p_idUser ; 

    update tblusers set  userNom =p_userNom, userPrenom = p_userPrenom, userAge = p_userAge , userBio = p_userBio, userNaissance = p_userNaissance,userLevel = p_userLevel, userPseudo = p_userPseudo ,userMail = p_userMail, userPassword =p_userPassword,
     userRole =p_userRole, userDateInscription =p_userDateInscription, userImg = p_userSimpleImg, userTypeImg = p_userSimpleTypeImg, userBanner = p_userSimpleBanner, userTypeBanner = p_userSimpleTypeBanner where idUser = p_idUser ; 
End$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `tblgames`
--

DROP TABLE IF EXISTS `tblgames`;
CREATE TABLE IF NOT EXISTS `tblgames` (
  `idGame` int(11) NOT NULL AUTO_INCREMENT,
  `gameName` varchar(50) NOT NULL,
  `gameDescription` varchar(100) NOT NULL,
  `gameGenre` varchar(100) NOT NULL,
  `gameAvis` varchar(100) NOT NULL,
  `gameClassification` varchar(100) NOT NULL,
  `gameMode` varchar(100) NOT NULL,
  `gameImg` varchar(100) NOT NULL,
  `gameTrailer` varchar(100) NOT NULL,
  `gameImgOther` varchar(100) NOT NULL,
  PRIMARY KEY (`idGame`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tblgames`
--

INSERT INTO `tblgames` (`idGame`, `gameName`, `gameDescription`, `gameGenre`, `gameAvis`, `gameClassification`, `gameMode`, `gameImg`, `gameTrailer`, `gameImgOther`) VALUES
(3, 'Warzone', 'MMO DE FOU IL Y A TROP DE CAMPEUR', 'Multi', '15', '+18', 'Stratégie', 'GamePcApp', 'GamePcApp', 'GamePcApp'),
(4, 'FIFSA', 'JEUX DE FOU IL Y A TROP DE LOOSER', 'MuDlti', '18D', '+3D', 'StratégieD', 'GamePcAppD', 'GamePcAppD', 'GamePcAppD'),
(5, 'BO5', 'NUKE OU RIEN', 'Multi et zombie', '16', '+18', 'DF', 'GameConsoleApp', 'GameConsoleApp', 'GameConsoleApp');

-- --------------------------------------------------------

--
-- Structure de la table `tblgamescs`
--

DROP TABLE IF EXISTS `tblgamescs`;
CREATE TABLE IF NOT EXISTS `tblgamescs` (
  `idGame` int(11) NOT NULL,
  `gameCsSupport` varchar(50) NOT NULL,
  `gameCsDateSortie` varchar(50) NOT NULL,
  `gameCsPrix` float NOT NULL,
  `gameCsTaille` float NOT NULL,
  `gameCsModeleEco` varchar(50) NOT NULL,
  `gameName` varchar(50) NOT NULL,
  `gameDescription` varchar(100) NOT NULL,
  `gameGenre` varchar(100) NOT NULL,
  `gameAvis` varchar(100) NOT NULL,
  `gameClassification` varchar(100) NOT NULL,
  `gameMode` varchar(100) NOT NULL,
  `gameImg` varchar(100) NOT NULL,
  `gameTrailer` varchar(100) NOT NULL,
  `gameImgOther` varchar(100) NOT NULL,
  KEY `idGame` (`idGame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tblgamescs`
--

INSERT INTO `tblgamescs` (`idGame`, `gameCsSupport`, `gameCsDateSortie`, `gameCsPrix`, `gameCsTaille`, `gameCsModeleEco`, `gameName`, `gameDescription`, `gameGenre`, `gameAvis`, `gameClassification`, `gameMode`, `gameImg`, `gameTrailer`, `gameImgOther`) VALUES
(5, 'PS3', '4/24/4343', 12, 44.2, 'ModeleEcofFRFR', 'BO5', 'NUKE OU RIEN', 'Multi et zombie', '16', '+18', 'DF', 'GameConsoleApp', 'GameConsoleApp', 'GameConsoleApp');

-- --------------------------------------------------------

--
-- Structure de la table `tblgamespc`
--

DROP TABLE IF EXISTS `tblgamespc`;
CREATE TABLE IF NOT EXISTS `tblgamespc` (
  `idGame` int(11) NOT NULL,
  `gamePcModeleEco` varchar(50) NOT NULL,
  `gamePcPrix` float NOT NULL,
  `gamePcOs` varchar(50) NOT NULL,
  `gamePcProc` varchar(50) NOT NULL,
  `gamePcCg` varchar(50) NOT NULL,
  `gamePcTaille` float NOT NULL,
  `gameName` varchar(50) NOT NULL,
  `gameDescription` varchar(100) NOT NULL,
  `gameGenre` varchar(100) NOT NULL,
  `gameAvis` varchar(100) NOT NULL,
  `gameClassification` varchar(100) NOT NULL,
  `gameMode` varchar(100) NOT NULL,
  `gameImg` varchar(100) NOT NULL,
  `gameTrailer` varchar(100) NOT NULL,
  `gameImgOther` varchar(100) NOT NULL,
  KEY `idGame` (`idGame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tblgamespc`
--

INSERT INTO `tblgamespc` (`idGame`, `gamePcModeleEco`, `gamePcPrix`, `gamePcOs`, `gamePcProc`, `gamePcCg`, `gamePcTaille`, `gameName`, `gameDescription`, `gameGenre`, `gameAvis`, `gameClassification`, `gameMode`, `gameImg`, `gameTrailer`, `gameImgOther`) VALUES
(4, 'modeleECOJAS', 543.67, 'LINUSX', 'INTDEL I7', '309D0 MIN', 232.12, 'FIFSA', 'JEUX DE FOU IL Y A TROP DE LOOSER', 'MuDlti', '18D', '+3D', 'StratégieD', 'GamePcAppD', 'GamePcAppD', 'GamePcAppD');

-- --------------------------------------------------------

--
-- Structure de la table `tblgroups`
--

DROP TABLE IF EXISTS `tblgroups`;
CREATE TABLE IF NOT EXISTS `tblgroups` (
  `idGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `groupeName` varchar(50) NOT NULL,
  `groupeDescription` varchar(50) NOT NULL,
  `groupeFkIdUser` int(11) NOT NULL,
  `groupePrivacy` varchar(50) NOT NULL,
  `groupeImg` longblob,
  `groupeTypeImg` varchar(50) DEFAULT NULL,
  `groupeBanner` longblob,
  `groupeTypeBanner` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idGroupe`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tblgroups`
--

INSERT INTO `tblgroups` (`idGroupe`, `groupeName`, `groupeDescription`, `groupeFkIdUser`, `groupePrivacy`, `groupeImg`, `groupeTypeImg`, `groupeBanner`, `groupeTypeBanner`) VALUES
(22, 'LES SUUUUU DE JSP', 'Ma frappe ya personne qui l arrete', 324, 'PubliDDc', NULL, 'GDroupePrivateApp', NULL, 'GDroupePrivateApp'),
(26, 'LES V3V', 'On fout jamais la merdeDD', 314, 'PubliDDc', NULL, 'GDroupePublicApp', NULL, 'GDroupePublicApp');

-- --------------------------------------------------------

--
-- Structure de la table `tblgroupsprivate`
--

DROP TABLE IF EXISTS `tblgroupsprivate`;
CREATE TABLE IF NOT EXISTS `tblgroupsprivate` (
  `idGroupe` int(3) NOT NULL,
  `groupeMasquer` tinyint(1) NOT NULL,
  `groupePrivateNbUsers` int(11) NOT NULL,
  `groupePrivateIdUser` int(11) NOT NULL,
  `groupeName` varchar(50) NOT NULL,
  `groupeDescription` varchar(50) NOT NULL,
  `groupeFkIdUser` int(11) NOT NULL,
  `groupePrivacy` varchar(50) NOT NULL,
  `groupeImg` longblob,
  `groupeTypeImg` varchar(50) DEFAULT NULL,
  `groupeBanner` longblob,
  `groupeTypeBanner` varchar(50) DEFAULT NULL,
  KEY `idGroupe` (`idGroupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tblgroupsprivate`
--

INSERT INTO `tblgroupsprivate` (`idGroupe`, `groupeMasquer`, `groupePrivateNbUsers`, `groupePrivateIdUser`, `groupeName`, `groupeDescription`, `groupeFkIdUser`, `groupePrivacy`, `groupeImg`, `groupeTypeImg`, `groupeBanner`, `groupeTypeBanner`) VALUES
(22, 0, 6, 858, 'LES SUUUUU DE JSP', 'Ma frappe ya personne qui l arrete', 324, 'PubliDDc', NULL, 'GDroupePrivateApp', NULL, 'GDroupePrivateApp');

-- --------------------------------------------------------

--
-- Structure de la table `tblgroupspublic`
--

DROP TABLE IF EXISTS `tblgroupspublic`;
CREATE TABLE IF NOT EXISTS `tblgroupspublic` (
  `idGroupe` int(3) NOT NULL,
  `groupeMasquer` tinyint(1) NOT NULL,
  `groupePublicNbUsers` int(11) NOT NULL,
  `groupePublicidUser` int(11) NOT NULL,
  `groupeName` varchar(50) NOT NULL,
  `groupeDescription` varchar(50) NOT NULL,
  `groupeFkIdUser` int(11) NOT NULL,
  `groupePrivacy` varchar(50) NOT NULL,
  `groupeImg` longblob,
  `groupeTypeImg` varchar(50) DEFAULT NULL,
  `groupeBanner` longblob,
  `groupeTypeBanner` varchar(50) DEFAULT NULL,
  KEY `idGroupe` (`idGroupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tblgroupspublic`
--

INSERT INTO `tblgroupspublic` (`idGroupe`, `groupeMasquer`, `groupePublicNbUsers`, `groupePublicidUser`, `groupeName`, `groupeDescription`, `groupeFkIdUser`, `groupePrivacy`, `groupeImg`, `groupeTypeImg`, `groupeBanner`, `groupeTypeBanner`) VALUES
(26, 1, 6, 858, 'LES V3V', 'On fout jamais la merdeDD', 314, 'PubliDDc', NULL, 'GDroupePublicApp', NULL, 'GDroupePublicApp');

-- --------------------------------------------------------

--
-- Structure de la table `tblusers`
--

DROP TABLE IF EXISTS `tblusers`;
CREATE TABLE IF NOT EXISTS `tblusers` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `userNom` varchar(50) NOT NULL,
  `userPrenom` varchar(50) NOT NULL,
  `userAge` varchar(50) NOT NULL,
  `userBio` varchar(50) NOT NULL,
  `userNaissance` varchar(50) NOT NULL,
  `userLevel` int(11) NOT NULL,
  `userPseudo` varchar(50) NOT NULL,
  `userMail` varchar(50) NOT NULL,
  `userPassword` varchar(50) NOT NULL,
  `userRole` varchar(50) NOT NULL,
  `userDateInscription` varchar(50) NOT NULL,
  `userImg` longblob,
  `userTypeImg` varchar(50) DEFAULT NULL,
  `userBanner` longblob,
  `userTypeBanner` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tblusers`
--

INSERT INTO `tblusers` (`idUser`, `userNom`, `userPrenom`, `userAge`, `userBio`, `userNaissance`, `userLevel`, `userPseudo`, `userMail`, `userPassword`, `userRole`, `userDateInscription`, `userImg`, `userTypeImg`, `userBanner`, `userTypeBanner`) VALUES
(13, 'DERPRICHE', 'SaHlim', '23', 'Meilleur wsh', '13/55/2012', 23, 'SERMAXX', 'as@gmail.com', '123', 'user', '21/01/2023', NULL, 'UserSimpleApp', NULL, 'UserSimpleApp'),
(14, 'LAUX', 'Toma', '22', 'I like sleep', 'Trop vieux connais pas DU TOUT', 2, 'KIDEI', 'td@gmail.com', '456', 'Admin', '31/12/2023', NULL, 'UserAdminApp', NULL, 'UserAdminApp');

-- --------------------------------------------------------

--
-- Structure de la table `tblusersadmin`
--

DROP TABLE IF EXISTS `tblusersadmin`;
CREATE TABLE IF NOT EXISTS `tblusersadmin` (
  `idUser` int(11) NOT NULL,
  `userAdminGrade` varchar(50) NOT NULL,
  `userAdminFonction` varchar(50) NOT NULL,
  `userCanModify` tinyint(1) NOT NULL,
  `userNom` varchar(50) NOT NULL,
  `userPrenom` varchar(50) NOT NULL,
  `userAge` varchar(50) NOT NULL,
  `userBio` varchar(50) NOT NULL,
  `userNaissance` varchar(50) NOT NULL,
  `userLevel` int(11) NOT NULL,
  `userPseudo` varchar(50) NOT NULL,
  `userMail` varchar(50) NOT NULL,
  `userPassword` varchar(50) NOT NULL,
  `userRole` varchar(50) NOT NULL,
  `userDateInscription` varchar(50) NOT NULL,
  `userAdminImg` longblob,
  `userAdminTypeImg` varchar(50) DEFAULT NULL,
  `userAdminBanner` longblob,
  `userAdminTypeBanner` varchar(50) DEFAULT NULL,
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tblusersadmin`
--

INSERT INTO `tblusersadmin` (`idUser`, `userAdminGrade`, `userAdminFonction`, `userCanModify`, `userNom`, `userPrenom`, `userAge`, `userBio`, `userNaissance`, `userLevel`, `userPseudo`, `userMail`, `userPassword`, `userRole`, `userDateInscription`, `userAdminImg`, `userAdminTypeImg`, `userAdminBanner`, `userAdminTypeBanner`) VALUES
(14, 'Super-Admin', 'Chef de serive', 1, 'LAUX', 'Toma', '22', 'I like sleep', 'Trop vieux connais pas DU TOUT', 2, 'KIDEI', 'td@gmail.com', '456', 'Admin', '31/12/2023', NULL, 'UserAdminApp', NULL, 'UserAdminApp');

-- --------------------------------------------------------

--
-- Structure de la table `tbluserssimple`
--

DROP TABLE IF EXISTS `tbluserssimple`;
CREATE TABLE IF NOT EXISTS `tbluserssimple` (
  `idUser` int(11) NOT NULL,
  `userSimplePlateforme` varchar(50) NOT NULL,
  `userSimpleCanModify` tinyint(1) NOT NULL,
  `userNom` varchar(50) NOT NULL,
  `userPrenom` varchar(50) NOT NULL,
  `userAge` varchar(50) NOT NULL,
  `userBio` varchar(50) NOT NULL,
  `userNaissance` varchar(50) NOT NULL,
  `userLevel` int(11) NOT NULL,
  `userPseudo` varchar(50) NOT NULL,
  `userMail` varchar(50) NOT NULL,
  `userPassword` varchar(50) NOT NULL,
  `userRole` varchar(50) NOT NULL,
  `userDateInscription` varchar(50) NOT NULL,
  `userSimpleImg` longblob,
  `userSimpleTypeImg` varchar(50) DEFAULT NULL,
  `userSimpleBanner` longblob,
  `userSimpleTypeBanner` varchar(50) DEFAULT NULL,
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tbluserssimple`
--

INSERT INTO `tbluserssimple` (`idUser`, `userSimplePlateforme`, `userSimpleCanModify`, `userNom`, `userPrenom`, `userAge`, `userBio`, `userNaissance`, `userLevel`, `userPseudo`, `userMail`, `userPassword`, `userRole`, `userDateInscription`, `userSimpleImg`, `userSimpleTypeImg`, `userSimpleBanner`, `userSimpleTypeBanner`) VALUES
(13, 'PCSS', 0, 'DERPRICHE', 'SaHlim', '23', 'Meilleur wsh', '13/55/2012', 23, 'SERMAXX', 'as@gmail.com', '123', 'user', '21/01/2023', NULL, 'UserSimpleApp', NULL, 'UserSimpleApp');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `tblgamescs`
--
ALTER TABLE `tblgamescs`
  ADD CONSTRAINT `tblgamescs_ibfk_1` FOREIGN KEY (`idGame`) REFERENCES `tblgames` (`idGame`);

--
-- Contraintes pour la table `tblgamespc`
--
ALTER TABLE `tblgamespc`
  ADD CONSTRAINT `tblgamespc_ibfk_1` FOREIGN KEY (`idGame`) REFERENCES `tblgames` (`idGame`);

--
-- Contraintes pour la table `tblusersadmin`
--
ALTER TABLE `tblusersadmin`
  ADD CONSTRAINT `tblusersadmin_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `tblusers` (`idUser`);

--
-- Contraintes pour la table `tbluserssimple`
--
ALTER TABLE `tbluserssimple`
  ADD CONSTRAINT `tbluserssimple_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `tblusers` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
