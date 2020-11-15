package bean;

public class EmptySubjectException extends MyException {
    private final String studentName;

    public EmptySubjectException(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "EmptyGroupException{" +
                "studentName='" + studentName + '\'' +
                '}';
    }
}
