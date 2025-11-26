package com.data.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 作者：张鹏烨
 * 2025/9/29
 **/
public class huffmanTree {

    public static Node HuffmaTree(int[] arr){
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i :arr) {
            Node node = new Node(i);
            nodes.add(node);
        }
        while (nodes.size() > 1){
            Collections.sort(nodes,( node1, node2)-> node1.value - node2.value
            );

            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node node = new Node(left.value + right.value);
            node.left = left;
            node.right = right;
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(node);
        }
        return nodes.get(0);
    }
    public void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node);
        preorder(node.left);
        preorder(node.right);

    }
    public static void main(String[] args) {
        // 测试数据
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        // 构建哈夫曼树
        Node root = HuffmaTree(arr);
        // 前序遍历
        System.out.println("哈夫曼树的前序遍历结果：");
        new huffmanTree().preorder(root);
    }
}
class Node  {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

}