package com.rajan.calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.*;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT,use=Use.LITERAL)
public interface CalculatorProcessor {

	@WebMethod()
	public @WebResult(name = "sum")
	int calculate(@WebParam(name = "value1") int a,
			@WebParam(name = "value2") int b);

}
