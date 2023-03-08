import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution {
    public static int[] getNumbers(String path) throws IOException {
        Path filePath = Paths.get(path);
        Scanner scanner = new Scanner(filePath);
        List<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        int[] arr = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            arr[i] = integers.get(i);
        }
        return arr;
    }
    public static void saveToFile(String path, int[] arr) throws IOException {
        try {
            FileWriter writer = new FileWriter(path);
            for (int j : arr) {
                writer.write(Integer.toString(j));
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
