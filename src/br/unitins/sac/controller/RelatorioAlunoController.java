package br.unitins.sac.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unitins.frame.application.Util;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Aluno;
import br.unitins.sac.model.Cidade;
import br.unitins.sac.repository.AlunoRepository;
import br.unitins.sac.repository.CidadeRepository;

@ManagedBean
@ViewScoped
public class RelatorioAlunoController  {

	private List<Aluno> listaAluno;
	private List<Cidade> listaCidade;
	private Cidade cidade;

	public List<Aluno> getListaAluno() {
		if (listaAluno == null) {
			AlunoRepository repository = new AlunoRepository(JPAFactory.getEntityManager());
			if (getCidade().getId() == null)
				listaAluno = repository.bucarTodos();
			else
				listaAluno = repository.bucarPorCidade(getCidade().getId());
		}
		return listaAluno;
	}
	
	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			CidadeRepository repository = new CidadeRepository(JPAFactory.getEntityManager());
			listaCidade = repository.bucarTodos();
		}
		return listaCidade;
	}
	
	public void imprimir() {
		Util.redirectNewPage("alunoReport?ID_CIDADE="+getCidade().getId());
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}
	
	public void pesquisar() {
		listaAluno = null;
	}

	public Cidade getCidade() {
		if (cidade == null)
			cidade = new Cidade();
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
		

}
