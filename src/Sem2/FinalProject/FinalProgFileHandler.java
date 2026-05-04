package Sem2.FinalProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProgFileHandler {
    private final File    file;
    private final Scanner reader;
    private final FileWriter writer;
    PrintWriter pw;
    public FinalProgFileHandler(String path) throws IOException {
        file   = new  File(path);
        reader = new Scanner(file);
        writer = new FileWriter(file, true);
        pw     = new PrintWriter(writer);
    }

    public void add(Transaction T) throws IOException {
        writer.write(T.toString());
        writer.close();
    }

    public ArrayList<Transaction> getList() {
        ArrayList<Transaction> list = new ArrayList<>();

        if (file.length() > 0) {
            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(",");
                list.add(new Transaction(line[0], Integer.parseInt(line[1]), line[2]));
            }
        }
        return list;
    }
}
