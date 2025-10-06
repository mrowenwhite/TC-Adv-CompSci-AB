package Q1.Langdocs.Prog285b;

import java.util.ArrayList;
import java.util.Iterator;

public class Prog285bHelper {
    private Node myroot;

    public Prog285bHelper() {
        myroot = null;
    }

    public void addFront(Node spot) {
        if (myroot == null)
            myroot = spot;
        else {
            spot.myNext = myroot;
            myroot = spot;
        }
    }

    public void addBack(Node spot) {
        if (myroot == null)
            myroot = spot;
        else {
            Node temp = myroot;
            while (temp.myNext!=null)
                temp = temp.myNext;
            temp.myNext = spot;
        }
    }

    public void calc() {
        Node temp = myroot;
        while (temp.myNext!=null)
            temp.getCom().calc();
        temp = temp.myNext;
    }

    public void deleteZeros() {
        while ((myroot!=null)&&myroot.getCom().getcommision()==0)
            myroot = myroot.myNext;
    }

    public void print() {
        Node temp = myroot;
        while (temp != null) {
            System.out.println(temp.getCom());
            temp = temp.myNext;
        }
    }
}
