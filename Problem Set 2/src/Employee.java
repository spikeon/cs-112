/*
Complete Programming Challenge 1 at the end of the chapter "A First Look at Classes".
You need only submit the Employee class. Use these names:
Getters - getName, getID, getDepartment, getPosition
Setters - setName, setID, setDepartment, setPosition
 */

public class Employee {
    private String name;
    private int ID;
    private String department;
    private String position;

    public Employee(){
        this.name = "";
        this.ID = 0;
        this.department = "";
        this.position = "";
    }

    public Employee(String name, int ID, String department, String position){
        this.name = name;
        this.ID = ID;
        this.department = department;
        this.position = position;
    }

    public Employee(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.department = "";
        this.position = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
