package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    @ResponseBody
    public TbItem getItemById(@PathVariable("itemId") long itemId){

        return itemService.getItemById(itemId);

    }

    @RequestMapping(value = "/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows){
        return itemService.getItemList(page,rows);
    }

    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem item,String desc){
        TaotaoResult result = null;
        try {
            result = itemService.createItem(item,desc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
