package com.lumia.wallpaper.util;

import com.alibaba.fastjson.JSON;
import com.lumia.wallpaper.entity.WallPaperUrl;
import com.lumia.wallpaper.listener.DownloadFinishListener;
import com.lumia.wallpaper.listener.RequestFinishListener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author lumia
 * @description
 * @date 2019/5/31 21:03
 */
public class HttpUtil {

    /**
     * 获取图片地址
     * @param address
     * @param listener
     */
    public static void doGet(String address, RequestFinishListener listener){
        new Thread(() -> {
            HttpURLConnection connection = null;
            InputStream in;
            BufferedReader reader;
            StringBuffer result = new StringBuffer();
            try {
                URL url = new URL(address);
                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(3000);
                connection.connect();
                in = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null){
                    result.append(line);
                }
                WallPaperUrl wallPaperUrl = JSON.parseObject(result.toString(), WallPaperUrl.class);
                if (listener != null){
                    listener.finish(wallPaperUrl);
                }
                reader.close();
                in.close();
            } catch (Exception e) {
                listener.error(e);
            }finally {
                if (connection != null){
                    connection.disconnect();
                }
            }
        }).start();
    }

    /**
     * 下载并应图片
     * @param address
     * @param dir
     * @param name
     * @param listener
     */
    public static void downloadPicture(String address, String dir, String name, DownloadFinishListener listener){
        new Thread(() -> {
            HttpURLConnection connection = null;
            FileOutputStream fos;
            InputStream in;
            File picFile = null;
            try {
                picFile = new File(dir + "\\" + name);
                if (picFile.exists()){
                    picFile.delete();
                }
                fos = new FileOutputStream(picFile);
                URL url = new URL(address);
                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(3000);
                connection.connect();
                in = connection.getInputStream();
                int len;
                byte[] buffer = new byte[1024];
                while ((len = in.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }
                listener.finish();
                fos.close();
                in.close();
            }catch (Exception e){
                if (picFile != null){
                    picFile.delete();
                }
                listener.error(e);
            }finally {
                if (connection != null){
                    connection.disconnect();
                }
            }
        }).start();
    }
}
