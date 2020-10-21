package com.baizhi.vo;

import com.baizhi.entity.Category;
import com.baizhi.po.CategoryPo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName CategoryVo
 * @Author wyy
 * @Date 2020/9/1 19:54
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {
      private String id;
      private String cateName;
      private String levels;
      private String parentId;
      private List<CategoryPo> categoryList;
}
