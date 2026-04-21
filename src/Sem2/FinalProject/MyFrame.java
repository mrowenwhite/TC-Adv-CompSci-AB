package Sem2.FinalProject;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MyFrame extends JFrame {
    JPanel header;
    ArrayList<Transaction> list;

    MyFrame(int len, int wid) {

        this.setSize(wid, len);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        header = new JPanel();
        JComboBox<String> categories = MakeCategoryBox();
        JTextField amounts = MakeAmountBox();
        JComboBox<String> descriptions = MakeDescriptionBox();
        header.add(new JLabel("Category: "));header.add(categories);
        header.add(new JLabel("Amount: "));header.add(amounts);
        header.add(new JLabel("Description: "));header.add(descriptions);

        JTable table = new JTable();
        table.setModel(new DefaultTableModel(3, 10));
        this.add(table, BorderLayout.CENTER);
        JButton button = new JButton("Add Transaction");
        button.addActionListener(e ->{
            Transaction t = new Transaction((String)categories.getSelectedItem(), Integer.parseInt(amounts.getText()), (String)descriptions.getSelectedItem());
            list.add(t);
            System.out.println(t);

        });
        header.add(button);
        this.add(header, BorderLayout.NORTH);
    }

    private JComboBox<String> MakeCategoryBox() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setSize(100, 20);
        comboBox.addItem("Option 1");
        comboBox.addItem("Option 2");
        comboBox.addItem("Option 3");
        comboBox.addItem("Option 4");
        return comboBox;
    }
    private JTextField MakeAmountBox() {
        JTextField field = new JTextField(20);
        field.setSize(100, 20);
        return field;
    }
    private JComboBox<String> MakeDescriptionBox() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setSize(100, 20);
        comboBox.addItem("Option 1");
        comboBox.addItem("Option 2");
        comboBox.addItem("Option 3");
        comboBox.addItem("Option 4");
        return comboBox;
    }
}
