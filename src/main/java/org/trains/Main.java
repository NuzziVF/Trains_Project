package org.trains;

import java.sql.Connection;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

// todo: Need to add
        //  -Add a new Train
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
                out.println("What is the train's name?");
                String inputTrainName = userScan.nextLine();

                out.println("What is the trains cargo?");
                String inputCargo = userScan.nextLine();

                out.println("How fast is the train?");
                int inputSpeed = Integer.parseInt(userScan.nextLine());

                out.println("Who is the trains maker?");
                String inputTrainMaker = userScan.nextLine();

                out.println("What is the production year of the train?");
                String inputYear = userScan.nextLine();

                out.println("What is the production month of the train?");
                String inputMonth = userScan.nextLine();

                if (inputMonth.length() == 1) {
                    inputMonth = "0" + inputMonth;
                }

                out.println("What is the production day of the train?");
                String inputDay = userScan.nextLine();

                if (inputDay.length() == 1) {
                    inputDay = "0" + inputDay;
                }

                String inputDate = inputYear + "-" + inputMonth + "-" + inputDay;

                out.println(inputDate);

                out.println("What Station is the train at?");
                String inputCurrentStation = userScan.nextLine();

                out.println("Where is it going?");
                String inputDestination = userScan.nextLine();

                out.println(inputTrainName);
                out.println(inputCargo);
                out.println(inputSpeed);
                out.println(inputTrainMaker);
                out.println(inputDate);
                out.println(inputCurrentStation);
                out.println(inputDestination);

                Commands.insertTrain(inputTrainName, inputCargo, inputSpeed, inputTrainMaker, inputDate, inputCurrentStation, inputDestination);

            } else if (userInput.equals("3")) {

                out.println("What is the name of the station?");
                String inputStationName = userScan.nextLine();
                Commands.insertStation(inputStationName);

            } else if (userInput.equals("4")) {
                out.println("Something");
            } else {
                out.println("ERROR: NO COMMAND MATCHES WITH " + userInput);
            }
        }
    }
}
