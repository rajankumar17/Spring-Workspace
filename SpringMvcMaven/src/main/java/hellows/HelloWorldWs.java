package hellows;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface HelloWorldWs {

	@WebMethod
	public String sayHello();
}
