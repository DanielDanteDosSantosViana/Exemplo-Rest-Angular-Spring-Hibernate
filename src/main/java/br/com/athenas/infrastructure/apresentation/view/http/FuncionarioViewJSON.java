package br.com.athenas.infrastructure.apresentation.view.http;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.athenas.domain.entity.Funcionario;
import br.com.athenas.infrastructure.apresentation.view.http.util.OperacaoRequest;
import br.com.athenas.infrastructure.apresentation.view.http.util.ResultadoResposta;
import br.com.athenas.service.funcionario.FuncionarioService;

@Component
@RequestMapping("/funcionario")
public class FuncionarioViewJSON {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping( value="/lista" , method = RequestMethod.POST)
	@ResponseBody
	public ResultadoResposta<List<Funcionario>> listaFuncionarios(@RequestBody OperacaoRequest<String>  request){

		ResultadoResposta<List<Funcionario>> resposta = new ResultadoResposta<List<Funcionario>>();
		
		List<Funcionario> funcionarios;
		try {
			
			funcionarios = funcionarioService.obtemTodosFuncionarios();
			resposta.setResposta(funcionarios);
			return resposta;

		} catch (Exception e) {
			e.printStackTrace();
			resposta.setErro(e.getMessage());
			
			return resposta;
		}
		
	}

	@RequestMapping( value="/cria" , method = RequestMethod.POST)
	@ResponseBody
	public ResultadoResposta<String> cadastra(@RequestBody OperacaoRequest<Funcionario>  request){
		ResultadoResposta<String> resposta = new ResultadoResposta<String>();
		try {
			
			funcionarioService.cadastraFuncionario(request.getRequest());
			resposta.setResposta("O usuario :"+request.getRequest().getNome()+" foi cadastrado!");
			return resposta;

		} catch (Exception e) {
			e.printStackTrace();
			resposta.setErro(e.getMessage());
			
			return resposta;
		}
		
	}

	@RequestMapping( value="/remove" , method = RequestMethod.POST)
	@ResponseBody
	public ResultadoResposta<String> deleta(@RequestBody OperacaoRequest<Funcionario>  request){
		ResultadoResposta<String> resposta = new ResultadoResposta<String>();
		try {
			
			funcionarioService.removerFuncionario(request.getRequest().getId());
			resposta.setResposta("O usuario :"+request.getRequest().getNome()+" foi removido!");
			return resposta;

		} catch (Exception e) {
			e.printStackTrace();
			resposta.setErro(e.getMessage());
			
			return resposta;
		}
		
	}

	@RequestMapping( value="/edita" , method = RequestMethod.POST)
	@ResponseBody
	public ResultadoResposta<String> edita(@RequestBody OperacaoRequest<Funcionario>  request){
		ResultadoResposta<String> resposta = new ResultadoResposta<String>();
		try {
			
			funcionarioService.editarFuncionario(request.getRequest());
			resposta.setResposta("O usuario :"+request.getRequest().getNome()+" foi editado!");
			return resposta;

		} catch (Exception e) {
			e.printStackTrace();
			resposta.setErro(e.getMessage());
			
			return resposta;
		}
		
	}


}
