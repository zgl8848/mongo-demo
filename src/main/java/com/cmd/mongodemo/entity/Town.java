package com.cmd.mongodemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_town")
public class Town extends Model<Town> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    @Id
    private Integer id;
    private String code;
    private String name;
    private String areacode;

    public Town(Integer id,String code,String name,String areacode){
        this.id = id;
        this.code = code;
        this.name = name;
        this.areacode = areacode;
    }

    public Town(String code,String name,String areacode){
        this.code = code;
        this.name = name;
        this.areacode = areacode;
    }
}
