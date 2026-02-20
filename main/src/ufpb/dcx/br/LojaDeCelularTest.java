package ufpb.dcx.br;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LojaDeCelularTest {

    @Test
    public void testaCadastroPesquisaRemocao() {

        LojaDeCelular loja = new LojaDeCelular();

        try {
            loja.pesquisaCelular("123");
            fail("Deveria lançar exceção");
        } catch (CelularInexistenteException e) {
        }

        loja.cadastrarCelular("123", "Samsung", "S23", 4000.0);
        loja.cadastrarCelular("456", "Apple", "iPhone 14", 7000.0);

        try {
            Celular c = loja.pesquisaCelular("123");
            assertEquals("Samsung", c.getMarca());
        } catch (CelularInexistenteException e) {
            fail("Não deveria lançar exceção");
        }

        try {
            loja.removerCelular("456");
        } catch (CelularInexistenteException e) {
            fail("Não deveria lançar exceção");
        }

        try {
            loja.pesquisaCelular("456");
            fail("Deveria lançar exceção");
        } catch (CelularInexistenteException e) {
        }
    }
}
