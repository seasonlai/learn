package com.season.controller;

import com.season.domain.BaseResult;
import com.season.domain.Book;
import com.season.domain.Writer;
import com.season.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/5/16.
 */
@RestController
@RequestMapping("/book")
@Api(value = "书籍接口",description = "书籍接口")
public class BookController extends BaseController{

    @Autowired
    BookService bookService;

    @ApiOperation(value = "添加书籍", httpMethod = "POST")
    @RequestMapping(value = "/addBook",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult addBook(@RequestBody Book book, @RequestParam("writerName")String writerName){

        Book result = bookService.addBook(book,writerName);
        BaseResult r= result!=null?new BaseResult(0,"成功",result):BaseResult.unKnow("失败");
        return r;
    }

    @ApiOperation(value = "添加书籍", httpMethod = "POST")
    @RequestMapping(value = "/addWriter",method = RequestMethod.POST)
    public BaseResult addWriter(@RequestParam("writerName")String writerName){

        Writer result = bookService.addWriter(writerName);

        return result!=null?new BaseResult(0,"成功",result):BaseResult.unKnow("失败");
    }


    @ApiOperation(value = "查询作者", httpMethod = "GET")
    @RequestMapping(value = "/getWriter/{name}",method = RequestMethod.GET)
    public BaseResult getWriter(@PathVariable("name") String name){

        Writer result = bookService.findWriterByName(name);

        return result!=null?new BaseResult(0,"成功",result):BaseResult.unKnow("失败");
    }


    @ApiOperation(value = "查询书籍", httpMethod = "GET")
    @RequestMapping(value = "/getBook/{name}",method = RequestMethod.GET)
    public BaseResult getBook(@PathVariable("name") String name){

        List<Book> result = bookService.findBookByName(name);

        return result!=null?new BaseResult(0,"成功",result):BaseResult.unKnow("失败");
    }
}
