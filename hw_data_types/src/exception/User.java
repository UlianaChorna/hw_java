package exception;

public class User {
    private String username;
    private String email;
    private boolean isBlocked;

        public User(String username, String email) {
            this.username = username;
            this.email = email;
            this.isBlocked = false;
        }

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isBlocked() {
            return isBlocked;
        }

        public void setBlocked(boolean blocked) {
            isBlocked = blocked;
        }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
