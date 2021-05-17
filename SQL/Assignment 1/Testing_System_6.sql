USE TestingSystem;
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
			IF (SELECT 	count(g.GroupID) FROM `Group` g WHERE g.GroupName like CONCAT('%',in_Char,'%')) != 0 THEN
				SELECT 	*
                FROM 	`Group` g 
                WHERE 	g.GroupName 
                like 	CONCAT('%',in_Char,'%');
			END IF;
			IF (SELECT count(a.AccountID) FROM `Account` a WHERE	a.FullName like CONCAT('%',in_Char,'%')) != 0 THEN
				SELECT 	*
                FROM 	`Account` a
                WHERE 	a.UserName
                like 	CONCAT('%',in_Char,'%');
			END IF;
    END$$
DELIMITER 
CALL proc_Find_Max_Group_Account('a');

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

/*Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
dụng store ở câu 9 để xóa)
Sau đó in số lượng record đã remove từ các table liên quan trong khi
removing*/
DROP PROCEDURE IF EXISTS proc_Delete_ExamID;
DELIMITER $$ 
	CREATE PROCEDURE proc_Delete_Exam_3year(IN in_ExamID tinyint)
	BEGIN	
		
	END$$
DELIMITER 
CALL proc_Delete_Exam_3year(11);

DROP PROCEDURE IF EXISTS SP_DeleteExamBefore3Year;
DELIMITER $$
CREATE PROCEDURE SP_DeleteExamBefore3Year()
BEGIN-- Khai báo biến sử dụng trong chương trình
DECLARE v_ExamID TINYINT UNSIGNED;
DECLARE v_CountExam TINYINT UNSIGNED DEFAULT 0;
DECLARE v_CountExamquestion TINYINT UNSIGNED DEFAULT 0;
DECLARE i TINYINT UNSIGNED DEFAULT 1;
DECLARE v_print_Del_info_Exam VARCHAR(50) ;
-- Tạo bảng tạm
DROP TABLE IF EXISTS ExamIDBefore3Year_Temp;
CREATE TABLE ExamIDBefore3Year_Temp(
ID INT PRIMARY KEY AUTO_INCREMENT,
ExamID INT);
-- Insert dữ liệu bảng tạm
INSERT INTO ExamIDBefore3Year_Temp(ExamID)
SELECT e.ExamID FROM exam e WHERE (year(now()) - year(e.CreateDate)) >2;
-- Lấy số lượng số Exam và ExamQuestion cần xóa.
SELECT count(1) INTO v_CountExam FROM ExamIDBefore3Year_Temp;
SELECT count(1) INTO v_CountExamquestion FROM examquestion ex
INNER JOIN ExamIDBefore3Year_Temp et ON ex.ExamID = et.ExamID;
-- Thực hiện xóa trên bảng Exam và ExamQuestion sử dụng Procedure đã tạo ở Question9 bên trên
WHILE (i <= v_CountExam) DO
SELECT ExamID INTO v_ExamID FROM ExamIDBefore3Year_Temp WHERE ID=i;
CALL proc_Delete_ExamID(v_ExamID);
SET i = i +1;
END WHILE;
-- In câu thông báo
SELECT CONCAT("DELETE ",v_CountExam," IN Exam AND ", v_CountExamquestion ," IN ExamQuestion") INTO v_print_Del_info_Exam;
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = v_print_Del_info_Exam ;
-- Xóa bảng tạm sau khi hoàn thành
DROP TABLE IF EXISTS ExamIDBefore3Year_Temp;
END$$
DELIMITER ;
-- Run Procedure
Call SP_DeleteExamBefore3Year;

/*Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
chuyển về phòng ban default là phòng ban chờ việc*/

