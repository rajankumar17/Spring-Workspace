package hellows.client.usingwsimporttool;

public class HelloWorldToolClient {
	public static void main(String[] args) {

		HelloWorldWsImplService helloService = new HelloWorldWsImplService();
		HelloWorldWs hello = helloService.getHelloWorldWsImplPort();

		System.out.println(hello.sayHello());

	}
}
