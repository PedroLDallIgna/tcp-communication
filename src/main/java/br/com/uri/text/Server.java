package br.com.uri.text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // 1 - Definir o server socket
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta");
        System.out.println("Server is running");

        // 2 - Aguardar solicitação de conexão do cliente
        Socket socket = serverSocket.accept();
        // Mostrar endereço IP do cliente conectado
        System.out.println("Client IP: " + socket.getInetAddress().getHostAddress());

        // 3 - Definir stream de entrada de dados no servidor
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String mensagem = entrada.readUTF();

        // 4 - Definir stream de saida e enviar os dados para o cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF(mensagem.toUpperCase());

        // 5 - Fechar streams de entrada e saida
        entrada.close();
        saida.close();

        // 6 - Fechar sockets de comunicação
        socket.close();
        serverSocket.close();
    }
}