DROP PROCEDURE IF EXISTS proc_Delete_Department;
DELIMITER $$ 
	CREATE PROCEDURE proc_Delete_Department(IN in_DepartmentName varchar(30))
	BEGIN
		DECLARE 	in_DepartmentID tinyint;
        
        SELECT 		d.DepartmentID INTO in_DepartmentID
        FROM		Department d
        WHERE		d.DepartmentName =in_DepartmentName;
        
		UPDATE		`Account` 
        SET			DepartmentID = 11
        WHERE		DepartmentID = in_DepartmentID;
        
        DELETE FROM department
        WHERE		departmentID = in_DepartmentID;
        
	END$$
DELIMITER 
CALL proc_Delete_Department('Thư ký');

/*Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
nay*/

DROP PROCEDURE IF EXISTS proc_List_Month_Question;
DELIMITER $$
CREATE PROCEDURE proc_List_Month_Question()
BEGIN
	WITH CTE_month AS (
			SELECT 1 AS MONTH
             UNION SELECT 2 AS MONTH
             UNION SELECT 3 AS MONTH
             UNION SELECT 4 AS MONTH
             UNION SELECT 5 AS MONTH
             UNION SELECT 6 AS MONTH
             UNION SELECT 7 AS MONTH
             UNION SELECT 8 AS MONTH
             UNION SELECT 9 AS MONTH
             UNION SELECT 10 AS MONTH
             UNION SELECT 11 AS MONTH
             UNION SELECT 12 AS MONTH
    )
    SELECT 		c.MONTH AS 'Tháng', count(QuestionID) AS 'Số câu hỏi'
    FROM		CTE_month c 
    LEFT JOIN	Question q	
	ON 			month(CreateDate) = c.MONTH
    GROUP BY	`MONTH`
    ORDER BY	`MONTH` DESC;
END$$
DELIMITER ;
CALL proc_List_Month_Question;

/*Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
tháng gần đây nhất
(Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
tháng")*/

DROP PROCEDURE IF EXISTS proc_List_6_Month_Question;
DELIMITER $$
CREATE PROCEDURE proc_List_6_Month_Question()
BEGIN
	WITH CTE_month_table AS (
			 SELECT MONTH(DATE_SUB(NOW(),INTERVAL 1 MONTH )) AS MONTH, YEAR(DATE_SUB(NOW(),INTERVAL 1 MONTH )) AS YEAR
             UNION SELECT MONTH(DATE_SUB(NOW(),INTERVAL 2 MONTH )) AS MONTH, YEAR(DATE_SUB(NOW(),INTERVAL 2 MONTH )) AS YEAR
			 UNION SELECT MONTH(DATE_SUB(NOW(),INTERVAL 3 MONTH )) AS MONTH, YEAR(DATE_SUB(NOW(),INTERVAL 3 MONTH )) AS YEAR
             UNION SELECT MONTH(DATE_SUB(NOW(),INTERVAL 4 MONTH )) AS MONTH, YEAR(DATE_SUB(NOW(),INTERVAL 4 MONTH )) AS YEAR
             UNION SELECT MONTH(DATE_SUB(NOW(),INTERVAL 5 MONTH )) AS MONTH, YEAR(DATE_SUB(NOW(),INTERVAL 5 MONTH )) AS YEAR
             UNION SELECT MONTH(DATE_SUB(NOW(),INTERVAL 6 MONTH )) AS MONTH, YEAR(DATE_SUB(NOW(),INTERVAL 6 MONTH )) AS YEAR
    )
    SELECT 		tb.YEAR AS 'Năm',tb.MONTH AS 'Tháng', CASE 
									WHEN count(q.QuestionID) = 0 THEN 'Không có câu hỏi'
                                    ELSE COUNT(q.QuestionID) END AS SL
    FROM 		CTE_month_table tb
	LEFT JOIN	Question q	
	ON 			MONTH(q.CreateDate) = tb.MONTH
	GROUP BY	`MONTH` 
	ORDER BY 	`MONTH`,`YEAR` ASC;
END$$
DELIMITER ;
CALL proc_List_6_Month_Question;
-- extend --




