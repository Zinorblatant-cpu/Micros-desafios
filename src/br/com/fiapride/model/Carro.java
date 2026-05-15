package br.com.fiapride.model;

public class Carro extends Veiculo {

    private int numeroPortas;
    private double litrosTanque;

    public Carro(String placa, String modelo, int ano, int numeroPortas, double litrosTanque) {
        super(placa, modelo, ano);  // inicializa atributos privados da mãe
        this.numeroPortas = numeroPortas;
        this.litrosTanque = litrosTanque;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public double getLitrosTanque() {
        return litrosTanque;
    }

    @Override
    public double calcularAutonomia() {
        return litrosTanque * 12.0;  // média de 12 km/L para carros
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Portas: " + numeroPortas);
        System.out.println("Tanque: " + litrosTanque + "L");
    }
}
