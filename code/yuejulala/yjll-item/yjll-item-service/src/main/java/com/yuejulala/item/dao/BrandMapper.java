package com.yuejulala.item.dao;

import com.yuejulala.common.mapper.BaseMapper;
import com.yuejulala.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {

    @Insert("INSERT INTO tb_category_brand (category_id,brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid")Long cid, @Param("bid") Long bid);
}
