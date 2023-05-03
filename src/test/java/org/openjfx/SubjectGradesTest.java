package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectGradesTest {

    SubjectGrades subject;
    @BeforeEach()
    void setup() {
        subject = new SubjectGrades();
    }
    @Test
    void setSubjectName() {
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectName(" something");
        }, "Shouldn't start with space");

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectName("something213");
        }, "Shouldn't have numbers");

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectName("");
        }, "Shouldn't be empty");

        assertDoesNotThrow(() -> {
            subject.setSubjectName("someSubject");
        });

        assertEquals("someSubject", subject.getSubjectName());
    }

    @Test
    void setSubjectCode() {

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("123456");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("123abc");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("abcdef");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setSubjectCode("abc1234");
        });


        subject.setSubjectCode("abc123");
        subject.setSubjectCode("abc123s");



    }

    @Test
    void setStudentID() {

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentID("abc12345");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentID("abcdefgh");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentID("12345678910");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentID("abc12345");
        });


        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentID("");
        });

        subject.setStudentID("12345678");
        subject.setStudentID("1234567D");
        subject.setStudentID("1234567c");

    }

    @Test
    void setOralMark() {
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setOralMark(-1);
        });

        assertDoesNotThrow(() -> {
            subject.setOralMark(0);
        });
        assertDoesNotThrow(() -> {
            subject.setOralMark(1);
        });

        assertDoesNotThrow(() -> {
            subject.setOralMark(5);
        });

        assertDoesNotThrow(() -> {
            subject.setOralMark(10);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setOralMark(11);
        });
    }

    @Test
    void setMidterm() {
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setMidterm(-1);
        });

        assertDoesNotThrow(() -> {
            subject.setMidterm(0);
        });
        assertDoesNotThrow(() -> {
            subject.setMidterm(1);
        });

        assertDoesNotThrow(() -> {
            subject.setMidterm(5);
        });

        assertDoesNotThrow(() -> {
            subject.setMidterm(20);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setMidterm(21);
        });
    }

    @Test
    void setFinal() {
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setFinal(-1);
        });

        assertDoesNotThrow(() -> {
            subject.setFinal(0);
        });
        assertDoesNotThrow(() -> {
            subject.setFinal(1);
        });

        assertDoesNotThrow(() -> {
            subject.setFinal(5);
        });

        assertDoesNotThrow(() -> {
            subject.setFinal(59);
        });

        assertDoesNotThrow(() -> {
            subject.setFinal(60);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setFinal(61);
        });
    }

    @Test
    void setActivities() {
        assertThrows(IllegalArgumentException.class, () -> {
            subject.setActivities(-1);
        });

        assertDoesNotThrow(() -> {
            subject.setActivities(0);
        });
        assertDoesNotThrow(() -> {
            subject.setActivities(1);
        });

        assertDoesNotThrow(() -> {
            subject.setActivities(5);
        });

        assertDoesNotThrow(() -> {
            subject.setActivities(10);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setActivities(11);
        });
    }

    @Test
    void setStudentName() {

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentName(" something");
        }, "Shouldn't start with space");

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentName("something213");
        }, "Shouldn't have numbers");

        assertThrows(IllegalArgumentException.class, () -> {
            subject.setStudentName("");
        }, "Shouldn't be empty");

        assertDoesNotThrow(() -> {
            subject.setStudentName("someSubject");
        });

        assertEquals("someSubject", subject.getStudentName());
    }

    @Test
    void calculateGrade() {
        assertThrows(IllegalArgumentException.class, () -> {
            SubjectGrades.calculateGrade(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            SubjectGrades.calculateGrade(101);
        });

        assertEquals("A+", SubjectGrades.calculateGrade(98));
        assertEquals("A", SubjectGrades.calculateGrade(93));
        assertEquals("A-", SubjectGrades.calculateGrade(89));
        assertEquals("B+", SubjectGrades.calculateGrade(84));
        assertEquals("B", SubjectGrades.calculateGrade(83));
        assertEquals("B-", SubjectGrades.calculateGrade(78));
        assertEquals("C+", SubjectGrades.calculateGrade(75));
        assertEquals("C", SubjectGrades.calculateGrade(71));
        assertEquals("C-", SubjectGrades.calculateGrade(68));
        assertEquals("D+", SubjectGrades.calculateGrade(65));
        assertEquals("D", SubjectGrades.calculateGrade(61));
        assertEquals("F", SubjectGrades.calculateGrade(20));

    }

    @Test
    void calculateGPA() {

        assertThrows(IllegalArgumentException.class, () -> {
            SubjectGrades.calculateGPA(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            SubjectGrades.calculateGPA(101);
        });

        assertEquals(4, SubjectGrades.calculateGPA(98));
        assertEquals(4, SubjectGrades.calculateGPA(93));
        assertEquals(3.7, SubjectGrades.calculateGPA(89));
        assertEquals(3.3, SubjectGrades.calculateGPA(84));
        assertEquals(3, SubjectGrades.calculateGPA(83));
        assertEquals(2.7, SubjectGrades.calculateGPA(78));
        assertEquals(2.3, SubjectGrades.calculateGPA(75));
        assertEquals(2, SubjectGrades.calculateGPA(71));
        assertEquals(1.7, SubjectGrades.calculateGPA(68));
        assertEquals(1.3, SubjectGrades.calculateGPA(65));
        assertEquals(1, SubjectGrades.calculateGPA(61));
        assertEquals(0, SubjectGrades.calculateGPA(20));
    }
}