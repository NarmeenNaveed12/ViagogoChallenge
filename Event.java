import java.util.Random;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
public class Event{
			 
	static int uniqueId = 0;
	int counter = 0;

	int MIN = 0, MAX = 3; 
  	static int ticketQuant = 0 ;
  	int counter1 = 0;

public Event(){
  uniqueId++;
  counter  = uniqueId;

  ticketQuant = ((int)(Math.random() * (MAX + 1 - MIN))) + MIN; //to get random order of ticketno
  counter1 = ticketQuant;
}


}















































// 		 public int meth(){
	     
//          List<Integer> listing = new ArrayList<Integer>();
//          int minT ;
//         for(int i = 0; i<3; i++){
//         t1 = new Ticket();
//         System.out.println( "Ticket countsssss " + Ticket.getTicketCount( ) );    
//         System.out.println( t1.getticket() );
//         listing.add(t1.getPrice());
//         System.out.println("Ticket price" + listing);

// //        System.out.println("Ticket price" + t1.getPrice());
//    }

//         minT = Collections.min(listing);
//         System.out.println("Ticket price" + minT);
//         return minT;
// }












// 	 static int uniqueId = 0;
// 	 int counter = 0;
// 	 Ticket t1;

// 	//int MIN = 0, MAX = 3; //for tick numbers
//      static int ticketQuant ;//ticket quantity
   

// public Event(){
// uniqueId++;
// counter  = uniqueId;

// //ticketQuant = ((int)(Math.random() * (MAX + 1 - MIN))) + MIN; //to get random order of ticketno

// }

// public static void getTickets(){
// for(int i = 0; i<3; i++){
// 	 t1 = new Ticket();
//      ticketQuant = ((int)(Math.random() * (3 + 1 - 0))) + 0;
    
//  }
//  System.out.println(ticketQuant);
// }


