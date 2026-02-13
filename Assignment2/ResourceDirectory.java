import java.util.*;
public class ResourceDirectory {
    private ArrayList<Resource> allResources;

    public ResourceDirectory(){
        allResources = new ArrayList<>();
    }

    public boolean add(Resource resource){
        for(int i = 0; i < allResources.size();i++){
            if(allResources.get(i).equalsResource(resource)){
                return false;
            }
        }
        allResources.add(resource);
        return true;
    }

    public int size(){
        return allResources.size();
    }

    public ArrayList<Resource> getAll(){
        ArrayList<Resource> newResources = new ArrayList<>();
        for(int i = 0; i < this.allResources.size(); i++){
            newResources.add(this.allResources.get(i));
        }
        return newResources;
    }

    public ArrayList<Resource> findByCommunity(String communityName){
        ArrayList<Resource> newResources = new ArrayList<>();
        for(int i = 0; i < this.allResources.size();i++){
            if(this.allResources.get(i).getCommunity().getCommunityName().equalsIgnoreCase(communityName)){
                newResources.add(allResources.get(i));
            }
        }
        return newResources;

    }

    public ArrayList<Resource> findByType(String type){
        ArrayList<Resource> newResources = new ArrayList<>();
        for(int i = 0; i < this.allResources.size();i++){
            if(this.allResources.get(i).getResourceType().equalsIgnoreCase(type)){
                newResources.add(allResources.get(i));
            }
        }
        return newResources;
    }
    public ArrayList<Resource> findByKeyword(String keyword) {
    ArrayList<Resource> result = new ArrayList<>();

    for (int i = 0; i < allResources.size(); i++) {
        Resource r = allResources.get(i);
        if (r.matchesKeyword(keyword)) {
            result.add(r);
        }
    }

    return result;
    }


    public String toString() {
        String s = "ResourceDirectory{size=" + allResources.size() + "}\n";
        for (int i = 0; i < allResources.size(); i++) {
            s += "  " + allResources.get(i) + "\n";
        }
        return s;
    }



}


