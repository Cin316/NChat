package com.nchat.client;

import javax.swing.JOptionPane;

public class Execute {

	public static final int port = 13131;
	public static String ip;

	public static void main(String[] args) {

		ip = JOptionPane.showInputDialog("Enter the IP address of the server you would like to connect to.");
		NChatClient client = new NChatClient(ip);
	}

}