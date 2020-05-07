package com.oracle.udai.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName CustomerVO
 * @Description:
 * @Author zhangxiaodong
 * @Date 2020/5/1 16:20
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVO {
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
