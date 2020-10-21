package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName Student
 * @Author wyy
 * @Date 2020/9/2 16:51
 * @Description TOOO
 */
@Document(indexName = "yingxs",type = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    @Id
    @Excel(name = "编号")
    private String id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word"
    )
    @Excel(name="姓名")
    private String name;
    @Field(type = FieldType.Keyword)
    @Excel(name="密码")
    private String password;
    @Field(type = FieldType.Date)
    @Excel(name="生日" ,format = "yyyy-MM-dd")
    private Date birthday;

}
