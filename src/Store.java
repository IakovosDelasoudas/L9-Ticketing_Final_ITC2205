import java.util.ArrayList;

public class Store {
    private final ArrayList<User> userList;
    private User currentUser;


    public Store()
    {
        userList = new ArrayList<>();
        userList.add(new User("Player", "Player123", User.Type.Player));
        userList.add(new User("Coach", "Coach123", User.Type.Coach));
    }

    public ArrayList<User> getUserList() {
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
