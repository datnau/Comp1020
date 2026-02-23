import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class A2Main {

    private static final String INPUT_FILE = "resource.txt";
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
        } catch (IOException e) {
            System.out.println("ERROR: cannot read file: " + filename);
        }
        if (!sawNonBlank) {
            System.out.println("ERROR: file is blank: " + filename);
        }
        return dir;
    }



    public static void saveDirectory(ResourceDirectory directory, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            ArrayList<Resource> all = directory.getAll();

            for (int i = 0; i < all.size(); i++) {
                Resource r = all.get(i);
                Community c = r.getCommunity();

                String resourceName = r.getResourceName();
                String type = r.getResourceType();
                String communityName = c.getCommunityName();
                String region = c.getRegion();
                String contact = r.getContact();

                bw.write(resourceName + "|" + type + "|" + communityName + "|" + region + "|" + contact);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR: cannot write file: " + filename);
            System.exit(1);
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
        
        String line = sc.nextLine().trim();
        int option;
        try{
            option = Integer.parseInt(line);

        }catch(NumberFormatException e ){
            System.out.println("Please enter a number.");
            continue;
        }

        if(option == 1){
            ArrayList<Resource> all = directory.getAll();
            if(all.size() == 0){
                System.out.println("No resources found!!!!!");
            }
            for(int i = 0 ; i < all.size();i++){
                System.out.println(all.get(i));

            }
            
        }


        if(option == 2){
            System.out.println("Enter a community name: ");
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
            System.out.println("Enter a resource name: ");
            String resourceName = sc.nextLine().trim();

            System.out.println("Enter a resource type: ");
            String resourceType= sc.nextLine().trim();

            System.out.println("Enter a community name: ");
            String communityName = sc.nextLine().trim();

            System.out.println("Enter a region: ");
            String region = sc.nextLine().trim();
            
            System.out.println("Enter a contact info: ");
            String contact = sc.nextLine().trim();

            if(resourceName.isEmpty() || resourceType.isEmpty() || communityName.isEmpty() || region.isEmpty() || contact.isEmpty()){
                System.out.println("One of inputs is EMPTY!!!");
                continue;
            }

            Community newCommunity = createCommunity(communityName, region);
            Resource newResource = createResource(resourceName, resourceType, newCommunity, contact);
            boolean added = directory.add(newResource);

            if (!added) {
                System.out.println("Resource already exists (same name and community). Not added.");
            } else {
                System.out.println("Resource added successfully.");
            }
            

        }
        if(option == 6){
           saveDirectory(directory, outputFilename);
           System.out.println("Saved. End of program!!!");
           break;
        }
        sc.close();
        

      }

    }

 

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("ERROR: expected input and output filenames");
            System.exit(1);
        }
        ResourceDirectory dir = loadDirectory(args[0]);
        saveDirectory(dir, args[1]);
    }
}
