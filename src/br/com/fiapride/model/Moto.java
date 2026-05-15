package br.com.fiapride.model;

public class Moto extends Veiculo implements Rastreavel {

    private String tipo;
    private double litrosTanque;
    private double latitude;
    private double longitude;

    public Moto(String placa, String modelo, int ano, String tipo, double litrosTanque) {
        super(placa, modelo, ano);
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
    public double calcularAutonomia() {
        return litrosTanque * 22.0;
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
        System.out.println("Tipo:   " + tipo);
        System.out.println("Tanque: " + litrosTanque + "L");
    }
}
