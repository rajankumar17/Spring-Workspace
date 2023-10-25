package com.rajan.calculator;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class CalculatorSoapClient {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:8080/SpringMvcMaven/services/calculate?wsdl");
		
		// To use TCP/IP create a TCP/IP from Windows Prefrences Run/Debug
		// TCP/IP port 8888 and localhost 8080 TCP/IP then start ...then run
		// this main..check details in TCP/IP view
		//http://www.mkyong.com/webservices/jax-ws/how-to-trace-soap-message-in-eclipse-ide/
		//URL url = new URL("http://localhost:8888/SpringMvcMaven/services/calculate?wsdl");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://calculator.rajan.com/",
				"CalculatorProcessorImplService");

		Service service = Service.create(url, qname);

		CalculatorProcessor hello = service.getPort(CalculatorProcessor.class);

		System.out.println(hello.calculate(3, 5));

	}
}
