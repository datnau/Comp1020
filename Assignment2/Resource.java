public class Resource {
    private String resourceName;
    private String resourceType;
    private Community community;
    private String contact;

    public Resource(String resourceName, String resourceType, Community community, String contact){
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.community = community;
        this.contact = contact;
    }

   

    public String getResourceType(){
        return this.resourceType;
    }

    public Community getCommunity(){
        return this.community;
    }

    public String getResourceName(){
        return this.resourceName;
    }
    public String getContact(){
        return this.contact;
    }

    public boolean matchesCommunity(Community other){
       return this.community.getCommunityName().equalsIgnoreCase(other.getCommunityName());
    }
     public boolean matchesType(String type){
        if(this.resourceType.equalsIgnoreCase(type)){
            return true;
        }
        return false;
    }
    public boolean matchesKeyword(String keyword) {
    if (keyword == null) return false;

    String key = keyword.toLowerCase();

    return (resourceName != null && resourceName.toLowerCase().contains(key))
        || (contact != null && contact.toLowerCase().contains(key));
    }


    public boolean equalsResource(Resource other) {
    if (other == null){
       return false;
    } 
    return this.resourceName.equalsIgnoreCase(other.resourceName)
        && this.community.equalsCommunity(other.community);
    }
      

    public String toString() {
        return "Resource{name='" + resourceName + "', type='" + resourceType
                + "', community=" + community
                + ", contact='" + contact + "'}";
    }

}
