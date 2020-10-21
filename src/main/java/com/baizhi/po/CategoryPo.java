package com.baizhi.po;

import com.baizhi.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

/**
 * @ClassName CategoryPo
 * @Author wyy
 * @Date 2020/9/1 19:59
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPo {
    private String id;
    private String cateName;
    private String levels;
    private String parentId;
    private List<CategoryPo> categoryList;
}
