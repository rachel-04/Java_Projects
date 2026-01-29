/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;

    private static int nextNumber = 1;

    public Ticket(Passenger p, Flight flight, double price) {
        this.passenger = p;
        this.flight = flight;
        this.price = price;
        this.number = nextNumber++;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Ticket " + number + ": " 
                + passenger.getName() + ", " 
                + flight.toString() 
                + ", ticket price: $" + String.format("%.2f", price);
    }
}
