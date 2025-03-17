package app;

class XmlConverter implements FileConverter {
    @Override
    public String convertToJson(String content) {
        System.out.println("Convertendo XML para JSON...");

        // Este é um exemplo simplificado de como extrair dados do XML
        String result = "";
        
        // Simulando extração de dados do XML
        if (content.contains("<root>")) {
            result = "{\"root\":{";

            String[] items = content.split("<item>");
            StringBuilder itemsJson = new StringBuilder();
            
            for (int i = 1; i < items.length; i++) {
                String value = items[i].split("</item>")[0];
                itemsJson.append("\"").append(value).append("\"");
                if (i < items.length - 1) {
                    itemsJson.append(",");
                }
            }
            
            result += "\"item\":[" + itemsJson + "]}}";
        }
        
        return result;
    }
}