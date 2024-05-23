package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
            try (Socket socket = new Socket("localhost", 9999)) {
            	ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            	ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            	
            	int choice = 0;
            	System.out.println("Enter your choice:");
            	System.out.println("1. ");
            	System.out.println("2. ");
            	System.out.println("3. ");
            	
            	while (true) {
            		choice = sc.nextInt();
            		sc.nextLine();
            		out.writeInt(choice);
            		out.flush();
            	
	            	switch (choice) {
	            		case 1:

							break;
	            		case 2:

	            			break;
	            	}
            	}
            }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
