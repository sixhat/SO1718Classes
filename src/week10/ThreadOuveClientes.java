package week10;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadOuveClientes extends Thread {

	private BufferedReader r;
	private FazBroadcast fz;

	public ThreadOuveClientes(BufferedReader r, FazBroadcast fz) {
		this.r = r;
		this.fz = fz;
	}
	
	@Override
	public void run() {

		while(true) {
			try {
				fz.envia(r.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
