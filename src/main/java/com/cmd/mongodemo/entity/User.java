package com.cmd.mongodemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "user")
@Data
@Accessors(chain = true)
public class User implements Serializable {

    @Id
    private int id;
    private String arms;
    private String name;
    private int roleid;
    private String sex;
    private LocalDateTime birthday;
}
