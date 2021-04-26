DROP DATABASE IF EXISTS  TestingSystem;
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

-- tạo bảng Department
DROP TABLE IF EXISTS  Department;
CREATE TABLE Department (
	DepartmentID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 		NVARCHAR(30) NOT NULL UNIQUE KEY --
);

-- tạo bảng Position
DROP TABLE IF EXISTS  Position;
CREATE TABLE Position (
	PositionID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName 		ENUM('Dev', 'Test', 'Scrum Master','PM') NOT NULL 
);

-- tạo bảng Account
DROP TABLE IF EXISTS  `Account`;
CREATE TABLE Account (
	AccountID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email 				NVARCHAR(30) NOT NULL UNIQUE KEY ,
    Username 			NVARCHAR(30) NOT NULL UNIQUE KEY,
    FullName 			NVARCHAR(30) NOT NULL ,
    DepartmentID 		TINYINT UNSIGNED NOT NULL,
    PositionID			TINYINT UNSIGNED NOT NULL,
    CreateDate 			DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);

-- tạo bảng Group
DROP TABLE IF EXISTS  `Group`;
CREATE TABLE `Group` (
	GroupID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName 			NVARCHAR(30) NOT NULL UNIQUE KEY,
    CreatorID 			TINYINT UNSIGNED NOT NULL,
    CreateDate 			DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

-- tạo bảng GroupAccount
DROP TABLE IF EXISTS  GroupAccount;
CREATE TABLE GroupAccount (
	GroupID 			TINYINT UNSIGNED NOT NULL,
    AccountID 			TINYINT UNSIGNED  NOT NULL,
    JoinDate 			DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID) 
);

-- tạo bảng TypeQuestion
DROP TABLE IF EXISTS  TypeQuestion;
CREATE TABLE TypeQuestion (
	TypeID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 			ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);

