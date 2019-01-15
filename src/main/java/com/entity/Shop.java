package com.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Shop {
    private Integer classId;

    private String className;

    private Integer classKey;

    private Integer level;

    private Integer ondelect;

    private String images;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Integer getClassKey() {
        return classKey;
    }

    public void setClassKey(Integer classKey) {
        this.classKey = classKey;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOndelect() {
        return ondelect;
    }

    public void setOndelect(Integer ondelect) {
        this.ondelect = ondelect;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }
}