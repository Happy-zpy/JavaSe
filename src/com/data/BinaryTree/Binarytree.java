package com.data.BinaryTree;
/**
 * 作者：张鹏烨
 * 2025/9/24
 **/
@SuppressWarnings({"all"})
public class Binarytree {
    public static void main(String[] args) {
        Node node1 = new Node("张鹏烨", 1);
        Node node2 = new Node("朱晶曦", 2);
        Node node4 = new Node("张志成", 4);
        Node node3 = new Node("张峪", 3);
        Node node5 = new Node("邹磊", 5);
        Node node6 = new Node("赵少彬", 3);
        Tree tree = new Tree();
        tree.add(node1);
        tree.add(node2);
        tree.add(node3);
        tree.add(node4);
        tree.add(node5);
        tree.add(node6);
        tree.preoder();
        System.out.println();
        tree.fixorder();
        System.out.println();
        tree.postorder();
        System.out.println();
        Node node = tree.preorederSearch(5);
        System.out.println(node);
        System.out.println();
        node = tree.infixorderSearch(5);
        System.out.println(node);
        System.out.println();
        node = tree.postorederSearch(5);
        System.out.println(node);
        System.out.println();
        node = tree.postorederSearch(7);
        System.out.println(node);
        tree.remove(4);
        node4.left = null;
        node4.right = null;
        tree.postorder();
        tree.add(node4);
        System.out.println();
        tree.postorder();
        System.out.println();
        tree.preoder();
        System.out.println();
        //tree.Threaded(tree.root);
        //tree.ThreadOrder();
        System.out.println();
        int[] arr = {7,3,10,12,5,1,9};
        Tree tree1 = new Tree();
       /*for (Integer i : arr) {
            tree1.add(new Node("",i));
        }
        tree1.fixorder();

        */

        for (int i = 0; i < 7; i++) {
            tree.delNode(i);
        }
        tree.fixorder();

    }
}
@SuppressWarnings({"all"})
class Tree{
    Node root;
    Node pre = null;
    public void add(Node node){
        if(node == null){
            System.out.println("添加项为空,无法添加");
            return;
        }
        if(root == null){
            root = node;
            return;
        }
        root.add(node);
    }

    public void ThreadOrder(){
        Node node = root;
        while(node != null){
            while (node != null && node.lefttype == false) {
                node = node.left;
            }
            System.out.println(node);
            while (node != null && node.righttype == true){
                node = node.right;
                System.out.println(node);
            }
            if (node != null ) {
                node = node.right;
            }
        }
    }

    public void Threaded(Node node){
        if(node == null){
            return;
        }
        Threaded(node.left);
        if (node.left == null){
            node.left = pre;
            node.lefttype = true;
        }
        if (pre != null && pre.right == null){
            pre.right = node;
            pre.righttype = true;
        }
        pre = node;
        Threaded(node.right);
    }

