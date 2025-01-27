package summer.academy.cepservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import summer.academy.cepservice.model.Endereco;
import summer.academy.cepservice.service.CepService;
import summer.academy.cepservice.service.EnderecoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CepRestController {

    @Autowired
    private CepService cepService;

    private final static Logger log = LoggerFactory.getLogger(CepRestController.class);

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
        log.info("Consultando CEP: {}", cep);

        Endereco endereco = cepService.buscaEnderecoPorCep(cep);

        log.info("Resposta da API: {}", endereco);

        if (endereco != null && endereco.getCep() != null) {
            endereco = enderecoService.salvarEndereco(endereco);
            log.info("Endereço salvo: {}", endereco);
            return ResponseEntity.ok(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}