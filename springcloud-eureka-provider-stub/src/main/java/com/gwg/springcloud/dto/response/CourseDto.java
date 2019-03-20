package com.gwg.springcloud.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseDto implements Serializable {

    private Integer id;
    private String name;
    private String code;
}
