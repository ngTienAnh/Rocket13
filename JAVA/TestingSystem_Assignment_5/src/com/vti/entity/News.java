package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class News implements INews {
	private int ID;
	private String Title;
	private String PublishDate;
	private String Author;
	private String Content;
	private float AverageRate;
	private int[] rate = new int[3];

	public static int COUNT;

	public int[] getRate() {
		return this.rate;
	}
	public void setRate(int[] rate) {
		this.rate = rate;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public float getAverageRate() {
		return AverageRate;
	}
	

	@Override
	public void dispaly() {
		System.out.println("News [Title=" + Title + ", PublishDate=" + PublishDate + ", Author=" + Author + ", Content="
				+ Content + ", AverageRate=" + AverageRate + "]");
	}

	@Override
	public float calculate() {
		AverageRate = ((rate[0] + rate[1] + rate[2]) / 3);
		return AverageRate;
	}
}
