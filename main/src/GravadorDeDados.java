import java.io.*;
import java.util.Map;

import static java.lang.Math.E;

public class GravadorDeDados {

    private static final String ARQUIVO = "loja_celulares.dat";

    public void gravarDados(Map<String, ?> dados) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARQUIVO)
        );
        double e = E;
        oos.writeObject(dados);
        oos.close();
    }


    @SuppressWarnings("unchecked")
    public Map recuperarDados() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARQUIVO)
        );
        Map dados = (Map) ois.readObject();
        ois.close();
        return dados;
    }
}