    public int delNodeRight(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.getNo());
        return target.getNo();
    }

    public void delNode(int value){
        if(root == null){
            return;
        }
        Node target = root.Search(value);
        if(target == null){
            return;
        }

        if(root.right == null && root.left == null){
            root = null;
            return;
        }
        Node parent = root.SearchParent(value);
        if(target.right == null && target.left == null){
            if(parent.left != null && parent.left == target){
                parent.left = null;
                return;
            }
            else if(parent.right != null && parent.right == target){
                parent.right = null;
                return;
            }
        } else if (target.left != null && target.right != null) {
            int no = delNodeRight(target.right);
            target.setNo(no);
        }
        else {
            Node childNode = (target.left != null) ? target.left : target.right;
            if (parent == null) {
                root = childNode;
                return;
            }
            if (parent.left == target) {
                parent.left = childNode;
            } else {
                parent.right = childNode;
            }
        }
    }

    public void remove(int no){
        if(root == null){
            System.out.println("根节点为空");
            return;
        }
        if(root.getNo() == no){
            root = null;
            return;
        }
        root.remove(no);
    }

    public Node preorederSearch(int no){
        if(root == null){
            System.out.println("当前树为空");
            return null;
        }
        return root.preorderSearch(no);
    }

    public Node infixorderSearch(int no){
        if(root == null){
            System.out.println("当前树为空");
            return null;
        }
        return root.infixorderSearch(no);

    }

    public Node postorederSearch(int no){
        if(root == null){
            System.out.println("当前树为空");
            return null;
        }
        return root.postorderSearch(no);
    }

    public void preoder(){
        if(root == null){
            System.out.println("树为空无法先序遍历");
            return;
        }
        root.preorder();
    }
    public void fixorder(){
        if(root == null){
            System.out.println("树为空无法中序遍历");
            return;
        }
        root.fixorder();
    }
    public void postorder(){
        if(root == null){
            System.out.println("树为空无法后序遍历");
            return;
        }
        root.postorder();
    }

}
class Node{
    private int no;
    private String name;
    Node right;
    Node left;
    boolean lefttype = false;
    boolean righttype = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Node(String name, int no) {
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public Node Search(int value){
        if(this.no == value){
            return this;
        } else if (this.no > value && this.left != null) {
            return this.left.Search(value);
        } else if (this.no < value && this.right != null) {
            return this.right.Search(value);
        }
        else {
            return null;
        }
    }

    public Node SearchParent(int value){
        if((this.left != null && this.left.no == value) || (this.right != null && this.right.no == value)){
            return this;
        } else if (this.no > value && this.left != null) {
            return this.left.SearchParent(value);
        } else if (this.no < value && this.right != null ) {
            return this.right.SearchParent(value);
        }
        else return null;

    }

    public void remove(int no) {
        if (this.left != null) {
            if (this.left.getNo() == no) {
                if (this.left.left != null) {
                    if (this.left.right != null) {
                        Node temp = this.left.right;
                        this.left = this.left.left;
                        this.left.add(temp);
                    } else if (this.left.right == null) {
                        this.left = this.left.left;
                    }
                    return;
                }
                else   {
                    if (this.left.right != null) {
                        this.left = this.left.right;
                    } else this.left = null;
                    return;
                }
            }
        }
            if (this.right!= null) {
                if (this.right.getNo() == no) {
                    if (this.right.left != null) {
                        if (this.right.right != null) {
                            Node temp = this.right.right;
                            this.right = this.right.left;
                            this.right.add(temp);
                        } else if (this.right.right == null) {
                            this.right = this.right.left;
                        }
                        return;
                    }
                    else {
                        if(this.right.right != null){
                            this.right = this.right.right;
                        }
                        else this.right =null;
                        return;
                    }
                }
            }
            if (this.left != null) {
                this.left.remove(no);
            }
            if (this.right != null) {
                this.right.remove(no);
            }

    }
    public void add(Node node){
        if (node == null || this.getNo() == node.getNo()){
            System.out.println("工号相同无法添加/添加项为空");
            return;
        }
        if(this.getNo() > node.getNo()){
            if(this.left != null){
                this.left.add(node);
            }
            else {
                this.left = node;
                return;
            }
        }
        else {
            if(this.right != null){
                this.right.add(node);
            }
            else {
                this.right = node;
                return;
            }
        }
    }

    public Node preorderSearch(int no){
        Node temp = null;
        if(this.getNo() == no){
            temp = this;
        }
        if(temp != null){
            return temp;
        }
        if(this.left != null){
            temp = this.left.preorderSearch(no);
        }
        if(temp != null){
            return temp;
        }
        if(this.right != null){
            temp = this.right.preorderSearch(no);
        }
        return temp;
    }

    public Node infixorderSearch(int no){
        Node temp = null;
        if(this.left != null){
           temp = this.left.infixorderSearch(no);
           if(temp != null){
               return temp;
           }
        }
        if(this.getNo() == no){
            temp = this;
        }

        if(this.right != null){
            temp = this.right.infixorderSearch(no);
            if(temp != null){
                return temp;
            }
        }
        return temp;
    }

    public Node postorderSearch(int no){
        Node temp = null;
        if(this.left != null){
            temp = this.left.postorderSearch(no);
            if(temp != null){
                return temp;
            }
        }
        if(this.right != null){
            temp = this.right.postorderSearch(no);
            if(temp != null){
                return temp;
            }
        }
        if(this.getNo() == no){
            return this;
        }
        return temp;
    }

    public void preorder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preorder();
        }
        if(this.right != null){
            this.right.preorder();
        }
    }
    public void fixorder(){
        if(this.left != null){
            this.left.fixorder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.fixorder();
        }
    }
    public void postorder(){
        if(this.left != null){
            this.left.postorder();
        }
        if(this.right != null){
            this.right.postorder();
        }
        System.out.println(this);
    }
}
