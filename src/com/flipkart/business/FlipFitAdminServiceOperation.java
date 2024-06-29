package com.flipkart.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitAdminDAOInterface;

public class FlipFitAdminServiceOperation implements FlipFitAdminService{


	FlipFitAdminDAOInterface adminDaoInterface = new FlipFitAdminDAOImpl();
	Scanner obj = new Scanner(System.in);

	@Override
	public void viewGymOwners() {
		adminDaoInterface.viewGymOwners();
	}

	@Override
	public void viewGyms() {
		adminDaoInterface.viewGyms();
	}


	@Override
	public void viewUsers() {
		adminDaoInterface.viewUsers();
	}


	@Override
	public void verifyGym(int gymId) {
		// TODO Auto-generated method stub
		adminDaoInterface.verifyGyms(gymId);
	}


	@Override
	public void verifyGymOwner(int gymOwnerId) {
		// TODO Auto-generated method stub
		adminDaoInterface.verifyGymOwners(gymOwnerId);

	}


	@Override
	public List<FlipFitGymOwner> getUnverifiedGymOwners() {
		// TODO Auto-generated method stub
		return adminDaoInterface.getUnverifiedGymOwner();
	}


	@Override
	public List<FlipFitGym> getUnverifiedGyms() {
		// TODO Auto-generated method stub
		return adminDaoInterface.getUnverifiedGyms();
	}

}
