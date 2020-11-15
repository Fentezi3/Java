package bean;

import java.util.List;

public class Group {
    int groupName;
    List<Student> studentsList;

    public Group(int groupName, List<Student> studentsList) {
        this.groupName = groupName;
        this.studentsList = studentsList;
    }

    public int getGroupName() {
        return groupName;
    }

    public void setGroupName(int groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName=" + groupName +
                ", studentsList=" + studentsList +
                '}';
    }
}
