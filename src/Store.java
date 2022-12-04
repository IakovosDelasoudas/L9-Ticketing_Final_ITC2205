import java.util.ArrayList;

public class Store {
    private static ArrayList<User> userList;
    private User currentUser;

    public Store()
    {
        userList = new ArrayList<>();
        userList.add(new User("User", "User123", User.Type.User));
        userList.add(new User("Staff1", "Staff123", User.Type.Staff1));
        userList.add(new User("Staff2", "Staff321", User.Type.Staff2));
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public void setCurrentUser(User user)
    {
        this.currentUser = user;
    }

    public String getCurrentUserName()
    {
        return (currentUser!=null)?currentUser.getUsername():"No user selected";
    }

}
