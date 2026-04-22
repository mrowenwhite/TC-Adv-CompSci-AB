package Sem2.FinalProject;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MyFrame extends JFrame {
    JPanel header;
    JTable table;
    ArrayList<Transaction> list;
    JTextField amounts;
    JComboBox<String> categories;
    JComboBox<String> descriptions;

    MyFrame(int len, int wid) {

        this.setSize(wid, len);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list         = new ArrayList<>();
        header       = new JPanel();
        table        = new JTable(new DefaultTableModel(3, 0));
        amounts      = MakeAmountBox();
        categories   = MakeCategoryBox();
        descriptions = MakeDescriptionBox();

        header.add(new JLabel("Category: "));header.add(categories);
        header.add(new JLabel("Amount: "));header.add(amounts);
        header.add(new JLabel("Description: "));header.add(descriptions);
        table.setModel(new DefaultTableModel(3, 3));

        JButton button = getJButton();
        header.add(button);
        this.add(header, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);
    }

    private JButton getJButton() {
        JButton button = new JButton("Add Transaction");
        button.addActionListener(e ->{
            Transaction t = new Transaction((String)categories.getSelectedItem(), Integer.parseInt(amounts.getText()), (String)descriptions.getSelectedItem());
            list.add(t);
            System.out.println(t);
            for (int lcv = 0; lcv < list.size(); lcv++) {
                Transaction t1 = list.get(lcv);
                table.add
                // ADD ROWS WITH THE MODEL< TALK TO LANDON!!!!!!!!!

                table.setValueAt(t1.category(),    lcv, 0);
                table.setValueAt(t1.amount(),      lcv, 1);
                table.setValueAt(t1.description(), lcv, 2);
            }

        });
        return button;
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

    public void addTransaction(Transaction transaction) {
        list.add(transaction);
    }
}
