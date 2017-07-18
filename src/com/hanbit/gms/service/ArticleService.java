package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;


public interface ArticleService {
	public String writeBoard(ArticleBean bean);
	public String countArticles();
	public List<ArticleBean> listAll();
	public ArticleBean findBySeq(int seq);
	public List<ArticleBean> findById(String id);
	
	public String deleteBoard(int seq);
	public String updateBoard(ArticleBean bean);
}
