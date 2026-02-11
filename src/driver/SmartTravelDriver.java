package driver;

import client.Client;
import travel.*;

import java.util.Scanner;

public class SmartTravelDriver {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to SmartTravelPlanner by: \n" +
                "   Mohammed El Ouaabani and Samy Baouche \n");

        System.out.print("What would you like to access: \n" +
                "   1- menu-driven interface \n" +
                "   2- predefined testing scenario \n" +
                "Enter your choice > ");

        int optionChoice = sc.nextInt();

        switch (optionChoice) {

            //Menu driven interface
            case 1 -> {

                Client[] clients = new Client[0];
                Transportation[] transportations = new Transportation[0];
                Accommodation[] accommodations = new Accommodation[0];
                Trip[] trips = new Trip[0];

                int choiceMenu = mainMenu();

                switch (choiceMenu) {
                    case 1 -> {
                        int choice;
                        do {
                            System.out.println("-- Client Management --\n");
                            System.out.println("1. Add a client\n" +
                                    "2. Edit a client\n" +
                                    "3. Delete a client\n" +
                                    "4. List all clients\n" +
                                    "0. Exit to main menu");

                            choice = sc.nextInt();
                        } while (choice < 0 || choice > 4);

                        switch (choice) {
                            case 1 -> {
                                System.out.print("Enter client First Name: ");
                                String firstName = sc.nextLine();
                                System.out.println("Enter client Last Name: ");
                                String lastName = sc.nextLine();
                                System.out.println("Enter client email: ");
                                String email = sc.nextLine();

                                Client client = new Client(firstName, lastName, email);

                                Client[] clientProcess = new Client[clients.length + 1];

                                if (clients.length > 0) {
                                    for (int i = 0; i < clients.length; i++) {
                                        clientProcess[i] = clients[i];
                                    }
                                }

                                clientProcess[clientProcess.length - 1] = client;
                                clients = clientProcess;

                                mainMenu();
                            }

                            case 2 -> {
                                System.out.println("");
                            }


                        }
                    }
                }

            }

            //Predefined testing scenario
            case 2 -> {

                System.out.println("\n      1. Creating... \n" +
                        "- 3 Clients \n" +
                        "- 3 Trips \n" +
                        "- 2 Objects of each Transportation Type \n" +
                        "- 2 Objects of each Accomodation Type");

                //3 Clients
                Client client1 = new Client("Jacob", "Delaire", "jacob.delaire@gmail.com");
                Client client2 = new Client("Nathan", "Blo", "nathan.blo@gmail.com");
                Client client3 = new Client("Mohammed", "Baouche", "mohammed.baouche@gmail.com");

                //2 Flights
                Flight flight1 = new Flight("Air Transat", "Montreal", "Fort Laudertale", 22);
                Flight flight2 = new Flight("Air Canada", "Montreal", "Barcelona", 22);

                //2 Buses
                Bus bus1 = new Bus("Chartrand", "Fort Laudertale", "Miami", 30);
                Bus bus2 = new Bus("Irizar", "Barcelona", "Marbella", 12);

                //2 Trains
                Train train1 = new Train("Trans-Canada", "Montreal", "Vancouver", "TGV", "First Class");
                Train train2 = new Train("Trans-Canada", "Montreal", "Vancouver", "TGV", "First Class");

                //2 Hotels
                Hotel hotel1 = new Hotel("Marriott", "Barcelona", 100, 4);
                Hotel hotel2 = new Hotel("Hilton", "Miami", 65, 3);

                //2 Hostels
                Hostel hostel1 = new Hostel("SleepInPeace", "Vancouver", 90, 3);
                Hostel hostel2 = new Hostel("SleepInPeace", "Vancouver", 90, 3);

                //3 Trips
                Trip trip1 = new Trip("Vancouver", 14, 600, client1, hostel1, train1);
                Trip trip2 = new Trip("Miami", 10, 400, client2, hotel2, bus1);
                Trip trip3 = new Trip("Barcelona", 21, 900, client3, hotel1, flight2);

                    //Arrays for objects

                //Clients Array (for 3 clients)
                Client[] clients = {client1, client2, client3};

                //Trips Array
                Trip[] trips = {trip1, trip2, trip3};

                //Transportation Array
                Transportation[] transportations = {train1, train2, bus1, bus2, flight1, flight2};

                //Accomodation Array
                Accommodation[] accommodations = {hotel1, hotel2, hostel1, hostel2};

                System.out.println("\n      2. Display all created objects\n");

                System.out.println("Clients:");
                for (Client client: clients) {
                    System.out.println("    " + client);
                }

                System.out.println("\nTrips:");
                for (Trip trip: trips) {
                    System.out.println("    " + trip);
                }

                System.out.println("\nTransportation Options:");
                for (Transportation transportation: transportations) {
                    System.out.println("    " + transportation);
                }

                System.out.println("\nAccomodations");
                for (Accommodation accommodation: accommodations) {
                    System.out.println("    " + accommodation);
                }

                System.out.println("\n      3. Test of the equals method:\n");
                System.out.println("-- Equals of a Flight and a Train");
                System.out.println(flight1.equals(train1));
                System.out.println("-- Equals of two Hotels (Different attributes)");
                System.out.println(hotel1.equals(hotel2));
                System.out.println("-- Equals of two Trains (Identical attributes)");
                System.out.println(train1.equals(train2));

                System.out.println("\n      4. Cost of the Trips\n");
                for (Trip trip: trips) {
                    System.out.println(trip.getTripId() + ": " + trip.calculateTotalCost() + "$");
                }

                System.out.println("\n      5. Most expensive Trip\n" );
                mostExpensiveTrip(trips);

                System.out.println("\n      6. Deep copie of the Transportation Array\n");

                System.out.println("Making the deep copy...\n");
                Transportation[] transportationsCopy = copyTransportationArray(transportations);

                System.out.println("-- Displaying both Arrays --\n");
                System.out.println("Original");
                for (Transportation transportation: transportations) {
                    System.out.println("    " + transportation);
                }

                System.out.println("\nCopy");
                for (Transportation transportation: transportationsCopy) {
                    System.out.println("    " + transportation);
                }

                System.out.println("\nModify the copy Array...\n");
                transportationsCopy[0].setCompanyName("Unknown Company");

                System.out.println("-- Display both Arrays AFTER MODIFICATION --\n");

                System.out.println("Original");
                for (Transportation transportation: transportations) {
                    System.out.println("    " + transportation);
                }

                System.out.println("\nCopy");
                for (Transportation transportation: transportationsCopy) {
                    System.out.println("    " + transportation);
                }
            }
        }

    }

    public static int mainMenu() {

        int choice;

        do {
            System.out.println("-- Choose one of the operations below -- ");
            System.out.println();
            System.out.println("1. Client Management");
            System.out.println("2. Trip Management");
            System.out.println("3. Transportation Management");
            System.out.println("4. Accomodation Management");

            choice = sc.nextInt();
        } while (choice < 1 || choice > 4);

        return choice;
    }

    public static void mostExpensiveTrip(Trip[] trips) {
        double topPrice = 0;

        Trip mostExpensiveTrip = new Trip();

        for (Trip trip: trips) {
            double costTrip = trip.calculateTotalCost();
            if (costTrip > topPrice) {
                topPrice = costTrip;
                mostExpensiveTrip = trip;
            }
        }

        System.out.println("The most expensive trip is: " + mostExpensiveTrip.getTripId());
    }

    public static Transportation[] copyTransportationArray(Transportation[] original) {
        Transportation[] copy = new Transportation[original.length];

        for (int i = 0; i < original.length; i++) {
            if (original[i] instanceof Flight) {
                copy[i] = new Flight((Flight) original[i]);
            } else if (original[i] instanceof Train) {
                copy[i] = new Train((Train) original[i]);
            } else if (original[i] instanceof Bus) {
                copy[i] = new Bus((Bus) original[i]);
            }
        }

        return copy;
    }
}
