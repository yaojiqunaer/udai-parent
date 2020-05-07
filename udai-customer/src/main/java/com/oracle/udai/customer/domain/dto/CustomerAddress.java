package com.oracle.udai.customer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {
    private Integer id;

    private Integer customerId;

    private String name;

    private String tel;

    private String address;

    private Boolean prime;

    private Boolean isDeleted;
    
}