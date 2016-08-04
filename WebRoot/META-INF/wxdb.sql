-- --------------------------------------------------------
-- 主机:                           120.27.28.3
-- 服务器版本:                        5.6.30-log - Source distribution
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 wxdb 的数据库结构
CREATE DATABASE IF NOT EXISTS `wxdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `wxdb`;


-- 导出  表 wxdb.admins 结构
CREATE TABLE IF NOT EXISTS `admins` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '管理员账户',
  `password` varchar(20) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  wxdb.admins 的数据：~0 rows (大约)
DELETE FROM `admins`;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;


-- 导出  表 wxdb.pages 结构
CREATE TABLE IF NOT EXISTS `pages` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `belongUser` varchar(50) NOT NULL COMMENT '创建用户',
  `belongType` varchar(50) NOT NULL COMMENT '所属类别',
  `contents` longtext NOT NULL COMMENT '页面html源码',
  `time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `FK_pages_users` (`belongUser`),
  KEY `FK_pages_pagetypes` (`belongType`),
  CONSTRAINT `FK_pages_pagetypes` FOREIGN KEY (`belongType`) REFERENCES `pagetypes` (`id`),
  CONSTRAINT `FK_pages_users` FOREIGN KEY (`belongUser`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  wxdb.pages 的数据：~0 rows (大约)
DELETE FROM `pages`;
/*!40000 ALTER TABLE `pages` DISABLE KEYS */;
/*!40000 ALTER TABLE `pages` ENABLE KEYS */;


-- 导出  表 wxdb.pagetypes 结构
CREATE TABLE IF NOT EXISTS `pagetypes` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '页面类别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  wxdb.pagetypes 的数据：~0 rows (大约)
DELETE FROM `pagetypes`;
/*!40000 ALTER TABLE `pagetypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagetypes` ENABLE KEYS */;


-- 导出  表 wxdb.resources 结构
CREATE TABLE IF NOT EXISTS `resources` (
  `id` varchar(50) NOT NULL COMMENT '资源id',
  `belongUser` varchar(50) NOT NULL COMMENT '上传资源的用户',
  `belongType` varchar(50) NOT NULL COMMENT '所属资源类别',
  `time` datetime NOT NULL COMMENT '上传资源的时间',
  `url` varchar(100) NOT NULL COMMENT '资源地址',
  PRIMARY KEY (`id`),
  KEY `FK_resources_users` (`belongUser`),
  KEY `FK_resources_resourcetypes` (`belongType`),
  CONSTRAINT `FK_resources_resourcetypes` FOREIGN KEY (`belongType`) REFERENCES `resourcetypes` (`id`),
  CONSTRAINT `FK_resources_users` FOREIGN KEY (`belongUser`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  wxdb.resources 的数据：~0 rows (大约)
DELETE FROM `resources`;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;


-- 导出  表 wxdb.resourcetypes 结构
CREATE TABLE IF NOT EXISTS `resourcetypes` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '资源名称',
  PRIMARY KEY (`id`),
  KEY `FK__resources` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  wxdb.resourcetypes 的数据：~0 rows (大约)
DELETE FROM `resourcetypes`;
/*!40000 ALTER TABLE `resourcetypes` DISABLE KEYS */;
INSERT INTO `resourcetypes` (`id`, `name`) VALUES
	('01', '图片'),
	('03', '视频'),
	('02', '音频');
/*!40000 ALTER TABLE `resourcetypes` ENABLE KEYS */;


-- 导出  表 wxdb.users 结构
CREATE TABLE IF NOT EXISTS `users` (
  `id` varchar(50) NOT NULL COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '账户',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `headimg` varchar(50) DEFAULT NULL COMMENT '头像',
  `company` varchar(50) DEFAULT NULL COMMENT '所属公司',
  `applyid` varchar(50) DEFAULT NULL COMMENT '微信ID',
  `applysecret` varchar(50) DEFAULT NULL COMMENT '微信密钥',
  `token` varchar(50) DEFAULT NULL COMMENT '微信token',
  `wxname` varchar(50) DEFAULT NULL COMMENT '微信名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  wxdb.users 的数据：~0 rows (大约)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
