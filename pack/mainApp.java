

public class mainApp {
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