-- tạo bảng CategoryQuestion
DROP TABLE IF EXISTS  CategoryQuestion;
CREATE TABLE CategoryQuestion (
	CategoryID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName 		NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- tạo bảng Question
DROP TABLE IF EXISTS  Question;
CREATE TABLE Question (
	QuestionID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content 			NVARCHAR(50) NOT NULL,
    CategoryID 			TINYINT UNSIGNED NOT NULL,
    TypeID 				TINYINT UNSIGNED,
    CreatorID 			TINYINT UNSIGNED NOT NULL,
    CreateDate 			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

-- tạo bảng Answer
DROP TABLE IF EXISTS  Answer;
CREATE TABLE Answer (
	AnswerID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content 			NVARCHAR(200) NOT NULL,
    QuestionID 			TINYINT UNSIGNED NOT NULL,
    isCorrect 			ENUM('Đúng','Sai'),
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);
-- tạo bảng Exam
DROP TABLE IF EXISTS  Exam;
CREATE TABLE Exam (
	ExamID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` 				VARCHAR(10) NOT NULL,
    Title 				NVARCHAR(100) NOT NULL,
    CategoryID 			TINYINT UNSIGNED NOT NULL,
    Duration 			TINYINT UNSIGNED NOT NULL,
	CreatorID 			TINYINT UNSIGNED,
	CreateDate 			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- tạo bảng ExamQuestion
DROP TABLE IF EXISTS  ExamQuestion;
CREATE TABLE ExamQuestion (
	ExamID 				TINYINT UNSIGNED AUTO_INCREMENT,
    QuestionID  	 	TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY(ExamID,QuestionID),
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID),
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID)
);

-- INSERT dữ liệu vào bảng Department
INSERT INTO Department(DepartmentName)
VALUE 		
			(N'Marketing'),
            (N'Sale'),
            (N'Bảo vệ'),
            (N'Nhân sự'),
            (N'Kỹ thuật'),
            (N'Tài chính'),
            (N'Phó giám đốc'),
            (N'Giám đốc'),
            (N'Thư ký'),
			(N'Bán hàng');
SELECT * FROM Department;

-- INSERT dữ liệu vào bảng Position
INSERT INTO `Position`(PositionName)
VALUE 		
			(N'Dev'),
            (N'Test'),
            (N'Dev'),
            (N'Scrum Master'),
            (N'Scrum Master'),
            (N'Test'),
            (N'PM'),
            (N'Dev'),
            (N'Dev'),
			(N'PM');
SELECT * FROM Position;

-- INSERT dữ liệu vào bảng Account
INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID)
VALUE 		
			(N'ngtienanh@gmail.com',N'boilanhlung',N'Nguyễn Tiến Anh',1,2),
            (N'ngbaotrung@gmail.com',N'abcnoname',N'Nguyễn Bảo Trung',2,3),
            (N'haohaoh@gmail.com',N'mianlien',N'Trần Hảo Hảo',3,4),
            (N'uyenninh33@gmail.com',N'congchuabongbong',N'Nguyễn Thị Uyên','4',5),
            (N'uyuyuy@gmail.com',N'abc123',N'Trần Y Uy',5,'6'),
            (N'Ngaphuongthao@gmail.com',N'darknight',N'Nguyễn Thị Nga Thao',7,8),
            (N'xyzuka@gmail.com',N'hohoho123',N'Nguyễn Trần Nga',9,1),
            (N'ngbcd@gmail.com',N'ngamyanh',N'Vương Công Tráng',1,5),
            (N'quangtrung@gmail.com',N'haohuehung1',N'Nguyễn Huệ',4,7),
			(N'quockhanhphan@gmail.com',N'tocquan',N'Phan Quốc Khánh',8,2);
SELECT * FROM Account;

-- INSERT dữ liệu vào bảng Group
INSERT INTO `Group`(GroupName,CreatorID)
VALUE 		
			(N'Rockket01',1),
            (N'Rockket02',2),
            (N'Rockket03',3),
            (N'Rockket04',7),
            (N'Rockket05',5),
            (N'Spaceship01',4),
            (N'Spaceship02',3),
            (N'Batman11',2),
            (N'Supperman02',1),
            (N'Carrider01',9);
SELECT * FROM `Group`;

-- INSERT dữ liệu vào bảng GroupAccount
INSERT INTO `GroupAccount`(GroupID,AccountID)
VALUE 		
			(1,1),
            (4,2),
            (5,2),
            (2,4),
            (3,5),
            (1,6),
            (8,7),
            (9,8),
            (2,9),
            (1,3);
SELECT * FROM `GroupAccount`;

-- INSERT dữ liệu vào bảng TypeQuestion
INSERT INTO `TypeQuestion`(TypeName)
VALUE 		
			(N'Essay'),
            (N'Multiple-Choice');
SELECT * FROM `TypeQuestion`;

-- INSERT dữ liệu vào bảng CategoryQuestion
INSERT INTO `CategoryQuestion`(CategoryName)
VALUE 		
			(N'Java'),
            (N'.NET'),
            (N'SQL'),
            (N'Postman'),
            (N'Ruby'),
            (N'react'),
            (N'angular'),
            (N'HTML'),
            (N'CSS'),
            (N'js');
SELECT * FROM `CategoryQuestion`;

-- INSERT dữ liệu vào bảng CategoryQuestion
INSERT INTO `Question`(Content,CategoryID,TypeID,CreatorID)
VALUE 		
			(N'Java là gì?',1,1,1),
            (N'.NET là gì',2,2,2),
            (N'SQL là ngôn ngữ gì',3,2,9),
            (N'Postman được sử dụng ở đâu',4,1,8),
            (N'Ruby sử dụng trên nền tảng gì',5,1,3),
            (N'react có bao nhiêu thành phần',6,2,5),
            (N'angular được phát triển bởi?',7,1,4),
            (N'HTML là ngôn ngữ?',8,1,4),
            (N'CSS sử dụng để?',9,2,6),
            (N'js dùng vào mục đích gì',10,1,10);
SELECT * FROM `Question`;

-- INSERT dữ liệu vào bảng Answer
INSERT INTO `Answer`(Content,QuestionID,isCorrect)
VALUE 		
			(N'Java là một một ngôn ngữ lập trình hiện đại, bậc cao, hướng đối tượng, bảo mật và mạnh mẽ. và là một Platform',1,N'Đúng'),
            (N'.NET Framework là một nền tảng lập trình được phát triển bởi Oracle',2,N'Sai'),
            (N'SQL ngôn ngữ lập trình hướng đối tượng',3,N'Sai'),
            (N'Postman chạy thử cho các API',4,N'Đúng'),
            (N'Ruby đã được cài đặt trên nhiều nền tảng khác nhau, bao gồm Unix',5,N'Đúng'),
            (N'react có 1 thành phần',6,N'Sai'),
            (N'Angular được phát triển từ những năm 2009 và được duy trì bởi Google',7,N'Đúng'),
            (N'HTML website?',8,N'Sai'),
            (N'CSS cho phép bạn định nghĩa kiểu, cách hiện thị cho các phần tử HTML',9,N'Đúng'),
            (N'Bạn có thể sử dụng JavaScript để kiểm tra input và giảm thiểu việc kiểm tra thủ công khi truy xuất qua database',10,N'Đúng');
SELECT * FROM `Answer`;

-- INSERT dữ liệu vào bảng Exam
INSERT INTO `Exam`(`Code`,Title,CategoryID,Duration,CreatorID)
VALUE 		
		('RK1',N'Bài thi rocket 1',1,15,1),
        ('RK2',N'Bài thi rocket 2',3,30,2),
        ('RL1',N'Bài thi railey 1 1',2,15,3),
        ('RL2',N'Bài thi railey 2',4,15,4),
        ('MS1',N'Bài thi musoso 1',6,30,6),
        ('MS2',N'Bài thi musoso 2',5,15,5),
        ('CC1',N'Bài thi cuối kì 1',7,45,8),
        ('CC2',N'Bài thi cuối kì 2',10,45,7),
        ('CC3',N'Bài thi kết thúc',9,60,10),
        ('OOP1',N'Bài thi hướng đối tượng',2,30,9);
SELECT * FROM `Exam`;

-- INSERT dữ liệu vào bảng ExamQuestion
INSERT INTO `ExamQuestion`(ExamID,QuestionID)
VALUE 		
		(1,2),
        (3,6),
        (2,4),
        (5,4),
        (6,10),
        (1,4),
        (7,7),
        (8,1),
        (4,5),
        (1,9);
SELECT * FROM `ExamQuestion`;
















