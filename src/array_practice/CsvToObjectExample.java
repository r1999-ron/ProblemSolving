package array_practice;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvToObjectExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/ronak/DSA-For-Interviews/ProblemSolving/src/array_practice/students.csv");

        try (Stream<String> lines = Files.lines(path)) {
            List<Student> students = lines
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .skip(1) // skip header
                    .map(line -> line.split(",")) // simple CSV split (no quoted commas)
                    .map(arr -> {
                        int id = Integer.parseInt(arr[0].trim());
                        String name = arr[1].trim();
                        String subject = arr[2].trim();
                        return new Student(id, name, subject);
//                        double rawSalary = Double.parseDouble(arr[3].trim());
//                        double updatedSalary = SalaryService.applyIncrement(rawSalary);
//                        return new Student(id, name, subject, updatedSalary);
                    })
                    .collect(Collectors.toList());

            students.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
