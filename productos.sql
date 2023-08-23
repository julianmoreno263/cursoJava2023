-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-08-2023 a las 00:14:16
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pruebas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `CODIGOARTICULO` varchar(4) DEFAULT NULL,
  `seccion` varchar(10) DEFAULT NULL,
  `nombrearticulo` varchar(20) DEFAULT NULL,
  `FECHA` varchar(10) DEFAULT NULL,
  `paisdeorigen` varchar(9) DEFAULT NULL,
  `PRECIO` decimal(15) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`CODIGOARTICULO`, `seccion`, `nombrearticulo`, `FECHA`, `paisdeorigen`, `PRECIO`) VALUES
('AR01', 'CERÁMICA', 'Tubos', '4/03/1997', 'China', '140,35435673674'),
('AR02', 'CERÁMICA', 'Plato Decorativo', '7/06/1997', 'China', '45,075907828784'),
('AR03', 'CERÁMICA', 'Juego de te', '15/01/1997', 'China', '36,060726263027'),
('AR04', 'CERÁMICA', 'Cenicero', '2/07/1997', 'Japón', '16,455711418028'),
('AR05', 'CERÁMICA', 'Maceta', '23/02/1997', 'España', '24,202757443535'),
('AR06', 'CERÁMICA', 'Jarra china', '2/09/1997', 'China', '106,47530441263'),
('AR07', 'CONFECCIÓN', 'Tarje Caballero', '11/03/1997', 'Italia', '237,14735614775'),
('AR08', 'CONFECCIÓN', 'Pantalón Señora', '1/05/1997', 'Marruecos', '145,19250417703'),
('AR09', 'CONFECCIÓN', 'Camisa Caballero', '11/08/1997', 'España', '55,942206676042'),
('AR10', 'CONFECCIÓN', 'Blusa Sra.', '18/03/1997', 'China', '84,213816066256'),
('AR11', 'CONFECCIÓN', 'Cazadora piel', '10/07/1997', 'Italia', '435,5775125311'),
('AR12', 'CONFECCIÓN', 'Abrigo Caballero', '5/07/1997', 'Italia', '203,26830382364'),
('AR13', 'CONFECCIÓN', 'Abrigo Sra', '3/05/1997', 'Marruecos', '300,06130323465'),
('AR14', 'CONFECCIÓN', 'Cinturón de piel', '12/05/1997', 'España', '3,6060726263027'),
('AR15', 'DEPORTE', 'Raqueta Tenis', '20/03/1997', 'Usa', '77,891168728138'),
('AR16', 'DEPORTE', 'Chándal', '13/09/1997', 'Usa', '193,39367494861'),
('AR17', 'DEPORTE', 'Tren Eléctrico', '3/07/1997', 'Japón', '1254,4805452382'),
('AR18', 'DEPORTE', 'Pistola Olímpica', '23/05/1997', 'Suecia', '38,945584364069'),
('AR19', 'DEPORTE', 'Monopatín', '11/11/1997', 'Marruecos', '93,036673758609'),
('AR20', 'DEPORTE', 'Balón baloncesto', '25/06/1997', 'Japón', '62,727633334535'),
('AR21', 'DEPORTE', 'Balón Fútbol', '5/07/1997', 'España', '36,595627035929'),
('AR22', 'DEPORTE', 'Sudadera', '3/11/1997', 'Usa', '365,98031084346'),
('AR23', 'DEPORTE', 'Bicicleta de montaña', '14/03/1997', 'Usa', '470,41818422223'),
('AR24', 'FERRETERÍA', 'Destornillador', '22/10/1997', 'España', '5,523301239287'),
('AR25', 'FERRETERÍA', 'Serrucho', '23/03/1997', 'Francia', '25,170386931593'),
('AR26', 'FERRETERÍA', 'Llave Inglesa', '23/04/1997', 'Usa', '20,332239491303'),
('AR27', 'FERRETERÍA', 'Alicates', '17/04/1997', 'Italia', '5,6134530549445'),
('AR28', 'FERRETERÍA', 'Martillo', '4/09/1997', 'España', '9,4959912492638'),
('AR29', 'FERRETERÍA', 'Destornillador', '20/02/1997', 'Francia', '7,5487120310603'),
('AR30', 'FERRETERÍA', 'Lima Grande', '10/08/1997', 'España', '18,390970394144'),
('AR31', 'FERRETERÍA', 'Juego de brocas', '4/07/1997', 'Taiwán', '12,579183344753'),
('AR32', 'JUGUETERÍA', 'Coche Teledirigido', '26/05/1997', 'Marruecos', '132,87175603717'),
('AR33', 'JUGUETERÍA', 'Correpasillos', '11/04/1997', 'Japón', '86,113014316108'),
('AR34', 'JUGUETERÍA', 'Consola Video', '24/09/1997', 'Usa', '368,78703737093'),
('AR35', 'JUGUETERÍA', 'Muñeca Andadora', '4/10/1997', 'España', '87,549433245586'),
('AR36', 'JUGUETERÍA', 'Fuerte de soldados', '25/11/1997', 'Japón', '119,75166179847'),
('AR37', 'JUGUETERÍA', 'Pistola con sonidos', '15/02/1997', 'España', '47,708340845985'),
('AR38', 'JUGUETERÍA', 'Pie de lámpara', '27/05/1997', 'Turquía', '33,133797314678');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
