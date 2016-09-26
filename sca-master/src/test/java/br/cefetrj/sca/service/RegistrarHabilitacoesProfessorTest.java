package br.cefetrj.sca.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.cefetrj.sca.dominio.Curso;
import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.Professor;

public class RegistrarHabilitacoesProfessorTest {
	RegistrarHabilitacoesProfessorService rhp ;
	
	@Before public void initialize() {
		rhp = new RegistrarHabilitacoesProfessorService();
	}
	
	@Test
	public void testSolicitarRegistroHabilitacoesDoProfessorNoCurso(){
		Professor p = new Professor("12345");
		p.habilitarPara(new Disciplina("ASD", "Arquitetura de Softwares Distribuidos", "5", "60horas"));
		Assert.assertNotNull(rhp.solicitarRegistroHabilitacoesDoProfessorNoCurso(p, new Curso("BCC", "Ciencia")));
		//Testa se o retorno nunca é nulo, deve sempre ser ao menos uma lista vazia
	}
	
	@Test
	public void  testAtualizarHabilitacoesProfessor(List<Disciplina> novaListaHabilitacoesProfessor, Professor prof){
		//testa se um professor com apenas uma habilitação será persistido corretamente
		Professor p = new Professor("12345");
		p.habilitarPara(new Disciplina("ASD", "Arquitetura de Softwares Distribuidos", "5", "60horas"));
		Assert.assertNotNull(rhp.solicitarRegistroHabilitacoesDoProfessorNoCurso(p, new Curso("BCC", "Ciencia")));
		Assert.assertEquals(true, rhp.atualizarHabilitacoesProfessor(novaListaHabilitacoesProfessor, prof));
	}
}
