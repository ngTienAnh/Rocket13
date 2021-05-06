-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS proc_List_DepartmentName_Account;
DELIMITER $$
	CREATE	PROCEDURE proc_List_DepartmentName_Account (IN In_DepartmentName VARCHAR(30))
	BEGIN	
		SELECT 		a.*, d.DepartmentName
        FROM 		Department d
        INNER JOIN	`Account` a
        ON 			d.DepartmentID = a.DepartmentID
        WHERE		d.DepartmentName = In_DepartmentName;
    END$$
DELIMITER 
CALL proc_List_DepartmentName_Account('Sale');


-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS proc_Count_GroupAccount;
DELIMITER $$
	CREATE	PROCEDURE proc_Count_GroupAccount ()
	BEGIN	
		SELECT 		g.GroupName, count(ga.AccountID)
        FROM 		groupaccount ga
        INNER JOIN	`Account` a
        ON 			a.AccountID = ga.AccountID
        INNER JOIN	`Group` g
        ON			g.GroupID = ga.GroupID
        GROUP BY	ga.GroupID;
    END$$
DELIMITER 
CALL proc_Count_GroupAccount();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại

DROP PROCEDURE IF EXISTS proc_Count_typequestion;
DELIMITER $$ 
	CREATE	PROCEDURE proc_Count_typequestion ()
	BEGIN	
    WITH 	CTE_Question_this_mounth AS (
		SELECT 		*
		FROM 		Question q
		HAVING		MONTH( q.CreateDate) = MONTH(NOW())
	)
		SELECT 		Content , count(QuestionID), CreateDate
        FROM 		CTE_Question_this_mounth; 
    END$$
DELIMITER 
CALL proc_Count_typequestion();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS proc_Max_typequestion;
DELIMITER $$ 
	CREATE	PROCEDURE proc_Max_typequestion (OUT out_Max_typeq TINYINT)
	BEGIN	
		WITH 	CTE_Max_typequestion AS (
			SELECT 		count(q.TypeID) AS SL
			FROM 		Question q
			GROUP BY	q.TypeID
		)
		SELECT 		TypeID INTO out_Max_typeq
        FROM 		Question q
        GROUP BY	q.TypeID
        HAVING		count(q.QuestionID) = (SELECT Max(SL) FROM CTE_Max_typequestion);
    END$$
DELIMITER 

SET @out_Max_typeq = 0;
CALL proc_Max_typequestion(@out_Max_typeq);
SELECT @out_Max_typeq;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS proc_Find_Max_typequestionName;
DELIMITER $$ 
	CREATE	PROCEDURE proc_Find_Max_typequestionName ()
	BEGIN	
			SET @out_Max_typeq = 0;
			CALL proc_Max_typequestion(@out_Max_typeq);
			SELECT 		*
			FROM 		TypeQuestion tq
			WHERE		tq.TypeID = @out_Max_typeq;
    END$$
DELIMITER 
CALL proc_Find_Max_typequestionName;

-- Qestion 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS proc_Find_Max_Group_Account;
DELIMITER $$ 
	CREATE	PROCEDURE proc_Find_Max_Group_Account (IN in_Char VARCHAR(30))
	BEGIN	
			SELECT 		*
			FROM		`Group` g
			WHERE		g.GroupName like in_Char
			UNION
			SELECT 		*
			FROM		`Account` a
			WHERE		a.FullName like in_Char;
    END$$
DELIMITER 
CALL proc_Find_Max_Group_Account;

/* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ
Sau đó in ra kết quả tạo thành công */
INSERT INTO Department(DepartmentName)
VALUE 		
			(N'Phòng chờ');
DROP PROCEDURE IF EXISTS proc_Insert_Account;
DELIMITER $$ 
	CREATE PROCEDURE proc_Insert_Account(IN in_FullName varchar(30), IN  in_Email varchar(30))
	BEGIN	
				INSERT INTO 	`Account`(Email, 		Username,		FullName,		DepartmentID,		PositionID)
				VALUE 				 	 (in_Email,		SUBSTRING_INDEX(in_Email, '@', 1),in_FullName,11,			8);
                SELECT 			* 
                FROM 			`Account` a 
                WHERE 			a.Email = in_Email;
    END$$
DELIMITER 
CALL proc_Insert_Account('Nguyễn Thanh Tùng A','ngthanhtunga@gmail.com');

/* Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất */

/*DROP PROCEDURE IF EXISTS proc_Max_TypeQuestion;
DELIMITER $$ 
	CREATE PROCEDURE proc_Max_TypeQuestion()
	BEGIN	
		
    END$$
DELIMITER 
CALL proc_Max_TypeQuestion();*/

DROP PROCEDURE IF EXISTS proc_Max_TypeQuestion;
DELIMITER $$ 
	CREATE PROCEDURE proc_Max_TypeQuestion(IN WhatType varchar(16))
	BEGIN	
		IF	WhatType like 'Essay' THEN
			SELECT 	q.Content, MAX(LENGTH(q.Content))
			FROM	Question q
            WHERE		q.TypeID = 1;
		ELSE IF	WhatType like 'Multiple-Choice' THEN
			SELECT 	q.Content, MAX(LENGTH(q.Content))
			FROM	Question q
            WHERE		q.TypeID = 2;
		END IF;
    END IF;
END$$
DELIMITER 
CALL proc_Max_TypeQuestion('Essay');

/*Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID*/
DROP PROCEDURE IF EXISTS proc_Delete_ExamID;
DELIMITER $$ 
	CREATE PROCEDURE proc_Delete_ExamID(IN in_ExamID tinyint)
	BEGIN	
		DELETE FROM EXAM 
        WHERE 		ExamID = in_ExamID;
        SELECT 		*
        FROM		Exam;
	END$$
DELIMITER 
CALL proc_Delete_ExamID(11);










