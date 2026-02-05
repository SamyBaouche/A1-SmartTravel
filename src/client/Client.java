package client;

import java.util.Objects;

public class Client {

    private String clientId;
    private String firstName;
    private String lastName;
    private String email;

    private static int idCounter = 1001;


    public Client() {
        this.clientId = "C" + idCounter;
        idCounter++;

        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    public Client(String firstName,
                  String lastName, String email) {

        this.clientId = "C" + idCounter;
        idCounter++;

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Client (Client other) {
        this.clientId = "C" + idCounter;
        idCounter++;

        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.email = other.email;

    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client Info: " +
                "[ID: " + clientId +
                ", Name: " + firstName + " " + lastName +
                ", Email: " + email + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client other = (Client) o;
        return Objects.equals(clientId, other.clientId) &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(email, other.email);
    }


}

