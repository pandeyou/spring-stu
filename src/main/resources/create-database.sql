-- app
create database stuapp character set utf8mb4 collate utf8mb4_0900_as_cs;
create user 'stuapp'@'%' identified by 'stuapp';
GRANT ALL PRIVILEGES ON stuapp.* TO 'stuapp'@'%'WITH GRANT OPTION;

-- def
create database studef character set utf8mb4 collate utf8mb4_0900_as_cs;
create user 'studef'@'%' identified by 'studef';
GRANT ALL PRIVILEGES ON studef.* TO 'studef'@'%'WITH GRANT OPTION;
