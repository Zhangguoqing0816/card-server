package com.card.zh.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.card.zh.entity.Temp;
import com.card.zh.service.ITempService;
import com.card.zh.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "getAll", notes = "all")
    @GetMapping("getAllTemp")
    public String getAllTemp(){
        Wrapper<Temp> wrapper = new EntityWrapper<>();
        List<Temp> temps = iTempService.selectList(wrapper);
        Result<List<Temp>> listResult = new Result<>("1", temps);
        String string = (String) JSON.toJSON(listResult);
        return string;
//        return temps.toString();
    }
}
