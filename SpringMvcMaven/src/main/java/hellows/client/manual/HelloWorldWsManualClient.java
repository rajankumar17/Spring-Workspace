package hellows.client.manual;

import hellows.HelloWorldWs;
import hellows.HelloWorldWsImpl;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldWsManualClient {public static void main(String[] args) throws Exception {

	//wsdl url
	URL url = new URL("http://localhost:8080/SpringMvcMaven/services/hellosoap?wsdl");

        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://hellows/", "HelloWorldWsImplService");

        Service service = Service.create(url, qname);

        //this should be interface
        HelloWorldWs hello = service.getPort(HelloWorldWs.class);

        System.out.println(hello.sayHello());

    }}
