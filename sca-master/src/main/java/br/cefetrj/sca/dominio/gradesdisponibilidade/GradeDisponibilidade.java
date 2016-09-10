package br.cefetrj.sca.dominio.gradesdisponibilidade;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.EnumDiaSemana;
import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.PeriodoLetivo;
import br.cefetrj.sca.dominio.Professor;

@Entity
public class GradeDisponibilidade implements Cloneable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Professor professor;

	@ManyToMany
	@JoinTable(name = "GRADEDISPONIBILIDADE_DISCIPLINA", joinColumns = { @JoinColumn(name = "GRADE_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "DISCIPLINA_ID", referencedColumnName = "ID") })
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "GRADEDISPONIBILIDADE_ID", referencedColumnName = "ID")
	private Set<ItemHorario> itensDisponibilidade = new HashSet<ItemHorario>();

	@Embedded
	private PeriodoLetivo semestre;

	@SuppressWarnings("unused")
	private GradeDisponibilidade() {
	}

	public GradeDisponibilidade(Professor professor, PeriodoLetivo semestre) {
		if (professor == null) {
			throw new IllegalArgumentException("Professor deve ser fornecido.");
		}
		this.professor = professor;
		this.semestre = semestre;
	}

	public GradeDisponibilidade(Professor professor) {
		this.professor = professor;
		this.semestre = (PeriodoLetivo) PeriodoLetivo.PERIODO_CORRENTE;
	}

	public Long getId() {
		return id;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Set<ItemHorario> getItensDisponibilidade() {
		return itensDisponibilidade;
	}

	public PeriodoLetivo getSemestre() {
		return semestre;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Disciplina adicionarDisciplina(Disciplina disciplina) {
		if (disciplina == null) {
			throw new IllegalArgumentException("Disciplina não fornecida.");
		}
		if (!this.professor.estaHabilitado(disciplina)) {
			throw new IllegalArgumentException(
					"Professor não está habilitado para disciplina \""
							+ disciplina.getNome() + "\".");
		}
		if(this.disciplinas.contains(disciplina)){
			throw new IllegalArgumentException("Habilitação já registrada.");
		}
		this.disciplinas.add(disciplina);
		return disciplina;
	}

	public void removerDisciplina(Disciplina disciplina) {
		disciplinas.remove(disciplina);
	}

	@Override
	public GradeDisponibilidade clone() {
		GradeDisponibilidade copia = new GradeDisponibilidade(this.professor,
				(PeriodoLetivo) this.semestre);
		copia.setDisciplinas(this.disciplinas);
		for (ItemHorario item : itensDisponibilidade) {
			copia.itensDisponibilidade.add((ItemHorario) item);
		}
		return copia;
	}

	private void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void adicionarItemHorario(String diaStr, String fim, String inicio) {
		EnumDiaSemana dia = EnumDiaSemana.findByText(diaStr);
		ItemHorario itemFornecido = getItemHorario(dia, inicio, fim);
		for (ItemHorario item : itensDisponibilidade) {
			if (itemFornecido.equals(item)) {
				throw new IllegalArgumentException("Item já inserido.");
			} else if (itemFornecido.colide(item)) {
				throw new IllegalArgumentException("Colisão de horários");
			}
		}
		itensDisponibilidade.add(itemFornecido);
	}

	private ItemHorario getItemHorario(EnumDiaSemana dia, String inicio, String fim) {
		ItemHorario item = new ItemHorario(dia, fim, inicio);
		for (ItemHorario itemHorario : itensDisponibilidade) {
			if (itemHorario.equals(item)) {
				return itemHorario;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Semestre letivo: " + this.semestre);

		buffer.append("Disciplinas:\n");
		for (Disciplina disciplina : this.disciplinas) {
			buffer.append(disciplina.getNome() + "\n");
		}

		buffer.append("Hor�rios:\n");
		for (ItemHorario item : this.itensDisponibilidade) {
			buffer.append(item.getInicio() + " �s " + item.getFim() + "\n");
		}
		return buffer.toString();
	}

	public void adicionarItemHorario(EnumDiaSemana dia, String horaInicial,
			String horaFinal) {
		ItemHorario item;
		item = new ItemHorario(dia, horaInicial, horaFinal);
		this.itensDisponibilidade.add(item);
	}

	public int getQuantidadeDisciplinas() {
		return disciplinas.size();
	}

	public int getQuantidadeDisponibilidades() {
		return itensDisponibilidade.size();
	}
}