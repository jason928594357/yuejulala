package com.yuejulala.item.service;

import com.yuejulala.item.pojo.Brand;

import java.util.List;

public interface BrandService {
    void saveBrand(Brand brand, List<Long> cids);
}
