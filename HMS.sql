create database hospital_management_system;
use hospital_management_system;

create table login(ID varchar(20),PW varchar(20));
select * from login;

insert into login value("GTlogin","GT123");

create table patient_info(ID varchar(20),Number varchar(40),Name varchar(40),Gender varchar(40),Patient_Disease varchar(40),Room_Number varchar(40),Time varchar(40),Deposite varchar(40));
select * from patient_info;

create table Room(room_no varchar(40),Availability varchar(20), Price varchar(20),Room_Type varchar(20));
select * from Room;

insert into Room values("100","Available","500","G Bed1");
insert into Room values("101","Available","500","G Bed2");
insert into Room values("102","Available","500","G Bed3");
insert into Room values("103","Available","500","G Bed4");
insert into Room values("200","Available","1500","Private Room");
insert into Room values("201","Available","1500","Private Room");
insert into Room values("202","Available","1500","Private Room");
insert into Room values("203","Available","1500","Private Room");
insert into Room values("300","Available","3500","ICU Bed1");
insert into Room values("301","Available","3500","ICU Bed2");
insert into Room values("302","Available","3500","ICU Bed3");
insert into Room values("303","Available","3500","ICU Bed4");
insert into Room values("304","Available","3500","ICU Bed5");
insert into Room values("305","Available","3500","ICU Bed6");

create table department(Department varchar(100),Phone_No varchar(20));
select * from department;

insert into department values("Surgical Department","1234567890");
insert into department values("Nursing Department","1478523690");
insert into department values("Operation theater Complex(OT)","1856923690");
insert into department values("Paramedical Department","1478523690");


create table EMP_INFO(Name varchar(30),Age varchar(10),Phone_No varchar(20),Gmail varchar(50),Aadhar_Number varchar(30));
select * from EMP_INFO;

insert into EMP_INFO values("Doctor1","30","2587413690","do1@gmail.com","123456789875");
insert into EMP_INFO values("Doctor2","35","2584513690","do2@gmail.com","321456789875");

create table Ambulance(Name varchar(20),Gender varchar(10),Car_name varchar(20),Available varchar(20),Location varchar(20));
insert into Ambulance values("ab","Male","Zen","Available","area 16");
select * from Ambulance;