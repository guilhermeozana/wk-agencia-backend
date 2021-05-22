package br.com.wkagencia.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wkagencia.model.Candidato;
import br.com.wkagencia.request.CandidatoRequest;
import br.com.wkagencia.service.CandidatoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/candidatos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600L) 
public class CandidatoController {
    private final CandidatoService candidatoService;
    
    @PostMapping("/admin/criar")
    public ResponseEntity<Candidato> criar(@RequestBody CandidatoRequest candidatoRequest,
                                @AuthenticationPrincipal UserDetails userDetails){
        return new ResponseEntity<Candidato>(candidatoService.criarCandidato(candidatoRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        candidatoService.deletar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/admin/atualizar")
    public ResponseEntity<Void> atualizar(@RequestBody CandidatoRequest candidatoRequest, 
                                        @AuthenticationPrincipal UserDetails userDetails){
        candidatoService.atualizar(candidatoRequest);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Candidato>> obterTodos(){
        return new ResponseEntity<List<Candidato>>(candidatoService.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> obterPorId(@PathVariable Long id){
        return new ResponseEntity<Candidato>(candidatoService.obterPorId(id), HttpStatus.OK);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Candidato>> obterPorEstado(@PathVariable String estado){
        return new ResponseEntity<List<Candidato>>(candidatoService.obterPorEstado(estado),HttpStatus.OK);
    }

    @GetMapping("/faixa-idade/{idade1}/{idade2}")
    public ResponseEntity<List<Candidato>> obterPorIdade(@PathVariable int idade1, @PathVariable int idade2){
        return new ResponseEntity<List<Candidato>>(candidatoService.obterPorIdade(idade1,idade2), HttpStatus.OK);
    }  
    
    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<List<Candidato>> obterPorSexo(@PathVariable String sexo){
        return new ResponseEntity<List<Candidato>>(candidatoService.obterPorSexo(sexo), HttpStatus.OK);
    }  

    @GetMapping("/tipo-sanguineo/{tipo}")
    public ResponseEntity<List<Candidato>> obterPorTipoSanguineo(@PathVariable String tipo){
        return new ResponseEntity<List<Candidato>>(candidatoService.obterPorTipoSanguineo(tipo), HttpStatus.OK);
    }
}
