package com.cmd.mongodemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cmd.mongodemo.entity.Town;

public interface TownService extends IService<Town> {
    public String insert(String json,String num);
}
