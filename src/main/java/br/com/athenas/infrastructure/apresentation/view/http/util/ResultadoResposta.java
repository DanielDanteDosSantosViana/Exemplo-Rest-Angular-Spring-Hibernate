package br.com.athenas.infrastructure.apresentation.view.http.util;

public class ResultadoResposta<T> {

	private String erro;	
	private T resposta;
	
	public T getResposta() {
		return resposta;
	}
	public void setResposta(T resposta) {
		this.resposta = resposta;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
}
