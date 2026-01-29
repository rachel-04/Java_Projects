package lab1;

import java.util.Scanner;

public class Manager {
    private Flight[] flights;
    private Ticket[] tickets;
    private int flightCount = 0;
    private int ticketCount = 0;

    public Manager(int maxFlights, int maxTickets) {
        flights = new Flight[maxFlights];
        tickets = new Ticket[maxTickets];
    }

    public void createFlights() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many flights do you want to create? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n && flightCount < flights.length; i++) {
            System.out.println("\n--- Enter flight " + (i + 1) + " ---");
            System.out.print("Flight number (int): ");
            int flightNumber = sc.nextInt();
            sc.nextLine();

            System.out.print("Origin: ");
            String origin = sc.nextLine().trim();

            System.out.print("Destination: ");
            String destination = sc.nextLine().trim();

            System.out.print("Departure time: ");
            String departureTime = sc.nextLine().trim();

            System.out.print("Capacity (int): ");
            int capacity = sc.nextInt();
            sc.nextLine();

            System.out.print("Original price (double): ");
            double price = sc.nextDouble();
            sc.nextLine();

            try {
                flights[flightCount++] = new Flight(flightNumber, origin, destination, departureTime, capacity, price);
                System.out.println("Flight created.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid flight (origin and destination cannot be same). Try again.");
                i--; 
            }
        }
    }

    public void displayAvailableFlights(String origin, String destination) {
        origin = origin.trim();
        destination = destination.trim();

        System.out.println("\nAvailable flights from " + origin + " to " + destination + ":");
        boolean found = false;

        for (int i = 0; i < flightCount; i++) {
            Flight f = flights[i];
            if (f.getOrigin().trim().equalsIgnoreCase(origin)
                    && f.getDestination().trim().equalsIgnoreCase(destination)
                    && f.getNumberOfSeatsLeft() > 0) {
                System.out.println(f);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available flights found.");
        }
    }

    public Flight getFlight(int flightNumber) {
        for (int i = 0; i < flightCount; i++) {
            if (flights[i].getFlightNumber() == flightNumber) {
                return flights[i];
            }
        }
        return null;
    }

    public void bookSeat(int flightNumber, Passenger p) {
        Flight f = getFlight(flightNumber);
        if (f == null) {
            System.out.println("Flight not found: " + flightNumber);
            return;
        }

        // Check ticket storage BEFORE taking a seat
        if (ticketCount >= tickets.length) {
            System.out.println("Ticket storage full. Cannot issue ticket.");
            return;
        }

        if (!f.bookASeat()) {
            System.out.println("Sorry, flight is fully booked.");
            return;
        }

        double finalPrice = p.applyDiscount(f.getOriginalPrice());
        Ticket t = new Ticket(p, f, finalPrice);
        tickets[ticketCount++] = t;

        System.out.println("Booking successful! Ticket issued:");
        System.out.println(t);
    }

    public static void main(String[] args) {
        Manager m = new Manager(50, 200);
        m.createFlights();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter origin to search: ");
        String origin = sc.nextLine().trim();
        System.out.print("Enter destination to search: ");
        String destination = sc.nextLine().trim();

        m.displayAvailableFlights(origin, destination);

        Passenger member = new Member("Rachel", 21, 6);
        Passenger nonMember = new NonMember("Grandma", 70);

        System.out.print("\nEnter a flight number to book for Member: ");
        int f1 = sc.nextInt();
        sc.nextLine();
        m.bookSeat(f1, member);

        System.out.print("\nEnter a flight number to book for NonMember: ");
        int f2 = sc.nextInt();
        sc.nextLine();
        m.bookSeat(f2, nonMember);

       
    }
}
