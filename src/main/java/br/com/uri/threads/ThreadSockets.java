package br.com.uri.threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSockets extends Thread {
    private Socket socket;

    public ThreadSockets(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            // 1 - Definir stream de entrada de dados no servidor
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String mensagem = entrada.readUTF();
            String novaMensagem = mensagem.toUpperCase();

            // 2 - Definir stream de saída de dados do servidor
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            saida.writeUTF(novaMensagem);

            // 3 - Fechar streams de entrada e saída de dados
            entrada.close();
            saida.close();

            // 4 - Fechar socket de comunicação
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.toString());
        }
    }
}
