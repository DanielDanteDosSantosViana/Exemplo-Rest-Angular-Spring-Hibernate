package br.com.athenas.infrastructure.persistence;

import org.springframework.stereotype.Component;

import br.com.athenas.domain.entity.Funcionario;
import br.com.athenas.persistence.IFuncionarioDAO;

@Component
public class FuncionarioDAO extends GenericDAO<Funcionario> implements IFuncionarioDAO {

}
