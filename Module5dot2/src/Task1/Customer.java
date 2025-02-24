package Task1;

public class Customer {
    static private int id = 1;
    private int customerid;

    public Customer() {
        this.customerid = id;
        id++;
    }

    public int getCustomerid() {
        return customerid;
    }
}
