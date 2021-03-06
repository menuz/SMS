drop table if exists tb_student;

/* stu is short for student */
create table tb_student (
	stu_id int,
	stu_no varchar(8),
	stu_name varchar(10),
	stu_sex varchar(4),
	stu_major varchar(20),
	stu_phone varchar(11), 
	stu_level int,
	stu_score int,
	stu_gpa double
);

drop table  if exists tb_assistant;

-- ast is short for assistant
create table tb_assistant (
	ast_id int,
	ast_name varchar(10),
	ast_phone varchar(11)
);

drop table if exists tb_group;

-- grp is short for group
create table tb_group (
	grp_id int,
	grp_assistant_id int,
	grp_student_id int,
	grp_leader int
);


drop table if exists tb_score_record;

-- sr is short for score record
create table tb_score_record (
	sr_id int primary key auto_increment not null,
	sr_student_id int,
	sr_score_type_id int,
	sr_comment varchar(100),
	sr_ct timestamp default current_timestamp
);
alter table tb_score_record
add sr_total int; 

alter table tb_score_record drop column sr_total;

-- srt is short for score record total, equals to sr_total
create table tb_score_record_total (
	srt_id int,
	srt_score int
)


drop table if exists tb_score_type;

-- st is short for score type
create table tb_score_type (
	st_id int primary key auto_increment not null,
	st_name varchar(40),
	st_score int
);

-- if is short for info
create table tb_info(
	if_id int primary key auto_increment not null,
	if_info varchar(200),
	if_ct timestamp default current_timestamp
);


-- u is short for user
-- 1 is admin 0 is not admin 
create table tb_user (
	u_id int primary key auto_increment not null,
	u_username varchar(20),
	u_password varchar(20),
	u_admin int
);

commit;




