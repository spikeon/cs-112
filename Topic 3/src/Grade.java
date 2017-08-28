public class Grade {

    private double grade = 0;

    public Grade(double grade){
        this.grade = grade;
    }

    public void setGrade(double grade){
        this.grade = grade;
    }

    public double getGrade(){
        return this.grade;
    }

    public String getLetterGrade() {
        if(this.grade > 90) return "A";
        if(this.grade > 80) return "B";
        if(this.grade > 70) return "C";
        if(this.grade > 60) return "D";
        return "F";
    }

    public String toString(){
        return this.getLetterGrade();
    }

}
