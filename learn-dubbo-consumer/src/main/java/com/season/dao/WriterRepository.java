package com.season.dao;

import com.season.domain.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/5/16.
 */
public interface WriterRepository extends JpaRepository<Writer,Long>{

    Writer findWriterByName(String name);


}
