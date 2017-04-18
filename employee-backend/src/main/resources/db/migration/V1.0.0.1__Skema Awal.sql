create table t_location (
	id varchar(255) not null,
	city varchar(255) not null,
	primary key (id)
);

create table t_employee (
    emp_id varchar(255) not null,
    date_of_birth date,
    division varchar(45),
    email varchar(50) not null,
    first_name varchar(45) not null,
    gender varchar(6) not null,
    grade varchar(45),
    hired_date date,
    last_name varchar(45) not null,
    martial_status varchar(7),
    nationality varchar(45) not null,
    phone varchar(15),
    photo varchar(255),
    status varchar(20),
    sub_division varchar(45),
    suspend_date date,
    loc_id varchar(255) not null,
    primary key (emp_id),
    foreign key (loc_id) references t_location(id)
);