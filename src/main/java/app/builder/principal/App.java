package app.builder.principal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.builder.gerador.GeradorPropriedades;
import app.builder.gerador.GeradorXML;
import app.builder.gerador.componente.Compactador;
import app.builder.gerador.componente.Criptografador;

public class App {
    public static void main(String[] args) {
        System.out.println("Testando o padrão Brigde");

        final GeradorXML meuGeradorXMLCompactado = new GeradorXML();
        Compactador compacta = new Compactador();

        final Map<String, Object> propriedades = new HashMap<String, Object>();
        
        propriedades.put("porta", "8080");
        propriedades.put("banco", "mysql");
        propriedades.put("servidor", "tomcat");

        String nome = "meuArquivoDePropriedadeCompactado.xml";

        System.out.println("Gerando arquivo XML compactado...");

        try {    
            meuGeradorXMLCompactado.setProcessador(compacta);
            meuGeradorXMLCompactado.gerarArquivo(nome, propriedades);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo " + nome + " - " + e.getMessage());
        }
        System.out.println("Arquivo " + nome + " gerado com sucesso!");

        GeradorPropriedades meuGeradorPropriedadesCifrado = new GeradorPropriedades();
        int delay=1;
        Criptografador criptografa = new Criptografador(delay);
        
        String nome2 = "meuArquivodePropriedadesCifrado.txt";
        System.out.println("Gerando arquivo de propriedades crifrado...");
        
        try {
            meuGeradorPropriedadesCifrado.setProcessador(criptografa);
            meuGeradorPropriedadesCifrado.gerarArquivo(nome2, propriedades);
        } catch (Exception e) {
            System.out.println("Erro ao gerar o arquivo " + nome2 + " - " + e.getMessage());
        }
        System.out.println("Arquivo " + nome2 + " gerado com sucesso!");

    }
}