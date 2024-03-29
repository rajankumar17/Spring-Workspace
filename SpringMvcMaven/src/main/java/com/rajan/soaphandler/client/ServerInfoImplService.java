
package com.rajan.soaphandler.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServerInfoImplService", targetNamespace = "http://soaphandler.rajan.com/", wsdlLocation = "http://localhost:8080/SpringMvcMaven/services/serverhandler?wsdl")
//@HandlerChain(file="handler-chain.xml")
public class ServerInfoImplService
    extends Service
{

    private final static URL SERVERINFOIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVERINFOIMPLSERVICE_EXCEPTION;
    private final static QName SERVERINFOIMPLSERVICE_QNAME = new QName("http://soaphandler.rajan.com/", "ServerInfoImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/SpringMvcMaven/services/serverhandler?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVERINFOIMPLSERVICE_WSDL_LOCATION = url;
        SERVERINFOIMPLSERVICE_EXCEPTION = e;
    }

    public ServerInfoImplService() {
        super(__getWsdlLocation(), SERVERINFOIMPLSERVICE_QNAME);
    }


    public ServerInfoImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVERINFOIMPLSERVICE_QNAME);
    }


    public ServerInfoImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }


    /**
     * 
     * @return
     *     returns ServerInfo
     */
    @WebEndpoint(name = "ServerInfoImplPort")
    public ServerInfo getServerInfoImplPort() {
        return super.getPort(new QName("http://client.soaphandler.rajan.com/", "ServerInfoImplPort"), ServerInfo.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServerInfo
     */
    @WebEndpoint(name = "ServerInfoImplPort")
    public ServerInfo getServerInfoImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://client.soaphandler.rajan.com/", "ServerInfoImplPort"), ServerInfo.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVERINFOIMPLSERVICE_EXCEPTION!= null) {
            throw SERVERINFOIMPLSERVICE_EXCEPTION;
        }
        return SERVERINFOIMPLSERVICE_WSDL_LOCATION;
    }

}
