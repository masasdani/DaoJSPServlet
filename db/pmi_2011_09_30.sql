-- 
-- Structure for table `donatur`
-- 

DROP TABLE IF EXISTS `donatur`;
CREATE TABLE IF NOT EXISTS `donatur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

