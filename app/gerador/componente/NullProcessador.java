package app.gerador.componente;

import java.io.IOException;

public class NullProcessador implements PosProcessador {

    @Override
    public byte[] processar(byte[] bytes) throws IOException {
        return null;
    }

}
