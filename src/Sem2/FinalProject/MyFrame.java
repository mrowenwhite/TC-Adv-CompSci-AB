package Sem2.FinalProject;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame {
    JPanel header;

    MyFrame(int len, int wid) {
        this.setSize(wid, len);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        header = new JPanel();
        header.add(new JLabel("Category: "));header.add(MakeCategoryBox());
        header.add(new JLabel("Amount: "));header.add(MakeAmountBox());
        header.add(new JLabel("Description: "));header.add(MakeDescriptionBox());
        header.add(new JButton("Add Transaction"));

        JButton button = new JButton("Add Transaction");
        button.setAction(new ActionListener() {}
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
        JTextField field = new JTextField();
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
