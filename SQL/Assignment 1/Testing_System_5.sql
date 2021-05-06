USE TestingSystem;
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW vw_DSVN_Sale AS	
	SELECT 		a.*
    FROM 		`Account` a
    INNER JOIN	Department d
    ON			a.DepartmentID = d.DepartmentID
    WHERE		d.DepartmentName = 'Sale';
    
SELECT * FROM vw_DSVN_Sale;
    
-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW vw_Max_GroupAccount AS
	WITH CTE_count_GroupAccount AS (
		SELECT 		count(ga.GroupID) AS SL FROM GroupAccount ga
		GROUP BY	ga.AccountID
	)
	SELECT 		a.*
	FROM		`Account` a
	INNER JOIN	GroupAccount ga
	ON 			a.AccountID = ga.AccountID
    GROUP BY  	ga.AccountID
	HAVING		count(ga.AccountID) = (SELECT MAX(SL) FROM CTE_count_GroupAccount);

SELECT * FROM vw_Max_GroupAccount;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW vw_Question_Content AS 
	SELECT * FROM Question q
	WHERE 	length(q.Content) > 35;
SELECT * FROM vw_Question_Content;
DELETE FROM vw_Question_Content;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW vw_most_Account
AS
	WITH CTE_count_Account_DepartmentID AS(
	SELECT 		count(a.AccountID) AS SL
	FROM 		`Account` a
	INNER JOIN	Department d
	ON 			a.DepartmentID = d.DepartmentID
	GROUP BY 	a.DepartmentID
	)

	SELECT 		d.DepartmentName, count(a.AccountID) AS SL
	FROM 		Department d
	INNER JOIN	`Account` a
	ON			d.DepartmentID = a.DepartmentID
	GROUP BY 	d.DepartmentID
	HAVING		count(a.AccountID) = (SELECT MAX(SL) FROM CTE_count_Account_DepartmentID);
SELECT * FROM vw_most_Account;
 
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW vw_Question_Nguyen
AS
	SELECT 		q.Content, a.FullName 
    FROM		`Account` a
    RIGHT JOIN	Question q
    ON			a.AccountID = q.CreatorID
    WHERE		(SUBSTRING_INDEX(a.FullName,' ', 1)) LIKE 'Nguyen%' ;
SELECT * FROM vw_Question_Nguyen;


-- expand --
DROP PROCEDURE IF EXISTS proc_Find_DepartmentID;
DELIMITER $$
	CREATE	PROCEDURE proc_Find_DepartmentID (IN In_DepartmentID tinyint, OUT out_DepartmentName varchar(30))
	BEGIN	
		SELECT 		d.DepartmentName INTO out_DepartmentName
        FROM 		Department d
        WHERE 		d.DepartmentID = In_DepartmentID;
    END$$
DELIMITER 

SET @Dep_Name ='';

CALL proc_Find_DepartmentID(1,@Dep_Name);

SELECT  @Dep_Name;












