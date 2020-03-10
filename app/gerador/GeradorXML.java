package app.gerador;

import java.util.Map;

public class GeradorXML extends GeradorArquivo {

    @Override
    protected String gerarConteudo(Map<String, Object> propriedades) {
        StringBuilder propFileBuilder = new StringBuilder();

        propFileBuilder.append("<properties>");
        for (String prop : propriedades.keySet()){
            String s = "<" + prop +  ">" + propriedades.get(prop) + "</" + prop + ">";
			propFileBuilder.append(s);
        }
        propFileBuilder.append("</properties>");

        return propFileBuilder.toString();
    }
    
}