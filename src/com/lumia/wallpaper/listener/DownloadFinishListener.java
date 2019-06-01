package com.lumia.wallpaper.listener;

/**
 * @author lumia
 * @description  下载完成监听
 * @date 2019/5/31 21:02
 */
public interface DownloadFinishListener {

    void  finish();

    void error(Exception ex);
}
