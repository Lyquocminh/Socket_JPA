package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import jakarta.persistence.EntityManager;
import services.EntityManagerFactoryUtil;

public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9999);) {
			System.out.println("Server started on port 9999");
			while (true) {
				Socket clientSocket = server.accept();
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

class ClientHandler implements Runnable {
	private Socket clientSocket;
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
	private EntityManager entityManager;

	public ClientHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
		this.entityManagerFactoryUtil = new EntityManagerFactoryUtil();
		this.entityManager = entityManagerFactoryUtil.getEnManager();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			
			int choice = 0;
			while (true) {
				if(in.available() > 0)
					choice = in.readInt();
				switch(choice) {
				case 1:

					break;
				case 2:

					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		    entityManagerFactoryUtil.close();
            
		}

	}
}