package travel;

import java.util.Objects;

public class Train extends Transportation {

    private String trainType;
    private String seatClass;

    private final static double FIRST_CLASS_PRICE = 250;
    private final static double ECONOMY_PRICE = 75;

    public Train() {
        super();
        this.seatClass = "";
        this.trainType = "";
    }

    public Train(String companyName, String departureCity,
                 String arrivalCity, String trainType, String seatClass) {

        super(companyName, departureCity, arrivalCity);
        this.trainType = trainType;
        this.seatClass = seatClass;
    }

    public Train(Train other) {

        super(other);
        this.trainType = other.trainType;
        this.seatClass = other.seatClass;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    @Override
    public String toString() {
        return "Train [" + super.toString() +
                ", Type: " + trainType +
                ", Class: " + seatClass + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Train other = (Train) o;
        return Objects.equals(trainType, other.trainType) && Objects.equals(seatClass, other.seatClass);
    }

    @Override
    public double calculateCost(int numberOfDays) {

        double cost = 0;

        if (seatClass.equalsIgnoreCase("Economy")) {
            cost = ECONOMY_PRICE;
        } else if (seatClass.equalsIgnoreCase("First Class")) {
            cost = FIRST_CLASS_PRICE;
        }

        return cost;
    }
}
