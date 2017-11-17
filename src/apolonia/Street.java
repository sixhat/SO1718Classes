package apolonia;

import java.util.LinkedList;

/**
 * The Street can hold all the Passengers, but it could be limited also.
 * 
 * @author "David Sousa-Rodrigues"
 *
 */
public class Street {
	private LinkedList<Passenger> filaDeEspera;

	public Street() {
		filaDeEspera = new LinkedList<Passenger>();
	}

	/**
	 * The Station dumps passengers onto the street
	 */
	public synchronized void dumpPassenger(Passenger p) {
		filaDeEspera.add(p);
		p.putOnStreet();
		notifyAll();
	}

	/**
	 * Taxis pick passengers from the street but only if the the filaDeEspera has
	 * passengers. Otherwise they will wait.
	 */
	public synchronized Passenger pickPassenger() {
		while (filaDeEspera.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Passenger p = filaDeEspera.poll();
		p.pickTaxi();
		return p;
	}

	public synchronized boolean notEmpty() {
		return !filaDeEspera.isEmpty();
	}
}
