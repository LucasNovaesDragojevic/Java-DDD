package br.com.alura.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.escola.academico.dominio.aluno.CPF;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioSelo;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;

public class RepositorioSeloEmMemoria implements RepositorioSelo {

	private List<Selo> selos = new ArrayList<>();
	
	@Override
	public void adicionar(Selo selo) {
		this.selos.add(selo);
	}

	@Override
	public List<Selo> selosAlunoCPF(CPF cpf) {
		return this.selos
					.stream()
					.filter(selo -> selo.getCpfAluno().equals(cpf))
					.collect(Collectors.toList());
	}
}
