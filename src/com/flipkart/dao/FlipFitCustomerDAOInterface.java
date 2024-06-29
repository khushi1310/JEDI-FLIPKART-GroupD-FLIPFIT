package com.flipkart.dao;

import com.flipkart.bean.FlipFitBookings;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitUser;

import java.util.List;

public interface FlipFitCustomerDAOInterface {

    List<FlipFitGym> getAllGymsByArea();


    boolean bookSlot(int gymId, int time, String email);


    List<FlipFitBookings> getAllBookingByUserID(String userId);


    boolean cancelBooking(int bookingId);


    boolean validateUser(String username, String pass);


    void createUser(FlipFitUser flipFitUser);
}
