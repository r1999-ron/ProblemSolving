package array_practice;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CsvToObjectExample {
    public static void main(String[] args) throws IOException {
        List<Student>  students = Files.lines(Paths.get("/Users/ronak/DSA-For-Interviews/ProblemSolving/src/array_practice/students.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(arr -> new Student(
                        Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2]
                )).collect(Collectors.toList());
       students.forEach(System.out::println);
    }
}
