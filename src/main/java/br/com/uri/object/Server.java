package br.com.uri.object;

import org.example.object.Pessoa;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1 - Definir o serverSocket (abrir porta de conexão)
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta");
        System.out.println("Server is running");

        // 2 - Aguardar solicitação de conexão do cliente
        Socket socket = serverSocket.accept();
        // Mostrar endereço IP do cliente conectado
        System.out.println("Client IP: " + socket.getInetAddress().getHostAddress());

        // 3 - Definir stream de entrada de dados no servidor
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        // 4- Recebe o objeto e faz o cast para o tipo Pessoa e mostra as informações
        Pessoa mensagem = (Pessoa) entrada.readObject();
        System.out.println(mensagem.toString());

        // 5 - Fechar streams de entrada de dados
        entrada.close();

        // 6 - Fechar sockets de comunicação e conexão
        socket.close();
        serverSocket.close();
    }
}
