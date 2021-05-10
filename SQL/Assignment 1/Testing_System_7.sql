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
		SET MESSAGE_TEXT = 'Năm tạo phải trong năm nay';
	END IF;
END$$
DELIMITER 
DELETE FROM `Account` WHERE Email = 'ngtienanh199@gmail.com';

/*uestion 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
"Sale" cannot add more user"*/
		-- INSERT --
DROP TRIGGER IF EXISTS trig_NoMoreUser_Sal_Insert;
DELIMITER $$
CREATE TRIGGER trig_NoMoreUser_Sal_Insert
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
	IF NEW.DepartmentID = (
				SELECT 	DepartmentID AS DepID
				FROM		Department
				WHERE 		DepartmentName = 'Sale') 
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
	END IF;
END$$
DELIMITER 
			-- UPDATE -- 
DROP TRIGGER IF EXISTS trig_NoMoreUser_Sale_Update;
DELIMITER $$
CREATE TRIGGER trig_NoMoreUser_Sale_Update
BEFORE UPDATE ON `Account`
FOR EACH ROW
BEGIN
	IF NEW.DepartmentID = (
				SELECT 	DepartmentID AS DepID
				FROM		Department
				WHERE 		DepartmentName = 'Sale') 
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
	END IF;
END$$
DELIMITER 

INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID)
VALUE 		
			(N'ngtienanh1999@gmail.com',N'banhlung1',N'Nguyễn Anh Nga',2,2);

/*Question 3: Cấu hình 1 group có nhiều nhất là 5 user*/
		-- INSERT --
DROP TRIGGER IF EXISTS trig_NoMoreThan5User_Group_Insert;
DELIMITER $$
CREATE TRIGGER trig_NoMoreThan5User_Group_Insert
AFTER INSERT ON `Groupaccount`
FOR EACH ROW
BEGIN
	IF (
    SELECT 	tb_AG.SL
	FROM (
		SELECT 		GroupID, count(AccountID) AS SL
		FROM		GroupAccount
		GROUP BY	GroupID
	) AS tb_AG
	WHERE tb_AG.GroupID = NEW.GroupID
    ) > 5
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = '1 group có nhiều nhất là 5 user';
	END IF;
END$$
DELIMITER;
		-- UPDATE --
DROP TRIGGER IF EXISTS trig_NoMoreThan5User_Group_Update;
DELIMITER $$
CREATE TRIGGER trig_NoMoreThan5User_Group_Update
AFTER UPDATE ON `Groupaccount`
FOR EACH ROW
BEGIN
	IF (
    SELECT 	tb_AG.SL
	FROM (
		SELECT 		GroupID, count(AccountID) AS SL
		FROM		GroupAccount
		GROUP BY	GroupID
	) AS tb_AG
	WHERE tb_AG.GroupID = NEW.GroupID
    ) > 5
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = '1 group có nhiều nhất là 5 user';
	END IF;
END$$
DELIMITER ;

INSERT INTO `GroupAccount`(GroupID,AccountID)
VALUE 		
			(1,1);          
            
-- ====== --
/*Question 4: Cấu hình 1 bài thi có nhiều nhất là 3 Question*/
		-- INSERT --
DROP TRIGGER IF EXISTS trig_NoMoreThan5Question_ExamQuestion_Insert;
DELIMITER $$
CREATE TRIGGER trig_NoMoreThan5Question_ExamQuestion_Insert
AFTER INSERT ON `ExamQuestion`
FOR EACH ROW
BEGIN
	IF (
    SELECT 	tb_EQ.SL
	FROM (
		SELECT 		ExamID, count(QuestionID) AS SL
		FROM		ExamQuestion
		GROUP BY	ExamID
	) AS tb_EQ
	WHERE tb_EQ.ExamID = NEW.ExamID
    ) > 3
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = '1 bài thi có nhiều nhất là 3 Question';
	END IF;
END$$
DELIMITER ;

		-- UPDATE --
DROP TRIGGER IF EXISTS trig_NoMoreThan5Question_ExamQuestion_Insert;
DELIMITER $$
CREATE TRIGGER trig_NoMoreThan5Question_ExamQuestion_Insert
AFTER UPDATE ON `ExamQuestion`
FOR EACH ROW
BEGIN
	IF (
    SELECT 	tb_EQ.SL
	FROM (
		SELECT 		ExamID, count(QuestionID) AS SL
		FROM		ExamQuestion
		GROUP BY	ExamID
	) AS tb_EQ
	WHERE tb_EQ.ExamID = NEW.ExamID
    ) > 3
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = '1 bài thi có nhiều nhất là 3 Question';
	END IF;
END$$
DELIMITER ;

INSERT INTO `ExamQuestion`(ExamID,QuestionID)
VALUE 		
		(1,3);

UPDATE `ExamQuestion` SET ExamID = '1' WHERE (ExamID = '3');
-- ====== --


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


/*Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
vào departmentID thì sẽ được phân vào phòng ban "waiting Department"*/

