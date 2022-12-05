public class Ticket {
    private String TicketID;
    private String user;
    private String desc;

    public enum Type{
        Type1, Type2
    }
    private Type type;

    // CONSTRUCTORS
    public Ticket() {
        this.TicketID = TicketID;
        this.user = this.user;
        this.desc = this.desc;
    }
    public Ticket(String ticketID, String user, String desc, Type type) {
        this.user = user;
        this.desc = desc;
        this.type = type;
    }

    // GETTERS
    public String getTicketID() {
        return TicketID;
    }
    public String getDesc() {
        return desc;
    }
    public String getUser() {
        return user;
    }
    public Type getType() {
        return type;
    }

    // SETTERS
    public void setTicketID(String TicketID) {
        this.TicketID = TicketID;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setType(Type type) {
        this.type = type;
    }

    // TO-STRING METHOD
    @Override
    public String toString() {
        return TicketID + "*" + user + "*" + desc + "*" + type;
    }
}