package org.trains;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import static java.lang.System.*;

// todo: Need to add
        // todo: -Add a new Train
        // todo: -Add a new Station
        // todo: -Change Trains Destination
        // todo: -Read info on selected train
        // todo: -Read info on Trains in Station
public class Main {
    public static void main(String[] args) {
        Scanner userScan = new Scanner(in);

        while (true) {
            out.println("What would you like to do?");
            String userInput = userScan.nextLine().toLowerCase();
            if (userInput.equals("1")) {
                out.println("What Station?");
                String userChoice = userScan.nextLine();
                Commands.trainsInStation(userChoice);
            } else if (userInput.equals("2")) {
                out.println("Something");
            } else if (userInput.equals("3")) {
                out.println("Something");
            } else if (userInput.equals("4")) {
                out.println("Something");
            } else {
                out.println("ERROR: NO COMMAND MATCHES WITH " + userInput);
            }
        }
    }
}
