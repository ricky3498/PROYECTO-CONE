-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-10-2019 a las 08:09:42
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_hospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `atencion_medica`
--

CREATE TABLE `atencion_medica` (
  `id_atencion` int(11) NOT NULL,
  `id_cita` int(11) NOT NULL,
  `fecha_atencion` datetime NOT NULL,
  `estado` int(11) NOT NULL,
  `diagnostico` varchar(99) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_medica`
--

CREATE TABLE `cita_medica` (
  `id_cita` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `numero_cita` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_programada`
--

CREATE TABLE `cita_programada` (
  `id_cProgramada` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `id_consultorio` int(11) NOT NULL,
  `fecha_cProgramada` int(11) NOT NULL,
  `vacantes_cProgramada` int(11) NOT NULL,
  `estado_cProgramada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultorio`
--

CREATE TABLE `consultorio` (
  `id_consultorio` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_atencion`
--

CREATE TABLE `detalle_atencion` (
  `id_detalle_atencion` int(11) NOT NULL,
  `id_atencion` int(11) NOT NULL,
  `id_madicamentos` int(11) NOT NULL,
  `tratamiento` varchar(99) COLLATE utf8_unicode_ci NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `descripcion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `id_especialidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_clinico`
--

CREATE TABLE `historial_clinico` (
  `id_historial` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_atencion` int(11) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `id_medicamentos` int(11) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fechaElaboracion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fechaVencimiento` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `marca` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `categoria` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `stock` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `estado` bit(1) NOT NULL,
  `laboratorio` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `sexo` bit(1) NOT NULL,
  `correo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `id_medico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id_pac` int(11) NOT NULL,
  `dni_pac` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_pac` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `apellido_pac` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `password` char(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `atencion_medica`
--
ALTER TABLE `atencion_medica`
  ADD PRIMARY KEY (`id_atencion`);

--
-- Indices de la tabla `cita_medica`
--
ALTER TABLE `cita_medica`
  ADD PRIMARY KEY (`id_cita`);

--
-- Indices de la tabla `cita_programada`
--
ALTER TABLE `cita_programada`
  ADD PRIMARY KEY (`id_cProgramada`);

--
-- Indices de la tabla `consultorio`
--
ALTER TABLE `consultorio`
  ADD PRIMARY KEY (`id_consultorio`);

--
-- Indices de la tabla `detalle_atencion`
--
ALTER TABLE `detalle_atencion`
  ADD PRIMARY KEY (`id_detalle_atencion`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD PRIMARY KEY (`id_medicamentos`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_medico`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_pac`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `atencion_medica`
--
ALTER TABLE `atencion_medica`
  MODIFY `id_atencion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cita_medica`
--
ALTER TABLE `cita_medica`
  MODIFY `id_cita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cita_programada`
--
ALTER TABLE `cita_programada`
  MODIFY `id_cProgramada` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `consultorio`
--
ALTER TABLE `consultorio`
  MODIFY `id_consultorio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_atencion`
--
ALTER TABLE `detalle_atencion`
  MODIFY `id_detalle_atencion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  MODIFY `id_medicamentos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `id_medico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id_pac` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
