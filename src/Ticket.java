public class Ticket {
    private static int count = 0;
    private String TicketID;
    private String user;
    private String desc;

    private boolean isFilled;

    public Ticket(String TicketID, String user, String desc) {
        this.TicketID = TicketID;
        this.user = user;
        this.desc = desc;
    }

    public Ticket(String title) {
        user = title;

        isFilled = false;
        setTicketID(++count);
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
}