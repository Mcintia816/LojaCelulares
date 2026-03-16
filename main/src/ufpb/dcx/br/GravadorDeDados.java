

package LojaDeCelulares;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    private static final String ARQUIVO = "loja_celulares.dat";

    public void gravarDados(Map<String, Celular> dados) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("loja_celulares.dat"));
        oos.writeObject(dados);
        oos.close();
    }

    public HashMap<String, Celular> recuperarDados() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("loja_celulares.dat"));
        HashMap<String, Celular> dados = (HashMap)ois.readObject();
        ois.close();
        return dados;
    }
}
