package br.com.athenas.service.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.athenas.domain.entity.Funcionario;
import br.com.athenas.domain.repository.FuncionarioRepository;

@Component
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> obtemTodosFuncionarios() throws Exception{
		
		return funcionarioRepository.lista();
	}

	public void removerFuncionario(Long id) throws Exception{
		
		 funcionarioRepository.remove(id);
	}

	public void editarFuncionario(Funcionario funcionario) throws Exception{
		
		 funcionarioRepository.edita(funcionario);
	}

	public void cadastraFuncionario(Funcionario funcionario) throws Exception{
		
		 funcionarioRepository.cadastra(funcionario);
	}

}

