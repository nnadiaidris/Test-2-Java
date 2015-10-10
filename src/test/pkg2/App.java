/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.pkg2;

/**
 *
 * @author Nurul.Nadia.Idris
 * For Test 2
 */
//package com.mkyong;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class App{
    private static Object ipv6;
	
   public static void main(String[] args){
		
	InetAddress ip;
	try {
            	
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
               
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
                
		System.out.print("Current MAC address : ");
                
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                 
                }
		System.out.println(sb.toString());
         
			
	} catch (UnknownHostException | SocketException e) {
	}
	    
   }

}
