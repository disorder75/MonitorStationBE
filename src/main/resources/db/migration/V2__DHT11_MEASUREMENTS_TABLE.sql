CREATE TABLE `DHT11_MEASUREMENTS` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `MAC_DEVICE_ID` varchar(256) NOT NULL,
  `TEMP` varchar(128) DEFAULT 'not sampled',
  `RH` varchar(128) DEFAULT 'not sampled',
  `DT_CREATION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
)

