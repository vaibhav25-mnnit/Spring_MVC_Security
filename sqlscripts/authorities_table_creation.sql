create table authorities (
username varchar(50) not null,
authority varchar(50) not null,
unique key authorities_idx_1 (username,authority),
constraint authorities_ibfk_1
foreign key (username)
references users (username)
)
