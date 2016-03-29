package com.estsoft.bookshop.dao;

import java.util.List;
import java.util.Scanner;

import com.estsoft.bookshop.vo.BookVo;

public class BookShop {
public static void main(String[] args){

	
	Scanner scanner = new Scanner(System.in);
	System.out.println("�뿩�� å��ȣ�� �Է��Ͻÿ�");
	int no = scanner.nextInt();
	
	BookVo bookVo = new BookVo();
	bookVo.setNo((long)no);
	bookVo.setState("rent");
	new BookDao().updateState(bookVo);
	
	scanner.close();
	printBookList();
}
public static void printBookList(){
	BookDao bookDAO = new BookDao();
	List<BookVo> list = bookDAO.getList();
	System.out.println("*****���� ���� ����ϱ�*****");
	for(BookVo bookVo : list){
		System.out.println("å ����:"+bookVo.getTitle()+", �۰�:"+bookVo.getAuthorName()+", �뿩 ����:"+bookVo.getState());
	}
}
}
