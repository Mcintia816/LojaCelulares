package ufpb.dcx.br;
import java.io.IOException;

public class CelularInexistenteException extends IOException {
    public CelularInexistenteException(String message) {
        super(message);
    }
}
