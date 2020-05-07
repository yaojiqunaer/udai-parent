package com.oracle.udai.product.domain.dto;

public class SpecGroup {
    private Integer id;

    private Integer spgId;

    private String name;

    private Boolean isDelted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpgId() {
        return spgId;
    }

    public void setSpgId(Integer spgId) {
        this.spgId = spgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getIsDelted() {
        return isDelted;
    }

    public void setIsDelted(Boolean isDelted) {
        this.isDelted = isDelted;
    }
}