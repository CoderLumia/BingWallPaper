package com.lumia.wallpaper.entity;


/**
 * @author lumia
 * @description  图片实体类
 * @date 2019/6/1 10:46
 */
public class Image {

    private String startdate;

    private String fullstartdate;

    private String enddate;

    private String url;

    private String urlbase;

    private String copyright;

    private String title;

    private String quiz;

    private Boolean wp;

    private String hsh;

    private Integer drk;

    private Integer top;

    private Integer bot;

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getFullstartdate() {
        return fullstartdate;
    }

    public void setFullstartdate(String fullstartdate) {
        this.fullstartdate = fullstartdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlbase() {
        return urlbase;
    }

    public void setUrlbase(String urlbase) {
        this.urlbase = urlbase;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public Boolean getWp() {
        return wp;
    }

    public void setWp(Boolean wp) {
        this.wp = wp;
    }

    public String getHsh() {
        return hsh;
    }

    public void setHsh(String hsh) {
        this.hsh = hsh;
    }

    public Integer getDrk() {
        return drk;
    }

    public void setDrk(Integer drk) {
        this.drk = drk;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getBot() {
        return bot;
    }

    public void setBot(Integer bot) {
        this.bot = bot;
    }
}
