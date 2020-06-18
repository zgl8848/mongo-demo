package com.cmd.mongodemo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@NoArgsConstructor
@Data
@Document(collection = "grid_alarm_deal")
public class AlarmDeal {

    /**
     * 实时告警id
     */
    @Id
    private String id;
    /**
     * 告警标题
     */
    @Field("alarm_title")
    private String alarmTitle;
    /**
     * 告警类型
     */
    @Field("alarm_type")
    private String alarmType;
    /**
     * 告警级别
     */
    @Field("alarm_level")
    private String alarmLevel;
    /**
     * 告警状态
     * 0:已处理	1:处理中
     */
    @Field("alarm_state")
    private String alarmState;
    /**
     * 告警来源
     */
    @Field("alarm_source")
    private String alarmSource;
    /**
     * 告警消息
     */
    @Field("alarm_msg")
    private String alarmMsg;
    /**
     * 学校id
     */
    @Field("school_id")
    private String schoolId;
    /**
     * 设备ip
     */
    @Field("device_ip")
    private String deviceIp;
    /**
     * 图片url
     */
    @Field("pic_url")
    private String picUrl;
    /**
     * 视频url
     */
    @Field("video_url")
    private String videoUrl;
    /**
     * 告警描述
     */
    @Field("alarm_desc")
    private String alarmDesc;
    /**
     * 告警结束时间
     */
    @Field("end_time")
    private Date endTime;
    /**
     * 告警开始时间
     */
    @Field("start_time")
    private Date startTime;
    /**
     * 告警模块
     */
    @Field("alarm_module")
    private String alarmModule;

    /**
     * 告警类型
     * 1-设备信息 2-告警信息 3-黑名单告警4-围栏告警 5-表情告警
     */
    @Field("data_type")
    private String dataType;

    public AlarmDeal(String alarmTitle, String alarmType, String alarmLevel, String alarmState, String alarmSource, String alarmMsg, String schoolId, String deviceIp, String picUrl, String videoUrl, String alarmDesc, Date endTime, Date startTime, String dataType) {
        this.dataType = dataType;
        this.alarmTitle = alarmTitle;
        this.alarmType = alarmType;
        this.alarmLevel = alarmLevel;
        this.alarmState = alarmState;
        this.alarmSource = alarmSource;
        this.alarmMsg = alarmMsg;
        this.schoolId = schoolId;
        this.deviceIp = deviceIp;
        this.picUrl = picUrl;
        this.videoUrl = videoUrl;
        this.alarmDesc = alarmDesc;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public AlarmDeal(String id, String alarmTitle, String alarmType, String alarmLevel, String alarmState, String alarmSource, String alarmMsg, String schoolId, String deviceIp, String picUrl, String videoUrl, String alarmDesc, Date endTime, Date startTime, String dataType) {
        this.id = id;
        this.alarmTitle = alarmTitle;
        this.alarmType = alarmType;
        this.alarmLevel = alarmLevel;
        this.alarmState = alarmState;
        this.alarmSource = alarmSource;
        this.alarmMsg = alarmMsg;
        this.schoolId = schoolId;
        this.deviceIp = deviceIp;
        this.picUrl = picUrl;
        this.videoUrl = videoUrl;
        this.alarmDesc = alarmDesc;
        this.endTime = endTime;
        this.startTime = startTime;
        this.dataType = dataType;
    }
}
