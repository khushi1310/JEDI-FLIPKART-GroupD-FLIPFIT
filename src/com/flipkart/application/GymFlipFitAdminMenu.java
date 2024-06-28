package com.flipkart.application;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.business.FlipFitAdminServiceOperation;
import com.flipkart.utils.DatabaseConnector;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;



public class GymFlipFitAdminMenu {

    FlipFitAdminService flipFitAdminService = new FlipFitAdminServiceOperation();

    public void viewGyms() {
        flipFitAdminService.viewGyms();
    }

 
    public void viewUsers() {
        flipFitAdminService.viewUsers();
    }

    public void viewGymOwners() {
        flipFitAdminService.viewGymOwners();
    }

    
    public void verifyGym(int id) {
        flipFitAdminService.verifyGym(id);
    }

    
    public void verifyGymOwner(int id) {
        flipFitAdminService.verifyGymOwner(id);
    }

    
    public void viewUnverifiedGyms() {
        List<Gym> gyms = flipFitAdminService.getUnverifiedGyms();
        String leftAlignFormat = "| %-5d | %-20s | %-5d | %-40s | %-20s | %-15s |%n";
        System.out.format("+-------+----------------------+-------+------------------------------------------+----------------------+------------------+\n");
        System.out.format("| Gym   |     Name             | Gym Id|           Address                        |   Location           |     Status       |\n");
        System.out.format("+-------+----------------------+-------+------------------------------------------+----------------------+------------------+\n");

        int x = 1;
        for (Gym g : gyms) {
            System.out.format(leftAlignFormat,x,g.getGymName(),g.getGymId(),g.getGymAddress(),g.getLocation(),g.getStatus());            x++;
        }
        System.out.format("+-------+----------------------+-------+------------------------------------------+----------------------+------------------+\n");

    }

    
    public void viewUnverifiedGymOwners() {
        List<GymOwner> g = flipFitAdminService.getUnverifiedGymOwners();
        int x = 1;
        for (GymOwner gymOwner : g) {
            System.out.println("GymOwner " + x + "-->   Gym Owner Id " + gymOwner.getOwnerId() + "    Email: " + gymOwner.getOwnerEmail() + "    Phone No: " + gymOwner.getPhoneNo() + "   Status:" + gymOwner.getStatus());
            x++;
            System.out.println("\n-------------------------------------------------------------");
        }
    }

   
    public boolean verifyAdminCredentials(String id, String pass) {
        try {
            Properties prop = new Properties(); // Properties is used to read files
            InputStream inputStream = DatabaseConnector.class.getClassLoader().getResourceAsStream("./config.properties");
            prop.load(inputStream);
            String admin_id = prop.getProperty("admin_id");
            String admin_password = prop.getProperty("admin_password");

            return (id.equals(admin_id) && pass.equals(admin_password));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
