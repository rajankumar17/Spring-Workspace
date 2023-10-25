package com.rajan.calculator;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

//@WebService(name = "calculateSum", targetNamespace = "com.rajan.calculator", serviceName = "SumProcessor", portName = "CalculatorPort", endpointInterface = "CalculatorProcessor")
//@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
@WebService(endpointInterface = "com.rajan.calculator.CalculatorProcessor")
public class CalculatorProcessorImpl implements CalculatorProcessor{
	
	@WebMethod()
	public @WebResult(name="sum") int calculate(@WebParam(name="value1") int a,@WebParam(name="value2") int b){
		return a+b;
	}

}
