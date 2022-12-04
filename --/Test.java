
import src.Class;
import src.School;
import src.Student;
import src.Teacher;

import java.util.HashMap;


public class Test {

    // for문 쓰는법 -> 두개
    // 일반적인 for문
    // Hashmap, ArrayList -> COllection -> Collection을 for문돌

    //Hashmap, ArrayLIst -> 이것을 선언하는 것-> 이 안에 어떤 메소드들

    // Input/OUtput -> csv를 읽고 쓰는 것
   
    public static void main(String[] args){    
        int a = 5;
        School s = new School("class.csv", "teacher.csv", "student.csv");
        s.subject_average("국어");
        save_result_2(s);
        save_result_3(s);
    }

    // HW0
    // 제 코드를 이해하십쇼
    // school 생성자-> csv파일을 읽어서 hashmap다가 다 집어넣는게

    // HW1 난이도 1
    public static void save_result(){
        // 과목별 1등 학생의 id, 이름, 반, 점수가 무엇인지 csv형태로 정리
    }

    // HW2 난이도 2
    public static void save_result_2(School s){
        HashMap<Integer, Student> student_map = s.student_map;
        Double totalKorean = 0D;
        Double totalEnglish = 0D;
        Double totalMath = 0D;
        Double totalScience = 0D;
        int totalStudent = student_map.size();

        Double firstGradeTotalKorean = 0D;
        Double firstGradeTotalEnglish = 0D;
        Double firstGradeTotalMath = 0D;
        Double firstGradeTotalScience = 0D;
        int firstGradeTotalStudent = 0;

        Double secondGradeTotalKorean = 0D;
        Double secondGradeTotalEnglish = 0D;
        Double secondGradeTotalMath = 0D;
        Double secondGradeTotalScience = 0D;
        int secondGradeTotalStudent = 0;

        Double thirdGradeTotalKorean = 0D;
        Double thirdGradeTotalEnglish = 0D;
        Double thirdGradeTotalMath = 0D;
        Double thirdGradeTotalScience = 0D;
        int thirdGradeTotalStudent = 0;

        for(int i=1;i<student_map.size();i++){
            Student student = student_map.get(i);

            // 전체 과목 별 합산
            totalKorean = Double.sum(totalKorean, student.score_map.get("국어")) ;
            totalEnglish = Double.sum(totalEnglish, student.score_map.get("영어")) ;
            totalMath = Double.sum(totalMath, student.score_map.get("수학")) ;
            totalScience = Double.sum(totalScience, student.score_map.get("과학")) ;

            if (student.c.id == 1) { // 1반 과목 별 합산
                firstGradeTotalKorean = Double.sum(firstGradeTotalKorean, student.score_map.get("국어")) ;
                firstGradeTotalEnglish = Double.sum(firstGradeTotalEnglish, student.score_map.get("영어")) ;
                firstGradeTotalMath = Double.sum(firstGradeTotalMath, student.score_map.get("수학")) ;
                firstGradeTotalScience = Double.sum(firstGradeTotalScience, student.score_map.get("과학")) ;
                firstGradeTotalStudent = firstGradeTotalStudent + 1;
            } else if (student.c.id == 2) { // 2반 과목 별 합산
                secondGradeTotalKorean = Double.sum(secondGradeTotalKorean, student.score_map.get("국어")) ;
                secondGradeTotalEnglish = Double.sum(secondGradeTotalEnglish, student.score_map.get("영어")) ;
                secondGradeTotalMath = Double.sum(secondGradeTotalMath, student.score_map.get("수학")) ;
                secondGradeTotalScience = Double.sum(secondGradeTotalScience, student.score_map.get("과학")) ;
                secondGradeTotalStudent = secondGradeTotalStudent + 1;
            } else if (student.c.id == 3) { // 3반 과목 별 합산
                thirdGradeTotalKorean = Double.sum(thirdGradeTotalKorean, student.score_map.get("국어")) ;
                thirdGradeTotalEnglish = Double.sum(thirdGradeTotalEnglish, student.score_map.get("영어")) ;
                thirdGradeTotalMath = Double.sum(thirdGradeTotalMath, student.score_map.get("수학")) ;
                thirdGradeTotalScience = Double.sum(thirdGradeTotalScience, student.score_map.get("과학")) ;
                thirdGradeTotalStudent = thirdGradeTotalStudent + 1;
            }
        }

        // 전체 평균
        System.out.println(totalKorean/totalStudent);
        System.out.println(totalEnglish/totalStudent);
        System.out.println(totalMath/totalStudent);
        System.out.println(totalScience/totalStudent);

        // 1학년 평균
        System.out.println(firstGradeTotalKorean/firstGradeTotalStudent);
        System.out.println(firstGradeTotalEnglish/firstGradeTotalStudent);
        System.out.println(firstGradeTotalMath/firstGradeTotalStudent);
        System.out.println(firstGradeTotalScience/firstGradeTotalStudent);

        // 2학년 평균
        System.out.println(secondGradeTotalKorean/secondGradeTotalStudent);
        System.out.println(secondGradeTotalEnglish/secondGradeTotalStudent);
        System.out.println(secondGradeTotalMath/secondGradeTotalStudent);
        System.out.println(secondGradeTotalScience/secondGradeTotalStudent);

        // 3학년 평균
        System.out.println(thirdGradeTotalKorean/thirdGradeTotalStudent);
        System.out.println(thirdGradeTotalEnglish/thirdGradeTotalStudent);
        System.out.println(thirdGradeTotalMath/thirdGradeTotalStudent);
        System.out.println(thirdGradeTotalScience/thirdGradeTotalStudent);

    }

    // HW3 난이도 3
    public static void save_result_3(School s){
        HashMap<Integer, Student> student_map = s.student_map;
        int maxSize = student_map.size();
        Double maxAvg = 0D;
        int maxId = 0;

        for (int rank=1;rank<=30;rank++) {

            // student_map안에 최고 등수의 학생을 찾는다.
            for(int i=1;i<=maxSize;i++) {
                // 밑에서 student_map를 삭제해서 null이 나올수 있어서 null이 아닌경우 조건을 건다.
                if (student_map.get(i) != null) {
                    Student student = student_map.get(i);
                    Double sum1 = Double.sum(student.score_map.get("수학"), student.score_map.get("과학"));
                    Double sum2 = Double.sum(student.score_map.get("국어"), student.score_map.get("영어"));
                    Double avg = Double.sum(sum1, sum2)/4;

                    // 최초 1등의 데이터를 찾기 위해 가장 큰 평균을 찾는다.
                    if (maxAvg<=avg) {
                        maxAvg = avg;
                        maxId = i;
                    }
                }
            }

            // 최고 등수의 학생을 출력한다.
            Student student = student_map.get(maxId);
            System.out.println(rank+"등 학생ID:"+ student.id + " 학생이름:" + student.name+
                    " 반ID:"+ student.c.id + " 반이름:" + student.c.name + " 평균점수:"+maxAvg
                    + " 국:" + student.score_map.get("국어")
                    + " 영:" + student.score_map.get("영어")
                    + " 수:" + student.score_map.get("수학")
                    + " 과:" + student.score_map.get("과학"));

            // 최고 등수의 학생을 student_map에서 삭제한다.
            student_map.remove(maxId);
            // 최고 등수 아이디를 0으로 초기화
            maxId = 0;
            // 최고 등수 평균을 0으로 초기화
            maxAvg = 0D;
        }
    }


}
