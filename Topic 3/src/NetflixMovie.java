public class NetflixMovie {
    private static int instances = 0;
    private int instance = 0;
    public boolean loaded = false;
    public String title = "";

    public NetflixMovie(String ttl){
        if(instances < 3) {
            instance = instances;
            instances++;
            loaded = true;
            title = ttl;
        }
    }
}
