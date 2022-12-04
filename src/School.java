package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class School {
    
    public HashMap<Integer, Class> class_map = new HashMap<Integer, Class>();
    public HashMap<Integer, Student> student_map = new HashMap<Integer, Student>();
    public HashMap<Integer, Teacher> teacher_map = new HashMap<Integer, Teacher>();

    public School(String class_file_path, String teacher_file_path, String student_file_path){    
        this.read_data(class_file_path, teacher_file_path, student_file_path);        
    }

    public int num_student(){
        return student_map.size();
    }

    public double subject_average(String subject_name){
        double avg = 0;
        for(Student s: student_map.values()){
            avg+=s.subject_score(subject_name);
        }
        return avg / this.num_student();
    }


    private void read_data(String class_file_path, String teacher_file_path, String student_file_path){
        // 반-> 학교 -> 학생
        this.read_class_data(class_file_path);
        this.read_teacher_data(teacher_file_path);
        this.read_student_data(student_file_path);
    }

    private void read_student_data(String file_name){        
        File csv = new File(file_name);
        BufferedReader br = null;
        String line = "";        
        try{
            br = new BufferedReader(new FileReader(csv));
            br.readLine();
            while((line=br.readLine())!=null){                
                String[] line_arr = line.split(",");
                int id = Integer.parseInt(line_arr[0]);                
                String name = line_arr[1];
                Student s = new Student(id, name);                
                int class_id = Integer.parseInt(line_arr[2]);
                s.c = this.class_map.get(class_id);
                    
                s.score_map.put("국어", Double.parseDouble(line_arr[3]));
                s.score_map.put("영어", Double.parseDouble(line_arr[4]));
                s.score_map.put("수학", Double.parseDouble(line_arr[5]));
                s.score_map.put("과학", Double.parseDouble(line_arr[6]));
                                
                this.student_map.put(id, s);

            }            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{                
                if(br!=null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }        

    }

    private void read_teacher_data(String file_name){        
        File csv = new File(file_name);
        BufferedReader br = null;
        String line = "";        
        try{
            br = new BufferedReader(new FileReader(csv));
            br.readLine();
            while((line=br.readLine())!=null){                
                String[] line_arr = line.split(",");
                int id = Integer.parseInt(line_arr[0]);
                String name = line_arr[1];
                int class_id = Integer.parseInt(line_arr[2]);
                Teacher t = new Teacher(id, name);
                t.c = this.class_map.get(class_id);
                this.teacher_map.put(t.id, t);
            }            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{                
                if(br!=null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private void read_class_data(String file_name){        
        File csv = new File(file_name);
        BufferedReader br = null;
        String line = "";        
        try{
            br = new BufferedReader(new FileReader(csv));
            br.readLine();
            while((line=br.readLine())!=null){                
                String[] line_arr = line.split(",");
                int id = Integer.parseInt(line_arr[0]);
                String name = line_arr[1];
                Class c = new Class(id, name);
                this.class_map.put(id, c);
            }            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{                
                if(br!=null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
