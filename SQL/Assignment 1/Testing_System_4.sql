USE TestingSystem;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 		a.AccountID, a.FullName, d.DepartmentName
FROM 		`Account` a INNER JOIN department d
ON 			a.DepartmentID = d.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các Account được tạo sau ngày 20/12/2010
SELECT 		*
FROM 		`Account` a
WHERE		date(a.CreateDate) > ('2010/12/20');

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT 		a.AccountID, a.FullName, p.PositionName
FROM 		`Account` a INNER JOIN Position p
ON 			a.PositionID = p.PositionID
WHERE 		p.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >2 nhân viên
SELECT 		d.DepartmentName AS 'Tên phòng', COUNT(a.DepartmentID) AS 'Sô lượng nhân viên'
FROM 		`Account` a INNER JOIN department d
ON			a.DepartmentID = d.DepartmentID
GROUP BY	a.DepartmentID
HAVING		COUNT(a.DepartmentID) > 2;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 		q.Content AS 'Câu hỏi', COUNT(eq.QuestionID) AS 'Số lần sử dụng'
FROM 		ExamQuestion eq
INNER JOIN 	Question q 
ON			q.QuestionID = eq.QuestionID
GROUP BY	eq.QuestionID
HAVING		COUNT(eq.QuestionID) = (
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
SELECT 		cq.CategoryName AS 'Tên Category', COUNT(q.CategoryID) AS 'Số lần sử dụng'
FROM 		Question q
INNER JOIN	CategoryQuestion cq
ON			q.CategoryID = cq.CategoryID
GROUP BY	q.CategoryID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT 		q.Content AS 'Câu hỏi', COUNT(q.QuestionID) AS 'Số lần sử dụng'
FROM		ExamQuestion eq
INNER JOIN	Question q
ON 			eq.QuestionID = q.QuestionID
GROUP BY	q.QuestionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT 		q.Content AS 'Câu hỏi', COUNT(a.AnswerID) AS 'Số lượng câu trả lời'
FROM		Answer a
INNER JOIN	Question q
ON 			a.QuestionID = q.QuestionID
GROUP BY	a.QuestionID
HAVING		COUNT(a.AnswerID) = (
			SELECT 	MAX(Total)
			FROM 	(
					SELECT 		COUNT(QuestionID) AS Total
					FROM		Answer 
                    GROUP BY	QuestionID
					) 
			AS Results
			);
	
-- Question 9: Thống kê số lượng Account trong mỗi group
SELECT 		g.GroupName AS 'Tên Group', COUNT(ga.GroupID) AS 'Số lượng tài khoản'
FROM		`Group` g
INNER JOIN	GroupAccount ga
ON 			ga.GroupID = g.GroupID
GROUP BY	ga.GroupID;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT 		PositionName AS 'Chức vụ ít người nhất', COUNT(a.PositionID) AS 'Số lượng nhân viên'
FROM		`Account` a
INNER JOIN	Position p 
ON 			p.PositionID = a.PositionID
GROUP BY	p.PositionName
HAVING		COUNT(a.AccountID)  = (
				SELECT 	MIN(Total)
                FROM 	(
						SELECT 		count(a.PositionID) 
						AS			Total
						FROM		`Account` a
						GROUP BY	a.PositionID
				)AS Results
			);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 		d.DepartmentName, count(a.AccountID) AS 'Số lượng nhân viên'
FROM		`Account` a
INNER JOIN	Department d
ON 			a.DepartmentID = d.DepartmentID
INNER JOIN	Position p
ON 			p.PositionID = a.PositionID
GROUP BY	p.PositionName;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì,
SELECT 		q.Content 			AS 'Câu hỏi', 
			tq.TypeName 		AS 'Loại câu hỏi', 
            cq.CategoryName 	AS 'Lĩnh  vực', 
            ac.FullName 		AS 'Người tạo',
            a.Content 			AS 'Câu trả lời',
            a.isCorrect 		AS 'Kết quả'
FROM		Question q
INNER JOIN	TypeQuestion tq
ON 			q.TypeID = tq.TypeID
INNER JOIN	CategoryQuestion cq
ON 			q.CategoryID = cq.CategoryID
INNER JOIN	Answer a
ON 			a.QuestionID = q.QuestionID
INNER JOIN	`Account` ac
ON 			ac.AccountID = q.CreatorID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 		tq.TypeName AS 'Thể loại', COUNT(q.QuestionID) AS 'Số lượng câu trả lời'
FROM		Question q
INNER JOIN	TypeQuestion tq
ON 			q.TypeID = tq.TypeID
GROUP BY	tq.TypeName;

-- Question 14:Lấy ra group không có account nào
SELECT 		g.GroupName AS 'Group không có thành viên',count(ga.AccountID) AS 'Số lượng thành viên'
FROM		`Group` g
LEFT JOIN	GroupAccount ga
ON 			g.GroupID = ga.GroupID
GROUP BY	g.GroupName
HAVING		count(ga.AccountID) = 0;

-- Question 15:Lấy ra group không có account nào
SELECT 		g.GroupName AS 'Group không có thành viên',count(ga.AccountID) AS 'Số lượng thành viên'
FROM		`Group` g
LEFT JOIN	GroupAccount ga
ON 			g.GroupID = ga.GroupID
GROUP BY	g.GroupName
HAVING		count(ga.AccountID) = 0;

-- Question 16: Lấy ra question không có answer nào
SELECT 		q.Content AS 'Câu hỏi không có answ', count(a.AnswerID) AS 'Số lượng câu trả lời'
FROM		Question q
LEFT JOIN	Answer a
ON 			a.QuestionID = q.QuestionID
GROUP BY	q.Content
HAVING		count(a.AnswerID) = 0;
	
			








