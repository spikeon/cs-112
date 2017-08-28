import java.util.ArrayList;
import java.util.List;

public class Students {
    private List<Student> list = new ArrayList<Student>();

    public void addStudent(Student s){
        this.list.add(s);
    }

    public void addStudent(String firstName, String lastName, String SSN, double grade){
        this.list.add(new Student(firstName, lastName, SSN, grade));
    }

    public Students(){
        this.addStudent("Michael", "Flynn", "006-88-3406", 100);
        this.addStudent( "Dumb", "Ass", "123-12-1234", 40);
    }

    public String toString(){
        String result = "";
        for(Student s:this.list) {
            result += s + "\n";
        }
        return result;
    }
}
