/**/
/*Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
trước 1 năm trước*/
DROP TRIGGER IF EXISTS trig_Insert_Group;
DELIMITER $$
CREATE TRIGGER trig_Insert_Group
AFTER DELETE ON `Group`
FOR EACH ROW
BEGIN
	IF YEAR(NEW.CreateDate) - YEAR(now()) > 1 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Năm tạo phải ';
END$$
DELIMITER 
DELETE FROM `Account` WHERE Email = 'ngtienanh199@gmail.com';


/*Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
tin liên quan tới user đó*/

DROP TRIGGER IF EXISTS trig_Delete_Account;
DELIMITER $$
CREATE TRIGGER trig_Delete_Account
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
	IF OLD.Email = 'ngtienanh199@gmail.com' THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Không thể xóa admin';
	END IF;
END$$
DELIMITER ;
DELETE FROM `Account` WHERE Email = 'ngtienanh199@gmail.com';

-- EXTENTS --
CREATE TABLE log_Update_Department (
	DepartmentID 		TINYINT PRIMARY KEY,
    DepartmentName 		NVARCHAR(30),
    CreateDate			DATETIME DEFAULT NOW()
);
DROP TRIGGER IF EXISTS trig_Update_Department;
DELIMITER $$
CREATE TRIGGER trig_Update_Department
AFTER UPDATE ON `Department`
FOR EACH ROW
BEGIN	
	DECLARE DepName varchar(30);
    
    SELECT 		d.DepartmentName 
    INTO 		DepName
    FROM 		Department d
    WHERE		d.DepartmentID = OLD.DepartmentID;

	INSERT INTO log_Update_Department (DepartmentID,	DepartmentName,		CreateDate)
    VALUES							  (OLD.DepartmentID,		DepName,		 NOW());
END$$
DELIMITER ;
-- ??
CREATE TABLE testingsystem.`log_dep_name_acc` (
 Id INT AUTO_INCREMENT,
  UserName VARCHAR(45) NOT NULL,
 OldDepName VARCHAR(50) NOT NULL,
  ChageDate DATETIME NOT NULL,
  PRIMARY KEY (Id));

DROP TRIGGER IF EXISTS Trg_AfUpdateAcc;
DELIMITER $$
	CREATE TRIGGER Trg_AfUpdateAcc
    AFTER UPDATE ON account
    FOR EACH ROW
    BEGIN		
		DECLARE DepName VARCHAR(50);         
        SELECT d.DepartmentName INTO DepName FROM department d WHERE d.DepartmentID = OLD.DepartmentID;        
		INSERT INTO log_dep_name_acc (UserName, OldDepName, ChageDate) VALUES (OLD.UserName, DepName, now());  
    END$$
DELIMITER ;

UPDATE account SET DepartmentID = '5' WHERE (AccountID = '1');
