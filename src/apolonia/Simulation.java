package apolonia;

public class Simulation {
	public static void main(String[] args) {
		System.out.println("=== Simulation Started ===");
		Simulation s = new Simulation();
		s.go();
		System.out.println("=== Simulation Terminated ===");
	}

	private Street street;
	private Station station;
	private Train train;
	private Taxi[] taxis;

	public Simulation() {
		street = new Street();
		station = new Station(street);
		train = new Train(station, 5);

		taxis = new Taxi[10];
		for (int i = 0; i < taxis.length; i++) {
			taxis[i] = new Taxi(i, street, station);
		}
	}

	private void go() {
		station.start();
		train.start();
		for (int i = 0; i < taxis.length; i++) {
			taxis[i].start();
		}
		
		try {
			train.join(); // Trains finished so we can now proceed to close the station
			System.out.println("Last train arrived");
			station.setOpen(false);
			station.join();
			System.out.println("Station is now Closed");
			
			for (int i = 0; i < taxis.length; i++) {
				taxis[i].join();
			}
			System.out.println("Taxis cleaned the Street and stooped working");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
