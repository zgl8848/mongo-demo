package com.cmd.mongodemo.entity.util;


import java.time.LocalDateTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

// Direction: Java -> MongoDB
@WritingConverter
public class DateToString implements Converter<LocalDateTime, String> {
    @Override
    public String convert(LocalDateTime source) {
        return source.toString() + 'Z';
    }
}
