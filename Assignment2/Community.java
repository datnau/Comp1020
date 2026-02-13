public class Community{
    private String communityName;
    private String region;

    public Community(String communityName, String region){
        this.communityName = communityName;
        this.region = region;

    }

    public boolean equalsCommunity(Community other){
         if (other == null){
            return false;
         } 
        return this.communityName.equalsIgnoreCase(other.getCommunityName());
    }

    public String getCommunityName(){
        return  this.communityName;
    }

    public String getRegion(){
        return this.region;
    }
    public String toString() {
        return "Community{name='" + communityName + "', region='" + region + "'}";
    }


}