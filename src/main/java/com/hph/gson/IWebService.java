
package com.hph.gson;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IWebService", targetNamespace = "http://webservice.xcbase.bmsoft.com.cn/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IWebService {


    /**
     * 
     * @param request
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String process(
        @WebParam(name = "request", partName = "request")
        String request);

}