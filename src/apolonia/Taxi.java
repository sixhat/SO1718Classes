package apolonia;

import java.util.concurrent.ThreadLocalRandom;

public class Taxi extends Thread {

	private int id;
	private Street street;
	private long maxTimeWaiting;
	private Station station; 
	
	public Taxi(int id, Street street, Station station) {
		this.id = id;
		this.street = street;
		this.station = station;
		maxTimeWaiting = 0;
	}

	@Override
	public void run() {
		while (station.isOpen() || street.notEmpty()) {
			Passenger p = street.pickPassenger();
			if (p.timeWaiting()>maxTimeWaiting) {
				System.out.println("Taxi "+id+":Passenger " + p.getId() + " from train "+ p.getTrainNumber()+ " waited for " + p.timeWaiting());
				maxTimeWaiting = p.timeWaiting();
			}
			
			
			long sleepFor = ThreadLocalRandom.current().nextLong(45, 180);
			try {
				sleep(sleepFor);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
