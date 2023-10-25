package com.rajan.soapauth.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class SoapAuthClient {

	private static final String WS_URL = "http://localhost:8080/SpringMvcMaven/services/soapauth?wsdl";

	public static void main(String[] args) {

		try {

			HelloWorldImplService helloService = new HelloWorldImplService();
			HelloWorld hellowrld = helloService.getHelloWorldImplPort();

			/******************* UserName & Password ******************************/
			Map<String, Object> req_ctx = ((BindingProvider) hellowrld)
					.getRequestContext();
			req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

			Map<String, List<String>> headers = new HashMap<String, List<String>>();
			headers.put("Username", Collections.singletonList("rajan"));
			headers.put("Password", Collections.singletonList("password"));
			req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
			/**********************************************************************/

			System.out.println(hellowrld.sayHelloToAuthUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
