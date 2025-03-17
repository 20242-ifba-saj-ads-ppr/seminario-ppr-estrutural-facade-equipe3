package app;

class CsvConverter implements FileConverter {
    @Override
    public String convertToJson(String content) {
        System.out.println("Convertendo CSV para JSON...");
        
        // Dividindo o conteúdo em linhas
        String[] lines = content.split("\n");
        if (lines.length < 2) {
            return "[]";
        }
        
        // A primeira linha contém os cabeçalhos
        String[] headers = lines[0].split(",");
        
        StringBuilder jsonBuilder = new StringBuilder("[");
        
        // Processando cada linha de dados
        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(",");
            jsonBuilder.append("{");
            
            // Associando cada valor ao seu cabeçalho
            for (int j = 0; j < Math.min(headers.length, values.length); j++) {
                jsonBuilder.append("\"").append(headers[j]).append("\":\"").append(values[j]).append("\"");
                if (j < Math.min(headers.length, values.length) - 1) {
                    jsonBuilder.append(",");
                }
            }
            
            jsonBuilder.append("}");
            if (i < lines.length - 1) {
                jsonBuilder.append(",");
            }
        }
        
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}
