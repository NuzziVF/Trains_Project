package org.trains;

import java.sql.Connection;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

// todo: Need to add
        //  -Add a new Train
        //  -Add a new Station
        //  -Change Trains Destination
        //  -Read info on Trains in Station
        // todo: -Read info on selected train
public class Main {
    public static void main(String[] args) {
        Scanner userScan = new Scanner(in);

        while (true) {
            out.println("What would you like to do?");
            String userInput = userScan.nextLine().toLowerCase();
            if (userInput.equals("station details")) {
                out.println("What station would you like the details of?");
                String userChoice = userScan.nextLine();
                Commands.trainsInStation(userChoice);
            } else if (userInput.equals("create train")) {
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

                out.println("What Station is the train at?");
                String inputCurrentStation = userScan.nextLine();

                out.println("Where is it going?");
                String inputDestination = userScan.nextLine();

                Commands.insertTrain(inputTrainName, inputCargo, inputSpeed, inputTrainMaker, inputDate, inputCurrentStation, inputDestination);

            } else if (userInput.equals("create station")) {

                out.println("What is the name of the station?");
                String inputStationName = userScan.nextLine();
                Commands.insertStation(inputStationName);

            } else if (userInput.equals("view all trains")) {

                Commands.viewAllTrains();

            } else if (userInput.equals("view all stations")) {

                Commands.viewAllStation();

            } else if (userInput.equals("alter destination")) {

                out.println("What Train?");
                String inputTrain = userScan.nextLine();

                out.println("What Station?");
                String inputStation = userScan.nextLine();

                Commands.alterDestination(inputTrain, inputStation);

            } else if (userInput.equals("train details")) {

                out.println("What Train?");
                String inputTrain = userScan.nextLine();

                Commands.viewInfoTrain(inputTrain);
            } else if (userInput.equals("go")){

            }else if (userInput.equals("help")){
                out.println("\"station details\" is to view the details of a single station");
                out.println("\"view all stations\" is to view the details of all stations");
                out.println("\"train detail\" is to view the details of a single train");
                out.println("\"view all trains\" is to view the details of all trains");
                out.println("\"create station\" is to create a station");
                out.println("\"create train\" is to create a train");
                out.println("\"alter destination\" is to change the destination of a train");
                out.println("\"go\" is to move a train");


            } else {
                out.println("ERROR: NO COMMAND MATCHES WITH " + userInput);
                out.println("Please type \"help\" for function names");
            }
        }
    }
}
