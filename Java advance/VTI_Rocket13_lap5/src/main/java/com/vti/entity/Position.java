package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Position", catalog = "testingsystem2")
public class Position implements Serializable{
	@Column(name = "PositionID")
	@Id
	private short PositionID;
	
	@Column(name = "PositionName", length = 30, unique = true, nullable = false)
	@Enumerated(EnumType.STRING)
	private positionName PositonName;
	
	@OneToMany(mappedBy = "position")
	@Cascade(value = { CascadeType.REMOVE, CascadeType.SAVE_UPDATE })
	private List<Account> account;

	public enum positionName{
		Dev, Test, Scrum_Master, PM
	}	
	
	public Position(short positionID, positionName positonName, List<Account> account) {
		super();
		PositionID = positionID;
		PositonName = positonName;
		this.account = account;
	}

	public Position() {
		super();
	}

	public short getPositionID() {
		return PositionID;
	}

	public void setPositionID(short positionID) {
		PositionID = positionID;
	}

	public positionName getPositonName() {
		return PositonName;
	}

	public void setPositonName(positionName positonName) {
		PositonName = positonName;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Position [PositionID=" + PositionID + ", PositonName=" + PositonName + ", account=" + account + "]";
	}
}
