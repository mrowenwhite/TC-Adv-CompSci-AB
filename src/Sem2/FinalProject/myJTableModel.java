package Sem2.FinalProject;

import java.util.*;

import javax.swing.table.DefaultTableModel;

public class myJTableModel extends DefaultTableModel {
    ArrayList<Transaction> list;

    public myJTableModel(int len) {
        super(len, 0);
        list = new ArrayList<>();
    }
    public void addTransaction(Transaction t) {
        list.add(t);
        addRow(new String[]{t.category(), String.valueOf(t.amount()), t.description()});
    }

}
