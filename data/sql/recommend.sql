use recommend;
SET FOREIGN_KEY_CHECKS = 0;

-- --------------
-- movies
-- --------------
DROP TABLE IF EXISTS `reco_movies`;
CREATE TABLE `reco_movies`(
  `id` BIGINT PRIMARY KEY,
  `average_rating` INT,
  `genres` VARCHAR(50) COMMENT '分类数组',
  `title` VARCHAR(100) COMMENT '电影名',
  `small` VARCHAR(255),
  `medium` VARCHAR(255),
  `large` VARCHAR(255),
  `year` VARCHAR(10)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# DELETE FROM reco_movies WHERE id > 100;

# SELECT * FROM reco_movies WHERE find_in_set('举起手来', title);

# SELECT * FROM reco_movies ORDER BY average_rating DESC LIMIT 0,50;

-- --------------
-- user
-- --------------
DROP TABLE IF EXISTS `reco_usercf`;
CREATE TABLE `reco_usercf`(
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `user_id` BIGINT,
  `movie_id` BIGINT,
  `movie_rating` DOUBLE,
  FOREIGN KEY (`movie_id`) REFERENCES `reco_movies` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=1;

# DROP INDEX UK_reco_unique_key_1 ON recommend.reco_usercf;
# alter table reco_usercf change id id bigint not null auto_increment;

INSERT INTO reco_usercf VALUES (null, '1', '1291571', '8.5');
INSERT INTO reco_usercf VALUES (null, '1', '1652587', '9');
INSERT INTO reco_usercf VALUES (null, '1', '1291561', '8.5');
INSERT INTO reco_usercf VALUES (null, '1', '1306809', '9');
INSERT INTO reco_usercf VALUES (null, '1', '1291843', '9.5');
# 与fenpanpan接近
INSERT INTO reco_usercf VALUES (null, '2', '1291571', '8');
INSERT INTO reco_usercf VALUES (null, '2', '1652587', '9');
INSERT INTO reco_usercf VALUES (null, '2', '1291561', '9.5');
INSERT INTO reco_usercf VALUES (null, '2', '1306809', '8.5');
INSERT INTO reco_usercf VALUES (null, '2', '1306809', '9.5');
# 与yangzifeng接近
INSERT INTO reco_usercf VALUES (null, '3', '1291571', '8.5');
INSERT INTO reco_usercf VALUES (null, '3', '1652587', '9');
INSERT INTO reco_usercf VALUES (null, '3', '1291561', '8.5');
INSERT INTO reco_usercf VALUES (null, '3', '1306809', '9');
INSERT INTO reco_usercf VALUES (null, '3', '1300656', '9.5');
# 与niexin接近
INSERT INTO reco_usercf VALUES (null, '4', '1291571', '8');
INSERT INTO reco_usercf VALUES (null, '4', '1652587', '9');
INSERT INTO reco_usercf VALUES (null, '4', '1291561', '9.5');
INSERT INTO reco_usercf VALUES (null, '4', '1306809', '9');
INSERT INTO reco_usercf VALUES (null, '4', '1306809', '9');
# 与yangzifeng接近
INSERT INTO reco_usercf VALUES (null, '5', '1291571', '8.5');
INSERT INTO reco_usercf VALUES (null, '5', '1652587', '9');
INSERT INTO reco_usercf VALUES (null, '5', '1291561', '8.5');
INSERT INTO reco_usercf VALUES (null, '5', '1306809', '9');
INSERT INTO reco_usercf VALUES (null, '5', '1293013', '9.5');


SELECT movie_rating FROM reco_usercf WHERE user_id = '1';







