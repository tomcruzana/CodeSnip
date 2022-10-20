DROP DATABASE codesnip_db;
CREATE DATABASE codesnip_db;
USE codesnip_db;

CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`fname` VARCHAR(64),
	`lname` VARCHAR(64),
	`username` VARCHAR(32) NOT NULL UNIQUE,
	`email` VARCHAR(128) NOT NULL UNIQUE,
	`password` VARCHAR(512) NOT NULL,
	`enabled` INT NOT NULL,
	`date_of_brith` DATE,
	`date_created` DATE NOT NULL,
	`bio` VARCHAR(1024),
	`image` VARCHAR(256),

	PRIMARY KEY(`id`) 
);

# password123
# https://bcrypt-generator.com/
INSERT INTO `user`(`username`, `email`, `password`, `enabled`, `date_created`) 
VALUES('testuser1', 'testuser1@email.com', '$2a$12$TrmBocvbaAW/ztZsytaMZ.bLnwlWkLBK5DvAM8gPt.1dcCX0ofB6S', 1, CURDATE());

INSERT INTO `user`(`username`, `email`, `password`, `enabled`, `date_created`) 
VALUES('testuse21', 'testuser21@email.com', '$2a$12$TrmBocvbaAW/ztZsytaMZ.bLnwlWkLBK5DvAM8gPt.1dcCX0ofB6S', 1, CURDATE());

##################################################################################################################

CREATE TABLE `authority` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  
  CONSTRAINT `fk_auth_user`
    FOREIGN KEY (user_id) REFERENCES user(id),
    
  PRIMARY KEY (`id`)
);

INSERT INTO `authority` (`user_id`, `name`)
VALUES (1, 'ROLE_FREE_USER');

INSERT INTO `authority` (`user_id`, `name`)
VALUES (1, 'ROLE_PRO_USER');

INSERT INTO `authority` (`user_id`, `name`)
VALUES (2, 'ROLE_PRO_USER');

##################################################################################################################

CREATE TABLE `snippet_collection` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` VARCHAR(34) NOT NULL,
  `description` VARCHAR(125) NOT NULL,
  `programming_language` VARCHAR(64) NOT NULL,
  `date_created` DATE NOT NULL,
  `link` VARCHAR(512),

  CONSTRAINT `fk_sc_user`
    FOREIGN KEY (user_id) REFERENCES user(id),
    
  PRIMARY KEY (`id`)
);

INSERT INTO `snippet_collection`(`user_id`, `title`, `description`, `programming_language`, `date_created`) 
VALUES(1, 'http servlet code snippets', 'Lorem ipsom dolor amet', 'java', CURDATE());

INSERT INTO `snippet_collection`(`user_id`, `title`, `description`, `programming_language`, `date_created`) 
VALUES(2, 'http php code ', 'Lorem ipsom asda dolor amet', 'php', CURDATE());

##################################################################################################################
	
CREATE TABLE `snippet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `snippet_collection_id` int NOT NULL,
  `title` VARCHAR(34) NOT NULL,
  `is_public` BOOLEAN DEFAULT FALSE,
  `programming_language` VARCHAR(64) NOT NULL,
  `date_created` DATE NOT NULL,
  `code` TEXT,
  
  CONSTRAINT `fk_s_snippet_collection`
    FOREIGN KEY (snippet_collection_id) REFERENCES `snippet_collection`(id),
    
  PRIMARY KEY (`id`)
);

INSERT INTO `snippet`(`snippet_collection_id`, `title`, `is_public`, `programming_language`, `date_created`, `code`)  
VALUES(1, 'luv2code angular http', FALSE, 'java', CURDATE(), 'const x =>{ console.log(y); }');

INSERT INTO `snippet`(`snippet_collection_id`, `title`, `is_public`, `programming_language`, `date_created`, `code`)  
VALUES(1, 'luv2code java http', FALSE, 'java', CURDATE(), 'let x =>{ console.log(y); }');

INSERT INTO `snippet`(`snippet_collection_id`, `title`, `is_public`, `programming_language`, `date_created`, `code`)  
VALUES(1, 'luv2code spring boot http', FALSE, 'java', CURDATE(), 'var x =>{ console.log(y); }');

INSERT INTO `snippet`(`snippet_collection_id`, `title`, `is_public`, `programming_language`, `date_created`, `code`)  
VALUES(2, 'asddasd', FALSE, 'javax', CURDATE(), 'var x =>{ consssole.log(y); }');

INSERT INTO `snippet`(`snippet_collection_id`, `title`, `is_public`, `programming_language`, `date_created`, `code`)  
VALUES(2, 'asddasd', FALSE, 'redis', CURDATE(), 'User x =>{ System.out.println(2) }');


##################################################################################################################


CREATE TABLE `tag` (
  `name` VARCHAR(34) NOT NULL,
  `snippet_collection_id` int NOT NULL,
  
  CONSTRAINT `fk_tag_snippet_collection`
    FOREIGN KEY (snippet_collection_id) REFERENCES `snippet_collection`(id),
    
  PRIMARY KEY (`name`)
);


SELECT * FROM `authority`;
SELECT * FROM `snippet_collection`;
SELECT * FROM `snippet`;
SELECT * FROM `tag`;

SELECT * FROM `snippet_collection`
	INNER JOIN `snippet` ON `snippet_collection`.id = `snippet`.`snippet_collection_id`
	WHERE `snippet_collection`.id = 2;


DROP TABLE `user`;