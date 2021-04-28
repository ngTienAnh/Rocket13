-- ================lệnh SELECT================== --
SELECT 	* 
FROM 	`Account`;

SELECT 	* 
FROM 	`Account` 
WHERE 	Email = 'ngtienanh@gmail.com';

SELECT 	* 
FROM 	`Account`
WHERE 	DepartmentID = '1' AND PositionID = 2;

SELECT 	* 
FROM 	`Account`
WHERE 	DepartmentID = 3 OR PositionID = 1; 
         
SELECT 	* 
FROM 	`Account`
WHERE 	DepartmentID BETWEEN 4 AND 9; -- dữ liệu nằm giữa

SELECT 	* 
FROM 	`Account`
WHERE 	DepartmentID IN (4, 9, 10 ,11); -- lấy dữ liệu nằm trong ngoặc
         
SELECT 	* 
FROM 	`Account`
WHERE 	DepartmentID NOT IN (4, 9, 10 ,11); -- lấy dữ liệu không nằm trong ngoặc
         
SELECT 	FullName 
FROM 	`Account` 
WHERE  	FullName 
LIKE 	'T%';

SELECT 	FullName 
FROM 	`Account` 
WHERE  	FullName 
NOT LIKE 'T%';

SELECT 	FullName 
FROM 	`Account` 
WHERE  	FullName 
LIKE 	'%T%'; -- % thay thế cho 1 chuỗi bất kì

SELECT 	FullName 
FROM 	`Account` 
WHERE  	FullName 
LIKE 	'__a%'; -- gạch dưới "_" đại diện cho 1 kí tự

SELECT 	FullName 
FROM 	`Account` 
WHERE  	FullName IS NULL;

SELECT 	FullName 
FROM 	`Account` 
WHERE  	FullName IS NOT NULL;

-- select với thời gian
SELECT * FROM `Account` WHERE CreateDate > '2021-03-24 00:00:00';
SELECT * FROM `Account` WHERE CreateDate < '2021-03-24 00:00:00';
SELECT * FROM `Account` WHERE CreateDate =  '2021-03-24 00:00:00';
SELECT * FROM `Account` WHERE CreateDate <> '2021-03-24 00:00:00';
SELECT * FROM `Account` WHERE CreateDate != '2021-03-24 00:00:00';

SELECT * FROM `Account` ORDER BY Username;
SELECT * FROM `Account` ORDER BY Username AND  DepartmentID DESC;


-- 3 cách đếm
SELECT *,1 FROM `Account`; -- 

SELECT count(*) AS 'Số bản ghi Account' FROM `Account`; -- đếm số dòng, đếm cả 1 dòng trong 1 lần
SELECT count(Fullname) AS 'Số bản ghi Account' FROM `Account`;
SELECT count(1) AS 'Số bản ghi Account' FROM `Account`;
-- ================= --
-- hàm leght, sum, min, max

-- ======== hàm max
SELECT 		MAX(length(Fullname)) 
AS 			'Ngày lập sớm nhất' 
FROM 		`Account` ;

SELECT 		MAX(length(Fullname)) 
AS 			'Ngày lập sớm nhất' 
FROM 		`Account` ;

SELECT 		MIN(CreateDate) 
AS 			'Ngày lập sớm nhất' 
FROM 		`Account` ;
