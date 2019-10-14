package com.card.zh.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:
 * @Description: 二维码 生成和解析
 * @Date: 2019/10/14 14:05
 */
public class QRCodeUtil {
    private static final String QR_CODE_IMAGE_PATH = "G:/MyQRCode.png";

    /**
     * 生成图片
     *
     * @param text     生成二维码的内容
     * @param width    二维码宽度
     * @param height   二维码高度
     * @param filePath 生成图片的保存路径
     */
    private static boolean generateQRCodeImage(String text, int width, int height, String filePath) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 生成字节数组
     *
     * @param text   生成二维码的内容
     * @param width  二维码宽度
     * @param height 二维码高度
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    /**
     * 解析二维码
     *
     * @param filePath 二维码的位置
     * @return
     */
    public static String decodeQrCode(String filePath) {
        String qrCodeContent = null;
        try {
            BufferedImage read = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(read);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
            qrCodeContent = result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qrCodeContent;
    }


    public static void main(String[] args) {
        boolean b = generateQRCodeImage("我叫张国庆", 350, 350, QR_CODE_IMAGE_PATH);
    }
}
