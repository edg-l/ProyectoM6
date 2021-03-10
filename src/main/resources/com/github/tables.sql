create table if not exists client (
    id int AUTO_INCREMENT,
    name varchar(120) not null,
    country varchar(120) not null,
    createdAt date not null,
    isPartner bool not null,
    primary key (id)
);

create table if not exists videogame (
    id int AUTO_INCREMENT,
    name varchar(120) not null,
    platform int not null,
    releaseDate date not null,
    price int not null,
    primary key (id)
);

create table if not exists client_videogames (
    client_id int not null,
    videogame_id int not null,
    primary key (client_id, videogame_id),
    foreign key (client_id) references client(id),
    foreign key (videogame_id) references videogame(id)
);