

package LojaDeCelulares;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LojaDeCelular implements LojaGerenciador {
    private HashMap<String, Celular> celulares = new HashMap();
    private GravadorDeDados gravador = new GravadorDeDados();

    public boolean cadastrarCelular(String codigo, String marca, String modelo, double preco, int quantUnidades) {
        if (this.celulares.containsKey(codigo)) {
            return false;
        } else {
            Celular c = new Celular(codigo, marca, modelo, preco, quantUnidades);
            this.celulares.put(codigo, c);
            return true;
        }
    }

    public Celular pesquisaCelular(String codigo) throws CelularInexistenteException {
        Celular c = (Celular)this.celulares.get(codigo);
        if (c == null) {
            throw new CelularInexistenteException("Não existe celular com esse código: " + codigo);
        } else {
            return c;
        }
    }

    public void removerCelular(String codigo) throws CelularInexistenteException {
        if (this.celulares.containsKey(codigo)) {
            this.celulares.remove(codigo);
        } else {
            throw new CelularInexistenteException("Não existe celular com esse código: " + codigo);
        }
    }

    public void salvarDados() throws IOException {
        this.gravador.gravarDados(this.celulares);
    }

    public void recuperarDados() throws IOException, ClassNotFoundException {
        this.celulares = this.gravador.recuperarDados();
    }

    public List<Celular> pesquisarCelularPeloModelo(String modelo) {
        List<Celular> modeloC = new ArrayList();

        for(Celular c : this.celulares.values()) {
            if (c.getModelo().equals(modelo)) {
                modeloC.add(c);
            }
        }

        return modeloC;
    }

    public List<Celular> pesquisarCelularPelaMarca(String marca) throws CelularInexistenteException {
        List<Celular> marcaC = new ArrayList();

        for(Celular c : this.celulares.values()) {
            if (c.getMarca().equals(marca)) {
                marcaC.add(c);
            }
        }

        return marcaC;
    }

    public double calcularTotalDaVendaDoCelular(String codigoCelular) {
        double total = (double)0.0F;

        for(Celular c : this.celulares.values()) {
            if (c.getCodigo().equals(codigoCelular)) {
                total += c.getPreco() * (double)c.getQuantUnidades();
            }
        }

        return total;
    }
}
