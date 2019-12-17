package cn.itcast.order.controller;


import cn.itcast.order.entity.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
//    注入discoveryclient：
//    调用方法获取服务的元数据信息
    @Autowired
    private DiscoveryClient discoveryClient;


//    注入restTemplate对象
    @Autowired
    private RestTemplate restTemplate;


//    基于ribbon的形式调用远程微服务

//    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
//    public Product findById(@PathVariable long id){
//        Product product = null;
//        product = restTemplate.getForObject("http://service-product/product/1", Product.class);
//        return product;
//    }
@RequestMapping(value="/buy/{id}",method = RequestMethod.GET)
public Product findById(@PathVariable Long id) {
    Product product = null;
    product = restTemplate.getForObject("http://service-product/product/1",Product.class);
    return product;
}

    /**
     * 参数：商品id
     * 通过订单系统，调用商品服务，根据id查询商品信息
     * 需要配置商品对象
     * 需要调用商品服务
     * 使用java中的urlconnection，httpclient，okhttp
     * 也可以用spring提供的RestTemplate
     */
//    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
//    public Product findById(@PathVariable long id){
//
//        //      已调用服务名称获取所有的元数据
//        final List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//
////        for (ServiceInstance instance:instances) {
////            System.out.println(instance);
////        }
////        获取唯一的一个元数据
//        final ServiceInstance serviceInstance = instances.get(0);
//
//        Product product = null;
////    如何调用商品服务
//
//       product = restTemplate.getForObject("http://" + serviceInstance.getHost()+":" + serviceInstance.getPort()+"/product/1", Product.class);
//
//        return product;
//    }
}
