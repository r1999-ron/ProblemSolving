package salaryproblem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class CsvToObjectExample {
    public record Student(int studentId, String name, String subject) {}

    private static Optional<Student> parseLine(String line){
        return Optional.ofNullable(line)
                .map(l -> l.split(",", -1))
                .filter(arr -> arr.length >=2)
                .flatMap(arr -> {
                    try{
                        int id = Integer.parseInt(arr[0].trim());
                        String name = arr[1].trim();
                        String subject = arr.length>2 ? arr[2].trim():"";
                        return Optional.of(new Student(id, name, subject));
                    }catch (NumberFormatException e){
                        return Optional.empty();
                    }
                });
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/ronak/DSA-For-Interviews/ProblemSolving/src/array_practice/students.csv");
        try(Stream<String> lines = Files.lines(path)){
            List<Student> students = lines.skip(1).map(String::trim).filter(s -> !s.isEmpty()).map(CsvToObjectExample::parseLine).flatMap(Optional::stream).toList();
            students.forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
