package br.com.athenas.infrastructure.apresentation.view.http.util;

public class OperacaoRequest<T> {

	private T request;
	

	public T getRequest() {
		return request;
	}

	public void setRequest(T request) {
		this.request = request;
	}

}
