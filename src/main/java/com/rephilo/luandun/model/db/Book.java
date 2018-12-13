package com.rephilo.luandun.model.db;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 书籍实体
 *
 * @author rephilo
 */
@Entity
public class Book {
    /**
     * 主键id
     */
    @Id
    private int id;
    /**
     * 封面
     */
    private String imageUrl;
    /**
     * 主标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 作者
     */
    private String author;
    /**
     * 译者
     */
    private String translator;
    /**
     * 出版社
     */
    private String press;
    /**
     * 出版日期
     */
    private String pubTime;
    /**
     * 详细介绍
     */
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
