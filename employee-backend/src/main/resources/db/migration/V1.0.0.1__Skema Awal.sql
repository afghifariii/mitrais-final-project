create table t_location (
	id varchar(255) not null,
	city varchar(255) not null,
	primary key (id)
);

create table t_employee (
    emp_id varchar(255) not null,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    gender varchar(6) not null,
    date_of_birth date not null,
    nationality varchar(45) not null,
    marital_status varchar(7) not null,
    phone varchar(25) not null unique,
    email varchar(50) not null unique,
    hired_date date not null,
    suspend_date date,
    division varchar(45) not null,
    grade varchar(45) not null,
    sub_division varchar(45) not null,
    status varchar(20) not null,
    photo text,
    loc_id varchar(255) not null,
    primary key (emp_id),
    foreign key (loc_id) references t_location(id)
);