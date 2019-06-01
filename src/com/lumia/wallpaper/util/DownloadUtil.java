package com.lumia.wallpaper.util;

import com.lumia.wallpaper.entity.Image;
import com.lumia.wallpaper.entity.WallPaperUrl;
import com.lumia.wallpaper.listener.DownloadFinishListener;
import com.lumia.wallpaper.listener.RequestFinishListener;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lumia
 * @description  图片下载保存
 * @date 2019/5/31 21:19
 */
public class DownloadUtil {

    /**
     * 检查当天的下载是否已经执行，防止重复下载
     * @return
     */
    private static boolean check(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String time = dateTime.format(formatter);
        File file = new File("D:\\Pictures\\lovewallpaper\\wallpaper\\" + time + ".jpg");
        if (file.exists()){
            return true;
        }
        return false;
    }

    /**
     * 获取bing的URL信息
     */
    public static void downloadWallPaper(){
        if (!check()){
            String requestAddress = "https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
            HttpUtil.doGet(requestAddress, new RequestFinishListener() {
                @Override
                public void finish(WallPaperUrl url) {
                    downloadPhoto(url);
                }

                @Override
                public void error(Exception ex) {
                    CommUtil.saveLog("请求图片网络地址异常" + ex.toString());
                }
            });
        }
    }

    /**
     * 下载图片
     * @param url
     */
    public static void downloadPhoto(WallPaperUrl url) {
        String picDir = "D:\\Pictures\\lovewallpaper\\wallpaper";
        File saveDir = new File(picDir);
        if (!saveDir.exists()){
            saveDir.mkdirs();
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String name = now.format(formatter) + ".jpg";
        Image image = url.getImages().get(0);
        String picAddress = "http://s.cn.bing.net" + image.getUrl();
        String copyright = image.getCopyright();
        String describle = copyright.substring(0, copyright.indexOf("("));
        HttpUtil.downloadPicture(picAddress, picDir, name, new DownloadFinishListener() {
            @Override
            public void finish() {
                String decribleUtf8 = null;
                try {
                    byte[] gbks = describle.getBytes("GBK");
                     decribleUtf8 = new String(gbks, "UTF8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                CommUtil.saveLog( "下载成功," + "必应图片描述：" + decribleUtf8);
            }

            @Override
            public void error(Exception ex) {
                CommUtil.saveLog("下载图片时异常，" + ex.toString());
            }
        });
    }
}
