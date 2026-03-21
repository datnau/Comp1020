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
    if (other == null || this.community == null){
        return false;
    }
    String a = this.community.getCommunityName();
    String b = other.getCommunityName();
    if (a == null || b == null){
        return false;
    }
    return a.trim().equalsIgnoreCase(b.trim());
}



    public boolean matchesType(String type) {
    if (type == null || this.resourceType == null){
        return false;
    } 
    return this.resourceType.equalsIgnoreCase(type.trim());
}
    

    public boolean matchesKeyword(String keyword) {
    if (keyword == null){
        return false;
    }
    String key = keyword.trim().toLowerCase();
    if (key.isEmpty()){
        return false;
    }
    boolean inName = (resourceName != null) && resourceName.toLowerCase().contains(key);
    boolean inContact = (contact != null) && contact.toLowerCase().contains(key);
    return inName || inContact;
}


    public boolean equalsResource(Resource other) {
    if (other == null){
        return false;

    } 
    if (this.resourceName == null || other.resourceName == null){
        return false;
    }
    if (this.community == null || other.community == null){
        return false;
    }

    return this.resourceName.trim().equalsIgnoreCase(other.resourceName.trim())
        && this.community.equalsCommunity(other.community);
}
      

    public String toString() {
        return "Resource {name= '" + resourceName + ", type= " + resourceType + ", community= " + community + ", contact= " + contact + "}";
    }

}
