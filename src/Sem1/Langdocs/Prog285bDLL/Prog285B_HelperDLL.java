package Sem1.Langdocs.Prog285bDLL;

public class Prog285B_HelperDLL {
    public static class DoubleNode {
        DoubleNode next;
        DoubleNode prev;
        private int myId;
        private int myCode;
        private double mySales;
        private double myCom;
        DoubleNode(int id, int code, double sales) {
            prev = null;
            myId = id;
            myCode = code;
            mySales = sales;
            myCom = 0;
            next = null;
        }
        public void calc() {
            if ((myCode==5)||(myCode==8)) {
                if           (mySales<=3500) myCom = mySales * 0.075;
                else myCom = ((mySales-5000)*0.085)+(5000*0.075);
            }
            if ((myCode==17)) {
                if           (mySales<=5000) myCom = mySales * 0.095;
                else myCom = ((mySales-5000)*0.095)+(3500*0.12);
            }
        }
        @Override
        public String toString() {
            return myId + "\t"  + myCode + "\t" + mySales + "\t" + myCom;
        }

        public double getCom() {
            return myCom;
        }

    }
    private DoubleNode myroot;

    public Prog285B_HelperDLL() {
        myroot = null;
    }

    public void addFront(DoubleNode node) {
        if (myroot == null) {
            myroot = node;
        }
        else {
            node.next   = myroot;
            myroot.prev = node;
            myroot      = node;
        }
    }
    public void addBack(DoubleNode node) {
        if (myroot == null) {
            myroot = node;
        } else {
            DoubleNode temp = myroot;
            while (temp.next != null) {
                temp = temp.next;
                node.prev = temp;
                temp.next = node;
            }
        }
    }

    public void print() {
        DoubleNode temp = myroot;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void deleteZeros() {
        while (myroot != null && myroot.getCom() == 0)
            myroot = myroot.next;

        DoubleNode current = myroot;
        while (current != null && current.next != null) {
            if (current.next.getCom() == 0)
                current.next = current.next.next;
            else
                current = current.next;
        }
    }

    public void calcAll() {
        DoubleNode temp = myroot;
        while (temp != null) {
            temp.calc();
            temp = temp.next;
        }
    }


}
