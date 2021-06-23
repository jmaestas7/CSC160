package com.school;

public class GradeCalcIfElseVsSwitch {
    public static void main(String[] args) {
        Integer grade = 90;
        String letterGrade = null;
        switch((int) Math.floor(Double.valueOf(grade/10))) {
            case 9: case 10:
                letterGrade = "A";
                break;
            case 8:
                letterGrade = "B";
                break;
            case 7:
                letterGrade = "C";
                break;
            case 6:
                letterGrade = "D";
                break;
            default:
                letterGrade = "F";
                break;
        }

        if (grade >= 90) {
            letterGrade = "A";
        } else if (grade >= 80) {
            letterGrade = "B";
        } else if (grade >= 70) {
            letterGrade = "C";
        } else if (grade >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        System.out.println(letterGrade);
    }

    public String getLetterGradeFromGrade(Integer grade ) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
