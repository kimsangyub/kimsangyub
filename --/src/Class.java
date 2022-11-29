package src;

import java.util.HashMap;

public class Class {
    int id;
    String name;
    Teacher teacher;
    HashMap<Integer, Student> student_map = new HashMap<Integer, Student>();

    public Class(int id, String name){
        this.id = id;
        this.name = name;
    }

    
}
