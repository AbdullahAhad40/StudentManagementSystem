
import java.util.ArrayList;
import java.util.Scanner;

public class RecordUpdate extends SaveAndLoad{
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> list = StudentDataEntry.getStudentsList();
    InputValidation validation = new InputValidation();

    public void updateStudentRecord() {
        while (true) {
            try {

                System.out.println("\n=========================================================");
                System.out.println("                UPDATE EXISTING INFORMATION              ");
                System.out.println("=========================================================");

                System.out.println("\nEnrolled Students...");
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).studentPreview();
                }

                System.out.print("\nEnter student ID to Update Information: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                validation.validateId(id);

                boolean found = false;
                for (int i = 0; i < list.size(); i++) {
                    if (id == list.get(i).getId()) {
                        found = true;

                        System.out.println("\n======================================");
                        System.out.println("\t\t\tOLD RECORD");
                        System.out.println("======================================");
                        list.get(i).displayIndividualInfo();

                        System.out.println("\n======================================");
                        System.out.println("\t\t\tENTER NEW RECORD");
                        System.out.println("======================================");

                        System.out.print("\nEnter new name: ");
                        String newName = scanner.nextLine();
                        validation.nameValidate(newName);

                        System.out.print("Enter New ID: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        validation.validateId(newId);

                        // ===== Section Menu =====
                        String newSection;
                        while (true) {
                            System.out.println("\nSelect Section:");
                            System.out.println("1. A");
                            System.out.println("2. B");
                            System.out.println("3. C");
                            System.out.println("4. D");
                            System.out.println("0. Return to Main Menu");
                            System.out.print("Enter your choice (0-4): ");
                            int sectionChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (sectionChoice) {
                                case 1: newSection = "A"; System.out.println("\nYou have chosen section: "+newSection); break;
                                case 2: newSection = "B"; System.out.println("\nYou have chosen section: "+newSection); break;
                                case 3: newSection = "C"; System.out.println("\nYou have chosen section: "+newSection); break;
                                case 4: newSection = "D"; System.out.println("\nYou have chosen section: "+newSection); break;
                                case 0: System.out.println("\nReturning to main menu"); return;
                                default:
                                    System.out.println("\nInvalid section. Please try again");
                                    continue;
                            }
                            break;
                        }

                        // ===== Semester Menu =====
                        double newSemester;
                        while (true) {
                            System.out.println("\nSelect Semester:");
                            System.out.println("1. 1.1");
                            System.out.println("2. 1.2");
                            System.out.println("3. 2.1");
                            System.out.println("4. 2.2");
                            System.out.println("5. 3.1");
                            System.out.println("6. 3.2");
                            System.out.println("7. 4.1");
                            System.out.println("8. 4.2");
                            System.out.println("0. Return to Main Menu");
                            System.out.print("Enter your choice (0-8): ");
                            int semChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (semChoice) {
                                case 1: newSemester = 1.1; System.out.println("\nYou have chosen semester: "+newSemester); break;
                                case 2: newSemester = 1.2; System.out.println("\nYou have chosen semester: "+newSemester); break;
                                case 3: newSemester = 2.1; System.out.println("\nYou have chosen semester: "+newSemester); break;
                                case 4: newSemester = 2.2; System.out.println("\nYou have chosen semester: "+newSemester); break;
                                case 5: newSemester = 3.1; System.out.println("\nYou have chosen semester: "+newSemester); break;
                                case 6: newSemester = 3.2; System.out.println("\nYou have chosen semester: "+newSemester); break;
                                case 7: newSemester = 4.1; System.out.println("\nYou have chosen semester: "+newSemester); break;
                                case 8: newSemester = 4.2; System.out.println("\nYou have chosen semester: "+newSemester); break;
                                case 0: System.out.println("\nReturning to main menu"); return;
                                default:
                                    System.out.println("\nInvalid semester. Please try again.");
                                    continue;
                            }
                            break;
                        }

                        // ===== Gender Menu =====
                        String newGender;
                        while (true) {
                            System.out.println("\nSelect Gender:");
                            System.out.println("1. Male");
                            System.out.println("2. Female");
                            System.out.println("0. Return to Main Menu");
                            System.out.print("Enter your choice (0-2): ");
                            int genderChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (genderChoice) {
                                case 1: newGender = "MALE"; System.out.println("\nYou have chosen: "+newGender); break;
                                case 2: newGender = "FEMALE"; System.out.println("\nYou have chosen: "+newGender); break;
                                case 0: System.out.println("\nReturning to main menu"); return;
                                default:
                                    System.out.println("Invalid gender choice. Please try again.");
                                    continue;
                            }
                            break;
                        }

                        // ===== Department Menu =====
                        String newDepartment;
                        while (true) {
                            System.out.println("\nSelect Department:");
                            System.out.println("1. CSE");
                            System.out.println("2. EEE");
                            System.out.println("3. L&HR");
                            System.out.println("4. ENG");
                            System.out.println("0. Return to Main Menu");
                            System.out.print("Enter your choice (0-4): ");
                            int deptChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (deptChoice) {
                                case 1: newDepartment = "CSE"; System.out.println("\nYou have chosen: '"+newDepartment+"' department"); break;
                                case 2: newDepartment = "EEE"; System.out.println("\nYou have chosen: '"+newDepartment+"' department"); break;
                                case 3: newDepartment = "L&HR"; System.out.println("\nYou have chosen: '"+newDepartment+"' department"); break;
                                case 4: newDepartment = "ENG"; System.out.println("\nYou have chosen: '"+newDepartment+"' department"); break;
                                case 0: System.out.println("\nReturning to main menu"); return;
                                default:
                                    System.out.println("Invalid department choice. Please try again.");
                                    continue;
                            }
                            break;
                        }

                        double newContinuousAssessment;
                        while(true){
                            try{
                                System.out.print("Enter Continuous Assessment Score (Out of 20): ");
                                newContinuousAssessment = scanner.nextDouble();
                                scanner.nextLine();
                                validation.validateContinuousAssessment(newContinuousAssessment);
                                break;
                            } catch (InvalidContinuousAssessmentException e){
                                System.err.println(e.getMessage());
                            }
                        }

                        double newProjectScore;
                        while (true){
                            try{
                                System.out.print("Enter Project Score (Out of 10): ");
                                newProjectScore = scanner.nextDouble();
                                scanner.nextLine();
                                validation.validateProjectScore(newProjectScore);
                                break;
                            } catch (InvalidProjectScoreException e){
                                System.err.println(e.getMessage());
                            }
                        }

                        double newMidtermAssessment;
                        while (true){
                            try{
                                System.out.print("Enter Midterm Assessment Score (Out of 20): ");
                                newMidtermAssessment = scanner.nextDouble();
                                scanner.nextLine();
                                validation.validateMidtermAssessment(newMidtermAssessment);
                                break;
                            } catch (InvalidMidAssessmentException e){
                                System.err.println(e.getMessage());
                            }
                        }

                        double newFinalAssessment;
                        while(true){
                            try{
                                System.out.print("Enter Final-term Assessment Score (Out of 50): ");
                                newFinalAssessment = scanner.nextDouble();
                                scanner.nextLine();
                                validation.validateFinalAssessment(newFinalAssessment);
                                break;
                            } catch (InvalidFinalAssessmentException e){
                                System.err.println(e.getMessage());
                            }
                        }

                        double newOverallPerformance = newContinuousAssessment + newProjectScore +
                                newMidtermAssessment + newFinalAssessment;

                        list.get(i).setName(newName);
                        list.get(i).setId(newId);
                        list.get(i).setSemester(newSemester);
                        list.get(i).setSection(newSection);
                        list.get(i).setGender(newGender);
                        list.get(i).setDepartment(newDepartment);
                        list.get(i).setContinuousAssessment(newContinuousAssessment);
                        list.get(i).setProjectScore(newProjectScore);
                        list.get(i).setMidtermAssessment(newMidtermAssessment);
                        list.get(i).setFinalAssessment(newFinalAssessment);
                        list.get(i).setOverallPerformance(newOverallPerformance);

                        if (newOverallPerformance < 40) {
                            list.get(i).setStatus("Failed");
                        } else {
                            list.get(i).setStatus("Passed");
                        }

                        saveToFile();

                        System.out.println("\nStudent record updated successfully.");
                        return;
                    }
                }

                if (!found) {
                    System.out.println("Student with ID " + id + " not found. Please try again.");
                }

            } catch (Exception e) {
                System.err.println("\nError: Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }
}
