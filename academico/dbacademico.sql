create database dbacademico;
show databases;
use dbacademico;
create table alunos(matricula int primary key auto_increment, nome varchar(50) not null, media DECIMAL(4,2), frequencia float);
show tables;
describe alunos;