import java.util.ArrayList;
import java.util.List;

public class Redditor extends User {
    private int id;
    private static List<Link> links = new ArrayList<Link>();

    public Redditor(String u, String p, String e, int i) {
        super(u, p, e);
        id = i;
    }

    public boolean postLink(String title, String url) {
        for(Link link : links) {
            if(link.url.equals(url)) return false;
        }
        links.add(new Link(title, url));
        return true;
    }

    public static List<Link> getLinks(){
        return links;
    }

}
