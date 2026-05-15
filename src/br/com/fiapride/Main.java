package br.com.fiapride;

import br.com.fiapride.model.Passageiro;

public class Main {

    public static void main(String[] args) {
        Passageiro passageiro = new Passageiro();
        passageiro.nome = "Leonardo Lopes";
        passageiro.rm = "123456";
        passageiro.email = "leonardo@email.com";
        passageiro.saldo = 100.0;
        passageiro.ativo = true;

        System.out.println("=== FiapRide - Passageiro ===");
        System.out.println("Nome:   " + passageiro.nome);
        System.out.println("RM:     " + passageiro.rm);
        System.out.println("Email:  " + passageiro.email);
        System.out.println("Saldo:  R$ " + passageiro.saldo);
        System.out.println("Ativo:  " + passageiro.ativo);
    }
}
