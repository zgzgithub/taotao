package com.taotao.service;

import java.util.List;

import com.taotao.pojo.TbContent;

public interface ContentService {

	List<TbContent> getContentList(long contentCid);
}
