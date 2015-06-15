package com.conecta.util;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("txCounter")
public class TxCounter {
	static int contador = 0;
    public int getNext() throws InterruptedException {
        System.out.println("contador: " + contador);
        contador++;
        System.out.println("regresar: " + contador);
        return contador;
    }
}
