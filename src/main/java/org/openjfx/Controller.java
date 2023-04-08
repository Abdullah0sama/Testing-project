package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Controller implements Initializable {

    FileChooser fileChooser;
    String xml, xmlOut;
    File input, output;

    @FXML
    TextArea originalTA = new TextArea();
    @FXML
    TextArea resultTA = new TextArea();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory(new File("src\\sample"));

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters().add(extFilter2);
    }

    public void onLoadFile() {

        input = fileChooser.showOpenDialog(new Stage());

        if (input != null) {
            InputStream orgInStream = System.in;
            try {
                System.setIn(new FileInputStream(input));
            } catch (FileNotFoundException ee) {
                ee.printStackTrace();
            }
            xml = CustomStdIn.readString();

            originalTA.setText(xml);
            CustomStdIn.close();
            System.setIn(orgInStream);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("You must provide a file");
            alert.setContentText("You didn't provide a file");
            alert.showAndWait();
        }
    }

    public void onSaveFile() {
        xml = originalTA.getText();
        output = fileChooser.showSaveDialog(new Stage());

        if (output != null) {
            PrintStream orgOutStream = System.out;
            try {
                System.setOut(new PrintStream(output));
            } catch (FileNotFoundException ee) {
                ee.printStackTrace();
            }
            CustomStdOut.write(xmlOut);

            CustomStdOut.close();
            System.setOut(orgOutStream);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("You must provide a path");
            alert.setContentText("You didn't provide a path to save the file");
            alert.showAndWait();
        }
    }

    public void onCalculateGPA() {
        xml = originalTA.getText();
        if (checkIfEmpty(xml))
            return;

        // ArrayList<String> linesInArrList = new ArrayList<>(Arrays.asList(xml.split("[\n|,]+")));

        // Every line of the input is in a string in the linesInArrList
        // the first line of the input is the course identification line
        // other n lines (after the first one) for all the students in this course
        ArrayList<String> linesInArrList = new ArrayList<>(Arrays.asList(xml.split("[\n|\r]+")));

        ArrayList<SubjectGrades> subjects = parseFile(xml);

        // used to collect the output string to the gui
//        StringBuilder sb = new StringBuilder();
//        for (String element: linesInArrList){
//            sb.append(element).append("\n\n");
//        }
        // show your method result in xmlOut
        xmlOut = subjectsOutput(subjects);
        resultTA.setText(xmlOut);
    }


    String subjectsOutput(ArrayList<SubjectGrades> subjectGrades) {
        ArrayList<String> outputString = new ArrayList<>();
        outputString.add("Subject Name: " + subjectGrades.get(0).getSubjectName());
        outputString.add("Max Mark: " + 100);

        for(int i = 0; i < subjectGrades.size(); ++i) {
            SubjectGrades subject = subjectGrades.get(i);
            String currentSubject = subject.getStudentName() + " " + subject.getStudentID() + " " + subject.gpaCalculator() + " " + subject.gradeCalculator();
            outputString.add(currentSubject);
        }

        return String.join("\n", outputString);
    }
    ArrayList<SubjectGrades> parseFile(String fileContent) {
        ArrayList<String> linesInArrList = new ArrayList<>(Arrays.asList(xml.split("[\n|\r]+")));
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
    SubjectGrades parseStudent(String subjectName, String subjectCode, String studentTxt) {

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


    private static boolean checkIfEmpty(String xml) {
        if (xml.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No XML");
            alert.setHeaderText("You must provide an XML text or file");
            alert.setContentText("Provide an XML");
            alert.showAndWait();
            return true;
        }
        return false;
    }
}
