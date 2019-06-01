package com.lumia.wallpaper.entity;


import java.util.List;

/**
 * @author lumia
 * @description   Bing每日图片URLJSON对象
 * @date 2019/6/1 10:59
 */
public class WallPaperUrl {

    private List<Image> images;

    private ToolTips tooltips;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public ToolTips getTooltips() {
        return tooltips;
    }

    public void setTooltips(ToolTips tooltips) {
        this.tooltips = tooltips;
    }
}
