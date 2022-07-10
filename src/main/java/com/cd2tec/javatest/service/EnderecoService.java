package com.cd2tec.javatest.service;

import com.cd2tec.javatest.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {
        private RestTemplate restTemplate = new RestTemplate();

        public Endereco pesquisaCep(String cep) {

            StringBuilder stringBuilder = new StringBuilder(120);
            stringBuilder.append("https://viacep.com.br/ws/");
            stringBuilder.append(cep);
            stringBuilder.append("/json/");

            String url = stringBuilder.toString();
            Endereco endereco = restTemplate.getForObject(url, Endereco.class);

            return endereco;
        }
    }

