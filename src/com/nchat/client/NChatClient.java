package com.nchat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class NChatClient {
	
	Socket connectionSocket;
	PrintWriter output;
	BufferedReader input;
	boolean stopClient = false;
	String chatMessage = "";
	String serverMessage = "";
	
	public NChatClient(String ip){
		
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		InetAddress address = null;
		//Get and verify IP address.
		try {
			address = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error", "Improper IP address.", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(-1);
		}
		
		//Try to start connection on port (Execute.port).
		System.out.println("Connecting to server (" + ip + ")...");
		try{
			connectionSocket = new Socket(address, Execute.port);
		}catch(Exception e){
			System.out.println("Error connecting to port " + Execute.port + "!");
			e.printStackTrace();
			System.exit(-1);
		}
		
		//Try to establish write connection with server.
		System.out.println("Establishing communications...");
		try{
			output = new PrintWriter(connectionSocket.getOutputStream(), true);
		}catch(IOException e){
			System.out.println("Error writing to server.");
			e.printStackTrace();
		}
		
		//Try to establish read connection with server.
		try{
			input = new BufferedReader( new InputStreamReader(connectionSocket.getInputStream()) );
		}catch(IOException e){
			System.out.println("Error reading from server.");
			e.printStackTrace();
		}
		
		System.out.println("Successfully connected to server (" + ip +")!");
		while(stopClient==false){
			
			//Try to read from console input.
			try {
				if(scan.ready()){
					chatMessage = scan.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//Try to read input from server.
			try{
				if(input.ready()){
					serverMessage = input.readLine();
					System.out.println(serverMessage);
				}
			} catch (IOException e) {
				System.out.println("Error reading from server.");
				e.printStackTrace();
			}
			
		}
	}
	
}
