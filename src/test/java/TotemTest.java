
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TotemTest {

	private Totem totem = null;

	@Before
	public void setUp() {
		totem = Totem.getInstance();
		totem.reiniciar();
	}

	@Test
	public void reiniciarTest() {

		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 0);

		totem.getFilaNormal().add(new Senha("N-0001"));
		totem.getFilaNormal().add(new Senha("N-0002"));
		totem.getFilaNormal().add(new Senha("N-0003"));
		totem.getFilaNormal().add(new Senha("N-0004"));

		Assert.assertTrue(this.totem.getTamanhoFilaNormal() != 0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 0);

		totem.getFilaPrioridade().add(new Senha("P-0001"));
		totem.getFilaPrioridade().add(new Senha("P-0002"));
		totem.getFilaPrioridade().add(new Senha("P-0003"));
		totem.getFilaPrioridade().add(new Senha("P-0004"));

		Assert.assertTrue(this.totem.getTamanhoFilaNormal() != 0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() != 0);

		totem.reiniciar();

		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 0);

	}

	@Test
	public void gerarSenhaTest() {
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);

		Senha senha = totem.gerarSenha(true);

		Assert.assertTrue(totem.getTamanhoFilaNormal() == 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() != 0);
		Assert.assertTrue(senha.getNumero().startsWith(Totem.PREFIXO_SENHA_PRIORIDADE));

		senha = totem.gerarSenha(false);

		Assert.assertTrue(totem.getTamanhoFilaNormal() != 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() != 0);
		Assert.assertTrue(senha.getNumero().startsWith(Totem.PREFIXO_SENHA_NORMAL));
		
		senha = totem.gerarSenha(true);

		Assert.assertTrue(totem.getTamanhoFilaNormal() != 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() != 0);
		Assert.assertTrue(senha.getNumero().startsWith(Totem.PREFIXO_SENHA_PRIORIDADE));
		Assert.assertTrue(senha.getNumero().equals(Totem.PREFIXO_SENHA_PRIORIDADE + 2));

		senha = totem.gerarSenha(false);

		Assert.assertTrue(totem.getTamanhoFilaNormal() != 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() != 0);
		Assert.assertTrue(senha.getNumero().startsWith(Totem.PREFIXO_SENHA_NORMAL));
		Assert.assertTrue(senha.getNumero().equals(Totem.PREFIXO_SENHA_NORMAL + 2));
	}

	@Test
	public void chamarSenhaTest() {
		Senha senha = null;

		Assert.assertTrue(totem.getTamanhoFilaNormal() == 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);

		totem.gerarSenha(true);
		totem.gerarSenha(false);
		totem.gerarSenha(true);
		totem.gerarSenha(false);
		totem.gerarSenha(true);
		totem.gerarSenha(false);
		totem.gerarSenha(true);
		totem.gerarSenha(false);
		totem.gerarSenha(true);
		totem.gerarSenha(false);

		Assert.assertTrue(totem.getTamanhoFilaNormal() != 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() != 0);
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 5);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 5);

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 5);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 4);
		Assert.assertTrue(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("P1"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 5);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 3);
		Assert.assertTrue(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("P2"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 5);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 2);
		Assert.assertTrue(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("P3"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 5);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 1);
		Assert.assertTrue(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("P4"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 5);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);
		Assert.assertTrue(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("P5"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 4);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);
		Assert.assertFalse(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("N1"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 3);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);
		Assert.assertFalse(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("N2"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 2);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);
		Assert.assertFalse(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("N3"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 1);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);
		Assert.assertFalse(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("N4"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);
		Assert.assertFalse(senha.isPrioridade());
		Assert.assertTrue(senha.getNumero().equals("N5"));

		senha = totem.chamarSenha();
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);

		Assert.assertTrue(senha == null);

	}

	@Test
	public void verificarProximaSenhaTest() {
		Senha senha = null;
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 0);

		totem.gerarSenha(true);
		totem.gerarSenha(false);
		totem.gerarSenha(true);
		totem.gerarSenha(false);
		totem.gerarSenha(true);
		totem.gerarSenha(false);
		totem.gerarSenha(true);
		totem.gerarSenha(false);
		totem.gerarSenha(true);
		totem.gerarSenha(false);

		Assert.assertTrue(totem.getTamanhoFilaNormal() != 0);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() != 0);
		Assert.assertTrue(totem.getTamanhoFilaNormal() == 5);
		Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 5);

		for (int i = 0; i < 100; i++) {
			senha = totem.verificarProximaSenha();
			Assert.assertTrue(totem.getTamanhoFilaNormal() == 5);
			Assert.assertTrue(totem.getTamanhoFilaPrioridade() == 5);
			Assert.assertTrue(senha.isPrioridade());
			Assert.assertFalse(senha.getNumero().equals("N1"));
			Assert.assertTrue(senha.getNumero().equals("P1"));
		}
	}

	@Test
	public void getTamanhoFilaPrioridadeTest() {
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 0);

		totem.getFilaPrioridade().add(new Senha("P0001"));
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 1);

		totem.getFilaPrioridade().add(new Senha("P0002"));
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 2);

		totem.getFilaPrioridade().add(new Senha("P0003"));
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 3);

		totem.getFilaPrioridade().add(new Senha("P0004"));
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 4);

		totem.getFilaPrioridade().add(new Senha("P0005"));
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 5);

		totem.getFilaPrioridade().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 4);

		totem.getFilaPrioridade().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 3);

		totem.getFilaPrioridade().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 2);

		totem.getFilaPrioridade().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 1);

		totem.getFilaPrioridade().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaPrioridade() == 0);

	}

	@Test
	public void getTamanhoFilaNormalTest() {
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 0);

		totem.getFilaNormal().add(new Senha("N0001"));
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 1);

		totem.getFilaNormal().add(new Senha("N0002"));
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 2);

		totem.getFilaNormal().add(new Senha("N0003"));
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 3);

		totem.getFilaNormal().add(new Senha("N0004"));
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 4);

		totem.getFilaNormal().add(new Senha("N0005"));
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 5);

		totem.getFilaNormal().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 4);

		totem.getFilaNormal().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 3);

		totem.getFilaNormal().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 2);

		totem.getFilaNormal().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 1);

		totem.getFilaNormal().remove(0);
		Assert.assertTrue(this.totem.getTamanhoFilaNormal() == 0);

	}

}
