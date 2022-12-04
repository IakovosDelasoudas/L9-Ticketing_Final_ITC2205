public class Ticket {
    private String number;
    private String user;
    private String desc;

    public Ticket(String number, String user, String desc) {
        this.number = number;
        this.user = user;
        this.desc = desc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
