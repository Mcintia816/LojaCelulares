

package LojaDeCelulares;

import java.io.IOException;
import java.util.List;

public interface LojaGerenciador {
    boolean cadastrarCelular(String var1, String var2, String var3, double var4, int var6);

    Celular pesquisaCelular(String var1) throws CelularInexistenteException;

    void removerCelular(String var1) throws CelularInexistenteException;

    void salvarDados() throws IOException;

    void recuperarDados() throws IOException, ClassNotFoundException;

    List<Celular> pesquisarCelularPeloModelo(String var1);

    List<Celular> pesquisarCelularPelaMarca(String var1) throws CelularInexistenteException;

    double calcularTotalDaVendaDoCelular(String var1);
}
