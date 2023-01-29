package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static ArrayList<ClientHandler> clients;

	public static void main(String[] args) throws IOException {

		int clientNum = 0; // para nombrar al cliente cliente+numCliente
		clients = new ArrayList<ClientHandler>();

		System.out.println("Servidor iniciado");

		ServerSocket serverSocket = new ServerSocket(9991);

		while (true) { // se ejecuta para siempre

			Socket socketClient = serverSocket.accept(); // se bloquea hasta que acepta una conexión de cliente.
			System.out.println("Cliente aceptado num " + clientNum);
			ClientHandler clientHandler = new ClientHandler(socketClient, "cliente " + clientNum);
			clients.add(clientHandler);
			clientHandler.start();
			clientNum++;

		}

		// System.out.println("Servidor finalizado");
	}

}
