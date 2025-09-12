package array_practice;

public class Student {
    int studentId;
    String name, subject;

    public Student(int studentId, String name, String subject) {
        this.studentId = studentId;
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
