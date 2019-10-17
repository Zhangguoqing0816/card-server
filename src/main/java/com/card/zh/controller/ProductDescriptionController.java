package com.card.zh.controller;

import com.card.zh.entity.ProductDescription;
import com.card.zh.entity.UserInfo;
import com.card.zh.model.request.ProductDescriptionRequest;
import com.card.zh.service.ProductDescriptionService;
import com.card.zh.service.UserInfoService;
import com.card.zh.util.BeanUtil;
import com.card.zh.util.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/17 15:15
 */
@RestController
@RequestMapping("/productDescription")
@Api(value = "产品简介", description = "产品简介")
public class ProductDescriptionController {
    @Autowired
    private ProductDescriptionService productDescriptionService;

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "新增产品简介信息", notes = "新增产品简介信息")
    @PostMapping("/addPro")
    public ResultData addPro(@RequestBody ProductDescriptionRequest request) {
        UserInfo userInfo = userInfoService.selectById(request.getUserInfoId());
        if (Objects.isNull(userInfo)) {
            return ResultData.error("操作失败，没有查到用户的账号");
        }
        ProductDescription productDescription = new ProductDescription();
        BeanUtil.copyProperties(request, productDescription);
        productDescriptionService.insert(productDescription);
        return ResultData.success();
    }
}
