package br.com.fiapride.model;

public class Passageiro {

    String nome;
    String rm;
    String email;
    double saldo;
    boolean ativo;

    void adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: valor de recarga deve ser positivo.");
            return;
        }
        saldo = saldo + valor;
        System.out.println("Saldo adicionado: R$ " + valor + " | Novo saldo: R$ " + saldo);
    }

    boolean descontarSaldo(double valor) {
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

    void exibirDados() {
        System.out.println("=== Passageiro ===");
        System.out.println("Nome:  " + nome);
        System.out.println("RM:    " + rm);
        System.out.println("Email: " + email);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Ativo: " + ativo);
    }
}
