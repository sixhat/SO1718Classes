package apolonia;

public class Passenger {
	private int id;
	private long atStreet;
	private long atTaxi;
	private int trainNumber;

	public Passenger(int id, int trainNumber) {
		this.id = id;
		this.trainNumber = trainNumber;
	}

	public void putOnStreet() {
		atStreet = System.currentTimeMillis();
	}

	public void pickTaxi() {
		atTaxi = System.currentTimeMillis();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public long timeWaiting() {
		return atTaxi - atStreet;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

}
