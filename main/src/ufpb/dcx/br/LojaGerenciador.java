package ufpb.dcx.br;
import java.io.IOException;
import java.util.List;

public interface LojaGerenciador {
    public boolean cadastrarCelular(String codigo, String marca, String modelo, double preco);
    public Celular pesquisaCelular(String codigo) throws CelularInexistenteException;
    public void removerCelular(String codigo) throws  CelularInexistenteException;
    public void salvarDados() throws IOException;
    public void recuperarDados() throws IOException, ClassNotFoundException;


}
