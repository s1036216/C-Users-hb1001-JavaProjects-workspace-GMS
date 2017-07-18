package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;
import com.hanbit.gms.serviceImpl.ArticleServiceImpl;

public class BoardController {
		public static void main(String[] args) {
	
		ArticleBean bean=null;	
			Butt[] buttons ={Butt.EXIT,Butt.WRITE,Butt.LIST,Butt.FIND_SEQ,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
			do{ 
			switch((Butt)JOptionPane.showInputDialog(
					null,//frame
					"Article Board", // frame title
					"SELECT MENU",  //order
					JOptionPane.QUESTION_MESSAGE,//type
					null, // icon
					buttons,//	Array of choices
					buttons[1] //default
					))	{
			case EXIT:return;
			case WRITE:
				bean=new ArticleBean();	
				bean.setId(JOptionPane.showInputDialog("아이디"));
				bean.setTitle(JOptionPane.showInputDialog("제목"));
				bean.setContent(JOptionPane.showInputDialog("내용"));
				ArticleServiceImpl.getInstance().writeBoard(bean);
				JOptionPane.showMessageDialog(null,"작성완료");
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().listAll());
				break;
			case FIND_SEQ:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().findBySeq(Integer.parseInt(JOptionPane.showInputDialog("찾으실 seqNo 입력"))).toString());
				break;
				case FIND_ID:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().findById(JOptionPane.showInputDialog("NAME")));
				break;	
			case COUNT:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().countArticles());
				break;
			case UPDATE:
				bean= new ArticleBean();
				bean.setArtcilsSeq(Integer.parseInt(JOptionPane.showInputDialog("update할 seq를 입력하세요")));
				bean.setTitle(JOptionPane.showInputDialog("변경할 제목 입력"));
				bean.setContent(JOptionPane.showInputDialog("새로운 내용 입력"));
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().updateBoard(bean));
				break;
			case DEL:
						
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().deleteBoard(Integer.parseInt(JOptionPane.showInputDialog("seq"))));
				break;
			
			default:
				
				
				
			}
			}
		while(true);
			
		}
		}

		