package Sem1.BigBinaryTree;

public class BinaryTree {
    static class btNode {
        public btNode left;
        public btNode right;
        private int data;
        public btNode(int data) {
            this.data = data;
            left = null;
            right = null;}
        public int getData() {return data;}
    }
    private btNode root;

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
        printIntOrder(root);
    }

    private void printIntOrder(btNode node) {
        if (node == null) return;
        printIntOrder(node.left);
        System.out.print(node.data + " ");
        printIntOrder(node.right);

    }




}
