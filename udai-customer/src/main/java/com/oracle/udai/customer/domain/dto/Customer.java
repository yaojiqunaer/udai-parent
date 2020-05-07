package com.oracle.udai.customer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String salt;

    private String wechat;

    private String tel;

    private Integer levelId;

    private Date createTime;

    private Date lastUpdateTime;

    private Boolean isDeleted;

}