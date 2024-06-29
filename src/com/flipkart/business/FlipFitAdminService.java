package com.flipkart.business;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;


public interface FlipFitAdminService {


    public void viewGymOwners();

    public void viewGyms();


    public void viewUsers();


    public void verifyGym(int gymId);


    public void verifyGymOwner(int gymOwnerId);


    public List<FlipFitGymOwner> getUnverifiedGymOwners() ;


    public List<FlipFitGym> getUnverifiedGyms() ;

}
