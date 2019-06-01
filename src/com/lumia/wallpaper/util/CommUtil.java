package com.lumia.wallpaper.util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lumia
 * @description  日志
 * @date 2019/5/31 21:36
 */
public class CommUtil {

    /**
     * 日志保存
     * @param message
     */
    public static void saveLog(String message) {
        FileWriter fileWriter = null;
        try {
            LocalDateTime now = LocalDateTime.now();
            File saveDir = new File("D:\\Pictures\\lovewallpaper\\logs");
            if (!saveDir.exists()){
                saveDir.mkdirs();  //多级创建目录
            }
            File logFile = new File("D:\\Pictures\\lovewallpaper\\logs\\download.log");
            if (!logFile.exists()){
                logFile.createNewFile(); //创建日志文件
            }

            fileWriter = new FileWriter(logFile, true);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String datetime = now.format(timeFormatter);
            String log = "时间：" + datetime + "," + message;
            fileWriter.write(log);
            fileWriter.write(System.lineSeparator());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
