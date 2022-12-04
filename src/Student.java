package src;

import java.util.HashMap;

public class Student {
    public int id;
    public String name;
    public Class c;
    public HashMap<String, Double> score_map = new HashMap<String, Double>();

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public double average_score(){
        int avg = 0;
        for(double a: score_map.values()){
            avg+=a;
        }
        return avg / score_map.size();
    }

    public double subject_score(String subject_name){
        return score_map.get(subject_name);
    }

}
