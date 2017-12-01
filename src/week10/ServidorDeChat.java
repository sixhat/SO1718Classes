package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorDeChat {
	
	private int portoOuvir;
	ArrayList<PrintWriter> canaisCliente;
	

	public ServidorDeChat(int portoOuvir) {
		this.portoOuvir = portoOuvir;
		this.canaisCliente = new ArrayList<>();
	}
	
	public void executa() {
		FazBroadcast fz = new FazBroadcast(canaisCliente);
		
		try (ServerSocket ss = new ServerSocket(portoOuvir);) {
			while (true) {
				Socket sCliente = ss.accept();
				
				PrintWriter p = new PrintWriter(sCliente.getOutputStream());
				BufferedReader r = new BufferedReader(new InputStreamReader(sCliente.getInputStream()));
				
				canaisCliente.add(p);
				
				ThreadOuveClientes th = new ThreadOuveClientes(r, fz);
				th.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
public static void main(String[] args) {
	ServidorDeChat schat = new ServidorDeChat(60000);
	schat.executa();
}
}
