package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.News;
import com.vti.entity.TuyenSinh;

public class Exercise1 {
	private  ArrayList<News> listNew;
	private  Scanner sc;
	
	
	public Exercise1() {
		sc = new Scanner (System.in);
		listNew = new ArrayList<News>();
	}

	public void menu() {
		while (true) {
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
			System.out.println("=== 1. Insert news											   	   ===");
			System.out.println("=== 2. View list news 									   			===");
			System.out.println("=== 3. Avarage Rates 				  								===");
			System.out.println("=== 4. Exit 								   						===");
			System.out.println("======================================================================");

			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				insertNew();
				break;
			case 2:
				viewListNews();
				break;
			case 3:
				AverageRates();
				break;
			case 4:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}

	private void AverageRates() {
		for (News nx : listNew) {
			System.out.println("/t");
			nx.dispaly();
			System.out.println("\tđiểm trung bình là: " + nx.calculate());
		}
	}

	private void viewListNews() {
		for (News nx : listNew) {
			System.out.println("/t");
			nx.dispaly();
		}
	}

	@SuppressWarnings("static-access")
	private void insertNew() {
		News news = new News();
		System.out.println("Mời nhập thông tin new:");
		System.out.printf("\n\t Title: ");
		news.setTitle(sc.next());
		System.out.printf("\n\t PublishDate: ");
		news.setPublishDate(sc.next());
		System.out.printf("\n\t Author: ");
		news.setAuthor(sc.next());
		System.out.printf("\n\t Content: ");
		news.setContent(sc.next());
		System.out.println("Mời nhập 3 đánh giá:");
		int rates[] = new int[3];
		for (int i = 0; i < rates.length; i++) {
			int y = i + 1;
			System.out.println("Moi nhap danh gia thu " + y  + ":");
			rates[i] = sc.nextInt();
		}
		news.setRate(rates);
		listNew.add(news);
		System.out.println("Lưu thành công!");
	}
	
	public void Question2 () {
		while (true) {
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
			System.out.println("=== 1. Insert Student===");
			System.out.println("=== 2. View Student news===");
			System.out.println("=== 3. Search==");
			System.out.println("=== 4. Exit===");
			System.out.println("======================================================================");

			int menuChoose = sc.nextInt();
			TuyenSinh ts = new TuyenSinh();
			switch (menuChoose) {
			case 1:
				ts.Insert();
				break;
			case 2:
				ts.Display();
				break;
			case 3:
				ts.Search();
				break;
			case 4:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}
}
