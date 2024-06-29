
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.FlipFitBookings;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.dao.UpdatePasswordDAOImpl;
import com.flipkart.dao.UpdatePasswordDAOInterface;


public class FlipFitUserServiceOperations implements FlipFitUserServices {

	FlipFitCustomerDAOInterface flipFitCustomerDAOInterface = new FlipFitCustomerDAOImpl();
	UpdatePasswordDAOInterface updatePasswordInterface = new UpdatePasswordDAOImpl();


	@Override
	public boolean verifyGymUserPassword(String email, String password, String updatedPassword) {
		return false;
	}


	@Override
	public boolean cancelSlots(int bookingId) {
		// TODO Auto-generated method stub

		return flipFitCustomerDAOInterface.cancelBooking(bookingId);
	}


	@Override
	public List<FlipFitBookings> getAllBookings(String userId) {
		// TODO Auto-generated method stub

		return flipFitCustomerDAOInterface.getAllBookingByUserID( userId);
	}


	@Override
	public List<FlipFitGym> getAllGymsWithSlots() {
		// TODO Auto-generated method stub
		return flipFitCustomerDAOInterface.getAllGymsByArea();
	}


	@Override
	public List<FlipFitGym> getAllGymsByArea(String area) {
		// TODO Auto-generated method stub
		return flipFitCustomerDAOInterface.getAllGymsByArea();

	}


	@Override
	public boolean bookSlots(int gymId, int time, String email) {
		return flipFitCustomerDAOInterface.bookSlot(gymId,time,email);
	}


	@Override
	public boolean validateUser(String username, String pass) {
		return flipFitCustomerDAOInterface.validateUser(username,pass);
	}


	@Override
	public void createUser(FlipFitUser flipFitUser) {
		flipFitCustomerDAOInterface.createUser(flipFitUser);
	}


	@Override
	public void updateGymUserPassword(String email, String password, String updatedPassword) {
		updatePasswordInterface.updateGymUserPassword(email, password, updatedPassword);
	}

}
