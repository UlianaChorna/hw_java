package exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManager {
    private final List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(String username, String email) throws DuplicateUsernameException, InvalidDataException {
        if (username == null || username.isEmpty() || email == null || email.isEmpty()) {
            throw new InvalidDataException();
        }

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                throw new DuplicateUsernameException(username);
            }
        }

        User newUser = new User(username, email);
        users.add(newUser);
    }

    public void deleteUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }

    public void changeUserBlockingStatus(String username) {
        User user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
        if (user == null) {
            return;
        }

        user.setBlocked(!user.isBlocked());
    }

    public static void main(String[] args) {
        UserManager userManager = new UserManager();


        try {
            userManager.addUser("user1", "user1@example.com");
            userManager.addUser("user2", "user2@example.com");
            userManager.changeUserBlockingStatus("user1");
            System.out.println(userManager.users);
            userManager.addUser("user1", "user3@example.com");
        } catch (DuplicateUsernameException | InvalidDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        userManager.deleteUser("user2");

    }
}
