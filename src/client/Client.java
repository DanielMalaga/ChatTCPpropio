package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private String serverAdress;
	private int port;
	private Socket socket;

	public static void main(String[] args) {

		System.out.println("Soy el cliente");

		Client client = new Client("localhost", 9991);

	}

	public Client(String serverAdress, int port) {
		this.serverAdress = serverAdress;
		this.port = port;

		try {
			conectar();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void conectar() throws IOException {
		socket = new Socket(serverAdress, port);

	}

}
