import java.io.IOException;

public interface LojaGerenciador {
    public void cadastrarCelular(Celular celular);
    public  Celular pesquisaCelular(String codigo) throws IOException, ClassNotFoundException;
    public void removerCelular(String codigo);
    public void salvarDados() throws IOException;
    public void recuperarDados() throws IOException, ClassNotFoundException;


}
