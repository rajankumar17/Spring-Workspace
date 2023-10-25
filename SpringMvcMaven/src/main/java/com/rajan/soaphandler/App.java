package com.rajan.soaphandler;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class App {

	public static void main(String[] args) {

		InetAddress ip;
		try {

			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());

			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			byte[] mac = network.getHardwareAddress();

			System.out.print("Current MAC address : ");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {

				sb.append(String.format("%02X%s", mac[i],
						(i < mac.length - 1) ? "-" : ""));

			}
			System.out.println(sb.toString());
			
			URL url = new URL("http://localhost:8080/SpringMvcMaven/services/serverhandler?wsdl");
	        QName qname = new QName("http://soaphandler.rajan.com/", "ServerInfoImplService");

	        Service service = Service.create(url, qname);
	        ServerInfo serverInfo = service.getPort(ServerInfo.class);
	        serverInfo.getServerName();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (SocketException e) {

			e.printStackTrace();

		}
		catch (Exception e) {

			e.printStackTrace();

		}

	}

}