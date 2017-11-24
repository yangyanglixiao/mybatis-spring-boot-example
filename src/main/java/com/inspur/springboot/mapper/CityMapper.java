package com.inspur.springboot.mapper;

import com.inspur.springboot.model.City;
import com.inspur.springboot.util.MyMapper;

public interface CityMapper extends MyMapper<City> {
    
    public City queryCityById(String id);
    
}
