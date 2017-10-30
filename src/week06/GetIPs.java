package week06;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPs {
	public static void main(String[] args) {
		System.out.println(args.length);
		try {
			InetAddress[] a = InetAddress.getAllByName(args[0]);
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
