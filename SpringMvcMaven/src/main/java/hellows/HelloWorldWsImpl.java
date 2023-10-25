package hellows;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(endpointInterface="hellows.HelloWorldWs")
public class HelloWorldWsImpl implements HelloWorldWs{

	@WebMethod
	public String sayHello(){
		return "Hello, How are you?";
	}
}
