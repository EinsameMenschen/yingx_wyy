package com.baizhi.repository;

import com.baizhi.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

//泛型  <操作对象的实体类型   序列化主键的类型>
public interface StudentRespository extends ElasticsearchRepository<Student,String> {
    List<Student> findByName(String name);

}
