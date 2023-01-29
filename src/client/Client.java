package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private String serverAdress;
	private int port;
	private Socket socket;
	BufferedReader in;
	PrintWriter out;

	public static void main(String[] args) {

		System.out.println("Soy un cliente");

		Client client = new Client("localhost", 9991);

	}

	public Client(String serverAdress, int port) {
		this.serverAdress = serverAdress;
		this.port = port;
		Lector lector = new Lector();
		Escritor escritor = new Escritor();

		try {
			conectar();
			lector.start();
			escritor.start();
		} catch (IOException e) {
			e.printStackTrace();

		} 

	}

	public void conectar() throws IOException {
		socket = new Socket(serverAdress, port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

	}

	public class Lector extends Thread {

		public void run() {
			String phrase;
			while (true) {
				try {
					phrase = in.readLine();
					System.out.println(phrase);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public class Escritor extends Thread {


		public void run() {
			String phrase;
			Scanner scanner = new Scanner(System.in);
			while (true) {
				phrase = scanner.nextLine();
				out.println(phrase);
			}
		}
	}

}
