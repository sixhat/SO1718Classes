package apolonia;

import java.util.LinkedList;

public class Station extends Thread {
	private Street street;
	private boolean open;

	private LinkedList<Passenger> platform;
	
	
	public Station(Street street) {
		this.street = street;
		this.platform = new LinkedList<Passenger>();
		this.open=true;
	}
	
	public synchronized void imKickingThisPassengerOut(Passenger p) {
		platform.add(p);
		notifyAll();
	}
	public synchronized Passenger getPassenger4Street() {
		while (platform.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return platform.poll();
	}

	@Override
	public void run() {
		while(isOpen() || !platform.isEmpty()) {
			street.dumpPassenger(getPassenger4Street());
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
}
