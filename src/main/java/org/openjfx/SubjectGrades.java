package org.openjfx;

public class SubjectGrades {
    String SubjectName;
    String SubjectCode;
    String StudentName;
    String StudentID;
    int OralMark,Midterm,Final,Activities;

    static int fullMark = 100;
    String GPA;

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        if (!(subjectName.matches("^[a-zA-Z]+( [a-zA-Z]+)*$"))) {
            throw new IllegalArgumentException("Name must contain only alphabetic characters and spaces, and should not start with a space.");
        }

        SubjectName = subjectName;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        if(subjectCode.length() != 7 && subjectCode.length() != 6){
            throw new IllegalArgumentException("Subject code should be 6 or 7 letters");
        }
        String alpaCode = subjectCode.substring(0,2);
        String numCode = subjectCode.substring(3,5);
        if(!alpaCode.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("The first 3 letters should be alphabet");
        } else if (!numCode.matches(("[0-9]+"))) {
            throw new IllegalArgumentException("From fourth to Sixth letters should be numbers");
        }else if (subjectCode.length() == 7){
            if(subjectCode.charAt(6) != 's')
                throw new IllegalArgumentException("The seventh letter should be (S)");
        }
        SubjectCode = subjectCode;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        if (!(studentName.matches("^[a-zA-Z]+( [a-zA-Z]+)*$"))) {
            throw new IllegalArgumentException("Name must contain only alphabetic characters and spaces, and should not start with a space.");
        }
        StudentName = studentName;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
       if (!(studentID.length() == 8 && studentID.substring(0, 7).matches("\\d+"))) {
            throw new IllegalArgumentException("The first seven characters are not all numbers.");
        }
        StudentID = studentID;
    }

    public int getOralMark() {
        return OralMark;
    }

    public void setOralMark(int oralMark) {
        if (!(oralMark >= 0 && oralMark <= 10)) {
            throw new IllegalArgumentException("Mark must be between 0 and 10.");
        }
        OralMark = oralMark;

    }

    public int getMidterm() {
        return Midterm;
    }

    public void setMidterm(int midterm) {
        if (!(midterm >= 0 && midterm <= 20)) {
            throw  new IllegalArgumentException("Mark must be between 0 and 20.");
        }
        Midterm = midterm;
    }

    public int getFinal() {
        return Final;
    }

    public void setFinal(int aFinal) {
        if (!(aFinal >= 0 && aFinal <= 60)) {
            throw new IllegalArgumentException("Mark must be between 0 and 60.");
        }
        Final = aFinal;
    }

    public int getActivities() {
        return Activities;
    }

    public void setActivities(int activities) {
        if (!(activities >= 0 && activities <= 10)) {
            throw new IllegalArgumentException("Mark must be between 0 and 10.");
        }
        Activities = activities;
    }


    public static String calculateGrade(int mark) {
        if (mark > 100 || mark < 0) {
            throw new IllegalArgumentException("Mark should be more than 0 and less than or equal 100");
        }

        if (mark >= 97 && mark <= 100) {
            return "A+";
        } else if (mark >= 93 && mark < 97) {
            return "A";
        } else if (mark >= 89 && mark < 93) {
            return "A-";
        } else if (mark >= 84 && mark < 89) {
            return "B+";
        } else if (mark >= 80 && mark < 84) {
            return "B";
        } else if (mark >= 76 && mark < 80) {
            return "B-";
        } else if (mark >= 73 && mark < 76) {
            return "C+";
        } else if (mark >= 70 && mark < 73) {
            return "C";
        } else if (mark >= 67 && mark < 70) {
            return "C-";
        } else if (mark >= 64 && mark < 67) {
            return "D+";
        } else if (mark >= 60 && mark < 64) {
            return "D";
        } else {
            return "F";
        }
    }
    public static double calculateGPA(int mark) {
        if (mark > 100 || mark < 0) {
            throw new IllegalArgumentException("Mark should be more than 0 and less than or equal 100");
        }

        if (mark >= 97 && mark <= 100) {
            return 4.0;
        } else if (mark >= 93 && mark < 97) {
            return 4.0;
        } else if (mark >= 89 && mark < 93) {
            return 3.7;
        } else if (mark >= 84 && mark < 89) {
            return 3.3;
        } else if (mark >= 80 && mark < 84) {
            return 3.0;
        } else if (mark >= 76 && mark < 80) {
            return 2.7;
        } else if (mark >= 73 && mark < 76) {
            return 2.3;
        } else if (mark >= 70 && mark < 73) {
            return 2.0;
        } else if (mark >= 67 && mark < 70) {
            return 1.7;
        } else if (mark >= 64 && mark < 67) {
            return 1.3;
        } else if (mark >= 60 && mark < 64) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public String gradeCalculator (){
//        this.OralMark = OralMark;
//        this.Midterm = Midterm;
//        this.Final = Final;
//        this.Activities = Activities;
        int Full = OralMark + Midterm + Final + Activities;
        if(Full > 100){
            throw new IllegalArgumentException("Input value cannot be greater than 100");
        }
        String result = calculateGrade(Full);
        return result;
    }


    public double gpaCalculator (){
//        this.OralMark = OralMark;
//        this.Midterm = Midterm;
//        this.Final = Final;
//        this.Activities = Activities;
        int Full = OralMark + Midterm + Final + Activities;
        if(Full > 100){
            throw new IllegalArgumentException("Input value cannot be greater than 100");
        }
        double result = calculateGPA(Full);
        return result;
    }
}


