package com.season.dao;

import com.season.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/5/16.
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
