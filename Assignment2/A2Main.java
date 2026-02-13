import java.io.*;
import java.util.ArrayList;

public class A2Main {

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

                if (line.trim().isEmpty()) continue;
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
            System.exit(1);
        } catch (IOException e) {
            System.out.println("ERROR: cannot read file: " + filename);
            System.exit(1);
        }

        if (!sawNonBlank) {
            System.out.println("ERROR: file is blank: " + filename);
            System.exit(1);
        }

        return dir;
    }

    public static void saveDirectory(ResourceDirectory directory, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            ArrayList<Resource> all = directory.getAll();

            for (int i = 0; i < all.size(); i++) {
                Resource r = all.get(i);
                Community c = r.getCommunity();

                String resourceName = safe(r.getResourceName());
                String type = safe(r.getResourceType());
                String communityName = safe(c.getCommunityName());
                String region = safe(c.getRegion());
                String contact = safe(r.getContact());

                bw.write(resourceName + "|" + type + "|" + communityName + "|" + region + "|" + contact);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("ERROR: cannot write file: " + filename);
            System.exit(1);
        }
    }

    private static String safe(String s) {
        return s == null ? "" : s.trim();
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
