package bean;

import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(String facultyName, List<Group> groups) {
        this.name = facultyName;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
