package br.cefetrj.sca.dominio;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Habilitacao {
	@OneToOne
	private Long idProfessor;
	
	@OneToOne
	private Long idDisciplina;
	
	
	public Habilitacao(Long idProfessor, Long idDisciplina) {
		this.setIdProfessor(idProfessor);
		this.setIdDisciplina(idDisciplina);
	}


	public Long getIdProfessor() {
		return idProfessor;
	}


	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}


	public Long getIdDisciplina() {
		return idDisciplina;
	}


	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	
	
	
}
