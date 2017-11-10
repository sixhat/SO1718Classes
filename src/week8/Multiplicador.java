package week8;

public class Multiplicador implements Runnable{

	private int primo;
	private int limite;
	public int acum;

	public Multiplicador(int i, int j) {
		this.primo = i;
		this.limite = j;
	}

	@Override
	public void run() {
		int ctn = 1;
		acum = 0;
		while (primo*ctn < limite) {
			acum += primo*ctn;
			ctn++;
		}
		System.out.println(primo+" ->"+acum);
		
	}

}
