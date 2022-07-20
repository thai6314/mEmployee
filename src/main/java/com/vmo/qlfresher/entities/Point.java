package com.vmo.qlfresher.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "point")
public class Point {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "point1")
	private float point1;
	
	@Column(name = "point2")
	private float point2;
	
	@Column(name = "point3")
	private float point3;
	
	@Column(name = "medium_score")
	private float mediumScore;
	
	@OneToOne
	@JoinColumn(name = "fresher_id")
	private Fresher fresher;
	
	public Point() {}

	public Point(int id, float point1, float point2, float point3, float mediumScore, Fresher fresher) {
		super();
		this.id = id;
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.mediumScore = mediumScore;
		this.fresher = fresher;
	}
	public Point(float point1, float point2, float point3, float mediumScore) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.mediumScore = mediumScore;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPoint1() {
		return point1;
	}

	public void setPoint1(float point1) {
		this.point1 = point1;
	}

	public float getPoint2() {
		return point2;
	}

	public void setPoint2(float point2) {
		this.point2 = point2;
	}

	public float getPoint3() {
		return point3;
	}

	public void setPoint3(float point3) {
		this.point3 = point3;
	}

	public float getMediumScore() {
		return mediumScore;
	}

	public void setMediumScore(float mediumScore) {
		this.mediumScore = mediumScore;
	}

	public Fresher getFresher() {
		return fresher;
	}

	public void setFresher(Fresher fresher) {
		this.fresher = fresher;
	}
	
	
	
	
}
