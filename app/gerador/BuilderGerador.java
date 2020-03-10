package app.gerador;

import java.io.IOException;
import java.util.Map;

import app.gerador.componente.Compactador;
import app.gerador.componente.Criptografador;
import app.gerador.componente.NullProcessador;
import app.gerador.componente.PosProcessador;
import app.gerador.componente.PosProcessadorComposto;

public class BuilderGerador {
    private GeradorArquivo instancia;

    public BuilderGerador gerandoEmXML() {
        instancia = new GeradorXML();
        return this;
    }

    public BuilderGerador gerandoEmPropriedades(Map<String, Object> propriedades){
        instancia = new GeradorPropriedades();
        instancia.gerarConteudo(propriedades);
        return this;
    }

    public BuilderGerador comCriptografia() {
        adicionaProcessador(new Criptografador(1));
        return this;
    }

    public BuilderGerador comCompactacao() {
        adicionaProcessador(new Compactador());
        return this;
    }

    private void adicionaProcessador(PosProcessador p) {
        PosProcessador atual = instancia.getProcessador();
        
        if(atual instanceof NullProcessador) {
            instancia.setProcessador(p);
        }else{
            PosProcessadorComposto pc = new PosProcessadorComposto();
            pc.add(atual);
            pc.add(p);
            instancia.setProcessador(pc);
}
    }

    public GeradorArquivo construir(String nome, Map<String, Object> propriedades) throws IOException {
        instancia.gerarArquivo(nome, propriedades);
        return instancia;
    }
}