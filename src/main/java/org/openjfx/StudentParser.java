package org.openjfx;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentParser {

    private SubjectGrades parseStudent(String subjectName, String subjectCode, String studentTxt) {

        SubjectGrades student = new SubjectGrades();

        student.setSubjectName(subjectName);
        student.setSubjectCode(subjectCode);
        ArrayList<String> studentData = new ArrayList<>(Arrays.asList(studentTxt.split(",")));

        if(studentData.size() != 6) {
            throw new IllegalArgumentException("Some student arguments are missing!");
        }

        student.setStudentName(studentData.get(0));
        student.setStudentID(studentData.get(1));
        student.setActivities(Integer.parseInt(studentData.get(2)));
        student.setOralMark(Integer.parseInt(studentData.get(3)));
        student.setMidterm(Integer.parseInt(studentData.get(4)));
        student.setFinal(Integer.parseInt(studentData.get(5)));
        return student;
    }

    ArrayList<SubjectGrades> parseFile(String fileContent) {
        ArrayList<String> linesInArrList = new ArrayList<>(Arrays.asList(fileContent.split("[\n|\r]+")));
        String[] subjectInfo = linesInArrList.get(0).split(",");
        String subjectName = subjectInfo[0];
        String subjectCode = subjectInfo[1];
        String subjectMaxMark = subjectInfo[2];

        ArrayList<SubjectGrades> subjectsGrades = new ArrayList<>();

        for (int i = 1; i < linesInArrList.size(); ++i) {
            subjectsGrades.add(parseStudent(subjectName, subjectCode, linesInArrList.get(i)));
        }

        return subjectsGrades;
    }

}
