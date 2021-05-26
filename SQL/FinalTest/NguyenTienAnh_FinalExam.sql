-- tạo database
DROP DATABASE IF EXISTS  FinalExam;
CREATE DATABASE IF NOT EXISTS FinalExam;
USE FinalExam;

-- tạo bảng Student
DROP TABLE IF EXISTS  Student;
CREATE TABLE Student (
	ID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`		NVARCHAR(30) NOT NULL,
    Age 		TINYINT NOT NULL,
    Gender		ENUM ("Nam","Nữ")
);

-- tạo bảng Subject
DROP TABLE IF EXISTS  `Subject`;
CREATE TABLE `Subject` (
	ID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` 		NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- tạo bảng StudentSubject
DROP TABLE IF EXISTS  StudentSubject;
CREATE TABLE StudentSubject (
	StudentID 		TINYINT UNSIGNED NOT NULL,
    SubjectID 		TINYINT UNSIGNED NOT NULL,
    Mark			FLOAT UNSIGNED,
    `Date`			DATE,
    CONSTRAINT Pk_StudentSubject_Student_Subject PRIMARY KEY (StudentID,SubjectID),
    CONSTRAINT fk_StudentSubject_StudentID FOREIGN KEY(StudentID) REFERENCES Student(ID),
    CONSTRAINT fk_StudentSubject_SubjectID FOREIGN KEY(SubjectID) REFERENCES `Subject`(ID)
);

-- INSERT dữ liệu vào bảng Student
INSERT INTO Student(		`Name`,		Age,	Gender)
VALUE 				(	"Student1",		17,		 "Nam"),
					(	"Student2",		15,		"Nữ"),
					(	"Student3",		19,		"Nam"),
					(	"Student4",		20,		"Nữ"),
					(	"Student5",		22,		"Nam");
			
            
-- INSERT dữ liệu vào bảng Subject      
INSERT INTO `Subject`(	`Name`	)
VALUE 				("Subject1"),
					("Subject2"),
					("Subject3"),
					("Subject4"),
					("Subject5");
					

-- INSERT dữ liệu vào bảng StudentSubject
INSERT INTO `StudentSubject`(StudentID,		SubjectID,		Mark,			`Date`)
VALUE 						(		  1,			5,			6,		"2020-03-12"),
							(		  2,			5,			6,		"2019-02-14"),
							(		  3,			2,			6,		"2020-03-22"),
							(		  4,			4,			6,		"2020-06-25"),
							(		  5,			4,			6,		"2020-12-12");
							

-- 2) a) Lấy tất cả các môn học không có bất kì điểm nào
SELECT			sj.ID, sj.`Name`
FROM			`Subject` sj
LEFT JOIN		`StudentSubject` ss
ON				sj.ID = ss.SubjectID
WHERE 			ss.SubjectID IS NULL;

-- 2) b) Lấy danh sách các môn học có ít nhất 2 điểm
SELECT			sj.ID, sj.`Name`
FROM			`Subject` sj
INNER JOIN		(	SELECT 	SubjectID, COUNT(ss.StudentID)
					FROM		`StudentSubject` ss
					GROUP BY	ss.SubjectID
					HAVING		COUNT(ss.StudentID) >= 2
				) AS tb
ON				sj.ID = tb.SubjectID;

/*3) Tạo view có tên là "StudentInfo" lấy các thông tin về học sinh bao gồm:
Student ID,Subject ID, Student Name, Student Age, Student Gender,
Subject Name, Mark, Date
(Với cột Gender show 'Male' để thay thế cho 0, 'Female' thay thế cho 1 và
'Unknow' thay thế cho null)*/

CREATE OR REPLACE VIEW StudentInfo
AS	
	SELECT 			ss.StudentID, ss.SubjectID, st.`Name` AS 'Tên Student', st.Age, 
					CASE WHEN	st.Gender = "Nam" THEN "Male"
						 WHEN	st.Gender = "Nữ"  THEN "Female"
                         ELSE	"Unknow" 
                         END AS Gender, sj.`Name` AS 'Tên Subject', ss.Mark, ss.`Date`
    FROM 			Studentsubject ss
    INNER JOIN		Student st  
    ON				ss.StudentID = st.ID
    INNER JOIN		`Subject` sj	
    ON 				sj.ID = ss.SubjectID;
    
SELECT * FROM StudentInfo;


/*4. Không sử dụng On Update Cascade & On Delete Cascade
a) Tạo trigger cho table Subject có tên là SubjectUpdateID:
Khi thay đổi data của cột ID của table Subject, thì giá trị tương
ứng với cột SubjectID của table StudentSubject cũng thay đổi
theo*/
DROP TRIGGER IF EXISTS SubjectUpdateID;
DELIMITER $$
CREATE TRIGGER SubjectUpdateID
AFTER UPDATE ON Subject
FOR EACH ROW
BEGIN    
	IF NEW.ID != OLD.ID THEN
		UPDATE 		Studentsubject
		SET 		SubjectID 	= 	NEW.ID
		WHERE 		SubjectID = OLD.ID;
	END IF;
END$$
DELIMITER ;

UPDATE 		`Subject`
SET 		ID 	= 	7
WHERE 		ID = 2;


/*b) Tạo trigger cho table Student có tên là StudentDeleteID:
Khi xóa data của cột ID của table Student, thì giá trị tương ứng với
cột SubjectID của table StudentSubject cũng bị xóa theo*/
DROP TRIGGER IF EXISTS StudentDeleteID;
DELIMITER $$
CREATE TRIGGER StudentDeleteID
AFTER UPDATE ON Student
FOR EACH ROW
BEGIN    
	IF NEW.ID = NULL THEN
		UPDATE 	studentsubject
		SET 	StudentID = NULL
		WHERE	OLD.ID = StudentID;
	END IF;
END$$
DELIMITER ;

/*5. Viết 1 store procedure (có 2 parameters: student name) sẽ xóa tất cả các
thông tin liên quan tới học sinh có cùng tên như parameter
Trong trường hợp nhập vào student name = "*" thì procedure sẽ xóa tất cả
các học sinh*/

DROP PROCEDURE IF EXISTS proc_DeleteStudenByName;
DELIMITER $$ 
	CREATE PROCEDURE proc_DeleteStudenByName(IN StudentName NVARCHAR(30))
	BEGIN
		IF StudentName = "*"  THEN
			DELETE  FROM 	Student;
            DELETE 	FROM	Studentsubject;
		ELSE IF StudentName != NULL THEN
			DELETE FROM 	Student st
            WHERE			st.`Name` = StudentName;
			DELETE FROM 	Studentsubject ss
            WHERE 			ss.StudentID = (SELECT 	ID 
											FROM 	Student 
											WHERE 	`Name` = StudentName);
		END IF;
        END IF;
	END$$
DELIMITER ;
CALL proc_DeleteStudenByName('Student1',"");







