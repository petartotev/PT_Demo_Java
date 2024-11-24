package com.inventory;

import com.bookapi.Book;
import java.util.ArrayList;
import java.util.List;

public class BookInventory {
    private List<Book> books;

    public BookInventory() {
        this.books = new ArrayList<>();
        books.add(new Book("OCA Study Guide"));
        books.add(new Book("OCP Study Guide"));
    }

    public List<Book> listBooks() {
        return books;
    }
}
