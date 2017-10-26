package br.com.projeto;

import java.io.*;
import java.util.*;

public class Recebedor implements Runnable {

    private InputStream servidor;
	private Scanner s;

    public Recebedor(InputStream servidor) {
        this.servidor = servidor;
    }

    public void run() {
        s = new Scanner(this.servidor);
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}