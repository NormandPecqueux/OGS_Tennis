CREATE TABLE `joueur` (
	`joueur_id` int(11) NOT NULL AUTO_INCREMENT,
	`nom` varchar(200) NOT NULL,
	`prenom` varchar(200) NOT NULL,
	`numero_adherent` int(1) NOT NULL,
	PRIMARY KEY (`joueur_id`),
	`login` varchar(100),
	`pswd` varchar(100),
	`administrateur` boolean NOT null,
	`information` varchar(350),
	`equipe_id` int(11) ,
	KEY `equipe_id_fk`(`equipe_id`),
	constraint `equipe_id_fk` foreign key(`equipe_id`) references `equipe`(`equipe_id`), 
);

CREATE TABLE `equipe` (
	`equipe_id` int(11) NOT NULL AUTO_INCREMENT,
    `equipe_numero` int(2) ,
    `joueur_id` int(11) NOT NULL,
    primary key (`equipe_id`),
    KEY `joueur_id_fk` (`joueur_id`),
    constraint `joueur_id_fk` foreign key(`joueur_id`) references `joueur`(`joueur_id`),
    
    
);

CREATE TABLE `match`(
	`match_id` int(11)) NOT NULL AUTO_INCREMENT,
	primary key(`match_id`),
    `joueur1_id_fk` int(11) NOT NULL, 
    `joueur2_id_fk` int(11) NOT NULL,
	KEY `joueur1_id_fk` (`joueur_id`),
    constraint `joueur1_id_fk` foreign key(`joueur_id`) references `joueur`(`joueur_id`),
	KEY `joueur2_id_fk` (`joueur_id`),
    constraint `joueur2_id_fk` foreign key(`joueur_id`) references `joueur`(`joueur_id`),
    `resultat` varchar(100),
	`date` date NOT NULL,

);

CREATE TABLE `article`(
	`article_id` int(11) NOT NULL auto_increment,
    primary key(`artcle_id`),
    `titre_article` varchar(100),
    `texte` varchar(500),

);

CREATE TABLE `photo`(
	`photo_id` int(11) NOT NULL auto_increment,
    `photo` , 
    
);

