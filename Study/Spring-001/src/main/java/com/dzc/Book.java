package com.dzc;

/**
 * @author dong
 * @title: Book
 * @projectName Spring-001
 * @description: TODO
 * @date 2022/2/3 23:41
 **/
public class Book {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
