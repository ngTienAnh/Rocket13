USE TestingSystem;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 		a.AccountID, a.FullName, d.DepartmentName
FROM 		`Account` a INNER JOIN department d
ON 			a.DepartmentID = d.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT 		*
FROM 		`Account` a
WHERE		date(a.CreateDate) > ('2010/12/20');

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT 		a.AccountID, a.FullName, p.PositionName
FROM 		`Account` a INNER JOIN Position p
ON 			a.PositionID = p.PositionID
WHERE 		p.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >2 nhân viên
SELECT 		d.DepartmentName AS 'Tên phòng', count(a.DepartmentID) AS 'Sô lượng nhân viên'
FROM 		`Account` a INNER JOIN department d
ON			a.DepartmentID = d.DepartmentID
GROUP BY	a.DepartmentID
HAVING		count(a.DepartmentID) > 2;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 		q.Content AS 'Câu hỏi', count(eq.QuestionID) AS 'Số lần sử dụng'
FROM 		ExamQuestion eq
INNER JOIN 	Question q 
ON			q.QuestionID = eq.QuestionID
GROUP BY	eq.QuestionID
HAVING		count(eq.QuestionID) = (
				SELECT MAX(Total) 
				FROM (
					SELECT 	COUNT(eq.QuestionID) AS Total 
					FROM 	ExamQuestion eq
					GROUP BY ExamID
				)AS Results
			);
-- SELECT MAX(Total) FROM (SELECT COUNT(*) AS Total FROM emp1 GROUP BY name) AS Results
-- SELECT COUNT(name) FROM emp1 GROUP BY name ORDER BY COUNT(name) DESC LIMIT 1

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT 		cq.CategoryName AS 'Tên Category', count(q.CategoryID) AS 'Số lần sử dụng'
FROM 		Question q
INNER JOIN	CategoryQuestion cq
ON			q.CategoryID = cq.CategoryID
GROUP BY	q.CategoryID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT 		q.Content AS 'Câu hỏi', count(q.QuestionID) AS 'Số lần sử dụng'
FROM		ExamQuestion eq
INNER JOIN	Question q
ON 			eq.QuestionID = q.QuestionID
GROUP BY	q.QuestionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT 		q.Content AS 'Câu hỏi', count(a.AnswerID) AS 'Số lượng câu trả lời'
FROM		Answer a
INNER JOIN	Question q
ON 			a.QuestionID = q.QuestionID
GROUP BY	a.QuestionID
HAVING		count(a.AnswerID) = (
			SELECT 	MAX(Total)
			FROM 	(
					SELECT 		count(QuestionID) AS Total
					FROM		Answer 
                    GROUP BY	QuestionID
					) 
			AS Results
			);

	
			








