package Sem1.BigBinaryTree;

public class BinaryTree {
    private btNode root;
    static class btNode {
        public btNode left;
        public btNode right;
        private int data;
        public btNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
        public int getData() {return data;}
    }


    public BinaryTree() {
        root = null;
    }

    public void add(int data) {
        btNode parent = root;
        btNode newNode = new btNode(data);
        if (root==null) {root = newNode;}
        else {
            btNode lcN = root;
            while (lcN!=null) {
                if (data < lcN.data) {
                    parent = lcN;lcN = lcN.left;
                }
                else {
                    parent = lcN;lcN = lcN.right;
                }
            }
            if (data<parent.getData()) {parent.left = newNode;}
            else {parent.right = newNode;}

        }
    }
    public void add(int[] nums) {for (int i : nums) {this.add(i);}}

    public void printIntOrder() {
        printINFIX(root);
    }




    private void printPREFIX(btNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printINFIX(node.left);
        printINFIX(node.right);
    }
    public void printPREFIX() {printPREFIX(root);}


    private void printINFIX(btNode node) {
        if (node == null) return;
        printINFIX(node.left);
        System.out.print(node.data + " ");
        printINFIX(node.right);
    }
    public void printINFIX() {printINFIX(root);}

    private void printPOSTFIX(btNode node) {
        if (node == null) return;
        printINFIX(node.left);
        printINFIX(node.right);
        System.out.print(node.data + " ");
    }
    public void printPOSTFIX() {printPOSTFIX(root);}

    public void delete(int n) {
        btNode prev = null;
        btNode temp = root;
        while ((temp!=null && (temp.getData()!=n))) {
            prev = temp;
            if (n<temp.getData()) {
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }
        if (temp!=null) {return;}
        if (temp.left==null && temp.right==null) {

        }
    }




}
