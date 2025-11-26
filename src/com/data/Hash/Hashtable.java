package com.data.Hash;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * 作者：张鹏烨
 * 2025/9/21
 **/
public class Hashtable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashTab hashTab = new HashTab(8);
        File file = new File("D:\\experiment\\hash.dat");
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                hashTab = (HashTab) ois.readObject();
                System.out.println("从文件加载数据成功");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("读取文件失败，使用新的哈希表: " + e.getMessage());
            }
        } else {
            System.out.println("文件不存在或为空，使用新的哈希表");
        }
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("添加链表(add):");
            System.out.println("遍历链表(list):");
            System.out.println("查找职(find):");
            System.out.println("退出系统(exit):");
            char s = scanner.next().charAt(0);
            switch(s){
                case 'a':
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入职员名字");
                    String name = scanner.next();
                    hashTab.add(new Emp(id,name));
                    break;
                case 'l':
                    hashTab.show();
                    break;
                case 'f':
                    System.out.println("查找职员的id:");
                    int num = scanner.nextInt();
                    hashTab.findEmp(num);
                    break;
                case 'r':
                    System.out.println("请输入所要删除职员的id:");
                    int sum = scanner.nextInt();
                    hashTab.remove(sum);
                case 'e':
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                        ObjectOutputStream oos;
                        oos = new ObjectOutputStream(new FileOutputStream("D:\\experiment\\hash.dat"));
                        oos.writeObject(hashTab);
                        oos.close();
                        System.out.println("保存成功");
                    System.out.println("系统退出");
                    loop = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("识别错误请重新输入:");
            }

        }
    }
}
class HashTab implements Serializable {
    private static final long serialVersionUID = 1L;
    EmpLinkedList[] EmpLinkedListArrays;
    public void remove(int num){
        int no = num % EmpLinkedListArrays.length;
        EmpLinkedListArrays[no].remove(num);
    }
    public HashTab(int size) {
        EmpLinkedListArrays = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            EmpLinkedListArrays[i] = new EmpLinkedList();
        }
    }
    public int Hashfun(Emp emp){
        return emp.getId() % EmpLinkedListArrays.length;
    }
    public void findEmp(int id){
        int no = id % EmpLinkedListArrays.length;
        Emp emp = EmpLinkedListArrays[no].findid(id);
        System.out.println(emp);
    }
    public void add(Emp emp){
        int no = Hashfun(emp);
        EmpLinkedListArrays[no].add(emp);
    }
    public void show(){
        for (int i = 0; i < EmpLinkedListArrays.length; i++) {
            EmpLinkedListArrays[i].show();
        }
    }
}
class Emp implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Emp emp)) return false;
        return getId() == emp.getId() && Objects.equals(getName(), emp.getName());
    }
}
class EmpLinkedList implements Serializable{
    private static final long serialVersionUID = 1L;
    Emp head;
    public void add(Emp emp){
        if (head == null){
            head = emp;
        }
        else {
            Emp temp = head;
            while (temp != null){
                if (temp.getId() == emp.getId()){
                    System.out.println("工号相同无法添加");
                    return;
                }
                temp = temp.next;
            }
            temp = head;
            while (temp.next != null && temp.getId() > emp.getId()){
                temp = temp.next;
        }
                    emp.next = temp.next;
                    temp.next = emp;
            }
        }
    public void show(){
        if (this.head == null){
            System.out.println("本链表为空");
            return;
        }
        Emp temp = this.head;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println("遍历完毕");
    }
    public Emp findid(int id){
        Emp temp = this.head;
        while (true){
            if(temp.getId() == id){
                return temp;
            }

            if (temp.next == null){
                System.out.println("没有找到");
                return null;
            }
            temp = temp.next;
        }
    }
    public Emp getEmp(int i){
        if(head == null){
            System.out.println("链表为空");
        }
        if (size() < i){
            System.out.println("超出该链表大小");
            return null;
        }
        int num = 0;
        Emp temp = this.head;
        while (num != i){
            temp = temp.next;
            num++;
        }
        return temp;
    }
    public int size(){
        if(this.head == null){
            System.out.println("该链表为空");
            return -1;
        }
        int num = 0;
        Emp temp = this.head;
        while (temp != null){
            temp = temp.next;
            num++;
        }
        return num;
    }
    public int IndexOf(Emp emp){
        Emp temp = this.head;
        int num = 0;
        while ( temp != null && !temp.equals(emp) ){
            num++;
            temp = temp.next;
        }
        return num;
    }
    public void remove(int i){
        if (i > size()){
            System.out.println("本链表中不含有该元素");
            return;
        }
        if (i == 0){
            this.head =null;
            return;
        }
        Emp temp = getEmp(i);
        temp.next = temp.next.next;
        Emp cer = getEmp(i);
        cer.next = null;
    }
    }


