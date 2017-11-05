
import java.util.Random;
import java.util.*;
import java.util.List;

public class Ticket {
    double price;
    final double MIN = 1, MAX = 100; 
    Random random=new Random();
  /**
  1.Generating random numbers for price here
  **/
    public Ticket(){
        price = ((double)(Math.random() * (MAX + 1 - MIN))) + MIN;
    }

    public double getPrice(){
      	return price;
    }
     public String toString()
    {
        return getPrice();
    }

}
