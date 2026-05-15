package br.com.fiapride.model;

public class Moto extends Veiculo {

    private String tipo;  // esportiva, custom, urbana
    private double litrosTanque;

    public Moto(String placa, String modelo, int ano, String tipo, double litrosTanque) {
        super(placa, modelo, ano);  // inicializa atributos privados da mãe
        this.tipo = tipo;
        this.litrosTanque = litrosTanque;
    }

    public String getTipo() {
        return tipo;
    }

    public double getLitrosTanque() {
        return litrosTanque;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo:   " + tipo);
        System.out.println("Tanque: " + litrosTanque + "L");
    }
}
