package com.hr.comm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor //全参构造方法
public class Result {
    String message;
    Integer status;
    Object object;

}
