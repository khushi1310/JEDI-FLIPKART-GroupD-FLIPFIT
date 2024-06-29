package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipfitGymOwnerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOInterface;
import com.flipkart.dao.UpdatePasswordDAOImpl;
import com.flipkart.dao.UpdatePasswordDAOInterface;


public class FlipFitGymOwnerServiceOperation implements FlipFitGymOwnerService{

	HashMap<String,FlipFitGymOwner> flipFitGymOwners = new HashMap();
	FlipFitGymOwnerDAOInterface flipFitGymOwnerDAOInterface = new FlipfitGymOwnerDAOImpl();
	Scanner obj = new Scanner(System.in);
	UpdatePasswordDAOInterface updatePasswordInterface = new UpdatePasswordDAOImpl();
	int id = 0;


	@Override
	public void addGymWithSlots(FlipFitGym flipFitGym) {
		flipFitGymOwnerDAOInterface.addGym(flipFitGym);
	}

	@Override
	public List<FlipFitGym> viewMyGyms(String userId){
		return flipFitGymOwnerDAOInterface.viewGymSlots(userId);
	}


	@Override
	public boolean validateLogin(String email, String password) {
		return updatePasswordInterface.verifyGymUserPassword(email, password);
//		if(gymOwnerDaoInterface.validateLogin(email,password)) return true;
//        return false;
    }


	@Override
	public void createGymOwner(FlipFitGymOwner flipFitGymOwner){
		flipFitGymOwnerDAOInterface.newGymOwner(flipFitGymOwner);

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
