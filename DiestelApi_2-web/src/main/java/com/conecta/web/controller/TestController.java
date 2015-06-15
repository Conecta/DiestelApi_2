package com.conecta.web.controller;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.SocketTimeoutException;

import javax.xml.ws.BindingProvider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diestel.ws.ArrayOfCCampo;
import com.diestel.ws.CCampo;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public @ResponseBody ArrayOfCCampo test(){
		try {
			return testDiestel();
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ArrayOfCCampo array = new ArrayOfCCampo();
			CCampo c = new CCampo();
			c.setSValor(e.toString());
			array.getCCampo().add( c );
			return array;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ArrayOfCCampo array = new ArrayOfCCampo();
			CCampo c = new CCampo();
			c.setSValor(e.toString());
			array.getCCampo().add( c );
			return array;
		}
	}
	
	public ArrayOfCCampo testDiestel() throws InterruptedException, SocketTimeoutException {

        //log.info("crea authenticator: " + new Date());
        Authenticator myAuth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("usr_ws", "usr123".toCharArray());
            }
        };
        Authenticator.setDefault(myAuth);
        com.diestel.ws.PxUniversal service = new com.diestel.ws.PxUniversal();
        com.diestel.ws.PxUniversalSoap port = service.getPxUniversalSoap();
        //log.info("creado authenticator: " + new Date());

        //log.info("crea servicio: " + new Date());
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.ws.request.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.ws.connect.timeout", 45000);
        ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.connectionTimeout", 45000);
        ((BindingProvider) port).getRequestContext().put("javax.xml.ws.client.receiveTimeout", 45000);
        //log.info("creado servicio: " + new Date());
        try{
            return port.test();
        }catch(Exception ex){
            if( ex instanceof java.net.SocketTimeoutException){
                throw new java.net.SocketTimeoutException();
            }else{
                throw new java.net.SocketTimeoutException();
            }
        }
    }
}
