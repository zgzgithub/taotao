package com.taotao.service;

import com.taotao.portal.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
