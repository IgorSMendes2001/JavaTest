package com.cd2tec.javatest.controller;

import com.cd2tec.javatest.dto.FreteDTO;
import com.cd2tec.javatest.dto.FreteResponseDTO;
import com.cd2tec.javatest.service.FreteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/frete")
@Api(value = "API REST Frete")
@CrossOrigin(origins = "*")
public class FreteController {

    @Autowired
    private FreteService freteService;

    @GetMapping(value = "/{peso}/{cepOrigem}/{cepDestino}/{nomeDestinatario}")
    @ApiOperation(value = "Retorna o Frete calculado com sua respectiva data de entrega.")
    public ResponseEntity<FreteResponseDTO> CalculaFreteGet(@PathVariable("peso") Double peso,
                                                               @PathVariable("cepOrigem") String cepOrigem, @PathVariable("cepDestino") String cepDestino,
                                                               @PathVariable("nomeDestinatario") String nomeDestinatario) {
        FreteDTO dto = new FreteDTO();
        dto.setPeso(peso);
        dto.setCepOrigem(cepOrigem);
        dto.setCepDestino(cepDestino);
        dto.setNomeDestinatario(nomeDestinatario);

        FreteResponseDTO response = freteService.calcularFrete(dto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    @ApiOperation(value = "Recebe valores e os salva para calcular o frete")
    public ResponseEntity<FreteResponseDTO> CalculaFretePost(@RequestBody FreteDTO freteDTO) {
        FreteResponseDTO response = freteService.calcularFrete(freteDTO);
        return ResponseEntity.ok().body(response);
    }


}