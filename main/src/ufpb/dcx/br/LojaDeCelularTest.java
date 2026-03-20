package LojaDeCelulares;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LojaDeCelularTest {
    @Test
    public void testaCadastroPesquisaRemocao() {
        LojaDeCelular loja = new LojaDeCelular();

        try {
            loja.pesquisaCelular("123");
            Assert.fail("Deveria lançar exceção");
        } catch (CelularInexistenteException var6) {
        }

        loja.cadastrarCelular("123", "Samsung", "S23", (double)4000.0F, 2);
        loja.cadastrarCelular("456", "Apple", "iPhone 14", (double)7000.0F, 2);

        try {
            Celular c = loja.pesquisaCelular("123");
            Assert.assertEquals("S23", c.getModelo());
        } catch (CelularInexistenteException var5) {
            Assert.fail("Não deveria lançar exceção");
        }

        try {
            loja.removerCelular("456");
        } catch (CelularInexistenteException var4) {
            Assert.fail("Não deveria lançar exceção");
        }

        try {
            loja.pesquisaCelular("456");
            Assert.fail("Deveria lançar exceção");
        } catch (CelularInexistenteException var3) {
        }

    }
}
