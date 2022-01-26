package core.services;

import core.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserService {
    Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public String registerUser(User newUser) {
        if (this.users.containsKey(newUser.getEmailId())) {
            return "The user with email Id " + newUser.getEmailId() + " already exists.";
        } else {
            this.users.put(newUser.getEmailId(), newUser);
            return "User successfully registered with following details " + newUser.getUserDetails();
        }

    }

    public String updateUserInformation(User updatedUser) {
        if (!this.users.containsKey(updatedUser.getEmailId())) {
            return "The user with the given email id does not exist. Please provide a valid email id";
        } else {
            User userToUpdate = users.get(updatedUser.getEmailId());
            userToUpdate.setFirstName(updatedUser.getFirstName());
            userToUpdate.setLastName(updatedUser.getLastName());
            return "User information successfully updated. " + userToUpdate.getUserDetails();
        }
    }

    public String deleteRegisteredUser(String emailId) {
        if (!this.users.containsKey(emailId)) {
            return "The user with this email id is not registered";
        } else {
            this.users.remove(emailId);
            return "User successfully unregistered";
        }
    }

    public Set<String> getUserIds () {
        return this.users.keySet();
    }
}
