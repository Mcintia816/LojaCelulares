package ufpb.dcx.br;

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
    public boolean cadastrarCelular(String codigo, String marca, String modelo, double preco) {
        if(this.celulares.containsKey(codigo)){
            return false;
        }else{
            Celular c = new Celular(codigo, marca, modelo,preco);
            this.celulares.put(codigo,c);
            return true;
        }
    }

    @Override
    public Celular pesquisaCelular(String codigo) throws CelularInexistenteException {
        Celular c = this.celulares.get(codigo);
        if(c==null){
            throw new CelularInexistenteException("Não existe celular com esse código: "+ codigo);

        }
        return c;

    }


    @Override
    public void removerCelular(String codigo) throws CelularInexistenteException {
          if(this.celulares.containsKey(codigo)){
              this.celulares.remove(codigo);
          }else{
              throw new CelularInexistenteException("Não existe celular com esse código: "+ codigo);
          }
    }

    @Override
    public void salvarDados() throws IOException {
          this.gravador.gravarDados(this.celulares);
    }

    @Override
    public void recuperarDados() throws IOException, ClassNotFoundException{
        this.celulares = this.gravador.recuperarDados();
    }


}
