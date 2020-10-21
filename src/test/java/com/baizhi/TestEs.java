package com.baizhi;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.Student;
import com.baizhi.repository.StudentRespository;
import io.goeasy.GoEasy;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEs {
    @Resource
    StudentRespository respository;
    @Resource
    ElasticsearchTemplate template;
    @Test
    public void testStudent(){
        Student student = new Student("3","豆豆","1111111",new Date());
        respository.save(student);
    }

    @Test
    public void testDelete(){
        Student student = new Student();
        student.setId("1");
        respository.delete(student);
    }

    @Test
    public void testFind(){
        Iterable<Student> all = respository.findAll();
        all.forEach(student -> System.out.println(student));
    }


    @Test
    public void testFind2(){
        //Page<Student> birthday = respository.findAll(Sort.Order.asc("birthday"));
        //birthday.forEach(student -> System.out.println(student));
    }


    @Test
    public void testFind3(){
        Page<Student> all = respository.findAll(PageRequest.of(0, 1));
        all.forEach(student -> System.out.println(student));
    }

    @Test
    public void testFind4(){
        Optional<Student> byId = respository.findById("2");
        System.out.println(byId);
    }
    @Test
    public void testFind5(){
        List<Student> list = respository.findByName("小白鱼");
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void querySearch(){
        String content="豆豆";
        //创建查询条件对象
        NativeSearchQuery searchQuery= new NativeSearchQueryBuilder()
                .withIndices("yingxs")//指定索引
                .withTypes("student")//指定类型
                .withQuery(QueryBuilders.queryStringQuery(content).field("name"))//指定查询条件
                .build();

        List<Student> list = template.queryForList(searchQuery, Student.class);
        list.forEach(student -> System.out.println(student));
    }


    @Test
    //高亮查询
    public void querySearch1(){
        String content="豆豆";

        //构建处理高亮对象
        HighlightBuilder.Field field = new HighlightBuilder.Field("*");
        field.preTags("<span style='color:red'>");//前缀
        field.postTags("</span>");
        //创建查询条件对象
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withIndices("yingxs")//指定索引
                .withTypes("student")//指定类型
                .withQuery(QueryBuilders.queryStringQuery(content).field("name"))//指定查询条件
                .withHighlightFields(field)//处理高亮
                .build();
        //高亮查询
        AggregatedPage<Student> students = template.queryForPage(build, Student.class, new SearchResultMapper() {
            @Override
            //处理高亮结果
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {

                List<Student> list = new ArrayList<>();
                //获取查询结果
                SearchHit[] hits = searchResponse.getHits().getHits();
                for (SearchHit hit:hits){
                    /*  ------{"id":"3","name":"豆豆","password":"1111111","birthday":1599694647198}
                        ------{name=[name], fragments[[<span style='color:red'>豆豆</span>]]}
                     */
                    System.out.println("------"+hit.getSourceAsString());//原始数据
                    System.out.println("------"+hit.getHighlightFields());//高亮数据

                    //原始数据
                    Map<String, Object> map = hit.getSourceAsMap();
                    String id = map.get("id").toString();
                    String name = map.get("name").toString();
                    String password = map.get("password").toString();
                    String birthday = map.get("birthday").toString();
                    //处理日期格式
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    Date date =null;
                    try {
                        date = sdf.parse(birthday);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Student student = new Student(id, name, password, date);
                    //处理高亮数据
                    Map<String, HighlightField> high = hit.getHighlightFields();
                    String name1 = high.get("name").getFragments()[0].toString();
                    student.setName(name1);
                    System.out.println("name1==="+name1);
                    list.add(student);

                }
                return null;
               // return new AggregatedPageImpl<T>((List<T>list));
            }
        });
    }
}
