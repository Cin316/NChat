package com.nchat.client;

import javax.swing.JOptionPane;

public class Execute {

	public static int port = 13132;
	public static String ip;

	public static void main(String[] args) {
		
		if (args.length>=1){
			port = Integer.parseInt(args[0]);
		}
		
		ip = JOptionPane.showInputDialog("Enter the IP address of the server you would like to connect to.");
		NChatClient client = new NChatClient(ip);
	}

}