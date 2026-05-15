package br.com.fiapride;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;

public class Main {

    public static void main(String[] args) {
        // construtor padrão + setters
        Passageiro p1 = new Passageiro();
        p1.setNome("Leonardo Lopes");
        p1.setRm("565437");
        p1.setEmail("leonardo@email.com");
        p1.adicionarSaldo(80.0);
        p1.exibirDados();

        System.out.println();

        // construtor customizado — usa this() internamente
        Passageiro p2 = new Passageiro("Ana Lima", "654321", "ana@email.com");
        p2.adicionarSaldo(150.0);
        p2.exibirDados();

        System.out.println();

        // veículo — modelo imutável, placa via atualizarPlaca()
        Veiculo veiculo = new Veiculo("ABC1D23", "Toyota Corolla", 2022);
        veiculo.exibirDados();

        System.out.println();
        veiculo.atualizarPlaca("XYZ9A87");
        veiculo.atualizarPlaca("123");  // placa inválida
    }
}
