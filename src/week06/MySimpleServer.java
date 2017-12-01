package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MySimpleServer {
	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(6000);){
			
			
			while (true) {
				Socket session = serverSocket.accept();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(session.getInputStream()));
				PrintWriter pw = new PrintWriter(session.getOutputStream(),true);
				
				String input=null;
				while ((input = br.readLine()) != null) {

					pw.println(input);	
				} 
				session.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
