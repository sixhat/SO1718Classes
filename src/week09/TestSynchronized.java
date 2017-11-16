package week09;

/**
 * A simple example of a class that uses synchronised methods to increment and decrement a counter.
 * @author "David Sousa-Rodrigues"
 *
 */
public class TestSynchronized {
	private int c;
	
	public TestSynchronized() {
		c = 0;
	
	}
	
	public synchronized void up() {
		c++;
	}
	
	public synchronized void down() {
		c--;
	}
	
	public static void main(String[] args) {
		TestSynchronized t = new TestSynchronized();
		t.up();
		t.down();
		
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					t.up();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					t.down();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getC());
		
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
}
