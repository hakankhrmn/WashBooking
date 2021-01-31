import java.util.HashMap;
import java.util.Map;

public class Main {
    // Admin account
    static String adminname = "admin"; // Use for static input
    static String adminpassword = "123"; // Use for static input
    static Technic admin = new Technic(adminname,adminpassword);
    // For reservation
    static Reservation reserve = new Reservation();
    // Guest account
    static Client guest=new Client();
    // User account
    static String name="Utku"; // Use for static input
    static String password="secret321"; // Use for static input
    static Client client=new Client(name,password);
    // For facility owner

    static String ownername = "owner"; // Use for static input
    static String ownerpassword = "12345"; // Use for static input
    static Facility owner = new Facility(ownername,ownerpassword);

    static Map<Integer,Integer> availableDays=new HashMap<>();
    //If 1, it is busy day

    public static void delay(){  // For demo program, use with simulation. Provides static inputs more efficiently.
        try {
            Thread.sleep(1800); // Each input delays 1.8 seconds.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void setCarCityDate(Client user) // Set info's.
    {
        int cityno,cartype,datetype;
        System.out.println("\nPlease enter your city");
        System.out.print("1 to Ankara, 2 to Istanbul,3 to Balıkesir, 4 to Izmir ,5 to Bursa,6 to Eskisehir:  ");
        // Scanner input = new Scanner();
        // cityno = input.nextInt();
        cityno = 1;
        delay();
        System.out.println("1");  // As if user enter 1 for simulation

        System.out.println("\nPlease enter your car type");
        System.out.print("1 to Renault, 2 to Fiat, 3 to Mercedes,4 to BMW ,5 to Toyota, 6 to Nissan: ");
        // cartype = input.nextInt();
        cartype = 2;
        delay();
        System.out.println("2"); // As if user enter 2 for simulation
        user.setInfo(cityno,cartype);  // This info's send to the Client class via user object
        int count=0;

        while (true){

            System.out.println("\nPlease enter date ");
            System.out.println("1 to Monday: "+isavailable(1));
            System.out.println("2 to Tuesday: "+isavailable(2));
            System.out.println("3 to Wednesday: "+isavailable(3));
            System.out.println("4 to Thursday: "+isavailable(4));
            System.out.println("5 to Friday: "+isavailable(5));
            System.out.println("6 to Saturday: "+isavailable(6));
            System.out.println("7 to Sunday: "+isavailable(7));
            delay();

            if(count==0){ // to testing input busy day and get error message
                datetype = 3; // As if user input 3  ( Wednesday )
                delay();
                System.out.println(datetype);
                user.SetDate(datetype);
                delay();
                owner.getErrorMessage();
                count++;
            }else if(count==1){
                for(int i=1;i<8;i++){
                    datetype = i;
                    if (availableDays.get(datetype)!=1){
                        delay();
                        System.out.println(datetype);
                        user.SetDate(datetype);
                        availableDays.replace(datetype,1); // This day is not available now
                        break;
                    }
                }
                break;
            }
        }
    }

    public static String isavailable(int d){ // Check available day
        if(availableDays.get(d)==1){
            return "Busy";
        }else if (availableDays.get(d)==0){
            return "Available";
        }
        return null;
    }

    public static void adminmenu() // For admin menu, can get reports and solve the reports.
    {
        System.out.println("***********************************");
        admin.getReports(); // Reports are printed to the screen
        System.out.println("Enter problem index to solve");
        delay();
        System.out.println("1");
        admin.solveReports(1); // As if admin selects first report for simulation
    }

    public static void sendReport() // User send the report from this method
    {
        String report;
        System.out.print("Please write your problem : ");
        // Scanner input = new Scanner(System.in);
        // report = input.nextLine();
        delay();
        report = "I have a problem with login "; // For static input, this report will be written by simulation
        delay();
        System.out.println(report);
        admin.reportlist.add(report); // Report is added
        System.out.println("Your report has been succesfully send");
    }

    public static void main(String[] args) {
        //For initializations
        Accounts accounts=new Accounts();
        accounts.Register(admin);  // Register admin to the system.
        accounts.Register(owner);  // Register owner to the system.

        for (int option=1;option<7;option++) { // Main menu, all cases will be tested.
            delay();
            System.out.println("\n---------WASH BOOKING---------");
            System.out.println("1- Enter 1 to go facility account");
            System.out.println("2- Enter 2 to visit with Guest account");
            System.out.println("3- Enter 3 to Register");
            System.out.println("4- Enter 4 to Log In");
            System.out.println("5- Enter 5 to Send Report");
            System.out.println("6- Enter 6 to Admin Log In");
            System.out.println("\n*******************************************************\n");

            if (option == 1){ // Facility Menu
                delay();
                System.out.println(option);
                System.out.println("Welcome to the facility menu");
                Facility person;
                System.out.print("Username : ");
                delay();
                System.out.println(ownername); // As if user enter ownername for simulation ( owner )
                System.out.print("Password : ");
                delay();
                System.out.println(ownerpassword); // As if user enter ownerpassword for simulation ( 12345 )
                person=(Facility) accounts.Login(ownername, ownerpassword); // Object is implemented
                if (person != null) // If name and password is available in accountlist,this statement will be work
                {
                    System.out.print("Press 5 to send available days to the system: ");
                    delay();
                    System.out.println(5);
                    owner.tickTheBusyDays();
                    availableDays=owner.sendAvailableDays();
                    delay();
                    System.out.println("Available days are sent to the system");
                }
                else{ // If there is logging error, this statement will be work
                    delay();
                    System.out.println("There is a problem with logging, please try again.\nReturning to the main menu");
                }
                delay();

            }else if (option == 2) { // Guest Menu
                delay();
                System.out.println(option);
                System.out.println("Welcome to the guest account");
                setCarCityDate(guest); // Set Car type, City and Date for guest
                reserve.makeReservation(guest); // Make reservation with guest's selections
                reserve.getReservation(); // Display the reservation
            }
            else if (option == 3) { // Register Menu
                delay();
                System.out.println(option);
                System.out.println("Welcome to the register menu");
                System.out.print("Username : ");
                delay();
                System.out.println(name); // As if user enter name for simulation (Utku)
                System.out.print("Password : ");
                delay();
                System.out.println(password); // As if user enter password for simulation (secret123)
                System.out.print("Confirm Password : ");
                delay();
                System.out.println(password);
                delay();
                accounts.Register(client); // To register to new user
            }
            else if (option == 4) { // Login Menu
                delay();
                System.out.println(option);
                System.out.println("Welcome to the login menu");
                Client currentClient;
                for (int i=0;i<2;i++){ // For simulation testing, this iteration will be causes for wrong password
                    // Then work with true password
                    password = "secret321";
                    if(i==0){
                        password="secret123";        //Wrong password
                    }
                    System.out.print("Username : ");
                    delay();
                    System.out.println(name); // As if user enter name for simulation
                    System.out.print("Password : ");
                    delay();
                    System.out.println(password); // As if user enter password for simulation (secret123 for first, then secret321)
                    currentClient=(Client) accounts.Login(name,password);
                    if (currentClient != null) // If name and password is available in accountlist,this statement will be work
                    {
                        setCarCityDate(currentClient);
                        reserve.makeReservation(currentClient);
                        reserve.getReservation();
                        owner.getConfirmMessage();
                    }
                    else{ // If there is logging error, this statement will be work
                        delay();
                    }
                }
            }
            else if (option == 5) // Report menu
            {
                delay();
                System.out.println(option);
                sendReport();
            }
            else if (option == 6) // Admin Menu
            {
                delay();
                System.out.println(option);
                System.out.println("Welcome to the admin menu");
                Technic person;
                System.out.print("Username : ");
                delay();
                System.out.println(adminname); // As if user enter adminname for simulation (admin)
                System.out.print("Password : ");
                delay();
                System.out.println(adminpassword); // As if user enter adminpassword for simulation (123)
                person=(Technic) accounts.Login(adminname,adminpassword); // Datas send to the login method
                if (person != null) // If name and password is available in accountlist,this statement will be work
                {
                    adminmenu(); // Reach the admin menu
                }
                else{ // If there is logging error, this statement will be work
                    delay();
                    System.out.println("There is a problem with logging, please try again.\nReturning to the main menu");
                }
                delay();
            }
        }
    }
}



