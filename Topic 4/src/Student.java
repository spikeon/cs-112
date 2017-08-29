public class Student extends User {
    private int id;
    private int[] course_list = new int[5];
    private int num_courses = 0;

    public Student(String u, String p, String e, int i){
        super(u, p, e);
        id = i;
    }

    public boolean enroll(int course_num) {
        if(num_courses == course_list.length) return false;
        course_list[num_courses] = course_num;
        num_courses++;
        return true;
    }

    public String getCourses() {
        String courses = "";
        for(int num : course_list) {
            courses += num + " ";
        }
        return courses;
    }
}
