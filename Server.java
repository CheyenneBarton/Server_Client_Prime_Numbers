package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	

	public static void main(String[] args) throws IOException {
		
		//create socket to connect with server
		ServerSocket server = new ServerSocket(1031);
		System.out.println("Server started");
		
		//create socket and wait for client connection
		Socket socket = server.accept();
		System.out.println("Client connected");
		
		while(true) {
			
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			
			Scanner userInput = new Scanner(input);
			
			//read number from client
			int userNumber = userInput.nextInt();
			
			//if number is less than 2 (1 or 0) = not prime
			if(ifPrime(userNumber)) {
				System.out.println(userNumber + " is a prime number");
			}
			else 
			{
				System.out.println(userNumber + " is NOT a prime number");
			}
			
			System.out.println("Closing connection");
			}
		}
	
	public static boolean ifPrime(int userNumber ) {
		if (userNumber <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(userNumber); i++) {
			if (userNumber % i == 0) {
				return false;
			}
		}
		return true;
	}
	}
