package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * @author zgz
 */
public interface ItemCatService {

    List<EUTreeNode> getCatList(long parentId);
}
