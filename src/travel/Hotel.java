package travel;

import java.util.Objects;

public class Hotel extends Accommodation {

    private int starRating;

    public Hotel() {
        super();
        this.starRating = 0;
    }

    public Hotel(String name, String location, double pricePerNight, int starRating) {
        super(name, location, pricePerNight);
        this.starRating = starRating;
    }

    public Hotel(Hotel other) {
        super(other);
        this.starRating = other.starRating;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    @Override
    public String toString() {
        return "Hotel [" + super.toString() +
                ", Stars: " + starRating + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hotel other = (Hotel) o;
        return starRating == other.starRating;
    }

    //Calculates using the pricePerNight and the numberOfDays
    @Override
    public double calculateCost(int numberOfDays) {
        return getPricePerNight() * numberOfDays;
    }
}
