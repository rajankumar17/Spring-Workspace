package com.rajan.soaphandler.client;

import java.util.Collections;
import java.util.List;

import javax.jws.HandlerChain;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class WsClient {
	
	public static void main(String[] args) throws Exception {

		ServerInfoImplService sis = new ServerInfoImplService();
		
		// Programmatic way to add handlers without changing the generated SEI code(which is ServerInfoImplService.java here)  
		sis.setHandlerResolver(new HandlerResolver() {
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				Handler h=(Handler)new MacAddressInjectHandler();
				return Collections.singletonList(h);
			}
        });
		
		//Above code can be replaced by adding @HandlerChain(file="handler-chain.xml") in ServerInfoImplService.java
		
		
		ServerInfo si = sis.getServerInfoImplPort();

		System.out.println(si.getServerName());

    }

}
