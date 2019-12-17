package cn.itcast.product.service;

import cn.itcast.product.entity.Product;

public interface ProductService {
    /**
     * 根据id查询

     * 保存
     * 更新
     * 删除
     */
    Product findBId(Long id);

    void save(Product product);

    void  update(Product product);

    void delete(Long id);
}
