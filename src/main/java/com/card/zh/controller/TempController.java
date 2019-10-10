package com.card.zh.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.card.zh.entity.Temp;
import com.card.zh.service.ITempService;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 16:20
 */
@RestController
@RequestMapping("temp")
@Api(value = "temp", description = "Temp")
public class TempController {
    @Autowired
    private ITempService iTempService;

    private static final Logger Log = LoggerFactory.getLogger(TempController.class);


    @ApiOperation(value = "getAll", notes = "all")
    @GetMapping("getAllTemp")
    public String getAllTemp1() {
        Wrapper<Temp> wrapper = new EntityWrapper<>();
        List<Temp> temps = iTempService.selectList(wrapper);
        return new ResultData<List<Temp>>().assembleJsonInfo("1", "成功", temps);
    }

    @ApiOperation(value = "根据条件获取", notes = "根据条件获取")
    @GetMapping("getTempBy")
    public String getTempBy() {
        Wrapper<Temp> wrapper = new EntityWrapper<>();
        wrapper.eq("zhang_gq", "5");
        List<Temp> temps = iTempService.selectList(wrapper);
        return new ResultData<List<Temp>>().assembleJsonInfo("1", "成功", temps);
    }

    @ApiOperation(value = "getErr", notes = "错误返回演示")
    @GetMapping("getErr")
    public String getErr() {
        try {
            int x = 1 / 0;
            return new ResultData<List<Temp>>().assembleJsonInfo("1", "成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData<List<Temp>>().assembleJsonInfo("0", "失败", null);
        }
    }

    @ApiOperation(value = "getToXml", notes = "getToXml")
    @GetMapping("getToXml")
    public String getToXml() {
        Temp temp = iTempService.queryBy("6");
        return new ResultData<Temp>().assembleJsonInfo("1", "成功", temp);
    }
}
