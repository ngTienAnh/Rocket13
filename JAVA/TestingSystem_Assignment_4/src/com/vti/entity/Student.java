package com.vti.entity;
// ques4
public class Student {
	private int id;
	private String name; 
	private String hometown;  
	private float score;
	
	public Student(int id, String name, String hometown) {
		super();
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.score = (float)0;
	}

	public Student() {
		super();
	}

	public Student(float score, String name) {
		super();
		this.score = score;
		this.name = name;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public void setPlusScore(float score) {
		this.score += score;
	}

	@Override
	public String toString() {
		String rateScore = "";
		if(this.score < (float)4.0) 
			rateScore = "Yếu";
		else if (this.score > (float)4.0 && this.score < (float)6.0)
			rateScore = "Trung bình";
		else if (this.score > (float)6.0 && this.score < (float)8.0)
			rateScore = "khá";
		else if(this.score > (float)8.0) 
			rateScore = "Giỏi";
		return "Student [name=" + name + ", Rank="+rateScore + "]";
	}
	
	
}
