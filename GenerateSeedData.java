import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.List;
import java.util.Collections;
import java.util.Map.Entry;
import static java.lang.Math.min;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class GenerateSeedData{

	Random rand = new Random(); 

	int xCoordinate;
	int yCoordinate;

	 Map<Pairs, Integer> map = new HashMap<Pairs, Integer>(); //map to hold all coordinates and their distances
	 Map<Pairs, Integer> eventMap = new HashMap<Pairs, Integer>(); //map to hold all cooridnates with their eventcount
	 Map<Pairs, Integer> filteredEvents = new HashMap<Pairs, Integer>();  //map to hold all coordinates with evencount 1
    	 Map<Integer, Integer> eventTicks = new HashMap<Integer, Integer>(); //map to hold all entries ID with the number of tickets
    	 Map<Integer, Integer> maps = new HashMap<>(); //map that holds eventIds and distnaces
     	 Map<Integer, Integer> amountTick= new HashMap<Integer, Integer>(); //map to hold eventID with their ticketQuantity
    	 Map<Integer, Double> amountID= new HashMap<Integer, Double>();//map to hold ticketID with cheapest price

    int minimum = 0;
    int maximum = 1;
    Event e;
    int distance;
   /**
    1. This method returns the 5 closest events with the cheapest tickets
   **/
    public void generateData(){ 
	
    	Scanner keyboard = new Scanner(System.in); 
        System.out.println("Please enter the X Coordinate followed by the return key");
        xCoordinate = keyboard.nextInt();
        System.out.println("Please enter the Y Coordinate followed by the return key");
        yCoordinate = keyboard.nextInt();
	    
	/** Range check for input **/
        if((xCoordinate >= -10 && xCoordinate <=10 ) && (yCoordinate >= -10 && yCoordinate <=10)) { 
        
	/**
	1.Calculating distance of each coordinate from input pair
	2.Putting Pairs and corr Distance in the map
	**/
    	for(int x1 = -10; x1 <= 10; x1++) {
	    	for(int y1 = -10; y1 <= 10; y1++) {
	    		distance = Math.abs(xCoordinate - x1) + Math.abs(yCoordinate-y1); 
	    		map.put(new Pairs(x1,y1),distance); 
	   	}
	}
    
        /**
        1. Setting a max of 1 event per coordinate
        **/
        Set<Entry<Pairs, Integer>> mapEntries = map.entrySet();
        for(Entry<Pairs, Integer> entry : mapEntries){ 
            for(int i = minimum; i< maximum; i++){
                eventMap.put(entry.getKey(),((int)(Math.random() * (maximum + 1 - minimum))) + minimum);
            }
        }

       /**
        1. Filtering all events with occurence 1
        2. Assigning all events with occurence 1 a unique event ID
        3. Assigning each event, ticket numbers
        **/
        Set<Entry<Pairs, Integer>> mapEvent = eventMap.entrySet(); 
        for(Entry<Pairs, Integer> entry1 : mapEvent){ 
            if (entry1.getValue() == 1) {
                e = new Event();
                filteredEvents.put(entry1.getKey(), e.counter); 
                amountTick.put(e.counter,e.counter1);
           } 
        }
         /**
        1. Returning a map with eventId and their corr distances
        **/
       Set<Pairs> commonKey = map.keySet();
       commonKey.retainAll(map.keySet());
       for (Pairs key: commonKey) {
            maps.put(filteredEvents.get(key),map.get(key));
        }

         /**
        1. Getting min priced ticket for each event that has a ticket count more than 0
        **/
        Set<Entry<Integer, Integer>> idTickno = amountTick.entrySet();
        for(Entry<Integer, Integer> entry5 : idTickno) { 
            Double minT = Double.POSITIVE_INFINITY;
            if(entry5.getValue() > 0) {
                for(int i = 0; i<entry5.getValue(); i++) {
                    Ticket ticket = new Ticket();
                    if(ticket.getPrice()<minT)
                        minT = ticket.getPrice();
                }
            }
            amountID.put(entry5.getKey(),minT);
        }
        /**
        1. Sorting the list of distances and the corr ID
        **/
        Set<Entry<Integer, Integer>> sortedSet = maps.entrySet();
        List<Entry<Integer, Integer>> sortedList = new LinkedList<Entry<Integer, Integer>>(sortedSet);
        Collections.sort(sortedList, new Comparator<Entry<Integer, Integer>>() {
                @Override
            public int compare(Entry<Integer, Integer> ele1,Entry<Integer, Integer> ele2) {
                return ele1.getValue().compareTo(ele2.getValue());
            }
        
        });
        /**
        1. Storing the list into Linked HashMap to preserve the order of insertion. 
        **/
        Map<Integer, Integer>sortedMap = new LinkedHashMap<Integer, Integer>();
        for(Entry<Integer, Integer> entry: sortedList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
		
        /**
        1. Returning five of the closest event with Ids, distances and cheapest price 
        **/
	System.out.println("Closest Events to " + "(" + xCoordinate + "," + yCoordinate + ")" + ":" );	
        int counter = 0;
        for(Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (counter == 5){
                break;
            }
            System.out.println("Event" + " " +  entry.getKey() + " " + "-" + " " + "$" + 
                Math.round(amountID.get(entry.getKey()) * 100.0) / 100.0 +  " , " + "Distance" + entry.getValue()); 
            counter++;
        }   
    
	} // END IF STATEMENT WHICH CHECKS INPUT

         else{ 
             System.out.println("INVALID ENTRY! PLEASE ENTER BETWEEN -10 AND 10!");
             generateData();
             }

    } 
}

   
