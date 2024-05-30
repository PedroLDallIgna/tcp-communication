package br.com.uri.object;

import org.example.object.Pessoa;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1 - Abrir conexão
        Socket socket = new Socket("192.168.2.51", 54321);

        // 2 - Definir stream de saída de dados do cliente
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());

        // 3- Envia o objeto
        Pessoa pessoa = new Pessoa("Pedro Dall Igna", 20);
        System.out.println("Enviando: " + pessoa.toString());
        saida.writeObject(pessoa);

        // 4 - Fechar streams de saída de dados
        saida.close();

        // 5 - Fechar o socket
        socket.close();
    }
}
