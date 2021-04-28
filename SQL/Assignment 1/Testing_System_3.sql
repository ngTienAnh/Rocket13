-- Question 2: lấy ra tất cả các phòng ban
SELECT 		* 
FROM 		Department;    

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT 		DepartmentID 
AS 			'ID phòng sale' 
FROM 		Department  
WHERE  		DepartmentName = N'Sale';   

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT 		*
FROM 		`Account` a
WHERE		length(a.FullName) = (SELECT MAX(length(FullName)) FROM `Account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT		*
FROM		`Account` a
WHERE		length(a.FullName) = (	SELECT MAX(length(FullName)) 
									FROM `Account` 
                                    WHERE DepartmentID = 3)
AND			DepartmentID = 3
ORDER BY 	Fullname DESC;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT 		*
FROM		`Group` g
WHERE		g.CreateDate < '2019/12/20';

-- Question 7: Lấy ra ID của question có >= 2 câu trả lời
SELECT 		QuestionID
AS			'ID câu hỏi'
FROM 		Answer a
GROUP BY	a.QuestionID
HAVING		COUNT(a.QuestionID) > 2;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT 		a.`Code`
AS			'Mã đề thi'
FROM 		Exam a
WHERE		CreateDate < '2019/12/20'
AND			Duration >= 60;

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT		*
FROM		`Group`
ORDER BY	CreateDate DESC
LIMIT		5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT		DepartmentName AS 'Tên phòng 2', count(a.DepartmentID) AS 'Số nhân viên'
FROM		`Account` a
INNER JOIN	Department d
ON			a.DepartmentID = d.DepartmentID
GROUP By	a.DepartmentID
HAVING		DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT 		*
FROM		`Account`
WHERE		FullName LIKE '%T%n%';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE		
FROM		Exam
WHERE 		CreateDate < '2019-12-20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE 
FROM 		`Account`
WHERE 		FullName like '%Nguyễn Hải%';

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE 		`Account`
SET			FullName 	=	 N'Nguyễn Bá Lộc',
			Email		=	 N'loc.nguyenba@vti.com.vn'
WHERE		AccountID 	=  	 5;
SELECT * FROM `Account` WHERE AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE		GroupAccount
SET			GroupID		= 	 4
WHERE		AccountID 	= 	 5;

-- ================================== THE END ================================================

SELECT 		* 
FROM 		`Account` 
WHERE 		length(Fullname) = (
				SELECT 	MAX(length(Fullname)) 
				FROM 	`Account` 
				WHERE 	DepartmentID = '3'
            ) 
AND DepartmentID = '3';


-- HÀM GROUP BY NHẰM CHIA RA CÁC NHÓM NHỎ THEO 1 TRƯỜNG NÀO ĐÓ
SELECT		DepartmentName, count(Fullname) AS 'Số nhân viên' 
FROM 		`Account` INNER JOIN Department
WHERE 		`Account`.DepartmentID = Department.DepartmentID
GROUP BY 	DepartmentName
HAVING 		count(Fullname) > 1







