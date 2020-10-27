package com.example.module2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private long id;
    private String surname;
    private String lastName;
    private String patronymic;
    private Date dateOfBirth;
    private Address address;
    private String phone;
    private Faculty faculty;
    private Course course;
    private Group group;

    public Student(String surname, String lastName, String patronymic) {
        this.id = System.nanoTime();
        this.surname = surname;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Student(String surname, String lastName, String patronymic, String phone) {
        this(surname, lastName, patronymic);
        this.phone = phone;
    }

    public Student(String surname, String lastName, String patronymic, Date birthDate, Address address, String phone,
                   Faculty faculty, Course course, Group group) {
        this(surname, lastName, patronymic, phone);
        this.dateOfBirth = birthDate;
        this.address = address;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateFormat.format(dateOfBirth) +
                ", address=" + address +
                ", phone=" + phone +
                ", faculty=" + faculty +
                ", course=" + course +
                ", group=" + group +
                '}';
    }
}
