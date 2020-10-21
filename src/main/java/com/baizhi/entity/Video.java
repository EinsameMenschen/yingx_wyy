package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Video
 * @Author wyy
 * @Date 2020/8/28 0:34
 * @Description TOOO
 */
@Document(indexName = "yingxv",type = "video")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="yx_video")
public class Video implements Serializable {
    @Id
    private String id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String biref;
    @Field(type = FieldType.Keyword)
    private String path;
    @Field(type = FieldType.Keyword)
    private String cover;
    @Field(type = FieldType.Date)
    @Column(name = "publish_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    @Field(type = FieldType.Keyword)
    @Column(name = "category_id")
    private String categoryId;
    @Field(type = FieldType.Keyword)
    @Column(name = "user_id")
    private String userId;
    @Field(type = FieldType.Keyword)
    @Column(name = "group_id")
    private String groupId;
}
