import java.io.Serializable;

/**
 * Employee
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = -2102607440282014261L;

    public String name;
    public String address;
    public int number;
    public Employee(String name, String address, int number)
    {
       System.out.println("Constructing an Employee");
       this.name = name;
       this.address = address;
       this.number = number;
    }

    public Employee(){

    }

    public double computePay()
    {
      System.out.println("Inside Employee computePay");
      return 0.0;
    }
    public void mailCheck()
    {
       System.out.println("Mailing a check to " + this.name
        + " " + this.address);
    }
    public String toString()
    {
       return name + " " + address + " " + number;
    }
    public String getName()
    {
       return name;
    }
    public String getAddress()
    {
       return address;
    }
    public void setAddress(String newAddress)
    {
       address = newAddress;
    }
    public int getNumber()
    {
      return number;
    }
}