package br.com.alura.escola.academico;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.PublicadorEventos;
import br.com.alura.escola.academico.dominio.aluno.LogAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {
	
	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";
		
		PublicadorEventos publicador = new PublicadorEventos();
		publicador.adicionar(new LogAlunoMatriculado());
		
		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
		matricular.executa(
				new MatricularAlunoDto(nome, 
						cpf, 
						email));
	}

}
