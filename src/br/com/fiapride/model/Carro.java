package br.com.fiapride.model;

public class Carro extends Veiculo implements Rastreavel {

    private int numeroPortas;
    private double litrosTanque;
    private double latitude;
    private double longitude;

    public Carro(String placa, String modelo, int ano, int numeroPortas, double litrosTanque) {
        super(placa, modelo, ano);
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
        return litrosTanque * 12.0;
    }

    @Override
    public void atualizarLocalizacao(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        System.out.println("[" + getModelo() + "] GPS atualizado a cada "
                + INTERVALO_ATUALIZACAO_SEGUNDOS + "s → " + obterLocalizacao());
    }

    @Override
    public String obterLocalizacao() {
        return "Lat: " + latitude + ", Long: " + longitude;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Portas: " + numeroPortas);
        System.out.println("Tanque: " + litrosTanque + "L");
    }
}
