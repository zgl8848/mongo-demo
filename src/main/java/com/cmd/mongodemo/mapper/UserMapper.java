package com.cmd.mongodemo.mapper;

import com.alibaba.fastjson.JSON;
import com.cmd.mongodemo.entity.*;
import com.cmd.mongodemo.entity.VO.AlarmVO;
import com.cmd.mongodemo.entity.VO.UserVO;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;


@Component
public class UserMapper {

    @Resource
    private MongoTemplate mongoTemplate;

    public String showUserRole() {
        List<String> aList = new ArrayList<>();
        aList.add("神王");
        aList.add("一级神祗");

        //查询条件
        Criteria criteria = new Criteria();
        //criteria.and("name").is("唐三");
        //criteria.and("roles.name").is("神王");
        //criteria.and("roles.name").in(aList);
        //模糊查询
        //criteria.and("name").regex(".*?\\" +"舞"+ ".*");
        //多表联查
        Aggregation aggregation = Aggregation.newAggregation(
                // 关联role表
                Aggregation.lookup("role","roleid","_id","roles"),
                //Aggregation.match(Criteria.where("_id").is(0)),
                //控制输出的字段
//                Aggregation.group("roles._id")
//                .count().as("rNum")
//                .last("name").as("name"),
                Aggregation.project("name","arms","sex","birthday")
                        .and("user.id").as("id")
                        .and("roles.zgl").as("roleid")
                        .and("roles.name").as("roleName")
//                // 分页：页码
//                Aggregation.skip(Long.valueOf(0)),
//                // 分页：条数
//                Aggregation.limit((long)3),
//                // 排序
//                Aggregation.sort(Sort.Direction.DESC,"id")

        );

        AggregationResults<UserVO> results = mongoTemplate.aggregate(aggregation, "user", UserVO.class);
        List<UserVO> userVOS = results.getMappedResults();
        System.out.println("userVOS: "+JSON.toJSONString(userVOS));
//        Map<String,Integer> map = new HashMap<>();
//        for(int i = 0;i<12;i++){
//            String str = "";
//            Integer num = 0;
//        for(UserVO userVO : userVOS){
//            String birthday = userVO.getBirthday();
//            Date date = java.sql.Date.valueOf(birthday);
//            if(date.getMonth()==i){
//                    num+=1;
//                }
//            }
//            if(i!=10 && i!= 11 && i!=9){
//                str = "0"+(i+1);
//            }else{
//                str = ""+(i+1);
//            }
//            map.put(str,num);
//        }
        return JSON.toJSONString(userVOS);
    }

    public void saveUser(){
       /* try{
            User user = new User();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//定义一个formate
            Date date = simpleDateFormat.parse("2020-03-27 12:12:12");
            System.out.println(date);
            user.setBirthday(date);
            mongoTemplate.insert(user);
        }catch (Exception e){
            e.printStackTrace();
        }*/

    }

