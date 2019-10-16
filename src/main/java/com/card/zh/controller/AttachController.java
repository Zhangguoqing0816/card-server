package com.card.zh.controller;

import com.card.zh.entity.Attach;
import com.card.zh.service.AttachService;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/14 14:14
 */
@RestController
@RequestMapping("/attachManage")
@Api(value = "附件", description = "附件")
public class AttachController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(AttachController.class);

    @Value("${file.upload.dirPath}")
    private String uploadPath;


    @Value("${nginx.attach.address}")
    private String nginxAttachAddress;

    @Autowired
    private AttachService attachService;

    @ApiOperation(value = "add", notes = "add")
    @PostMapping("/add")
    public void add() {
        Attach attach = new Attach();
        attach.setId(genSeqNo("file-", 5));
        attachService.insert(attach);
    }

    /**
     * 上传文件
     *
     * @param inFile
     * @param request
     * @return
     */
    @ApiOperation(value = "上传附件", notes = "上传附件")
    @PostMapping("/uploadFile")
    public ResultData uploadFile(@RequestBody MultipartFile inFile, HttpServletRequest request) {
        if (inFile.isEmpty()) {
            return ResultData.error();
        }

        File requestFile = new File(inFile.getOriginalFilename());
        String realFileName = requestFile.getName();
        Attach attach = new Attach();
        attach.setId(genSeqNo("file-", 5));
        attach.setAttachName(realFileName);
        attach.setAttachType(realFileName.substring(realFileName.lastIndexOf(".")));

        OutputStream out = null;
        InputStream inputStream = null;
        logger.info("开始上传文件：" + realFileName);
        try {
            inputStream = inFile.getInputStream();
            File file = new File(uploadPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            String newFileName = attach.getId() + attach.getAttachType();
            String path = uploadPath + "/" + newFileName;
            logger.info("文件上传的路径是：" + path);
            File outFile = new File(path);
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            out = new FileOutputStream(outFile);
            byte[] bytes = new byte[1024];
            int size;
            while ((size = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, size);
            }
            attach.setAttachUrl(nginxAttachAddress + "/upload/" + newFileName);
            //保存附件信息到数据库
            attachService.insert(attach);
            return ResultData.success("上传成功", attach.getId());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultData.error(e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
