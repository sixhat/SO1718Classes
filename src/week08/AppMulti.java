package week08;

public class AppMulti {
 public static void main(String[] args) {
	Multiplicador m2 = new Multiplicador(2, 1000);
	Multiplicador m3 = new Multiplicador(3, 1000);
	Multiplicador m5 = new Multiplicador(5, 1000);
	Multiplicador m7 = new Multiplicador(7, 1000);
	Multiplicador m11 = new Multiplicador(11, 1000);
	 
	 
	Thread t2 = new Thread(m2);
	Thread t3 = new Thread(m3);
	Thread t5 = new Thread(m5);
	Thread t7 = new Thread(m7);
	Thread t11 = new Thread(m11);
	
	t2.start();
	t3.start();
	t5.start();
	t7.start();
	t11.start();
	
	try {
		t2.join();
		t3.join();
		t5.join();
		t7.join();
		t11.join();

		System.out.println(m2.acum+m3.acum+m5.acum+m7.acum+m11.acum);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	
	}
}
