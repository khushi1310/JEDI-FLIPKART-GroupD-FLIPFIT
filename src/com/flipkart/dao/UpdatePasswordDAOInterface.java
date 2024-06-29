package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;

public interface UpdatePasswordDAOInterface {

    public void updateGymOwnerPassword(String email, String password, String updatedPassword);


    public void updateGymUserPassword(String email, String password, String updatedPassword);


    public boolean verifyGymOwnerPassword(String email, String password);


    public boolean verifyGymUserPassword(String email, String password);
}
