/**
 * 
 */
package com.flipkart.client;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.business.FlipFitGymOwnerServiceOperation;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.flipkart.constants.ColorConstants.*;
//public class FlipFitGymOwner {
//
//}
////package com.flipkart.application;
//
//i


public class GymFlipFitGymOwnerMenu {

    FlipFitGymOwnerService flipFitGymOwnerService = new FlipFitGymOwnerServiceOperation();
    static Scanner obj = new Scanner(System.in);


    boolean verifyGymOwner(String email, String password) {
        return flipFitGymOwnerService.validateLogin(email, password);
    }


    boolean gymOwnerLogin(String email, String password) {
        if (flipFitGymOwnerService.validateLogin(email, password)) {
            System.out.println(ANSI_BLUE+ "Login Successful"+ANSI_RESET);
            while (true) {
                System.out.println(ANSI_CYAN+"***********GYM OWNER MENU***********");
                System.out.println("1. View all available gyms");
                System.out.println("2. Add your Gym");
                System.out.println("3. Logout"+ANSI_RESET);
                int y = Integer.parseInt(obj.nextLine());

                switch (y) {
                    case 2:
                        addGym(email);
                        break;
                    case 1:
                        displayGyms(email);
                        break;
                    case 3:
                        return true;
                }
            }
        } else return false;
    }


    void addGym(String userId) {
        FlipFitGym flipFitGym = new FlipFitGym();

        System.out.println("Enter the following info:");
        System.out.println("\nEnter gym name:");
        String gymName = obj.nextLine();
        System.out.println("\nGym Address:");
        String address = obj.nextLine();
        System.out.println("\nGym Location:");
        String location = obj.nextLine();

        flipFitGym.setGymAddress(address);
        flipFitGym.setLocation(location);
        flipFitGym.setGymName(gymName);
        flipFitGym.setStatus("unverified");
        List<FlipFitSlots> flipFitSlots = new ArrayList<>();
        System.out.println("\nHow many slots to be entered?");
        int slotNo = Integer.parseInt(obj.nextLine());
        int x = 1;
        while (slotNo != 0) {
            System.out.println("Add slot no. " + x++ + "\n");
            System.out.println("\nEnter start time:");
            int startTime = Integer.parseInt(obj.nextLine());
            System.out.println("\nEnter available seats:");
            int number = Integer.parseInt(obj.nextLine());
            FlipFitSlots slot = new FlipFitSlots(x - 1, startTime, number);
            flipFitSlots.add(slot);
            slotNo--;
        }
        flipFitGym.setSlots(flipFitSlots);
        flipFitGym.setOwnerId(userId);

        flipFitGymOwnerService.addGymWithSlots(flipFitGym);
    }


    void createGymOwner() {
        System.out.println("Enter the following info:");
        System.out.println("\nYour email: ");
        String ownerEmail = obj.nextLine();
        System.out.println("\nYour name: ");
        String ownerName = obj.nextLine();
        System.out.println("\nEnter a password: ");
        String password = obj.nextLine();
        System.out.println("\nPhone number: ");
        String phoneNo = obj.nextLine();
        System.out.println("\nNation ID/ Aadhaar Number: ");
        String nationalId = obj.nextLine();
        if (nationalId.length() != 12) {
            System.out.println(ANSI_YELLOW + "Invalid Adhaar No. Enter a valid adhaar!" + ANSI_RESET);
            return;
        }
        System.out.println("\nGST: ");
        String GST = obj.nextLine();
        System.out.println("\nPAN Details: ");
        String PAN = obj.nextLine();
        if (PAN.length() != 10) {
            System.out.println(ANSI_YELLOW + "Invalid Pan Card No. Enter a valid Pan Card No!" + ANSI_RESET);
            return;
        }

        FlipFitGymOwner flipFitGymOwner = new FlipFitGymOwner();
        List<FlipFitGym> emptyGymList = new ArrayList<>();
        flipFitGymOwner.setOwnerEmail(ownerEmail);
        flipFitGymOwner.setPAN(PAN);
        flipFitGymOwner.setOwnerName(ownerName);
        flipFitGymOwner.setGST(GST);
        flipFitGymOwner.setPassword(password);
        flipFitGymOwner.setNationalId(nationalId);
        flipFitGymOwner.setPhoneNo(phoneNo);
        flipFitGymOwner.setGyms(emptyGymList);
        flipFitGymOwner.setStatus("verified");

        flipFitGymOwnerService.createGymOwner(flipFitGymOwner);
    }


    void displayGyms(String userId) {
        List<FlipFitGym> gymsList = flipFitGymOwnerService.viewMyGyms(userId);
        int x = 1;
        for (FlipFitGym flipFitGym : gymsList) {
            System.out.println("Gym " + x + ": Name " + flipFitGym.getGymName() + "     Address: " + flipFitGym.getGymAddress() + "       Location: " + flipFitGym.getLocation());
            System.out.println("Slots: ");
            for (FlipFitSlots slot : flipFitGym.getSlots()) {
                System.out.println("Slot: " + slot.getSlotsId() + " Slot Time: " + slot.getStartTime() + " - " + (slot.getStartTime() + 1) + " Seats: " + slot.getSeatCount());
            }
            x++;
        }
    }
}
