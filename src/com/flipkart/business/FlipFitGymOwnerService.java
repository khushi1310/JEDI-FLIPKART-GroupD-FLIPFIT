
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;

public interface FlipFitGymOwnerService {

	void addGymWithSlots(FlipFitGym flipFitGym);


	List<FlipFitGym> viewMyGyms(String userId);


    boolean verifyGymOwnerPassword(String email, String password);


    boolean validateLogin(String email, String password);


	void createGymOwner(FlipFitGymOwner flipFitGymOwner);


	void updateGymOwnerPassword(String email, String password, String updatedPassword);
}
