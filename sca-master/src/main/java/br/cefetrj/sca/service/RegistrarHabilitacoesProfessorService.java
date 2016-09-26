package br.cefetrj.sca.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.cefetrj.sca.dominio.Curso;
import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.Professor;
import br.cefetrj.sca.dominio.repositories.HabilitacoesRepositorio;

public class RegistrarHabilitacoesProfessorService {
	@Autowired
	private HabilitacoesRepositorio habilitaRepositorio;
	
	public List<List<Disciplina>> solicitarRegistroHabilitacoesDoProfessorNoCurso(Professor prof, Curso curso){
		try {
			if(prof.getHabilitacoes().size() > 7)
				throw new Exception("numero.de.habilitacoes.excedido");//regra de negócio adicionada para ser um exemplo de aplicação de RN na camada de servico
			
			habilitaRepositorio.solicitarRegistroHabilitacoesDoProfessorNoCurso(prof, curso);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean  atualizarHabilitacoesProfessor(List<Disciplina> novaListaHabilitacoesProfessor, Professor prof){
		for (Iterator it = novaListaHabilitacoesProfessor.iterator(); it.hasNext();) {
			prof.habilitarPara((Disciplina)it);
			
		}
		if (habilitaRepositorio.atualizarHabilitacoesProfessor(prof))
			return true;
		return false;
	}
	
	public Boolean  ConfirmaEEncerrarRegistro(List<Disciplina> novaListaHabilitacoesProfessor, Professor prof){
		for (Iterator it = novaListaHabilitacoesProfessor.iterator(); it.hasNext();) {
			prof.habilitarPara((Disciplina)it);
			
		}
		if (habilitaRepositorio.atualizarHabilitacoesProfessor(prof))
			return true;
		return false;
	}
	
	
}
