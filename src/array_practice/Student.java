package array_practice;

class Student {
    int studentId;
    String name, subject;
  //  double salary;

    Student(int id, String name, String subject) {
        this.studentId = id;
        this.name = name;
        this.subject = subject;
       // this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
               // ", salary=" + salary +
                '}';
    }
}