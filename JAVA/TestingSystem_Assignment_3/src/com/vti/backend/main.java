package com.vti.backend;

import java.time.LocalDate;
import java.util.Random;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PosititionName;

public class main {
	public static void main(String[] args) {
		Group group2 = new Group();
		group2.ID = 2;
		group2.Name = "rocket2";
		
		Group group3 = new Group();
		group3.ID = 3;
		group3.Name = "rocket3";
		Group group1 = new Group();
		group1.ID = 1;
		group1.Name = "rocket1";

		Department department1 = new Department();
		department1.ID = 1;
		department1.Name = "Sale";
		Department department2 = new Department();
		department1.ID = 1;
		department1.Name = "Thư kí";
		Department department3 = new Department();
		department1.ID = 1;
		department1.Name = "Kinh doanh";

		Position position1 = new Position();
		position1.ID = 1;
		position1.Name = PosititionName.DEV;
		Position position2 = new Position();
		position1.ID = 1;
		position1.Name = PosititionName.PM;
		Position position3 = new Position();
		position1.ID = 1;
		position1.Name = PosititionName.SCRUM_MASTER;

		Account acct1 = new Account();
		acct1.ID = 1;
		acct1.email = "demo1@gmail.com";
		acct1.fullName = "name1";
		acct1.department = department1;
		acct1.position = position1;
		acct1.userName = "username1";

		Account acct2 = new Account();
		acct2.ID = 2;
		acct2.email = "demo2@gmail.com";
		acct2.fullName = "name2";
		acct2.department = department2;
		acct2.position = position2;
		acct2.userName = "username2";

		Account acct3 = new Account();
		acct3.ID = 3;
		acct3.email = "demo3@gmail.com";
		acct3.fullName = "name3";
		acct3.department = department3;
		acct3.position = position3;
		acct3.userName = "username3";

		acct1.group = new Group[] { group1, group2 };
		acct2.group = new Group[] { group3, group2 };
		acct3.group = new Group[] { group1, group3 };

		group1.Account = new Account[] { acct1, acct2 };
		group2.Account = new Account[] { acct1, acct3 };
		group3.Account = new Account[] { acct2, acct3 };

		System.out.print("danh sách account");
		System.out.print("\nID:" + acct1.ID);
		System.out.print("\nfullName:" + acct1.fullName);
		System.out.print("\nEmail:" + acct1.email);
		System.out.print("\nuserNamel:" + acct1.userName);
		System.out.print("\nGroup:" + acct1.group[0].Name + "\t" + acct1.group[1].Name);

		System.out.print("\n");
		System.out.print("\nID:" + acct2.ID);
		System.out.print("\nfullName:" + acct2.fullName);
		System.out.print("\nEmail:" + acct1.email);
		System.out.print("\nuserNamel:" + acct2.userName);
		System.out.print("\nGroup:" + acct2.group[0].Name + "\t" + acct2.group[1].Name);

		System.out.print("\n");
		System.out.print("\nID:" + acct3.ID);
		System.out.print("\nfullName:" + acct3.fullName);
		System.out.print("\nEmail:" + acct3.email);
		System.out.print("\nuserNamel:" + acct3.userName);
		System.out.print("\nGroup:" + acct3.group[0].Name + "\t" + acct3.group[1].Name);
		System.out.println();
		Account acc[]= {acct1, acct2, acct3};

		System.out.println("Số ngẫu nhiên: ");
		Random random = new Random();
		int i = random.nextInt(acc.length);
		System.out.println("tên bạn ngẫu nhiên: "+acc[i].fullName);
		System.out.println("---------FOR Question 16- 10: In thông tin account:---------");
		
		Random random1 = new Random();
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay(); // Lấy ra số ngày nhỏ nhất tính từ 01/01/1970
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay(); // Lấy ra số ngày lớn nhất tính từ 01/01/1970
		long randomInt = minDay + random1.nextInt(maxDay - minDay); // Lấy ra số ngày ngẫu nhiên trong khoảng thời gian
																	// // cần lấy
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
		System.out.println("haha");
	}
}
