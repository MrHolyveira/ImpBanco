package br.com.projeto;

import java.io.*;
import java.util.*;

public class TrataCliente implements Runnable {

    private InputStream cliente;
    private Servidor servidor;

    public TrataCliente(InputStream cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {
       
        Scanner s = new Scanner(this.cliente);
    
        s.close();
    }
}