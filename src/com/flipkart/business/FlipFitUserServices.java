
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.FlipFitBookings;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitUser;


public interface FlipFitUserServices {


	boolean cancelSlots(int slotId);


	List<FlipFitBookings> getAllBookings(String userId);


	List<FlipFitGym> getAllGymsWithSlots();


	List<FlipFitGym> getAllGymsByArea(String area);


	boolean bookSlots(int gymId, int time, String email);


	boolean validateUser(String username, String pass);


	void createUser(FlipFitUser flipFitUser);
	public boolean verifyGymUserPassword(String email, String password, String updatedPassword);


	void updateGymUserPassword(String email, String password, String updatedPassword);
}
