package Task1;

public class Theater {
    private int tickets;

    public Theater() {
        this.tickets = 30;
    }

    public synchronized void reserveTicket(Customer customer, int tickets) {
        if (this.tickets - tickets >= 0) {
            this.tickets -= tickets;
            System.out.println("Customer"+ customer.getCustomerid() + " reserved " + tickets + " tickets");
        } else {
            System.out.println("Customer"+ customer.getCustomerid() + " couldn't reserved " + tickets + " tickets");
        }
    }
}
