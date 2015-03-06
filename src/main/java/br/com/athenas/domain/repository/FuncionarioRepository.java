package br.com.athenas.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.athenas.domain.entity.Funcionario;
import br.com.athenas.persistence.IFuncionarioDAO;

@Component
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FuncionarioRepository {

	@Autowired
	private IFuncionarioDAO funcionarioDAO;
	
	@Transactional(readOnly = false)
	public List<Funcionario> lista(){
		
		return funcionarioDAO.lista(Funcionario.class);
	}

	@Transactional(readOnly = false)
	public void cadastra(Funcionario funcionario){

		funcionarioDAO.cadastra(funcionario);
	}

	@Transactional(readOnly = false)
	public void remove(Long id){

		funcionarioDAO.remove(Funcionario.class,id);
	}

	@Transactional(readOnly = false)
	public void edita(Funcionario funcionario){

		funcionarioDAO.edita(funcionario);
	}

}
