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

    @Value("${file.download.dirPath}")
    private String downloadPath;

    @Value("${nginx.attach.port}")
    private String nginxAttachPort;

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
        OutputStream out = null;
        InputStream inputStream = null;
        File requestFile = new File(inFile.getOriginalFilename());
        String fileName = requestFile.getName();
        logger.info("开始上传文件：" + fileName);
        try {
            inputStream = inFile.getInputStream();
            File file = new File(uploadPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            String path = uploadPath + "/" + fileName;
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
            //保存附件信息到数据库
            Attach attach = new Attach();
            attach.setAttachName(inFile.getName());
            attach.setAttachType(fileName.substring(fileName.lastIndexOf(".")));
            attach.setAttachUrl(request.getRemoteAddr() + ":" + nginxAttachPort + "/upload/" + fileName);
            attach.setId(genSeqNo("file-", 5));
            attachService.insert(attach);
            return ResultData.success();
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
