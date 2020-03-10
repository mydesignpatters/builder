package app.gerador.componente;

import java.io.IOException;

public interface PosProcessador {
    /**
     * Processa um array de bytes
     * @param bytes array de bytes
     * @return array de bytes processados
     */
    public byte[] processar(byte[] bytes) throws IOException;

}
