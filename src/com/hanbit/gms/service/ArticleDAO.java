package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;

public interface ArticleDAO {
	public String insert(ArticleBean bean);
	public List<ArticleBean> list();
	public List<ArticleBean> findId(String id);//fk리턴값여러게
	public ArticleBean findSeq(int seq);//pk 프라이머리키 는 리턴값 한게
	public String count();
	public String modify(ArticleBean bean);
	public String remove(int seq);
}
