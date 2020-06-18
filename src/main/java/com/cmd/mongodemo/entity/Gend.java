package com.cmd.mongodemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "gend")
public class Gend {

    @Id
    private String id;
    @Field("g_name")
    private String name;
    @Field("g_sex")
    private String sex;
    @Field("g_old")
    private Integer old;
    @Field("g_birthday")
    private Date birthday;
}
