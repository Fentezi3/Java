package bean;

import java.util.Map;

public class Student {
    String studentName;
    Map<String, Integer> subjects;

    public Student(String studentName, Map<String, Integer> subjects) {
        validateSubjects(subjects);
        this.studentName = studentName;
        this.subjects = subjects;
    }

    private void validateSubjects(Map<String, Integer> subjects) {
        for (Integer grade : subjects.values()) {
            if (grade < 0 || grade > 10) {
                throw new IllegalStateException("Grade is less than 0 or more than 10");
            }
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<String, Integer> subjects) {
        validateSubjects(subjects);
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentName='" + studentName + '\'' +
                ", subject=" + subjects +
                '}';
    }
}
