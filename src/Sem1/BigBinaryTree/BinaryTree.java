package Sem1.BigBinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

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
        public void setData(int data) {this.data = data;}
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
    public void printIntOrder() {printINFIX(root);}




    private void printPREFIX(btNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPREFIX(node.left);
        printPREFIX(node.right);
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
        printPOSTFIX(node.left);
        printPOSTFIX(node.right);
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
        //leaf
        if (temp==null) {return;}
        if (temp.left==null && temp.right==null) {
            if (n<prev.getData()) {
                prev.left = null;
                return;
            }
            else {
                prev.right = null;
                return;
            }
        }
        // 1 branch
        if (temp.left==null || temp.right==null) {
            if (temp==root) {
                if (temp.left==null) {
                    root = root.right;
                }
                else {
                    root = root.left;
                }

            }
            else {
                if (n<prev.getData()) {
                    prev.left = temp.left;
                }
                else {
                    prev.right = temp.right;
                }
            }
            return;
        }
        // both branches
        prev = temp;
        btNode find = temp.left;
        while (find.right!=null) {
            prev = find;
            find = find.right;
        }
        if (find == temp.left) {
            temp.setData(find.getData());
            temp.left = find.left;
        }
        else {
            temp.setData(find.getData());
            prev.right = find.left;

        }
    }

    public boolean contains(int data) {
        btNode temp = root;
        while (temp!=null) {
            if (data==temp.data) {return true;}
            if (data<temp.data) {temp=temp.left;}
            else {temp=temp.right;}
        }
        return false;
    }


    private int DFS_depth(btNode n) {
        if (n==null) {return 0;}
        return 1 + Math.max(DFS_depth(n.left), DFS_depth(n.right));
    }
    public int DFS_depth() {return DFS_depth(root);}


    public int BFS_width() {
        Queue<btNode> queue = new ArrayDeque<>();
        queue.add(root);
        int maxWid = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                btNode node = queue.poll();
                if (node.left != null) {queue.add(node.left);}
                if (node.right!= null) {queue.add(node.right);}
            }
            size  = queue.size();
            maxWid = Math.max(maxWid, size);
        }
        return maxWid;
    }

    public int size() {
        Queue<btNode> queue = new ArrayDeque<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            int Qsize = queue.size();
            for (int i = 0; i <Qsize; i++) {
                btNode node = queue.poll();
                if (node.left != null) {queue.add(node.left);}
                if (node.right != null) {queue.add(node.right);}
                size++;
            }
            size  = queue.size();
        }
        return size;
    }

    private int NodeSum() {
        Queue<btNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                btNode node = queue.poll();
                if (node.left != null) {queue.add(node.left);}
                if (node.right!= null) {queue.add(node.right);}
                sum += node.data;
            }
            size  = queue.size();
        }
        return sum;
    }
    public int AverageValue() {
        return NodeSum()/this.size();
    }

    public void KillClosestToAvg() {
        int avg = AverageValue();
        Queue<btNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                btNode node = queue.poll();
                if (node.left != null) {queue.add(node.left);}
                if (node.right != null) {queue.add(node.right);}
            }
            size  = queue.size();
        }
    }

}
