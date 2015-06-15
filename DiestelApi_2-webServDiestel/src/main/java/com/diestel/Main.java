package com.diestel;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.SocketTimeoutException;
import java.util.Date;

import javax.xml.ws.BindingProvider;

import com.diestel.ws.ArrayOfCCampo;
import com.diestel.ws.CCampo;
import com.diestel.ws.PxUniversalSoap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		try {
			ArrayOfCCampo lstResultado = main.test();
			for (CCampo c : lstResultado.getCCampo()) {
                System.out.println("campo " + c.getSCampo() + " ");
                System.out.println("valor" + c.getSValor());
                System.out.println("clase" + c.getIClase());
                System.out.println("tipo" + c.getITipo());
                System.out.println("long" + c.getILongitud());
                //System.out.println("" + );
            }
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayOfCCampo test() throws InterruptedException, SocketTimeoutException {

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
	
	public ArrayOfCCampo info(ArrayOfCCampo arrayOfCCampo, PxUniversalSoap port) throws InterruptedException, SocketTimeoutException {
        ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 45000);
        try{
            return port.info(arrayOfCCampo);
        }catch(Exception ex){
            if( ex instanceof java.net.SocketTimeoutException){
                throw new java.net.SocketTimeoutException();
            }else{
                throw new java.net.SocketTimeoutException();
            }
        }
        
    }
}
