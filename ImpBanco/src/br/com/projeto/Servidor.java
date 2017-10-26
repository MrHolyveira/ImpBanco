package br.com.projeto;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {

    public static void main(String[] args) throws IOException {
        // inicia o servidor
        new Servidor(12345).executa();
    }

    private int porta;
    private List<PrintStream> clientes;
	private ServerSocket servidor;

    public Servidor (int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<PrintStream>();
    }

    public void executa () throws IOException {
        servidor = new ServerSocket(this.porta);
        System.out.println("Porta 12345 aberta!");

        while (true) {
            // aceita um cliente
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão, cliente: " +
                cliente.getInetAddress().getHostAddress()
            );

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            TrataCliente tc =
                    new TrataCliente(cliente.getInputStream(), this);
            new Thread(tc).start();
        }
    }
}