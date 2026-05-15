package br.com.fiapride;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Viagem;

public class Main {

    public static void main(String[] args) {
        // filhas inicializam atributos privados da mãe via super()
        Carro carro = new Carro("ABC1D23", "Toyota Corolla", 2022, 4, 55.0);
        Moto moto = new Moto("XYZ9A87", "Honda CB 500", 2021, "esportiva", 17.5);

        System.out.println("--- Carro ---");
        carro.exibirDados();  // chama super.exibirDados() + dados próprios

        System.out.println("\n--- Moto ---");
        moto.exibirDados();

        System.out.println("\n--- Viagem com Carro ---");
        Passageiro passageiro = new Passageiro("Leonardo Lopes", "565437", "leonardo@email.com");
        passageiro.adicionarSaldo(100.0);

        Viagem viagem = new Viagem(passageiro, carro, "Av. Paulista", "Aeroporto de Congonhas", 45.0);
        viagem.iniciarViagem();
        viagem.finalizarViagem();

        System.out.println();
        passageiro.exibirDados();
    }
}
