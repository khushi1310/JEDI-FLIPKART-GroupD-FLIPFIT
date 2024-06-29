package com.flipkart.dao;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;

import java.sql.SQLException;
import java.util.List;

public interface FlipFitAdminDAOInterface {

    public void viewGyms();


    public void viewUsers();


    public void viewGymOwners();


    public void verifyGymOwners(int id);


    public void verifyGyms(int id);


    public List<FlipFitGym> getUnverifiedGyms();


    public List<FlipFitGymOwner> getUnverifiedGymOwner();
}
