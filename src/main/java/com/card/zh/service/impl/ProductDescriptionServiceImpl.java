package com.card.zh.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.card.zh.entity.ProductDescription;
import com.card.zh.mapper.ProductDescriptionMapper;
import com.card.zh.service.ProductDescriptionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhanggq
 * @since 2019-10-17
 */
@Service
public class ProductDescriptionServiceImpl extends ServiceImpl<ProductDescriptionMapper, ProductDescription> implements ProductDescriptionService {

}
