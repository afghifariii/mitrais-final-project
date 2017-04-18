create table t_location (
	id varchar(255) not null,
	city varchar(255) not null,
	primary key (id)
);

create table t_employee (
    emp_id varchar(255) not null,
    date_of_birth date not null,
    division varchar(45) not null,
    email varchar(50) not null,
    first_name varchar(45) not null,
    gender varchar(6) not null,
    grade varchar(45) not null,
    hired_date date not null,
    last_name varchar(45) not null,
    martial_status varchar(7) not null,
    nationality varchar(45) not null,
    phone varchar(15) not null,
    photo varchar(255),
    status varchar(20) not null,
    sub_division varchar(45) not null,
    suspend_date date,
    loc_id varchar(255) not null,
    primary key (emp_id),
    foreign key (loc_id) references t_location(id)
);