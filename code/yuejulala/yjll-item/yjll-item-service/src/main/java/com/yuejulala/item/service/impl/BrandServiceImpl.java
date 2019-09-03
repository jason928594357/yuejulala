package com.yuejulala.item.service.impl;

import com.yuejulala.common.enums.ExceptionEnum;
import com.yuejulala.common.exception.YjllException;
import com.yuejulala.item.dao.BrandMapper;
import com.yuejulala.item.pojo.Brand;
import com.yuejulala.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Transactional
    @Override
    public void saveBrand(Brand brand, List<Long> cids) {
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if(count!=1){
            throw new YjllException(ExceptionEnum.BRAND_SAVE_ERROR);
        }
        for(Long cid :cids){
            count = brandMapper.insertCategoryBrand(cid, brand.getId());
            if(count!=1){
                throw new YjllException(ExceptionEnum.BRAND_SAVE_ERROR);
            }
        }
    }
}