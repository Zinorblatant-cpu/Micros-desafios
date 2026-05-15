package br.com.fiapride.model;

public class Passageiro {

    private String nome;
    private String rm;
    private String email;
    private double saldo;
    private boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: nome não pode ser vazio.");
            return;
        }
        this.nome = nome;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        if (rm == null || rm.trim().isEmpty()) {
            System.out.println("Erro: RM não pode ser vazio.");
            return;
        }
        this.rm = rm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Erro: email inválido.");
            return;
        }
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: valor de recarga deve ser positivo.");
            return;
        }
        saldo = saldo + valor;
        System.out.println("Saldo adicionado: R$ " + valor + " | Novo saldo: R$ " + saldo);
    }

    public boolean descontarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: valor de desconto deve ser positivo.");
            return false;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente. Saldo atual: R$ " + saldo);
            return false;
        }
        saldo = saldo - valor;
        System.out.println("Desconto realizado: R$ " + valor + " | Saldo restante: R$ " + saldo);
        return true;
    }

    public void exibirDados() {
        System.out.println("=== Passageiro ===");
        System.out.println("Nome:  " + nome);
        System.out.println("RM:    " + rm);
        System.out.println("Email: " + email);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Ativo: " + ativo);
    }
}
