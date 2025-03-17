import app.ConversionFacade;


public class Main {
    public static void main(String[] args) {
        // Criando o Facade
        ConversionFacade converter = new ConversionFacade();
        
        // Definindo conteúdos de exemplo
        String xmlContent = "<root><item>Valor XML</item><item>Outro valor XML</item></root>";
        String csvContent = "nome,idade,cargo\nJoão,30,Analista\nMaria,25,Desenvolvedora";
        String htmlContent = "<html><body><h1>Título Principal</h1><p>Primeiro parágrafo</p><p>Segundo parágrafo</p></body></html>";
        
        // Testando método com detecção automática
        System.out.println(converter.convertToJson(xmlContent, "xml"));
        System.out.println(converter.convertToJson(csvContent, "csv"));
        System.out.println(converter.convertToJson(htmlContent, "html"));
            
        // Testando formato não suportado
        System.out.println(converter.convertToJson("conteúdo", "pdf"));
     }
}