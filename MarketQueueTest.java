/** CC2 2015 - Laboratorio #4
    Ejercicio #2 - MarketQueueTest*/

import java.util.*;

public class MarketQueueTest {
	public static void main(String[] args) {

		Random r = new Random();
		MarketQueue mq1 = new MarketQueue(r.nextInt(45));
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("Created queue: " + mq1.toString());
		System.out.println("Number of Queues: "+MarketQueue.getNumberOfQueues());
		System.out.println("Max Capacity Queue Number :"+MarketQueue.getMaxCapacityQueue().getQueueNumber());
		System.out.println("Max Queue Capacity :"+MarketQueue.getMaxCapacityQueue().getCapacity());
		System.out.println("+++++++++++++++++++++++++++++++++++");

		MarketQueue mq2 = new MarketQueue(r.nextInt(45));
		System.out.println("Created queue: " + mq2.toString());
		System.out.println("Number of Queues :"+MarketQueue.getNumberOfQueues());
		System.out.println("Max Capacity Queue Number :"+MarketQueue.getMaxCapacityQueue().getQueueNumber());
		System.out.println("Max Queue Capacity :"+MarketQueue.getMaxCapacityQueue().getCapacity());
		System.out.println("+++++++++++++++++++++++++++++++++++");

		MarketQueue mq3 = new MarketQueue(r.nextInt(45));
		System.out.println("Created queue: " + mq3.toString());
		System.out.println("Number of Queues: "+MarketQueue.getNumberOfQueues());
		System.out.println("Max Capacity Queue Number: "+MarketQueue.getMaxCapacityQueue().getQueueNumber());
		System.out.println("Max Queue Capacity: "+MarketQueue.getMaxCapacityQueue().getCapacity());
		System.out.println("+++++++++++++++++++++++++++++++++++");

		MarketQueue mq4 = new MarketQueue(r.nextInt(45));
		System.out.println("Created queue: " + mq4.toString());
		System.out.println("Number of Queues: "+MarketQueue.getNumberOfQueues());
		System.out.println("Max Capacity Queue Number :"+MarketQueue.getMaxCapacityQueue().getQueueNumber());
		System.out.println("Max Queue Capacity : "+MarketQueue.getMaxCapacityQueue().getCapacity());

		System.out.println("+++++++++++++++++++++++++++++++++++");
	}
}