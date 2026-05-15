package br.com.fiapride;

import br.com.fiapride.model.Passageiro;

public class Main {

    public static void main(String[] args) {
        Passageiro passageiro = new Passageiro();

        passageiro.setNome("Leonardo Lopes");
        passageiro.setRm("565437");
        passageiro.setEmail("leonardo@email.com");
        passageiro.setAtivo(true);
        passageiro.adicionarSaldo(80.0);

        passageiro.exibirDados();

        System.out.println("\n--- Testando validações dos setters ---");
        passageiro.setNome("");           // nome inválido
        passageiro.setEmail("semArroba"); // email inválido
        passageiro.descontarSaldo(200.0); // saldo insuficiente

        System.out.println("\n--- Getters ---");
        System.out.println("Nome via getter:  " + passageiro.getNome());
        System.out.println("Saldo via getter: R$ " + passageiro.getSaldo());
    }
}
