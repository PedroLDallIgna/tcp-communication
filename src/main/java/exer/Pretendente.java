package exer;

import java.io.Serializable;

public class Pretendente implements Serializable {
    private String nome;
    private int idade;
    private String pretencao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPretencao() {
        return pretencao;
    }

    public void setPretencao(String pretencao) {
        this.pretencao = pretencao;
    }
}
