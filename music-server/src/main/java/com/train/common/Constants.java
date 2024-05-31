package com.train.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

@Slf4j
public class Constants {
    /* 歌曲图片，歌手图片，歌曲文件，歌单图片等文件的存放路径 */
    public static String PROJECT_PATH;

    static {
        try {
            PROJECT_PATH = new File(ResourceUtils.getURL("classpath:static").getPath()).getPath();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* 盐值加密 */
    public static String SALT = "salt";

    public static void main(String[] args) throws FileNotFoundException {
         File path = new File(ResourceUtils.getURL("classpath:static").getPath());
         System.out.println("path = " + path);

        // System.out.println(AVATOR_IMAGES_PATH);

//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // ClassLoader classLoader = Constants.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("static");//resources/static
        // URL resourceUrl = classLoader.getResource("");//resources/
        String path2 = resourceUrl.getPath();
        System.out.println("path = " + path2);

        System.out.println(System.getProperty("file.separator"));
    }
}
