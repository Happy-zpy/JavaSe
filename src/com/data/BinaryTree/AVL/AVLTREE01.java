package com.data.BinaryTree.AVL;

import java.io.*;
import java.util.Objects;

/**
 * 作者：张鹏烨
 * 2025/10/12
 **/
@SuppressWarnings({"all"})
public class AVLTREE01 {
    public static void main(String[] args) {
        int[] arr = {4,3,6,5,7,8};
        AVLTree avlTree = new AVLTree();
        AVLTree avlTree1 = new AVLTree();
        for (int i = arr.length - 1; i > 0; i--) {
            NoDe noDe = new NoDe(arr[i]);
            avlTree.add(noDe);
        }
        avlTree.inOrder();
        System.out.println(avlTree.root.leftheight());
        System.out.println(avlTree.root.rightheight());
        System.out.println();
        int[] arr1 = {10,11,7,6,8,9};
        for (int i : arr1) {
            NoDe noDe = new NoDe(i);
            avlTree1.add(noDe);
        }
        avlTree1.inOrder();
        System.out.println(avlTree1.root.leftheight());
        System.out.println(avlTree1.root.rightheight());
        NoDe noDe = null;
    }
}

@SuppressWarnings({"all"})
class AVLTree implements Serializable {
    NoDe root;

    public AVLTree deepCopy(){
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        AVLTree Alv;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Alv = (AVLTree) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                ois.close();
                bos.close();
                bis.close();
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Alv;
    }

    public void add(NoDe noDe){
        if(noDe == null){
            return;
        }
        if(root == null){
            root = noDe;
        }
        else {
            root.add(noDe);
        }
    }

    public int delNodeRight(NoDe node){
        NoDe target = node;
        while (target.left != null){
            target = target.left;
        }
        delNoDe(target.getValue());
        return target.getValue();
    }

    public void delNoDe(int value){
        if(isEmpty()){
            return;
        }
        if(root.left == null && root.right == null){
            root = null;
            return;
        }
        NoDe target = root.Search(value);
        if(target == null){
            return;
        }
        NoDe parent = root.SearchParent(value);
        if(target.left == null && target.right == null){
            if(parent.left != null && parent.left == target){
                parent.left = null;
                return;
            }
            else if(parent.right != null && parent.right == target){
                parent.right = null;
                return;
            }
        }else if (target.left != null && target.right != null) {
            int no = delNodeRight(target.right);
            target.setValue(no);
        }
        else {
            NoDe childNode = (target.left != null) ? target.left : target.right;
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

    public void preOrder(){
        if(isEmpty()){
            return;
        }
        root.preOrder();
    }

    public void inOrder(){
        if(isEmpty()){
            return;
        }
        root.inOrder();
    }

    public void postOrder(){
        if (isEmpty()){
            return;
        }
        root.preOrder();
    }

    public NoDe preOrderSearch(NoDe noDe){
        if(isEmpty()){
            return null;
        }
        return root.preOrderSearch(noDe);
    }

    public NoDe inOrderSearch(NoDe noDe){
        if(isEmpty()){
            return null;
        }
        return root.inOrderSearch(noDe);
    }

    public NoDe postOrderSearch(NoDe noDe){
        if(isEmpty()){
            return null;
        }
        return root.postOrderSearch(noDe);
    }

    public boolean isEmpty(){
        return root == null;
    }

}
@SuppressWarnings({"all"})
class NoDe<T> implements Serializable{
    T data;
    int value;
    NoDe left;
    NoDe right;
    String name;

    public NoDe(int value) {
        this.value = value;
    }

    public NoDe(NoDe noDe) {
        this.data = (T)noDe.data;
        this.value = noDe.value;
        this.name = noDe.name;
    }

    public NoDe SearchParent(int value){
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        } else if (this.value > value && this.left != null) {
            return this.left.SearchParent(value);
        } else if (this.value < value && this.right != null ) {
            return this.right.SearchParent(value);
        }
        else return null;
    }

    public NoDe Search(int value){
        if(this.getValue() == value){
            return this;
        }
        else if(this.left != null && this.getValue() > value){
            return this.left.Search(value);
        }
        else if(this.right != null){
            return this.right.Search(value);
        }

        else {
            return null;
        }
    }

    public int leftheight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }

    public int rightheight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    public void add(NoDe noDe){
        if(noDe == null){
            return;
        }

        if(this.getValue() == noDe.getValue()){
            System.out.println("相同号码无法添加");
            return;
        }

        if(this.getValue() > noDe.getValue()){
            if (this.left == null) {
                this.left = noDe;
            }
            else {
                this.left.add(noDe);
            }
        }
        if(this.getValue() < noDe.getValue()){
            if (this.right == null) {
                this.right = noDe;
            }
            else {
                this.right.add(noDe);
            }
        }
        if (rightheight() - leftheight() > 1) {
            // 右子树过高，需要平衡
            if (right != null && right.leftheight() > right.rightheight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
        }
        else if (leftheight() - rightheight() > 1) {
            if (left != null && left.rightheight() > left.leftheight()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }

    }

    public void leftRotate(){
        NoDe newNoDE = new NoDe(this);
        newNoDE.left = this.left;
        newNoDE.right = right.left;
        this.setValue(right.getValue());
        this.left = newNoDE;
        this.right = right.right;
    }

    public void rightRotate(){
        NoDe<T> newNoDe = new NoDe<>(this);
        newNoDe.right = this.right;
        newNoDe.left = this.left.right;
        this.setValue(this.left.getValue());
        this.left = left.left;
        this.right = newNoDe;
    }

    public int height(){
        return Math.max(left == null ? 0 : left.height() ,right ==null ? 0 : right.height() ) + 1;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();

        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    public void inOrder(){
        if(this.left != null){
            this.left.inOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.inOrder();
        }
    }

    public void postOrder(){
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
        System.out.println(this);
    }

    public NoDe preOrderSearch(NoDe noDe){
        if(this.equals(noDe)){
            return this;
        }
        if(this.left != null){
            NoDe result = this.left.preOrderSearch(noDe);
            if (result != null) {
                return result;
            }
        }
        if(this.right != null){
            NoDe result = this.right.preOrderSearch(noDe);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public NoDe inOrderSearch(NoDe noDe){
        if(this.left != null){
            NoDe result = this.left.inOrderSearch(noDe);
            if (result != null) {
                return result;
            }
        }
        if(this.equals(noDe)){
            return this;
        }
        if(this.right != null){
            NoDe result = this.right.inOrderSearch(noDe);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public NoDe postOrderSearch(NoDe noDe){
        if(this.left != null){
            NoDe result = this.left.postOrderSearch(noDe);
            if (result != null) {
                return result;
            }
        }
        if(this.right != null){
            NoDe result = this.right.postOrderSearch(noDe);
            if (result != null) {
                return result;
            }
        }
        if(this.equals(noDe)){
            return this;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NoDe{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NoDe<?> noDe)) return false;
        return getValue() == noDe.getValue() && Objects.equals(data, noDe.data) && Objects.equals(getName(), noDe.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, getValue(), getName());
    }
}
