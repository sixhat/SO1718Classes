package week10;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FazBroadcast {

	private ArrayList<PrintWriter> canaisCliente;

	public FazBroadcast(List<PrintWriter> canaisCliente2) {
		this.canaisCliente = (ArrayList<PrintWriter>) canaisCliente2;
	}
	
	public void envia(String msg) {
		for (PrintWriter printWriter : canaisCliente) {
			printWriter.print(msg+"\n\r");
			printWriter.flush();
		}
	}
}
