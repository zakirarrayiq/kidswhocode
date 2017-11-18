package edu.kidswhocode.shapes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * FilesTestApp.
 *
 * @author Zakir Magdum
 */
public class FilesTestApp {
    public static void main(String[] args) throws IOException {
        FilesTestApp app = new FilesTestApp();
        //app.listFiles("/Users/zakirmagdum/Documents");
        //app.findFiles("/Users/zakirmagdum/Documents");
        app.readFile1("/Users/zakirmagdum/MacSecondHD/development/kidswhocode/shapes/pom.xml");
        app.writeFile("/Users/zakirmagdum/Documents/demo.txt", "This is my first write into the file");
        app.deleteFile("/Users/zakirmagdum/Documents/demo.txt");
    }

    private void listFiles(String directory) {
        try (Stream<Path> stream = Files.list(Paths.get(directory))) {
            stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findFiles(String directory) {
        try (Stream<Path> stream = Files.find(Paths.get(directory), 5, (path, attr) ->
                String.valueOf(path).endsWith(".jpg"))) {
            stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readFile1(String fileName) {
        try {
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                stream
                        .filter(line -> line.contains("groupId"))
                        .map(String::trim)
                        .forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeFile(String fileName, String content) {
        try {
            Files.write(Paths.get(fileName), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFile(String fileName) throws IOException {
        Files.delete(Paths.get(fileName));
    }
}
