package com.lumia.wallpaper;

import com.lumia.wallpaper.util.DownloadUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lumia
 * @description  下载图片
 * @date 2019/5/31 22:16
 */
public class GetWallPaper {

    public static void main(String[] args) {
        downloadTimer();
    }

    /**
     * 实现定时任务
     */
    public static void downloadTimer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                DownloadUtil.downloadWallPaper();
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //每天上午六点开启定时任务
        calendar.set(year, month, day, 6, 0, 0);
        Date date = calendar.getTime();
        Timer timer = new Timer();
        //每天0时刻开始执行  每隔30分钟重复执行一次
        int peroid = 30 * 60 *1000;
        timer.schedule(task, date, peroid);
    }
}
