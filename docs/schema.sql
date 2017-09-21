create table tbl_hotel(
  hotel_no int primary key auto_increment,
  hotel_name varchar(30) not null,
  hotel_addr varchar(100) not null,
  hotel_phone varchar(20) not null,
  hotel_room_cnt int,
  hotel_pic mediumblob 
);

-- medium blob , blob:binary large object

alter table tbl_hotel add hotel_room_cnt int;

create table tbl_room(
   room_id int primary key auto_increment,
   room_no varchar(10) not null,
   room_type char(1) not null,
   room_equipment varchar(20) not null,
   room_status char(1) not null,
   room_memo varchar(255),
   hotel_no int not null,
   constraint FK_HOTEL_ROOM FOREIGN KEY(hotel_no) references tbl_hotel(hotel_no)
);

create table tbl_users(
   user_no    char(6) primary key,
   user_pwd   char(6) not null,
   user_name  varchar(30) not null
);

insert into tbl_users values('000101','123456','张青山');
insert into tbl_users values('000102','123456','刘海燕');