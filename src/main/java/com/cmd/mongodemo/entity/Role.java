package com.cmd.mongodemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
@Data
public class Role {

    @Id
    private int sacsdvsvsaf;
    private Integer zgl;
    private String name;


}
