package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentParserTest {

    StudentParser studentParser;
    @BeforeEach
    void setup() {
        studentParser = new StudentParser();
    }
    @Test
    void parseFileInCorrectOrder() {

        String name = "John Doe", id = "12345678", activity = "8", oral = "9";
        String midterm = "18", finalMark = "50", subject = "English", subjectCode = "ENG101";

        String testText = String.format("%s,%s,100\n", subject, subjectCode) +
                String.format("%s,%s,%s,%s,%s,%s", name, id, activity, oral, midterm, finalMark);

        SubjectGrades subjectGrade = studentParser.parseFile(testText).get(0);

        assertEquals(subject, subjectGrade.getSubjectName());
        assertEquals(subjectCode, subjectGrade.getSubjectCode());
        assertEquals(name, subjectGrade.getStudentName());
        assertEquals(name, subjectGrade.getStudentName());
        assertEquals(id, subjectGrade.getStudentID());
        assertEquals(activity, Integer.toString(subjectGrade.getActivities()));
        assertEquals(oral, Integer.toString(subjectGrade.getOralMark()));
        assertEquals(midterm, Integer.toString(subjectGrade.getMidterm()));
        assertEquals(finalMark, Integer.toString(subjectGrade.getFinal()));
    }

    @Test
    void parseAllFileContent() {
        String name = "John Doe", id = "12345678", activity = "8", oral = "9";
        String midterm = "18", finalMark = "50", subject = "English", subjectCode = "ENG101";

        String testText = String.format("%s,%s,100", subject, subjectCode);
        String student = String.format("%s,%s,%s,%s,%s,%s", name, id, activity, oral, midterm, finalMark);

        int n = 10;
        for(int i = 0; i < n; ++i) {
            testText = testText + "\n" + student;
        }
        assertEquals(n, studentParser.parseFile(testText).size());
    }
}