package com.gavin.mapper;

import com.gavin.pojo.Book;
import com.gavin.pojo.saleBook;

import java.util.List;

public interface BookMapper {

     List<Book> findAllBook();

    List<Book> findBookByName(String BookName);

     int addBook(Book book);

    int saleBook (saleBook sBook);

    int delBookById(Integer BookId);

}
