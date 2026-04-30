package Sem2.FinalProject;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame {
    static JLabel eastTextSummary;
    static JPanel summaryBox;
    JPanel header;
    JTable table;
    ArrayList<Transaction> list;
    JTextField amounts, descriptions;
    JComboBox<String> categories;
    static Map<String, Integer> map;
    File file;
    FileWriter writer;


    MyFrame(int len, int wid) throws IOException {






        //TS is so broken bruh




        this.setSize(wid, len);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.lightGray);
        writer           = new FileWriter("C:\\Users\\white.o3\\IdeaProjects\\TC CompSci\\src\\Sem2\\FinalProject\\Transactions.csv");
        file             = new File("C:\\Users\\white.o3\\IdeaProjects\\TC CompSci\\src\\Sem2\\FinalProject\\Transactions.csv");
        list             = new ArrayList<>();

        try (Scanner fileReader = new Scanner(file)) {


            fileReader.next();
            String fileText = "";
            while (fileReader.hasNext()) {
                fileText += fileReader.next();
            }
            String[] stuff = fileText.split(",");
            for (int i = 0; i < stuff.length - 3; i += 3) {
                list.add(new Transaction(stuff[i], Integer.parseInt(stuff[i + 1]), stuff[i + 2]));
            }
        }
        catch (Exception e) {
            System.out.println("poop");
        }



        map              = new HashMap<>();
        header           = new JPanel();
        table            = new JTable(new DefaultTableModel(3, 0));
        summaryBox       = new JPanel();
        eastTextSummary  = new JLabel();
        eastTextSummary.setSize(20, 20);
        amounts          = MakeAmountBox();
        categories       = MakeComboBox(new String[] {"Food", "Rent", "Entertainment", "Transportation"});
        descriptions     = MakeAmountBox();


        header.add(new JLabel("Category:    "));header.add(categories);
        header.add(new JLabel("Amount:      "));header.add(amounts);
        header.add(new JLabel("Description: "));header.add(descriptions);
        table.setModel(new DefaultTableModel(0, 3));

        JButton button = getAddJButton();
        JButton reverser = getReverseButton();
        header.add(button);
        header.add(reverser);
        summaryBox.add(eastTextSummary);
        this.add(summaryBox, BorderLayout.EAST);
        this.add(header, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);

        this.revalidate();



    }

    private JButton getAddJButton() {
        JButton button = new JButton("Add Transaction");
        button.addActionListener(e ->{
            Transaction t = new Transaction((String)categories.getSelectedItem(), Integer.parseInt(amounts.getText()),descriptions.getText());
            list.add(t);
            map.put(t.category(),map.getOrDefault(t.category(),0) + t.amount());
            ((DefaultTableModel)table.getModel()).addRow(new Object[]{t.category(),t.amount(),(t.description().isEmpty()?"N/A":t.description())});
            getSummary();
            try (Scanner fileReader = new Scanner(file)) {
                String fileText = "";
                while (fileReader.hasNext()) {
                    fileText += fileReader.next();
                }
                Files.writeString(file.toPath(), fileText + t, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                System.out.println("pee");
            }

        });
        return button;
    }

    private JComboBox<String> MakeComboBox(String[] options) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setSize(100, 20);
        return comboBox;
    }
    private JTextField MakeAmountBox() {
        JTextField field = new JTextField(20);
        field.setSize(100, 20);
        return field;
    }

    public JButton getReverseButton() {
        JButton button = new JButton("Reverse Transaction");
        button.addActionListener(e -> {
            list = new ArrayList<>(list.reversed());
            for  (int lcv = 0; lcv < list.size(); lcv++) {
                table.setValueAt(list.get(lcv).category(),    lcv, 0);
                table.setValueAt(list.get(lcv).amount(),      lcv, 1);
                table.setValueAt(list.get(lcv).description(), lcv, 2);
            }});
        return button;
    }

    public void getSummary() {
        String highestExpenseCategory = map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        int totalBalance = map.values().stream().mapToInt(i -> i).sum();
        eastTextSummary.setText((
                "<html>Number of Transactions: " +list.size() +
                "<br>Highest Expense Category: " + highestExpenseCategory +
                "<br>Total Balance: "            + totalBalance +
                "<br><br>Food: $"                + map.getOrDefault("Food", 0) +
                "<br>Rent: $"                    + map.getOrDefault("Rent", 0) +
                "<br>Entertainment: $"           + map.getOrDefault("Entertainment", 0) +
                "<br>Transportation: $"          + map.getOrDefault("Transportation", 0) +
                "</html>"
        ));
    }
}