    public String groupshow(){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.lookup("role","roleid","_id","roles"),
                Aggregation.group("roleid")
                .last("arms").as("arms")
                       // .count().as("rNum")//,
                //Aggregation.project("")
                       // .and("").as("arms")
                       // .and("rNum").as("rNum")
        );
        AggregationResults<UserVO> results = mongoTemplate.aggregate(aggregation, "user", UserVO.class);
        List<UserVO> alarmVOS = results.getMappedResults();
        return JSON.toJSONString(alarmVOS);
    }

    public String showId(){
        Criteria criteria = new Criteria();
        criteria.and("_id").is(0);
        Query query = new Query();
        query.addCriteria(criteria);
        User user = mongoTemplate.find(query,User.class).get(0);
        return JSON.toJSONString(user);
    }


    public String showRole(){
        Query query = new Query();
        //我是跟一只野兽差不了多少,可这里终究是我的国土
        query.addCriteria(Criteria.where("_id").is(6));
        Update update = new Update();
        update.set("zgl",6);
        update.set("name","神界巡查者");
        mongoTemplate.updateFirst(query, update, Role.class);
        return "sessue";
    }


    public void saveGend(){
        Gend g = new Gend();
        g.setName("潇梦临");
        g.setSex("0000001");
        g.setOld(18);
        g.setBirthday(new Date());
        mongoTemplate.insert(g);
    }



    public List<AlarmVO> queryPage(@Param("startIndex") Integer startIndex, @Param("size") Integer size,
                                   @Param("schoolId") String schoolId, @Param("childDepts")List<String> childDepts,
                                   @Param("roleType") String roleType,
                                   @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime){
        System.out.println("startIndex: "+startIndex);
        System.out.println("size: "+size);
        System.out.println("schoolId: "+schoolId);
        System.out.println("childDepts: "+ JSON.toJSONString(childDepts));
        System.out.println("roleType: "+roleType);
        System.out.println("startTime: "+startTime);
        System.out.println("endTime: "+endTime);
        Criteria criteria = getCriteria(roleType,schoolId,childDepts,startTime,endTime);
        Aggregation aggregation = getAggregation(criteria,startIndex,size);
        AggregationResults<AlarmVO> results = mongoTemplate.aggregate(aggregation, "grid_alarm", AlarmVO.class);
        List<AlarmVO> alarmVOS= results.getMappedResults();
        return alarmVOS;
    }
    public Criteria getCriteria(String roleType, String schoolId, List<String> childDepts, LocalDateTime startTime, LocalDateTime endTime){
        Criteria criteria = new Criteria();
        if(roleType.equals("2")){
            criteria.and("g.school_id").is(schoolId);
        }else if(roleType.equals("1")){
            if(schoolId!=null && !schoolId.equals("")){
                criteria.and("g._id").is(schoolId);
            }else{
                criteria.and("g.dept_id").in(childDepts);
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localstartDate = startTime;
        ZonedDateTime startzdt = localstartDate.atZone(zoneId);
        Date startDate = Date.from(startzdt.toInstant());

        LocalDateTime localendDate = startTime;
        ZonedDateTime endzdt = localendDate.atZone(zoneId);
        Date endDate = Date.from(endzdt.toInstant());

        if(startTime!= null && endTime!=null){
            criteria.and("start_time").gte(sdf.format(startDate));
            //criteria.and("end_time").lte(sdf.format(endDate));逍遥半生酒中意,一剑碎影向征程
        }
        return criteria;
    }

    public Aggregation getAggregation(Criteria criteria,Integer startIndex,Integer size){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.lookup("grid_school","school_id","_id","g"),
                Aggregation.match(criteria),
                Aggregation.project("_id","alarm_title","alarm_type","alarm_level","alarm_state","alarm_source","alarm_msg","school_id","device_ip","pic_url","video_url","alarm_desc","end_time","start_time","alarm_module","data_type")
                        .and("g.school_name").as("schoolName"),
                Aggregation.skip(startIndex),
                Aggregation.limit((long)size),
                Aggregation.sort(Sort.Direction.DESC,"start_time")
        );
        return aggregation;
    }
    /**
     * 处理告警信息,通过ID将grid_alarm的告警转移到grid_alarm_deal表中
     * @param id
     * @return
     */
    public boolean dealWith(String id){
        Query query =new Query(Criteria.where("_id").is(id));
        Alarm alarm = mongoTemplate.findOne(query,Alarm.class);
        AlarmDeal alarmDeal = replace(alarm);
        try{
            query = new Query(Criteria.where("_id").is(id));
            mongoTemplate.remove(query, Alarm.class);
            mongoTemplate.insert(alarmDeal);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public AlarmDeal replace(Alarm alarm){
        AlarmDeal alarmDeal = new AlarmDeal();
        alarmDeal.setAlarmDesc(alarm.getAlarmDesc());
        alarmDeal.setAlarmLevel(alarm.getAlarmLevel());
        alarmDeal.setAlarmModule(alarm.getAlarmModule());
        alarmDeal.setAlarmMsg(alarm.getAlarmMsg());
        alarmDeal.setAlarmSource(alarm.getAlarmSource());
        alarmDeal.setAlarmState("0");
        alarmDeal.setAlarmTitle(alarm.getAlarmTitle());
        alarmDeal.setAlarmType(alarm.getAlarmType());
        alarmDeal.setDataType(alarm.getDataType());
        alarmDeal.setDeviceIp(alarm.getDeviceIp());
        alarmDeal.setEndTime(alarm.getEndTime());
        alarmDeal.setId(alarm.getId());
        alarmDeal.setPicUrl(alarm.getPicUrl());
        alarmDeal.setSchoolId(alarm.getSchoolId());
        alarmDeal.setStartTime(alarm.getStartTime());
        alarmDeal.setVideoUrl(alarm.getVideoUrl());
        return alarmDeal;
    }
}

/*
startIndex: 0
size: 10
schoolId:
childDepts: null
roleType: 0
startTime: 2020-05-01T00:00
endTime: 2020-05-31T00:00
*/