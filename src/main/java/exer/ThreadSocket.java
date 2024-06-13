package exer;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ThreadSocket extends Thread {
    private Socket socket;

    public ThreadSocket(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            // 1 - Definir stream de entrada de dados no servidor
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            Pretendente pretendente = (Pretendente) entrada.readObject();
            System.out.println(pretendente.getNome());
            System.out.println(pretendente.getIdade());
            System.out.println(pretendente.getPretencao());
            JOptionPane.showMessageDialog(null, pretendente.getPretencao(), "Client says", JOptionPane.PLAIN_MESSAGE);

            // 2 - Definir stream de saída de dados do servidor
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            String novaMensagem = JOptionPane.showInputDialog("Resposta: ");
            saida.writeUTF(novaMensagem);

            // 3 - Fechar streams de entrada e saída de dados
            entrada.close();
            saida.close();

            // 4 - Fechar socket de comunicação
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.toString());
        }
    }
}
