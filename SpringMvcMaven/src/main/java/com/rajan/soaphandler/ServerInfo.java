package com.rajan.soaphandler;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@HandlerChain(file="handler-chain.xml")
public interface ServerInfo{

	@WebMethod
	public String getServerName() ;

}