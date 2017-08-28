public class Student {

    public String getName(){
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    private String first_name, last_name, SSN;
    private Grade grade;

    public Student(String first_name, String last_name, String SSN, double grade){
        this.grade = new Grade(grade);
        this.first_name = first_name;
        this.last_name = last_name;
        this.SSN = SSN;
    }

    public boolean equals(Object other){
        if(!(other instanceof Student)) return false;
        Student s = (Student) other;
        return this.SSN.equals(s.SSN);
    }

    public String toString(){
        return this.getName() + ":\t" + this.grade;
    }

}
