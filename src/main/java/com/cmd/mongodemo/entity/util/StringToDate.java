package com.cmd.mongodemo.entity.util;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Direction: MongoDB -> Java
@ReadingConverter
public class StringToDate implements Converter<String, LocalDateTime>  {
    @Override
    public LocalDateTime convert(String source) {
        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }
}
