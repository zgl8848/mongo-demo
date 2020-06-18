package com.cmd.mongodemo.controller;

import com.cmd.mongodemo.entity.Town;
import com.cmd.mongodemo.entity.User;
import com.cmd.mongodemo.mapper.UserMapper;
import com.cmd.mongodemo.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MongoController {


    @Autowired
    private TownService townService;

    @RequestMapping(path = "/add")
    public String insert(@RequestParam(value = "json",required = false) String json,@RequestParam(value = "num",required = false) String num){
        return townService.insert(json,num);
    }


    /**
     * 获取当前格式化时间
     * @return
     */
    public String FormattingTime(){
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());*/
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Resource
    private UserMapper userMapper;

    @RequestMapping(path = "/dealWith")
    public String dealWith(){
        userMapper.dealWith("EADFFE80EB32487F81C16EBE2DDD0F04");
        return "seccuss";
    }
    @RequestMapping(path = "/show")
    public String ss(){
        return  userMapper.showUserRole();
    }

    @RequestMapping(path = "/save")
    public String save(){
        userMapper.saveUser();
        return "succes";
    }
    @RequestMapping(path = "/first")
    public String showFirst(){
        return userMapper.showRole();
    }

    @RequestMapping(path = "/saveGend")
    public String saveGend(){
        userMapper.saveGend();
        return "seccus";
    }
}
