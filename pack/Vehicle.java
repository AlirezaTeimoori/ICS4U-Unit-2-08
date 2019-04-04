
//---------------------------------------
//-- Created by:     Alireza Teimoori  --
//-- Created on:     Apr 02 2019       --
//-- Created for:    Unit 2-08         --
//-- Course Code:    ICS4U             --
//-- Teacher Name:   Chris Atkinson    --
//---------------------------------------
//-- This program creates a class      --
//-- vehicle and some child classes    --
//---------------------------------------

import java.util.*;

public class Vehicle {

    protected  Scanner scanner = new Scanner(System.in);
    // Intro fields
    private Integer       licensePlateNumber;
    private String        colour;
    private Integer       numberOfDoors;
    private Integer       speed;
    private Integer       maxSpeed;

    // Constructor
    // public Vehicle (int licensePlateNumber, String colour, Integer numberOfDoors, Integer speed, Integer maxSpeed) {

    //     this.licensePlateNumber = licensePlateNumber;
    //     this.colour             = colour;
    //     this.numberOfDoors      = numberOfDoors;
    //     this.speed              = speed;
    //     this.maxSpeed           = maxSpeed;

    // }

    // create() function creates Vehicles and adds them to an ArrayList and returns it:
    protected ArrayList<Vehicle> create(Scanner scanner) { // scanner gets imported to the function from the main method

        // Ask for and store data:
        System.out.println("How many vehicles do you want to create?");
        int howMany = scanner.nextInt();

        // Create an ArrayList of type Vehicle:
        ArrayList<Vehicle> list = new ArrayList<Vehicle>();

        // For how many Vehicles the user wants to create:
        for (int counter = 0; counter < howMany; counter ++) {

            // OUTPUT:
            System.out.println("\n\n===================================");
            System.out.println("===\tCreating Vehicle #" + (counter + 1) + "\t===\n");
            
            // Create a new Vehicle:
            Vehicle vehicle = new Vehicle();
            // Get the info and modify the fields:
            vehicle.getInfo();

            // Add the Vehicle to the list of Vehicles:
            list.add(vehicle);
        }

        // For how many Vehicles are created:
        for (int count = 0; count < howMany; count ++) {

            // OUTPUT:
            System.out.println("\n\n===================================");
            System.out.println("======\t     Vehicle #" + (count + 1) + "      ======\n");

            // Run toString() function to print the vehicle information for each vehicle
            list.get(count).toString();
            System.out.println("\n===================================");

        }
        
        // return the list of Vehicles:
        return list;
    }

    // accelerate() function changes the speed and adds 20 to it until the speed reaches the max:
    protected void accelerate(ArrayList<Vehicle> list, Scanner scanner) {

        // INPUT -- Ask for and store data (user is choosing a car number):
        System.out.println("For which vehicle?");
        int vNumber = scanner.nextInt();

        // PROCESS
        // Add 20 to the speed of the chosen car:
        list.get(vNumber).speed += 20;
        // If the speed is bigger than the max possible, assign speed to max speed:
        list.get(vNumber).speed = list.get(vNumber).speed > list.get(vNumber).maxSpeed ? list.get(vNumber).maxSpeed : list.get(vNumber).speed;

        // OUTPUT:
        System.out.println("Speeding up!");
        System.out.println(list.get(vNumber));
    }

    // brake() function reduces the speed all the way to 0:
    protected void brake(ArrayList<Vehicle> list, Scanner scanner) {

        // INPUT -- Ask for and store data (the user is choosing a car number):
        System.out.println("For which vehicle?");
        int vNumber = scanner.nextInt();

        // PROCESS
        // Change the speed of the chosen car to 0:
        list.get(vNumber).speed = 0;

        // OUTPUT:
        System.out.println("Brake!");
        System.out.println(list.get(vNumber));

    }

    protected void setSpeed(int speedToSet) {

        this.speed = speedToSet;
    }

    // getInfo() function recieves all the information from the user and assigns them to the appropriate field:
    public void getInfo() {
        
        // Ask for and store data in appropriate field:
        System.out.println("Enter vehicle licence plate number:");
        this.licensePlateNumber = scanner.nextInt();
        System.out.println("Enter vehicle colour:");
        this.colour = scanner.next();
        System.out.println("Enter vehicle number of doors: ");
        this.numberOfDoors = scanner.nextInt();
        System.out.println("Enter vehicle speed:");
        this.speed = scanner.nextInt();
        System.out.println("Enter vehicle max speed: ");
        this.maxSpeed = scanner.nextInt();

    }

    public String toString() {
        
        // OUTPUT -- Print all the fields in an organized way: 
        System.out.println("===\tLicence Plate:\t" + this.licensePlateNumber + "\t===" );
        System.out.println("===\tColour:\t\t" + this.colour + "\t===" );
        System.out.println("===\tDoors:\t\t" + this.numberOfDoors  + "\t===");
        System.out.println("===\tSpeed:\t\t" + this.speed + "\t===" );
        System.out.println("===\tMaximum Speed:\t" + this.maxSpeed + "\t===" );

        // You have to return a string with thie function otherwise it won't let you to override it.
        return "";
    
    }

    // main() function:
    public static void main(String[] args) {
        
        // Bring in the instances:
        Scanner scanner = new Scanner(System.in);
        Vehicle v = new Vehicle();

        // Create the trigger for the while loop:
        boolean run = true;

        // Create an empty list of Vehicles:
        ArrayList<Vehicle> list = null;

        // As long as the button is ON run this loop:
        while (run) {

            // Ask for and store data:
            System.out.println("What do you want to do? ( C = Create, A = Accelerate, B = Brake, E = Exit ) ");
            String response = scanner.nextLine();


            switch (response) {
                // Create a vehicle if they type "C":
                case "C":
                    list = v.create(scanner);
                    break;
            
                // Run the accelerate() function if they type "A":
                case "A":
                    v.accelerate(list, scanner);
                    break;
                    
                // Run brake() funvtion if they type "B":
                case "B":
                    v.brake(list, scanner);
                    break;
                
                // Turn off the while loop if they type "E":
                case "E":
                    run = false;

                //System.out.println(run);
            }

        }

        scanner.close();
    }
}