package com.oracle.udai.product.domain.dto;

public class CategoryBrand extends CategoryBrandKey {
    private Boolean isDeleted;

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}