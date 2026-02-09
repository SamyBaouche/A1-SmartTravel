package travel;

import java.util.Objects;

public class Bus extends Transportation {

    private String busCompany;
    private int numberOfStops;

    private final static double DAILY_PASS_PRICE = 5;
    private final static double DISCOUNT = 0.75;

    public Bus() {
        super();
        this.busCompany = "";
        this.numberOfStops = 0;
    }

    public Bus(String companyName, String departureCity,
               String arrivalCity, int numberOfStops) {

        super(companyName, departureCity, arrivalCity);
        this.numberOfStops = numberOfStops;
    }

    public Bus(Bus other) {
        super(other);
        this.busCompany = other.busCompany;
        this.numberOfStops = other.numberOfStops;
    }

    public String getBusCompany() {
        return busCompany;
    }

    public void setBusCompany(String busCompany) {
        this.busCompany = busCompany;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    @Override
    public String toString() {
        return "Bus [" + super.toString() +
                ", Operator: " + busCompany +
                ", Stops: " + numberOfStops + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus other = (Bus) o;
        return numberOfStops == other.numberOfStops && Objects.equals(busCompany, other.busCompany);
    }

    @Override
    public double calculateCost(int numberOfDays) {
        double cost = 0;

        if (numberOfDays > 30) {
            cost = numberOfDays * DAILY_PASS_PRICE * DISCOUNT;
        } else {
            cost = numberOfDays * DAILY_PASS_PRICE;
        }

        return cost;
    }
}
