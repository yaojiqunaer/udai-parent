package com.oracle.udai.product.domain.dto;

public class SpecParam {
    private Integer id;

    private Integer spgId;

    private Integer sppId;

    private String name;

    private Boolean numeric;

    private String unit;

    private Boolean generic;

    private Boolean searching;

    private String segements;

    private Boolean isDeleted;

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

    public Integer getSppId() {
        return sppId;
    }

    public void setSppId(Integer sppId) {
        this.sppId = sppId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getNumeric() {
        return numeric;
    }

    public void setNumeric(Boolean numeric) {
        this.numeric = numeric;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Boolean getGeneric() {
        return generic;
    }

    public void setGeneric(Boolean generic) {
        this.generic = generic;
    }

    public Boolean getSearching() {
        return searching;
    }

    public void setSearching(Boolean searching) {
        this.searching = searching;
    }

    public String getSegements() {
        return segements;
    }

    public void setSegements(String segements) {
        this.segements = segements == null ? null : segements.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}