import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LojaDeCelular implements LojaGerenciador {
    private HashMap<String, Celular> celulares;
    private GravadorDeDados gravador;

    public LojaDeCelular() {
        celulares = new HashMap<>();
        gravador = new GravadorDeDados();
    }

    @Override
    public void cadastrarCelular(Celular celular) {
        celulares.put(celular.getCodigo(), celular);
    }

    @Override
    public Celular pesquisaCelular(String codigo) throws IOException, ClassNotFoundException {
        for (Celular c : this.celulares.values()) {
            if (c.getCodigo() == codigo) {
                return c;
            } else {
                throw new CelularInexistenteException("Não existe celular com esse código" + codigo);

            }
        }


    @Override
    public void removerCelular(String codigo){
            celulares.remove(codigo);
        }
    }

    @Override
    public void salvarDados() throws IOException {
        this.gravador.gravarDados(celulares);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.celulares = this.gravador.recuperarDados();

    }

    public Map<String, Celular> getCelular() {
        return celulares;
    }
}
