package Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilename = "D:\\Khai\\3rd_kurs_2d_term\\Java\\ЛР4\\workers.txt";
        String outputFilename = "D:\\Khai\\3rd_kurs_2d_term\\Java\\ЛР4\\new_workers.txt";
        List<Worker> workers = readWorkersFromFile(inputFilename);
        List<Worker> newWorkers = filterByHireYear(workers, "2010");
        writeWorkersToFile(newWorkers, outputFilename);
        System.out.println("Workers:");
        for (Worker worker : workers) {
            System.out.println("\n"+worker);
        }
        System.out.println("Filtered workers:");
        for (Worker worker : newWorkers) {
            System.out.println("\n"+worker);
        }
    }

    private static void writeWorkersToFile(List<Worker> newWorkers, String outputFilename) {
        File fileB = new File(outputFilename);
        try {
            FileWriter fileWrite = new FileWriter(fileB);
            BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);
            PrintWriter printFileB = new PrintWriter(bufferedWrite);
            for (Worker worker : newWorkers) {
                printFileB.print(worker.toString()+"\n");
            }
        printFileB.close();
    } catch(
    IOException e)

    {
        System.out.println("Помилка при створенні файлу з масивом В");
    }

}

    private static List<Worker> filterByHireYear(List<Worker> workers, String s) {
        List<Worker> worker2010 = new ArrayList<>();
        for (Worker worker : workers
        ) {
            if (worker.getHireYear().equals(s)){worker2010.add(worker);}

        }
        return worker2010;
    }

    public static List<Worker> readWorkersFromFile(String filename) {
        List<Worker> workers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(", ");
                Worker worker = new Worker(tokens[0], tokens[1], tokens[2], tokens[3],
                        tokens[4], tokens[5], tokens[6], tokens[7], tokens[8],
                        tokens[9], tokens[10], tokens[11], tokens[12], tokens[13],
                        tokens[14], tokens[15], tokens[16]);
                workers.add(worker);
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
        return workers;
    }
}
