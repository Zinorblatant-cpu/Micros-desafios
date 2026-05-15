package br.com.fiapride;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Veiculo;

public class Main {

    public static void main(String[] args) {
        // new Veiculo() — erro de compilação: Veiculo é abstract
        // Veiculo v = new Veiculo("ABC1D23", "Generico", 2020); // INVÁLIDO

        Veiculo[] frota = new Veiculo[3];
        frota[0] = new Carro("ABC1D23", "Toyota Corolla", 2022, 4, 55.0);
        frota[1] = new Moto("XYZ9A87", "Honda CB 500", 2021, "esportiva", 17.5);
        frota[2] = new Carro("DEF2E34", "VW Gol", 2020, 4, 42.0);

        System.out.println("=== Relatório de Autonomia da Frota ===\n");

        for (Veiculo veiculo : frota) {
            veiculo.exibirDados();
            // calcularAutonomia() agora é obrigação de cada subclasse
            System.out.println("Autonomia: " + veiculo.calcularAutonomia() + " km");
            System.out.println();
        }
    }
}
