DROP DATABASE IF EXISTS QL_DoAn;
CREATE DATABASE QL_DoAn ;
USE QL_DoAn;

DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien (
		Id_GV 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        Ten_GV		NVARCHAR(30) NOT NULL,
        Tuoi		TINYINT,
        HocVi		CHAR(20)
);

DROP TABLE IF EXISTS SinhVien;
CREATE TABLE SinhVien (
		Id_SV 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        Ten_SV		NVARCHAR(30) NOT NULL,
        NamSinh		INT,
        QueQuan		NVARCHAR(30)
);

DROP TABLE IF EXISTS DeTai;
CREATE TABLE DeTai (
		Id_DeTai 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        Ten_DeTai	NVARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan (
		Id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        Id_SV		TINYINT UNSIGNED ,
        Id_DeTai	TINYINT UNSIGNED ,
        Id_GV		TINYINT UNSIGNED ,
        Diem		FLOAT,
    CONSTRAINT fk_HuongDan_SinhVien  	FOREIGN KEY(Id_SV) 			REFERENCES 	SinhVien(Id_SV) ON DELETE CASCADE,
    CONSTRAINT fk_HuongDan_DeTai 		FOREIGN KEY(Id_DeTai) 		REFERENCES 	DeTai(Id_DeTai),
    CONSTRAINT fk_HuongDan_GiangVien 	FOREIGN KEY(Id_GV) 			REFERENCES 	GiangVien(Id_GV)
);

-- INSERT --

/*GiangVien(Id_GV, Ten_GV, Tuoi, HocVi)
SinhVien(Id_SV, Tên_SV, NamSinh, QueQuan)
DeTai(Id_DeTai, Ten_DeTai)
HuongDan(Id, Id_SV, Id_DeTai, Id_GV, Diem)
Trường học vị: nhận các giá trị là Ths, Ts, PGS, GS, …;*/

INSERT INTO GiangVien 	(		Ten_GV,			Tuoi,		HocVi)
VALUES 					(N'Giảng Viên 1',		30,			'Ths'	),
						(N'Giảng Viên 2',		26,			'Ts'	),
                        (N'Giảng Viên 3',		40,			'Ts'	),
                        (N'Giảng Viên 4',		59,			'Ths'	),
                        (N'Giảng Viên 5',		44,			'GS'	),
                        (N'Giảng Viên 6',		44,			'Ths'	),
                        (N'Giảng Viên 7',		40,			'GS'	),
                        (N'Giảng Viên 8',		60,			'Ths'	),
                        (N'Giảng Viên 9',		50,			'PGS'	),
                        (N'Giảng Viên 10',		30,			'PGS'	);
                       
INSERT INTO DeTai 	(		Ten_DeTai)
VALUES				(		N'Đề tài 1'),
					(		N'Đề tài 2'),
                    (		N'Đề tài 3'),
                    (		N'Đề tài 4'),
                    (		N'Đề tài 5'),
					(		N'Đề tài 6'),
                    (		N'Đề tài 7'),
                    (		N'Đề tài 8'),
                    (		N'Đề tài 9'),
                    (		N'Đề tài 10');
                    
INSERT INTO SinhVien 	(		Ten_SV,			NamSinh,		QueQuan)
VALUES 					(N'Sinh viên 1',		1999,			'QueQuan 1'	),
						(N'Sinh viên2',			1999,			'QueQuan 2'	),
                        (N'Sinh viên 3',		1999,			'QueQuan 3'	),
                        (N'Sinh viên 4',		2000,			'QueQuan 4'	),
                        (N'Sinh viên 5',		2000,			'QueQuan 5'	),
                        (N'Sinh viên 6',		2002,			'QueQuan 6'	),
                        (N'Sinh viên 7',		2004,			'QueQuan 7'	),
                        (N'Sinh viên 8',		2004,			'QueQuan 8'	),
                        (N'Sinh viên 9',		2000,			'QueQuan 9'	),
                        (N'Sinh viên 10',		2005,			'QueQuan 10');

INSERT INTO HuongDan 	(		Id_SV,			Id_DeTai,		Id_GV,		Diem)
VALUES 					(			1,					1,			1,			1),
						(			2,					2,			2,			2),
                        (			3,					3,			3,			3),
                        (			4,					4,			4,			4),
                        (			5,					5,			5,			5),
                        (			6,					6,			6,			6),
                        (			7,					7,			7,			7),
                        (			8,					8,			8,			8),
                        (			9,					9,			9,			9),
                        (			10,					10,			10,			10);

-- 2 -- Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT 		SV.Id_SV, SV.Ten_SV, SV.NamSinh, SV.QueQuan
FROM		SinhVien sv
LEFT JOIN	HuongDan hd 
ON			sv.Id_SV = hd.Id_SV
WHERE		hd.Id_DeTai IS NULL;


-- b) Lấy ra số sinh viên làm đề tài ‘DeTai 6’
SELECT 		COUNT(hd.Id_SV) AS 'Số sinh viên làm đề tài 6'
FROM		HuongDan hd
INNER JOIN	DeTai dt
ON			hd.Id_DeTai = dt.Id_DeTai
WHERE		dt.Ten_DeTai = 'Đề Tài 6';

/*3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
mã số, họ tên và tên đề tài
(Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")*/
CREATE OR REPLACE VIEW SinhVienInfo AS
	SELECT 		sv.Id_SV, sv.Ten_SV,  CASE
				WHEN dt.Ten_DeTai IS NULL THEN 'Chưa có'
				ELSE dt.Ten_DeTai END AS 'Tên đề tài'
    FROM		SinhVien sv 
    LEFT JOIN		HuongDan hd
    ON			sv.Id_SV = hd.Id_SV
    LEFT JOIN	DeTai dt
    ON			dt.Id_DeTai = hd.Id_DeTai;

SELECT * FROM SinhVienInfo;

/*4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1950
thì hiện ra thông báo "Moi ban kiem tra lai nam sinh"*/
DROP TRIGGER IF EXISTS trg_insert_SV_NamSinh;
DELIMITER $$
CREATE TRIGGER trg_insert_SV_NamSinh
BEFORE INSERT ON SinhVien
FOR EACH ROW
BEGIN
	IF NEW.NamSinh <= 1950 THEN
		SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Moi ban kiem tra lai nam sinh';
	END IF;
END$$
DELIMITER ;

INSERT INTO SinhVien 	(		Ten_SV,			NamSinh,		QueQuan)
VALUES 					(N'Sinh viên 11',		   1940,	'QueQuan 11');

/*5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi*/

	DELETE FROM SinhVien sv
    WHERE		sv.Id_SV = 1;

/*6. Viết 1 Procedure để khi nhập vào tên của sinh viên thì sẽ thực hiện xóa toàn bộ thông tin
liên quan của sinh viên trên hệ thống:*/

DROP PROCEDURE IF EXISTS proc_delete_SV;
DELIMITER $$
	CREATE	PROCEDURE proc_delete_SV (IN in_Name VARCHAR(30))
	BEGIN
			DELETE FROM SinhVien sv
			WHERE		sv.Ten_SV = in_Name;
           /* DELETE FROM HuongDan hd
            WHERE		hd.Id_SV = (SELECT 	Id_SV
									FROM 	SinhVien sv
									WHERE	sv.Ten_SV = in_Name);*/
    END$$
DELIMITER ;
CALL proc_delete_SV('Sinh viên2');






