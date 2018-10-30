package br.com.cast.aluguel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicatedException() {
		super("Veículo clonado!");
	}
}