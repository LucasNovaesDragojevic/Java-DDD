package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {

	private Aluno aluno;
	
	@BeforeEach
	void beforeEach() {
		this.aluno = new FabricaDeAluno().comNomeCPFEmail("Teste", "123.456.789-00", "teste@teste.com").criar();
	}
	
	@Test
	void devePermitirAdicionar2Telefones() {
		this.aluno.adicionarTelefone("00", "123456789");
		this.aluno.adicionarTelefone("11", "123456789");
		assertEquals(2, this.aluno.getTelefones().size());
	}

	@Test
	void naoDevePermitirAdicionar3Telefones() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.aluno.adicionarTelefone("00", "123456789");
			this.aluno.adicionarTelefone("11", "123456789");
			this.aluno.adicionarTelefone("22", "123456789");
		});
	}
}
