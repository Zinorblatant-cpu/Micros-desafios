package br.com.fiapride;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Veiculo;

public class Main {

    public static void main(String[] args) {
        // frota tipada como Veiculo — polimorfismo em ação
        Veiculo[] frota = new Veiculo[3];
        frota[0] = new Carro("ABC1D23", "Toyota Corolla", 2022, 4, 55.0);
        frota[1] = new Moto("XYZ9A87", "Honda CB 500", 2021, "esportiva", 17.5);
        frota[2] = new Carro("DEF2E34", "VW Gol", 2020, 4, 42.0);

        System.out.println("=== Relatório de Autonomia da Frota ===\n");

        // mesmo método chamado — comportamento diferente em tempo de execução
        for (Veiculo veiculo : frota) {
            System.out.println("Modelo:    " + veiculo.getModelo());
            System.out.println("Placa:     " + veiculo.getPlaca());
            System.out.println("Autonomia: " + veiculo.calcularAutonomia() + " km");
            System.out.println("---");
        }
    }
}
