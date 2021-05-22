package br.com.wkagencia.exception;

public class CandidatoNaoEncontradoException extends RuntimeException {
    public CandidatoNaoEncontradoException(String message){
        super(message);
    }
}
