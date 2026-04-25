package Sem2.FinalProject;

import java.awt.*;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame {
    static JLabel eastTextSummary;
    JPanel header;
    JTable table;
    ArrayList<Transaction> list;
    JTextField amounts;
    JComboBox<String> categories, descriptions;
    static Map<String, Integer> map;

    MyFrame(int len, int wid) {
        this.setSize(wid, len);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.lightGray);
        list             = new ArrayList<>();
        map              = new HashMap<>();
        header           = new JPanel();
        table            = new JTable(new DefaultTableModel(3, 0));
        eastTextSummary  = new JLabel();
        amounts          = MakeAmountBox();
        categories       = MakeComboBox(new String[] {"Option 1", "Option 2", "Option 3", "Option 4"});
        descriptions     = MakeComboBox(new String[] {"Option 1", "Option 2", "Option 3", "Option 4"});


        header.add(new JLabel("Category:    "));header.add(categories);
        header.add(new JLabel("Amount:      "));header.add(amounts);
        header.add(new JLabel("Description: "));header.add(descriptions);
        table.setModel(new DefaultTableModel(2, 3));

        JButton button = getAddJButton();
        JButton reverser = getReverseButton();
        header.add(button);
        header.add(reverser);
        this.add(eastTextSummary, BorderLayout.EAST); // TODO: Just get the label there, getsummary should work :)
        this.add(header, BorderLayout.NORTH);
        this.add(table, BorderLayout.CENTER);

    }

    private JButton getAddJButton() {
        JButton button = new JButton("Add Transaction");
        button.addActionListener(e ->{
            Transaction t = new Transaction((String)categories.getSelectedItem(), Integer.parseInt(amounts.getText()), (String)descriptions.getSelectedItem());
            list.add(t);
            ((DefaultTableModel) table.getModel()).addRow(new Object[] {});
            for  (int lcv = 0; lcv < list.size(); lcv++) {
                table.setValueAt(list.get(lcv).category(),    lcv, 0);
                table.setValueAt(list.get(lcv).amount(),      lcv, 1);
                table.setValueAt(list.get(lcv).description(), lcv, 2);
                getSummary();
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
        for   (int lcv = 0; lcv < list.size(); lcv++) {
            map.put(list.get(lcv).category(), map.get(list.get(lcv).category())+list.get(lcv).amount());
        }
        for  (Map.Entry<String, Integer> entry : map.entrySet()) {
            eastTextSummary.setText("Category: " + entry.getKey()+ " Amount: " + entry.getValue());
        }
    }

}
