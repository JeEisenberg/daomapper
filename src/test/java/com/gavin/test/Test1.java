package com.gavin.test;

import com.gavin.pojo.Book;
import com.gavin.pojo.buyBook;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    private SqlSession sqlSession = null;
    SqlSessionFactory factory = null;

    @Before
    public void Init() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(resource);


    }

    @Test
    public void Test() {
       sqlSession = factory.openSession();

        List<Object> bookList = sqlSession.selectList("findAllBook");
        bookList.stream().forEach(System.out::println);
      /*  Book book= new Book();
        book.setBookName("C++");
        book.setBookKind("计算机");
        book.setBookPrice(65.9);
        book.setBookPublish("电子科技出版社");
        book.setBookCount(100);

        int result = sqlSession.insert("addBook", book);
        if (result==1){
            System.out.println("添加成功");
        }*/
        buyBook b = new buyBook();
        b.setBookCount(10);
        b.setBookId(1001);


        int saleBook = sqlSession.update("saleBook", b);
        sqlSession.commit();
        if (saleBook == 1) System.out.println("已成功购买");
    }

    @After
    public void after() {
        sqlSession.close();

    }

}
