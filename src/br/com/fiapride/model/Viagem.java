package br.com.fiapride.model;

public class Viagem {

    private Passageiro solicitante;  // TEM-UM Passageiro
    private Veiculo veiculo;         // TEM-UM Veiculo
    private String origem;
    private String destino;
    private double valorCorrida;
    private boolean finalizada;

    public Viagem(Passageiro solicitante, Veiculo veiculo, String origem, String destino, double valorCorrida) {
        this.solicitante = solicitante;
        this.veiculo = veiculo;
        this.origem = origem;
        this.destino = destino;
        this.valorCorrida = valorCorrida;
        this.finalizada = false;
    }

    public void iniciarViagem() {
        System.out.println("Viagem iniciada!");
        System.out.println("Passageiro: " + solicitante.getNome());
        System.out.println("Veículo:    " + veiculo.getModelo() + " | " + veiculo.getPlaca());
        System.out.println("Rota:       " + origem + " → " + destino);
        System.out.println("Valor:      R$ " + valorCorrida);
    }

    public void finalizarViagem() {
        if (finalizada) {
            System.out.println("Esta viagem já foi finalizada.");
            return;
        }
        System.out.println("\nFinalizando viagem...");
        boolean pago = solicitante.descontarSaldo(valorCorrida);
        if (pago) {
            finalizada = true;
            System.out.println("Viagem concluída com sucesso!");
        } else {
            System.out.println("Falha ao finalizar: saldo insuficiente.");
        }
    }

    public void exibirResumo() {
        System.out.println("=== Resumo da Viagem ===");
        System.out.println("Passageiro: " + solicitante.getNome());
        System.out.println("Veículo:    " + veiculo.getModelo());
        System.out.println("Rota:       " + origem + " → " + destino);
        System.out.println("Valor:      R$ " + valorCorrida);
        System.out.println("Finalizada: " + finalizada);
    }
}
