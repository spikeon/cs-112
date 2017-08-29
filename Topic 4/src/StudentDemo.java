public class StudentDemo {

        public static void main(String[] args){
            Student user = new Student("mwagner", "letmein", "mwagner@hancockcollege.edu", 2600);

            user.changePassword("longpassword123");
            user.enroll(5000);
            user.enroll(6400);
            System.out.println(user.getUsername());
            System.out.println(user.getCourses());
        }

}

