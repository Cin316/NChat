package com.nchat.client;

public class User{

	protected String ip;
	protected String name;

	public User(String a){

		ip = a;
		this.setName(ip + "IP");

	}

	public User (String a, String n){

		ip = a;
		this.setName(n);

	}

	public String getName(){

		return name;

	}
	public void setName(String s){

		name = s;

	}

	public String getIP(){

		return ip;

	}

}