/* @author Jorge E. Campos II
   Object Oriented Programming
   Sprint 5: SwissArmyKnife
*/
public class HttpRequestIndex extends HttpRequest {
   
    public Boolean readURL(String urlIN) {
        Boolean returnValue = super.readURL(urlIN);
 
        // Reads string and edits contents
        for (String line : urlContent) {
            line = line.trim();
            line = line.replace("{ \"", "");
            
            // Cuts down contents to ""
            if (line.substring(line.length() - 1).contentEquals(",")) {
                line = line.replace("\" },", "");
            }
            else {
                line = line.replace("\" }", "");
            }
            line = line.replace("\" },", "");
 
            // Adds contents into array
            String Tokens[] = line.split("\", \""); 
            // Checks to see how manyy tokens there are
            if (Tokens.length > 1) {
                for (String token : Tokens) {
                    String PerToken[] = token.split("\":\"");
                   
                    // Looks for more links of other json files
                    if (PerToken[1].startsWith("https://")) {
                        // creates object from class to loop through
                        HttpRequest http = new HttpRequest();
                        if (http.readURL(PerToken[1])) {
                            System.out.println(http.toString());
                        }
                        else {
                            // Prints if URL doesn't work
                            System.out.println("Unable to access URL");
                        }
                    }
                }
            }
        }
       
        return returnValue;
    }
 }