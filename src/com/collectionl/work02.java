package com.collectionl;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：张鹏烨
 * 2025/8/20
 **/
public class work02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(new Book("zhangpeny"+i,"" + 'A' + i ,i));
        }
        Book book = null;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1-i; j++) {
                Book b = (Book) list.get(j);
                Book n = (Book) list.get(j + 1);
                if (b.price < n.price){
                    book = b;
                    list.set(j,n);
                    list.set(j + 1,book);
                }


            }

        }
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("kkkk\tooooo");

    }
}
class Book{
    String name ,author;
    int price;

    public Book(String author, String name, int price) {
        this.author = author;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
