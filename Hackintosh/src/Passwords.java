import java.util.ArrayList;
import java.util.List;

public class Passwords {
    private List<Password> list = new ArrayList<Password>();
    public void add(Password p){
        list.add(p);
    }
    public boolean check(String pw){
        boolean flag = false;
        for(Password p : list){
            if(p.check(pw)) flag = true;
        }
        return flag;
    }
    public int found(){
        int ctr = 0;
        for(Password p : list){
            if(p.isFound()) ctr++;
        }
        return ctr;
    }
    public boolean isDone(){
        if(found() < list.size()) return false;
        return true;
    }

}
