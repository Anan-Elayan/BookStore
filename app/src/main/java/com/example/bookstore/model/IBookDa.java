package com.example.bookstore.model;

import java.util.List;

public interface IBookDa {
    List<Book> getBooks(String Category);
    String [] getCategories();
}
