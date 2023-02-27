package com.example.TicketsRegister.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bean 
{
	@Id
	@Column
	private int passengerId;
	@Column
	private String passengerName;
	@Column
	private String passengerdestination;
	
	public Bean()
	{

	}
	public Bean(int passengerId, String passengerName, String passengerdestination) 
	{	
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerdestination = passengerdestination;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerdestination() {
		return passengerdestination;
	}
	public void setPassengerdestination(String passengerdestination) {
		this.passengerdestination = passengerdestination;
	}
	public String toString() {
		return "Bean [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerdestination="
				+ passengerdestination + "]";
	}
}
