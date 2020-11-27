package bean;

import java.util.List;

public class Group {
    private int name;
    private List<Student> studentList;

    public Group(int groupName, List<Student> studentsList) {
        this.name = groupName;
        this.studentList = studentsList;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName=" + name +
                ", studentsList=" + studentList +
                '}';
    }
}
