/* @author Jorge E. Campos II
   Object Oriented Programming
   Sprint 5: SwissArmyKnife
*/   

public class sak {

    public static void main(String[] args) {

        System.out.println("Starting Swiss Army Knife\n");
        
        // Case and check for command line arguments
        if (args.length == 2){

            // Checks which command user wants
            if ((args[0].equalsIgnoreCase("--HttpRequest") || (args[0].equalsIgnoreCase("-i")))){
                // Sets URL 
                String URL = args[1];

                // Creates an object from class
                HttpRequest http = new HttpRequest();
                System.out.println("Starting HTTPRequest!\n");
                
                // Reads and print from URL
                if(http.readURL(URL)){
                    System.out.println(http);
            
                }else{
                    // Prints if URL doesn't work
                    System.out.println("Unable to access URL\n");
                }
            }
            // Checks and check for command line arguments
            if ((args[0].equalsIgnoreCase("--HttpRequestIndex") || (args[0].equalsIgnoreCase("-j")))){
                // Sets URL
                String URL = args[1];

                // Creates an object from class
                HttpRequestIndex index = new HttpRequestIndex();
                System.out.println("Starting HTTPRequestIndex!\n");

                // Reads and prints from URL
                if(index.readURL(URL)){
                    System.out.println(index);

                }else{
                    // Prints if URL doesn't work
                    System.out.println("Unable to access URL\n");
                }
            }
        }
        // If arguments are more or less than 2 
        if(args.length < 2 || args.length > 2){    
            // prints if argument is help flag
            if ((args[0].equalsIgnoreCase("--Help") || args[0].equalsIgnoreCase("-h"))){
                System.out.println("./sak <flag> [URL]\n  -i or --HttpRequest - Reqests pages from URL\n  -j or --HttpRequestIndex - Requests Index from URL");

            }else{
                // Prints if user makes an error
                System.out.println("Invaid Input: ./sak <flag> [URL]\n  -i or --HttpRequest - Reqests pages from URL\n  -j or --HttpRequestIndex - Requests Index from URL");
                
            }
        }


    }
}