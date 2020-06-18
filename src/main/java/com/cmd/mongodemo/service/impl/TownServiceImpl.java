package com.cmd.mongodemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmd.mongodemo.entity.Town;
import com.cmd.mongodemo.mapper.TownMapper;
import com.cmd.mongodemo.service.TownService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("townService")
@AllArgsConstructor
public class TownServiceImpl  extends ServiceImpl<TownMapper, Town> implements IService<Town>, TownService {

    @Autowired(required = false)
    private final TownMapper townMapper;

    @Override
    public String insert(String json,String num){
        Town town = null;
        String[] name =json.split(",");
        for (int i = 1;i<=name.length;i++){
            System.out.println(name[i-1]);
            if(i>=10){
                town  = new Town(0,num+i,name[i-1],num);
            }else{
                town  = new Town(0,num+"0"+i,name[i-1],num);
            }
           /* System.out.println("town: "+ JSON.toJSONString(town));
            if(baseMapper.insert(town)<=0){
               return "error";
            }*/
        }
        return "seccuss";
    }
}