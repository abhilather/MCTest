package core.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String emailId;
    private List<String> deviceIds;

    public User(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.deviceIds = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUserDetails() {
        return "firstName = " + this.firstName + ", lastName = " + this.lastName + ", emailId = " + this.emailId;
    }

    public List<String> getDeviceIds() {
        return this.deviceIds;
    }

    public void setDeviceIds(List<String> deviceIds) {
        this.deviceIds = deviceIds;
    }
}
