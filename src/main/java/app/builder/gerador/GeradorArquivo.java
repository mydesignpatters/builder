package app.builder.gerador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import app.builder.gerador.componente.PosProcessador;

/**
 * Classe que define o Template Method
 */
public abstract class GeradorArquivo{
    private PosProcessador myProcessador;

    public void setProcessador(PosProcessador criarProcessador) {
        this.myProcessador = criarProcessador;
	}

    /**
     * processa o arquivo passado e retorna um array de bytes 
     * @param bytes Array de Bytes do Arquivo
     * @return Array de Bytes processados
     */
    protected byte[] processar(byte[] bytes) throws IOException{
        return myProcessador.processar(bytes);
    }

    /**
     * método abstrato para gerar o conteudo do arquivo de acordo com o formato trabalhado 
     * @param propriedades mapa de propriedades do arquivo passado
     * @return conteudo do arquivo
     */
    protected abstract String gerarConteudo(Map<String, Object> propriedades);

    /**
     * Gera um arquivo com sua propriedades
     * @param nome nome do Arquivo
     * @param propriedades propriedades do Arquivo
     * @throws IOException levanta exception caso algo de errado relacionado a I/O
     */
    public final void gerarArquivo(String nome, Map<String, Object> propriedades) throws IOException{
        String conteudo = this.gerarConteudo(propriedades);
        byte[] bytes = conteudo.getBytes();
        bytes = this.processar(bytes);

        FileOutputStream fileOut = new FileOutputStream(nome);
        fileOut.write(bytes);
        fileOut.close();
    }

	public PosProcessador getProcessador() {
		return myProcessador;
	}

}