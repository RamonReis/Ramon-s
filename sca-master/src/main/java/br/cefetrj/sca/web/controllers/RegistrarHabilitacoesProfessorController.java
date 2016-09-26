package br.cefetrj.sca.web.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.cefetrj.sca.dominio.Curso;
import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.Professor;
import br.cefetrj.sca.service.RegistrarHabilitacoesProfessorService;

public class RegistrarHabilitacoesProfessorController {
	@Autowired
	private RegistrarHabilitacoesProfessorService servRH;
	
	public List<List<Disciplina>> solicitarRegistroHabilitacoesDoProfessorNoCurso(Professor Prof, Curso curso){
		return servRH.solicitarRegistroHabilitacoesDoProfessorNoCurso(Prof, curso);
		
	}
	
	public Boolean  atualizarHabilitacoesProfessor(List<Disciplina> novaListaHabilitacoesProfessor, Professor prof){
		if (servRH.atualizarHabilitacoesProfessor(novaListaHabilitacoesProfessor, prof))
			return true;//Mantém o usuário na tela de habilitações
		return false;
	}
	
	public void  ConfirmaEEncerrarRegistro(List<Disciplina> novaListaHabilitacoesProfessor, Professor prof){
		servRH.atualizarHabilitacoesProfessor(novaListaHabilitacoesProfessor, prof);
		//Código para seguir para o menu principal do sistema		
	}
	
}
