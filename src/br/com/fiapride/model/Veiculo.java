package br.com.fiapride.model;

public abstract class Veiculo {

    private String placa;
    private String modelo;
    private int ano;

    // construtor padrão
    public Veiculo() {
    }

    // construtor customizado — modelo é definido aqui e não tem setter
    public Veiculo(String placa, String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
        setPlaca(placa);
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    // setPlaca privado — só a própria classe controla a lógica de alteração
    private void setPlaca(String placa) {
        if (placa == null || placa.trim().length() < 7) {
            System.out.println("Erro: placa inválida.");
            return;
        }
        this.placa = placa.toUpperCase();
    }

    // processo público de atualização de placa (simula trâmite formal)
    public void atualizarPlaca(String novaPlaca) {
        System.out.println("Iniciando atualização de placa para o veículo: " + modelo);
        setPlaca(novaPlaca);
        System.out.println("Placa atualizada para: " + this.placa);
    }

    // contrato obrigatório — cada subclasse deve implementar seu próprio cálculo
    public abstract double calcularAutonomia();

    public void exibirDados() {
        System.out.println("=== Veículo ===");
        System.out.println("Modelo: " + modelo);
        System.out.println("Placa:  " + placa);
        System.out.println("Ano:    " + ano);
    }
}
