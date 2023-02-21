package org.trains;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

// todo: Need to add
        //  -Add a new Train
        //  -Add a new Station
        //  -Change Trains Destination
        //  -Read info on Trains in Station
        //  -Read info on selected train
public class Main {
    public static void main(String[] args) {
        Scanner userScan = new Scanner(in);
        boolean whileVariable = true;

        while (whileVariable) {
            out.println("What would you like to do?");
            String userInput = userScan.nextLine().toLowerCase();
            switch (userInput) {
                case "view all trains" -> Commands.viewAllTrains();
                case "view all stations" -> Commands.viewAllStation();
                case "train details" -> {

                    out.println("What Train?");
                    String inputTrain = userScan.nextLine();

                    Commands.viewInfoTrain(inputTrain);
                }
                case "station details" -> {
                    out.println("What station would you like the details of?");
                    String userChoice = userScan.nextLine();
                    Commands.trainsInStation(userChoice);
                }
                case "alter destination" -> {

                    out.println("What Train?");
                    String inputTrain = userScan.nextLine();

                    out.println("What Station?");
                    String inputStation = userScan.nextLine();

                    Commands.alterDestination(inputTrain, inputStation);

                }
                case "create train" -> {
                    out.println("What is the new train's name?");
                    String inputTrainName = userScan.nextLine();
                    out.println("What is the new trains cargo?");
                    String inputCargo = userScan.nextLine();
                    out.println("How fast is the new train?");
                    int inputSpeed = Integer.parseInt(userScan.nextLine());
                    out.println("Who is the new train's maker?");
                    String inputTrainMaker = userScan.nextLine();
                    out.println("What is the production year of the train?");
                    String inputYear = userScan.nextLine();
                    out.println("What is the production month of the train?");
                    String inputMonth = userScan.nextLine();
                    if (inputMonth.length() == 1) inputMonth = "0" + inputMonth;
                    out.println("What is the production day of the train?");
                    String inputDay = userScan.nextLine();
                    if (inputDay.length() == 1) inputDay = "0" + inputDay;
                    String inputDate = inputYear + "-" + inputMonth + "-" + inputDay;
                    out.println("What Station is the train at?");
                    String inputCurrentStation = userScan.nextLine();
                    out.println("What station is this train going to?");
                    String inputDestination = userScan.nextLine();
                    Commands.insertTrain(inputTrainName, inputCargo, inputSpeed, inputTrainMaker, inputDate, inputCurrentStation, inputDestination);
                }
                case "create station" -> {
                    out.println("What is the name of the station?");
                    String inputStationName = userScan.nextLine();
                    Commands.insertStation(inputStationName);
                }
                case "progress time" -> Commands.goMethod();
                case "help" -> {
                    out.println("\"View All Trains\" is to view the details of all trains");
                    out.println("\"View All Stations\" is to view the details of all stations");
                    out.println("\"Train Details\" is to view the details of a single train");
                    out.println("\"Station Details\" is to view the details of a single station");
                    out.println("\"Alter Destination\" is to change the destination of a train");
                    out.println("\"Create Train\" is to create a train");
                    out.println("\"Create Station\" is to create a station");
                    out.println("\"Progress Time\" is to move a train");
                    out.println("\"help\" shows all commands");
                    out.println("\"/q\" quits out of the program");
                }
                case "/q" -> {whileVariable = false;}
                default -> {
                    out.println("ERROR: NO COMMAND MATCHES WITH " + userInput);
                    out.println("Please type \"help\" for function names");
                }
            }
        }
    }
}
