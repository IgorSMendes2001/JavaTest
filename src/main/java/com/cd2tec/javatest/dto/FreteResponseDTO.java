package com.cd2tec.javatest.dto;

import com.cd2tec.javatest.model.Frete;

import java.time.LocalDate;

public class FreteResponseDTO {
    private String cepOrigem;
    private String cepDestino;
    private Double vlTotalFrete;
    private LocalDate dataPrevistaEntrega;

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

    public Double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public void setVlTotalFrete(Double vlTotalFrete) {
        this.vlTotalFrete = vlTotalFrete;
    }

    public LocalDate getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public FreteResponseDTO(){

    }

    public FreteResponseDTO(String cepOrigem, String cepDestino, Double vlTotalFrete, LocalDate dataPrevistaEntrega) {
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.vlTotalFrete = vlTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }
    public FreteResponseDTO(Frete frete){
        cepOrigem=frete.getCepOrigem();
        cepDestino=frete.getCepDestino();
        vlTotalFrete=frete.getVlTotalFrete();
        dataPrevistaEntrega=frete.getDataPrevistaEntrega();
    }
}
