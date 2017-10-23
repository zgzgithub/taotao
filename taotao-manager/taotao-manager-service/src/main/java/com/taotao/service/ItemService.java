package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
    /**
     * 根据ID查询商品订单查询
     */
    TbItem getItemById(long itemId);

    EUDataGridResult getItemList(int page,int rows);

    TaotaoResult createItem(TbItem item,String desc)throws Exception;
}
