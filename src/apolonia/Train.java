package apolonia;

import java.util.concurrent.ThreadLocalRandom;

public class Train extends Thread{
	private Station station;
	private int currentTrainNumber;
	private int numTrains;
	
	public Train(Station station, int numTrains) {
		this.station = station;
		this.numTrains = numTrains;
		this.currentTrainNumber=0;
	}
	
	@Override
	public void run() {
		while(station.isOpen()) {
			int numberOfPassengers = ThreadLocalRandom.current().nextInt(600, 2000);
			currentTrainNumber++;
			for (int i = 0; i < numberOfPassengers; i++) {
				Passenger p = new Passenger(i+1, currentTrainNumber);
				
				kickPassenger(station, p);
			}
			System.out.println("Train "+currentTrainNumber + " put "+numberOfPassengers+" on the Station");
			

			if (currentTrainNumber==numTrains) {
				return;
			}
			
			try {
				sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}

	private void kickPassenger(Station station2, Passenger p) {
		station2.imKickingThisPassengerOut(p);
		
	}

}
