package com.gavin.test;


import com.gavin.mapper.BookMapper;
import com.gavin.pojo.Book;
import com.gavin.pojo.saleBook;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> allBook = mapper.findAllBook();
allBook.stream().forEach(System.out::println);

    }

    @After
    public void after() {
        sqlSession.close();

    }

}
