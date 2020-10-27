package com.example.module2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) throws ParseException {
        List<Student> studentList = generateStudentList();
        List<Student> filmFaculty = printFilmFacultyStudents(studentList);
        studentsBornEarlieThat(studentList);
        printStudentsFromOneGroup(filmFaculty);
        System.out.println();
        facultyGroupList(studentList);
    }

    private static List<Student> generateStudentList() throws ParseException {
        Student student1 = new Student("Doe", "Joe", "Jonovich");
        Student student2 = new Student("Billigan", "Tommy", "Joevich", "+375 25 555 00 42");
        Student student3 = new Student("Grib", "Olga", "Ol'govna", "+375 55 874 98 77");
        Student student4 = new Student("Wick", "John", "Jordanovich", "+7 983 778 00 07");
        Student student5 = new Student("Potter", "Harry", "Ivanovich", "+89 983 784 83 98");
        Student student6 = new Student("Batty", "Roy", "Nexsus 6", "+42 424 242 42 42");

        Address address1 = new Address("Singapure", "Kuara Lumupur",
                "18765", "Borrowman", 7897, 2);
        Address address2 = new Address("Belarus", "Minsk",
                "220000", "Nezalejnosti", 4, 42);
        Address address3 = new Address("Poland", "Wrzlav",
                "297000", "Klaus Pshche", 8, 192);
        Address address4 = new Address("US", "Oklahoma",
                "987846", "Tompsom Johnes", 7, 11);
        Address address5 = new Address("UK", "Belfast",
                "111000", "God Save Queen", 1, 1);
        Address address6 = new Address("US", "NewNewYork",
                "544500", "Hopes", 98, 3);

        String date1 = "01.03.2000";
        String date2 = "20.02.1931";
        String date3 = "11.11.1976";
        String date4 = "01.01.1970";
        String date5 = "31.06.1997";
        String date6 = "12.12.1912";

        Date birthDate6 = format.parse(date6);
        student6.setDateOfBirth(birthDate6);
        student6.setAddress(address6);
        student6.setCourse(Course.SIXTH);
        student6.setFaculty(Faculty.THEATRICAL);
        student6.setGroup(Group.TWO);
        System.out.println(student6);

        Date birthDate5 = format.parse(date5);
        student5.setDateOfBirth(birthDate5);
        student5.setAddress(address5);
        student5.setCourse(Course.THIRD);
        student5.setFaculty(Faculty.FILM);
        student5.setGroup(Group.ONE);
        System.out.println(student5);

        Date birthDate4 = format.parse(date4);
        student4.setDateOfBirth(birthDate4);
        student4.setAddress(address4);
        student4.setCourse(Course.FIFTH);
        student4.setFaculty(Faculty.FILM);
        student4.setGroup(Group.TWO);
        System.out.println(student4);

        Date birthDate3 = format.parse(date3);
        student3.setDateOfBirth(birthDate3);
        student3.setAddress(address3);
        student3.setCourse(Course.SIXTH);
        student3.setFaculty(Faculty.ART);
        student3.setGroup(Group.ONE);
        System.out.println(student3);

        Date birthDate2 = format.parse(date2);
        student2.setDateOfBirth(birthDate2);
        student2.setAddress(address2);
        student2.setCourse(Course.FIFTH);
        student2.setFaculty(Faculty.FILM);
        student2.setGroup(Group.THREE);
        System.out.println(student2);

        Date birthDate1 = format.parse(date1);
        student1.setDateOfBirth(birthDate1);
        student1.setAddress(address1);
        student1.setCourse(Course.SECOND);
        student1.setGroup(Group.THREE);
        student1.setFaculty(Faculty.DESIGN);
        System.out.println(student1);

        return Arrays.asList(student1, student2, student3, student4, student5, student6);
    }

    private final static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    //a) список студентов заданного факультета;
    private static List<Student> printFilmFacultyStudents(List<Student> studentList) {
        List<Student> filmFacultyStudentList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty() == Faculty.FILM) {
                filmFacultyStudentList.add(student);
            }
        }
        System.out.println("Film faculty " + filmFacultyStudentList);
        return filmFacultyStudentList;
    }

    //b) списки студентов для каждого факультета и курса;
    private static void facultyGroupList(List<Student> studentList) {
        List<List<Student>> globalList = new ArrayList<>();
        for (Faculty faculty : Faculty.values()) {
            for (Group group : Group.values()) {
                List<Student> students = new ArrayList<>();
                for (Student student : studentList) {
                    if (student.getFaculty().equals(faculty) && student.getGroup().equals(group)) {
                        students.add(student);
                    }
                }
                globalList.add(students);
            }
        }
        for (List<Student> list : globalList) {
            System.out.println(list);
        }
    }

    //c) список студентов, родившихся после заданного года;
    private static void studentsBornEarlieThat(List<Student> studentList) throws ParseException {
        Date someDateForEquals = format.parse("01.01.1971");
        List<Student> studentsBornBeforeDate = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getDateOfBirth().compareTo(someDateForEquals) < 0) {
                studentsBornBeforeDate.add(student);
            }
        }
        System.out.println("Students who born earlier then 1971 " + studentsBornBeforeDate);
    }

    //d) список учебной группы.
    private static void printStudentsFromOneGroup(List<Student> filmFaculty) {
        List<Student> groupOneStudents = new ArrayList<>();
        for (Student student : filmFaculty) {
            if (student.getGroup() == Group.ONE) {
                groupOneStudents.add(student);
            }
        }
        System.out.println("Group One " + groupOneStudents);
    }
}
