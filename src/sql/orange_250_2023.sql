drop database if exists orange_250_2023;
create database orange_250_2023;
use orange_250_2023;

create table client(
    idclient int(3) not null auto_increment,
    nom varchar(30),
    prenom varchar(30),
    email varchar(50),
    adresse varchar(50),
    tel varchar(20),
    primary key (idclient)
);

create table technicien(
    idtechnicien int(3) not null auto_increment,
    nom varchar(30),
    prenom varchar(30),
    email varchar(50),
    mdp varchar(50),
    qualification varchar(50),
    primary key (idtechnicien)
);

create table intervention(
    idintervention int(3) not null auto_increment,
    materiel varchar(30),
    panne varchar(30),
    dateinter date,
    prix float,
    idclient int(3) not null,
    idtechnicien int(3) not null,
    primary key (idintervention),
    foreign key (idclient) references client(idclient),
    foreign key (idtechnicien) references technicien(idtechnicien)
);
    




