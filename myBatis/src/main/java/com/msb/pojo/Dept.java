package com.msb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// get和set方法以及toString
@Data
// 全参构造器
@AllArgsConstructor
// 无参构造器
@NoArgsConstructor
public class Dept implements Serializable {
    private Integer Id;
    private String name;
    private String loc;
}
