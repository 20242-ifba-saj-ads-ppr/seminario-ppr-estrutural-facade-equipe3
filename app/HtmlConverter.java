package app;

class HtmlConverter implements FileConverter {
    @Override
    public String convertToJson(String content) {
        System.out.println("Convertendo HTML para JSON...");
        
        StringBuilder result = new StringBuilder("{");
        

        String title = extractTagContent(content, "h1");
        if (title != null) {
            result.append("\"title\":\"").append(title).append("\",");
        }
        
        String[] paragraphs = extractAllTagContents(content, "p");
        if (paragraphs.length > 0) {
            result.append("\"paragraphs\":[");
            for (int i = 0; i < paragraphs.length; i++) {
                result.append("\"").append(paragraphs[i]).append("\"");
                if (i < paragraphs.length - 1) {
                    result.append(",");
                }
            }
            result.append("]");
        }
        
        result.append("}");
        return result.toString();
    }
    
    private String extractTagContent(String html, String tag) {
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";
        
        int start = html.indexOf(openTag);
        if (start == -1) return null;
        
        start += openTag.length();
        int end = html.indexOf(closeTag, start);
        if (end == -1) return null;
        
        return html.substring(start, end);
    }
    
    private String[] extractAllTagContents(String html, String tag) {
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";
        
        java.util.List<String> contents = new java.util.ArrayList<>();
        int startIndex = 0;
        
        while (true) {
            int start = html.indexOf(openTag, startIndex);
            if (start == -1) break;
            
            start += openTag.length();
            int end = html.indexOf(closeTag, start);
            if (end == -1) break;
            
            contents.add(html.substring(start, end));
            startIndex = end + closeTag.length();
        }
        
        return contents.toArray(new String[0]);
    }
}
