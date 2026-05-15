package br.com.fiapride.model;

public interface Rastreavel {

    // constante de interface — pública, estática e final por padrão
    int INTERVALO_ATUALIZACAO_SEGUNDOS = 30;

    void atualizarLocalizacao(double latitude, double longitude);

    String obterLocalizacao();
}
