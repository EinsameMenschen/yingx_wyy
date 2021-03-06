package com.baizhi.service.impl;

import com.baizhi.annotation.AddLog;
import com.baizhi.dao.FeedbackDao;
import com.baizhi.entity.Feedback;
import com.baizhi.entity.User;
import com.baizhi.service.FeedbackService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName FeedBackServiceImpl
 * @Author wyy
 * @Date 2020/8/29 10:22
 * @Description TOOO
 */
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;


    @Override
    @AddLog(value = "查询反馈数据")
    public HashMap<String, Object> queryPageFeedback(Integer page, Integer rows) {
        //将页码  总条数 每页的页数存起来吗  展示到jsp
        HashMap<String, Object> map = new HashMap<>();

        Feedback feedback = new Feedback();
        RowBounds row = new RowBounds((page-1)*rows,rows);
        List<Feedback> feedbacks = feedbackDao.selectByRowBounds(feedback, row);
        int i = feedbackDao.selectCount(feedback);

        map.put("total",(i%rows==0)? (i/rows):(i/rows+1));
        map.put("records",i);
        map.put("rows",feedbacks);
        map.put("page",page);
        return map;
    }

    @Override
    @AddLog(value = "添加反馈数据")
    public void add(Feedback feedback) {
        feedback.setId(UUID.randomUUID().toString());
        feedback.setUserId("1");
        feedback.setSaveDate(new Date());

        feedbackDao.insertSelective(feedback);

    }

    @Override
    @AddLog(value = "删除反馈数据")
    public void del(Feedback feedback) {
        feedbackDao.deleteByPrimaryKey(feedback);
    }
}
