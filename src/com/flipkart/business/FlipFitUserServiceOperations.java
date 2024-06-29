
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Bookings;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
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
	public List<Bookings> getAllBookings(String userId) {
		// TODO Auto-generated method stub

		return flipFitCustomerDAOInterface.getAllBookingByUserID( userId);
	}


	@Override
	public List<Gym> getAllGymsWithSlots() {
		// TODO Auto-generated method stub
		return flipFitCustomerDAOInterface.getAllGymsByArea();
	}


	@Override
	public List<Gym> getAllGymsByArea(String area) {
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
	public void createUser(User user) {
		flipFitCustomerDAOInterface.createUser(user);
	}


	@Override
	public void updateGymUserPassword(String email, String password, String updatedPassword) {
		updatePasswordInterface.updateGymUserPassword(email, password, updatedPassword);
	}

}
