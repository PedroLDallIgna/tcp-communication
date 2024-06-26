package exer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // 1 - Definir o serverSocket (abrir porta de conexão)
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta");
        System.out.println("Servidor esperando receber mensagens de clientes...");

        while (true) {
            // 2 - Aguardar solicitações de conexão de clientes
            Socket socket = serverSocket.accept();
            // Mostrar endereço IP do cliente conectado
            System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

            // 3 - Definir uma thread para cada cliente conectado
            ThreadSocket thread = new ThreadSocket(socket);
            thread.start();
        }
    }
}
