package ufpb.dcx.br;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    private static final String ARQUIVO = "loja_celulares.dat";

    public void gravarDados(Map<String, Celular> dados) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARQUIVO)
        );
        oos.writeObject(dados);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Celular> recuperarDados()
            throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARQUIVO)
        );

        HashMap<String, Celular> dados =
                (HashMap<String, Celular>) ois.readObject();

        ois.close();
        return dados;
    }
}
