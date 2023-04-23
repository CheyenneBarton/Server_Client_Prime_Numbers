package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;

public class Client {

		
		public static void main(String[] args) throws IOException {
			Scanner userInput = new Scanner(System.in);
        	System.out.println("Enter a number to check if number is prime ");
        	int userNumber = userInput.nextInt();
			
			try {
			//create socket to connect with server
			Socket socket = new Socket("localhost", 1031);
			System.out.println("Connected");
			
			// takes input from terminal
	        DataInputStream input = new DataInputStream(socket.getInputStream());
	       
	        // sends output to the socket
	        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
	        
	        	Scanner serverInput = new Scanner(input);
	        	PrintWriter writer = new PrintWriter(output, true);
	        	
	        	//send number to server
	        	writer.println(userNumber);
	        	
	        	//read response fro server
	        	String response = serverInput.nextLine();
	        	
	        	System.out.println("Is this number prime? " + response);
	        	
	        	serverInput.close();
	        	
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}