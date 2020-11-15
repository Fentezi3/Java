import bean.*;

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
            averageGradeBySubjectInOneGroup(facultyList, "Math", 1, "English");
            System.out.println();
            averageGradeForOneSubjectInUniversity(facultyList, "Math");
        } catch (MyException e) {
            e.getStackTrace();
        }
    }

    private static void validateFacultyGroupStudentsSubjectIsEmpty(List<Faculty> facultyList) throws MyException {
        if (facultyList.isEmpty()) {
            throw new EmptyFacultyListException("You haven't faculty in university.");
        }
        for (Faculty faculty : facultyList) {
            if (faculty.getGroups().isEmpty()) {
                throw new EmptyFacultyGroupsException("You haven't group in " + faculty.getFacultyName() + " faculty");
            }
            for (Group group : faculty.getGroups()) {
                if (group.getStudentsList().isEmpty()) {
                    throw new EmptyStudentListException("You haven't students in " + group.getGroupName() + " group.");
                }
                for (Student students : group.getStudentsList()) {
                    if (students.getSubjects().isEmpty()) {
                        throw new EmptySubjectException("In " + students.getStudentName() + " hasn't subjects");
                    }
                }
            }
        }
    }

    private static void calculateAverageGradeForEachStudent(List<Faculty> facultyList) {
        List<Student> studentsList = new ArrayList<Student>();
        for (Faculty faculty : facultyList) {
            for (Group group : faculty.getGroups()) {
                studentsList.addAll(group.getStudentsList());
            }
        }
        for (Student student : studentsList) {
            Map<String, Integer> subjects = student.getSubjects();
            int sum = 0;
            for (Integer grade : subjects.values()) {
                sum += grade;
            }
            float average = sum / (float) subjects.size();
            System.out.println(student.getStudentName() + "'s average grade is" + " - " + average);
        }
    }

    private static void averageGradeBySubjectInOneGroup(List<Faculty> facultyList, String facultyName,
                                                        int groupName, String subjectName) {
        float sum = 0;
        float average;
        int check = 0;
        List<Student> studentList = new ArrayList<Student>();
        for (Faculty faculty : facultyList) {
            if (faculty.getFacultyName().equals(facultyName)) {
                for (Group group : faculty.getGroups()) {
                    if (group.getGroupName() == groupName) {
                        studentList = group.getStudentsList();
                    }
                }
            }
        }
        for (Student student : studentList) {
            if (student.getSubjects().containsKey(subjectName)) {
                sum += student.getSubjects().get(subjectName);
                check++;
            }
        }
        average = sum / check;
        System.out.println("Average grade in" + " " + facultyName + " " + "faculty," + " " + groupName + " " +
                "group, for " + subjectName + " is - " + average);
    }

    private static void averageGradeForOneSubjectInUniversity(List<Faculty> facultyList, String enteredSubject) {
        float sum = 0;
        int check = 0;
        for (Faculty faculty : facultyList) {
            for (Group group : faculty.getGroups()) {
                for (Student students : group.getStudentsList()) {
                    if (students.getSubjects().containsKey(enteredSubject)) {
                        sum += students.getSubjects().get(enteredSubject);
                        check++;
                    }
                }
            }
        }
        float average = sum / check;
        System.out.println("Average grade for " + enteredSubject + " in all university is - " + average);
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
