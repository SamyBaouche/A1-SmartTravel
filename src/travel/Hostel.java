package travel;

import java.util.Objects;

public class Hostel extends Accommodation {

    private int sharedBeds;

    public Hostel() {
        super();
        this.sharedBeds = 0;
    }

    public Hostel(String name, String location, double pricePerNight, int sharedBeds) {
        super(name, location, pricePerNight);
        this.sharedBeds = sharedBeds;
    }

    public Hostel(Hostel other) {
        super(other);
        this.sharedBeds = other.sharedBeds;
    }

    public int getSharedBeds() {
        return sharedBeds;
    }

    public void setSharedBeds(int sharedBeds) {
        this.sharedBeds = sharedBeds;
    }

    @Override
    public String toString() {
        return "Hostel [" + super.toString() +
                ", Shared Beds: " + sharedBeds + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Hostel other = (Hostel) o;
        return sharedBeds == other.sharedBeds;
    }

    //Same calcul as the hotel but divided by the number of shared beds
    @Override
    public double calculateCost(int numberOfDays) {
        return (getPricePerNight() * numberOfDays) / sharedBeds;
    }
}
