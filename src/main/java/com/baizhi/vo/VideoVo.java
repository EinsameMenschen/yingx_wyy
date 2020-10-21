package com.baizhi.vo;

import com.baizhi.entity.Video;
import com.baizhi.po.VideoPo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.IntrospectionException;
import java.util.List;

/**
 * @ClassName VideoVo
 * @Author wyy
 * @Date 2020/9/1 18:32
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoVo {
    private String id;
    private String videoTitle;
    private String cover;
    private String path;
    private String uploadTime;
    private String description;
    private Integer likeCount;
    private String cateName;
    private String userPhoto;
    //视屏播放
    private String userPicImg;
    private String categoryId;
    private String userId;
    private String userName;
    private Integer playCount;
    private String isAttention;
    private List<VideoVo> videoList;


    public VideoVo(String id, String videoTitle, String cover, String path, String uploadTime, String description, Integer likeCount, String cateName, String userPhoto) {
        this.id = id;
        this.videoTitle = videoTitle;
        this.cover = cover;
        this.path = path;
        this.uploadTime = uploadTime;
        this.description = description;
        this.likeCount = likeCount;
        this.cateName = cateName;
        this.userPhoto = userPhoto;
    }

    public VideoVo(String id, String videoTitle, String cover, String path, String uploadTime, String description, Integer likeCount, String cateName, String categoryId,String userId) {
        this.id = id;
        this.videoTitle = videoTitle;
        this.cover = cover;
        this.path = path;
        this.uploadTime = uploadTime;
        this.description = description;
        this.likeCount = likeCount;
        this.cateName = cateName;
        this.categoryId = categoryId;
        this.userId=userId;
    }
    public VideoVo(String id, String videoTitle, String cover, String path, String uploadTime, String description, Integer likeCount, String cateName, String categoryId,String userId,String userName) {
        this.id = id;
        this.videoTitle = videoTitle;
        this.cover = cover;
        this.path = path;
        this.uploadTime = uploadTime;
        this.description = description;
        this.likeCount = likeCount;
        this.cateName = cateName;
        this.categoryId = categoryId;
        this.userId=userId;
        this.userName=userName;
    }


    public VideoVo(String id, String videoTitle, String cover, String path, String uploadTime, String description, Integer likeCount, String cateName,String categoryId, String userId, String userPicImg,String userName, Integer playCount, String isAttention, List<VideoVo> videoList) {
        this.id = id;
        this.videoTitle = videoTitle;
        this.cover = cover;
        this.path = path;
        this.uploadTime = uploadTime;
        this.description = description;
        this.likeCount = likeCount;
        this.cateName = cateName;
        this.userPicImg = userPicImg;
        this.categoryId = categoryId;
        this.userId = userId;
        this.userName = userName;
        this.playCount = playCount;
        this.isAttention = isAttention;
        this.videoList = videoList;
    }

}
