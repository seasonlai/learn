package com.season.service;

import com.season.dao.BookRepository;
import com.season.dao.WriterRepository;
import com.season.domain.Book;
import com.season.domain.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Administrator on 2018/5/16.
 */
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    WriterRepository writerRepository;


    public void publish(Book book){

    }

    public List<Book> findBookByName(String name){
        Book book= new Book();
        book.setName(name);

        return bookRepository.findAll(Example.of(book));
    }


    public Writer addWriter(String name){
        Assert.isNull(findWriterByName(name),"作者已存在");
        Writer writer = new Writer();
        writer.setName(name);
        return writerRepository.save(writer);
    }

    @Cacheable(value = "writer",key = "#name")
    public Writer findWriterByName(String name){
        return writerRepository.findWriterByName(name);
    }

    public Book addBook(Book book, String writerName){

        Assert.notNull(book,"书籍不能为空");
        Assert.notNull(writerName,"作者不能为空");

        Writer writer = findWriterByName(writerName);
        if(writer==null){
            writer = new Writer();
            writer.setName(writerName);
            writer = writerRepository.save(writer);
        }
        book.setWriter(writer);
        return bookRepository.save(book);
    }

}
