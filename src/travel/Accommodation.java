package travel;

import java.util.Objects;

public abstract class Accommodation {

    private String accommodationId;
    private String name;
    private String location;
    private double pricePerNight;

    private static int idCounter = 4001;

    public Accommodation() {
        this.accommodationId = "A" + idCounter;
        idCounter++;

        this.name = "";
        this.location = "";
        this.pricePerNight = 0.0;
    }

    public Accommodation(String name, String location, double pricePerNight) {

        this.accommodationId = "A" + idCounter;
        idCounter++;

        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }

    public Accommodation(Accommodation other) {

        this.accommodationId = "A" + idCounter;
        idCounter++;

        this.name = other.name;
        this.location = other.location;
        this.pricePerNight = other.pricePerNight;
    }

    public String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "ID: " + accommodationId +
                ", Name: " + name +
                ", Location: " + location +
                ", Rate: $" + pricePerNight + "/night";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation other = (Accommodation) o;
        return Double.compare(pricePerNight, other.pricePerNight) == 0
                && Objects.equals(name, other.name)
                && Objects.equals(location, other.location);
    }

    public abstract double calculateCost(int numberOfDays);


}
