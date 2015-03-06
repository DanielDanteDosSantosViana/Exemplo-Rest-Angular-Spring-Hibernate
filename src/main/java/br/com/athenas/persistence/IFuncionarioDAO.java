package br.com.athenas.persistence;

import java.util.List;

import br.com.athenas.domain.entity.Funcionario;

public interface IFuncionarioDAO {

	List<Funcionario> lista(Class<Funcionario> classe);

	void cadastra(Funcionario funcionario);

	void remove(Class<Funcionario> classType,Long id);

	void edita(Funcionario funcionario);
	
}
