package com.baizhi.entity;

import com.baizhi.dao.FeedbackDao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Feedback
 * @Author wyy
 * @Date 2020/8/28 19:13
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "yx_feedback")
public class Feedback implements Serializable {
    @Id
    private String id;
    private String title;
    private String content;
    @Column(name = "user_id")
    private String userId;
    @Column(name="save_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saveDate;


}
