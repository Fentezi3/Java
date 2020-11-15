package bean;

public class EmptyStudentListException extends MyException {
    private final String groupName;

    public EmptyStudentListException(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "EmptyStudentList{" +
                "groupName=" + groupName +
                '}';
    }
}
