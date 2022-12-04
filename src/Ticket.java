public class Ticket {
    private String TicketID;
    private String user;
    private String desc;

    public Ticket() {
        this.TicketID = TicketID;
        this.user = user;
        this.desc = desc;
    }


    public String getTicketID() {
        return TicketID;
    }

    public void setTicketID(String TicketID) {
        this.TicketID = TicketID;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "TicketID='" + TicketID + '\'' +
                ", user='" + user + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}