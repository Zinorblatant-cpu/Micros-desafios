package br.com.fiapride;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Rastreavel;
import br.com.fiapride.model.Veiculo;

public class Main {

    public static void main(String[] args) {
        Carro carro = new Carro("ABC1D23", "Toyota Corolla", 2022, 4, 55.0);
        Moto moto = new Moto("XYZ9A87", "Honda CB 500", 2021, "esportiva", 17.5);

        System.out.println("=== Rastreamento da Frota ===\n");

        // tipado como Rastreavel — contrato de interface
        Rastreavel[] rastreaveis = { carro, moto };

        for (Rastreavel r : rastreaveis) {
            r.atualizarLocalizacao(-23.5614, -46.6560);
        }

        System.out.println("\n=== Autonomia da Frota ===\n");

        // tipado como Veiculo — contrato da classe abstrata
        Veiculo[] frota = { carro, moto };

        for (Veiculo veiculo : frota) {
            System.out.println(veiculo.getModelo() + " → " + veiculo.calcularAutonomia() + " km");
        }
    }
}
