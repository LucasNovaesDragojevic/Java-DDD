package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.gamificacao.dominio.selo.RepositorioSelo;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoEvento;

public class GeraSeloAlunoNovato extends Ouvinte {
	
	private final RepositorioSelo repositorioSelo;

	public GeraSeloAlunoNovato(RepositorioSelo repositorioSelo) {
		this.repositorioSelo = repositorioSelo;
	}

	@Override
	protected void reageAo(Evento evento) {
		CPF cpfAluno = (CPF) evento.informacoes().get("CPF");
		Selo novato = new Selo (cpfAluno, "Novato");
		repositorioSelo.adicionar(novato);
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento.tipo() == TipoEvento.ALUNO_MATRICULADO;
	}

}
