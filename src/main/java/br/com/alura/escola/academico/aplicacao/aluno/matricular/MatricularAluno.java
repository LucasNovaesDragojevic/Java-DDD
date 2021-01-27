package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.shared.dominio.evento.PublicadorEventos;

public class MatricularAluno {
	
	private final RepositorioDeAlunos repositorio;
	private final PublicadorEventos publicador;

	public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorEventos publicadorEventos) {
		this.repositorio = repositorio;
		this.publicador = publicadorEventos;
	}
	
	// COMMAND
	public void executa(MatricularAlunoDto dados) {
		Aluno novo = dados.criarAluno();
		repositorio.matricular(novo);
		AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
		publicador.publicar(evento);
	}

}
