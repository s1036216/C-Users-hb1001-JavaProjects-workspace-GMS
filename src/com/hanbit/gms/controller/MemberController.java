package com.hanbit.gms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;
import com.hanbit.gms.serviceImpl.MemberDAOIml;
import com.hanbit.gms.serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		
		MemberBean bean=null;
		List<MemberBean> temp =new ArrayList<MemberBean>();
		Butt[] buttons ={Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(
					null,//frame
					"MEMBER ADMIN", // frame title
					"SELECT MENU",  //order
					JOptionPane.QUESTION_MESSAGE,//type
					null, // icon
					buttons,//	Array of choices
					buttons[1] //default
					))	{
			case EXIT:
				return;
			case ADD:
				bean=new MemberBean();
				String[] arr=JOptionPane.showInputDialog("ID/NAME/PASSWOD/SSN").split("/");
				bean.setId(arr[0]);
				bean.setName(arr[1]);
				bean.setPassword(arr[2]);
				bean.setSsn(arr[3]);
				MemberServiceImpl.getInstance().addMember(bean);
				JOptionPane.showMessageDialog(null,"가입완료");
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null,MemberServiceImpl.getInstance().list());
				break flag;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null,MemberServiceImpl.getInstance().findByName(JOptionPane.showInputDialog("NAME")));
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null,MemberServiceImpl.getInstance().findById(JOptionPane.showInputDialog("ID")).toString());
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null,MemberServiceImpl.getInstance().count());
				break flag;
			case UPDATE:
				bean=new MemberBean();
				String id=JOptionPane.showInputDialog("ID");
				bean.setId(id);
				String pw=JOptionPane.showInputDialog("바뀔pw");
				bean.setPassword(pw);
				MemberServiceImpl.getInstance().modify(bean);
				JOptionPane.showMessageDialog(null,"성공");
				break flag;
			case DEL:
				MemberServiceImpl.getInstance().remove(JOptionPane.showInputDialog("삭제할ID"));
				JOptionPane.showMessageDialog(null,"삭제완료");
				break flag;
			
			}
		}while(true);
	}
}
