package br.cefetrj.sca.dominio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.cefetrj.sca.dominio.Curso;
import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.Professor;

public interface HabilitacoesRepositorio {
	//utilizará os dois métodos abaixo
	public List<List<Disciplina>> solicitarRegistroHabilitacoesDoProfessorNoCurso(Professor Prof, Curso curso);
	
	@Query("Select * from disciplina d, habilitacao h, professor p, curso c"
			+ "where p.id == h.idProfessor and h.idDisciplina == d.id and curso c.disciplinas == d.id")
	public List<Disciplina> listaHablitacoesProfessor();
	
	@Query("Select * from disciplina d, curso c"
			+ "where c.disciplinas == d.id")
	public List<Disciplina> disciplinas();
	
	

	@Query("Delete from habilitacao h"
			+ "where h.idProfessor ==  prof.id"
			+ "Insert into habiltitacao "
			+ "values novaListaHabilitacoesProfessor")
	public Boolean  atualizarHabilitacoesProfessor(Professor prof);
	
}
