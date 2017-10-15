package com.taotao.service;

import com.taotao.pojo.TbItem;

public interface ItemService {
    /**
     * 根据ID查询商品订单查询
     */
    TbItem getItemById(long itemId);
}
