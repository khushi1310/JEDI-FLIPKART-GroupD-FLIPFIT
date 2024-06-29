package com.flipkart.dao;

import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitSlots;

import java.sql.SQLException;
import java.util.List;

public interface FlipFitGymOwnerDAOInterface {

    void insertSlots(List<FlipFitSlots> flipFitSlots, int gymId);


    public List<FlipFitGym> viewGymSlots(String gymOwnerID);


    void addGym(FlipFitGym flipFitGym);

    void newGymOwner(FlipFitGymOwner flipFitGymOwner);


    boolean validateLogin(String email, String password);
}
