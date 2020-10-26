package com.example.module2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Student student = new Student("Doe", "Joe", "Jonovich");
        Student student1 = new Student("Billigan", "Tommy", "Joevich", "+375 25 555 00 42");
        Student student2 = new Student("Grib", "Olga", "Ol'govna", "+375 55 874 98 77");
        Student student3 = new Student("Wick", "John", "Jordanovich", "+7 983 778 00 07");
        Student student4 = new Student("Potter", "Harry", "Ivanovich", "+89 983 784 83 98");
        Student student5 = new Student("Batty", "Roy", "Nexsus 6", "+42 424 242 42 42");

        Address address = new Address("Singapure", "Kuara Lumupur",
                18765, "Borrowman", 7897, 2);
        Address address1 = new Address("Belarus", "Minsk",
                220000, "Nezalejnosti", 4, 42);
        Address address2 = new Address("Poland", "Wrzlav",
                297000, "Klaus Pshche", 8, 192);
        Address address3 = new Address("US", "Oklahoma",
                987846, "Tompsom Johnes", 7, 11);
        Address address4 = new Address("UK", "Belfast",
                111000, "God Save Queen", 1, 1);
        Address address5 = new Address("US", "NewNewYork",
                544500, "Hopes", 98, 3);

        String date = "01.03.2000";
        String date1 = "20.02.1931";
        String date2 = "11.11.1976";
        String date3 = "01.01.1970";
        String date4 = "31.06.1997";
        String date5 = "12.12.1912";

        Date birthDate5 = format.parse(date5);
        student5.setDateOfBirth(birthDate5);
        student5.setAddress(address5);
        student5.setCourse(Course.SIXTH);
        student5.setFaculty(Faculty.THEATRICAL);
        student5.setGroup(Group.TWO);
        System.out.println(student5.toString());

        Date birthDate4 = format.parse(date4);
        student4.setDateOfBirth(birthDate4);
        student4.setAddress(address4);
        student4.setCourse(Course.THIRD);
        student4.setFaculty(Faculty.FILM);
        student4.setGroup(Group.ONE);
        System.out.println(student4.toString());

        Date birthDate3 = format.parse(date3);
        student3.setDateOfBirth(birthDate3);
        student3.setAddress(address3);
        student3.setCourse(Course.FIFTH);
        student3.setFaculty(Faculty.FILM);
        student3.setGroup(Group.TWO);
        System.out.println(student3.toString());

        Date birthDate2 = format.parse(date2);
        student2.setDateOfBirth(birthDate2);
        student2.setAddress(address2);
        student2.setCourse(Course.SIXTH);
        student2.setFaculty(Faculty.ART);
        student2.setGroup(Group.ONE);
        System.out.println(student2.toString());

        Date birthDate1 = format.parse(date1);
        student1.setDateOfBirth(birthDate1);
        student1.setAddress(address1);
        student1.setCourse(Course.FIFTH);
        student1.setFaculty(Faculty.FILM);
        student1.setGroup(Group.THREE);
        System.out.println(student1.toString());

        Date birthDate = format.parse(date);
        student.setDateOfBirth(birthDate);
        student.setAddress(address);
        student.setCourse(Course.SECOND);
        student.setGroup(Group.THREE);
        student.setFaculty(Faculty.DESIGN);
        System.out.println(student.toString());

//a) список студентов заданного факультета;
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        List<Student> filmFaculty = new ArrayList<>();
        for (Student equalsFaculty : studentList) {
            if (equalsFaculty.getFaculty() == Faculty.FILM) {
                filmFaculty.add(equalsFaculty);
            }
        }
        System.out.println("Film faculty" + filmFaculty.toString());

//c) список студентов, родившихся после заданного года;
        String someDate = "01.01.1971";
        Date someDateForEquals = format.parse(someDate);
        List<Student> timeDate = new ArrayList<>();
        for (Student dataEquals : studentList) {
            if (dataEquals.getDateOfBirth().compareTo(someDateForEquals) < 0) {
                timeDate.add(dataEquals);
            }
        }
        System.out.println("Students who born earlier then 1971 " + timeDate.toString());

//d) список учебной группы.
        List<Student> groupOne = new ArrayList<>();
        for (Student studyGroup : filmFaculty){
            if (studyGroup.getGroup() == Group.ONE){
                groupOne.add(studyGroup);
            }
        }
        System.out.println("Group One " + groupOne);
    }
}
