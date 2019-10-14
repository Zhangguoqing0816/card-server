package com.card.zh.util;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class FileUtil {

    /**
     * 读取文件内容
     * @param path
     * @return
     */
    public static String readFile(String path){
        String result = new String();
        File file = new File(path);
        result = readFile(file);
        return result;
    }


    public static String readFile(File file){
        String result = new String();
        if (file.exists()) {
            LineIterator it = null;
            try {
                it = FileUtils.lineIterator(file, "utf-8");
                while (it.hasNext()) {
                    String line = it.nextLine();
                    result += line;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LineIterator.closeQuietly(it);
            }
        } else {
            System.out.println("文件不存在：" + file.getPath());
        }
        return result;
    }


    /**
     * 读取文件内容
     * @param fileName
     * @return
     */
    public static String readFileByLines(String fileName) {
        String result = new String();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                result += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return result;
    }

    /**
     * 文件的下载
     * @param response
     * @param file
     */
    public static void download(HttpServletResponse response,
                                File file){
        response.setCharacterEncoding("GBK");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
        ServletOutputStream out;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            out = response.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[1024];
            while (b != -1) {
                b = inputStream.read(buffer);
                out.write(buffer, 0, b);
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证文件路径是否存在
     * @param path
     * @return
     */
    public static boolean checkPath(String path){
        File file = new File(path);
        if(!file.exists()){
            return false;
        }
        return true;
    }

    /**
     * 获取文件
     * @param filePath
     * @return
     */
    public static File getFile(String filePath){
        File file = new File(filePath);
        if(checkPath(filePath)){
           if(!file.isDirectory()){
               System.out.println(file.getName());
               return file;
           }
        }
        return null;
    }

    /**
     * 获取路径中的所有文件
     * @param path
     * @param urls
     */
    public static void getFile(String path, List<String> urls) {
        // File对象 可以是文件或者目录
        File file = new File(path);
        if (file.isDirectory()) {
            File[] array = file.listFiles();
            for (int i = 0; i < array.length; i++) {
                if (array[i].isFile()) {
                    System.out.println("*****" + array[i].getPath());
                    urls.add(array[i].getPath());
                } else if (array[i].isDirectory()) {
                    getFile(array[i].getPath(), urls);
                }
            }
        } else {
            urls.add(path);
        }
    }

    /**
     * 文件转化为 byte 数组
     *
     * @param imgPath
     * @return
     */
    public static byte[] fileToByte1(String imgPath) {
        byte[] bytes = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            BufferedImage bi = ImageIO.read(new File(imgPath));
            ImageIO.write(bi, "png", out);
            bytes = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    /**
     * 文件转化为 byte 数组
     *
     * @param filePath
     * @return
     */
    public static byte[] fileToByte(String filePath) {
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bytes = new byte[1024];
            int size = 0;
            while ((size = bufferedInputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, size);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] content = byteArrayOutputStream.toByteArray();
        return content;
    }

    /**
     * byte 数组 转为 文件并生成
     *
     * @param bytes
     */
    public static void ByteToFile(byte[] bytes) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        try {
            File file = new File("G:\\haha.png");
            BufferedImage bi = ImageIO.read(bis);
            ImageIO.write(bi, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
