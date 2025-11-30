
import java.util.ArrayList;
import java.util.Scanner;

public class StudentResultEntry extends SaveAndLoad{
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> list = StudentDataEntry.getStudentsList();
    InputValidation validation = new InputValidation();


    public void enterMarks() {
        try {

            System.out.println("\n=========================================================");
            System.out.println("                ENTER MARKS FOR ALL STUDENTS             ");
            System.out.println("=========================================================");

            if (list.isEmpty()) {
                System.out.println("\nNo students enrolled yet");
                return;
            }

            for (int i = 0; i < list.size(); i++) {
                Student s = list.get(i);

                while (true) {
                    try {
                        System.out.println("\nEntering marks for: " + s.getName() + " (ID: " + s.getId() + ")");

                        double continuousAssessment;
                        while(true){
                            try{
                                System.out.print("Enter Continuous Assessment Score (Out of 20): ");
                                continuousAssessment = scanner.nextDouble();
                                scanner.nextLine();
                                validation.validateContinuousAssessment(continuousAssessment);
                                break;
                            } catch (InvalidContinuousAssessmentException e){
                                System.err.println(e.getMessage());
                            }
                        }

                        double projectScore;
                        while (true){
                            try{
                                System.out.print("Enter Project Score (Out of 10): ");
                                projectScore = scanner.nextDouble();
                                scanner.nextLine();
                                validation.validateProjectScore(projectScore);
                                break;
                            } catch (InvalidProjectScoreException e){
                                System.err.println(e.getMessage());
                            }
                        }

                        double midtermAssessment;
                        while (true){
                            try{
                                System.out.print("Enter Midterm Assessment Score (Out of 20): ");
                                midtermAssessment = scanner.nextDouble();
                                scanner.nextLine();
                                validation.validateMidtermAssessment(midtermAssessment);
                                break;
                            } catch (InvalidMidAssessmentException e){
                                System.err.println(e.getMessage());
                            }
                        }

                        double finalAssessment;
                        while(true){
                            try{
                                System.out.print("Enter Final-term Assessment Score (Out of 50): ");
                                finalAssessment = scanner.nextDouble();
                                scanner.nextLine();
                                validation.validateFinalAssessment(finalAssessment);
                                break;
                            } catch (InvalidFinalAssessmentException e){
                                System.err.println(e.getMessage());
                            }
                        }

                        double overallPerformance = continuousAssessment + projectScore + midtermAssessment + finalAssessment;

                        s.setContinuousAssessment(continuousAssessment);
                        s.setProjectScore(projectScore);
                        s.setMidtermAssessment(midtermAssessment);
                        s.setFinalAssessment(finalAssessment);
                        s.setOverallPerformance(overallPerformance);

                        if (overallPerformance < 40) {
                            s.setStatus("Failed");
                        } else {
                            s.setStatus("Passed");
                        }

                        saveToFile();
                        break;

                    } catch (Exception e) {
                        System.err.println("\nError: Something Went Wrong...Please try again.");
                        scanner.nextLine();
                    }
                }
            }

            System.out.println("\nAll student marks updated successfully");

        } catch (Exception e) {
            System.err.println("\nUnexpected error occurred.");
        }
    }


    public void enterSpecificIdMarks() {
        while (true) {
            try {

                System.out.println("\n=========================================================");
                System.out.println("            ENTER MARKS FOR SPECIFIC STUDENTS            ");
                System.out.println("=========================================================");

                System.out.println("\nEnrolled Students...");
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).studentPreview();
                }


                int id;
                while (true) {
                    try {
                        System.out.print("Enter Registration Number to add mark: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        validation.validateId(id);
                        break;
                    } catch (InvalidIdException e) {
                        System.err.println(e.getMessage());
                        scanner.nextLine();
                    }
                }

                Student targetStudent = null;
                for (int i = 0; i < list.size(); i++) {
                    Student s = list.get(i);
                    if (s.getId() == id) {
                        targetStudent = s;
                        break;
                    }
                }

                if (targetStudent == null) {
                    System.out.println("Student with ID " + id + " not found. Please try again.");
                    continue;
                }

                double continuousAssessment;
                while(true){
                    try{
                        System.out.print("Enter Continuous Assessment Score (Out of 20): ");
                        continuousAssessment = scanner.nextDouble();
                        scanner.nextLine();
                        validation.validateContinuousAssessment(continuousAssessment);
                        break;
                    } catch (InvalidContinuousAssessmentException e){
                        System.err.println(e.getMessage());
                    }
                }

                double projectScore;
                while (true){
                    try{
                        System.out.print("Enter Project Score (Out of 10): ");
                        projectScore = scanner.nextDouble();
                        scanner.nextLine();
                        validation.validateProjectScore(projectScore);
                        break;
                    } catch (InvalidProjectScoreException e){
                        System.err.println(e.getMessage());
                    }
                }

                double midtermAssessment;
                while (true){
                    try{
                        System.out.print("Enter Midterm Assessment Score (Out of 20): ");
                        midtermAssessment = scanner.nextDouble();
                        scanner.nextLine();
                        validation.validateMidtermAssessment(midtermAssessment);
                        break;
                    } catch (InvalidMidAssessmentException e){
                        System.err.println(e.getMessage());
                    }
                }

                double finalAssessment;
                while(true){
                    try{
                        System.out.print("Enter Final-term Assessment Score (Out of 50): ");
                        finalAssessment = scanner.nextDouble();
                        scanner.nextLine();
                        validation.validateFinalAssessment(finalAssessment);
                        break;
                    } catch (InvalidFinalAssessmentException e){
                        System.err.println(e.getMessage());
                    }
                }

                double overallPerformance = continuousAssessment + projectScore + midtermAssessment + finalAssessment;

                targetStudent.setContinuousAssessment(continuousAssessment);
                targetStudent.setProjectScore(projectScore);
                targetStudent.setMidtermAssessment(midtermAssessment);
                targetStudent.setFinalAssessment(finalAssessment);
                targetStudent.setOverallPerformance(overallPerformance);

                if (overallPerformance < 40) {
                    targetStudent.setStatus("Failed");
                } else {
                    targetStudent.setStatus("Passed");
                }

                saveToFile();
                System.out.println("Marks updated successfully.");
                return;

            } catch (Exception e) {
                System.err.println("\nError: Something Went Wrong...Please try again.");
                scanner.nextLine();
            }
        }
    }

}
