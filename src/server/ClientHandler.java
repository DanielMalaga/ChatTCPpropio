package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

	private Socket socket;
	private String nombre;
	BufferedReader in;
	PrintWriter out;

	public ClientHandler(Socket socket, String nombre) throws IOException {
		this.socket = socket;
		this.nombre = nombre;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
	}

	public void run() {
		String phrase;
		while (true) {
			try {
				phrase = in.readLine();
				for (int i = 0; i < Server.clients.size(); i++) {
					if (!Server.clients.get(i).nombre.equals(nombre)) {
						Server.clients.get(i).out.println(nombre + " HA ESCRITO: " + phrase);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
