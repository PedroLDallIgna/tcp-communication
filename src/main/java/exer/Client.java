package exer;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        // 1 - Abrir conexão
        Socket socket = new Socket("127.0.0.1", 54321);

        while (true) {
            int resposta = JOptionPane.showConfirmDialog(null, "Enviar nova mensagem?");

            if (resposta == JOptionPane.YES_OPTION) {
                // 2 - Definir stream de saida de dados do cliente
                Pretendente pretendente = new Pretendente();
                String nome = JOptionPane.showInputDialog("Nome:");
                pretendente.setNome(nome);
                String idade = JOptionPane.showInputDialog("Idade: ");
                pretendente.setIdade(Integer.parseInt(idade));
                String pretencao = JOptionPane.showInputDialog("Pretenção: ");
                pretendente.setPretencao(pretencao);
                ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
                saida.writeObject(pretendente);

                // 3 - Definir stream de entrada de dados no cliente
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                String novaMensagem = entrada.readUTF();
                JOptionPane.showMessageDialog(null, novaMensagem, "Server says", JOptionPane.PLAIN_MESSAGE);

                // 4 - Fechar streams de entrada e saida de dados
                entrada.close();
                saida.close();
            } else {
                break;
            }
        }

        // 5 - Fechar a conexão
        socket.close();
    }
}
