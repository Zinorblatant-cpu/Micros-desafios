package br.com.fiapride;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;

public class Main {

    public static void main(String[] args) {
        Passageiro passageiro = new Passageiro("Leonardo Lopes", "565437", "leonardo@email.com");
        passageiro.adicionarSaldo(80.0);

        Veiculo veiculo = new Veiculo("ABC1D23", "Toyota Corolla", 2022);

        Viagem viagem = new Viagem(passageiro, veiculo, "Av. Paulista", "Aeroporto de Congonhas", 45.0);

        viagem.iniciarViagem();
        viagem.finalizarViagem();

        System.out.println();
        viagem.exibirResumo();

        System.out.println();
        passageiro.exibirDados();

        System.out.println("\n--- Tentando finalizar viagem já encerrada ---");
        viagem.finalizarViagem();
    }
}
