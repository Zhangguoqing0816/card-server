package com.card.zh.controller;

import com.card.zh.entity.UserInfo;
import com.card.zh.service.UserInfoService;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/11 9:46
 */
@RestController
@RequestMapping("userInfo/")
@Api(value = "人员管理", description = "人员管理")
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;


    private String path = "C:\\Users\\zhiwang\\Desktop\\pic.png";

    public static void main(String[] args) {
        byte[] bytes = fileToByte("C:\\Users\\zhiwang\\Desktop\\pic.png");
        ByteToFile(bytes);
    }

    public static byte[] fileToByte(String imgPath) {
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

    @ApiOperation(value = "addUser", notes = "addUser")
    @PostMapping("/addUser")
    public String add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(genSeqNo("U", 5));
        userInfo.setQqQrCode(fileToByte(path));
        userInfoService.insert(userInfo);
        return new ResultData<String>().assembleJsonInfo(0, "插入成功", null);
    }

    @ApiOperation(value = "getUsers", notes = "getUsers")
    @PostMapping("/getUsers")
    public String getUser() {
        List<UserInfo> users = userInfoService.getUsers();
        return new ResultData<List<UserInfo>>().assembleJsonInfo(0, "search成功", users);
    }

    @ApiOperation(value = "getUsersExcludeBlob", notes = "getUsersExcludeBlob")
    @PostMapping("/getUsersExcludeBlob")
    public String getUsersExcludeBlob() {
        List<UserInfo> users = userInfoService.getUsersExcluseBlob();
        return new ResultData<List<UserInfo>>().assembleJsonInfo(0, "search成功", users);
    }

}
