package com.cd2tec.javatest.service;

import com.cd2tec.javatest.dto.FreteDTO;
import com.cd2tec.javatest.dto.FreteResponseDTO;
import com.cd2tec.javatest.model.Endereco;
import com.cd2tec.javatest.model.Frete;
import com.cd2tec.javatest.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class FreteService {

        @Autowired
        private FreteRepository freteRepository;

        @Autowired
        private EnderecoService enderecoService;


        private Double pesagemKg =1.0;

        public FreteResponseDTO calcularFrete(FreteDTO freteDTO) {

            FreteResponseDTO freteResponseDTO = new FreteResponseDTO();

            Double valorFrete = freteDTO.getPeso() * pesagemKg;
            LocalDate dataPrevistaEntrega = LocalDate.now();
            Endereco enderecoDeOrigem = enderecoService.pesquisaCep(freteDTO.getCepOrigem());
            Endereco enderecoDeDestino = enderecoService.pesquisaCep(freteDTO.getCepDestino());

            if(enderecoDeOrigem.getDdd().equals(enderecoDeDestino.getDdd())) {

                double porcentagem = 50.0 / 100.0;
                valorFrete -= (porcentagem * valorFrete);
                dataPrevistaEntrega = dataPrevistaEntrega.plusDays(1);

                freteResponseDTO.setVlTotalFrete(valorFrete);
                freteResponseDTO.setDataPrevistaEntrega(dataPrevistaEntrega);
            }

            if(enderecoDeOrigem.getUf().equals(enderecoDeDestino.getUf())) {

                double porcentagem = 75.0 / 100.0;
                valorFrete -= (porcentagem * valorFrete);
                dataPrevistaEntrega = dataPrevistaEntrega.plusDays(3);

                freteResponseDTO.setVlTotalFrete(valorFrete);
                freteResponseDTO.setDataPrevistaEntrega(dataPrevistaEntrega);
            }

            if(!enderecoDeOrigem.getUf().equals(enderecoDeDestino.getUf())) {

                dataPrevistaEntrega = dataPrevistaEntrega.plusDays(10);
                freteResponseDTO.setDataPrevistaEntrega(dataPrevistaEntrega);
            }

            freteResponseDTO.setVlTotalFrete((double) (Math.round(valorFrete*100.0)/100.0));
            freteResponseDTO.setCepOrigem(freteDTO.getCepOrigem());
            freteResponseDTO.setCepDestino(freteDTO.getCepDestino());

            insert(freteDTO, freteResponseDTO);
            return freteResponseDTO;
        }

        @Transactional
        public void insert(FreteDTO freteDTO, FreteResponseDTO freteResponseDTO) {
            Frete entity = new Frete();
            entity.setPeso(freteDTO.getPeso());
            entity.setCepDestino(freteDTO.getCepDestino());
            entity.setCepOrigem(freteDTO.getCepOrigem());
            entity.setNomeDestinatario(freteDTO.getNomeDestinatario());

            entity.setVlTotalFrete(freteResponseDTO.getVlTotalFrete());
            entity.setDataPrevistaEntrega(freteResponseDTO.getDataPrevistaEntrega());
            entity.setDataConsulta(LocalDate.now());

            freteRepository.save(entity);
        }
    }

