USE master ;
GO

-- Check to see if the database already exists, if it does drop it. This is the seed for a new database so 
IF DB_ID('KBSBenefits') IS NOT NULL
	DROP DATABASE KBSBenefits

-- Get the SQL Server data path.
DECLARE @data_path nvarchar(256);
SET @data_path = (SELECT SUBSTRING(physical_name, 1, CHARINDEX(N'master.mdf', LOWER(physical_name)) - 1)
      FROM master.sys.master_files
      WHERE database_id = 1 AND file_id = 1);

-- Using dynamic SQL in order to use the above variable to make a generic path for rerunability on multiple machines.
EXECUTE ('
	CREATE DATABASE KBSBenefits
		CONTAINMENT = NONE
		ON
		PRIMARY 
		( 
			NAME = KBSBenefits
			,FILENAME = ''' + @data_path + 'KBSBenefits.mdf''
			,SIZE = 8192KB
			,MAXSIZE = UNLIMITED
			,FILEGROWTH = 65536KB 
		)
		LOG ON 
		( 
			NAME = KBSBenefits_log
			,FILENAME = ''' + @data_path + 'KBSBenefits_log.ldf''
			,SIZE = 8192KB
			,MAXSIZE = 2048GB 
			,FILEGROWTH = 65536KB 
		)
')
GO

BEGIN TRANSACTION

USE KBSBenefits
GO

-- Create Organization Table
CREATE TABLE organization(
	id bigint IDENTITY(1,1) NOT NULL
	,name nchar(35) NOT NULL
	,created_date datetime NOT NULL DEFAULT GETDATE()
	,updated_date datetime NOT NULL DEFAULT GETDATE()
	,CONSTRAINT PK_organization PRIMARY KEY CLUSTERED (id)
)

INSERT INTO organization (name, created_date, updated_date)
VALUES ('KB Solutions', GETDATE(), GETDATE())

DECLARE @ORG bigint;
SET @ORG = CAST(@@IDENTITY AS bigint);

-- Setusp Discount tables
CREATE TABLE discount_type(
	id bigint IDENTITY(1,1) NOT NULL
	,name varchar(35) NOT NULL
	,organization_id bigint NOT NULL
	,created_date datetime NOT NULL DEFAULT GETDATE()
	,updated_date datetime NOT NULL DEFAULT GETDATE()
	,CONSTRAINT PK_discount_type PRIMARY KEY CLUSTERED (id ASC)
)

INSERT INTO discount_type (name, organization_id, created_date, updated_date)
VALUES ('A_NAMES_ARE_COOL', @ORG, GETDATE(), GETDATE())

CREATE TABLE discount(
	id bigint IDENTITY(1,1) NOT NULL
	,percentage numeric NULL
	,amount smallint NULL
	,discount_type_id bigint NOT NULL
	,organization_id bigint NOT NULL
	,created_date datetime NOT NULL DEFAULT GETDATE()
	,updated_date datetime NOT NULL DEFAULT GETDATE()
	,CONSTRAINT PK_discount PRIMARY KEY CLUSTERED (id ASC)
	,CONSTRAINT FK_discount_discount_type FOREIGN KEY (discount_type_id) REFERENCES discount_type (id)
	,CHECK (amount IS NOT NULL OR percentage IS NOT NULL) -- Either a percentage needs to be supplied or an amount, both don't need to be there though.
)

INSERT INTO discount
	(
		percentage
		,amount
		,discount_type_id
		,organization_id
		,created_date
		,updated_date
	)
VALUES
	(
		10
		,null
		,SCOPE_IDENTITY()
		,@ORG
		, GETDATE()
		, GETDATE()
	)

-- Setup Relationship Types
CREATE TABLE relationship_type(
	id bigint IDENTITY(1,1) NOT NULL
	,relationship_type_name varchar(35) NOT NULL
	,display_name varchar(35) NOT NULL
	,display_order tinyint NOT NULL
	,created_date datetime NOT NULL DEFAULT GETDATE()
	,updated_date datetime NOT NULL DEFAULT GETDATE()
	,CONSTRAINT PK_relationship_type PRIMARY KEY CLUSTERED (id)
)

INSERT INTO relationship_type (relationship_type_name, display_name, display_order, created_date, updated_date)
VALUES
	('EMPLOYEE', 'Employee', 1, GETDATE(), GETDATE())
	,('SPOUSE', 'Spouse', 2, GETDATE(), GETDATE())
	,('CHILD', 'Child', 3, GETDATE(), GETDATE())
	,('PARENT', 'Parent', 4, GETDATE(), GETDATE())
	,('GRANDPARENT', 'Grand Parent', 5, GETDATE(), GETDATE())
	,('OTHER', 'Other', 6, GETDATE(), GETDATE())

-- Create Person table
CREATE TABLE person(
	id bigint IDENTITY(1,1) NOT NULL
	,first_name nchar(65) NOT NULL
	,last_name nchar(65) NOT NULL
	,created_date datetime NOT NULL
	,updated_date datetime NOT NULL
	,CONSTRAINT PK_person PRIMARY KEY CLUSTERED (id)
)


-- Create Relationship Table
CREATE TABLE relationship(
	id bigint IDENTITY(1,1) NOT NULL
	,primary_id bigint NOT NULL
	,secondary_id bigint NOT NULL
	,realtionship_type_id bigint NOT NULL
	,created_date datetime NOT NULL DEFAULT GETDATE()
	,updated_date datetime NOT NULL DEFAULT GETDATE()
	,CONSTRAINT PK_relationship PRIMARY KEY CLUSTERED (id)
	,CONSTRAINT FK_relationship_relationship_type FOREIGN KEY (realtionship_type_id) REFERENCES relationship_type (id)
	,CONSTRAINT FK_relationship_primary_person FOREIGN KEY (primary_id) REFERENCES person (id)
	,CONSTRAINT FK_relationship_secondary_person FOREIGN KEY (secondary_id) REFERENCES person (id)
)

-- Create Benefit Packages
CREATE TABLE benefit_package(
	id bigint IDENTITY(1,1) NOT NULL
	,benefit_package_name varchar(100) NOT NULL
	,employee_cost_per_year money NOT NULL
	,non_employee_cost_per_year money NOT NULL
	,organization_id bigint NOT NULL
	,created_date datetime NOT NULL DEFAULT GETDATE()
	,updated_date datetime NOT NULL DEFAULT GETDATE()
	,CONSTRAINT PK_benefit_package PRIMARY KEY CLUSTERED (id)
)

INSERT INTO benefit_package (
	benefit_package_name
	,employee_cost_per_year
	,non_employee_cost_per_year
	,organization_id
	,created_date
	,updated_date
)
VALUES (
	'KB Solutions Super Awesome Benefits!'
	,1000
	,500
	,@ORG
	,GETDATE()
	,GETDATE()
)

-- Create employee table
CREATE TABLE employee(
	id bigint IDENTITY(1,1) NOT NULL
	,person_id bigint NOT NULL
	,organization_id bigint NOT NULL
	,benefit_package_id bigint NOT NULL
	,salary money NOT NULL
	,pay_frequency tinyint NOT NULL
	,discount_id bigint
	,created_date datetime NOT NULL DEFAULT GETDATE()
	,updated_date datetime NOT NULL DEFAULT GETDATE()
	,CONSTRAINT PK_employee PRIMARY KEY CLUSTERED (id)
	,CONSTRAINT FK_employee_person FOREIGN KEY (person_id) REFERENCES person (id)
	,CONSTRAINT FK_employee_organization FOREIGN KEY (organization_id) REFERENCES organization (id)
	,CONSTRAINT FK_employee_benefit_package FOREIGN KEY (benefit_package_id) REFERENCES benefit_package (id)
	,CONSTRAINT FK_employee_discount FOREIGN KEY (discount_id) REFERENCES discount (id)
)

-- Create dependent table
CREATE TABLE dependent(
	id bigint IDENTITY(1,1) NOT NULL
	,person_id bigint NOT NULL
	,relationship_type_id bigint NOT NULL
	,employee_id bigint NOT NULL
	,discount_id bigint NOT NULL
	,created_date datetime NOT NULL DEFAULT GETDATE()
	,updated_date datetime NOT NULL DEFAULT GETDATE()
	,CONSTRAINT PK_dependent PRIMARY KEY CLUSTERED (id)
	,CONSTRAINT FK_dependent_person FOREIGN KEY (person_id) REFERENCES person (id)
	,CONSTRAINT FK_dependent_employee FOREIGN KEY (employee_id) REFERENCES employee (id)
	,CONSTRAINT FK_dependent_discount FOREIGN KEY (discount_id) REFERENCES discount (id)
	,CONSTRAINT FK_dependent_relationship_type FOREIGN KEY (relationship_type_id) REFERENCES relationship_type (id)
)

COMMIT TRANSACTION