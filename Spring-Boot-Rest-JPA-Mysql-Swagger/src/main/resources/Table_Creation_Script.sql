create database custsupplier;

use custsupplier;

-- Phone number
CREATE TABLE phone_details(
id bigint(20) Primary key NOT NULL,
version int(10) NOT NULL,
area_code varchar (10) NOT NULL,
number varchar (15) NOT NULL,
created_by varchar(10) NOT NULL,
created_date date NOT NULL,
modified_by varchar(10) NOT NULL,
modified_date date NOT NULL,
active int(1) DEFAULT 1
);

-- Person table
CREATE TABLE person(
id bigint(20) Primary key NOT NULL,
version int(10) NOT NULL,
first_name varchar (25) NOT NULL,
last_name varchar (25) NOT NULL,
phone_details_id bigint(20) NOT NULL,
created_by varchar(10) NOT NULL,
created_date date NOT NULL,
modified_by varchar(10) NOT NULL,
modified_date date NOT NULL,
active int(1) DEFAULT 1,
foreign key(phone_details_id) references phone_details(id)
);

-- Company table
CREATE TABLE company(
id bigint(20) Primary key NOT NULL,
version int(10) NOT NULL,
name varchar (250) NOT NULL,
registration_number varchar (100) NOT NULL,
phone_details_id bigint(20) NOT NULL,
created_by varchar(10) NOT NULL,
created_date date NOT NULL,
modified_by varchar(10) NOT NULL,
modified_date date NOT NULL,
active int(1) DEFAULT 1,
foreign key(phone_details_id) references phone_details(id)
);

-- Customer table
CREATE TABLE customer(
id bigint(20) Primary key NOT NULL,
version int(10) NOT NULL,
customer_number varchar (25) unique NOT NULL,
last_order_date date NOT NULL,
person_id  bigint(20),
company_id  bigint(20),
created_by varchar(10) NOT NULL,
created_date date NOT NULL,
modified_by varchar(10) NOT NULL,
modified_date date NOT NULL,
active int(1) DEFAULT 1,
foreign key(person_id) references person(id),
foreign key(company_id) references company(id)
);

-- Supplier table
CREATE TABLE supplier(
id bigint(20) Primary key NOT NULL,
version int(10) NOT NULL,
tax_number varchar (25) unique  NOT NULL,
order_lead_days int(5) NOT NULL,
person_id  bigint(20),
company_id  bigint(20),
created_by varchar(10) NOT NULL,
created_date date NOT NULL,
modified_by varchar(10) NOT NULL,
modified_date date NOT NULL,
active int(1) DEFAULT 1,
foreign key(person_id) references person(id),
foreign key(company_id) references company(id)
);

-- Note - If other trigger not loaded at the time of complete script 
-- then need to execute manually as problem with DELIMITER before execute the trigger in workbench
-- Need to find out 
-- TODO
 
DELIMITER //
CREATE TRIGGER InsertFieldCustNotNull BEFORE INSERT ON customer
FOR EACH ROW 
	BEGIN
  IF (NEW.person_id IS NULL AND NEW.company_id IS NULL) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Person or Company cannot both null';
  elseif (NEW.person_id IS NOT NULL AND NEW.company_id IS NOT NULL) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Person and Company cannot exist at a time';
  END IF;
END;

DELIMITER //
CREATE TRIGGER UpdateFieldCustNotNull BEFORE UPDATE ON customer
FOR EACH ROW 
	BEGIN
  IF (NEW.person_id IS NULL AND NEW.company_id IS NULL) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Person or Company cannot both null';
  elseif (NEW.person_id IS NOT NULL AND NEW.company_id IS NOT NULL) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Person and Company cannot exist at a time';
  END IF;
END;

DELIMITER //
CREATE TRIGGER InsertFieldSupplierNotNull BEFORE INSERT ON supplier
FOR EACH ROW 
	BEGIN
  IF (NEW.person_id IS NULL AND NEW.company_id IS NULL) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Person or Company cannot both null';
  elseif (NEW.person_id IS NOT NULL AND NEW.company_id IS NOT NULL) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Person and Company cannot exist at a time';
  END IF;
END;

DELIMITER //
CREATE TRIGGER UpdateFieldSupplierNotNull BEFORE UPDATE ON supplier
FOR EACH ROW 
	BEGIN
  IF (NEW.person_id IS NULL AND NEW.company_id IS NULL) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Person or Company cannot both null';
  elseif (NEW.person_id IS NOT NULL AND NEW.company_id IS NOT NULL) THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Person and Company cannot exist at a time';
  END IF;
END;
