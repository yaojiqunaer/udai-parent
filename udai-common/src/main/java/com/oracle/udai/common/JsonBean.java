package com.oracle.udai.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CHENCHEN
 * @create 2020-04-02 10:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonBean {
    private int code;

    private String msg;

    private Object data;

}
