package app.builder.principal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.builder.gerador.BuilderGerador;
import app.builder.gerador.GeradorArquivo;

public class AppBuilder {
    public static void main(String[] args) {
        System.out.println("Testando o padrão Builder");

        final Map<String, Object> propriedades = new HashMap<String, Object>();
        propriedades.put("porta", "8080");
        propriedades.put("banco", "mysql");
        propriedades.put("servidor", "tomcat");

        String nome = "meuArquivoDePropriedadeCompactado.xml";

        try {
            GeradorArquivo ga = new BuilderGerador()
                                .gerandoEmXML()
                                .gerandoEmPropriedades(propriedades)
                                .comCriptografia()
                                .construir(nome, propriedades);

            System.out.println("Gerando arquivo de propriedades XML criptografado...");
            System.out.println("Arquivo " + nome + " gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo " + nome + " - " + e.getMessage());
        }

    }
}