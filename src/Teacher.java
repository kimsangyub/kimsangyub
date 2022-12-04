package src;


import java.util.ArrayList;


public class Teacher {
    public int id;
    public String name;
    public Class c;
    public ArrayList<Student> student_list = new ArrayList<Student>();

    public Teacher(int id, String name){
        this.id = id;
        this.name = name;
    }
}
