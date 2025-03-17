package app;

public class ConversionFacade {
    private XmlConverter xmlConverter;
    private CsvConverter csvConverter;
    private HtmlConverter htmlConverter;
    
    public ConversionFacade() {}
    
    public String convertXmlToJson(String xmlContent) {
        if (xmlConverter == null) {
            xmlConverter = new XmlConverter();
        }
        String result = xmlConverter.convertToJson(xmlContent);
        return "Resultado da conversão XML: " + result;
    }
    
    public String convertCsvToJson(String csvContent) {
        if (csvConverter == null) {
            csvConverter = new CsvConverter();
        }
        String result = csvConverter.convertToJson(csvContent);
        return "Resultado da conversão CSV: " + result;
    }
    
    public String convertHtmlToJson(String htmlContent) {
        if (htmlConverter == null) {
            htmlConverter = new HtmlConverter();
        }
        String result = htmlConverter.convertToJson(htmlContent);
        return "Resultado da conversão HTML: " + result;
        
    }
    
    // Método auxiliar para detectar formato e converter automaticamente
    public String convertToJson(String content, String fileType) {
        switch (fileType.toLowerCase()) {
            case "xml":
                return convertXmlToJson(content);
            case "csv":
                return convertCsvToJson(content);
            case "html":
                return convertHtmlToJson(content);
            default:
                return "Formato de arquivo não suportado: " + fileType;
        }
    }
}
