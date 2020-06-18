package com.cmd.mongodemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmd.mongodemo.entity.Town;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TownMapper extends BaseMapper<Town> {
}
