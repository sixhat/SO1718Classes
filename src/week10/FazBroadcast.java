package week10;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

public class FazBroadcast {

	private Vector<PrintWriter> canaisCliente;

	public FazBroadcast(Vector<PrintWriter> canaisCliente) {
		this.canaisCliente = canaisCliente;
	}
	
	public void envia(String msg) {
		for (PrintWriter printWriter : canaisCliente) {
			printWriter.println(msg);
			printWriter.flush();
		}
	}
}
