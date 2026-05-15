package br.com.fiapride;

import br.com.fiapride.model.Passageiro;

public class Main {

    public static void main(String[] args) {
        Passageiro passageiro = new Passageiro();
        passageiro.nome = "Leonardo Lopes";
        passageiro.rm = "123456";
        passageiro.email = "leonardo@email.com";
        passageiro.saldo = 50.0;
        passageiro.ativo = true;

        passageiro.exibirDados();

        System.out.println("\n--- Testando métodos ---");
        passageiro.adicionarSaldo(30.0);
        passageiro.descontarSaldo(20.0);
        passageiro.descontarSaldo(200.0);  // saldo insuficiente
        passageiro.adicionarSaldo(-10.0);  // valor inválido

        System.out.println("\n--- Dados finais ---");
        passageiro.exibirDados();
    }
}
