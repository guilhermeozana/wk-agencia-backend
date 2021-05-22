package br.com.wkagencia.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.wkagencia.exception.CandidatoNaoEncontradoException;
import br.com.wkagencia.model.Candidato;
import br.com.wkagencia.repository.CandidatoRepository;
import br.com.wkagencia.request.CandidatoRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidatoService {
    private final CandidatoRepository candidatoRepository;

    public Candidato criarCandidato(CandidatoRequest candidatoRequest){
        Candidato candidato = Candidato.builder()
            .nome(candidatoRequest.getNome())
            .cpf(candidatoRequest.getCpf())
            .rg(candidatoRequest.getRg())
            .dataNasc(candidatoRequest.getDataNasc())
            .sexo(candidatoRequest.getSexo())
            .mae(candidatoRequest.getMae())
            .pai(candidatoRequest.getPai())
            .email(candidatoRequest.getEmail())
            .cep(candidatoRequest.getCep())
            .endereco(candidatoRequest.getEndereco())
            .numero(candidatoRequest.getNumero())
            .bairro(candidatoRequest.getBairro())
            .cidade(candidatoRequest.getCidade())
            .estado(candidatoRequest.getEstado())
            .telefoneFixo(candidatoRequest.getTelefoneFixo())
            .celular(candidatoRequest.getCelular())
            .altura(candidatoRequest.getAltura())
            .peso(candidatoRequest.getPeso())
            .tipoSanguineo(candidatoRequest.getTipoSanguineo())
            .build();
            
        return candidatoRepository.save(candidato);
    }

    public void deletar(Long id) {
        candidatoRepository.delete(obterPorId(id));
    }

    public void atualizar(CandidatoRequest candidatoRequest) {
        
        Candidato candidatoSalvo = obterPorId(candidatoRequest.getId());

        Candidato novoCandidato = Candidato.builder()
            .nome(candidatoRequest.getNome())
            .cpf(candidatoRequest.getCpf())
            .rg(candidatoRequest.getRg())
            .dataNasc(candidatoRequest.getDataNasc())
            .sexo(candidatoRequest.getSexo())
            .mae(candidatoRequest.getMae())
            .pai(candidatoRequest.getPai())
            .email(candidatoRequest.getEmail())
            .cep(candidatoRequest.getCep())
            .endereco(candidatoRequest.getEndereco())
            .numero(candidatoRequest.getNumero())
            .bairro(candidatoRequest.getBairro())
            .cidade(candidatoRequest.getCidade())
            .estado(candidatoRequest.getEstado())
            .telefoneFixo(candidatoRequest.getTelefoneFixo())
            .celular(candidatoRequest.getCelular())
            .altura(candidatoRequest.getAltura())
            .peso(candidatoRequest.getPeso())
            .tipoSanguineo(candidatoRequest.getTipoSanguineo())
            .build();

        novoCandidato.setId(candidatoSalvo.getId());
        candidatoRepository.save(novoCandidato);
    }

    public List<Candidato> obterTodos(){
        return candidatoRepository.findAll();
    }

    public Candidato obterPorId(Long id) {
        return candidatoRepository.findById(id)
            .orElseThrow(() -> new CandidatoNaoEncontradoException("Candidato não encontrado"));
    }

    public List<Candidato> obterPorEstado(String estado) {
        return candidatoRepository.findByEstado(estado);
    }

    public List<Candidato> obterPorIdade(int idade1, int idade2){

        int dia = LocalDate.now().getDayOfMonth();
        Month mes = LocalDate.now().getMonth();
        int ano = LocalDate.now().getYear();

        LocalDate ate = LocalDate.of(ano - idade1, mes, dia);
        LocalDate de = LocalDate.of(ano - idade2, mes, dia);
        
        return candidatoRepository.findByDataNascBetween(de, ate);
    }

    public List<Candidato> obterPorSexo(String sexo) {
        return candidatoRepository.findBySexo(sexo);
    }

    public List<Candidato> obterPorTipoSanguineo(String tipoSanguineo){
        return candidatoRepository.findByTipoSanguineo(tipoSanguineo);
    }
}