DROP TRIGGER IF EXISTS trig_Insert_nonDepartmentID_Account;
DELIMITER $$
CREATE TRIGGER trig_Insert_nonDepartmentID_Account
AFTER INSERT ON `Account`
FOR EACH ROW
BEGIN
	IF NEW.DepartmentID = NULL THEN
		-- NEW.DepartmentID = (SELECT DepartmentID FROM Department WHERE DepartmentName = "Phòng chờ");
        UPDATE 	`Account` a
		SET 	DepartmentID = (SELECT DepartmentID FROM Department WHERE DepartmentName = "Phòng chờ")
		WHERE 	a.AccountID = NEW.AccountID;
	END IF;
END$$
DELIMITER ;

INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID)
VALUE 		
			(N'ngtienanh187@gmail.com',N'kakatiti',N'Nguyễn Hùng Mỹ',null,2);

/*Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 3 answers cho mỗi
question, trong đó có tối đa 2 đáp án đúng.*/

DROP TRIGGER IF EXISTS trig_Max4Ans_2correc;
DELIMITER $$
CREATE TRIGGER trig_Max4Ans_2correc
AFTER INSERT ON `Answer`
FOR EACH ROW
BEGIN
	IF (
    SELECT 	tb_AW.SL
	FROM (
			SELECT 		QuestionID, count(aw.AnswerID) AS SL
			FROM		Answer aw
			GROUP BY 	aw.QuestionID
	) AS tb_AW
	WHERE tb_AW.QuestionID = NEW.QuestionID
    ) > 3
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = '1 question có nhiều nhất là 3 answers';
	ELSE IF (
		SELECT 	tb_AW.SL
		FROM (
			SELECT 		QuestionID, count(aw.AnswerID) AS SL
			FROM		Answer aw
            WHERE		isCorrect = 'Đúng'
			GROUP BY 	aw.QuestionID
		) AS tb_AW
		WHERE	tb_AW.QuestionID =  NEW.QuestionID
    ) > 2
	THEN 
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'chỉ có tối đa 2 câu trả lời đúng';
    END IF;
    END IF;
END$$
DELIMITER ;

INSERT INTO `Answer`(Content,QuestionID,isCorrect)
VALUE 		
			(N'oke nhé',1,N'Đúng');


/*Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày*/
DROP TRIGGER IF EXISTS trig_Delete_2dateEarly;
DELIMITER $$
CREATE TRIGGER trig_Delete_2dateEarly
BEFORE DELETE ON `Exam`
FOR EACH ROW
BEGIN
	IF (NOW() - OLD.CreateDate ) >= 2 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'không cho phép người dùng xóa bài thi mới tạo được 2 ngày';
	END IF;
END$$
DELIMITER ;

DELETE FROM Exam WHERE ExamID = '1';

/*Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
question khi question đó chưa nằm trong exam nào*/
		
        -- INSERT --
DROP TRIGGER IF EXISTS trig_Delete_nonExamInQuestion;
DELIMITER $$
CREATE TRIGGER trig_Delete_nonExamInQuestion
BEFORE DELETE ON `Question` 
FOR EACH ROW
BEGIN
	DECLARE OLD_QuestionID tinyint;
    SELECT 	tb_QE.SL INTO OLD_QuestionID
		 FROM (
			SELECT 		q.QuestionID,count(eq.ExamID) AS SL
			FROM		Question q
			LEFT JOIN	ExamQuestion eq
			ON			q.QuestionID = eq.QuestionID
			GROUP BY	q.QuestionID
         ) AS tb_QE
	WHERE 	OLD.QuestionID = tb_QE.QuestionID;
    
	IF OLD_QuestionID != 0 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'không được delete khi question đã có trong exam';
	END IF;
END$$
DELIMITER ;

		-- UPDATE --
DROP TRIGGER IF EXISTS trig_Update_nonExamInQuestion;
DELIMITER $$
CREATE TRIGGER trig_Update_nonExamInQuestion
BEFORE Update ON `Question` 
FOR EACH ROW
BEGIN
	DECLARE OLD_QuestionID tinyint;
    SELECT 	tb_QE.SL INTO OLD_QuestionID
		 FROM (
			SELECT 		q.QuestionID,count(eq.ExamID) AS SL
			FROM		Question q
			LEFT JOIN	ExamQuestion eq
			ON			q.QuestionID = eq.QuestionID
			GROUP BY	q.QuestionID
         ) AS tb_QE
	WHERE 	OLD.QuestionID = tb_QE.QuestionID;
    
	IF OLD_QuestionID != 0 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'không được update khi question đã có trong exam';
	END IF;
END$$
DELIMITER ;        
        
DELETE FROM Question q WHERE q.QuestionID = 1;
UPDATE Question SET QuestionID = 2 WHERE QuestionID = 1;

/*Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
không có user thì sẽ thay đổi giá trị 0 thành "Không có User"*/

DROP PROCEDURE IF EXISTS proc_List_userDep;
DELIMITER $$
	CREATE	PROCEDURE proc_List_userDep ()
	BEGIN
    SELECT * FROM (
		SELECT 		d.DepartmentName, count(a.AccountID) AS SL
		FROM		`Account` a
		RIGHT JOIN	Department d
		ON			a.DepartmentID = d.DepartmentID
		GROUP BY	d.DepartmentName
	) AS tb_DEP;
        IF tb_DEP.SL = 0 THEN
			UPDATE 	tb_DEP
            SET		SL = 'Không có User' 
            WHERE	SL = 0;
		END IF;
    END$$
DELIMITER;
CALL proc_List_userDep();









-- ==========EXTENTS============ --
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
