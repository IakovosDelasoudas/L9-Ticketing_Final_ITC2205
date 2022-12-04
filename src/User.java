public class User {
    private String username;
    private String password;
    public enum Type {
        User, Staff1, Staff2,
    }
    private Type type;

    // CONSTRUCTOR
    public User(String username, String password, Type type) {
        if (username!=null && username.length()>=2)
        {
            this.username = username;
        }
        if (password!=null && password.length()>=2)
        {
            this.password = password;
        }
        this.type = type;
    }

    // GETTERS
    public String getUsername()
    {
        return username;
    }
    public Type getType() {
        return type;
    }

    /**
     * Checks a given string if it matches the password of the user
     * @param passwordGiven string to match password
     * @return true if password matches, false otherwise
     */
    public boolean authenticate(String passwordGiven)
    {
        return passwordGiven.equals(password);
    }
}
