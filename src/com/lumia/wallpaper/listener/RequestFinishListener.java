package com.lumia.wallpaper.listener;

import com.lumia.wallpaper.entity.WallPaperUrl;

/**
 * @author lumia
 * @description  请求监听接口
 * @date 2019/5/31 21:00
 */
public interface RequestFinishListener {

    void finish(WallPaperUrl url);

    void error(Exception ex);
}
