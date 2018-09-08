package com.br.matrix.lancamentos.lancamentos.configurations;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.matrix.lancamentos.lancamentos.models.MensagemDeErro;

@ControllerAdvice
public class ManipuladorDeExcecaoCustomizado extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
	protected ResponseEntity<Object> handlerConflict(RuntimeException excecao, WebRequest request)
	{
		MensagemDeErro erro = new MensagemDeErro();
		erro.setMensagem("Parâmetros inválidos.");
		return handleExceptionInternal(excecao, erro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = {ExcecaoDeRecursoNaoEncontrado.class})
	protected ResponseEntity<Object> recursoNaoEncontradoHandler(RuntimeException excecao, WebRequest request)
	{
		MensagemDeErro erro = new MensagemDeErro();
		erro.setMensagem("Recurso inexistente.");
		return handleExceptionInternal(excecao, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
