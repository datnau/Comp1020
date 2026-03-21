import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class A2Main {

    private static final String INPUT_FILE = "resources.txt";
    private static final String OUTPUT_FILE = "resources-output.txt";
    public static Community createCommunity(String name, String region) {
        return new Community(name, region);
    }



    public static Resource createResource(String name, String type, Community community, String contact) {
        return new Resource(name, type, community, contact);
    }



    public static ResourceDirectory loadDirectory(String filename) {
        ResourceDirectory dir = new ResourceDirectory();
        boolean sawNonBlank = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                lineNum++;
                if (line.trim().isEmpty()){
                    continue;
                } 
                sawNonBlank = true;
                String[] parts = line.split("\\|", -1);
                if (parts.length != 5) {
                    System.out.println("ERROR (line " + lineNum + "): invalid format -> " + line);
                    continue;
                }
                String resourceName = parts[0].trim();
                String type = parts[1].trim();
                String communityName = parts[2].trim();
                String region = parts[3].trim();
                String contact = parts[4].trim();
                if (resourceName.isEmpty() || type.isEmpty() || communityName.isEmpty() || region.isEmpty() || contact.isEmpty()) {
                    System.out.println("ERROR (line " + lineNum + "): missing field -> " + line);
                    continue;
                }

                Community c = createCommunity(communityName, region);
                Resource r = createResource(resourceName, type, c, contact);
                dir.add(r);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: file not found: " + filename);
            throw new RuntimeException("Missing input file: " + filename);
        } catch (IOException e) {
            System.out.println("ERROR: cannot read file: " + filename);
            throw new RuntimeException("I/O error reading: " + filename);
        }
        if (!sawNonBlank) {
            System.out.println("ERROR: file is blank: " + filename);
            throw new RuntimeException("Blank input file: " + filename);
        }
        return dir;
    }



    public static void saveDirectory(ResourceDirectory directory, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            ArrayList<Resource> all = directory.getAll();

            for (int i = 0; i < all.size(); i++) {
                Resource r = all.get(i);
                Community c = r.getCommunity();

            String resourceName = r.getResourceName();
            if (resourceName == null) resourceName = "";
            resourceName = resourceName.trim();

            String type = r.getResourceType();
            if (type == null) type = "";
            type = type.trim();

            String communityName = c.getCommunityName();
            if (communityName == null) communityName = "";
            communityName = communityName.trim();

            String region = c.getRegion();
            if (region == null) region = "";
            region = region.trim();

            String contact = r.getContact();
            if (contact == null) contact = "";
            contact = contact.trim();

                pw.println(resourceName + "|" + type + "|" + communityName + "|" + region + "|" + contact);
            }
        } catch (IOException e) {
            System.out.println("ERROR: cannot write file: " + filename);
            throw new RuntimeException("Save failed: " + filename, e);
        }

    }



    public static void runMenu(ResourceDirectory directory, String outputFilename){
    Scanner  sc = new Scanner(System.in);
      while(true){
       
        System.out.println("1 - List all resources" );
        System.out.println("2 - Search resources by community");
        System.out.println("3 - Search resources by type");
        System.out.println("4 - Search resources by keyword");
        System.out.println("5 - Add a new resource");
        System.out.println("6 - Save and quit");
        System.out.println("What would you like to do (1-6)?");
        
        if (!sc.hasNextLine()){
            return;
        } 
        String line = sc.nextLine().trim();
        int option;
        try{
            option = Integer.parseInt(line);

        }catch(NumberFormatException e ){
            System.out.println("Please enter a number.");
            continue;
        }
        if (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6) {
            System.out.println("Invalid option. Please choose 1, 2, 3, 4, 5, or 6.");
            continue;
        }

        if(option == 1){
            ArrayList<Resource> all = directory.getAll();
            if(all.size() == 0){
                System.out.println("No resources found!!!!!");
                continue;
            }
            for(int i = 0 ; i < all.size();i++){
                System.out.println(all.get(i));

            }
            
        }
        if(option == 2){
            System.out.println("Enter a community name: ");
            if (!sc.hasNextLine()) return;
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                continue;
            }
            ArrayList<Resource> community = directory.findByCommunity(input);
            if(community.size() == 0){
                System.out.println("No communities found!!!");
            }
            for(int i = 0; i < community.size(); i++){
                System.out.println(community.get(i));
            }
        }


        if(option == 3){
            System.out.println("Enter a type: ");
            if (!sc.hasNextLine()) return;
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                continue;
            }
            ArrayList<Resource> type = directory.findByType(input);
            if(type.size() == 0){
                System.out.println("No types found!!!");
            }
            for(int i = 0; i < type.size(); i++){
                System.out.println(type.get(i));
            }   
        }


        if(option == 4){
            System.out.println("Enter a keyword: ");
            if (!sc.hasNextLine()) return;
            String input = sc.nextLine().trim();
            if(input.isEmpty()){
                continue;
            }
            ArrayList<Resource> keyword = directory.findByKeyword(input);
            if(keyword.size() == 0){
                System.out.println("No keywords found!!!");
            }
            for(int i = 0; i < keyword.size(); i++){
                System.out.println(keyword.get(i));
            }   
            
        }
        if(option == 5){
            System.out.println("Enter resource info (comma-separated 5 fields) OR enter resource name only:");
            if (!sc.hasNextLine()) return;
            String first = sc.nextLine().trim();

            if (first.isEmpty()) {
                System.out.println("ERROR: Blank inputs are not allowed. Resource not added.");
                continue;
            }

            String resourceName, resourceType, communityName, region, contact;

            if (first.contains(",")) {
                String[] parts = first.split(",", -1);
                if (parts.length != 5) {
                    System.out.println("ERROR: Invalid comma-separated format. Need 5 fields.");
                    continue;
                }
                resourceName = parts[0].trim();
                resourceType = parts[1].trim();
                communityName = parts[2].trim();
                region = parts[3].trim();
                contact = parts[4].trim();
            } else {
                resourceName = first;

                System.out.println("Enter a resource type: ");
                if (!sc.hasNextLine()) return;
                resourceType = sc.nextLine().trim();

                System.out.println("Enter a community name: ");
                if (!sc.hasNextLine()) return;
                communityName = sc.nextLine().trim();

                System.out.println("Enter a region: ");
                if (!sc.hasNextLine()) return;
                region = sc.nextLine().trim();

                System.out.println("Enter a contact info: ");
                if (!sc.hasNextLine()) return;
                contact = sc.nextLine().trim();
            }
            if (resourceName.isEmpty() || resourceType.isEmpty() || communityName.isEmpty() || region.isEmpty() || contact.isEmpty()) {
                System.out.println("ERROR: Blank inputs are not allowed. Resource not added.");
                continue;
            }

            Community newCommunity = createCommunity(communityName, region);
            Resource newResource = createResource(resourceName, resourceType, newCommunity, contact);
            boolean added = directory.add(newResource);

            if (!added) {
                System.out.println("Resource already exists (same name and community). Not added.");
            } else {
                System.out.println("Resource added successfully.");
                System.out.println(newResource);
            }
            

        }
        if(option == 6){
           saveDirectory(directory, outputFilename);
           System.out.println("Saved. End of program!!!");
           break;
           
        }
        
      }
    }
    public static void main(String[] args) {
    try {
        ResourceDirectory dir = loadDirectory(INPUT_FILE);
        if (dir.size() == 0) {
            System.out.println("ERROR: No valid resources found in " + INPUT_FILE);
            return;
        }
        runMenu(dir, OUTPUT_FILE);
    } catch (RuntimeException e) {
        return;
    }
}
}
