package com.flipkart.bean;


public class FlipFitSlots {

	private int slotsId; // Unique identifier for the slot
	private int startTime; // Start time of the slot
	private int seatCount; // Number of available seats in the slot


	public FlipFitSlots(int slotsId, int startTime, int seatCount) {
		this.setSlotsId(slotsId);
		this.setStartTime(startTime);
		this.setSeatCount(seatCount);
	}


	public int getSlotsId() {
		return slotsId;
	}


	public void setSlotsId(int slotsId) {
		this.slotsId = slotsId;
	}


	public int getStartTime() {
		return startTime;
	}


	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}


	public int getSeatCount() {
		return seatCount;
	}


	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
}
