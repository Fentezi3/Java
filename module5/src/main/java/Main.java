import bean.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Faculty> facultyList = createFacultyList();
        try {
            validateFacultyGroupStudentsSubjectIsEmpty(facultyList);
            calculateAverageGradeForEachStudent(facultyList);
            System.out.println();
            calculateAverageGradeInOneGroup(facultyList, "Math", 1, "English");
            System.out.println();
            calculateAverageGradeForOneSubjectInUniversity(facultyList, "Math");
        } catch (MyException e) {
            e.getStackTrace();
        }
    }

    /**
     * This method validate what this data is not null.
     * @param facultyList all faculty in university in 1 list.
     * @throws MyException parent class for all exceptions in this app
     */
    private static void validateFacultyGroupStudentsSubjectIsEmpty(List<Faculty> facultyList) throws MyException {
        /**
         * Faculty list can't be empty.
         */
        if (facultyList.isEmpty()) {
            /**
             * @throws EmptyFacultyListException if faculty list is empty -  write about this in console.
             */
            throw new EmptyFacultyListException("There is no faculties in university.");
        }
        for (Faculty faculty : facultyList) {
            /**
             * Checks groups in every faculty.
             */
            if (faculty.getGroups().isEmpty()) {
                /**
                 * @throws EmptyFacultyGroupsException if faculty hasn't group, we write exception massage.
                 */
                throw new EmptyFacultyGroupsException("There is no group in " + faculty.getName() + " faculty");
            }
            for (Group group : faculty.getGroups()) {
                /**
                 * Each group need has students.
                 */
                if (group.getStudentList().isEmpty()) {
                    /**
                     * @throws EmptyStudentListException if group is empty, write message.
                     */
                    throw new EmptyStudentListException("There is no students in " + group.getName() + " group.");
                }
                for (Student students : group.getStudentList()) {
                    /**
                     * Every student need have some subject.
                     */
                    if (students.getSubjects().isEmpty()) {
                        /**
                         * @throws EmptySubjectException if student hasn't subject - write message about this.
                         */
                        throw new EmptySubjectException("There is " + students.getName() + " no subjects");
                    }
                }
            }
        }
    }

    /**
     * Calculate average grade for all subjects for each student.
     * @param facultyList all faculty in university.
     */
    private static void calculateAverageGradeForEachStudent(List<Faculty> facultyList) {
        List<Student> studentsList = new ArrayList();
        for (Faculty faculty : facultyList) {
            for (Group group : faculty.getGroups()) {
                /**
                 * Sort out all faculty and groups. Find each student and add in studentsList.
                 */
                studentsList.addAll(group.getStudentList());
            }
        }
        for (Student student : studentsList) {
            /**
             * Take each student and calculate average grade for all subjects.
             */
            Map<String, Integer> subjects = student.getSubjects();
            int sum = student.getSubjects().values().stream().mapToInt(Integer::intValue).sum();
            float average = sum / (float) subjects.size();
            String textPrint = String.format( "%s's average grade: %s%n", student.getName(), average);
            System.out.println(textPrint);
        }
    }

    /**
     * Calculation average grade in particular faculty and group, on a particular subject.
     * @param facultyList all faculty in university.
     * @param facultyName particular faculty for calculation.
     * @param groupName particular group for calculation.
     * @param subjectName particular subject for calculation.
     */
    private static void calculateAverageGradeInOneGroup(List<Faculty> facultyList, String facultyName,
                                                        int groupName, String subjectName) {
        float sum = 0;
        float average;
        int counter = 0;
        List<Student> studentList = new ArrayList<>();
        for (Faculty faculty : facultyList) {
            if (faculty.getName().equals(facultyName)) {
                for (Group group : faculty.getGroups()) {
                    if (group.getName() == groupName) {
                        /**
                         * Create student's list from given faculty and group.
                         */
                        studentList = group.getStudentList();
                    }
                }
            }
        }
        for (Student student : studentList) {
            /**
             * Find given subject in the each student, sum up graduate for this subject, and calculate average.
             */
            Map<String, Integer> subjects = student.getSubjects();
            if (subjects.containsKey(subjectName)) {
                sum += subjects.get(subjectName);
                counter++;
            }
        }
        average = sum / counter;
        System.out.println("Average grade in " + facultyName + " faculty, " + groupName +
                " group, for " + subjectName + " : " + average);
    }

    /**
     * Calculation average grade for given subject in all university.
     * @param facultyList all faculty in university.
     * @param subjectName given subject.
     */
    private static void calculateAverageGradeForOneSubjectInUniversity(List<Faculty> facultyList, String subjectName) {
        float sum = 0;
        int counter = 0;
        for (Faculty faculty : facultyList) {
            for (Group group : faculty.getGroups()) {
                for (Student students : group.getStudentList()) {
                    Map<String, Integer> subjects = students.getSubjects();
                    if (subjects.containsKey(subjectName)) {
                        sum += subjects.get(subjectName);
                        counter++;
                    }
                }
            }
        }
        float average = sum / counter;
        System.out.println("Average grade for " + subjectName + " in all university is - " + average);
    }

    private static List<Faculty> createFacultyList() {
        Map<String, Integer> subjects1 = new HashMap<String, Integer>();
        subjects1.put("Math", 7);
        subjects1.put("English", 6);
        subjects1.put("Physic", 4);
        Map<String, Integer> subjects2 = new HashMap<String, Integer>();
        subjects2.put("Math", 5);
        subjects2.put("English", 6);
        subjects2.put("Physic", 8);
        Map<String, Integer> subjects3 = new HashMap<String, Integer>();
        subjects3.put("Math", 3);
        subjects3.put("English", 3);
        subjects3.put("Physic", 9);
        Map<String, Integer> subjects4 = new HashMap<String, Integer>();
        subjects4.put("Math", 9);
        subjects4.put("English", 9);
        subjects4.put("Physic", 6);

        Student student1 = new Student("John", subjects1);
        Student student2 = new Student("Bob", subjects2);
        Student student3 = new Student("Sue", subjects3);
        Student student4 = new Student("Charlie", subjects4);

        List<Student> group1Students = new ArrayList<Student>();
        group1Students.add(student1);
        group1Students.add(student2);
        List<Student> group2Students = new ArrayList<Student>();
        group2Students.add(student3);
        List<Student> group3Students = new ArrayList<Student>();
        group3Students.add(student4);

        Group group1 = new Group(1, group1Students);
        Group group2 = new Group(2, group2Students);
        Group group3 = new Group(3, group3Students);

        List<Group> mathFacultyGroups = new ArrayList<Group>();
        mathFacultyGroups.add(group1);
        List<Group> humanityFacultyGroups = new ArrayList<Group>();
        humanityFacultyGroups.add(group2);
        humanityFacultyGroups.add(group3);

        Faculty mathFaculty = new Faculty("Math", mathFacultyGroups);
        Faculty humanityFaculty = new Faculty("Humanity", humanityFacultyGroups);

        List<Faculty> facultyList = new ArrayList<Faculty>();
        facultyList.add(mathFaculty);
        facultyList.add(humanityFaculty);
        return facultyList;
    }
}