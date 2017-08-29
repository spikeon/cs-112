public class User {
    private String username;
    private String password;
    private String email;

    public User(String u, String p, String e) {
        username = u;
        password = p;
        email = e;
    }

    public boolean changePassword(String new_password) {
        boolean success = false;
        if (new_password.length() >= 6) {
            password = new_password;
            success = true;
        }
        return success;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}