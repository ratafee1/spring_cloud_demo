package cn.itcast.product.controller;

import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable long id){
        Product product = productService.findBId(id);
        product.setProductName("访问的服务地址"+ip+ ":"+port);
        return product;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Product product){
         productService.save( product);
         return "保存成功";

    }
}
