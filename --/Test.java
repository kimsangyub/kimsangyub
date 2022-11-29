
import src.School;

public class Test {

    // for문 쓰는법 -> 두개
    // 일반적인 for문
    // Hashmap, ArrayList -> COllection -> Collection을 for문돌

    //Hashmap, ArrayLIst -> 이것을 선언하는 것-> 이 안에 어떤 메소드들

    // Input/OUtput -> csv를 읽고 쓰는 것
   
    public static void main(String[] args){    
        School s = new School("class.csv", "teacher.csv", "student.csv");
        s.subject_average("국어");

        
    }

    // HW0
    // 제 코드를 이해하십쇼
    // school 생성자-> csv파일을 읽어서 hashmap다가 다 집어넣는게

    // HW1 난이도 1
    public static void save_result(){
        // 과목별 1등 학생의 id, 이름, 반, 점수가 무엇인지 csv형태로 정리
    }

    // HW1



    // HW2 난이도 2
    public static void save_result_2(){
        // 반별 과목 및 전체 평균 비교
    }

    // HW3 난이도 3
    public static void save_result_3(){
        // 전체 평균점수 기준 1등부터 30등까지 나열
    }


}
