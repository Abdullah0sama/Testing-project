package org.openjfx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFTest {

    // test cases of functions:
// public void setSubjectName
    @Test
    public void testSetSubjectName_ValidName() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setSubjectName("Mathematics");

        // Assert
        // Ensure no exception is thrown and the subject name is set correctly.
        assertEquals("Mathematics", yourObject.getSubjectName());
    }

    @Test
    public void testSetSubjectName_InvalidSpecialCharacters() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setSubjectName("Physics");

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

    @Test
    public void testSetSubjectName_InvalidStartingWithSpace() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setSubjectName("Chemistry");

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

    @Test
    public void testSetSubjectName_ValidMultipleWords() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setSubjectName("Social Studies");

        // Assert
        // Ensure no exception is thrown and the subject name is set correctly.
        assertEquals("Social Studies", yourObject.getSubjectName());
    }

//public void setStudentName

    @Test
    public void testSetStudentName_ValidName() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setStudentName("John Doe");

        // Assert
        // Ensure no exception is thrown and the student name is set correctly.
        assertEquals("John Doe", yourObject.getStudentName());
    }

    @Test(expected)
    public void testSetStudentName_InvalidSpecialCharacters() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setStudentName("John@Doe");

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }


// public void setStudentID

    @Test
    public void testSetStudentID_ValidID() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setStudentID("12345678");

        // Assert
        // Ensure no exception is thrown and the student ID is set correctly.
        assertEquals("12345678", yourObject.getStudentID());
    }

    @Test
    public void testSetStudentID_InvalidLength() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setStudentID("1234567");

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

    @Test
    public void testSetStudentID_InvalidFirstSevenCharacters() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setStudentID("12A34567");

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

    @Test
    public void testSetStudentID_InvalidAllNonNumeric() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setStudentID("ABCDEFGH");

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }


// public void setOralMark

    @Test
    public void testSetOralMark_ValidMark() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setOralMark(8);

        // Assert
        // Ensure no exception is thrown and the oral mark is set correctly.
        assertEquals(8, yourObject.getOralMark());
    }


    @Test
    public void testSetOralMark_InvalidMarkBelowRange() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setOralMark(-5);

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }
    @Test
    public void testSetOralMark_InvalidMarkAboveRange() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setOralMark(15);

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

//set final

    @Test
    public void testSetFinal_ValidMark() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setFinal(45);

        // Assert
        // Ensure no exception is thrown and the final mark is set correctly.
        assertEquals(45, yourObject.getFinal());
    }


    @Test
    public void testSetFinal_InvalidMarkBelowRange() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setFinal(-5);

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

    @Test
    public void testSetFinal_InvalidMarkAboveRange() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setFinal(75);

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

//set activities

    @Test
    public void testSetActivities_ValidMark() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setActivities(8);

        // Assert
        // Ensure no exception is thrown and the activities mark is set correctly.
        assertEquals(8, yourObject.getActivities());
    }

    @Test
    public void testSetActivities_InvalidMarkBelowRange() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setActivities(-5);

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

    @Test
    public void testSetActivities_InvalidMarkAboveRange() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();

        // Act
        yourObject.setActivities(15);

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }


// calculate grade and gpa

    @Test
    public void testCalculateGrade_ValidMark() {
        // Arrange
        int mark = 85;

        // Act
        String grade = SubjectGrades.calculateGrade(mark);

        // Assert
        assertEquals("B", grade);
    }

    @Test
    public void testCalculateGrade_InvalidMarkBelowRange() {
        // Arrange
        int mark = -5;

        // Act
        String grade = SubjectGrades.calculateGrade(mark);

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

    @Test
    public void testCalculateGrade_InvalidMarkAboveRange() {
        // Arrange
        int mark = 110;

        // Act
        String grade = SubjectGrades.calculateGrade(mark);

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }


// grade and gpa calculator

    @Test
    public void testGradeCalculator_ValidValues() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();
        yourObject.setOralMark(80);
        yourObject.setMidterm(70);
        yourObject.setFinal(85);
        yourObject.setActivities(90);

        // Act
        String grade = yourObject.gradeCalculator();

        // Assert
        assertEquals("B", grade);
    }

    @Test
    public void testGradeCalculator_InvalidValuesAboveRange() {
        // Arrange
        SubjectGrades yourObject = new SubjectGrades();
        yourObject.setOralMark(80);
        yourObject.setMidterm(70);
        yourObject.setFinal(40);
        yourObject.setActivities(60);

        // Act
        String grade = yourObject.gradeCalculator();

        // Assert
        // Expecting an IllegalArgumentException to be thrown.
    }

}
