package com.rajan.soaphandler;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="com.rajan.soaphandler.ServerInfo")
@HandlerChain(file="handler-chain.xml")
public class ServerInfoImpl implements ServerInfo{

	@WebMethod
	public String getServerName() {

		return "Rajan's server";

	}

}