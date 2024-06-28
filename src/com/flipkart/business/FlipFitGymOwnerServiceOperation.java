package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipfitGymOwnerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOInterface;
import com.flipkart.dao.UpdatePasswordDAOImpl;
import com.flipkart.dao.UpdatePasswordDAOInterface;


public class FlipFitGymOwnerServiceOperation implements FlipFitGymOwnerService{

	HashMap<String,GymOwner> gymOwners = new HashMap();
	FlipFitGymOwnerDAOInterface flipFitGymOwnerDAOInterface = new FlipfitGymOwnerDAOImpl();
	Scanner obj = new Scanner(System.in);
	UpdatePasswordDAOInterface updatePasswordInterface = new UpdatePasswordDAOImpl();
	int id = 0;


	@Override
	public void addGymWithSlots(Gym gym) {
		flipFitGymOwnerDAOInterface.addGym(gym);
	}

	@Override
	public List<Gym> viewMyGyms(String userId){
		return flipFitGymOwnerDAOInterface.viewGymSlots(userId);
	}


	@Override
	public boolean validateLogin(String email, String password) {
		return updatePasswordInterface.verifyGymUserPassword(email, password);
//		if(gymOwnerDaoInterface.validateLogin(email,password)) return true;
//        return false;
    }


	@Override
	public void createGymOwner(GymOwner gymOwner){
		flipFitGymOwnerDAOInterface.newGymOwner(gymOwner);

	}


	@Override
	public boolean verifyGymOwnerPassword(String email, String password) {
		return updatePasswordInterface.verifyGymUserPassword(email, password);
    }


	@Override
	public void updateGymOwnerPassword(String email, String password, String updatedPassword) {
		updatePasswordInterface.updateGymOwnerPassword(email, password, updatedPassword);
	}

}
