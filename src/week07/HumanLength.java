package week07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This illustrates the use of priority queues with Comparators and Comparable
 * Objects
 * 
 * @author "David Sousa-Rodrigues"
 * 
 */
public class HumanLength implements Comparator<HumanLength>, Comparable<HumanLength> {
	public double length;
	private int i;

	public HumanLength(int i) {
		this.i = i;
		this.length = Math.random() * 200;
	}

	@Override
	public String toString() {
		return "I'm human " + i + ". My length is  " + length;
	}

	@Override
	public int compare(HumanLength o1, HumanLength o2) {
		return o1.length > o2.length ? 1 : -1;
	}

	@Override
	public int compareTo(HumanLength o) {
		return length > o.length ? 1 : -1;
	}

	public static void main(String[] args) {

		PriorityQueue<HumanLength> queue = new PriorityQueue<HumanLength>();

		for (int i = 0; i < 10; i++) {
			HumanLength hl = new HumanLength(i);
			queue.add(hl);
			System.out.println(hl);
		}
		System.out.println("==================");

		for (HumanLength humanLength : queue) {
			System.out.println(humanLength);
		}
	}
}
