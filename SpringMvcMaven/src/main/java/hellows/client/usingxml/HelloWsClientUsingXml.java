package hellows.client.usingxml;

import hellows.HelloWorldWs;
import hellows.HelloWorldWsImpl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

//used jaxws:client

public class HelloWsClientUsingXml {
	public static void main(String[] args) {
		BeanFactory context = new XmlBeanFactory(new FileSystemResource(
				"src/main/webapp/WEB-INF/dispatcher-servlet.xml"));
		HelloWorldWs hello = context.getBean("helloWsClient",
				HelloWorldWs.class);
		System.out.println(hello.sayHello());

	}

}
