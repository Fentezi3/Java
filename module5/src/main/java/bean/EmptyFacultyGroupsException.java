package bean;

public class EmptyFacultyGroupsException extends MyException {
    private final String facultyName;

    public EmptyFacultyGroupsException(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @Override
    public String toString() {
        return "EmptyFacultyGroupsException{" +
                "facultyName='" + facultyName + '\'' +
                '}';
    }
}
