package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		System.out.println("Servidor iniciado");

		ServerSocket serverSocket = new ServerSocket(9991);

		while (true) {

			// se ejecuta para siempre
			// se bloquea hasta que acepta una conexión de cliente.
			Socket socketClient = serverSocket.accept();

			System.out.println("Cliente aceptado");

		}

		// System.out.println("Servidor finalizado");
	}

}
