package br.com.uri.threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        // 1 - Abrir conexão
        Socket socket = new Socket("127.0.0.1", 54321);

        // 2 - Definir stream de saida de dados do cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("pedro");

        // 3 - Definir stream de entrada de dados no cliente
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String novaMensagem = entrada.readUTF();
        System.out.println(novaMensagem);

        // 4 - Fechar streams de entrada e saida de dados
        entrada.close();
        saida.close();

        // 5 - Fechar a conexão
        socket.close();
    }
}
