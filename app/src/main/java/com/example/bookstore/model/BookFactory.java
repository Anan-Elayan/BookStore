package com.example.bookstore.model;

public class BookFactory {

    public IBookDa getBooks(){
        return  new BookDa();
    }
}
