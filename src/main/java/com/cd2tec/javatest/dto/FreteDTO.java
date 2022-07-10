package com.cd2tec.javatest.dto;


import com.cd2tec.javatest.model.Frete;

public class FreteDTO {
    private Long id;
    private Double peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;

    public FreteDTO() {
    }

    public FreteDTO(Long id, Double peso, String cepOrigem, String cepDestino, String nomeDestinatario) {
        this.id = id;
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.nomeDestinatario = nomeDestinatario;
    }
    public FreteDTO(Frete frete) {
        peso = frete.getPeso();
        cepOrigem = frete.getCepOrigem();
        cepDestino = frete.getCepDestino();
        nomeDestinatario = frete.getNomeDestinatario();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }
}
