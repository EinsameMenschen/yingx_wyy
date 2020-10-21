package com.baizhi.repository;

import com.baizhi.entity.Video;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface VideoRespository extends ElasticsearchRepository <Video,String>{
}
