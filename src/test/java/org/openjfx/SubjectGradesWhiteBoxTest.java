

//    White Box Testing
//
//    This file contains test cases for each function
//    in the SubjectGrades class that cover 100% of the following:
//    1- Statement Coverage
//    2- Branch Coverage
//    3- Condition Coverage (when possible)



package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectGradesWhiteBoxTest {
    private SubjectGrades subject;

    @BeforeEach()
    void setUp() {
        subject = new SubjectGrades();
    }

    @Test
    void setSubjectName() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectName("");
        }, "Shouldn't be empty");
        subject.setSubjectName("someSubject");
        assertEquals("someSubject", subject.getSubjectName());
    }


    @Test
    void setSubjectCode() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        //----------------Condition Coverage = 100%---------------------
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("abc12345");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("123abc");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("abc1d23");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("abc123d");
        });
        subject.setSubjectCode("abc123");
        assertEquals("abc123", subject.getSubjectCode());
        subject.setSubjectCode("abc123s");
        assertEquals("abc123s", subject.getSubjectCode());
    }

    @Test
    void setStudentName() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentName("");
        }, "Shouldn't be empty");
        subject.setStudentName("someSubject");
        assertEquals("someSubject", subject.getStudentName());
    }

    @Test
    void setStudentID() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentID("abc12345");
        });
        subject.setStudentID("12345678");
        assertEquals("12345678", subject.getStudentID());
    }

    @Test
    void setOralMark() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        //----------------Condition Coverage = 100%---------------------
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setOralMark(11);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setOralMark(-1);
        });
        subject.setOralMark(5);
        assertEquals(5, subject.getOralMark());
    }

    @Test
    void setMidterm() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        //----------------Condition Coverage = 100%---------------------
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setMidterm(21);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setMidterm(-1);
        });
        subject.setMidterm(10);
        assertEquals(10, subject.getMidterm());
    }

    @Test
    void setFinal() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        //----------------Condition Coverage = 100%---------------------
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setFinal(61);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setFinal(-1);
        });
        subject.setFinal(30);
        assertEquals(30, subject.getFinal());
    }

    @Test
    void setActivities() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        //----------------Condition Coverage = 100%---------------------
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setActivities(11);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setActivities(-1);
        });
        subject.setActivities(5);
        assertEquals(5, subject.getActivities());
    }

    @Test
    void calculateGrade() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        //----------------Condition Coverage = 100%---------------------
        assertThrows(IllegalArgumentException.class, () -> {
            SubjectGrades.calculateGrade(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            SubjectGrades.calculateGrade(101);
        });
        assertEquals("A+", SubjectGrades.calculateGrade(98));
        assertEquals("A", SubjectGrades.calculateGrade(95));
        assertEquals("A-", SubjectGrades.calculateGrade(91));
        assertEquals("B+", SubjectGrades.calculateGrade(86));
        assertEquals("B", SubjectGrades.calculateGrade(82));
        assertEquals("B-", SubjectGrades.calculateGrade(78));
        assertEquals("C+", SubjectGrades.calculateGrade(75));
        assertEquals("C", SubjectGrades.calculateGrade(72));
        assertEquals("C-", SubjectGrades.calculateGrade(68));
        assertEquals("D+", SubjectGrades.calculateGrade(66));
        assertEquals("D", SubjectGrades.calculateGrade(62));
        assertEquals("F", SubjectGrades.calculateGrade(20));
    }

    @Test
    void calculateGPA() {
        //----------------Statement Coverage = 100%---------------------
        //------------------Branch Coverage = 100%----------------------
        //----------------Condition Coverage = 100%---------------------
        assertThrows(IllegalArgumentException.class, () -> {
            SubjectGrades.calculateGPA(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            SubjectGrades.calculateGPA(101);
        });
        assertEquals(4, SubjectGrades.calculateGPA(98));
        assertEquals(4, SubjectGrades.calculateGPA(95));
        assertEquals(3.7, SubjectGrades.calculateGPA(91));
        assertEquals(3.3, SubjectGrades.calculateGPA(86));
        assertEquals(3, SubjectGrades.calculateGPA(82));
        assertEquals(2.7, SubjectGrades.calculateGPA(78));
        assertEquals(2.3, SubjectGrades.calculateGPA(75));
        assertEquals(2, SubjectGrades.calculateGPA(72));
        assertEquals(1.7, SubjectGrades.calculateGPA(68));
        assertEquals(1.3, SubjectGrades.calculateGPA(66));
        assertEquals(1, SubjectGrades.calculateGPA(62));
        assertEquals(0, SubjectGrades.calculateGPA(20));
    }
}
