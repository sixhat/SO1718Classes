package week08;

/**
 * Example of Threads doing their thing...
 * @author "David Sousa-Rodrigues"
 *
 */
public class RunningThreads {
	public RunningThreads() {

	}

	/**
	 * Launch a new thread
	 * @param val
	 */
	private void launch(final int val) {

		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 20; i=i+val) {
					System.out.println(Thread.currentThread().getName()+" "+val+" "+i);
					try {
						Thread.sleep((long) (Math.random()*300));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		th.start();

	}

	public static void main(String[] args) {
		RunningThreads rt = new RunningThreads();
		for (int i = 1; i < 5; i++) {
			rt.launch(i);
		}
	}
}
